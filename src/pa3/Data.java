package pa3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data{
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("address")
	@Expose
	private String address;
	@SerializedName("latitude")
	@Expose
	private double latitude;
	@SerializedName("longitude")
	@Expose
	private double longitude;
	@SerializedName("drivers")
	@Expose
	private int drivers;
	@SerializedName("menu")
	@Expose
	private String[] menu;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public void setDrivers(int drivers) {
		this.drivers = drivers;
	}
	public void setMenu(String[] menu) {
		this.menu = menu;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public int getDrivers() {
		return drivers;
	}
	public String[] getMenu() {
		return menu;
	}
	public double getDistance() {
		double lat = getLatitude();
		double lon = getLongitude();
		return getDistance(lat, lon);
	}
	public double getDistance(double lat, double lon) {
		        double delta = lon - longitude;
		        double dist = Math.sin(Math.toRadians(lat)) *
		Math.sin(Math.toRadians(latitude))
		                + Math.cos(Math.toRadians(lat)) *
		Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(delta));
		return dist;
	}
	
	
	
}