package sdbms;
public class Student {
	private String id;
	private int age;
	private String name;
	private int marks;
	static int count=101;
	public Student( int age, String name, int marks) {
		super();
		this.id = "JSP"+count;
		this.age = age;
		this.name = name;
		this.marks = marks;
		count++;
	}
	public String getid()
	{
		return id;
	}
	public int getage()
	{
		return age;
	}
	public void setage(int age)
	{
		this.age=age;
	}
	public String getname()
	{
		return name;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public int getmarks()
	{
		return marks;
	}
	public void setmarks(int marks)
	{
		this.marks=marks;
	}
	@Override
	public String toString() {
		return " id:-"+id+" age:-"+age+" name:-"+ name+" marks:-"+ marks;
		
	}
	

}
