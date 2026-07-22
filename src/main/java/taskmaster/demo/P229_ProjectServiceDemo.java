package taskmaster.demo;

public class P229_ProjectServiceDemo {

    public static void main(String[] args) {

        P229_ProjectService service = new P229_ProjectService();

        P228_Project project = service.findProject("PRJ001");

        if (project != null) {

            System.out.println("====================================");
            System.out.println("        PROJECT DETAILS");
            System.out.println("====================================");
            System.out.println(project);

        } else {

            System.out.println("Project Not Found.");

        }

    }

}