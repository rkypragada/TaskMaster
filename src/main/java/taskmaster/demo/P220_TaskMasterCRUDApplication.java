package taskmaster.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class P220_TaskMasterCRUDApplication {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("     TASKMASTER CRUD APPLICATION");
            System.out.println("======================================");
            System.out.println("1. Count Total Projects");
            System.out.println("2. Search Project by Code");
            System.out.println("3. Check Project Exists");
            System.out.println("4. Search Projects by Status");
            System.out.println("5. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice : ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    countProjects();
                    break;

                case 2:
                    searchProject();
                    break;

                case 3:
                    checkProjectExists();
                    break;

                case 4:
                    searchProjectsByStatus();
                    break;

                case 5:
                    System.out.println("Thank You...");
                    break;

                default:
                    System.out.println("Invalid Choice.");

            }

        } while (choice != 5);

        scanner.close();

    }

    // -----------------------------------------------------

    static void countProjects() {

        try (Connection connection = P203_DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT COUNT(*) total FROM projects");
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                System.out.println();
                System.out.println("Total Projects : "
                        + rs.getInt("total"));

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // -----------------------------------------------------

    static void searchProject() {

        try (Connection connection = P203_DBConnection.getConnection()) {

            System.out.print("Enter Project Code : ");
            String code = scanner.nextLine();

            PreparedStatement ps =
                    connection.prepareStatement(
                            "SELECT * FROM projects WHERE project_code=?");

            ps.setString(1, code);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("--------------------------------");

                System.out.println("Project Code : "
                        + rs.getString("project_code"));

                System.out.println("Project Name : "
                        + rs.getString("project_name"));

                System.out.println("Description  : "
                        + rs.getString("description"));

                System.out.println("Budget       : "
                        + rs.getDouble("budget"));

                System.out.println("Priority     : "
                        + rs.getString("priority"));

                System.out.println("Status       : "
                        + rs.getString("status"));

                System.out.println("Manager ID   : "
                        + rs.getLong("manager_id"));

                System.out.println("--------------------------------");

            } else {

                System.out.println("Project Not Found.");

            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // -----------------------------------------------------

    static void checkProjectExists() {

        try (Connection connection = P203_DBConnection.getConnection()) {

            System.out.print("Enter Project Code : ");

            String code = scanner.nextLine();

            PreparedStatement ps =
                    connection.prepareStatement(
                            "SELECT COUNT(*) total FROM projects WHERE project_code=?");

            ps.setString(1, code);

            ResultSet rs = ps.executeQuery();

            rs.next();

            if (rs.getInt("total") > 0) {

                System.out.println("Project Exists.");

            } else {

                System.out.println("Project Does Not Exist.");

            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // -----------------------------------------------------

    static void searchProjectsByStatus() {

        try (Connection connection = P203_DBConnection.getConnection()) {

            System.out.print("Enter Status : ");

            String status = scanner.nextLine();

            PreparedStatement ps =
                    connection.prepareStatement(
                            "SELECT project_code,project_name,budget,priority,status "
                                    + "FROM projects WHERE status=?");

            ps.setString(1, status);

            ResultSet rs = ps.executeQuery();

            System.out.println();

            System.out.printf("%-10s %-35s %-12s %-12s %-12s%n",
                    "Code",
                    "Project Name",
                    "Budget",
                    "Priority",
                    "Status");

            System.out.println("--------------------------------------------------------------------------");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.printf("%-10s %-35s %-12.2f %-12s %-12s%n",

                        rs.getString("project_code"),

                        rs.getString("project_name"),

                        rs.getDouble("budget"),

                        rs.getString("priority"),

                        rs.getString("status"));

            }

            if (!found) {

                System.out.println("No Projects Found.");

            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}