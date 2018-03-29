package hu.training.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {

	private static class Counter {
		private AtomicInteger c = new AtomicInteger(0);

		public void increment() {
			c.incrementAndGet();
		}

		public void decrement() {
			c.decrementAndGet();
		}

		public int value() {
			return c.get();
		}

	}

	public static void main(String[] args) {
		// Közösen használt számláló
		final Counter counter = new Counter();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					try {
						counter.increment();
						System.out.println(counter.value());
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					counter.decrement();
					System.out.println(counter.value());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		}).start();
	}

}
