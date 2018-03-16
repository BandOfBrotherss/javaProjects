package domain;

import java.util.Scanner;

public class Menu {
	public Menu(){}
	public void starter(){
		Simulation simulation = new Simulation();
		String name=getNameForUser();
		simulation.start();		
		simulation.human.setName(name);
		simulation.computer.setName();
		simulation.chooseWhoStart();
		
	
	
	
	
	
	}

	public String getNameForUser(){
		System.out.println("Please enter your name");
		Scanner sc = new Scanner(System.in);
		String name =sc.nextLine();
		return name;
		
	}
	
	
	
	
	
	
}
