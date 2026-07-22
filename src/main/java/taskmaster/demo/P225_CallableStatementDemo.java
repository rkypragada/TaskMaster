package taskmaster.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class P225_CallableStatementDemo {

    public static void main(String[] args) {

        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {

            // Get Connection
            connection = P203_DBConnection.getConnection();

            // Verify Current Database
            statement = connection.createStatement();

            ResultSet dbResult =
                    statement.executeQuery("SELECT DATABASE()");

            if (dbResult.next()) {

                System.out.println("-----------------------------------");
                System.out.println("Current Database : "
                        + dbResult.getString(1));
                System.out.println("-----------------------------------");

            }

            dbResult.close();

            // Fully Qualified Stored Procedure Name
            String procedure =
                    "{CALL taskmaster.GetProjectByCode(?)}";

            callableStatement =
                    connection.prepareCall(procedure);

            // Input Parameter
            callableStatement.setString(1, "PRJ001");

            // Execute Procedure
            resultSet =
                    callableStatement.executeQuery();

            if (resultSet.next()) {

                System.out.println();
                System.out.println("====================================");
                System.out.println("         PROJECT DETAILS");
                System.out.println("====================================");

                System.out.println("Project ID    : "
                        + resultSet.getInt("project_id"));

                System.out.println("Project Code  : "
                        + resultSet.getString("project_code"));

                System.out.println("Project Name  : "
                        + resultSet.getString("project_name"));

                System.out.println("Description   : "
                        + resultSet.getString("description"));

                System.out.println("Start Date    : "
                        + resultSet.getDate("start_date"));

                System.out.println("End Date      : "
                        + resultSet.getDate("end_date"));

                System.out.println("Budget        : "
                        + resultSet.getDouble("budget"));

                System.out.println("Priority      : "
                        + resultSet.getString("priority"));

                System.out.println("Status        : "
                        + resultSet.getString("status"));

                System.out.println("Manager ID    : "
                        + resultSet.getInt("manager_id"));

                System.out.println("====================================");

            } else {

                System.out.println("Project Not Found.");

            }

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

            e.printStackTrace();

        } finally {

            try {

                if (resultSet != null)
                    resultSet.close();

                if (callableStatement != null)
                    callableStatement.close();

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