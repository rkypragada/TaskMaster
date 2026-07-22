package taskmaster.demo;

import java.sql.Connection;

public class P204_TestConnection {

    public static void main(String[] args) {

        Connection connection =
                P203_DBConnection.getConnection();

        if (connection != null) {

            System.out.println(
                    "=================================="
            );

            System.out.println(
                    " Connected to TaskMaster Database "
            );

            System.out.println(
                    "=================================="
            );

            try {
                connection.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }

        else {

            System.out.println(
                    "Connection Failed"
            );

        }

    }

}