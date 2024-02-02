package secureCoding;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;



public class HealthClinic {
    public static void main(String[] args) {
    	
    	Scanner In= new Scanner(System.in);
    	System.out.println("Enter username");
		String username=In.nextLine();
		System.out.println("Enter Password");
		String password=In.nextLine();
		
		String hashpass=getHash(password);
    	System.out.println("1. Login as Registrar");
		System.out.println("2. Login as Doctor");
		System.out.println("3. Login as Patient");
    	int option = In.nextInt();
    	
    	
    	
		switch(option) {
		case 1:
			if(isRegLog(username,hashpass))
			{
				System.out.println("Logged in Successfully");
			}
			else
			{
				System.out.println("Incorrect Username or Password");
			}
			break;
		case 2:
			if(isDoctorLog(username, hashpass))
			{
				System.out.println("Logged in Successfully");
			}
			else
			{
				System.out.println("Incorrect Username or Password");
			}
			break;
		case 3:
			if(isPatientLog(username, hashpass))
			{
				System.out.println("Logged in Successfully");
			}
			else
			{
				System.out.println("Incorrect Username or Password");
			}
			break;
			default:
				System.out.println("Invalid input");
				break;
				
		}
    }
    
    public static boolean isRegLog(String adminUsername, String hashedPassword) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(
					new FileReader("C:\\Users\\User\\eclipse-workspace\\finalSC\\Registrar.txt"));

			String line;
			while ((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				if (columns.length >= 2 && columns[0].equalsIgnoreCase(adminUsername)
						&& columns[1].equals(hashedPassword)) {
					return true;
				}
			}
		} catch (IOException e) {
			System.err.println("Error while reading file");

		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.err.println("Error closing the reader");
			}
		}
		return false;
	}
    
    public static boolean isDoctorLog(String adminUsername, String hashedPassword) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(
					new FileReader("Doctor.txt"));

			String line;
			while ((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				if (columns.length >= 2 && columns[0].equalsIgnoreCase(adminUsername)
						&& columns[1].equals(hashedPassword)) {
					return true;
				}
			}
		} catch (IOException e) {
			System.err.println("Error while reading file");

		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.err.println("Error closing the reader");
			}
		}
		return false;
	}
    
    public static boolean isPatientLog(String adminUsername, String hashedPassword) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(
					new FileReader("Patient.txt"));

			String line;
			while ((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				if (columns.length >= 2 && columns[0].equalsIgnoreCase(adminUsername)
						&& columns[1].equals(hashedPassword)) {
					return true;
				}
			}
		} catch (IOException e) {
			System.err.println("Error while reading  file");

		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.err.println("Error closing the reader");
			}
		}
		return false;
	}
    
    public static String getHash(String value) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			result = encode(md.digest(value.getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException e) {
			System.err.println("The Algorithm doesn't exist");
		}
		return result;
	}

    public static String encode(byte[] data) {
		return Base64.getEncoder().encodeToString(data);
	}
}