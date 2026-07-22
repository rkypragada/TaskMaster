package taskmaster.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class P206_ExecuteFirstSelect {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            // Step 1: Get database connection
            connection = P203_DBConnection.getConnection();

            // Step 2: Create Statement
            statement = connection.createStatement();

            // Step 3: SQL Query
            String sql = "SELECT * FROM projects";

            // Step 4: Execute Query
            resultSet = statement.executeQuery(sql);

            System.out.println("Query Executed Successfully.");

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