/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author Sexon
 */
public class tables {
    public static void main(String[]args){
        Connection con = null;
        Statement st = null;
        try{
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            
            if(!tableExists(st, "ImmStudentdetails")){
              st.executeUpdate("CREATE TABLE ImmStudentdetails (LRN BIGINT PRIMARY KEY, Name VARCHAR(255) NOT NULL, Gender VARCHAR(255) NOT NULL, Section VARCHAR(255) NOT NULL, Contact VARCHAR(255) NOT NULL, Adviser VARCHAR(255) NOT NULL, UniqueRegId VARCHAR(100) not null, imagename VARCHAR(100));");
            }
            if (!tableExists(st, "ImmStudentattendance")){
                st.executeUpdate("CREATE TABLE ImmStudentattendance (LRN BIGINT NOT NULL, Name VARCHAR(255) NOT NULL, Gender VARCHAR(255) NOT NULL, Section VARCHAR(255) NOT NULL, Date DATE NOT NULL, TimeIn DATETIME, TimeOut DATETIME, WorkDuration VARCHAR(100))");
            }
               JOptionPane.showMessageDialog(null, "Tables Checked/ Created Successfully");     
        
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);    
        }finally{
            try{
                if (con !=null){
                    con.close();
                }
                if (st!=null){
                    st.close();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
    }
    private static boolean tableExists(Statement st, String tableName)throws Exception{
        ResultSet resultSet = st.executeQuery("SHOW TABLES LIKE '" + tableName + "'");
        return resultSet.next();
    }
}