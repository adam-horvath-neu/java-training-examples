package hu.training.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDown implements Runnable {
    private static final long SLEEP_BEFORE_COUNTDOWN = 1000L;

    private CountDownLatch countDownLatch;

    public CountDown(final CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(SLEEP_BEFORE_COUNTDOWN);
            System.out.println("Time until detonation: " + countDownLatch.getCount());
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            System.err.println("Something happened during countdown!");
            e.printStackTrace();
            System.exit(2);
        }
    }
}
