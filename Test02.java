import java.sql.*;
import java.util.*;

public class Test02 {

    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String pass = "sastra123";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            return;
        }

        try (Connection con = DriverManager.getConnection(url, user, pass);
            
             Scanner input = new Scanner(System.in)) {

            System.out.println("Connected to the database");
            int choice;

            do {
                System.out.println("\n1. Add Student \n2. Display All \n3. Search \n4. Delete \n5. Exit");
                System.out.print("Enter your choice: ");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        addStudent(con, input);
                        break;
                    case 2:
                        displayAllStudents(con);
                        break;
                    case 3:
                        searchStudent(con, input);
                        break;
                    case 4:
                        deleteStudent(con, input);
                        break;
                    case 5:
                        System.out.println("Thank you");
                        break;
                    default:
                        System.out.println("Invalid choice...");
                        break;
                }

            } while (choice != 5);

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    private static void addStudent(Connection con, Scanner input) throws SQLException {
        System.out.print("Enter rno, name and cgpa: ");
        int rno = input.nextInt();
        String name = input.next();
        float cgpa = input.nextFloat();

        String sql = "INSERT INTO student1 (rno, name, cgpa) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rno);
            ps.setString(2, name);
            ps.setDouble(3, cgpa);
            int result = ps.executeUpdate();
        
            if (result > 0) {
                System.out.println("Student added successfully.");
            }
        }
    }

    private static void displayAllStudents(Connection con) throws SQLException {
        String sql = "SELECT * FROM student1";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int rno = rs.getInt("rno");
                String name = rs.getString("name");
                float cgpa = rs.getFloat("cgpa");
                System.out.println(rno + " - " + name + " - " + cgpa);
            }
        }
    }

    private static void searchStudent(Connection con, Scanner input) throws SQLException {
        System.out.print("Enter rno to search: ");
        int rno = input.nextInt();

        String sql = "SELECT * FROM student1 WHERE rno=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rno);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    float cgpa = rs.getFloat("cgpa");
                    System.out.println(rno + " - " + name + " - " + cgpa);
                } else {
                    System.out.println("Details not found...");
                }
            }
        }
    }

    private static void deleteStudent(Connection con, Scanner input) throws SQLException {
        System.out.print("Enter rno to delete: ");
        int rno = input.nextInt();

        String sql = "DELETE FROM student1 WHERE rno=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rno);
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println(rno + " - Deleted successfully...");
            } else {
                System.out.println("Details not found...");
            }
        }
    }
}
