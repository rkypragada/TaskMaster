package taskmaster.demo;

public class P229_ProjectServiceDemo {

    private P227_ProjectDAO dao = new P227_ProjectDAO();

    public P228_Project findProject(String projectCode) {

        if (projectCode == null || projectCode.trim().isEmpty()) {
            System.out.println("Invalid Project Code.");
            return null;
        }

        return dao.getProjectByCode(projectCode);
    }
}