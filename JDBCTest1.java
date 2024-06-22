import java.sql.*;

public class JDBCTest1 {
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String user = "system";
    private static String pass = "sastra123";

    public static void main(String args[]) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, pass);
        ps = con.prepareStatement("SELECT * FROM student1");
        rs = ps.executeQuery();
        while (rs.next()) {
            int rno = rs.getInt("rno");
            String name = rs.getString("name");
            double cgpa = rs.getDouble("cgpa");
            System.out.println(rno + " - " + name + " - " + cgpa);
        }
        rs.close();
        ps.close();
        con.close();
    }
}
