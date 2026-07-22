package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class P218_CountTotalProjects {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = P203_DBConnection.getConnection();

            String sql =
                    "SELECT COUNT(*) AS total_projects "
                  + "FROM projects";

            preparedStatement =
                    connection.prepareStatement(sql);

            resultSet =
                    preparedStatement.executeQuery();

            if (resultSet.next()) {

                int totalProjects =
                        resultSet.getInt("total_projects");

                System.out.println("----------------------------------");
                System.out.println(" TASKMASTER PROJECT STATISTICS");
                System.out.println("----------------------------------");
                System.out.println("Total Projects : "
                        + totalProjects);
                System.out.println("----------------------------------");

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