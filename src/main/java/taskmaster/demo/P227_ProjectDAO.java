package taskmaster.demo;

import java.sql.Connection;
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
}