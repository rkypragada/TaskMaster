package taskmaster.demo;

import java.util.Scanner;

public class P230_TaskMasterApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        P229_ProjectService service = new P229_ProjectService();

        int choice;

        do {

            System.out.println();
            System.out.println("==========================================");
            System.out.println("       TASKMASTER APPLICATION");
            System.out.println("==========================================");
            System.out.println("1. Search Project by Code");
            System.out.println("2. Exit");
            System.out.println("==========================================");
            System.out.print("Enter your choice : ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Project Code : ");
                    String projectCode = scanner.nextLine();

                    P228_Project project =
                            service.findProject(projectCode);

                    if (project != null) {

                        System.out.println();
                        System.out.println("PROJECT DETAILS");
                        System.out.println("------------------------------");
                        System.out.println(project);

                    } else {

                        System.out.println("Project Not Found.");

                    }

                    break;

                case 2:

                    System.out.println("Thank You...");
                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 2);

        scanner.close();

    }

}