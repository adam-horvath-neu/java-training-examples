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

		// @TesterInfo annotáció feldolgozása
		if (textExampleClass.isAnnotationPresent(TesterInfo.class)) {

			// Megvizsgáljuk a TestExample osztályon lévõ @TesterInfo annotációt
			Annotation annotation = textExampleClass.getAnnotation(TesterInfo.class);
			TesterInfo testerInfo = (TesterInfo) annotation;

			System.out.printf("%nPriority: %s", testerInfo.priority());
			System.out.printf("%nCreatedBy: %s", testerInfo.createdBy());
			System.out.printf("%nTags: ", Arrays.toString(testerInfo.tags()));
			System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());
		}
		
		// Létrehozunk egy új példányt a TestExample osztályból
		TestExample newInstance = textExampleClass.newInstance();

		// A TestExample osztály metódusainak vizsgálata
		for (Method method : textExampleClass.getDeclaredMethods()) {

			// Ha a metódus annotálva van a @Test annotációval
			if (method.isAnnotationPresent(Test.class)) {

				// Akkor megvizsgáljuk az adott annotációt
				Annotation annotation = method.getAnnotation(Test.class);
				Test test = (Test) annotation;

				// Ha engedélyezett (enabled == true)
				if (test.enabled()) {

					try {
						// Meghívjuk a metódust a fentebb létrehozott példányon
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
