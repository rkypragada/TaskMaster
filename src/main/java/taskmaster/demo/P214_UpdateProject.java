package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class P214_UpdateProject {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = P203_DBConnection.getConnection();

            String sql =
                    "UPDATE projects "
                  + "SET project_name=?, "
                  + "description=?, "
                  + "budget=?, "
                  + "priority=?, "
                  + "status=? "
                  + "WHERE project_code=?";

            preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1,
                    "Advanced Library Management System");

            preparedStatement.setString(2,
                    "Library Automation with Barcode Support");

            preparedStatement.setDouble(3,
                    750000.00);

            preparedStatement.setString(4,
                    "CRITICAL");

            preparedStatement.setString(5,
                    "ACTIVE");

            // Existing Project Code
            preparedStatement.setString(6,
                    "PRJ011");

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0) {

                System.out.println();
                System.out.println("Project Updated Successfully.");

            }
            else {

                System.out.println();
                System.out.println("Project Code Not Found.");

            }

        }

        catch(Exception e) {

            e.printStackTrace();

        }

        finally {

            try {

                if(preparedStatement != null)
                    preparedStatement.close();

                if(connection != null)
                    connection.close();

            }

            catch(Exception e) {

                e.printStackTrace();

            }

        }

    }

}