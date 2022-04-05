import java.util.*;
import java.io.*;
public class CompanyLockers {
	public static void main(String[] args) {
		int option=0;
	
		File file = new File("C:\\Users\\Hari\\Desktop\\LockedMe.com\\CompanyLockers");
		File[] listoffiles = file.listFiles();
		List<File> arrayoffiles = Arrays.asList(listoffiles);
		do
			{
			System.out.println("Company Lockers Ltd");
			System.out.println("Developed by Srihari K\t Email:srihari16@gmail.com");
			System.out.println("Select an option from the menu\n\t1. Display all files\n\t2. Business level operations\n\t3. Exit");
			Scanner sc = new Scanner(System.in);
			try {
				
				option = sc.nextInt();
				if(option>3) {
					System.out.println("Invalid Input");
				}
			}catch(InputMismatchException e)
			{
				System.out.println("Invalid Input");
			}
			
			switch (option) {
			//Option 1 to view files
				case 1: {
					int count=1;
					Collections.sort(arrayoffiles);
					for (int i = 0; i < listoffiles.length; i++) 
						{
					  		if (listoffiles[i].isFile()) 
					  		{
					  			System.out.println(count+". "+listoffiles[i].getName());
					  			count++;
					  		} 
						}
						break;
					}
			
			
			//Option 2 to modify files
				case 2: {
					int option2=0;
					do {
						
					System.out.println("Select an option from the menu\n\t1. Add a new file\n\t2. Delete a file\n\t3. Search for a file\n\t4. Retun to Main Menu");
					sc = new Scanner(System.in);
					try {
						
						option2 = sc.nextInt();
						if(option>4) {
							System.out.println("Invalid Input");
						}
					}catch(InputMismatchException e)
					{
						System.out.println("Invalid Input");
					}
					
			//Option to create a file
					if(option2==1) {
						FileOutputStream inputfile =  null;
						try {
						
							System.out.println("Enter the name of the file");
							String newfilename = sc.next();
							inputfile=new FileOutputStream(newfilename,true);
							System.out.println("File Succesfully created");
							
						}catch(IOException e){
							System.out.println("Error occured");
						}finally {
						}
							if(inputfile != null) {
								try {
									inputfile.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
						else if(option2==2)
						{	
			//Option to delete a file
							boolean deleteflag=false;
							System.out.println("Enter the name of the file to be deleted");
							String DeleteFileName= sc.next();
							for(File i:listoffiles) {
								if(i.getName().equals(DeleteFileName))
								{
									deleteflag=i.delete();
									System.out.println("Deleted file "+i.getName());
								}
								}
							if(!deleteflag)
							{
								System.out.println("File Not Found");
							}
							
						}else if(option2==3)
						{
			//Option to search for a file
							
							System.out.println("Enter the name of the file");
							int flag=0;
							String filename= sc.next();
							String[] filenamestring = file.list();
							for(int i=0; i<filenamestring.length;i++) {
								if(filename.equals(filenamestring[i])) {
									System.out.println(filename + "found");
								flag=1;
								}
							}
							if(flag==0)
							{
								System.out.println("File Not found");
							}
						}else if(option2==4)
						{
							break;
						}
					}while(option2!=4);
					break;
				}
			//Option to navigate back to main menu
				case 3:
				{
					break;
				}
				
			}
			}while(option!=3);
	
		}
	}
