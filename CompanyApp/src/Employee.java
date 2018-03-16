
/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/

import java.util.regex.Pattern;

public class Employee {

	public String name;
	private int age;
	private Employee_type employee_type;
	private double hours_worked;
	private double hours_overtime_worked; // enumu dışarıda al // inputları
											// burada kontrol et
	private double amount_of_sale;
	private double salary;

	public Employee(String name, int age, Employee_type employee_type) {
		setName(name);
		setAge(age);
		setEmployee_type(employee_type);
		setHours_overtime_worked(0);
		setHours_worked(0);
		setSalary(0);
		setAmount_of_sale(0);

	}

	public double getHours_worked() {
		return hours_worked;
	}

	public boolean setHours_worked(double hours_worked) {
		if (hours_worked < 0) {
			return false;
		} else {
			this.hours_worked = hours_worked;
			return true;
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAmount_of_sale() {
		return amount_of_sale;
	}

	public boolean setAmount_of_sale(double amount_of_sale) {
		if (amount_of_sale < 0) {
			return false;
		} else {
			this.amount_of_sale = amount_of_sale;
			return true;
		}
	}

	public double getHours_overtime_worked() {
		return hours_overtime_worked;
	}

	public boolean setHours_overtime_worked(double hours_overtime_worked) {
		if (hours_overtime_worked < 0) {
			return false;
		} else {
			this.hours_overtime_worked = hours_overtime_worked;
			return true;
		}

	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if (Pattern.matches("[ A-Za-z]+", name)) {
			this.name = name;
			return true;
		} else {
			return false;
		}

	}

	public int getAge() {
		return age;
	}

	public boolean setAge(int age) {
		if (age < 15) {
			return false;
		} else {
			this.age = age;
			return true;
		}
	}

	public Employee_type getEmployee_type() {
		return employee_type;
	}

	public void setEmployee_type(Employee_type employee_type) {

		this.employee_type = employee_type;

	}

}