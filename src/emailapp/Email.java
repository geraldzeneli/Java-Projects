package emailapp;

import java.util.Scanner;

public class Email {
	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength=10;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	//Constructor to receive the firstname and lastname
	public Email(String fname, String lname) {
		this.firstname = fname;
		this.lastname = lname;
		
		//Call the method asking for the department - return the department
		this.department = setDepartment();
		
		//Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + password);
		
		//Combine elements to generate email
		email = this.firstname.toLowerCase() + "." + this.lastname.toLowerCase() + "@" + this.department + "." + this.companySuffix;
	}
	
	//Ask for the department
	private String setDepartment() {
		System.out.print("New worker: " + firstname + ". Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter the department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {
			return "sales";
		}
		else if(depChoice == 2) {
			return "dev";
		}
		else if(depChoice == 3) {
			return "acct";
		}
		else return "";
	}
	
	//Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@$%";
		char[] password = new char[length];
		
		for(int i=0;i<length;i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	//Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	//Change the password
	public void changePassword(String passwd) {
		this.password = passwd;
	}
	
	public String getPassword() {
		return password;
	}
	
	//Show info
	public String showInfo() {
		return "Display Name: " + firstname + " " + lastname +
				"\nCompany Email: " + email +
				"\nMailbox Capacity: " + mailboxCapacity + "mb";
	}
}
