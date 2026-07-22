package taskmaster.demo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class P227_ProjectDAO {

    // Search Project by Project Code
    public P228_Project getProjectByCode(String projectCode) {

        P228_Project project = null;

        String sql = "SELECT * FROM projects WHERE project_code = ?";

        try (
                Connection connection = P203_DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, projectCode);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                project = new P228_Project();

                project.setProjectId(rs.getInt("project_id"));
                project.setProjectCode(rs.getString("project_code"));
                project.setProjectName(rs.getString("project_name"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getString("start_date"));
                project.setEndDate(rs.getString("end_date"));
                project.setBudget(rs.getDouble("budget"));
                project.setPriority(rs.getString("priority"));
                project.setStatus(rs.getString("status"));
                project.setManagerId(rs.getInt("manager_id"));

            }

            rs.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return project;
    }

    // Insert Project
    public boolean insertProject(P228_Project project) {

        String sql = "INSERT INTO projects "
                + "(project_code, project_name, description, start_date, "
                + "end_date, budget, priority, status, manager_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = P203_DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, project.getProjectCode());
            preparedStatement.setString(2, project.getProjectName());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.setString(4, project.getStartDate());
            preparedStatement.setString(5, project.getEndDate());
            preparedStatement.setDouble(6, project.getBudget());
            preparedStatement.setString(7, project.getPriority());
            preparedStatement.setString(8, project.getStatus());
            preparedStatement.setInt(9, project.getManagerId());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }
 // Update Project
    public boolean updateProject(P228_Project project) {

        String sql = "UPDATE projects "
                + "SET project_name = ?, "
                + "description = ?, "
                + "start_date = ?, "
                + "end_date = ?, "
                + "budget = ?, "
                + "priority = ?, "
                + "status = ?, "
                + "manager_id = ? "
                + "WHERE project_code = ?";

        try (
                Connection connection = P203_DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setString(3, project.getStartDate());
            preparedStatement.setString(4, project.getEndDate());
            preparedStatement.setDouble(5, project.getBudget());
            preparedStatement.setString(6, project.getPriority());
            preparedStatement.setString(7, project.getStatus());
            preparedStatement.setInt(8, project.getManagerId());

            preparedStatement.setString(9, project.getProjectCode());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }
    public boolean deleteProject(String projectCode) {

        String sql = "DELETE FROM projects WHERE project_code = ?";

        try (
            Connection connection = P203_DBConnection.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, projectCode);

            int rows = preparedStatement.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }
 // View All Projects
    public List<P228_Project> getAllProjects() {

        List<P228_Project> projectList = new ArrayList<>();

        String sql = "SELECT * FROM projects ORDER BY project_id";

        try (
                Connection connection = P203_DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {

            while (resultSet.next()) {

                P228_Project project = new P228_Project();

                project.setProjectId(resultSet.getInt("project_id"));
                project.setProjectCode(resultSet.getString("project_code"));
                project.setProjectName(resultSet.getString("project_name"));
                project.setDescription(resultSet.getString("description"));
                project.setStartDate(resultSet.getString("start_date"));
                project.setEndDate(resultSet.getString("end_date"));
                project.setBudget(resultSet.getDouble("budget"));
                project.setPriority(resultSet.getString("priority"));
                project.setStatus(resultSet.getString("status"));
                project.setManagerId(resultSet.getInt("manager_id"));

                projectList.add(project);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return projectList;

    }
 // Search Projects by Manager ID
    public List<P228_Project> getProjectsByManager(int managerId) {

        List<P228_Project> projectList = new ArrayList<>();

        String sql = "SELECT * FROM projects WHERE manager_id=? ORDER BY project_id";

        try (
                Connection connection = P203_DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
        ) {

            preparedStatement.setInt(1, managerId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                P228_Project project = new P228_Project();

                project.setProjectId(resultSet.getInt("project_id"));
                project.setProjectCode(resultSet.getString("project_code"));
                project.setProjectName(resultSet.getString("project_name"));
                project.setDescription(resultSet.getString("description"));
                project.setStartDate(resultSet.getString("start_date"));
                project.setEndDate(resultSet.getString("end_date"));
                project.setBudget(resultSet.getDouble("budget"));
                project.setPriority(resultSet.getString("priority"));
                project.setStatus(resultSet.getString("status"));
                project.setManagerId(resultSet.getInt("manager_id"));

                projectList.add(project);

            }

            resultSet.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return projectList;

    }
 // Search Projects by Status
    public List<P228_Project> getProjectsByStatus(String status) {

        List<P228_Project> projectList = new ArrayList<>();

        String sql = "SELECT * FROM projects WHERE status=? ORDER BY project_id";

        try (
                Connection connection = P203_DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, status);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                P228_Project project = new P228_Project();

                project.setProjectId(resultSet.getInt("project_id"));
                project.setProjectCode(resultSet.getString("project_code"));
                project.setProjectName(resultSet.getString("project_name"));
                project.setDescription(resultSet.getString("description"));
                project.setStartDate(resultSet.getString("start_date"));
                project.setEndDate(resultSet.getString("end_date"));
                project.setBudget(resultSet.getDouble("budget"));
                project.setPriority(resultSet.getString("priority"));
                project.setStatus(resultSet.getString("status"));
                project.setManagerId(resultSet.getInt("manager_id"));

                projectList.add(project);

            }

            resultSet.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return projectList;

    }
 // Search Projects by Priority
    public List<P228_Project> getProjectsByPriority(String priority) {

        List<P228_Project> projectList = new ArrayList<>();

        String sql = "SELECT * FROM projects WHERE priority=? ORDER BY project_id";

        try (
                Connection connection = P203_DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, priority);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                P228_Project project = new P228_Project();

                project.setProjectId(resultSet.getInt("project_id"));
                project.setProjectCode(resultSet.getString("project_code"));
                project.setProjectName(resultSet.getString("project_name"));
                project.setDescription(resultSet.getString("description"));
                project.setStartDate(resultSet.getString("start_date"));
                project.setEndDate(resultSet.getString("end_date"));
                project.setBudget(resultSet.getDouble("budget"));
                project.setPriority(resultSet.getString("priority"));
                project.setStatus(resultSet.getString("status"));
                project.setManagerId(resultSet.getInt("manager_id"));

                projectList.add(project);

            }

            resultSet.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return projectList;

    }
 // View Projects Sorted by Project Name
    public List<P228_Project> getProjectsSortedByName() {

        List<P228_Project> projectList = new ArrayList<>();

        String sql = "SELECT * FROM projects ORDER BY project_name ASC";

        try (
                Connection connection = P203_DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {

            while (resultSet.next()) {

                P228_Project project = new P228_Project();

                project.setProjectId(resultSet.getInt("project_id"));
                project.setProjectCode(resultSet.getString("project_code"));
                project.setProjectName(resultSet.getString("project_name"));
                project.setDescription(resultSet.getString("description"));
                project.setStartDate(resultSet.getString("start_date"));
                project.setEndDate(resultSet.getString("end_date"));
                project.setBudget(resultSet.getDouble("budget"));
                project.setPriority(resultSet.getString("priority"));
                project.setStatus(resultSet.getString("status"));
                project.setManagerId(resultSet.getInt("manager_id"));

                projectList.add(project);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return projectList;

    }
 // View Projects Sorted by Budget
    public List<P228_Project> getProjectsSortedByBudget() {

        List<P228_Project> projectList = new ArrayList<>();

        String sql = "SELECT * FROM projects ORDER BY budget DESC";

        try (
                Connection connection = P203_DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {

            while (resultSet.next()) {

                P228_Project project = new P228_Project();

                project.setProjectId(resultSet.getInt("project_id"));
                project.setProjectCode(resultSet.getString("project_code"));
                project.setProjectName(resultSet.getString("project_name"));
                project.setDescription(resultSet.getString("description"));
                project.setStartDate(resultSet.getString("start_date"));
                project.setEndDate(resultSet.getString("end_date"));
                project.setBudget(resultSet.getDouble("budget"));
                project.setPriority(resultSet.getString("priority"));
                project.setStatus(resultSet.getString("status"));
                project.setManagerId(resultSet.getInt("manager_id"));

                projectList.add(project);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return projectList;

    }
}