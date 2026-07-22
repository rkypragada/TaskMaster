package taskmaster.demo;

public class P229_ProjectService {

    private P227_ProjectDAO dao = new P227_ProjectDAO();

    // Search Project
    public P228_Project findProject(String projectCode) {

        if (projectCode == null || projectCode.trim().isEmpty()) {

            System.out.println("Invalid Project Code.");
            return null;

        }

        return dao.getProjectByCode(projectCode);
    }

    // Insert Project
    public boolean addProject(P228_Project project) {

        if (project == null) {

            return false;

        }

        return dao.insertProject(project);
    }

    // Update Project
    public boolean modifyProject(P228_Project project) {

        if (project == null) {

            return false;

        }

        if (project.getProjectCode() == null ||
            project.getProjectCode().trim().isEmpty()) {

            System.out.println("Project Code is required.");
            return false;

        }

        return dao.updateProject(project);
    }

}