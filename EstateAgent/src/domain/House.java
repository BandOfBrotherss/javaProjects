/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/
package domain;

public class House {
	String id;
	Integer price;
	int size;
	int number_of_rooms;
	int number_of_bathrooms;
	String air_conditioner;

	public House(String id, int price, int size, int number_of_rooms, int number_of_bathrooms, String air_conditioner) {
		setID(id);
		setPrice(price);
		setSize(size);
		setNumber_of_bathrooms(number_of_bathrooms);
		setNumber_of_rooms(number_of_rooms);
		setAirConditioner(air_conditioner);
		//System.out.println(toString());
	}
	
	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumber_of_rooms() {
		return number_of_rooms;
	}

	public void setNumber_of_rooms(int number_of_rooms) {
		this.number_of_rooms = number_of_rooms;
	}

	public int getNumber_of_bathrooms() {
		return number_of_bathrooms;
	}

	public void setNumber_of_bathrooms(int number_of_bathrooms) {
		this.number_of_bathrooms = number_of_bathrooms;
	}

	public String getAirConditioner() {
		return air_conditioner;
	}

	public void setAirConditioner(String air_conditioner) {
		this.air_conditioner = air_conditioner;
	}



	@Override
	public String toString() {
		return "[ id : " + getID() + " price : " + getPrice() + " size : " + getSize() + " # of rooms : "
				+ getNumber_of_rooms() + " # of bathrooms : " + getNumber_of_bathrooms() + " air conditioner : "
				+ getAirConditioner() + " ]";
	}

}