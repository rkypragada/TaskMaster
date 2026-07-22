package taskmaster.demo;

import java.util.List;
import java.util.ArrayList;

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
 // Delete Project
    public boolean removeProject(String projectCode) {

        if (projectCode == null || projectCode.trim().isEmpty()) {

            System.out.println("Project Code is required.");
            return false;

        }

        return dao.deleteProject(projectCode);

    }
 // View All Projects
    public List<P228_Project> getProjects() {

        return dao.getAllProjects();

    }
 // Search Projects by Manager ID
    public List<P228_Project> findProjectsByManager(int managerId) {

        return dao.getProjectsByManager(managerId);

    }
 // Search Projects by Status
    public List<P228_Project> findProjectsByStatus(String status) {

        if (status == null || status.trim().isEmpty()) {

            return new ArrayList<>();

        }

        return dao.getProjectsByStatus(status);

    }
 // Search Projects by Priority
    public List<P228_Project> findProjectsByPriority(String priority) {

        if (priority == null || priority.trim().isEmpty()) {

            return new ArrayList<>();

        }

        return dao.getProjectsByPriority(priority);

    }
 // View Projects Sorted by Name
    public List<P228_Project> getProjectsSortedByName() {

        return dao.getProjectsSortedByName();

    }
 // View Projects Sorted by Budget
    public List<P228_Project> getProjectsSortedByBudget() {

        return dao.getProjectsSortedByBudget();

    }
}