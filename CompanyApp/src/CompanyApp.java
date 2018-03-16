
/**
*
*@author FurkanCan-İbrahimAcar , 220201014-220201023
*
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CompanyApp {

	public static Company readEmployeeDir() throws IOException {
		String name;
		int age;
		Employee_type type;
		Company company = new Company();

		BufferedReader employeeInfo = new BufferedReader(new FileReader("src/employeeInfo.dir"));
		for (int i = 0; i < 3; i++) {
			String employee = employeeInfo.readLine();
			StringTokenizer stringTokenizer = new StringTokenizer(employee, ",");
			name = stringTokenizer.nextToken();
			age = Integer.parseInt((stringTokenizer.nextToken().trim()));
			type = Employee_type.valueOf(stringTokenizer.nextToken().trim());
			Employee person = new Employee(name, age, type);
			person.setHours_worked(Double.parseDouble(stringTokenizer.nextToken().trim()));
			person.setHours_overtime_worked(Double.parseDouble(stringTokenizer.nextToken()));
			person.setAmount_of_sale(Double.parseDouble(stringTokenizer.nextToken()));
			person.setSalary(Double.parseDouble(stringTokenizer.nextToken()));
			company.addEmployee(person);
		}
		employeeInfo.close();
		return company;
	}

	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		Company company = readEmployeeDir();
		while (check) {
			System.out.println("---------MENU---------");
			System.out.println("1. Add employee");
			System.out.println("2. Remove Employee");
			System.out.println("3. Calculate Salary");
			System.out.println("4. Save employee information");
			System.out.println("5. Save average of the salaries");
			System.out.println("----------------------");
			System.out.println("Enter 0 to EXIT");

			int input = keyboard.nextInt();

			switch (input) {
			case 0:
				check = false;
				break;
			case 1:
				Employee employee = new Employee("", 0, Employee_type.STAFF);
				int age;
				String name;
				Employee_type type;

				System.out.println("Please enter a name");
				name = sc.nextLine();
				if (employee.setName(name) == false) {
					while (employee.setName(name) == false) {

						System.out.println("Invalid input. Please enter a name");
						name = sc.nextLine();
					}
				}

				System.out.println("Please enter the age");
				age = Integer.valueOf(keyboard.next());

				if (employee.setAge(age) == false) {

					while (employee.setAge(age) == false) {

						System.out.println("This is not a valid input for age. Please enter an age greater than 15.");
						age = Integer.valueOf(keyboard.next());
					}
				}
				System.out.println("Please enter the employee type");
				type = Employee_type.valueOf(keyboard.next().toUpperCase());
				employee.setEmployee_type(type);
				company.addEmployee(employee);
				sc.close();
				break;
			case 2:
				String name1;
				System.out.println("ENter name");
				name1 = keyboard.next() + " " + keyboard.next();
				company.removeEmployee(name1);
				break;
			case 3:
				double hours_worked = 0;
				double hours_overtime_worked = 0;
				double amount_of_sale = 0;
				for (Employee employe : company.getEmployee_list()) {
					System.out.println(employe.getName());
					do {
						System.out.println("Enter the number of hours that employee worked :");
						hours_worked = keyboard.nextDouble();
					} while (employe.setHours_worked(hours_worked) == false);

					do {
						System.out.println("Enter the number of hours that employee overtime worked :");
						hours_overtime_worked = keyboard.nextDouble();
					} while (employe.setHours_overtime_worked(hours_overtime_worked) == false);

					do {
						System.out.println("Enter the amount of sale that employee does");
						amount_of_sale = keyboard.nextDouble();
					} while (employe.setAmount_of_sale(amount_of_sale) == false);

					company.calculateSalaries(employe);
					System.out.println("Salary of " + employe.getName() + " is $" + employe.getSalary());
				}
				break;
			case 4:
				for (Employee each_employe : company.getEmployee_list()) {
					company.saveEmployee(each_employe);
					System.out.println("Information of " + each_employe.getName() + " is written to the '"
							+ each_employe.getName() + ".dat'");
				}
				break;
			case 5:
				company.calculateAverageSalary();
				System.out.println("The average of the salaries is written to'averageSalary.dat'");
				break;
			}
		}
		keyboard.close();
	}
}