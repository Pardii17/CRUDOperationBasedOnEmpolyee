package com.techpalle;

import java.util.Scanner;

public class Myprogram {

	public static void main(String[] args) 
	{
		Employee e = new Employee();
		boolean repeat = true;
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
