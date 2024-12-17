import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option: \n1. Add Customer \n2. Add Employee \n3. Add Manager \n4. Add Intern \n5. Promote Intern to Employee \n6. Fire Employee \n7. Record a Deal \n8. View People \n9. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Customer Details: ID, Name, Loyalty Points");
                    String id = scanner.nextLine();
                    String name = scanner.nextLine();
                    int points = scanner.nextInt();
                    people.add(new Customer(id, name, points));
                }
                case 2 -> {
                    System.out.println("Enter Employee Details: ID, Name, Job Title, Manager ID");
                    String id = scanner.nextLine();
                    String name = scanner.nextLine();
                    String jobTitle = scanner.nextLine();
                    String managerID = scanner.nextLine();
                    people.add(new Employee(id, name, jobTitle, managerID));
                    updateManagerTeamSize(people, managerID, 1);
                }
                case 3 -> {
                    System.out.println("Enter Manager Details: ID, Name, Job Title, Team Size");
                    String id = scanner.nextLine();
                    String name = scanner.nextLine();
                    String jobTitle = scanner.nextLine();
                    int teamSize = scanner.nextInt();
                    people.add(new Manager(id, name, jobTitle, teamSize));
                }
                case 4 -> {
                    System.out.println("Enter Intern Details: ID, Name, Job Title, University");
                    String id = scanner.nextLine();
                    String name = scanner.nextLine();
                    String jobTitle = scanner.nextLine();
                    String university = scanner.nextLine();
                    people.add(new Intern(id, name, jobTitle, university));
                }
                case 5 -> promoteIntern(scanner, people);
                case 6 -> fireEmployee(scanner, people);
                case 7 -> recordADeal(scanner, people);
                case 8 -> {
                    for (Person person : people) {
                        System.out.println(person);
                        System.out.println("------------");
                    }
                }
                case 9 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
    
    private static void recordADeal(Scanner scanner, ArrayList<Person> people) {
        System.out.println("Enter Employee/Intern ID to Record a Deal:");
        String empID = scanner.nextLine();
        for (Person person : people) {
            if (person instanceof Employee && person.getPersonID().equals(empID)) {
                ((Employee) person).recordADeal();
                System.out.println("Deal recorded for " + person.getName());
                if (person instanceof Intern && ((Intern) person).getNumberOfDeals() >= 5) {
                    System.out.println(person.getName() + " has been promoted!");
                    promoteInternById(empID, people, "None");
                }
                return;
            }
        }
        System.out.println("Person not found.");
    }



    private static void updateManagerTeamSize(ArrayList<Person> people, String managerID, int adjustment) {
        for (Person person : people) {
            if (person instanceof Manager && person.getPersonID().equals(managerID)) {
                ((Manager) person).setTeamSize(((Manager) person).getTeamSize() + adjustment);
            }
        }
    }

    private static void promoteIntern(Scanner scanner, ArrayList<Person> people) {
        System.out.println("Enter Intern ID to Promote and Manager ID:");
        String internID = scanner.nextLine();
        String managerID = scanner.nextLine();
        promoteInternById(internID, people, managerID);
    }

    private static void fireEmployee(Scanner scanner, ArrayList<Person> people) {
        System.out.println("Enter Employee ID to Fire:");
        String empID = scanner.nextLine();
        people.removeIf(person -> person instanceof Employee && person.getPersonID().equals(empID));
        System.out.println("Employee fired!");
    }

    private static void promoteInternById(String internID, ArrayList<Person> people, String managerID) {
        for (Person person : people) {
            if (person instanceof Intern && person.getPersonID().equals(internID)) {
                Intern intern = (Intern) person;
                people.add(new Employee(intern.getPersonID(), intern.getName(), intern.getJobTitle(), managerID));
                updateManagerTeamSize(people, managerID, 1);
                people.remove(person);
                System.out.println("Intern promoted!");
                return;
            }
        }
        System.out.println("Intern not found.");
    }
}
