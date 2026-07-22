package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class P211_PreparedStatementDemo {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            // Step 1 : Get Database Connection
            connection = P203_DBConnection.getConnection();

            // Step 2 : SQL Query
            String sql =
                    "SELECT * FROM projects WHERE project_id = ?";

            // Step 3 : Create PreparedStatement
            preparedStatement =
                    connection.prepareStatement(sql);

            // Step 4 : Set Parameter
            preparedStatement.setInt(1, 1);

            // Step 5 : Execute Query
            resultSet =
                    preparedStatement.executeQuery();

            System.out.println("Project Details");

            while (resultSet.next()) {

                System.out.println(
                        resultSet.getInt("project_id")
                        + "  "
                        + resultSet.getString("project_name"));

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        finally {

            try {

                if(resultSet!=null)
                    resultSet.close();

                if(preparedStatement!=null)
                    preparedStatement.close();

                if(connection!=null)
                    connection.close();

            }

            catch(Exception e) {

                e.printStackTrace();

            }

        }

    }

}