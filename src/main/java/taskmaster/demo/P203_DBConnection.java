package taskmaster.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class P203_DBConnection {

	public static Connection getConnection() {

	        Connection connection = null;

	        try {

	            String url = "jdbc:mysql://localhost:3306/taskmaster?useSSL=false&serverTimezone=UTC";

	            String username = "root";

	            String password = "root";

	            connection = DriverManager.getConnection(
	                    url,
	                    username,
	                    password
	            );

	            System.out.println("Connected Successfully");

	        }

	        catch (Exception e) {

	            e.printStackTrace();

	        }

	        return connection;

	    }

}
