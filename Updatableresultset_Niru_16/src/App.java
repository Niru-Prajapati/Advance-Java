import java.sql.*;
import java.util.Scanner;

public class App{

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/empdb"; // Your database
        String user = "root"; // MySQL username
        String pass = "";     // MySQL password

        Scanner sc = new Scanner(System.in);

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection con = DriverManager.getConnection(url, user, pass);

            // Get employee ID from user
            System.out.print("Enter Employee ID to update: ");
            int empId = sc.nextInt();
            sc.nextLine(); // consume newline

            // Create updatable ResultSet
            String query = "SELECT * FROM emptable WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(
                    query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            pst.setInt(1, empId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Current Employee Details:");
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getString("position") + " | " +
                                   rs.getDouble("salary"));

                // Get new name from user
                System.out.print("Enter new name for the employee: ");
                String newName = sc.nextLine();

                // Update the name in the ResultSet
                rs.updateString("name", newName);
                rs.updateRow(); // commit the update to the database

                System.out.println("Employee name updated successfully!");

            } else {
                System.out.println("Employee with ID " + empId + " not found.");
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
