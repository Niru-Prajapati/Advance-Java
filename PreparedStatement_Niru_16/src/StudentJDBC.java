import java.sql.*;

public class StudentJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // Replace with your DB name
        String user = "root"; // MySQL username
        String pass = "";     // MySQL password

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, pass);

            // Create tblStudent table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS tblStudent (" +
                                      "id INT PRIMARY KEY, " +
                                      "name VARCHAR(50), " +
                                      "email VARCHAR(50))";
            Statement stmt = con.createStatement();
            stmt.execute(createTableQuery);
            System.out.println("Table tblStudent created successfully (if it did not exist).");

            // Insert a record using PreparedStatement
            String insertQuery = "INSERT INTO tblStudent(id, name, email) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertQuery);

           pst.setInt(1, 2); // Change 1 to 2 or any unused id
pst.setString(2, "Anita");
pst.setString(3, "anita@example.com");
            int rows = pst.executeUpdate();
            System.out.println(rows + " record(s) inserted successfully!");

            // Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
