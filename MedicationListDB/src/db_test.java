import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class db_test {

	static int id;
	
	public static void main(String[] args) {
		DButil util = new DButil();
		util.connect();
		ResultSet rs = util.select("SELECT * FROM Patient");
		try {
			while (rs.next()) {
				id = rs.getInt("patientId");
				System.out.println(rs.getInt("patientId") + ", " + rs.getString("lastName") + ", " + rs.getString("firstName") +", "+ rs.getString("middleInitial") + ", "
						+ rs.getString("email") +", "+ rs.getString("password") + ", " + rs.getString("address") + ", " + rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		util.closeRS();
		
		System.out.println("Would you like to add a new patient to the list? (y/n)");
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		if (in.equalsIgnoreCase("y")) {
			id++;
			util.insert(id, "Smith", "Agent", "M", "smith@gmail.com", "password", "123 address road, New York, NY", "456-123-9876", "");
		}
		
		System.out.println("Would you like to delete a patient from the list? (y/n)");
		//scan = new Scanner(System.in);
		in = scan.nextLine();
		if (in.equalsIgnoreCase("y")) {
			System.out.println("Give the ID of the patient you would like to delete: ");
			in = scan.nextLine();
			int choice = Integer.parseInt(in);
			util.delete(choice);
		}
		
		System.out.println("Would you like to update a patient's records? (y/n)");
		in = scan.nextLine();
		if (in.equalsIgnoreCase("y")) {
			System.out.println("Give the ID of the patient you would like to update: ");
			in = scan.nextLine();
			int id_choice = Integer.parseInt(in);
			
			System.out.println("Which section would you like to update?\n" + 
			"1. Last Name\n" +
			"2. First Name\n" +
			"3. Middle Initial\n" +
			"4. Email\n" +
			"5. Password\n" +
			"6. Address\n" + 
			"7. Phone");
			in = scan.nextLine();
			int update_choice = Integer.parseInt(in);
			
			System.out.println("Make you selected change:");
			String change = scan.nextLine();
			util.update(id_choice, update_choice, change);
			
		}
		
		
		util.close();
	  }
	}


