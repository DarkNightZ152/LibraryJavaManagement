package giaodien;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author nvcam
 */
public class DBconnection {
    public static Connection geConnection(){
        Connection con = null;
        try {
            

//            Class.forName("con.microsoft.sqlserver.jdbc.SQLServer");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLTVjava";
            String user = "sa";
            String pass = "123";
            
           con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
            System.out.println("Connected");
     
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static void closeConnection(Connection conn){
        if (conn != null) {
            try {
                    conn.close();
            } catch (Exception e) {
                    e.printStackTrace();
            }
        }    
    }
    
    public static void main(String[] args) {
        System.out.println(geConnection());
    }

 
  
}
