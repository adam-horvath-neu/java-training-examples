package hu.training.thread;

public class SimpleThread {
	
	private static class MyRunnable implements Runnable {

		@Override
		public void run() {
			for (int i = 1; i < 5; i++) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static class MyThread extends Thread {

		@Override
		public void run() {
			for (int i = 5; i < 10; i++) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		new Thread(myRunnable).start();
		new Thread(myRunnable).start();
		System.out.println("Fõ szál");
		
		new MyThread().start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 10; i < 15; i++) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}