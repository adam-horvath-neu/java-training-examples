package hu.training.test;

import hu.training.annotation.Test;
import hu.training.annotation.TesterInfo;
import hu.training.annotation.TesterInfo.Priority;

@TesterInfo(priority = Priority.HIGH, createdBy = "hu.training.Adam", tags = { "sales", "test" })
public class TestExample {

	@Test
	void testA() {
		if (true)
			throw new RuntimeException("This test always failed");
	}

	@Test(enabled = false)
	void testB() {
		if (false)
			throw new RuntimeException("This test always passed");
	}

	@Test(enabled = true)
	void testC() {
		if (10 > 1) {
			// do nothing, this test always passed.
		}
	}

}