package taskmaster.demo;

import java.util.List;
import java.util.Scanner;

public class P236_SearchProjectsByStatusDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        P229_ProjectService service =
                new P229_ProjectService();

        System.out.println("========================================");
        System.out.println("     SEARCH PROJECTS BY STATUS");
        System.out.println("========================================");

        System.out.print("Enter Status (ACTIVE/PLANNING/ON_HOLD/COMPLETED): ");
        String status = scanner.nextLine().toUpperCase();

        List<P228_Project> projects =
                service.findProjectsByStatus(status);

        if (projects.isEmpty()) {

            System.out.println("\nNo Projects Found.");

        } else {

            System.out.println();

            System.out.printf("%-5s %-8s %-30s %-10s %-10s%n",
                    "ID",
                    "Code",
                    "Project Name",
                    "Priority",
                    "Manager");

            System.out.println(
"--------------------------------------------------------------------------");

            for (P228_Project project : projects) {

                System.out.printf("%-5d %-8s %-30s %-10s %-10d%n",
                        project.getProjectId(),
                        project.getProjectCode(),
                        project.getProjectName(),
                        project.getPriority(),
                        project.getManagerId());

            }

            System.out.println(
"--------------------------------------------------------------------------");

            System.out.println("Total Projects : " + projects.size());

        }

        scanner.close();

    }

}