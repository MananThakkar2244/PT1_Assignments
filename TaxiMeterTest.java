import java.util.Scanner;
class TaxiMeter {
	int taxiNo;
	String name;
	double km;
	final double gst = 0.09;
	Scanner sc = new Scanner(System.in);
	void input() {
		System.out.print("Enter the taxi number: ");
		taxiNo = sc.nextInt();
		System.out.print("Enter the name of passenger: ");
		name = sc.next();
		System.out.print("Enter the distance travelled(in km) by the passenger: ");
		km = sc.nextDouble();
	}
	void display() {
		System.out.println("Taxi Number: " + taxiNo);
		System.out.println("Name of passenger: " + name);
		System.out.println("Distance travelled: " + km + "km");
		System.out.println("GST applied: " + gst);
		System.out.println("Final bill amount: " + calculate());
	}
	private double calculate() {
		double rate = 0.00;
		if (km <= 10) {
			rate = km * 25;
		} else if (km > 10 && km <= 60) {
			rate = km * 22;
		} else if (km > 60 && km <= 120) {
			rate = km * 18;
		} else if (km > 120 && km <= 200) {
			rate = km * 15;
		} else {
			rate = km * 10;
		}
		double finalBill = rate + (rate * gst);
		return finalBill;
	}
}

class TaxiMeterTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("Enter the number of passengers you want to enter: ");
		n = sc.nextInt();
		System.out.println();
		System.out.println("---Enter Details---");
		TaxiMeter taxi[] = new TaxiMeter[n];
		for (int i = 0; i < n; i++) {
			taxi[i] = new TaxiMeter();
			System.out.println();
			taxi[i].input();
		}
		System.out.println();
		System.out.println("---Details---");
		for (int i = 0; i < n; i++) {
			System.out.println();
			taxi[i].display();
		}
	}
}