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

public class CargoInfoMenu {

	public CargoInfoMenu() {
	}

	public void startGui(Company company) {// Company i parametre
												// olarak al
		JFrame mainFrame = new JFrame("Cargo Company");
		mainFrame.setSize(250, 200);
		mainFrame.getContentPane().setLayout(new BorderLayout());

		JLabel date = new JLabel();
		date.setText("Date :");

		JTextField date_text = new JTextField(15);

		JLabel statusLabel = new JLabel();
		statusLabel.setText("Weight :");

		JTextField text_field = new JTextField(15);

		JComboBox<String> type = new JComboBox<String>();
		type.addItem("AIR");
		type.addItem("ROAD");
		type.addItem("RAIL");

		JLabel trans_type = new JLabel();
		trans_type.setText("Transportation Type :");

		JButton button = new JButton("Send Cargo ");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Cargo cargo = new Cargo();
				String weight = text_field.getText();
				String date = date_text.getText();
				String transportation_type = type.getSelectedItem().toString();
				boolean check = checkInfo(weight, date,cargo);
				if (check) {
					String check_vehicle = company.checkAvaliableVehicles(cargo, date, transportation_type);
					if (check_vehicle.equals("false")) {
						JOptionPane.showMessageDialog(mainFrame, "Sorry.No available " + transportation_type
								+ " type vehicle. Please change Transportation way.");
						mainFrame.setVisible(false);
						startGui(company);
					} else {
						cargo.setWeight(weight);
						cargo.setOrder_date(date);
						PriceMenu price_menu = new PriceMenu();
						price_menu.showPriceMenu(company, cargo, check_vehicle,
								Transportation_type.valueOf(transportation_type));
						mainFrame.setVisible(false);
					}

				} else {
					mainFrame.setVisible(false);
					startGui(company);
				}

			}
		});

		JPanel controlPanel = new JPanel();

		controlPanel.add(statusLabel);
		controlPanel.add(text_field);

		controlPanel.add(date);
		controlPanel.add(date_text);

		controlPanel.add(trans_type);
		controlPanel.add(type);

		controlPanel.add(button);

		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);

	}

	public boolean checkInfo(String weight, String date,Cargo cargo) {
		
		boolean weight_check = cargo.setWeight(weight);
		boolean date_check = cargo.setOrder_date(date);
		if (!date_check || !weight_check) {
			JFrame warning = new JFrame();
			warning.setSize(200, 150);
			warning.getContentPane().setLayout(new BorderLayout());
			if (!date_check && !weight_check) {
				JOptionPane.showMessageDialog(warning,
						"Date format is not right!(dd/MM/yyyy) and Enter a valid weight");
			} else if (!weight_check) {
				JOptionPane.showMessageDialog(warning, "Enter a valid weight");

			} else {
				JOptionPane.showMessageDialog(warning, "Date format is not right!(dd/MM/yyyy) or No available vehicle at that  time ");
			}
			return false;
		} else {
			return true;
		}

	}

}
