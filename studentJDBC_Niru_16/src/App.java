import java.sql.*;

public class App {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String pass = "";

        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(url, user, pass);

            // Insert 5 student records
            String insertQuery = "INSERT INTO student(Id, Name, Gender, Address) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertQuery);

            // Record 1
            pst.setInt(1, 1);
            pst.setString(2, "Anita");
            pst.setString(3, "Female");
            pst.setString(4, "Kathmandu");
            pst.executeUpdate();

            // Record 2
            pst.setInt(1, 2);
            pst.setString(2, "Bikash");
            pst.setString(3, "Male");
            pst.setString(4, "Bhaktapur");
            pst.executeUpdate();

            // Record 3
            pst.setInt(1, 3);
            pst.setString(2, "Sita");
            pst.setString(3, "Female");
            pst.setString(4, "Lalitpur");
            pst.executeUpdate();

            // Record 4
            pst.setInt(1, 4);
            pst.setString(2, "Kamal");
            pst.setString(3, "Male");
            pst.setString(4, "Pokhara");
            pst.executeUpdate();

            // Record 5
            pst.setInt(1, 5);
            pst.setString(2, "Rita");
            pst.setString(3, "Female");
            pst.setString(4, "Chitwan");
            pst.executeUpdate();

            System.out.println("5 Records Inserted Successfully!\n");

            // Display records in ascending order by Name
            String selectQuery = "SELECT * FROM student ORDER BY Name ASC";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(selectQuery);

            System.out.println("Student Records (Name Ascending Order):");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("Id") + " | " +
                                rs.getString("Name") + " | " +
                                rs.getString("Gender") + " | " +
                                rs.getString("Address"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
