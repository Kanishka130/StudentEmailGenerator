package emailGen;

import java.util.Scanner;

public class emailObj {
	private String firstName; //Encapsulating the variables so that they are not accessed by everyone 
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int defaultPasswordLen = 10;
	private int inboxCapacity = 500;
	private String altEmail;
	private String college = "liit.ac.in";
	
	//Constructor to set the firstName and lastName
	public emailObj(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email Created:"+firstName+" "+lastName);
		//Call a method within this method to set department
		this.department = setDepartment();
		System.out.println("Department:"+department);
		//Call a method to generate password
		this.password = randomPassword(defaultPasswordLen);
		System.out.println("Your password is:"+password);
		//Generate email
		email = firstName.toLowerCase() + lastName.toLowerCase() + "." + department + "@" + college;
		//System.out.println("Your email ID is: "+email);
	}
	
	//Ask for department
	private String setDepartment(){
		System.out.println("Department Numbers:\n1 for Computer Science\n2 for Electrical\n3 for Mechanical\n4 for Chemical\n5 for Civil\nEnter the department number:");  
		Scanner read = new Scanner(System.in);
		int depChoice = read.nextInt();
		if(depChoice == 1) {
			return "cse";
		}else if(depChoice == 2) {
			return "ele";
		}else if(depChoice == 3) {
			return "mec";
		}else if(depChoice == 4) {
			return "che";
		}else if(depChoice == 5) {
			return "civ";
		}else {
			return "";
		}
	}
	
	//Generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&*";
		char password[] = new char[length];
		for(int i=0;i<length;i++) {
			int rand = (int)(Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set the inbox capacity
	public void setInboxCapacity(int capacity) {
		this.inboxCapacity = capacity;
	}
	
	//Set alternate email ID
	public void setAlternateEmail(String alternateEmail) {
		this.altEmail = alternateEmail;
	}
	
	//Change the password
	public void changePassword(String pass) {
		if(pass.length() < defaultPasswordLen) { //Checks if password length is less than the default value
			System.out.println("Password must be "+defaultPasswordLen+" long.");
			System.out.println("Enter the password:");
			Scanner r = new Scanner(System.in);
			pass = r.nextLine();
			changePassword(pass);
		}
		else {
			this.password = pass;
		}
		
	}
	
	//Display inbox capacity
	public int getInboxCapacity() {
		return inboxCapacity;
	}
	
	//Display alternate email
	public String getAlternateEmail() {
		return altEmail;
	}
	
	//Display password
	public String password() {
		return password;
	}
	
	//Display information
	public String display() {
		return "\nName: "+ firstName + " " + lastName +
				"\nEmail:" + email +
				"\nAlternate Email: " + altEmail +
				"\nInbox Capacity: " + inboxCapacity;
	}

}
