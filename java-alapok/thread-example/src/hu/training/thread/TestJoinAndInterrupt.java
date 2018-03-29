package hu.training.thread;

public class TestJoinAndInterrupt {

	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}

	private static class MessageLoop implements Runnable {
		public void run() {
			final String[] messages = { "This is my first message. Wait to the next one.",
					"This is my second message. Wait to the next one.",
					"This is my thrird message. Wait to the next one.",
					"This is my forth message. Wait to the next one.",
					"This is my fifth message. Wait to the next one." };
			try {
				for (String message : messages) {
					Thread.sleep(4000);
					threadMessage(message);
				}
			} catch (InterruptedException e) {
				threadMessage("I wasn't done!");
			}
		}
	}

	public static void main(String args[]) throws InterruptedException {

		// K�sleltet�s - ennyit v�runk a megszak�t�ssal
		long patience = 2000;

		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread messageLoop = new Thread(new MessageLoop());
		messageLoop.start();

		threadMessage("Waiting for MessageLoop thread to finish");
		// Am�g a messageLoop sz�l �l
		while (messageLoop.isAlive()) {
			threadMessage("Still waiting...");
			// A f� v�grehajt�si sz�l v�rni fog 1 m�sodpercet, hogy a messageLoop befejez�dj�n.
			messageLoop.join(1000);
			if (((System.currentTimeMillis() - startTime) > patience) && messageLoop.isAlive()) {
				threadMessage("Tired of waiting!");
				messageLoop.interrupt();
				// Megv�rjuk, m�g t�nylegesen meghal a messageLoop sz�l
				messageLoop.join();
			}
		}
		threadMessage("Finally!");
	}
}
