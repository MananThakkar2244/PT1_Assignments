import java.util.Scanner;
class Person {
	int id;
	String name, city;
	Scanner sc = new Scanner(System.in);
	void setPerson() {
		System.out.print("Enter name: ");
		name = sc.next();
		System.out.print("Enter city: ");
		city = sc.next();
		System.out.print("Enter id: ");
		id = sc.nextInt();
	}
	void getPerson() {
		System.out.println("Name: " + name);
		System.out.println("City: " + city);
		System.out.println("Id: " + id);
	}
}

class Student extends Person {
	String branch;
	int[] marks = new int[5];
	void setStu() {
		setPerson();
		System.out.print("Enter branch: ");
		branch = sc.next();
		for (int i = 0; i < 5; i++) {
			System.out.print("Enter marks in sub " + (i + 1) + ": ");
			marks[i] = sc.nextInt();
		}
	}
	void getStu() {
		getPerson();
		System.out.println("Branch: " + branch);
		for (int i = 0; i < 5; i++) {
			System.out.println("Marks, sub " + (i + 1) + ": " + marks[i]);
		}
	}
	double avgMarks() {
		double total = 0.00;
		for (int i = 0; i < 5; i++) {
			total += marks[i];
		}
		return total / 5;
	}
}

class VisitingTeacher extends Person {
	int exp, rateOfLec, workingHrs;
	void setVisitingTeacher() {
		setPerson();
		System.out.print("Enter years of experience: ");
		exp = sc.nextInt();
		System.out.print("Enter working hours: ");
		workingHrs = sc.nextInt();
		System.out.print("Enter rate of lecture per hour: ");
		rateOfLec = sc.nextInt();
	}
	void getVisitingTeacher() {
		getPerson();
		System.out.println("Years of experience: " + exp);
		System.out.println("Working hours: " + workingHrs);
		System.out.println("Rater of lecture per hour: " + rateOfLec);
		System.out.println("Salary: " + calSalary());
	}
	double calSalary() {
		if (workingHrs <= 40) {
			return workingHrs * rateOfLec;
		} else {
			double normalPay = 40 * rateOfLec;
			double overtimeHrs = workingHrs - 40;
			double overtimePay = overtimeHrs * rateOfLec * 1.5;
			return normalPay + overtimePay;
		}
	}
}

class PersonTest {
	public static void main(String[] args) {
		System.out.println("\n---Enter Student Details---");
		Student stu = new Student();
		stu.setStu();
		System.out.println("\n---Student Details---");
		stu.getStu();

		System.out.println("\n---Enter Visiting Teacher Details---");
		VisitingTeacher vt = new VisitingTeacher();
		vt.setVisitingTeacher();
		System.out.println("\n---Visiting Teacher Details---");
		vt.getVisitingTeacher();
	}
}