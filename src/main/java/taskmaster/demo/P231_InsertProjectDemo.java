package taskmaster.demo;

import java.util.Scanner;

public class P231_InsertProjectDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        P229_ProjectService service = new P229_ProjectService();

        P228_Project project = new P228_Project();

        System.out.println("====================================");
        System.out.println("        INSERT PROJECT");
        System.out.println("====================================");

        System.out.print("Project Code : ");
        project.setProjectCode(scanner.nextLine());

        System.out.print("Project Name : ");
        project.setProjectName(scanner.nextLine());

        System.out.print("Description : ");
        project.setDescription(scanner.nextLine());

        System.out.print("Start Date (YYYY-MM-DD) : ");
        project.setStartDate(scanner.nextLine());

        System.out.print("End Date (YYYY-MM-DD) : ");
        project.setEndDate(scanner.nextLine());

        System.out.print("Budget : ");
        project.setBudget(scanner.nextDouble());
        scanner.nextLine();

        System.out.print("Priority (LOW/MEDIUM/HIGH) : ");
        project.setPriority(scanner.nextLine());

        System.out.print("Status (PLANNING/ACTIVE/ON_HOLD/COMPLETED) : ");
        project.setStatus(scanner.nextLine());

        System.out.print("Manager ID : ");
        project.setManagerId(scanner.nextInt());

        if (service.addProject(project)) {

            System.out.println("\nProject Inserted Successfully.");

        } else {

            System.out.println("\nProject Insertion Failed.");

        }

        scanner.close();

    }

}