package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class P222_MoneyTransferTransaction {

    public static void main(String[] args) {

        Connection connection = null;

        PreparedStatement debitStatement = null;

        PreparedStatement creditStatement = null;

        try {

            connection = P203_DBConnection.getConnection();

            // Disable Auto Commit
            connection.setAutoCommit(false);

            double amount = 5000.00;

            // Debit Account
            String debitSQL =
                    "UPDATE accounts "
                  + "SET balance = balance - ? "
                  + "WHERE account_id = ?";

            debitStatement =
                    connection.prepareStatement(debitSQL);

            debitStatement.setDouble(1, amount);

            debitStatement.setInt(2, 1);

            debitStatement.executeUpdate();

            // Credit Account
            String creditSQL =
                    "UPDATE accounts "
                  + "SET balance = balance + ? "
                  + "WHERE account_id = ?";

            creditStatement =
                    connection.prepareStatement(creditSQL);

            creditStatement.setDouble(1, amount);

            creditStatement.setInt(2, 2);

            creditStatement.executeUpdate();

            // Save changes
            connection.commit();

            System.out.println("Transaction Completed Successfully.");

        }

        catch (Exception e) {

            try {

                if (connection != null) {

                    connection.rollback();

                    System.out.println("Transaction Rolled Back.");

                }

            }

            catch (Exception ex) {

                ex.printStackTrace();

            }

            e.printStackTrace();

        }

        finally {

            try {

                if (debitStatement != null)
                    debitStatement.close();

                if (creditStatement != null)
                    creditStatement.close();

                if (connection != null)
                    connection.close();

            }

            catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

}