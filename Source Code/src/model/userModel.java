
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class userModel {
        Connection conn;
        public static int userType;
        public static int pharmacistID;
        public static String workerName;
        static Logger log = Logger.getLogger(userModel.class.getName());
    public userModel(){
        conn = db.dbConnection.getConnection();
    }
    
    public String adminLogin(String username, String password){
        String msg = "";
        String query = "SELECT * FROM `owner` WHERE `username`='"+username+"' AND `password`='"+password+"' ";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String name = "";
            while(rs.next()){
                name = rs.getString("name");
            }
            if(name.equals("")){
                msg="Invalid username or password";}
            else{
                msg = "Welcome,"+name;
                userType = 1;
            }
        } catch (Exception e) {
            msg="Error"+e.getMessage();
            log.debug(e.getMessage());
        }
        if(msg.startsWith("Invalid")){
            query = "SELECT * FROM `pharmacist` WHERE `username`='"+username+"' AND `password`='"+password+"' ";
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String name = "";
                int isActive= 0;
                while(rs.next()){
                    name = rs.getString("name");
                    workerName = rs.getString("name");
                    isActive = rs.getInt("active");
                    pharmacistID = rs.getInt("pharmacist_id");
                }
                if(name.equals("")){
                    msg="Invalid username or password";
                }else if(isActive==0){
                    msg="Inactive User";
                }else{
                    msg = "Welcome,"+name;
                    userType = 2;
                }
            } catch (Exception e) {
                msg="Error"+e.getMessage();
                log.debug(e.getMessage());
            }
        }
        return msg;
    }
}