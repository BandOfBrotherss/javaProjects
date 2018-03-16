/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/



package domain;

import java.util.ArrayList;

public class SenderCustomer extends Customer {

	private ArrayList<Cargo> cargoes = new ArrayList<Cargo>();
	
	public SenderCustomer(String id, String name, String phone_number, String address,ArrayList<Cargo> cargoes) {
		super(id, name, phone_number, address);
	}
	
	public SenderCustomer(){
		super();
	}

	
	public ArrayList<Cargo> getCargoes() {
		return cargoes;
	}

	public void addCargo(Cargo cargo) {
		cargoes.add(cargo);
	}

}