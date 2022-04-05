package Project;
import java.util.*;
import java.io.*;
public class HomePage {
	public static void main(String[] args) {
		int option=0;
		
		File file = new File("C:\\Users\\Hari\\Desktop\\Project\\Companylockers1");
		File[] listoffiles = file.listFiles();
		List<File> arrayoffiles = Arrays.asList(listoffiles);
		do
			{
			System.out.println("Company Lockers Ltd");
			System.out.println("Select an option from the menu\n\t1. Display all files\n\t2. Business level operations\n\t3. Exit");
			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();
			
			switch (option) {
			//Option 1 to view files
				case 1: {
					
					Collections.sort(arrayoffiles);
					for (int i = 0; i < listoffiles.length; i++) 
						{
					  		if (listoffiles[i].isFile()) 
					  		{
					  			System.out.println("File " + listoffiles[i].getName());
					  		} 
						}
						break;
					}
			
			
			//Option 2 to modify files
				case 2: {
					int option2=0;
					do {
					System.out.println("Select an option from the menu\n\t1. Add a new file\n\t2. Delete a file\n\t3. Search for a file\n\t4. Retun to Main Menu");
					option2 = sc.nextInt();
					
			//Option to create a file
					if(option2==1) {
						FileOutputStream inputfile =  null;
						try {
						
							System.out.println("Enter the name of the file");
							String newfilename = sc.next();
							inputfile=new FileOutputStream(newfilename,true);
							
						}catch(IOException e){
							System.out.println("error");
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
							String DeletefileName= sc.next();
							for(File i:listoffiles) {
								if(i.getName().equals(DeletefileName))
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
						}else {
							System.out.println("invalid input");
						}
					}while(option2!=4);
					break;
				}
			//Option to navigate back to main menu
				case 3:
				{
					break;
				}
				default : {
					System.out.println("Invalid input");
				}
			}
			}while(option!=3);
	
		}
	}
