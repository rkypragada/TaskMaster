package taskmaster.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class P207_ReadingResultSet {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            // Step 1: Get Connection
            connection = P203_DBConnection.getConnection();

            // Step 2: Create Statement
            statement = connection.createStatement();

            // Step 3: SQL Query
            String sql = "SELECT * FROM projects";

            // Step 4: Execute Query
            resultSet = statement.executeQuery(sql);

            System.out.println("\nProjects Available\n");

            while (resultSet.next()) {

                int projectId = resultSet.getInt("project_id");

                String projectName = resultSet.getString("project_name");

                String status = resultSet.getString("status");

                System.out.println(
                        projectId + " | "
                                + projectName + " | "
                                + status);

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (resultSet != null)
                    resultSet.close();

                if (statement != null)
                    statement.close();

                if (connection != null)
                    connection.close();

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

}