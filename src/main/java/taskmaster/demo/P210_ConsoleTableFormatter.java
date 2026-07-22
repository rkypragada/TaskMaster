package taskmaster.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class P210_ConsoleTableFormatter {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection = P203_DBConnection.getConnection();

            statement = connection.createStatement();

            resultSet = statement.executeQuery(
                    "SELECT * FROM projects");

            ResultSetMetaData metaData =
                    resultSet.getMetaData();

            int columnCount =
                    metaData.getColumnCount();

            // Print Header
            for (int i = 1; i <= columnCount; i++) {

                System.out.printf("| %-20s",
                        metaData.getColumnName(i));

            }

            System.out.println("|");

            // Print Separator
            for (int i = 1; i <= columnCount; i++) {

                System.out.print("+----------------------");

            }

            System.out.println("+");

            // Print Records
            while (resultSet.next()) {

                for (int i = 1; i <= columnCount; i++) {

                    System.out.printf("| %-20s",
                            resultSet.getString(i));

                }

                System.out.println("|");

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        finally {

            try {

                if (resultSet != null)
                    resultSet.close();

                if (statement != null)
                    statement.close();

                if (connection != null)
                    connection.close();

            }

            catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

}