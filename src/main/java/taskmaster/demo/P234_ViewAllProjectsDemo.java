package taskmaster.demo;

import java.util.List;

public class P234_ViewAllProjectsDemo {

    public static void main(String[] args) {

        P229_ProjectService service = new P229_ProjectService();

        List<P228_Project> projectList = service.getProjects();

        System.out.println("==============================================================================================");
        System.out.printf("%-4s %-8s %-28s %-10s %-10s %-10s %-12s%n",
                "ID",
                "Code",
                "Project Name",
                "Budget",
                "Priority",
                "Status",
                "Manager");
        System.out.println("==============================================================================================");

        for (P228_Project project : projectList) {

            System.out.printf(
                    "%-4d %-8s %-28s %-10.2f %-10s %-10s %-12d%n",
                    project.getProjectId(),
                    project.getProjectCode(),
                    project.getProjectName(),
                    project.getBudget(),
                    project.getPriority(),
                    project.getStatus(),
                    project.getManagerId());

        }

        System.out.println("==============================================================================================");
        System.out.println("Total Projects : " + projectList.size());

    }

}