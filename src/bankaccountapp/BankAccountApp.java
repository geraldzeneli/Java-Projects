package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {

		List<Account> accounts = new LinkedList<Account>();
		
		
		// Read a csv file then create new accounts based on that data
		String file = "C:\\Users\\...";
		
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		
		for(String[] accountHolder: newAccountHolders) {
			String name = accountHolder[0];
			String ssn = accountHolder[1];
			String accountType = accountHolder[2];
			double initialDeposit = Double.parseDouble(accountHolder[3]);
			
			if("Savings".equals(accountType)) {
				accounts.add(new Savings(name, ssn, initialDeposit));
			}
			else if("Checking".equals(accountType)) {
				accounts.add(new Checking(name, ssn, initialDeposit));
			}
			else {
				System.out.println("Error reading account type!");
			}
		}
		
		for(Account acc: accounts) {
			System.out.println("******************************");
			acc.showInfo();
		}

	}

}
	
