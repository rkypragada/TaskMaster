package taskmaster.demo;

import java.util.List;

public class P238_ViewProjectsSortedByNameDemo {

    public static void main(String[] args) {

        P229_ProjectService service = new P229_ProjectService();

        List<P228_Project> projects =
                service.getProjectsSortedByName();

        System.out.println("==============================================================================================");
        System.out.printf("%-4s %-8s %-30s %-12s %-10s %-10s%n",
                "ID",
                "Code",
                "Project Name",
                "Budget",
                "Priority",
                "Status");

        System.out.println("==============================================================================================");

        for (P228_Project project : projects) {

            System.out.printf("%-4d %-8s %-30s %-12.2f %-10s %-10s%n",
                    project.getProjectId(),
                    project.getProjectCode(),
                    project.getProjectName(),
                    project.getBudget(),
                    project.getPriority(),
                    project.getStatus());

        }

        System.out.println("==============================================================================================");
        System.out.println("Total Projects : " + projects.size());

    }

}