package hu.training.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // Met�dusszint�
public @interface Test {

	// Enged�lyezett-e a teszt
	public boolean enabled() default true;

}