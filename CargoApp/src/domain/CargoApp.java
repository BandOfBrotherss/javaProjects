/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/


package domain;

import java.io.IOException;

import fileAccess.DataAccessLayer;
import presentation.CargoInfoMenu;

public class CargoApp {

	public static void main(String[] args) throws IOException {
		Company company = new Company();
		DataAccessLayer dataAccess = new DataAccessLayer();
		dataAccess.addVehicles(company);
		CargoInfoMenu cargoInfoMenu = new CargoInfoMenu();
		cargoInfoMenu.startGui(company);
	}

}


