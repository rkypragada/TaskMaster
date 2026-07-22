package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import taskmaster.demo.P203_DBConnection;
import taskmaster.demo.P228_Project;

public class P227_ProjectDAO {

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

}