
/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/


package domain;

import java.util.regex.Pattern;

public class Cargo {
	
	private String id;
	private double weight;
	private double price;
	private String order_date;
	private SenderCustomer sender;
	private ReceiverCustomer receiver;
	private Customer payer;
	
	public Cargo(String id,double weight,double price,String order_date,SenderCustomer sender,ReceiverCustomer receiver,Customer payer){
		setId(id);
		setWeight(String.valueOf(weight));
		setPrice(String.valueOf(price));
		setOrder_date(order_date);
		setSender(sender);
		setReceiver(receiver);
		setPayer(payer);		
		
	}
	
	public Cargo(){}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getWeight() {
		return weight;
	}
	public boolean setWeight(String weight) {
		if (Pattern.matches("[.,0-9]+", weight)) {
			this.weight = Double.valueOf(weight);
			return true;
		} else {
			return false;
		}
	}
	public double getPrice() {
		return price;
	}
	public boolean setPrice(String price) {
		if (Pattern.matches("[.,0-9]+", price)) {
			this.price = Double.valueOf(price);
			return true;
		} else {
			return false;
		}
	}
	public String getOrder_date() {
		return order_date;
	}
	public boolean setOrder_date(String order_date) {
		if (Pattern.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", order_date)) {
			this.order_date = order_date;
			
			return true;
		} else {
			return false;
		}
	}
	
	public SenderCustomer getSender() {
		return sender;
	}
	public void setSender(SenderCustomer sender) {
		this.sender = sender;
	}
	public ReceiverCustomer getReceiver() {
		return receiver;
	}
	public void setReceiver(ReceiverCustomer receiver) {
		this.receiver = receiver;
	}
	public Customer getPayer() {
		return payer;
	}
	public void setPayer(Customer payer) {
		this.payer = payer;
	}
	
	
	}