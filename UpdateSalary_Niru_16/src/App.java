import java.sql.*;

public class App{

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db"; // Change database name if needed
        String user = "root";
        String pass = "";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, pass);

            // Update salary by 15% where salary < 20000
            String updateQuery = "UPDATE student SET Salary = Salary * 1.15 WHERE Salary < 20000";
            Statement st = con.createStatement();
            int rows = st.executeUpdate(updateQuery);

            System.out.println(rows + " record(s) updated successfully!");

            // Display updated records
            String selectQuery = "SELECT * FROM student";
            ResultSet rs = st.executeQuery(selectQuery);

            System.out.println("\nUpdated Student Records:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("Id") + " | " +
                        rs.getString("Name") + " | " +
                        rs.getDouble("Salary") + " | " +
                        rs.getString("Gender")
                );
            }

            // Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
