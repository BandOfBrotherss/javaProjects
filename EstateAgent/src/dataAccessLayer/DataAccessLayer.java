/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/
package dataAccessLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import domain.EstateAgent;
import domain.House;

public class DataAccessLayer {
	EstateAgent estateAgent;
	String readPath, writePath;
	private String id, air_conditioner;
	private Integer price;
	private int rooms, bathrooms, size;
	Scanner sc;
	String firstline;
	PrintWriter printWriter;

	public DataAccessLayer(EstateAgent estateAgent, String readPath, String writePath) {
		this.estateAgent = estateAgent;
		this.readPath = readPath;
		this.writePath = writePath;
	}

	public String readFirstLine() {

		try {
			sc = new Scanner(new File(readPath));
		} catch (FileNotFoundException e) {
			System.out.println("File doesn not exist!");
		}

		return sc.nextLine();
	}

	public void readAll() {
		House house;

		firstline = readFirstLine();

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] infos_for_house = line.split(",");

			id = infos_for_house[0];
			price = Integer.valueOf(infos_for_house[1]);
			size = Integer.valueOf(infos_for_house[2]);
			rooms = Integer.valueOf(infos_for_house[3]);
			bathrooms = Integer.valueOf(infos_for_house[4]);
			air_conditioner = infos_for_house[5];
			house = new House(id, price, size, rooms, bathrooms, air_conditioner);

			estateAgent.addHouse(house);

		}
		sc.close();

	}

	public void save() throws FileNotFoundException {
		printWriter = new PrintWriter(new FileOutputStream(writePath));
		printWriter.println(firstline);
		String line;
		for (House house : estateAgent.getHouses()) {
			line = house.getID() + ", " + house.getPrice() + ", " + house.getSize() + house.getNumber_of_rooms() + ", "
					+ house.getNumber_of_bathrooms() + ", " + house.getAirConditioner();

			printWriter.println(line);
		}
		printWriter.close();

	}

}