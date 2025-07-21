import java.sql.*;
public class connectjava_sql {
    
    public static void main(String[]args) throws ClassNotFoundException{
        try {
    String hostname = "localhost\\SQLEXPRESS";
    String sqlInstanceName = "DESKTOP-AE83B91\\SQLEXPRESS";
    String sqlDatabase = "fornetbeans1";  // Removed leading space
    String sqlUser = "sa";
    String sqlPassword = "kerbypogi";
    
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    
    // Fixed the missing + operator
    String connectURL = "jdbc:sqlserver://" + hostname + ":1433" + ";instance=" + sqlInstanceName + ";databaseName=" + sqlDatabase + ";encrypt=true;trustServerCertificate=true";
    
    Connection conn = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);
    System.out.println("Connect to database successful!!");
    
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
