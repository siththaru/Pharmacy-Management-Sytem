
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbConnection {
    private static Connection conn;
    
    public static Connection getConnection(){
        if(conn==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/medcure_pharmacy?useSSL=false", "root", "Comp@123");
            } catch (Exception ex) {
                Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
                conn = null;
            }
        }
        return conn;
    }
    public static void main(String[] args) throws SQLException{
        System.out.println(getConnection().getCatalog());
    }
}
