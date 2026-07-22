package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class P217_SearchProjectsByStatus {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = P203_DBConnection.getConnection();

            String sql =
                    "SELECT project_code, project_name, budget, priority, status "
                  + "FROM projects "
                  + "WHERE status = ? "
                  + "ORDER BY project_name";

            preparedStatement =
                    connection.prepareStatement(sql);

            // Change the status as required
            preparedStatement.setString(1, "ACTIVE");

            resultSet =
                    preparedStatement.executeQuery();

            System.out.println("==========================================================================");
            System.out.printf("%-12s %-35s %-12s %-12s %-12s%n",
                    "Code", "Project Name", "Budget", "Priority", "Status");
            System.out.println("==========================================================================");

            boolean found = false;

            while (resultSet.next()) {

                found = true;

                System.out.printf(
                        "%-12s %-35s %-12.2f %-12s %-12s%n",
                        resultSet.getString("project_code"),
                        resultSet.getString("project_name"),
                        resultSet.getDouble("budget"),
                        resultSet.getString("priority"),
                        resultSet.getString("status"));
            }

            if (!found) {

                System.out.println("No projects found with the specified status.");

            }

            System.out.println("==========================================================================");

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