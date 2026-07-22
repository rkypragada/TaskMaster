package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;

public class P223_JDBCSavepoints {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;

        try {

            connection = P203_DBConnection.getConnection();

            connection.setAutoCommit(false);

            System.out.println("Transaction Started");

            // First Update
            String sql1 =
                    "UPDATE projects "
                  + "SET budget = budget + ? "
                  + "WHERE project_code = ?";

            statement1 = connection.prepareStatement(sql1);

            statement1.setDouble(1, 5000);

            statement1.setString(2, "PRJ001");

            statement1.executeUpdate();

            System.out.println("Budget Updated.");

            // Create Savepoint
            Savepoint savepoint =
                    connection.setSavepoint("BudgetUpdated");

            System.out.println("Savepoint Created.");

            // Second Update
            String sql2 =
                    "UPDATE projects "
                  + "SET priority = ? "
                  + "WHERE project_code = ?";

            statement2 = connection.prepareStatement(sql2);

            statement2.setString(1, "HIGH");

            statement2.setString(2, "INVALID_CODE");

            int rows = statement2.executeUpdate();

            if (rows == 0) {

                System.out.println("Second Update Failed.");

                connection.rollback(savepoint);

                System.out.println(
                        "Rolled Back To Savepoint.");

            }

            connection.commit();

            System.out.println("Transaction Committed.");

        }

        catch (Exception e) {

            try {

                if (connection != null) {

                    connection.rollback();

                    System.out.println(
                            "Full Transaction Rolled Back.");

                }

            }

            catch (Exception ex) {

                ex.printStackTrace();

            }

            e.printStackTrace();

        }

        finally {

            try {

                if (statement1 != null)
                    statement1.close();

                if (statement2 != null)
                    statement2.close();

                if (connection != null)
                    connection.close();

            }

            catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

}