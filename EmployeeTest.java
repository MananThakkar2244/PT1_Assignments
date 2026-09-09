class Employee {
	int id;
	String firstName, lastName;
	double monthlySalary;
	Employee(int id, String firstName, String lastName, double monthlySalary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.monthlySalary = monthlySalary;
	}
	void setId(int id) {
		this.id = id;
	}
	int getId() {
		return id;
	}
	void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	String getFirstName() {
		return firstName;
	}
	void setLastName(String lastName) {
		this.lastName = lastName;
	}
	String getLastName() {
		return lastName;
	}
	void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	double getMonthlySalary() {
		return monthlySalary;
	}
	double getYearlySalary() {
		return monthlySalary * 12;
	}
}

class EmployeeTest {
	public static void main(String[] args) {
		Employee emp1 = new Employee(1, "Aditi", "Rao", 50000);
		Employee emp2 = new Employee(2, "Rohan", "Mehta", 60000);

		System.out.println(emp1.getFirstName() + " " + emp1.getLastName() + " yearly salary: " + emp1.getYearlySalary());
		System.out.println(emp2.getFirstName() + " " + emp2.getLastName() + " yearly salary: " + emp2.getYearlySalary());

		emp1.setMonthlySalary(emp1.getMonthlySalary() * 1.10);
		emp2.setMonthlySalary(emp2.getMonthlySalary() * 1.10);

		System.out.println("\nAfter 10% raise:");
		System.out.println(emp1.getFirstName() + " " + emp1.getLastName() + " yearly salary: " + emp1.getYearlySalary());
		System.out.println(emp2.getFirstName() + " " + emp2.getLastName() + " yearly salary: " + emp2.getYearlySalary());
	}
}