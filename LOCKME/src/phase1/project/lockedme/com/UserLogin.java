package phase1.project.lockedme.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;
public class UserLogin {

	//viewEntry method()
	
	public static void viewEntry(){
		Scanner fileEntry=new Scanner(System.in);
		System.out.println("Enter the file name with extension you wish to view: ");
		String filename=fileEntry.nextLine();
		File fileobj=new File("D:\\LockedMeTest\\"+filename);
		try {
			if(fileobj.exists()) {
				Scanner filereader=new Scanner(fileobj);
				while(filereader.hasNext()) {
					System.out.println(filereader.next());
				}
				System.out.println();
				System.out.println("Press 0 to return to the main menu: ");
				byte space=fileEntry.nextByte();
				if(space==0) {
					SaveAccDetails();
				}
			}
			else {
				throw new Exception();
				}
		}
		catch(IOException e) {
			System.out.println("An error has occured");
		} catch (Exception e) {
			System.out.println("File with name "+filename+ " not found");
		}
		
		}
	
	
	//createFile method()
	
	public static void createFile() {
		Scanner fileEntry1=new Scanner(System.in);
		FileOutputStream fileobj=null;
		System.out.println("File name with extension: ");
		String filename=fileEntry1.nextLine();
		System.out.print("Website: ");
		String website=fileEntry1.nextLine();
		System.out.print("Username: ");
		String username=fileEntry1.nextLine();
		System.out.print("Password: ");
		String password=fileEntry1.nextLine();
		String comp=website.concat("\n").concat("Username:").concat(username).concat("\n").concat("Password:").concat(password);
		try {
				fileobj=new FileOutputStream("D:\\LockedMeTest\\"+filename);
				fileobj.write(comp.getBytes());
			}
		catch(IOException e) {
			System.out.println("An error has occured");
			e.printStackTrace();
		}
		finally
		{
			try {
				fileobj.close();
			} catch (IOException e) {e.printStackTrace();	}
		}
		System.out.println("Do you wish to make a new entry: Y/N");
		String ans=fileEntry1.nextLine();
		if(ans.equalsIgnoreCase("Y")){
			newEntry();
		}
		else {
			homepage();
		}
	}
	
	//existingFile method()
	
	public static void existingFile() {
	
		Scanner fileEntry2=new Scanner(System.in);
		FileOutputStream fileobj=null;
		System.out.println("File name with extension: ");
		String filename=fileEntry2.nextLine();
		File file=new File("D:\\LockedMeTest\\"+filename);
		if(file.exists())
		{
		System.out.print("Website: ");
		String website=fileEntry2.nextLine();
		System.out.print("Username: ");
		String username=fileEntry2.nextLine();
		System.out.print("Password: ");
		String password=fileEntry2.nextLine();
		String comp="\n".concat(website).concat("\n").concat("Username:").concat(username).concat("\n").concat("Password:").concat(password);
		try {
				fileobj=new FileOutputStream("D:\\LockedMeTest\\"+filename,true);
				fileobj.write(comp.getBytes());
			}
		catch(IOException e) {
			System.out.println("An error has occured");
			e.printStackTrace();
		}
		finally
		{
			try {
				fileobj.close();
			} catch (IOException e) {e.printStackTrace();
			}
		}
		}
		else {
			System.out.println("File with name "+filename+ " not found");
			System.out.println("Do you wish to create a file: Y/N");
			String answer=fileEntry2.nextLine();
			if(answer.equalsIgnoreCase("Y"))
			{
				createFile();
			}
			
		}
		System.out.println("Do you wish to make a new entry: Y/N");
		String ans=fileEntry2.nextLine();
		if(ans.equalsIgnoreCase("Y")){
			newEntry();
		}
		else
		{
			homepage();
		}
	}
	
	
	//deleteFile method()
	
	public static void deleteFile() {
		Scanner fileEntry=new Scanner(System.in);
		System.out.println("File name with extension: ");
		String filename3=fileEntry.nextLine();
		File fileobj3=new File("D:\\LockedMeTest\\"+filename3);
		if(fileobj3.exists()) {
		fileobj3.delete();
		System.out.println("File Deleted");}
		else {
			System.out.println("File not found");
		}
	}
	
	//newEntry method()
	
	public static void newEntry() {
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("=======Password Repository=======");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		Scanner fileEntry=new Scanner(System.in);
	
	System.out.println("1. Create File");
	System.out.println("2. Use existing file");
	System.out.println("3. Delete File");
	byte entry=fileEntry.nextByte();
	switch(entry) {
	case 1: createFile();
				break;
	case 2: existingFile();
					break;
	case 3: deleteFile();
				break;
		default: System.out.println("Invalid Input");
	}
				
	}
	
	
	//SaveAccDetails method()
	
	public static void SaveAccDetails() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("=======Password Repository=======");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("Enter your choice");
		System.out.println("1. New Entry");
		System.out.println("2. View Entry");
		System.out.println("3. Home Page");
		Scanner input=new Scanner(System.in);
		byte choice=input.nextByte();
		
		switch(choice) {
		case 1:	newEntry();
					break;
		case 2: viewEntry();
					break;
		case 3: homepage();
		default: System.out.println("Invalid choice");
		}
	}

	//readFromFile_Reg method()
	public static void readFromFile_Reg() throws Exception  {
		int count=0;
		TreeMap<String, String> map=new TreeMap<String, String>();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("=======Password Repository=======");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("User Name: "); 
		
		InputStreamReader read=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(read);
		
		String pass=null;
		String username=null;
		try {
			username = br.readLine();
			System.out.print("Password: ");
			pass=br.readLine();
			} catch (IOException e2) { e2.printStackTrace();	}
		
		
		FileInputStream inp=new FileInputStream("D:\\LockedMeTest\\RegistrationDB.txt");
		BufferedReader br1=new BufferedReader(new InputStreamReader(inp));
		String line=null;
			line = br1.readLine();
				
			while(line !=null) {
				String [] split=line.split(",");
				map.put(split[0],split[1]);
				try {
					line=br1.readLine();
					} catch (IOException e) {e.printStackTrace();	}
				}
			try {
			String passWord=map.get(username);
				if(passWord.equals(pass)) {
				count=1;}
				else
				{
					System.err.println("Invalid username or password");
					System.out.println();
						readFromFile_Reg();
					}
					
				}
				catch(NullPointerException e) {
					System.err.println("Invalid username or password");
					System.out.println();
					readFromFile_Reg();
					}
			if(count==1) {
				System.out.println("Login Success");
				SaveAccDetails();
			}
	}
	
	
	
	
	//userInput_Reg method()
public static void userInput_Reg() {
		
		String username;
		String password;
		
		TreeMap<String, String> map=new TreeMap<String, String>();
		Scanner input=new Scanner(System.in);
				
				//Taking user details		
				
				System.out.print("User Name: ");
				username=input.nextLine();
				System.out.println();		
				System.out.println("Enter an 8 character alphanumeric code");		
				System.out.print("Password: ");
				password=input.nextLine();
				if(Pattern.matches("[a-zA-Z0-9]{8}", password)) {		//Implementing regex to attain the desired pattern of password
				map.put("Username", "Password");
				map.put(username, password);}
				else {
					System.out.println("Invalid password, try again");
					userInput_Reg();		//calling the userInput_Reg method()
				}
				
				String t=username.concat(",").concat(password);
				List<String> list=Arrays.asList(t);
				
				Charset utf8=StandardCharsets.UTF_8;
				File dir=new File("D:\\LockedMeTest\\");
				boolean b=dir.mkdir();
				try {
						Files.write(Paths.get("D:\\LockedMeTest\\RegistrationDB.txt"), list , utf8 , StandardOpenOption.CREATE, StandardOpenOption.APPEND);
				SaveAccDetails();
				}
				catch(NoSuchFileException e ) {System.out.println("Sorry, create a folder LockedMeTest in 'D' drive");}
				catch(IOException e){e.printStackTrace();}
				
				
	}
	
	
	//homepage method()
	public static void homepage() {
		System.out.println();
		System.out.println("Press '1': Sign Up for New Registration");
		System.out.println("Press '2': Sign In to Login");
		System.out.println("Press '3': Logout");
		
		System.out.print("Please Enter your Choice:  ");  //Taking user choice of menu
		Scanner input=new Scanner(System.in);
		byte choice=input.nextByte();
		
		try {
		switch(choice) {					//Switch case to implement choice
		case 1: System.out.println("Welcome to Registration Portal");
						userInput_Reg(); 	//calling the userInput_Reg method()
						break;
		case 2: System.out.println("Welcome Back");
						readFromFile_Reg();		//calling the readFromFile_Reg method()
							break;
		case 3: System.exit(choice);
					
		default: System.out.println("INVALID CHOICE");
		}
		}
		catch(Exception e) {}
	
	}
	
	//main method()
	public static void main(String[] args) {
		
		System.out.println("********************************************************");
		System.out.println("~~~~~~~~~~~~~LockedMe.com~~~~~~~~~~~~");
		System.out.println("~~~~~~~your security our responsibility~~~~~~~~");
		System.out.println("********************************************************");
		homepage();		//calling the homepage method()
}
}
