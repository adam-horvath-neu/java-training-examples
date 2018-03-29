package hu.training.thread;

public class TestWithExtendsThread {

	public static void main(String[] args) {
		new MyThread().start();;
	}
	
	private static class MyThread extends Thread {

		@Override
		public void run() {
			System.out.println("Testing threads with extending Thread...");
		}
		
	}

}
