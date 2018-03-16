

/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/


package domain;

import java.util.ArrayList;

public class Company {

	ArrayList<Cargo> cargoes_of_company = new ArrayList<Cargo>();

	ArrayList<Vehicle> vehicles_of_company = new ArrayList<Vehicle>();

	ArrayList<SenderCustomer> senders_of_company = new ArrayList<SenderCustomer>();

	public Company() {

	}

	public void sendCargo() {

	}

	public String checkAvaliableVehicles(Cargo cargo, String preffered_send_date, String type) {
		for (Vehicle vehicle : vehicles_of_company) {
			if (String.valueOf(vehicle.getTransportation_type()) == type) {
				String[] vehicle_day_month_year = vehicle.getDeparture_date().split("/");
				int departure_day_of_vehicle = Integer.valueOf(vehicle_day_month_year[0]); 
				
				String[] preffered_date_day_month_year = preffered_send_date.split("/");
				int preffered_send_day = Integer.valueOf(preffered_date_day_month_year[0]);
				int preffered_send_month=Integer.valueOf(preffered_date_day_month_year[1]);
				int preffered_send_year=Integer.valueOf(preffered_date_day_month_year[2]);

				if (preffered_send_day < departure_day_of_vehicle && cargo.getWeight() < vehicle.getUpper_weight()) {
					if (preffered_send_month<11 && preffered_send_year==2016) {
						return vehicle.getId();	
					}
					
					

				}

			}

		}
		return "false";
	}

	public boolean checkSender(String name) {
		for (SenderCustomer sender : senders_of_company) {
			if (name.intern() == sender.getName().intern()) {
				System.out.println("girdi isim");
				return true;
			}

		}
		return false;

	}

	public Double calculatePrice(Transportation_type type,Cargo cargo){
		Double air_ratio=5.0;
		Double road_ratio=3.5;
		Double rail_ratio=2.0;
		if (String.valueOf(type).intern()=="AIR") {
			return cargo.getWeight()*air_ratio;
			
		}
		else if (String.valueOf(type)=="ROAD") {
			return cargo.getWeight()*road_ratio;
			
		}
		else if (String.valueOf(type)=="RAIL") {
			return cargo.getWeight()*rail_ratio;
			
		}else{
			return 0.0;
		}
		
		
	}
	
	
	
	public ArrayList<Cargo> getCargoes_of_company() {
		return cargoes_of_company;
	}

	public void addCargoToCompany(Cargo cargo) {
		cargoes_of_company.add(cargo);
	}

	public ArrayList<Vehicle> getVechiles_of_company() {
		return vehicles_of_company;
	}

	public void addVechileToCompany(Vehicle vechile) {
		vehicles_of_company.add(vechile);

	}

	public ArrayList<SenderCustomer> getSenders_of_company() {
		return senders_of_company;
	}

	public void addSenderToCompany(SenderCustomer sender) {
		senders_of_company.add(sender);

	}

}