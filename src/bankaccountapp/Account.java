package bankaccountapp;

public abstract class Account implements IBaseRate {
	// List common properties for savings and checking accounts
	private String name;
	private String SSN;
	private double balance;
	private static int index = 10000;
	
	protected String accountNumber;
	protected double rate;
	
	// Constructor to set base properties and initialize the account
	public Account(String name, String SSN, double initDeposit) {
		this.name = name;
		this.SSN = SSN;
		balance = initDeposit;

		// Set account number
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		String lastTwoSsn = SSN.substring(SSN.length()-2, SSN.length());
		int uniqueId = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoSsn + uniqueId + randomNumber;
	}
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance += accruedInterest;
		System.out.println("Accrued interest: $" + accruedInterest);
		printBalance();
	}
	
	// List common methods
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance -= amount;
		System.out.println("Transfering $" + amount + " to: " + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your current balance is: $" + balance);
	}
	
	public void showInfo() {
		System.out.println(
				"Name: " + name +
				"\nAccount number: " + accountNumber +
				"\nBalance: " + balance +
				"\nRate: " + rate + "%");
	}
}
