/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/



package fileAccess;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import domain.Company;
import domain.Transportation_type;
import domain.Vehicle;

public class DataAccessLayer {
	public DataAccessLayer() {
	}

	public void addVehicles(Company company) throws IOException {
		File file = new File("src/vehicles.dat");
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String vehicles_imp = sc.nextLine();
			String informations[] = vehicles_imp.split(", ");
			String vechicle_id = informations[0];
			String departure_time = informations[1];
			Transportation_type type = Transportation_type.valueOf(informations[2]);
			Double upper_weight = Double.valueOf(informations[3]);
			Vehicle vehicle = new Vehicle(vechicle_id, departure_time, type, upper_weight);
			company.addVechileToCompany(vehicle);
		}
		sc.close();

	}

}
