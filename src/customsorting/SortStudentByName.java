package customsorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentByName implements Comparator<Student> {
	


	@Override
	public int compare(Student x, Student y) {

		return x.getname().compareTo(y.getname());
	}
	

}
