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
import domain.ReceiverCustomer;
import domain.SenderCustomer;

public class CustomerInfoMenu {
	SenderCustomer sender;
	ReceiverCustomer receiver;

	public void customerInfoMenu(Company company, Cargo cargo) {
		JFrame frame = new JFrame("Customer Info");
		frame.setSize(250, 200);
		frame.getContentPane().setLayout(new BorderLayout());

		JLabel sender_name = new JLabel("Sender Name :");
		JTextField sender_nameText = new JTextField(15);

		JLabel receiver_name = new JLabel("Receiver Name:");
		JTextField receiver_nameText = new JTextField(15);

		JLabel who_pays = new JLabel("Who_will pay :");
		JComboBox<String> who_paysChoice = new JComboBox<String>();
		who_paysChoice.addItem("Sender");
		who_paysChoice.addItem("Receiver");

		JButton button = new JButton("Next");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				receiver = new ReceiverCustomer();
				String payer = who_paysChoice.getSelectedItem().toString();
				String senderName = sender_nameText.getText();
				boolean checkSender = company.checkSender(senderName);
				if (!checkSender) {
					String receiverName = receiver_nameText.getText();
					receiver.setName(receiverName);
					frame.setVisible(false);
					senderInfo(company, cargo, senderName, payer);
				} else {
					JOptionPane.showMessageDialog(frame, "We already know you "+ senderName );
					for (SenderCustomer sender : company.getSenders_of_company()) {
						if (senderName.equals(sender.getName())) {
							
							if (payer.equals("Sender")) {
								cargo.setPayer(sender);
							} else {
								cargo.setPayer(receiver);
							}
							
							
							cargo.setSender(sender);
							cargo.setReceiver(receiver);
							sender.addCargo(cargo);
							break;
							
						}
					}
					receiverInfo(company, cargo);
					frame.setVisible(false);
				
				}

			}
		});

		JPanel panel = new JPanel();
		panel.add(sender_name);
		panel.add(sender_nameText);

		panel.add(receiver_name);
		panel.add(receiver_nameText);

		panel.add(who_pays);
		panel.add(who_paysChoice);
		panel.add(button);

		frame.add(panel);
		frame.setVisible(true);

	}

	public void receiverInfo(Company company, Cargo cargo) {
		JFrame frame = new JFrame("Receiver Info");
		frame.setSize(250, 300);
		frame.getContentPane().setLayout(new BorderLayout());

		JLabel nationalId = new JLabel("Receiver ID :");
		JTextField nationalIdText = new JTextField(15);

		JLabel phoneNumber = new JLabel("Receiver Phone Number :");
		JTextField phoneNumberText = new JTextField(15);

		JLabel adress = new JLabel("Receiver Adress :");
		JTextArea adressText = new JTextArea(7, 16);

		JButton button = new JButton("Send Cargo");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = nationalIdText.getText();
				String phone_number = phoneNumberText.getText();
				String receiver_adress = adressText.getText();

				boolean checkId = receiver.setId(id);
				boolean checkPhoneNumber = receiver.setPhone_number(phone_number);
				if (!checkId || !checkPhoneNumber) {
					JOptionPane.showMessageDialog(frame, "Invalid input.Please correct it.");
					frame.setVisible(false);
					receiverInfo(company, cargo);
				} else {
					receiver.setAddress(receiver_adress);
					receiver.setCargo(cargo);
					company.addCargoToCompany(cargo);
					JOptionPane.showMessageDialog(frame, "Cargo successfully sent.");
					CargoInfoMenu new_cargo = new CargoInfoMenu();
					frame.setVisible(false);
					new_cargo.startGui(company);

				}
			}
		});
		JPanel panel = new JPanel();

		panel.add(nationalId);
		panel.add(nationalIdText);

		panel.add(phoneNumber);
		panel.add(phoneNumberText);

		panel.add(adress);
		panel.add(adressText);

		panel.add(button);

		frame.add(panel);
		frame.setVisible(true);
	}

	public void senderInfo(Company company, Cargo cargo, String name, String payer) {
		JFrame frame = new JFrame("Sender Info");
		frame.setSize(250, 300);
		frame.getContentPane().setLayout(new BorderLayout());

		JLabel nationalId = new JLabel("Sender ID :");
		JTextField nationalIdText = new JTextField(15);

		JLabel phoneNumber = new JLabel("Sender Phone Number :");
		JTextField phoneNumberText = new JTextField(15);

		JLabel adress = new JLabel("Sender Adress :");
		JTextArea adressText = new JTextArea(7, 17);

		JButton button = new JButton("Next");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sender = new SenderCustomer();

				sender.setName(name);

				String id = nationalIdText.getText();
				String phone_number = phoneNumberText.getText();
				String sender_adress = adressText.getText();

				boolean checkId = sender.setId(id);
				boolean checkPhoneNumber = sender.setPhone_number(phone_number);
				sender.setAddress(sender_adress);
				if (!checkId || !checkPhoneNumber) {
					JOptionPane.showMessageDialog(frame, "Invalid information.Please correct it.");
					frame.setVisible(false);
					senderInfo(company, cargo, name, payer);
				} else {
					sender.setAddress(sender_adress);
					cargo.setSender(sender);
					sender.addCargo(cargo);
					company.addSenderToCompany(sender);
					frame.setVisible(false);
					receiverInfo(company, cargo);

				}
			}
		});

		JPanel panel = new JPanel();

		panel.add(nationalId);
		panel.add(nationalIdText);

		panel.add(phoneNumber);
		panel.add(phoneNumberText);

		panel.add(adress);
		panel.add(adressText);

		panel.add(button);

		frame.add(panel);
		frame.setVisible(true);
	}

}
