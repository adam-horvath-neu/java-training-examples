package hu.training.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    private static final long SLEEP_BETWEEN_THREAD_STARTS = 1000L;
    private static final short COUNT_DOWN_TIME = 5; // How many countdown threads should be create?

    public static void main(final String... args) {
        final CountDownLatch latch = new CountDownLatch(COUNT_DOWN_TIME);

        // Creating and starting bomb thread
        Thread bombThread = new Thread(new BigAssBomb(latch));
        bombThread.start();

        // Creating and starting countdown threads
        // The bomb thread will wait until all of these threads did their countdown
        for (short i = 0; i < COUNT_DOWN_TIME; i++) {
            Thread countDownThread = new Thread(new CountDown(latch));
            countDownThread.start();

            try {
                Thread.sleep(SLEEP_BETWEEN_THREAD_STARTS);
            } catch (InterruptedException e) {
                System.err.println("Error occurred during bomb detonation!");
                e.printStackTrace();
                System.exit(3);
            }
        }
    }
}
