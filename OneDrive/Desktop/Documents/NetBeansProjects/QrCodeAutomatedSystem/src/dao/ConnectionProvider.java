/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Sexon
 */
public class ConnectionProvider {
    private static final String DB_NAME = "QrCode_Automated_System";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_USERNAME = "root"; 
    private static final String DB_PASSWORD = "kerbypogi"; 

    public static Connection getCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            String serverUrl = DB_URL + "?serverTimezone=Asia/Kuala_Lumpur&useSSL=false";
            Connection con = DriverManager.getConnection(serverUrl, DB_USERNAME, DB_PASSWORD);
            
            
            if(!databaseExists(con, DB_NAME)){
                createDatabase(con, DB_NAME);
            }
            con.close(); // Close the server connection
            
            
            String dbUrl = DB_URL + DB_NAME + "?serverTimezone=Asia/Kuala_Lumpur&useSSL=false";
            con = DriverManager.getConnection(dbUrl, DB_USERNAME, DB_PASSWORD);
            
            return con; 
            
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    private static boolean databaseExists(Connection con, String dbName) throws Exception{
        Statement stmt = con.createStatement();
        return stmt.executeQuery("SHOW DATABASES LIKE '" + dbName + "'").next();
    }
    
    private static void createDatabase(Connection con, String dbName) throws Exception{
        Statement stmt = con.createStatement();
        stmt.executeUpdate("CREATE DATABASE " + dbName);
        System.out.println("Database '" + dbName + "' created successfully!");
    }
}