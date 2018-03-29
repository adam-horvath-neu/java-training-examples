package hu.training.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    private static final String PARTY_NAME_PREFIX = "Party";
    private static final short NUMBER_OF_PARTIES = 5;   // You can change this constant to play with the number of threads.
    private static final long WAIT_BETWEEN_THREAD_STARTS = 1000;

    public static void main(String[] args) {
        // Creating the barrier.
        final CyclicBarrier barrier = new CyclicBarrier(NUMBER_OF_PARTIES);

        // Dynamic thread creation.
        for (int i = 0; i < NUMBER_OF_PARTIES; i++) {
            final String partyName = PARTY_NAME_PREFIX + i;
            Thread partyThread = new Thread(new Party(partyName, barrier));
            partyThread.start();

            try {
                Thread.sleep(WAIT_BETWEEN_THREAD_STARTS); // wait a bit between new threads
            } catch (InterruptedException e) {
                System.err.println("Error occurred while starting Party thread!");
                e.printStackTrace();
                System.exit(2);
            }
        }
    }
}
