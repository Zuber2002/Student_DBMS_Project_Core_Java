package sdbms;
import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;


public class StudentManagementSystemImp implements StudentManagementSystem{	
	//Scanner
	Scanner scan=new Scanner(System.in);
	//Map db=new lhm
	Map<String,Student> db=new LinkedHashMap<String,Student>();	
	@Override
	public void addStudent(){
		//accept age,name and marks
		//add student object into db -> put() -> id,std
		System.out.println("Enter Student Age:- ");
		int age=scan.nextInt();
		System.out.println("Enter Student Name:- ");
		String name=scan.next();
		System.out.println("Enter Student marks:- ");
		int marks=scan.nextInt();
		Student std=new Student(age, name, marks);
		db.put(std.getid(), std);
		System.out.println("Student Record Inserted Sucessfully");
		System.out.println("Student Id is "+std.getid());
	}
	@Override
	public void displayStudent() {
		System.out.println("Enter Student Id:- ");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student Details are Follows:- ");
			System.out.println("-----------------------------");
			Student std=db.get(id);
			System.out.println("Id: "+std.getid());
			System.out.println("Age: "+std.getage());
			System.out.println("Name: "+std.getname());
			System.out.println("Marks: "+std.getmarks());
			//			System.out.println(std);->printing ref var as toString() is Overriden
		}
		else {
			try {
				String message="Student with the Id"+id+" is Not found!";
				throw new StubNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void displayAllStudents() {
		if(db.size()!=0)
		{
			Set<String> keys=db.keySet();
			for(String key:keys)
			{
				Student value=db.get(key);
				System.out.println(value);
			}
		}
		else {
			try {
				String message="Student Records Not Available to Display!";
				throw new StubNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeStudent() {
		System.out.println("Enter student id:- ");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student Record Found!");
			System.out.println(db.get(id));//priting student object
			db.remove(id);
			System.out.println("Student Record Deleted Sucessfully");
		}
		else {
			try {
				String message="Student with the Id "+id+" is Not Found!";
				throw new StubNotFoundException(message);
			} 
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}	
	}

	@Override
	public void removeAllStudents() 
	{
		if(db.size()!=0) {
			System.out.println("Student Records Available:- "+db.size());
			db.clear();
			System.out.println("All Student Reccords Deletd Successfully!");
			System.out.println("Student Records Available:"+db.size());

		}
		else {
			try {
				String message="Student Database is Empty!";
				throw new StubNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void updateStudent() 
	{
		System.out.println("Enter Student Id:- ");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("1:Update Age\n2:Update Name\n3:Update Marks");
			System.out.println("Enter choice:");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Age:- ");
				int age=scan.nextInt();
				std.setage(age);
				break;
			case 2:
				System.out.println("Enter name:- ");
				String name=scan.next();
				std.setname(name);
				break;
			case 3:
				System.out.println("Enter marks:- ");
				int marks=scan.nextInt();
				std.setage(marks);
				break;
			default:
				try {
					String message="Invalid Choice, Enter Valid Choice!";
					throw new StubNotFoundException(message);
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}

			}

		}
		else {
			try {
				String message="Student with the Id "+id+" is Not Found!";
				throw new StubNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}


	}


	@Override
	public void countStudent() 
	{
		System.out.println("No of Student Records:- "+db.size());
	}
	private static void display(List<Student> list) {
		for(Student s:list) {
			System.out.println(s);
		}
	}

	@Override
	public void sortStudents() 
	{
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			for(String key:keys) {
				list.add(db.get(key));
			}
			System.out.println("1:Sort by id\n2:Sort by Age\n3:Sort by Name\n4:Sort by marks\\n1:Enter choice:- \n");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				Collections.sort(list,new SortStudentById());
				display(list);
				break;
			case 2:
				Collections.sort(list,new SortStudentByAge());
				display(list);
				break;
			case 3:
				Collections.sort(list,new SortStudentByName());
				display(list);
				break;
			case 4:
				Collections.sort(list,new SortStudentByMarks());
				display(list);
				break;
			default:
				try {
					String message="Invalid choice, Enter valid choice";
					throw new StubNotFoundException(message);
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}

			}
		}
		else {
			try {
				String message="No Sufficient student objects to sort!";
				throw new StubNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}

		}
	}


	@Override
	public void getStudentWithLowestMarks() 
	{
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			for(String key:keys) {
				list.add(db.get(key));
			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(0));
		}
		else {
			try {
				String message="No Sufficient student objects to compare!";
				throw new StubNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			for(String key:keys) {
				list.add(db.get(key));
			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(list.size()-1));
		}
		else {
			try {
				String message="No Sufficient student objects to compare!";
				throw new StubNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}

		}


	}

}
