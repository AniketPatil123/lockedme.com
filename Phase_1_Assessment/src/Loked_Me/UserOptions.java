package Loked_Me;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserOptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path="E:\\ani2\\Phase 1_ Assesment\\Loked_Me";
		Scanner sc=new Scanner(System.in);
		boolean success=false;
		System.out.println("********************************");
		System.out.println("********************************");
		System.out.println("-------- LockEdME.com ----------");
		System.out.println("--Company Lockers Pvt. Limited--");
		System.out.println("---------  DEVELOPER -----------");
		System.out.println("--------  ANIKET PATIL  --------");
		System.out.println("********************************");
		System.out.println("********************************\n");
		System.out.println("Virtual key for repositories :\n");
		int flag=0;
		int choice =1;
		
		while(choice<4 && choice>0) {
			System.out.println("Enter your choice : ");
			System.out.println("1. Get the all files present in the directory");
			System.out.println("2. Enter your choice regarding file operation");
			System.out.println("3. Close the application");
			choice=sc.nextInt();
			
			if(choice ==3)
				break;
			
			switch(choice){
			
			case 1:
				System.out.println("Get the all files present in the directory");
				File directoryPath=new File("E:\\ani2\\Phase 1_ Assesment\\Loked_Me");
				File[] fileList=directoryPath.listFiles();
				List<String> files=new ArrayList<String>();
				for(File iterator:fileList) {
					files.add(iterator.getName());
				}
				Collections.sort(files);
				System.out.println("All file details :\n");
				for(File file:fileList) {
					System.out.println("File name: "+file.getName());
					System.out.println("File path: "+file.getAbsolutePath());
					System.out.println("File size: "+file.getTotalSpace());
					System.out.println(" ");
				}
				System.out.println("All files in a ascending order : ");
				for(String names: files) {
					System.out.println(names);
				}
				break;
				
			case 2:
				
				int opschoice=1;
				while(opschoice<4 && opschoice>0) {
					System.out.println("Enter your choice regarding file operation");
					System.out.println("1. Add file to existing directory ");
					System.out.println("2. Delete user specified file from directory");
					System.out.println("3. Search user specified file from the directory");
					System.out.println("4. Come back to the main menu");
					opschoice=sc.nextInt();
					
					if(opschoice==4)
						break;
					
					switch(opschoice) {
					
					case 1:
						System.out.println("Adding  file to existing directory ");
						System.out.println("Enter the name of file to be added :");
						String name=sc.next();
						File f=new File(path+"\\"+name);
						if(f.exists())
							System.out.println("File already exists");
						else {
							try {
								success=f.createNewFile();
								if(success)
									System.out.println("file created successfully");
								else
									System.out.println("File not created");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
								System.out.println("Not able to craete a file");
							}
							
						}
						break;
						
					case 2:
						System.out.println("Delete user specified file from directory");
						System.out.println("Enter the name of file to be deleted :");
						String name1=sc.next();
						File f1=new File(path+"\\"+name1);
						if(f1.delete()) {
							System.out.println(f1.getName()+" deleted");
						}
						else {
							System.out.println("failed");
						}
						break;
						
					case 3:
						System.out.println("Search user specified file from the directory");
						System.out.println("Enter the name of file to be searched :");
						String name2=sc.next();
						
						File dirPath=new File("E:\\ani2\\Phase 1_ Assesment\\Loked_Me");
						File[] filelist=dirPath.listFiles();
						List<String> lists=new ArrayList<String>();
						for(File iterator:filelist) {
							lists.add(iterator.getName());
						}
						Collections.sort(lists);
						
						for(String names: lists) {
							if(names.equals(name2)) {
							System.out.println(names+ " File found in directory");
							flag=1;
							break;
							}
							
						}
						if(flag==0)
							System.out.println("File not found");
						
						break;
						
					default: 
						System.out.println("Wrong choice");
						break;
					}
				}
				
				break;
				
				default:
					System.out.println("Wrong choice");
					break;
			
		
			}
		}
		
		System.out.println("You are out of the application..................");
	}

}
