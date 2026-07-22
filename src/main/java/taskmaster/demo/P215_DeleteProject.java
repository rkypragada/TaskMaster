package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class P215_DeleteProject {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = P203_DBConnection.getConnection();

            String sql =
                    "DELETE FROM projects WHERE project_code = ?";

            preparedStatement =
                    connection.prepareStatement(sql);

            // Change this to the project you want to delete
            preparedStatement.setString(1, "PRJ011");

            int rows =
                    preparedStatement.executeUpdate();

            if (rows > 0) {

                System.out.println();
                System.out.println("Project Deleted Successfully.");

            }
            else {

                System.out.println();
                System.out.println("Project Code Not Found.");

            }

        }

        catch (Exception e) {

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