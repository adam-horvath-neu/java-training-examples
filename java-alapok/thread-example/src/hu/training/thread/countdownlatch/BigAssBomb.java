package hu.training.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * A custom implementation of {@link Runnable}.
 * This is a big-ass bomb waiting to be detonated.
 *
 * The bomb will wait for a {@link CountDownLatch} instance to reach
 * zero and then will detonate!
 *
 * The instance will be provided through the constructor.
 */
public class BigAssBomb implements Runnable {
    private CountDownLatch countDownLatch;

    public BigAssBomb(final CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Waiting for detonation...");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.err.println("Something went wrong! Somebody interrupted the detonation!");
            System.exit(1);
        }

        System.out.println("BOOM BABY!");
    }
}
