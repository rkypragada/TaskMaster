package taskmaster.demo;

import java.util.List;

public class P239_ViewProjectsSortedByBudgetDemo {

    public static void main(String[] args) {

        P229_ProjectService service =
                new P229_ProjectService();

        List<P228_Project> projects =
                service.getProjectsSortedByBudget();

        System.out.println("==============================================================================================================");
        System.out.printf("%-4s %-8s %-30s %-15s %-10s %-10s %-10s%n",
                "ID",
                "Code",
                "Project Name",
                "Budget",
                "Priority",
                "Status",
                "Manager");

        System.out.println("==============================================================================================================");

        for (P228_Project project : projects) {

            System.out.printf("%-4d %-8s %-30s %-15.2f %-10s %-10s %-10d%n",
                    project.getProjectId(),
                    project.getProjectCode(),
                    project.getProjectName(),
                    project.getBudget(),
                    project.getPriority(),
                    project.getStatus(),
                    project.getManagerId());

        }

        System.out.println("==============================================================================================================");
        System.out.println("Total Projects : " + projects.size());

    }

}