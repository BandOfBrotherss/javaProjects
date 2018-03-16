/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.*;

public class Company {

	private ArrayList<Employee> employee_list = new ArrayList<Employee>();

	public ArrayList<Employee> getEmployee_list() {
		return employee_list;
	}

	public void setEmployee_list(ArrayList<Employee> employee_list) {
		this.employee_list = employee_list;
	}

	public Company() {
	}

	public void addEmployee(Employee employee) {
		employee_list.add(employee);

	}

	public void removeEmployee(String name) {
		Iterator<Employee> company_iterator = employee_list.iterator();
		boolean flag = false;
		while (company_iterator.hasNext()) {
			Employee employee = company_iterator.next();
			File employee_information = new File(employee.getName() + ".dat");
			if (employee.getName().equals(name)) {
				company_iterator.remove();
				employee_information.delete();
				flag = true;
				System.out.println("Employee removed succesfully !");
				break;
			}

		}
		if (!flag) {
			System.out.println("There is no such an employee !");
		}
	}

	public void calculateSalaries(Employee employee) {
		double salary;
		Employee_type type = employee.getEmployee_type();
		double promotion = 0;
		switch (type) {
		case STAFF:
			if (employee.getAmount_of_sale() > 50) {
				promotion = 100.00;
			}
			salary = (employee.getHours_worked() * 35.00) + (employee.getHours_overtime_worked() * 17.5 + promotion);
			employee.setSalary(salary);
			break;
		case PART_TIME:
			if (employee.getAmount_of_sale() >= 70) {
				promotion = 100.00;
			}
			salary = (employee.getHours_worked() * 20.00) + (employee.getHours_overtime_worked() * 10.00 + promotion);
			employee.setSalary(salary);
			break;
		case INTERN:
			if (employee.getAmount_of_sale() >= 30) {
				promotion = 10.00;
			}
			salary = (employee.getHours_worked() * 5.00) + (employee.getHours_overtime_worked() * 2.50 + promotion);
			employee.setSalary(salary);
			break;
		}

	}

	public void saveEmployee(Employee employee) throws FileNotFoundException {
		PrintWriter outputStream = new PrintWriter(new FileOutputStream(employee.getName() + ".dat"));
		outputStream.print(employee.getName() + ", " + employee.getAge() + ", " + employee.getEmployee_type() + ", "
				+ String.valueOf(employee.getHours_worked()) + ", " + employee.getHours_overtime_worked() + ", "
				+ employee.getAmount_of_sale() + ", " + employee.getSalary());
		outputStream.close();
	}

	public void calculateAverageSalary() throws IOException {
		String information;
		String infot = null;
		double salaries_sum = 0;
		PrintWriter averageSalary = new PrintWriter(new FileOutputStream("averageSalary.dat"));
		BufferedReader fil = null;
		for (Employee employee : employee_list) {
			File people = new File(employee.getName() + ".dat");
			fil = new BufferedReader(new FileReader(people));
			information = fil.readLine();
			StringTokenizer stringTokenize = new StringTokenizer(information, ", ");
			for (int j = 0; j < 8; j++) {
				infot = stringTokenize.nextToken();

			}
			salaries_sum += Double.parseDouble(infot);
		}
		averageSalary.print("Average Salary : $" + salaries_sum / employee_list.size());
		averageSalary.close();
	}

}