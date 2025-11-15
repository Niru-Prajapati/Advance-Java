import java.sql.*;

public class EmployeeNavigation {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/empdb"; // Replace with your DB
        String user = "root"; // MySQL username
        String pass = ""; // MySQL password

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, pass);

            // Create scrollable ResultSet
            Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT * FROM emptable";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("=== First Employee Record ===");
            if (rs.first()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("position") + " | " +
                        rs.getDouble("salary"));
            }

            System.out.println("\n=== Last Employee Record ===");
            if (rs.last()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("position") + " | " +
                        rs.getDouble("salary"));
            }

            System.out.println("\n=== Previous Employee Record (from last) ===");
            if (rs.previous()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("position") + " | " +
                        rs.getDouble("salary"));
            }

            System.out.println("\n=== Next Employee Record (from previous) ===");
            if (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("position") + " | " +
                        rs.getDouble("salary"));
            }

            // Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
