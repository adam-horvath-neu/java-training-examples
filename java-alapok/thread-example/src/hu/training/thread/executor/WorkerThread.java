package hu.training.thread.executor;

import java.util.Random;

public class WorkerThread implements Runnable {

	private String command;

	public WorkerThread(String s) {
		this.command = s;
	}

	@Override
	public void run() {
		int wait = (new Random().nextInt(5) + 1) * 1000;
		System.out.println(Thread.currentThread().getName() + " Start. Command = " + command + ", wait: " + wait);
		processCommand(wait);
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	private void processCommand(int wait) {
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return this.command;
	}
}
