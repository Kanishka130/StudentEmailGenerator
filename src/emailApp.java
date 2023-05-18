/*Email Generating Application
 * Name: Kanishka Gupta
 * The application generates email and password for students of college. Later, the students can edit their
 * information like password, alternate email, inbox capacity accordingly. The college details can be preset.
 */
package emailGen;
import java.util.*;

public class emailApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your first name:");
		String firstName = input.nextLine();
		System.out.println("Enter your last name:");
		String lastName = input.nextLine();
		emailObj st1 = new emailObj(firstName,lastName);
		System.out.println(st1.display());
		
		System.out.println("\nDo you want to change your information? (Press 1 for yes and 0 for no)"); //Allows changing the information
		int choice = input.nextInt();
		
		if(choice == 1) {
			int exitChoice = 0;
			while(exitChoice != 1) {
				Scanner in = new Scanner(System.in);
				int changeChoice;
				System.out.println("Press:\n1 to change password\n2 to change alternate email\n3 to change "
						+ "inbox capacity\nEnter your choice:");
				changeChoice = input.nextInt();
				switch(changeChoice) {
				case 1: System.out.println("Enter the new password:");
						String newPassword = in.nextLine();
						st1.changePassword(newPassword);
						break;
				case 2: System.out.println("Enter the new alternate email ID:");
						String altEmail = in.nextLine();
						st1.setAlternateEmail(altEmail);
						break;
				case 3: System.out.println("Enter the new inbox capacity:");
						int capacity = in.nextInt();
						st1.setInboxCapacity(capacity);
						break;
				default: System.out.println("Incorrect choice!");
						break;
				}
				System.out.println("Do you want to make more changes?(Press 0 for yes and 1 for no)");
				exitChoice = in.nextInt();
			}
			System.out.println(st1.display());

		}
		
	}

}
