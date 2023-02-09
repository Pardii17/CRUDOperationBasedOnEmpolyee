package com.techpalle;

import java.util.Scanner;

public class Myprogram {

	public static void main(String[] args) 
	{
		Employee e = new Employee();
		boolean repeat = true;
		System.out.println("1 : For creating Employee table");
		System.out.println("2 : for inserting a values in table");
		System.out.println("3 : For Updating a values in table");
		System.out.println("4 : For deleting a values in table");
		System.out.println("5 : For reading a values  in table");
		System.out.println("6 : For Exit a program");
		
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a number");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				e.creating();
				System.out.println("Employee Table is created");
				break;
				
			case 2:
				System.out.println("Enter ename");
				String ename=sc.next();
				System.out.println("Enter esal");
				int esal=sc.nextInt();
				e.inserting(ename, esal);
				break;
				
			case 3:
				System.out.println("Enter eid");
				int eid1=sc.nextInt();
				System.out.println("Enter ename");
				String ename1=sc.next();
				System.out.println("Enter esal");
				int esal1=sc.nextInt();
				e.updating(eid1, ename1, esal1);
				break;
				
			case 4:
				System.out.println("Enter eid");
				int eid2=sc.nextInt();
				e.deleting(eid2);
				break;
				
			case 5:
				System.out.println("values in Employee Table is : ");
				e.read();
				break;
				
			case 6:
				repeat=false;
				System.out.println("Program is exist");
				break;
				
			default:
				System.out.println("Invalid number");
			}
		}
		while(repeat);
	}
}
