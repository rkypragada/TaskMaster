package taskmaster.demo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class P213_InsertProject {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement codeStatement = null;
        ResultSet resultSet = null;

        try {

            connection = P203_DBConnection.getConnection();

            // -------------------------------
            // Generate Next Project Code
            // -------------------------------

            String projectCode = "";

            String codeSql =
                    "SELECT IFNULL(MAX(CAST(SUBSTRING(project_code,4) AS UNSIGNED)),0)+1 "
                  + "FROM projects";

            codeStatement = connection.prepareStatement(codeSql);

            resultSet = codeStatement.executeQuery();

            if (resultSet.next()) {

                int nextNumber = resultSet.getInt(1);

                projectCode = String.format("PRJ%03d", nextNumber);

            }

            resultSet.close();
            codeStatement.close();

            System.out.println("Generated Project Code : " + projectCode);

            // -------------------------------
            // Insert Project
            // -------------------------------

            String sql =
                    "INSERT INTO projects "
                  + "(project_code, project_name, description, start_date, "
                  + "end_date, budget, priority, status, manager_id) "
                  + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, projectCode);

            preparedStatement.setString(2,
                    "Library Management System");

            preparedStatement.setString(3,
                    "Automation of Library Operations");

            preparedStatement.setDate(4,
                    Date.valueOf("2026-07-01"));

            preparedStatement.setDate(5,
                    Date.valueOf("2026-12-31"));

            preparedStatement.setDouble(6,
                    500000.00);

            preparedStatement.setString(7,
                    "HIGH");

            preparedStatement.setString(8,
                    "ACTIVE");

            // Change this if manager_id = 1 does not exist
            preparedStatement.setLong(9, 1);

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {

                System.out.println();
                System.out.println("Project Inserted Successfully.");
                System.out.println("Project Code : " + projectCode);

            } else {

                System.out.println("Project Insertion Failed.");

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        finally {

            try {

                if (resultSet != null)
                    resultSet.close();

                if (codeStatement != null)
                    codeStatement.close();

                if (preparedStatement != null)
                    preparedStatement.close();

                if (connection != null)
                    connection.close();

            }

            catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

}