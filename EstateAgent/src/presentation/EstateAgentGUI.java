/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/
package presentation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import domain.EstateAgent;
import domain.House;

public class EstateAgentGUI implements ActionListener {
	JFrame appFrame;
	Container cPane, addCon, orderCon, removeCon, searchCon, rightMainCon;

	JLabel jlbPrice, jlbSize, jlbRooms, jlbBathRooms, jlbAirCnd, jlbIDRemove, jlbeMaxBound, jlbMinBound,
			jlbNumberofRooms;
	JTextField jtfPrice, jtfSize, jtfRooms, jtfBathRooms, jtfIDRemove, jtfMaxBound, jtfMinBound, jtfNumberofRooms;
	JTable table;
	JComboBox<String> jcomboAirCon;
	JPanel jpRight, jpLeft, jpSearch;
	JButton jbAddHouse, jbRemoveHouse, jbOrderHouse, jbSearchHouse, jBackAdd, jBackRemove, jBackOrder, jBackSearch,
			jbAdd, jbRemove, jbSearch;
	JRadioButton jrdAscending, jrdDescending;
	JCheckBox jchPrice, jchSize, jchRooms;
	CardLayout cardlayoutRightPanel;
	ButtonGroup orderGroup, searchGroup;

	DefaultTableModel tableModel;

	EstateAgent estateAgent;

	public EstateAgentGUI(EstateAgent estateAgent) {
		this.estateAgent = estateAgent;

		appFrame = new JFrame("Estate Agent");
		cPane = appFrame.getContentPane();
		createTextFields();
		createLabels();
		createButtons();
		createRadioButtons();
		createCheckboxes();
		createComboBox();

		createAddCon();
		createOrderCon();
		createRightMainCon();
		createRemoveCon();
		createSearchCon();

		arrangePanels();
		create();

	}

	public void create() {
		cPane.setLayout(new FlowLayout(FlowLayout.LEFT));

		appFrame.setSize(700, 500);
		appFrame.setResizable(false);
		appFrame.setVisible(true);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void arrangePanels() {
		arrangeLeftPanel();
		arrangeRightPanel();

		cPane.add(jpLeft);
		cPane.add(jpRight);

	}

	public void arrangeLeftPanel() {
		jpLeft = new JPanel(new BorderLayout());

		createTable();
		fillTable(estateAgent.getHouses());
		jpLeft.add(new JScrollPane(table));

	}

	public void arrangeRightPanel() {
		cardlayoutRightPanel = new CardLayout();
		jpRight = new JPanel(cardlayoutRightPanel);

		jpRight.add(rightMainCon);
		jpRight.add(addCon, "Add Container");
		jpRight.add(orderCon, "Order Container");
		jpRight.add(removeCon, "Remove Container");
		jpRight.add(searchCon, "Search Container");

	}

	public void createTable() {
		String[] col = { " ID ", "Price", "Size", "Rooms", "Bathrooms", "Aircn" };
		tableModel = new DefaultTableModel(col, 0);

		table = new JTable(tableModel);

	}

	public void createLabels() {
		jlbPrice = new JLabel("Price :");
		jlbRooms = new JLabel("Number of Rooms :");
		jlbBathRooms = new JLabel("Number of Bathrooms :");
		jlbSize = new JLabel("Size(m2) :");
		jlbAirCnd = new JLabel("Air Conditioner :");
		jlbIDRemove = new JLabel("ID:");
		jlbeMaxBound = new JLabel("Max:");
		jlbMinBound = new JLabel("Min:");
		jlbNumberofRooms = new JLabel("Number of Rooms :");
	}

	public void createButtons() {
		jbAddHouse = new JButton("Add House");
		jbOrderHouse = new JButton("Order Houses");
		jbRemoveHouse = new JButton("Remove House");
		jbSearchHouse = new JButton("Search House");
		jBackAdd = new JButton("Back");
		jBackRemove = new JButton("Back");
		jBackSearch = new JButton("Back");
		jBackOrder = new JButton("Back");
		jbAdd = new JButton("Add");
		jbRemove = new JButton("Remove");
		jbSearch = new JButton("Search");

		addButtonActionListener();
	}

	public void addButtonActionListener() {
		jbAddHouse.addActionListener(this);
		jbOrderHouse.addActionListener(this);
		jbRemoveHouse.addActionListener(this);
		jbSearchHouse.addActionListener(this);
		jBackAdd.addActionListener(this);
		jBackRemove.addActionListener(this);
		jBackOrder.addActionListener(this);
		jBackSearch.addActionListener(this);
		jbAdd.addActionListener(this);
		jbRemove.addActionListener(this);
		jbSearch.addActionListener(this);

	}

	public void createRadioButtons() {
		jrdAscending = new JRadioButton("Ascending Order");
		jrdDescending = new JRadioButton("Descending Order");

		orderGroup = new ButtonGroup();

		orderGroup.add(jrdAscending);
		orderGroup.add(jrdDescending);

		radioButtonActionListener();

	}

	public void radioButtonActionListener() {
		jrdAscending.addActionListener(this);
		jrdDescending.addActionListener(this);

	}

	public void createComboBox() {
		jcomboAirCon = new JComboBox<>();
		jcomboAirCon.addItem("yes");
		jcomboAirCon.addItem("no");
		// jcomboAirCon.addActionListener(this);

	}

	public void createCheckboxes() {
		jchPrice = new JCheckBox("Price");
		jchSize = new JCheckBox("Size");
		jchRooms = new JCheckBox("Rooms");

		searchGroup = new ButtonGroup();

		searchGroup.add(jchPrice);
		searchGroup.add(jchRooms);
		searchGroup.add(jchSize);

		checkBoxActionListener();
	}

	public void checkBoxActionListener() {
		jchPrice.addActionListener(this);
		jchRooms.addActionListener(this);
		jchSize.addActionListener(this);
	}

	public void createTextFields() {
		jtfPrice = new JTextField(5);
		jtfSize = new JTextField(5);
		jtfRooms = new JTextField(5);
		jtfBathRooms = new JTextField(5);
		jtfIDRemove = new JTextField(10);
		jtfMaxBound = new JTextField(15);
		jtfMinBound = new JTextField(15);
		jtfNumberofRooms = new JTextField(15);
	}

	public void createRightMainCon() {
		rightMainCon = new Container();
		rightMainCon.setLayout(new GridLayout(5, 0));

		rightMainCon.add(jbAddHouse);
		rightMainCon.add(jbOrderHouse);
		rightMainCon.add(jbRemoveHouse);
		rightMainCon.add(jbSearchHouse);

	}

	public void createAddCon() {
		addCon = new Container();
		addCon.setLayout(new BoxLayout(addCon, BoxLayout.PAGE_AXIS));

		addCon.add(jlbPrice);
		addCon.add(jtfPrice);

		addCon.add(jlbSize);
		addCon.add(jtfSize);

		addCon.add(jlbRooms);
		addCon.add(jtfRooms);

		addCon.add(jlbBathRooms);
		addCon.add(jtfBathRooms);

		addCon.add(jlbAirCnd);
		addCon.add(jcomboAirCon);

		addCon.add(jbAdd);
		addCon.add(jBackAdd);

	}

	public void createRemoveCon() {
		removeCon = new Container();
		removeCon.setLayout(new BoxLayout(removeCon, BoxLayout.Y_AXIS));

		jtfIDRemove.setMaximumSize(jtfIDRemove.getPreferredSize());

		removeCon.add(jlbIDRemove);
		removeCon.add(jtfIDRemove);

		removeCon.add(jbRemove);
		removeCon.add(jBackRemove);

	}

	public void createOrderCon() {
		orderCon = new Container();
		orderCon.setLayout(new GridLayout(3, 0));

		orderCon.add(jrdAscending);
		orderCon.add(jrdDescending);

		orderCon.add(jBackOrder);

	}

	public void createSearchCon() {
		searchCon = new Container();
		searchCon.setLayout(new BoxLayout(searchCon, BoxLayout.PAGE_AXIS));
		searchCon.add(jchPrice);
		searchCon.add(jchSize);
		searchCon.add(jchRooms);

		searchCon.add(jlbMinBound);
		searchCon.add(jtfMinBound);
		jtfMinBound.setMaximumSize(jtfMinBound.getPreferredSize());

		searchCon.add(jlbeMaxBound);
		searchCon.add(jtfMaxBound);
		jtfMaxBound.setMaximumSize(jtfMaxBound.getPreferredSize());

		searchCon.add(jlbNumberofRooms);
		searchCon.add(jtfNumberofRooms);

		searchCon.add(jbSearch);
		searchCon.add(jBackSearch);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbAddHouse) {
			cardlayoutRightPanel.show(jpRight, "Add Container");
		}

		else if (e.getSource() == jbAdd) {
			if (checkTextFieldsAdd()) {
				addHouse();
				JOptionPane.showMessageDialog(null, "Houses added succesfully.");
				cardlayoutRightPanel.first(jpRight);
				try {
					estateAgent.save();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}

		else if (e.getSource() == jBackAdd) {
			cardlayoutRightPanel.first(jpRight);
		}

		else if (e.getSource() == jbOrderHouse) {
			cardlayoutRightPanel.show(jpRight, "Order Container");
		}

		else if (e.getSource() == jrdAscending) {
			orderAscending();
			try {
				estateAgent.save();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}

		else if (e.getSource() == jrdDescending) {
			orderDescending();
			try {
				estateAgent.save();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		}

		else if (e.getSource() == jBackOrder) {
			orderByID();
			cardlayoutRightPanel.first(jpRight);
		}

		else if (e.getSource() == jbSearchHouse) {

			cardlayoutRightPanel.show(jpRight, "Search Container");
		}

		else if (e.getSource() == jbSearch) {
			int min;
			int max;
			if (jchPrice.isSelected()) {
				if (checkTextField(jtfMinBound) && checkTextField(jtfMaxBound)) {

					min = Integer.valueOf(jtfMinBound.getText());
					max = Integer.valueOf(jtfMaxBound.getText());
					searchbyPrice(min, max);
				}
			}

			else if (jchRooms.isSelected()) {
				if (checkTextField(jtfRooms)) {

					int number_of_rooms = Integer.valueOf(jtfNumberofRooms.getText());
					searchByRooms(number_of_rooms);
				}
			}

			else if (jchSize.isSelected()) {
				if (checkTextField(jtfMaxBound) && checkTextField(jtfMinBound)) {

					min = Integer.valueOf(jtfMinBound.getText());
					max = Integer.valueOf(jtfMaxBound.getText());
					searchBySize(min, max);
				}
			}
			try {
				estateAgent.save();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		}

		else if (e.getSource() == jBackSearch) {
			orderByID();
			cardlayoutRightPanel.first(jpRight);

		}

		else if (e.getSource() == jbRemoveHouse) {
			cardlayoutRightPanel.show(jpRight, "Remove Container");
		}

		else if (e.getSource() == jbRemove) {
			if (checkTextFieldRemove()) {

				String id = jtfIDRemove.getText();
				removeHouse(id);
				JOptionPane.showMessageDialog(null, "Houses removed succesfully.");
			}
		}

		else if (e.getSource() == jBackRemove) {
			orderByID();
			cardlayoutRightPanel.first(jpRight);
		}

	}

	public boolean checkTextField(JTextField text_field) {
		try {
			Integer.parseInt(text_field.getText());
		} catch (Exception e) {
			new JOptionPane().showMessageDialog(null, "Invalid input. Try again!");
			return false;
		}
		return true;

	}

	public boolean checkTextFieldRemove() {
		try {
			Integer.parseInt(jtfIDRemove.getText());
		} catch (Exception e) {
			new JOptionPane().showMessageDialog(null, "Invalid input. Try again!");
		}
		return true;
	}

	public boolean checkTextFieldsAdd() {
		try {

			Integer.parseInt(jtfPrice.getText());
		} catch (NumberFormatException e) {
			new JOptionPane().showMessageDialog(null, "Invalid input. Try again!1");
			return false;
		}
		try {
			Integer.parseInt(jtfSize.getText());
		} catch (NumberFormatException e) {
			new JOptionPane().showMessageDialog(null, "Invalid input. Try again!2");
			return false;
		}
		try {
			Integer.parseInt(jtfRooms.getText());

		} catch (NumberFormatException e) {
			new JOptionPane().showMessageDialog(null, "Invalid input. Try again!3");
			return false;
		}

		try {

			Integer.parseInt(jtfBathRooms.getText());
		} catch (NumberFormatException e) {

			new JOptionPane().showMessageDialog(null, "Invalid input. Try again!4");
			return false;
		}
		return true;

	}

	public void fillTable(ArrayList<House> houses) {

		for (House house : houses) {
			Object[] data = { house.getID(), house.getPrice(), house.getSize(), house.getNumber_of_rooms(),
					house.getNumber_of_bathrooms(), house.getAirConditioner() };
			tableModel.addRow(data);

		}
	}

	public void addHouse() {
		String id = String.valueOf(estateAgent.getHouses().size() + 1);
		Integer price = Integer.valueOf(jtfPrice.getText());
		Integer size = Integer.valueOf(jtfSize.getText());
		int rooms = Integer.valueOf(jtfRooms.getText());
		int brooms = Integer.valueOf(jtfBathRooms.getText());
		String aircon = String.valueOf(jcomboAirCon.getSelectedItem());

		House house = new House(id, price, size, rooms, brooms, aircon);

		estateAgent.addHouse(house);
		addRowTable(house);
	}

	public void addRowTable(House house) {
		Object[] data = { house.getID(), house.getPrice(), house.getSize(), house.getNumber_of_rooms(),
				house.getNumber_of_bathrooms(), house.getAirConditioner() };

		tableModel.addRow(data);

	}

	public void orderByID() {
		tableModel.setRowCount(0);
		estateAgent.orderByID();
		fillTable(estateAgent.getHouses());

	}

	public void orderAscending() {
		estateAgent.orderAscendingPrice();
		tableModel.setRowCount(0);
		fillTable(estateAgent.getHouses());
	}

	public void orderDescending() {
		estateAgent.orderDescendingPrice();
		tableModel.setRowCount(0);
		fillTable(estateAgent.getHouses());

	}

	public void searchbyPrice(int min, int max) {
		ArrayList<House> houses = estateAgent.searchWithPrice(min, max);
		tableModel.setRowCount(0);

		fillTable(houses);

	}

	public void searchByRooms(int number_of_rooms) {
		ArrayList<House> houses = estateAgent.searchHouseWithRoom(number_of_rooms);
		tableModel.setRowCount(0);

		fillTable(houses);
	}

	public void searchBySize(int min, int max) {
		ArrayList<House> houses = estateAgent.searchWithSize(min, max);
		tableModel.setRowCount(0);

		fillTable(houses);
	}

	public void removeHouse(String id) {
		estateAgent.removeHouse(id);
		tableModel.setRowCount(0);
		fillTable(estateAgent.getHouses());

	}

	public void save() {

	}

}
