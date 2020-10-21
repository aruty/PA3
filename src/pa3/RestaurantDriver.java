package pa3;

import java.util.concurrent.Semaphore;

public class RestaurantDriver extends Thread {
	private Integer waitTime;
	private String restaurant;
	private String dish;
	private Semaphore semaphore;

	public RestaurantDriver(Integer waitTime, String restaurant, String dish, Semaphore semaphore) {
		this.waitTime = waitTime;
		this.restaurant = restaurant;
		this.dish = dish;
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			semaphore.acquire();
			System.out.println(TimestampUtil.getTimestampDiffFormatted() + " Waiting for " + dish + "to be ready");
			//semaphore.wait(1000 * waitTime);
			Thread.sleep(1000 * waitTime);
			System.out.println(TimestampUtil.getTimestampDiffFormatted() + " Picked up " + dish);

		} catch (InterruptedException e) {

		} finally {
			semaphore.release();
			System.out.println(TimestampUtil.getTimestampDiffFormatted() + " Order of " + dish + " delivered");
		}
	}
}