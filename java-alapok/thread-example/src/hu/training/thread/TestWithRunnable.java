package hu.training.thread;

public class TestWithRunnable {

	public static void main(String[] args) {
		new Thread(new MyRunnable()).start();
	}
	
	private static class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("Testing threads with a Runnable...");
			for (int i = 1; i <= 5; i++) {
				try {
					System.out.format("Waiting %s millisec.\n", i * 1000);
					Thread.sleep(i * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("End.");
		}
	}

}
