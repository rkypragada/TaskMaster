package taskmaster.demo;

import java.util.Scanner;

public class P232_UpdateProjectDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        P229_ProjectService service = new P229_ProjectService();

        P228_Project project = new P228_Project();

        System.out.println("====================================");
        System.out.println("        UPDATE PROJECT");
        System.out.println("====================================");

        System.out.print("Project Code : ");
        project.setProjectCode(scanner.nextLine());

        System.out.print("New Project Name : ");
        project.setProjectName(scanner.nextLine());

        System.out.print("New Description : ");
        project.setDescription(scanner.nextLine());

        System.out.print("New Start Date (YYYY-MM-DD) : ");
        project.setStartDate(scanner.nextLine());

        System.out.print("New End Date (YYYY-MM-DD) : ");
        project.setEndDate(scanner.nextLine());

        System.out.print("New Budget : ");
        project.setBudget(scanner.nextDouble());
        scanner.nextLine();

        System.out.print("New Priority (LOW/MEDIUM/HIGH) : ");
        project.setPriority(scanner.nextLine());

        System.out.print("New Status (PLANNING/ACTIVE/ON_HOLD/COMPLETED) : ");
        project.setStatus(scanner.nextLine());

        System.out.print("New Manager ID : ");
        project.setManagerId(scanner.nextInt());

        boolean updated = service.modifyProject(project);

        if (updated) {

            System.out.println();
            System.out.println("Project Updated Successfully.");

        } else {

            System.out.println();
            System.out.println("Project Update Failed.");
            System.out.println("Check whether the Project Code exists.");

        }

        scanner.close();

    }

}