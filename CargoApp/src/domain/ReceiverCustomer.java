/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/



package domain;

public class ReceiverCustomer extends Customer {
	
	private Cargo cargo;
	
	
	public ReceiverCustomer(String id, String name, String phone_number, String address,Cargo cargo) {
		super(id, name, phone_number, address);
		
	}
	
	public ReceiverCustomer(){
		super();
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
