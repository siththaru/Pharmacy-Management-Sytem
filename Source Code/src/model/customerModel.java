
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class customerModel {
    Connection conn;
    static Logger log = Logger.getLogger(customerModel.class.getName());
    
    public customerModel(){
        conn = db.dbConnection.getConnection();
    }

    public String insertCustomer(String mobile, String name, String email) {
    
    String msg = "null";
    
        String runningQuery = "SELECT * FROM customer";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String mob = String.valueOf(rs.getInt("mobile"));
                if(mob.equalsIgnoreCase(mobile)){
                    msg = "Customer already added";
                }
            }    
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    
        if(msg=="null"){
            String query = "INSERT INTO customer (mobile, name, email, isactive) VALUES(?,?,?,'1')";
    
            try {
                PreparedStatement psm = conn.prepareStatement(query);

                    psm.setString(1, mobile);
                    psm.setString(2, name);
                    psm.setString(3, email);
                    psm.execute();
                msg="Success";
            } catch (Exception e) {
                e.printStackTrace();
                msg="Error : "+e.getMessage();
                log.debug(e.getMessage());
            }
        }
    return msg;
}

    public void loadTable(String keyword, DefaultTableModel customerTableModel) {
        String runningQuery = "SELECT * FROM customer WHERE mobile LIKE ? AND isactive='1'";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            customerTableModel.setRowCount(0);
            while(rs.next()){
                int mobile = rs.getInt("mobile");
                String name = rs.getString("name");
                String email = rs.getString("email");
                
                rowData = new Object[]{mobile,name,email};
                customerTableModel.addRow(rowData);
            }    
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
    
    public void loadDeletedTable(String keyword, DefaultTableModel customerTableModel) {
        String runningQuery = "SELECT * FROM customer WHERE mobile LIKE ? AND isactive='0'";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            customerTableModel.setRowCount(0);
            while(rs.next()){
                int mobile = rs.getInt("mobile");
                String name = rs.getString("name");
                
                rowData = new Object[]{mobile,name};
                customerTableModel.addRow(rowData);
            }    
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public Object[] getSelectedUserDataById(int customerMob) {
        String runningQuery = "SELECT * FROM customer WHERE `mobile` = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setInt(1, customerMob);
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData = null;
            while(rs.next()){
                int mobile = rs.getInt("mobile");
                String name = rs.getString("name");
                String email = rs.getString("email");
                
                rowData = new Object[]{mobile,name,email};
            }
            return rowData;
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return null;
    }

    public String updateUser(String mob, String name, String email) {
       String msg = null;
       String query = "UPDATE customer SET name=?, email=? WHERE mobile=? ";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, email);
            psm.setString(3, mob);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
    }
    
    public String restoreUser(String mob) {
       String msg = null;
       String query = "UPDATE customer SET isactive='1' WHERE mobile=? ";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, mob);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
        return msg;
    }
    
    public String deleteUser(String mob) {

        String msg = null;
       String query = "UPDATE customer SET isactive='0' WHERE mobile=? ";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, mob);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
        return msg;
    }
}
