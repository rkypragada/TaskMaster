package taskmaster.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class P226_DatabaseMetaDataDemo {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = P203_DBConnection.getConnection();

            System.out.println("========================================");
            System.out.println("      DATABASE METADATA");
            System.out.println("========================================");

            DatabaseMetaData dbMeta =
                    connection.getMetaData();

            System.out.println("Database Product : "
                    + dbMeta.getDatabaseProductName());

            System.out.println("Database Version : "
                    + dbMeta.getDatabaseProductVersion());

            System.out.println("Driver Name      : "
                    + dbMeta.getDriverName());

            System.out.println("Driver Version   : "
                    + dbMeta.getDriverVersion());

            System.out.println("JDBC URL         : "
                    + dbMeta.getURL());

            System.out.println("User Name        : "
                    + dbMeta.getUserName());

            System.out.println();

            String sql =
                    "SELECT * FROM projects LIMIT 1";

            preparedStatement =
                    connection.prepareStatement(sql);

            resultSet =
                    preparedStatement.executeQuery();

            ResultSetMetaData rsMeta =
                    resultSet.getMetaData();

            System.out.println("========================================");
            System.out.println("      RESULTSET METADATA");
            System.out.println("========================================");

            int columnCount = rsMeta.getColumnCount();

            System.out.println("Total Columns : "
                    + columnCount);

            System.out.println();

            System.out.printf("%-5s %-25s %-20s %-10s%n",
                    "No",
                    "Column Name",
                    "Data Type",
                    "Size");

            System.out.println("---------------------------------------------------------------");

            for (int i = 1; i <= columnCount; i++) {

                System.out.printf("%-5d %-25s %-20s %-10d%n",

                        i,

                        rsMeta.getColumnName(i),

                        rsMeta.getColumnTypeName(i),

                        rsMeta.getColumnDisplaySize(i));

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        finally {

            try {

                if (resultSet != null)
                    resultSet.close();

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