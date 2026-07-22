package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class P219_CheckProjectExists {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = P203_DBConnection.getConnection();

            String projectCode = "PRJ001";

            String sql =
                    "SELECT COUNT(*) AS project_count "
                  + "FROM projects "
                  + "WHERE project_code = ?";

            preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, projectCode);

            resultSet =
                    preparedStatement.executeQuery();

            if (resultSet.next()) {

                int count =
                        resultSet.getInt("project_count");

                System.out.println("-------------------------------------");
                System.out.println("PROJECT VALIDATION RESULT");
                System.out.println("-------------------------------------");

                if (count > 0) {

                    System.out.println("Project Code : " + projectCode);
                    System.out.println("Status       : Project Exists");

                } else {

                    System.out.println("Project Code : " + projectCode);
                    System.out.println("Status       : Project Does Not Exist");

                }

                System.out.println("-------------------------------------");

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