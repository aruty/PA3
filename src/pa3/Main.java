package pa3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static Restaurants restList;
	public static Map<String, Semaphore> nameMap;

	public static void main(String[] args) {
		System.out.println("What is the name of the file containing the restaurant information?");
		boolean done = false;
		while (done == false) {
			try {
				String inputFileName = reader.readLine();
				String file = inputFileName;

				// List<Data> restList = new ArrayList<>();
				Gson gson = new Gson();
				Type listType = new TypeToken<List<Data>>() {
				}.getType();
				restList = gson.fromJson(new FileReader(file), Restaurants.class);
				System.out.println(restList);
				done = true;
			} catch (FileNotFoundException e) {
				System.out.println("File cannot be found, please provide name of existing file");
			} catch (IllegalStateException c) {
				System.out.println("file contains wrong data types");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		HashMap<String, Semaphore> map = new HashMap<String, Semaphore>();
		List<Data> rests = restList.getData();
		// rests.get(0).getDrivers();
		for (int i = 0; i < rests.size(); i++) {
			int drivers = rests.get(i).getDrivers();
			String name = rests.get(i).getName();
			double distance = rests.get(i).getDistance();
			String[] menu = rests.get(i).getMenu();
			Restaurant r = new Restaurant(name, drivers, distance, menu);
			Semaphore sem = r.getSemaphore();
			map.put(name, sem);

		}
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("What is the name of the file containing the schedule information?");
		boolean finish = false;
		while (finish == false) {
			try {
				String inputFileName = reader.readLine();
				BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
				// Scanner s = new Scanner(new File(inputFileName));
				String line = reader.readLine();
				// while(s.hasNext()) {
				while (line != null) {
					list.add(line);
					String[] items = line.split(",");
					Integer waitTime = Integer.parseInt(items[0].trim());
					String restName = items[1].trim();
					String dish = items[2].trim();
					Semaphore sema = map.get(restName);
					new RestaurantDriver(waitTime, restName, dish, sema).start();
					line = reader.readLine();
				}
				finish = true;
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
