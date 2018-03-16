

/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/


package presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import domain.Cargo;
import domain.Company;
import domain.Transportation_type;
import domain.Vehicle;

public class PriceMenu {
	public PriceMenu() {
	}

	public void showPriceMenu(Company company, Cargo cargo, String vehicleId,Transportation_type type) {
		JFrame frame = new JFrame("Price Validity");
		frame.setSize(300, 300);
		frame.getContentPane().setLayout(new BorderLayout());
		double price = company.calculatePrice(type, cargo);
		JLabel label = new JLabel("Cargo price is $ " + String.valueOf(price) + ". Do you verify it ?");

		JButton yes = new JButton("Yes");
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CustomerInfoMenu customerInfoMenu = new CustomerInfoMenu();
				cargo.setPrice(String.valueOf(price));
				addCargotoVehicle(company, cargo, vehicleId);
				
				customerInfoMenu.customerInfoMenu(company, cargo);
				frame.setVisible(false);
			}
		});
		JButton no = new JButton("No");
		no.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CargoInfoMenu cargoInfoMenu = new CargoInfoMenu();
				cargoInfoMenu.startGui(company);
				frame.setVisible(false);

			}
		});
		JPanel panel = new JPanel();

		panel.add(label);
		panel.add(yes);
		panel.add(no);

		frame.add(panel);
		frame.setVisible(true);

	}

	public void addCargotoVehicle(Company company, Cargo cargo, String vehicleID) {
		for (Vehicle vehicle : company.getVechiles_of_company()) {
			if (vehicleID.equals(vehicle.getId())) {
				vehicle.setCargoes_in_vechile(cargo);
				vehicle.reduceUpperWeight(cargo.getWeight());
				break;
			}
		}

	}
}