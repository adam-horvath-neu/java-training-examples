package hu.training.thread.cyclicbarrier;

import java.time.LocalDateTime;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import hu.training.thread.utils.FormatUtils;

/**
 * Custom {@link Runnable} implementation to demonstrate how to use
 * a {@link CyclicBarrier} to make a threads wait at a given synchronization point
 * in code.
 *
 * This implementation will acquire an instance of {@link CyclicBarrier} through
 * its constructor.
 */
public class Party implements Runnable {

    /**
     * How much a {@link Party} thread should sleep after it has started.
     *
     * Tip: avoid the use of 'magic numbers' in your code.
     * Magic number is a number type literal somewhere in your code typically
     * given as a parameter to a method. Like {@link Thread#sleep}.
     *
     * I could just do {@code Thread.sleep(3000)}, but instead I made a constant
     * from this number and assigned a name to it. Having a name will better convey
     * its purpose in your code.
     */
    private static final long SLEEP_INTERVAL = 3000;

    private String name;
    private CyclicBarrier barrier;

    /* Tip: making method parameters 'final' could be a good practice, as
     * we usually don't want a method to alter the value of a parameter during its
     * execution.
     */
    public Party(final String name, final CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.printf("[%s] Party '%s' is starting!%n", getNowAsString(), name);
        try {
            Thread.sleep(SLEEP_INTERVAL); // wait a bit, just for fun
            System.out.printf("[%s] Party '%s' will be awaiting...%n", getNowAsString(), name);
            barrier.await(); // waiting at the barrier for other threads
            System.out.printf("[%s] Party '%s' is resuming...%n", getNowAsString(), name);
        } catch (InterruptedException | BrokenBarrierException e) {
            System.err.println("An error occurred while executing Party!");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String getNowAsString() {
        return FormatUtils.date(LocalDateTime.now());
    }
}
