package bankaccountapp;

public class Savings extends Account {
	// List properties specific to a savings account
	private int safetyDepositBoxId;
	private int safetyDepositBoxKey;
	
	// Constructor to initialize savings account properties
	public Savings(String name, String SSN, double initDeposit) {
		super(name, SSN, initDeposit);
		accountNumber = "1" + accountNumber;
		
		setSafetyDepositBox();
	}		
	
	private void setSafetyDepositBox() {
		safetyDepositBoxId = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
	}
	
	// List any methods specific to the savings account
	public void showInfo() {
		super.showInfo();
		System.out.println("Your savings account features" +
		"\n Safety Deposit Box Id: " + safetyDepositBoxId +
		"\n Safety Deposit Box Key: " + safetyDepositBoxKey);
	}
}
