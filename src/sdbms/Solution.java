package sdbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Welcome to student DB Management System ");
		System.out.println("-----------------");
		Scanner scan=new Scanner(System.in);
		StudentManagementSystem sms=new StudentManagementSystemImp();//upcasted
		while(true)
		{

			System.out.println("1: AddStudent\n2: displayStudent\n3: displayAllStudents");
			System.out.println("4: removeStudent\n5: removeAllStudents\n6: updateStudent");
			System.out.println("7: countStudent\n8: sortStudents\n9: getStudentWithLowestMarks");
			System.out.println("10: getStudentWithHighestMarks");
			System.out.print("Enter the number :- ");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudents();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudents();
				break;
			case 6:{
				sms.updateStudent();
				break;}
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudents();
				break;
			case 9:
				sms.getStudentWithLowestMarks();
				break;
			case 10:
				sms.getStudentWithHighestMarks();
				break;
			case 11:
				System.out.println("Thank You!");
				System.exit(0);
				break;
			default:
				try {
					throw new InvalidChoiceException("Invalid choice, Enter Valid Choice!");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}//end of swith
			System.out.println("-------------");
		}//end of while loop
	}//end of main()
}//end of class
