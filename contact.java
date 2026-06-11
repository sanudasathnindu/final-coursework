import java.util.*;
class contact {
    private static ArrayList<String> contactIds = new ArrayList<>();
    private static ArrayList<String> names = new ArrayList<>();
    private static ArrayList<String> phoneNumbers = new ArrayList<>();
    private static ArrayList<String> companies = new ArrayList<>();
    private static ArrayList<Double> salaries = new ArrayList<>();
    private static ArrayList<String> birthdays = new ArrayList<>();
    
    public final static void clearConsole(){
        try {   
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            clearConsole();
            System.out.println(" /$$ /$$$$$$$$ /$$$$$$$  /$$$$$$  /$$$$$$$$ /$$   /$$ /$$$$$$$ ");
            System.out.println("|__/| $$_____/| $$__  $$|_  $$_/ | $$_____/| $$$ | $$| $$__  $$");
            System.out.println(" /$$| $$      | $$  \\ \\$$  | $$   | $$      | $$$$| $$| $$  \\ \\$$");
            System.out.println("| $$| $$$$$   | $$$$$$$/  | $$   | $$$$$   | $$ $$ $$| $$  | $$");
            System.out.println("| $$| $$__/   | $$__  $$  | $$   | $$__/   | $$  $$$$| $$  | $$");
            System.out.println("| $$| $$      | $$  \\ \\$$  | $$   | $$      | $$\\  $$$| $$  | $$");
            System.out.println("| $$| $$$$$$$$| $$  | $/$$$$$$ | $$$$$$$$| $$ \\  \\$$| $$$$$$$/");
            System.out.println("|__/|________/|__/  |__/|______/ |________/|__/  \\__/|_______/ ");
            System.out.println("                                                               ");
            System.out.println("  _  _     _               _               _  _               _   ");
            System.out.println(" | |/ |   (_)             | |             | | | |             (_)  ");
            System.out.println("___|   / ___ _ __  ___  __ _| |_ ___    ___ | |_| |__ _ _ _  _ _____ _ __ ");
            System.out.println("/ __|  < / _ | '_ \\/ __|/ _` | __/ __|  / _ \\|  _| / _` | '_ \\| |_  / _' |");
            System.out.println("| (__|   | (_) | | | \\__ | (_| | |_\\__ \\ | (_) | |_| | (_| | | | | |/ /  | |");
            System.out.println(" \\___|_|\\_\\___/|_| |_|___/\\__,_|\\__|___/  \\___/ \\__|_|\\__,_|_| |_|_/___||_|");
            System.out.println("                                                                           ");
            System.out.println("============================================================================");
            System.out.println();
            
            System.out.println("\t [1] Add Contacts \n");
            System.out.println("\t [2] Update Contacts  \n");
            System.out.println("\t [3] Delete Contacts \n");
            System.out.println("\t [4] Search Contacts \n");
            System.out.println("\t [5] List Contacts \n");
            System.out.println("\t [6] Exit \n");
            
            System.out.print("Enter an option to continue :");
            int option = input.nextInt();
            input.nextLine(); 
              
            switch(option){
                case 1: {
                    clearConsole();
                    boolean addMore = true;
                    
                    while (addMore) { 
                        clearConsole();
                        System.out.println("+----------------------------------------+");
                        System.out.println("|\t Add Contact To The List. \t |");
                        System.out.println("+----------------------------------------+");
                        
                        int nextNum = contactIds.size() + 1;
                        String nextId = String.format("C%04d", nextNum);
                        System.out.println("Contact ID : " + nextId);
                        System.out.println("============= \n");
                        
                        System.out.print("Name : ");
                        String name = input.nextLine().trim();
                        
                        String phone = "";
                        while (true) { 
                            System.out.print("Phone Number : ");
                            phone = input.nextLine().trim();
                            if (phone.length() == 10 && phone.startsWith("0")) {
                                break;
                            }
                            System.out.println("\t>>> Invalid! Must be 10 digits and start with 0.");
                        }

                        System.out.print("Company Name : ");
                        String company = input.nextLine().trim();

                        double salary = 0;
                        while (true) {
                            System.out.print("Salary : ");
                            try {
                                salary = Double.parseDouble(input.nextLine().trim());
                                if (salary > 0) {
                                    break;
                                }
                                System.out.println("\t>>> Salary must be greater than 0.");
                            } catch (Exception e) {
                                System.out.println("\t>>> Invalid number format.");
                            }
                        }

                        String birthday = "";
                        while (true) {
                            System.out.print("Birthday (YYYY-MM-DD) : ");
                            birthday = input.nextLine().trim();
                            
                            if (birthday.length() == 10 && birthday.charAt(4) == '-' && birthday.charAt(7) == '-') {
                                break;
                            }
                            System.out.println("\t>>> Invalid format! Please use YYYY-MM-DD format.");
                        }

                        contactIds.add(nextId);
                        names.add(name);
                        phoneNumbers.add(phone);
                        companies.add(company);
                        salaries.add(salary);
                        birthdays.add(birthday);

                        System.out.println("\nContact added successfully!");

                        while (true) {
                            System.out.print("\nDo you want to add another Contact (Y/N): ");
                            String choice = input.nextLine().trim().toUpperCase();
                            if (choice.equals("Y")) {
                                break; 
                            } else if (choice.equals("N")) {
                                addMore = false;
                                break;
                            } else {
                                System.out.println("Invalid choice. Enter Y or N.");
                            }
                        }
                    }
                    break; 
                }
                
                case 2: {
                    boolean updateMore = true;
                    while (updateMore) {
                        clearConsole();
                        System.out.println("+----------------------------------------+");
                        System.out.println("|\t   Update Contact Details  \t |");
                        System.out.println("+----------------------------------------+");
                        
                        System.out.print("\nSearch Contact by Name or Phone Number: ");
                        String searchKey = input.nextLine().trim();
                        
                        int index = -1;
                        for (int i = 0; i < contactIds.size(); i++) {
                            if (names.get(i).equalsIgnoreCase(searchKey) || phoneNumbers.get(i).equals(searchKey)) {
                                index = i;
                                break;
                            }
                        }
                        if (index == -1) {
                            System.out.println("\n\t>>> Contact not found!");
                        } else {
                            System.out.println("\n--- Contact Details Found ---");
                            System.out.println("Contact ID   : " + contactIds.get(index));
                            System.out.println("Name         : " + names.get(index));
                            System.out.println("Phone Number : " + phoneNumbers.get(index));
                            System.out.println("Company Name : " + companies.get(index));
                            System.out.println("Salary       : " + salaries.get(index));
                            System.out.println("Birthday     : " + birthdays.get(index));
                            System.out.println("-----------------------------");
                            
                            System.out.println("\nWhat do you want to update?");
                            System.out.println("\t[1] Name");
                            System.out.println("\t[2] Phone Number");
                            System.out.println("\t[3] Company Name");
                            System.out.println("\t[4] Salary");
                            System.out.print("\nEnter choice: ");
                            
                            int updateChoice = input.nextInt();
                            input.nextLine(); 
                            
                            switch (updateChoice) {
                                case 1:
                                    System.out.print("Enter New Name: ");
                                    String newName = input.nextLine().trim();
                                    names.set(index, newName);
                                    break;
                                case 2:
                                    String newPhone = "";
                                    while (true) {
                                        System.out.print("Enter New Phone Number: ");
                                        newPhone = input.nextLine().trim();
                                        if (newPhone.length() == 10 && newPhone.startsWith("0")) {
                                            break;
                                        }
                                        System.out.println("\t>>> Invalid! Must be 10 digits and start with 0.");
                                    }
                                    phoneNumbers.set(index, newPhone);
                                    break;
                                case 3:
                                    System.out.print("Enter New Company Name: ");
                                    String newCompany = input.nextLine().trim();
                                    companies.set(index, newCompany);
                                    break;
                                case 4:
                                    double newSalary = 0;
                                    while (true) {
                                        System.out.print("Enter New Salary: ");
                                        try {
                                            newSalary = Double.parseDouble(input.nextLine().trim());
                                            if (newSalary > 0) {
                                                break;
                                            }
                                            System.out.println("\t>>> Salary must be greater than 0.");
                                        } catch (Exception e) {
                                            System.out.println("\t>>> Invalid number format.");
                                        }
                                    }
                                    salaries.set(index, newSalary);
                                    break;
                                default:
                                    System.out.println("\t>>> Invalid Choice. No updates made.");
                                    break;
                            }
                            
                            if (updateChoice >= 1 && updateChoice <= 4) {
                                System.out.println("\nUpdate successful!");
                            }
                         }

                        while (true) {
                            System.out.print("\nDo you want to update another contact (Y/N): ");
                            String choice = input.nextLine().trim().toUpperCase();
                            if (choice.equals("Y")) {
                                break;
                            } else if (choice.equals("N")) {
                                updateMore = false;
                                break;
                            } else {
                                System.out.println("Invalid choice. Enter Y or N.");
                            }
                        }
                    }
                    break;
                }
                
                case 3: {
                    boolean deleteMore = true;
                    while (deleteMore) {
                         clearConsole();
                         System.out.println("+----------------------------------------+");
                         System.out.println("|\t   Delete Contact Details  \t |");
                         System.out.println("+----------------------------------------+");
                            
                         System.out.print("\nEnter Phone Number or Name to Delete: ");
                         String deleteKey = input.nextLine().trim();
                         
                         if (deleteKey.matches("\\d+") && !(deleteKey.length() == 10 && deleteKey.startsWith("0"))) {
                             System.out.println("\t>>> Invalid Phone Number! Must be 10 digits and start with 0.");
                         } else {
                             int index = -1;
                             for (int i = 0; i < contactIds.size(); i++) {
                                 if (names.get(i).equalsIgnoreCase(deleteKey) || phoneNumbers.get(i).equals(deleteKey)) {
                                     index = i;
                                     break;
                                 }
                             }
                             if (index == -1) {
                                 System.out.println("\n\t>>> Contact still hasn't been added to the system.");
                             } else {
                                 System.out.println("\n--- Contact Details Found ---");
                                 System.out.println("Contact ID   : " + contactIds.get(index));
                                 System.out.println("Name         : " + names.get(index));
                                 System.out.println("Phone Number : " + phoneNumbers.get(index));
                                 System.out.println("Company Name : " + companies.get(index));
                                 System.out.println("Salary       : " + salaries.get(index));
                                 System.out.println("Birthday     : " + birthdays.get(index));
                                 System.out.println("-----------------------------");
                                    
                                 System.out.print("\nAre you sure you want to delete this contact? (Y/N): ");
                                 String confirmation = input.nextLine().trim().toUpperCase();
                                    
                                 if (confirmation.equals("Y")) {
                                     contactIds.remove(index);
                                     names.remove(index);
                                     phoneNumbers.remove(index);
                                     companies.remove(index);
                                     salaries.remove(index);
                                     birthdays.remove(index);
                                        
                                     System.out.println("\nContact deleted successfully!");
                                 } else {
                                     System.out.println("\nDeletion canceled. Contact remains safe.");
                                 }
                             }
                         }
                            
                         while (true) {
                             System.out.print("\nDo you want to delete another contact (Y/N): ");
                             String choice = input.nextLine().trim().toUpperCase();
                             if (choice.equals("Y")) {
                                 break;
                             } else if (choice.equals("N")) {
                                 deleteMore = false;
                                 break;
                             } else {
                                 System.out.println("Invalid choice. Enter Y or N.");
                             }
                         }
                    }
                    break; 
                }
                
                case 4: {
                    boolean searchMore = true;
                    while (searchMore) {
                        clearConsole();
                        System.out.println("+----------------------------------------+");
                        System.out.println("|\t   Search Contact Details  \t |");
                        System.out.println("+----------------------------------------+");
                        
                        System.out.print("\nEnter Phone Number or Name to Search: ");
                        String searchKey = input.nextLine().trim();
                        
                        if (searchKey.matches("\\d+") && !(searchKey.length() == 10 && searchKey.startsWith("0"))) {
                            System.out.println("\t>>> Invalid Phone Number! Must be 10 digits and start with 0.");
                        } else {
                            int index = -1;
                            
                            for (int i = 0; i < contactIds.size(); i++) {
                                if (names.get(i).equalsIgnoreCase(searchKey) || phoneNumbers.get(i).equals(searchKey)) {
                                    index = i;
                                    break;
                                }
                            }
                            if (index == -1) {
                                System.out.println("\n\t>>> Contact still hasn't been added to the system.");
                            } else {
                                
                                System.out.println("\n--- Contact Details Found ---");
                                System.out.println("Contact ID   : " + contactIds.get(index));
                                System.out.println("Name         : " + names.get(index));
                                System.out.println("Phone Number : " + phoneNumbers.get(index));
                                System.out.println("Company Name : " + companies.get(index));
                                System.out.println("Salary       : " + salaries.get(index));
                                System.out.println("Birthday     : " + birthdays.get(index));
                                System.out.println("-----------------------------");
                            }
                        }
                        
                        while (true) {
                            System.out.print("\nDo you want to search another contact (Y/N): ");
                            String choice = input.nextLine().trim().toUpperCase();
                            if (choice.equals("Y")) {
                                break;
                            } else if (choice.equals("N")) {
                                searchMore = false;
                                break;
                            } else {
                                System.out.println("Invalid choice. Enter Y or N.");
                            }
                        }
                    }
                    break;
                }
                
                case 5: {
                    boolean sortMore = true;
                    while (sortMore) {
                        clearConsole();
                        System.out.println("+----------------------------------------+");
                        System.out.println("|\t       Sort Contacts      \t |");
                        System.out.println("+----------------------------------------+");
                        if (contactIds.isEmpty()) {
                            System.out.println("\n\t>>> No contacts available to sort.");
                        } else {
                            System.out.println("\n[1] Sort by Name");
                            System.out.println("[2] Sort by Salary");
                            System.out.println("[3] Sort by Birthday");
                            System.out.print("\nEnter choice: ");
                            int sortChoice = input.nextInt();
                            input.nextLine(); 
                            
                            
                            Integer[] indices = new Integer[contactIds.size()];
                            for (int i = 0; i < indices.length; i++) {
                                indices[i] = i;
                            }
                            
                            if (sortChoice == 1) {
                                Arrays.sort(indices, (a, b) -> names.get(a).compareToIgnoreCase(names.get(b)));
                            } else if (sortChoice == 2) {
                                Arrays.sort(indices, (a, b) -> Double.compare(salaries.get(a), salaries.get(b)));
                            } else if (sortChoice == 3) {
                                Arrays.sort(indices, (a, b) -> birthdays.get(a).compareTo(birthdays.get(b)));
                            } else {
                                System.out.println("\t>>> Invalid Choice.");
                                indices = null;
                            }
                            
                            if (indices != null) {
                                System.out.println("\n==========================================================================================");
                                System.out.printf("%-12s %-15s %-15s %-15s %-12s %-12s\n", "ID", "Name", "Phone", "Company", "Salary", "Birthday");
                                System.out.println("==========================================================================================");
                                for (int idx : indices) {
                                    System.out.printf("%-12s %-15s %-15s %-15s %-12.2f %-12s\n", 
                                        contactIds.get(idx), names.get(idx), phoneNumbers.get(idx), companies.get(idx), salaries.get(idx), birthdays.get(idx));
                                }
                                System.out.println("==========================================================================================");
                            }
                        }
                        while (true) {
                            System.out.print("\nDo you want to stay in Sort Menu (Y/N): ");
                            String choice = input.nextLine().trim().toUpperCase();
                            if (choice.equals("Y")) {
                                break;
                            } else if (choice.equals("N")) {
                                sortMore = false;
                                break;
                            } else {
                                System.out.println("Invalid choice. Enter Y or N.");
                            }
                        }
                    }
                    break;
                }
                
                case 6: {
                    System.out.println("\nExiting application... Goodbye!");
                    System.exit(0);
                }
                
                default: {
                    System.out.println("\nInvalid selection. Try again.");
                    try { Thread.sleep(1000); } catch(Exception ignored) {}
                    break;
                }
            } 
         }
    } 
} 
