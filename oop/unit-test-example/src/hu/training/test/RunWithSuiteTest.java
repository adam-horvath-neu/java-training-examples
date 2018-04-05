package hu.training.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CalculatorTest.class, AssertTests.class, JunitAnnotationsTest.class, RunWithParameterizedTest.class })
public class RunWithSuiteTest {

}
