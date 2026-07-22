package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class P216_SearchProjectByCode {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = P203_DBConnection.getConnection();

            String sql =
                    "SELECT project_code, project_name, description, "
                  + "start_date, end_date, budget, priority, "
                  + "status, manager_id "
                  + "FROM projects "
                  + "WHERE project_code = ?";

            preparedStatement =
                    connection.prepareStatement(sql);

            // Change the project code as required
            preparedStatement.setString(1, "PRJ001");

            resultSet =
                    preparedStatement.executeQuery();

            if (resultSet.next()) {

                System.out.println("==========================================");
                System.out.println("        PROJECT DETAILS");
                System.out.println("==========================================");

                System.out.println("Project Code : "
                        + resultSet.getString("project_code"));

                System.out.println("Project Name : "
                        + resultSet.getString("project_name"));

                System.out.println("Description  : "
                        + resultSet.getString("description"));

                System.out.println("Start Date   : "
                        + resultSet.getDate("start_date"));

                System.out.println("End Date     : "
                        + resultSet.getDate("end_date"));

                System.out.println("Budget       : "
                        + resultSet.getDouble("budget"));

                System.out.println("Priority     : "
                        + resultSet.getString("priority"));

                System.out.println("Status       : "
                        + resultSet.getString("status"));

                System.out.println("Manager ID   : "
                        + resultSet.getLong("manager_id"));

            } else {

                System.out.println("Project Not Found.");

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