package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class P212_StatementVsPreparedStatement {

    public static void main(String[] args) {

        Connection connection = null;

        Statement statement = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        try {

            connection = P203_DBConnection.getConnection();

            System.out.println("========== USING STATEMENT ==========");

            statement = connection.createStatement();

            resultSet =
                    statement.executeQuery(
                            "SELECT project_id, project_name FROM projects");

            while (resultSet.next()) {

                System.out.println(
                        resultSet.getInt("project_id")
                                + "  "
                                + resultSet.getString("project_name"));

            }

            resultSet.close();

            System.out.println();

            System.out.println("===== USING PREPARED STATEMENT =====");

            String sql =
                    "SELECT project_id, project_name FROM projects WHERE project_id > ?";

            preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setInt(1, 0);

            resultSet =
                    preparedStatement.executeQuery();

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

                if (resultSet != null)
                    resultSet.close();

                if (statement != null)
                    statement.close();

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