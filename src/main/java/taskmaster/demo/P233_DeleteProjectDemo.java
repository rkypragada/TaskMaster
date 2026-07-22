package taskmaster.demo;

import java.util.Scanner;

public class P233_DeleteProjectDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        P229_ProjectService service = new P229_ProjectService();

        System.out.println("====================================");
        System.out.println("        DELETE PROJECT");
        System.out.println("====================================");

        System.out.print("Enter Project Code : ");
        String projectCode = scanner.nextLine();

        boolean deleted = service.removeProject(projectCode);

        if (deleted) {

            System.out.println();
            System.out.println("Project Deleted Successfully.");

        } else {

            System.out.println();
            System.out.println("Project Deletion Failed.");
            System.out.println("Project Code not found.");

        }

        scanner.close();

    }

}