package hu.training;

import hu.training.exception.MyCheckedException;
import hu.training.exception.MyUncheckedException;

public class TestExceptions {

	private static class MyUncheckedExceptionTest {

		private int value = 0;

		public MyUncheckedExceptionTest(int positiveNumber) throws MyUncheckedException {
			if (positiveNumber < 0) {
				throw new MyUncheckedException("positiveNumber must be positive");
			}
			this.value = positiveNumber;
		}

		public int getValue() {
			return value;
		}
	}

	private static class MyCheckedExceptionTest {

		private int value = 0;

		public MyCheckedExceptionTest(int positiveNumber) throws MyCheckedException {
			if (positiveNumber < 0) {
				throw new MyCheckedException("positiveNumber must be positive");
			}
			this.value = positiveNumber;
		}

		public int getValue() {
			return value;
		}
	}

	public static void main(String[] args) {
		// Nem ellenõrzött kivétel
		try {
			MyUncheckedExceptionTest myUncheckedExceptionTest = new MyUncheckedExceptionTest(-10);
			System.out.println(myUncheckedExceptionTest.getValue());
		} catch (MyUncheckedException e) {
			System.out.println("Én erre számítottam...");
		}

		// Ellenõrzött kivétel
		try {
			MyCheckedExceptionTest myCheckedExceptionTest = new MyCheckedExceptionTest(-10);
			System.out.println(myCheckedExceptionTest.getValue());
		} catch (MyCheckedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
