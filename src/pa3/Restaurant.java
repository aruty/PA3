package pa3;

import java.util.concurrent.Semaphore;

class Restaurant {
	private static int drivers;
	private static String name;
	private String[] menu;
	private double distance;
	private Semaphore semaphore;

	public Restaurant(String name, int drivers, double distance, String[] menu) {
		this.drivers = drivers;
		this.name = name;
		this.distance = distance;
		this.menu = menu;
		this.semaphore = new Semaphore(drivers);
	}

	//private static Semaphore semaphore = new Semaphore(drivers);

	public Semaphore getSemaphore() {
		return semaphore;
	}

	public String getRestName() {
		return name;
	}

	public Integer getRestDrivers() {
		return drivers;
	}

	public String[] getRestMenu() {
		return menu;
	}

	public double getDistance() {
		return distance;
	}
	/*
	 * public void run(){ try { Thread.sleep(1000); } catch (InterruptedException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */
}
