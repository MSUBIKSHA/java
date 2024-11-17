import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TouristManagementSystem {

   
    static class Tourist {
        private String name;
        private String country;
        private int age;
        private String passportNumber;

        public Tourist(String name, String country, int age, String passportNumber) {
            this.name = name;
            this.country = country;
            this.age = age;
            this.passportNumber = passportNumber;
        }

       
        public String getName() {
            return name;
        }

        public String getCountry() {
            return country;
        }

        public int getAge() {
            return age;
        }

        public String getPassportNumber() {
            return passportNumber;
        }

        
        public String toString() {
            return "Name: " + name + ", Country: " + country + ", Age: " + age + ", Passport No: " + passportNumber;
        }
    }

    static class TouristManager {
        private List<Tourist> tourists;

      
        public TouristManager() {
            tourists = new ArrayList<>();
        }

        
        public void addTourist(Tourist tourist) {
            tourists.add(tourist);
        }

        
        public void displayTourists() {
            if (tourists.isEmpty()) {
                System.out.println("No tourists added yet.");
            } else {
                for (Tourist tourist : tourists) {
                    System.out.println(tourist);
                }
            }
        }

      
        public void searchTouristByName(String name) {
            boolean found = false;
            for (Tourist tourist : tourists) {
                if (tourist.getName().equalsIgnoreCase(name)) {
                    System.out.println("Tourist found: " + tourist);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No tourist found with the name: " + name);
            }
        }

    
        public void searchTouristByPassport(String passportNumber) {
            boolean found = false;
            for (Tourist tourist : tourists) {
                if (tourist.getPassportNumber().equals(passportNumber)) {
                    System.out.println("Tourist found: " + tourist);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No tourist found with the passport number: " + passportNumber);
            }
        }
    }

 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TouristManager manager = new TouristManager();

       
        while (true) {
            System.out.println("\n------ Tourist Management System ------");
            System.out.println("1. Add Tourist");
            System.out.println("2. View All Tourists");
            System.out.println("3. Search Tourist by Name");
            System.out.println("4. Search Tourist by Passport Number");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add Tourist
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter country: ");
                    String country = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Enter passport number: ");
                    String passportNumber = scanner.nextLine();

                    Tourist tourist = new Tourist(name, country, age, passportNumber);
                    manager.addTourist(tourist);
                    System.out.println("Tourist added successfully.");
                    break;

                case 2:
                    
                    manager.displayTourists();
                    break;

                case 3:
                
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    manager.searchTouristByName(searchName);
                    break;

                case 4:
                   
                    System.out.print("Enter passport number to search: ");
                    String searchPassport = scanner.nextLine();
                    manager.searchTouristByPassport(searchPassport);
                    break;

                case 5:
                  
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
