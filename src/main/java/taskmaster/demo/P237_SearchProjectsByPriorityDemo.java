package taskmaster.demo;

import java.util.List;
import java.util.Scanner;

public class P237_SearchProjectsByPriorityDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        P229_ProjectService service =
                new P229_ProjectService();

        System.out.println("========================================");
        System.out.println("    SEARCH PROJECTS BY PRIORITY");
        System.out.println("========================================");

        System.out.print("Enter Priority (HIGH/MEDIUM/LOW): ");
        String priority = scanner.nextLine().toUpperCase();

        List<P228_Project> projects =
                service.findProjectsByPriority(priority);

        if (projects.isEmpty()) {

            System.out.println("\nNo Projects Found.");

        } else {

            System.out.println();

            System.out.printf("%-5s %-8s %-30s %-10s %-10s%n",
                    "ID",
                    "Code",
                    "Project Name",
                    "Status",
                    "Manager");

            System.out.println("--------------------------------------------------------------------------");

            for (P228_Project project : projects) {

                System.out.printf("%-5d %-8s %-30s %-10s %-10d%n",
                        project.getProjectId(),
                        project.getProjectCode(),
                        project.getProjectName(),
                        project.getStatus(),
                        project.getManagerId());

            }

            System.out.println("--------------------------------------------------------------------------");

            System.out.println("Total Projects : " + projects.size());

        }

        scanner.close();

    }

}