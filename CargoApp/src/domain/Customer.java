/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/



package domain;

import java.util.regex.Pattern;

public class Customer {
	private String id;
	private String name;
	private String phone_number;
	private String address;

	public Customer(String id, String name, String phone_number, String address) {
		setAddress(address);
		setId(id);
		setName(name);
		setPhone_number(phone_number);

	}
	
	public Customer(){}

	public String getId() {
		return id;
	}

	public boolean setId(String id) {
		if (Pattern.matches("[0-9]+", id)) {
			this.id = id;
			return true;
		} else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if (Pattern.matches("[ A-Za-z]+", name)) {
			this.name = name;
			return true;
		} else {
			return false;
		}
	}
	

	public String getPhone_number() {
		return phone_number;
	}

	public boolean setPhone_number(String phone_number) {
		if (Pattern.matches("[0-9]+", phone_number)) {
			this.phone_number = phone_number;
			return true;
		} else {
			return false;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}