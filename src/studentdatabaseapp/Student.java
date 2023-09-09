package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstname;
	private String lastname;
	private int gradeYear;
	private String studentId;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	// Constructor : prompt user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student firstname: ");
		this.firstname = in.nextLine();
		
		System.out.print("Enter student lastname: ");
		this.lastname = in.nextLine();
		
		System.out.print("1-freshmen\n2-sophmore\n3-junior\n4-senior\nEnter student class level: ");
		this.gradeYear = in.nextInt();
		
		setStudentId();
	}
	
	// Generate an ID
	private void setStudentId() {
		// Grade level + id
		id++;
		this.studentId = gradeYear + "" + id;		
	}
	
	// Enroll in courses
	public void enroll() {
		// Get inside a loop, users hits 0
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if(!course.equals("Q")) {
				courses += "\n  " + course;
				tuitionBalance += costOfCourse;
			}
			else {
				break;
			}
		}
		while(1 != 0);
	}
	
	// View balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	// Pay tuition
	public void payTuition() {
		System.out.print("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		
		viewBalance();
	}
	
	// Show status
	public String showInfo() {
		return "Name: " + firstname + " " + lastname +
				"\nGrade Level: " + gradeYear +
				"\nCourses Enrolled: " + courses +
				"\nBalance: $" + tuitionBalance;
	}
}
