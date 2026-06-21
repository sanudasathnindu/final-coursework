import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;




class iFRIEND{
	///////////////GLOBAL VARIABLE///////////////
	public static String[] contactID=new String[0];
	public static String[] name=new String[0];
	public static String[] phoneNumber=new String[0];
	public static String[] companyName=new String[0];
	public static double[] salary=new double[0];
	public static String[] birthDay=new String[0];
	//////////////////////////////////////////////
	
	public final static void clearConsole(){
		try {   
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
			}else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	public static  String genarateContactID(int ID){
		String contact_ID=String.format("C%04d",ID);
		
		return contact_ID;
	}
	
	public static void extendArrays(String ID,String Name,String p_NO,String company_Name,double Salary,String bDay){
		String[] tempContactID=new String[contactID.length+1];
		String[] tempName=new String[name.length+1];
		String[] tempPhoneNumber=new String[phoneNumber.length+1];
		String[] tempCompanyName=new String[companyName.length+1];
		double[] tempSalary=new double[salary.length+1];
		String[] tempBirthDay=new String[birthDay.length+1];
		
		for(int i = 0 ; i < name.length ; i++){
			tempContactID[i]=contactID[i];
			tempName[i]=name[i];
			tempPhoneNumber[i]=phoneNumber[i];
			tempCompanyName[i]=companyName[i];
			tempSalary[i]=salary[i];
			tempBirthDay[i]=birthDay[i];
		}
		
		contactID=tempContactID;
		contactID[contactID.length-1]=ID;
		
		name=tempName;
		name[name.length-1]=Name;
		
		phoneNumber=tempPhoneNumber;
		phoneNumber[phoneNumber.length-1]=p_NO;
		
		companyName=tempCompanyName;
		companyName[companyName.length-1]=company_Name;
		
		salary=tempSalary;
		salary[salary.length-1]=Salary;
		
		birthDay=tempBirthDay;
		birthDay[birthDay.length-1]=bDay;
		
		
	}
	
	public static boolean checkPhoneNumber(String p_NO){
		if(p_NO.length()!=10 || p_NO.charAt(0)!='0'){
			return true;
		}
		return false;
	}
	
	public static boolean checkSalary(double salary){
		return salary < 0 ?true:false;
	}
	
	public static boolean checkBirthDay(String bDay){
		try{
			LocalDate birthday=LocalDate.parse(bDay);
			LocalDate currentDate=LocalDate.now();
			
			int birthYear=birthday.getYear();
			int currentYear=currentDate.getYear();
			
			if(birthYear < 1900 || birthYear > currentYear){
				return false;
			}
			
			return true;
			
		}catch(DateTimeParseException e){
			return false;
		}
			
	}
	
	public static void addContacts(){
		Scanner input=new Scanner(System.in);
		
		int contact_ID=1;
		
		do{
			System.out.println("+-----------------------------------------------+");
			System.out.println("|\t   Add Contact to the list  \t\t|");
			System.out.println("+-----------------------------------------------+");
			System.out.println('\n');
			
			String ID =genarateContactID(contact_ID);
			System.out.println(ID);
			System.out.println("=======");
			System.out.println();
			
			System.out.print("Name              : ");
			String name=input.next();

			System.out.print("Phone Number      : ");
			String p_NO=input.next();
		
		//////////CHECK PHONE NUMBER//////////	
		L1:	do{	
				if(checkPhoneNumber(p_NO)){
			
				System.out.println();
				System.out.println("\tInvalid phone number...");
				System.out.println();
						
				System.out.print("Do you want to add phone number again (Y/N): ");
				char subADD=input.next().charAt(0);
				System.out.println();
				subADD=Character.toLowerCase(subADD);
				
					
					if(subADD=='y'){
						System.out.print("\033[6A");
						System.out.print("\033[0J");
						
						System.out.print("Phone Number      : ");
						p_NO=input.next();			
					}else{
						System.out.print("\033[6A");
						System.out.print("\033[0J");
						System.out.println("Phone Number      : Not insert...");
						p_NO="";
						break L1;
					}
				}
			}while(checkPhoneNumber(p_NO));
		///////////////////////////////////////
			
			System.out.print("Company Name      : ");
			String company_Name=input.next();
				
			System.out.print("Salary            : ");
			double Salary=input.nextDouble();
			
		//////////CHECK SALARY//////////	
		L2:	do{
				if(checkSalary(Salary)){
					System.out.println();
					System.out.println("\tInvalid Input...");
					System.out.println();
					
					System.out.print("Do you want to add salary again (Y/N): ");
					char subSalary=input.next().charAt(0);
					subSalary=Character.toLowerCase(subSalary);
					
					if(subSalary=='y'){
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						
						System.out.print("Salary            : ");
						Salary=input.nextDouble();
					}else{
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						System.out.println("Salary            : Not insert...");
						Salary=0;
						break L2;
					}
				}
			}while(checkSalary(Salary));
		/////////////////////////////////
				
			System.out.print("B'Day(YYYY-MM-DD) : ");
			String bDay=input.next();
			
		//////////CHECK BIRTHDAY//////////
		L3:	do{
				if(checkBirthDay(bDay)){
					break L3;
				}else{
					System.out.println();
					System.out.println("\tInvalid Birthday...");
					System.out.println();
					
					System.out.print("Do you want to input birthday again (Y/N): ");
					char subBDay=input.next().charAt(0);
					subBDay=Character.toLowerCase(subBDay);
					
					if(subBDay=='y'){
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						
						System.out.print("B'Day(YYYY-MM-DD) : ");
						bDay=input.next();
					}else{
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						System.out.print("B'Day(YYYY-MM-DD) : Not insert");
						bDay="";
						break L3;
					}
				}
					
			}while(!checkBirthDay(bDay));		
		////////////////////////////////////
			
			extendArrays(ID,name,p_NO,company_Name,Salary,bDay);
			contact_ID++;
			
			System.out.println();
			System.out.println("\tContact has been added successfully...");
			System.out.println('\n');
			
			System.out.print("Do you want to add another contact(Y/N): ");
			char optionADD=input.next().charAt(0);
			optionADD=Character.toLowerCase(optionADD);
			System.out.println('\n');
			
			if(optionADD=='y'){
				clearConsole();
				continue;
			}else{
				clearConsole();
				main(null);
			}
		}while(true);
		
	}
	
	public static int searchContacts(String search){
		for(int i = 0 ;i < name.length ; i++){
			if(search.equals(name[i]) | search.equals(phoneNumber[i])){
				return i;
			}
		}
		return -1;
	}
	
	public static void displayContact(int i){
		if(i !=-1){
			System.out.println("\tContact ID        : "+contactID[i]);
			System.out.println("\tName              : "+name[i]);
			System.out.println("\tPhone Number      : "+phoneNumber[i]);
			System.out.println("\tCompany Name      : "+companyName[i]);
			System.out.println("\tSalary            : "+salary[i]);
			System.out.println("\tB,Day(YYYY-MM-DD) : "+birthDay[i]);
		}
	}
	
	public static void updateContacts(){
		Scanner input=new Scanner(System.in);
		
		do{
			System.out.println("+-----------------------------------------------+");
			System.out.println("|\t\t UPDATE Contact \t\t|");
			System.out.println("+-----------------------------------------------+");
			System.out.println('\n');
		
			System.out.print("Search Contact by  Name or Phone Number - ");
			String search=input.next();
			System.out.println('\n');
			
			int index=searchContacts(search);
		//	int temp=searchContacts(search);

			displayContact(index);
			
			try{Thread.sleep(500);}catch(Exception e){}
			
			if(index==-1){
				System.out.println("\tNo results found...");
				System.out.println('\n');
				
				try{Thread.sleep(800);}catch(Exception e){}
				
				System.out.print("Do you want to search contact again(Y/N): ");
				char subUpdate=input.next().charAt(0);
				subUpdate=Character.toLowerCase(subUpdate);
				if(subUpdate=='y'){
					clearConsole();
					continue;
				}else{
					clearConsole();
					main(null);
				}
			}
			
			System.out.println('\n');
			System.out.println("what do you want to update...");
			System.out.println();
			System.out.println("\t[01]Name");
			System.out.println("\t[02]Phone Number");
			System.out.println("\t[03]Company Name");
			System.out.println("\t[04]Salary");
			System.out.println('\n');
			System.out.print("Enter an option to continue -> ");
			int optionUpdate=input.nextInt();
			System.out.println('\n');
		
			System.out.print("\033[11A");
			System.out.print("\033[0J");
			
			switch (optionUpdate){
				//////////UPDATE NAME//////////
				case 1: 
				System.out.println("Update Name");
				System.out.println("============");
				System.out.println();
				
				System.out.print("Input new name - ");
				name[index]=input.next();
				System.out.println('\n');
				
				System.out.println("\tContact has been update succesfully...");
				System.out.println('\n');
				break;
				//////////UPDATE PHONE NUMBER//////////
				case 2: 
				System.out.println("Update Phone Number");
				System.out.println("====================");
				System.out.println();
				
				System.out.print("Input new Phone Number - ");
				String p_NO=input.next();
					//////////CHECK PHONE NUMBER IN UPDATE//////////
			L4 :do{
					if(checkPhoneNumber(p_NO)){
					System.out.println('\n');
					System.out.println("\tInvalid phone number...");
					System.out.println('\n');
					
					System.out.print("Do you want to add phone number again (Y/N): ");
					char subUpdateP_NO=input.next().charAt(0);
					subUpdateP_NO=Character.toLowerCase(subUpdateP_NO);
					if(subUpdateP_NO=='y'){
						System.out.print("\033[7A");
						System.out.print("\033[0J");
						
						System.out.print("Input Phone Number - ");
						p_NO=input.next();

					}else{
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						System.out.println("Input Phone Number - not update...");
						
						break L4;
					}
					}
				}while(checkPhoneNumber(p_NO));
				
				if(!checkPhoneNumber(p_NO)){
					phoneNumber[index]=p_NO;
				}else{
					phoneNumber[index]=phoneNumber[index];
				}
				
				System.out.println('\n');
				System.out.println("\tContact has been update succesfully...");
				System.out.println('\n');
				break;
				
				//////////UPDATE COMPANY NAME//////////
				case 3: 
				System.out.println("Update Company Name");
				System.out.println("=====================");
				System.out.println();
				
				System.out.print("Input new company name - ");
				companyName[index]=input.next();
				System.out.println('\n');
				
				System.out.println("\tContact has been update succesfully...");
				System.out.println('\n');
				break;
				
				//////////UPDATE SALARY//////////
				case 4: 
				System.out.println("Update Salary");
				System.out.println("==============");
				System.out.println();
				
				System.out.print("Input new salary - ");
				double Salary=input.nextDouble();
					//////////CHECK SALARY IN UPDATE//////////
			L5:	do{
					if(checkSalary(Salary)){
						System.out.println();
						System.out.println("\tInvalid Salary...");
						System.out.println();
						
						System.out.print("Do you want to input Salary again (Y/N): ");
						char subUpdateSalary=input.next().charAt(0);
						subUpdateSalary=Character.toLowerCase(subUpdateSalary);
						if(subUpdateSalary=='y'){
							System.out.print("\033[5A");
							System.out.print("\033[0J");
							
							System.out.print("Input new salary - ");
							Salary=input.nextDouble();
						}else{
							System.out.print("\033[5A");
							System.out.print("\033[0J");
							System.out.println("Input Salary - not update...");
							break L5;
						}
					}
				}while(checkSalary(Salary));	
				
				salary[index]=Salary;
				System.out.println('\n');
				
				System.out.println("\tContact has been update succesfully...");
				System.out.println('\n');
				break;
				
				default:System.out.println("\tInvalid option...");
			}
			
			System.out.print("Do you want to update another Contact (Y/N) : ");
			char subUpdate=input.next().charAt(0);
			if(subUpdate=='y'){
				clearConsole();
				continue;
			}else{
				clearConsole();
				main(null);
				return ;
			}
		}while(true);
	}
	
	public static void reduceArrays(int index){
		String[] tempContact=new String[contactID.length-1];
		String[] tempName=new String[name.length-1];
		String[] tempPhoneNumber=new String[phoneNumber.length-1];
		String[] tempCompanyName=new String[companyName.length-1];
		double[] tempSalary=new double[salary.length-1];
		String[] tempBDay=new String[birthDay.length-1];
		
		for (int i = index; i < name.length-1; i++){
			contactID[i]=contactID[i+1];
			name[i]=name[i+1];
			phoneNumber[i]=phoneNumber[i+1];
			companyName[i]=companyName[i+1];
			salary[i]=salary[i+1];
			birthDay[i]=birthDay[i+1];			
		}
		
		for (int j = 0; j < name.length -1; j++){
			tempContact[j]=contactID[j];
			tempName[j]=name[j];
			tempPhoneNumber[j]=phoneNumber[j];
			tempCompanyName[j]=companyName[j];
			tempSalary[j]=salary[j];
			tempBDay[j]=birthDay[j];			
		}
		
		contactID=tempContact;
		name=tempName;
		phoneNumber=tempPhoneNumber;
		companyName=tempCompanyName;
		salary=tempSalary;
		birthDay=tempBDay;
		
	}
	
	public static void deleteContacts(){
		Scanner input=new Scanner(System.in);
		
	L6:	do{
			System.out.println("+-----------------------------------------------+");
			System.out.println("|\t\t DELETE Contact \t\t|");
			System.out.println("+-----------------------------------------------+");
			System.out.println('\n');
	
			System.out.print("Search Contact by  Name or Phone Number - ");
			String search=input.next();
			System.out.println('\n');
			
			int index=searchContacts(search);

			displayContact(index);
	//		System.out.println('\n');
			
			if(index==-1){
				System.out.println("\t No results found...");
				System.out.println('\n');
				
				try{Thread.sleep(500);}catch(Exception e){}
				
				System.out.print("Do you want to search contact again (Y/N): ");
				char subUpdate=input.next().charAt(0);
				subUpdate=Character.toLowerCase(subUpdate);
				if(subUpdate=='y'){
					clearConsole();
					continue;
				}else {
					clearConsole();			
					main(null);
				}
			}
			
			System.out.println('\n');
			System.out.print("Do you want to delete this Contact (Y/N): ");
			char subDelete=input.next().charAt(0);
			subDelete=Character.toLowerCase(subDelete);
			System.out.println();
			
			if(subDelete=='y'){
				reduceArrays(index);
				
				try{Thread.sleep(100);}catch(Exception e){}
				
				System.out.println("\tContact has been deleted successfuly...");
				System.out.println('\n');
				
				try{Thread.sleep(200);}catch(Exception e){}
				
			}else {
				System.out.println("\tNot deleted...");
				System.out.println('\n');
				
				try{Thread.sleep(200);}catch(Exception e){}
			}
			
			System.out.print("Do you want to delete another Contact(Y/N): ");	
			char optionDelete=input.next().charAt(0);
			System.out.println();
			optionDelete=Character.toLowerCase(optionDelete);
			if(optionDelete=='y'){
				clearConsole();
				continue;
			}else{
				clearConsole();
				main(null);
				break L6;
			}		
			
		}while(true);	
	}
	
	public static void searchContacts(){
		Scanner input=new Scanner(System.in);

		do{		
			System.out.println("+-----------------------------------------------+");
			System.out.println("|\t\t SEARCH Contact \t\t|");
			System.out.println("+-----------------------------------------------+");
			System.out.println('\n');
		
			System.out.print("Search Contact by Name or Phone Number - ");
			String search=input.next();
			System.out.println();
			
			int index=searchContacts(search);
			if(index == -1){
				System.out.println("\tNo contact found for "+search);
				System.out.println('\n');
				
				try{Thread.sleep(600);}catch(Exception e){}
				
				System.out.print("Do you want to try a new search (Y/N): ");
				char subSearch=input.next().charAt(0);
				subSearch=Character.toLowerCase(subSearch);
				
				if(subSearch=='y'){
					System.out.print("\033[6A");
					System.out.print("\033[0J");
					clearConsole();
					continue;
					
				}else{
					clearConsole();
					main(null);
					break;
				}
			}else {
				displayContact(index);
				try{Thread.sleep(600);}catch(Exception e){}
			}
			
			System.out.println('\n');
			System.out.print("Do you want to search another contact(Y/N): " );
			char optionSearch=input.next().charAt(0);
			optionSearch=Character.toLowerCase(optionSearch);
			System.out.println('\n');
			
			if(optionSearch=='y'){
				clearConsole();
				continue;
			}else{
				clearConsole();
				main(null);
				break;
			}
		}while(true);
		
	}
	
	public static void sortName(){
		Scanner input=new Scanner(System.in);
		
		for(int j=name.length-1 ;j > 0;j--){
			for (int i = 0; i < j; i++){
				if(name[i].charAt(0)>name[(i+1)].charAt(0)){
					String tempID=contactID[i];
					contactID[i]=contactID[i+1];
					contactID[i+1]=tempID;
							
					String tempname=name[i];
					name[i]=name[(i+1)];
					name[(i+1)]=tempname;
					
					String tempP_NO=phoneNumber[i];
					phoneNumber[i]=phoneNumber[i+1];
					phoneNumber[i+1]=tempP_NO;
					
					String tempCompName=companyName[i];
					companyName[i]=companyName[i+1];
					companyName[i+1]=tempCompName;
					
					double tempSalary=salary[i];
					salary[i]=salary[i+1];
					salary[i+1]=tempSalary;
					
					String tempBDay=birthDay[i];
					birthDay[i]=birthDay[i+1];
					birthDay[i+1]=tempBDay;
					
				}

			}
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s  | %-15s |%n","Contact ID","Name","Phone Number","Company","Salary","Birthday");
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		for(int i=0; i < contactID.length;i++){
			System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8.2f | %-15s |\n",contactID[i],name[i],phoneNumber[i],companyName[i],salary[i],birthDay[i]);
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		System.out.println('\n');
		System.out.print("Do you want to go Home Page (Y/N): ");
		char main=input.next().charAt(0);
		main=Character.toLowerCase(main);
		
		if(main=='y'){
			clearConsole();
			main(null);
		}else{
			clearConsole();
			sortContacts();
		}
	}
	
	public static void sortSalary(){
		Scanner input=new Scanner(System.in);
		
		for (int i = salary.length-1; i > 0; i--){
			for (int j = 0; j < i ; j++){
				if(salary[j]>salary[j+1]){
					
					double temp=salary[j];
					salary[j]=salary[(j+1)];
					salary[(j+1)]=temp;
					
					String tempID=contactID[j];
					contactID[j]=contactID[j+1];
					contactID[j+1]=tempID;
					
					String tempname=name[j];
					name[j]=name[(j+1)];
					name[(j+1)]=tempname;
					
					String tempP_NO=phoneNumber[j];
					phoneNumber[j]=phoneNumber[j+1];
					phoneNumber[j+1]=tempP_NO;
					
					String tempCompName=companyName[j];
					companyName[j]=companyName[j+1];
					companyName[j+1]=tempCompName;
					
					String tempBDay=birthDay[j];
					birthDay[j]=birthDay[j+1];
					birthDay[j+1]=tempBDay;
				}
			}
		}
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s  | %-15s |%n","Contact ID","Name","Phone Number","Company","Salary","Birthday");
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		for(int i=0; i < contactID.length;i++){
			System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8.2f | %-15s |\n",contactID[i],name[i],phoneNumber[i],companyName[i],salary[i],birthDay[i]);
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		System.out.println('\n');
		System.out.print("Do you want to go Home Page (Y/N): ");
		char main=input.next().charAt(0);
		main=Character.toLowerCase(main);
		
		if(main=='y'){
			clearConsole();
			main(null);
		}else{
			clearConsole();
			sortContacts();
		}
	}
	
	public static void sortBirthDay(){
		Scanner input=new Scanner(System.in);
			
		for (int j = birthDay.length-1; j > 0 ; j--){
			for (int i = 0; i < j; i++){
				int year_0=Integer.parseInt(birthDay[i].substring(0,4));
				int year_1=Integer.parseInt(birthDay[(i+1)].substring(0,4));
			
				if(year_0>year_1){
					
					String tempYear=birthDay[i];
					birthDay[i]=birthDay[(i+1)];
					birthDay[(i+1)]=tempYear;
					
					String tempID=contactID[i];
					contactID[i]=contactID[i+1];
					contactID[i+1]=tempID;
					
					String tempname=name[i];
					name[i]=name[(i+1)];
					name[(i+1)]=tempname;
					
					String tempP_NO=phoneNumber[i];
					phoneNumber[i]=phoneNumber[i+1];
					phoneNumber[i+1]=tempP_NO;
					
					String tempCompName=companyName[i];
					companyName[i]=companyName[i+1];
					companyName[i+1]=tempCompName;
					
					double tempSalary=salary[i];
					salary[i]=salary[i+1];
					salary[i+1]=tempSalary;
					
				}else if(year_0==year_1){
					int month_0=Integer.parseInt(birthDay[i].substring(5,7));
					int month_1=Integer.parseInt(birthDay[i+1].substring(5,7));

					if(month_0 > month_1){
						
						String tempYear=birthDay[i];
						birthDay[i]=birthDay[i+1];
						birthDay[i+1]=tempYear;
						
						String tempID=contactID[i];
						contactID[i]=contactID[i+1];
						contactID[i+1]=tempID;
						
						String tempname=name[i];
						name[i]=name[(i+1)];
						name[(i+1)]=tempname;
						
						String tempP_NO=phoneNumber[i];
						phoneNumber[i]=phoneNumber[i+1];
						phoneNumber[i+1]=tempP_NO;
						
						String tempCompName=companyName[i];
						companyName[i]=companyName[i+1];
						companyName[i+1]=tempCompName;
						
						double temp=salary[j];
						salary[j]=salary[(j+1)];
						salary[(j+1)]=temp;
					
					} else if(month_0 == month_1){
						int day_0=Integer.parseInt(birthDay[i].substring(8,10));
						int day_1=Integer.parseInt(birthDay[i+1].substring(8,10));

						if(day_0 > day_1){
							
							String tempYear=birthDay[i];
							birthDay[i]=birthDay[i+1];
							birthDay[i+1]=tempYear;
							
							String tempID=contactID[i];
							contactID[i]=contactID[i+1];
							contactID[i+1]=tempID;
							
							String tempname=name[i];
							name[i]=name[(i+1)];
							name[(i+1)]=tempname;
							
							String tempP_NO=phoneNumber[i];
							phoneNumber[i]=phoneNumber[i+1];
							phoneNumber[i+1]=tempP_NO;
							
							String tempCompName=companyName[i];
							companyName[i]=companyName[i+1];
							companyName[i+1]=tempCompName;
							
							double temp=salary[j];
							salary[j]=salary[(j+1)];
							salary[(j+1)]=temp;
						}
					}
			
				}
			}	
		}
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s  | %-15s |%n","Contact ID","Name","Phone Number","Company","Salary","Birthday");
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		for(int i=0; i < contactID.length;i++){
			System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8.2f | %-15s |\n",contactID[i],name[i],phoneNumber[i],companyName[i],salary[i],birthDay[i]);
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		System.out.println('\n');
		System.out.print("Do you want to go Home Page (Y/N): ");
		char main=input.next().charAt(0);
		main=Character.toLowerCase(main);
		
		if(main=='y'){
			clearConsole();
			main(null);
		}else{
			clearConsole();
			sortContacts();
		}
	}
	
	public static void sortContacts(){
		Scanner input=new Scanner(System.in);
		
		System.out.println("+------------------------------------+");
		System.out.println("|            SORT Contact            |");
		System.out.println("+------------------------------------+");
		System.out.println('\n');
		
		System.out.println("	[1] Sorting by Name\n");
		System.out.println("	[2] Sorting by Slary\n");
		System.out.println("	[3] Sorting by Birthday\n");
		System.out.println();
		
		System.out.print("Enter an option to continue -> ");
		int  optionSort=input.nextInt();
		System.out.println();
		
		switch (optionSort){
			case 1 :sortName();break;
			case 2 :sortSalary();break;
			case 3 :sortBirthDay();break;
			default:
			System.out.println("\tInvalid Input...");
			try{Thread.sleep(200);}catch(Exception e){}
			clearConsole();
			main(null);
			break;
		}
			
	}
	public static void exit(){
		System.exit(0);
	}	
	
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		
		System.out.println("	                      /$$ / $$$$$$$$/$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$    ");
		System.out.println("	                      |__/  $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$  ");
		System.out.println("	                       /$$  $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$  ");
		System.out.println("	                      | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$  ");
		System.out.println("	                      | $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$  ");
		System.out.println("	                      | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$  ");
		System.out.println("	                      | $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/  ");
		System.out.println("	                      |__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/   ");
		
		System.out.println('\n');
		
		System.out.println("   _____             _             _              ____                         _                   ");
		System.out.println("  / ____|           | |           | |            / __ \\                       (_)                 ");
		System.out.println(" | |      ___  _ __ | |_ __ _  ___| |_ ___      | |  | |_ __ __ _       _ __  _ ____ __ _ __     ");
		System.out.println(" | |     / _ \\| '_ \\| __/ _` |/ __| __/ __|     | |  | | `_/  _` |/ _` | '_ \\| |_  / _ \\ `__|    ");
		System.out.println(" | |____| (_) | | | | || |_| | |__| |_\\__ \\     | |__| | | | |_| | |_| | | | | |/ /  __/| |      ");
		System.out.println("  \\_____ \\___/|_| |_|\\__\\__,_|\\___|\\__|___/      \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___||_|      ");
		System.out.println("                                                             __/ |                               ");
		System.out.println("                                                            |___/                                ");
		
		System.out.println();
		System.out.println("========================================================================================================");
		System.out.println('\n');
		
		System.out.println("	[1] ADD Contacts\n");
		System.out.println("	[2] UPDATE Contacts\n");
		System.out.println("	[3] DELETE Contacts\n");
		System.out.println("	[4] SEARCH Contacts\n");
		System.out.println("	[5] LIST Contacts\n");
		System.out.println("	[6] Exit\n");
		
		System.out.print("Enter an option to continue -> ");
		int optionHomePage=input.nextInt();
		System.out.println('\n');
		
		clearConsole();
		try{Thread.sleep(300);}catch(Exception e){}
		
		switch (optionHomePage){
			case 1:addContacts();break;
			case 2:updateContacts();break;
			case 3:deleteContacts();break;
			case 4:searchContacts();break;
			case 5:sortContacts();break;
			case 6: exit();break;
			default:
			
			System.out.println("\tInvalid input...");
			
			try{Thread.sleep(500);}catch(Exception ex){}
			
			clearConsole();	
			main(null);
			break;
		}

	}
}
