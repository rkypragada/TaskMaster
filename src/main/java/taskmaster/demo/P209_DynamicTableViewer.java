package taskmaster.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class P209_DynamicTableViewer {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            // Step 1: Get Connection
            connection = P203_DBConnection.getConnection();

            // Step 2: Create Statement
            statement = connection.createStatement();

            // Step 3: Execute Query
            resultSet = statement.executeQuery("SELECT * FROM projects");

            // Step 4: Get Metadata
            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();

            // Print Column Headers
            for (int i = 1; i <= columnCount; i++) {

                System.out.printf("%-20s",
                        metaData.getColumnName(i));

            }

            System.out.println();

            System.out.println("----------------------------------------------------------------------------------------------");

            // Print Records
            while (resultSet.next()) {

                for (int i = 1; i <= columnCount; i++) {

                    System.out.printf("%-20s",
                            resultSet.getString(i));

                }

                System.out.println();

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