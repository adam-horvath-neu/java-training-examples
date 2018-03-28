package hu.training.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

import hu.training.annotation.Test;
import hu.training.annotation.TesterInfo;

public class TestExecutor {
	public static void main(String[] args) throws Exception {

		System.out.println("Testing...");

		int passed = 0, failed = 0, count = 0, ignore = 0;

		Class<TestExample> textExampleClass = TestExample.class;

		// @TesterInfo annot�ci� feldolgoz�sa
		if (textExampleClass.isAnnotationPresent(TesterInfo.class)) {

			// Megvizsg�ljuk a TestExample oszt�lyon l�v� @TesterInfo annot�ci�t
			Annotation annotation = textExampleClass.getAnnotation(TesterInfo.class);
			TesterInfo testerInfo = (TesterInfo) annotation;

			System.out.printf("%nPriority: %s", testerInfo.priority());
			System.out.printf("%nCreatedBy: %s", testerInfo.createdBy());
			System.out.printf("%nTags: ", Arrays.toString(testerInfo.tags()));
			System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());
		}
		
		// L�trehozunk egy �j p�ld�nyt a TestExample oszt�lyb�l
		TestExample newInstance = textExampleClass.newInstance();

		// A TestExample oszt�ly met�dusainak vizsg�lata
		for (Method method : textExampleClass.getDeclaredMethods()) {

			// Ha a met�dus annot�lva van a @Test annot�ci�val
			if (method.isAnnotationPresent(Test.class)) {

				// Akkor megvizsg�ljuk az adott annot�ci�t
				Annotation annotation = method.getAnnotation(Test.class);
				Test test = (Test) annotation;

				// Ha enged�lyezett (enabled == true)
				if (test.enabled()) {

					try {
						// Megh�vjuk a met�dust a fentebb l�trehozott p�ld�nyon
						method.invoke(newInstance);
						System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
						passed++;
					} catch (Throwable ex) {
						System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
						failed++;
					}

				} else {
					System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());
					ignore++;
				}

			}

		}
		System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);

	}
}
