class BankAccount {
	double balance;
	BankAccount() {
		balance = 0;
	}
	BankAccount(double balance) {
		this.balance = balance;
	}
	double deposit(double money) {
		balance += money;
		return balance;
	}
	double withdraw(double money) {
		if (balance >= money) {
			balance -= money;
			return balance;
		} else {
			System.out.println("Balance is not enough to withdraw money");
			return 0;
		}
	}
	void getBalance() {
		System.out.println("Current balance: " + balance);
	}
	void transfer(double amount, BankAccount accName) {
		if (this.withdraw(amount) == 0) {
			System.out.println("Not sufficient balance to transfer the money");
		} else {
			accName.deposit(amount);
		}
	}
}

class SavingsAccount extends BankAccount {
	double interestRate;
	SavingsAccount(double balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}
	double addInterest() {
		double interest = balance * (interestRate / 100);
		return balance + interest;
	}
}

class CheckingAccount extends BankAccount {
	int FREE_TRANSACTIONS = 3;
	final double TRANSACTION_FEE = 2.0;
	int transactionCount = 0;
	CheckingAccount(double balance) {
		super(balance);
	}
	double deposit(double money) {
		if (FREE_TRANSACTIONS == 0 && balance + money < TRANSACTION_FEE) {
			System.out.println("Not enough balance to pay transaction fee");
			return balance;
		}
		balance += money;
		deductFees();
		return balance;
	}
	double withdraw(double money) {
		double totalRequired = money;
		if (FREE_TRANSACTIONS == 0) {
			totalRequired += TRANSACTION_FEE;
		}
		if (balance >= totalRequired) {
			balance -= money;
			deductFees();
			return balance;
		} else {
			System.out.println("Balance is not enough to withdraw money");
			return 0;
		}
	}
	void deductFees() {
		if (FREE_TRANSACTIONS > 0) {
			FREE_TRANSACTIONS--;
		} else {
			balance -= TRANSACTION_FEE;
		}
		transactionCount++;
	}
}

class BackAccountTest {
	public static void main(String[] args) {
		System.out.println("--- BankAccount ---");
		BankAccount acc1 = new BankAccount(500);
		acc1.getBalance();
		acc1.deposit(200);
		acc1.getBalance();
		acc1.withdraw(100);
		acc1.getBalance();

		System.out.println("\n--- SavingsAccount ---");
		SavingsAccount sav = new SavingsAccount(1000, 5);
		sav.getBalance();
		sav.deposit(300);
		sav.getBalance();
		sav.withdraw(150);
		sav.getBalance();
		System.out.println("Balance after interest: " + sav.addInterest());

		System.out.println("\n--- CheckingAccount ---");
		CheckingAccount chk = new CheckingAccount(1000);
		chk.getBalance();
		chk.deposit(200);
		chk.getBalance();
		chk.withdraw(100);
		chk.getBalance();

		System.out.println("\n--- transfer() test ---");
		BankAccount acc2 = new BankAccount(50);
		acc1.transfer(300, acc2);
		System.out.print("acc1 ");
		acc1.getBalance();
		System.out.print("acc2 ");
		acc2.getBalance();
	}
}