package taskmaster.demo;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class P224_JDBCBatchProcessing {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = P203_DBConnection.getConnection();

            // Disable Auto Commit
            connection.setAutoCommit(false);

            System.out.println("----------------------------------------");
            System.out.println("      JDBC BATCH PROCESSING DEMO");
            System.out.println("----------------------------------------");

            String sql = "UPDATE projects "
                    + "SET status = ? "
                    + "WHERE project_code = ?";

            preparedStatement = connection.prepareStatement(sql);

            // ==========================
            // Batch 1
            // ==========================
            preparedStatement.setString(1, "ACTIVE");
            preparedStatement.setString(2, "PRJ001");
            preparedStatement.addBatch();

            // ==========================
            // Batch 2
            // ==========================
            preparedStatement.setString(1, "COMPLETED");
            preparedStatement.setString(2, "PRJ002");
            preparedStatement.addBatch();

            // ==========================
            // Batch 3
            // ==========================
            preparedStatement.setString(1, "ON_HOLD");
            preparedStatement.setString(2, "PRJ003");
            preparedStatement.addBatch();

            // Execute Batch
            int[] results = preparedStatement.executeBatch();

            // Commit Transaction
            connection.commit();

            System.out.println();
            System.out.println("Batch Executed Successfully");
            System.out.println();

            for (int i = 0; i < results.length; i++) {

                if (results[i] > 0) {

                    System.out.println("Batch " + (i + 1)
                            + " : Success ("
                            + results[i]
                            + " row updated)");

                } else {

                    System.out.println("Batch " + (i + 1)
                            + " : No Record Found");

                }

            }

        }

        catch (BatchUpdateException e) {

            try {

                if (connection != null) {

                    connection.rollback();

                    System.out.println("Batch Rolled Back.");

                }

            } catch (Exception ex) {

                ex.printStackTrace();

            }

            System.out.println("\nBatch Update Error:");
            e.printStackTrace();

        }

        catch (Exception e) {

            try {

                if (connection != null) {

                    connection.rollback();

                    System.out.println("Transaction Rolled Back.");

                }

            } catch (Exception ex) {

                ex.printStackTrace();

            }

            e.printStackTrace();

        }

        finally {

            try {

                if (preparedStatement != null)
                    preparedStatement.close();

                if (connection != null) {

                    connection.setAutoCommit(true);

                    connection.close();

                }

            }

            catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

}