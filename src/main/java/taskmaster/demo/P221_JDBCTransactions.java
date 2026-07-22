package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class P221_JDBCTransactions {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = P203_DBConnection.getConnection();

            System.out.println("--------------------------------");
            System.out.println("JDBC TRANSACTION DEMO");
            System.out.println("--------------------------------");

            System.out.println("Default Auto Commit : "
                    + connection.getAutoCommit());

            // Disable Auto Commit
            connection.setAutoCommit(false);

            System.out.println("Auto Commit Disabled.");

            // Update one project
            String sql =
                    "UPDATE projects "
                  + "SET budget = budget + ? "
                  + "WHERE project_code = ?";

            preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setDouble(1, 10000);

            preparedStatement.setString(2, "PRJ001");

            int rows =
                    preparedStatement.executeUpdate();

            if (rows > 0) {

                System.out.println("Budget Updated.");

                // Save changes
                connection.commit();

                System.out.println("Transaction Committed.");

            } else {

                System.out.println("Project Not Found.");

                connection.rollback();

                System.out.println("Transaction Rolled Back.");

            }

        }

        catch (Exception e) {

            try {

                if (connection != null) {

                    connection.rollback();

                    System.out.println("Transaction Rolled Back Due To Error.");

                }

            }

            catch (Exception ex) {

                ex.printStackTrace();

            }

            e.printStackTrace();

        }

        finally {

            try {

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