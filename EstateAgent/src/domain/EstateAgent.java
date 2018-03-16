/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/

package domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import dataAccessLayer.DataAccessLayer;
import presentation.EstateAgentGUI;

public class EstateAgent {
	ArrayList<House> houses = new ArrayList<House>();
	DataAccessLayer dal;
	EstateAgentGUI estateGui;

	public EstateAgent() throws FileNotFoundException {
		dal = new DataAccessLayer(this, "housing.txt", "housing_updated.txt");
		dal.readAll();

		estateGui = new EstateAgentGUI(this);
		estateGui.create();

	}

	public void orderAscendingPrice() {
		Collections.sort(houses, new PriceComparatorAscending());
	}

	public void orderDescendingPrice() {
		Collections.sort(houses, new PriceComparatorDescending());
	}

	public void orderByID() {
		Collections.sort(houses, new IdComparator());

	}

	public void removeHouse(String id) {
		Iterator<House> house_iterator = houses.iterator();
		House house;
		while (house_iterator.hasNext()) {
			house = house_iterator.next();
			if (house.getID().intern() == id.intern()) {
				house_iterator.remove();
				break;
			}

		}

	}

	public void addHouse(House house) {
		houses.add(house);
	}

	public ArrayList<House> searchWithSize(int min_size, int max_size) {
		ArrayList<House> houses_between_choosen_sizes = new ArrayList<House>();
		for (House house : houses) {
			if (min_size <= house.getSize() && max_size >= house.getSize()) {
				houses_between_choosen_sizes.add(house);
			}
		}
		return houses_between_choosen_sizes;

	}

	public ArrayList<House> searchWithPrice(Integer min_price, Integer max_price) {
		ArrayList<House> houses_between_choosen_prices = new ArrayList<House>();
		for (House house : houses) {
			if (min_price <= house.getPrice() && max_price >= house.getPrice()) {
				houses_between_choosen_prices.add(house);
			}
		}
		return houses_between_choosen_prices;

	}

	public ArrayList<House> searchHouseWithRoom(int room_number) {
		ArrayList<House> houses_with_choosen_room_number = new ArrayList<House>();
		for (House house : houses) {
			if (house.getNumber_of_rooms() == room_number) {
				houses_with_choosen_room_number.add(house);
			}

		}
		return houses_with_choosen_room_number;

	}

	public void save() throws FileNotFoundException {
		dal.save();

	}

	public ArrayList<House> getHouses() {
		return houses;
	}

}
