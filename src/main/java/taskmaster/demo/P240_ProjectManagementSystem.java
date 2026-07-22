package taskmaster.demo;

import java.util.List;
import java.util.Scanner;

public class P240_ProjectManagementSystem {

    static Scanner scanner = new Scanner(System.in);
    static P229_ProjectService service = new P229_ProjectService();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n==========================================================");
            System.out.println("          TASKMASTER PROJECT MANAGEMENT SYSTEM");
            System.out.println("==========================================================");
            System.out.println("1. Search Project by Code");
            System.out.println("2. Insert Project");
            System.out.println("3. Update Project");
            System.out.println("4. Delete Project");
            System.out.println("5. View All Projects");
            System.out.println("6. Search Projects by Manager ID");
            System.out.println("7. Search Projects by Status");
            System.out.println("8. Search Projects by Priority");
            System.out.println("9. View Projects Sorted by Name");
            System.out.println("10. View Projects Sorted by Budget");
            System.out.println("11. Exit");

            System.out.print("\nEnter Your Choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            case 1:
                searchProject();
                break;

            case 2:
                insertProject();
                break;

            case 3:
                updateProject();
                break;

            case 4:
                deleteProject();
                break;

            case 5:
                viewAllProjects();
                break;

            case 6:
                searchByManager();
                break;

            case 7:
                searchByStatus();
                break;

            case 8:
                searchByPriority();
                break;

            case 9:
                sortByName();
                break;

            case 10:
                sortByBudget();
                break;

            case 11:
                System.out.println("\nThank You...");
                break;

            default:
                System.out.println("Invalid Choice.");

            }

        } while (choice != 11);

        scanner.close();

    }

    // --------------------------------------------------------------------
    // Search Project
    // --------------------------------------------------------------------

    static void searchProject() {

        System.out.print("\nEnter Project Code : ");

        String code = scanner.nextLine();

        P228_Project project = service.findProject(code);

        if (project != null)
            System.out.println(project);
        else
            System.out.println("Project Not Found.");

    }

    // --------------------------------------------------------------------
    // Insert Project
    // --------------------------------------------------------------------

    static void insertProject() {

        P228_Project project = new P228_Project();

        System.out.print("Project Code : ");
        project.setProjectCode(scanner.nextLine());

        System.out.print("Project Name : ");
        project.setProjectName(scanner.nextLine());

        System.out.print("Description : ");
        project.setDescription(scanner.nextLine());

        System.out.print("Start Date : ");
        project.setStartDate(scanner.nextLine());

        System.out.print("End Date : ");
        project.setEndDate(scanner.nextLine());

        System.out.print("Budget : ");
        project.setBudget(scanner.nextDouble());
        scanner.nextLine();

        System.out.print("Priority : ");
        project.setPriority(scanner.nextLine());

        System.out.print("Status : ");
        project.setStatus(scanner.nextLine());

        System.out.print("Manager ID : ");
        project.setManagerId(scanner.nextInt());
        scanner.nextLine();

        if (service.addProject(project))
            System.out.println("Project Inserted Successfully.");
        else
            System.out.println("Insertion Failed.");

    }

    // --------------------------------------------------------------------
    // Update Project
    // --------------------------------------------------------------------

    static void updateProject() {

        P228_Project project = new P228_Project();

        System.out.print("Project Code : ");
        project.setProjectCode(scanner.nextLine());

        System.out.print("Project Name : ");
        project.setProjectName(scanner.nextLine());

        System.out.print("Description : ");
        project.setDescription(scanner.nextLine());

        System.out.print("Start Date : ");
        project.setStartDate(scanner.nextLine());

        System.out.print("End Date : ");
        project.setEndDate(scanner.nextLine());

        System.out.print("Budget : ");
        project.setBudget(scanner.nextDouble());
        scanner.nextLine();

        System.out.print("Priority : ");
        project.setPriority(scanner.nextLine());

        System.out.print("Status : ");
        project.setStatus(scanner.nextLine());

        System.out.print("Manager ID : ");
        project.setManagerId(scanner.nextInt());
        scanner.nextLine();

        if (service.modifyProject(project))
            System.out.println("Project Updated Successfully.");
        else
            System.out.println("Update Failed.");

    }

    // --------------------------------------------------------------------
    // Delete Project
    // --------------------------------------------------------------------

    static void deleteProject() {

        System.out.print("Enter Project Code : ");

        String code = scanner.nextLine();

        if (service.removeProject(code))
            System.out.println("Project Deleted Successfully.");
        else
            System.out.println("Deletion Failed.");

    }

    // --------------------------------------------------------------------
    // View All
    // --------------------------------------------------------------------

    static void viewAllProjects() {

        List<P228_Project> projects = service.getProjects();

        for (P228_Project project : projects)
            System.out.println(project);

    }

    // --------------------------------------------------------------------
    // Manager
    // --------------------------------------------------------------------

    static void searchByManager() {

        System.out.print("Enter Manager ID : ");

        int manager = scanner.nextInt();
        scanner.nextLine();

        List<P228_Project> projects =
                service.findProjectsByManager(manager);

        for (P228_Project project : projects)
            System.out.println(project);

    }

    // --------------------------------------------------------------------
    // Status
    // --------------------------------------------------------------------

    static void searchByStatus() {

        System.out.print("Enter Status : ");

        String status = scanner.nextLine();

        List<P228_Project> projects =
                service.findProjectsByStatus(status);

        for (P228_Project project : projects)
            System.out.println(project);

    }

    // --------------------------------------------------------------------
    // Priority
    // --------------------------------------------------------------------

    static void searchByPriority() {

        System.out.print("Enter Priority : ");

        String priority = scanner.nextLine();

        List<P228_Project> projects =
                service.findProjectsByPriority(priority);

        for (P228_Project project : projects)
            System.out.println(project);

    }

    // --------------------------------------------------------------------
    // Sort by Name
    // --------------------------------------------------------------------

    static void sortByName() {

        List<P228_Project> projects =
                service.getProjectsSortedByName();

        for (P228_Project project : projects)
            System.out.println(project);

    }

    // --------------------------------------------------------------------
    // Sort by Budget
    // --------------------------------------------------------------------

    static void sortByBudget() {

        List<P228_Project> projects =
                service.getProjectsSortedByBudget();

        for (P228_Project project : projects)
            System.out.println(project);

    }

}