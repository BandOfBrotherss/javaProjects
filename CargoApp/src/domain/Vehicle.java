/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/


package domain;

import java.util.ArrayList;

public class Vehicle {
	private String id;
	private String departure_date;
	private Transportation_type transportation_type;
	private ArrayList<Cargo> cargoes_in_vehicle = new ArrayList<Cargo>();
	private Double upper_weight;

	public Vehicle(String id, String departure_date, Transportation_type transportation_type, Double upper_weight) {
		setId(id);
		setDeparture_date(departure_date);
		setTransportation_type(transportation_type);
		setUpper_weight(upper_weight);

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}

	public Transportation_type getTransportation_type() {
		return transportation_type;
	}

	public void setTransportation_type(Transportation_type transportation_type) {
		this.transportation_type = transportation_type;
	}

	public ArrayList<Cargo> getCargoes_in_vechile() {
		return cargoes_in_vehicle;
	}

	public void setCargoes_in_vechile(Cargo cargo) {
		cargoes_in_vehicle.add(cargo);

	}

	public Double getUpper_weight() {
		return upper_weight;
	}

	public void setUpper_weight(Double upper_weight) {
		this.upper_weight = upper_weight;
	}
	public void reduceUpperWeight(Double cargo_weight){
		upper_weight -= cargo_weight;
	}
}