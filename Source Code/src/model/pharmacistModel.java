package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class pharmacistModel {
    Connection conn;
    int pid;
    static Logger log = Logger.getLogger(pharmacistModel.class.getName());
    public pharmacistModel(){
        conn = db.dbConnection.getConnection();
        pid = userModel.pharmacistID;
    }

    public String insertPharmacist(String name, String mobile, String address, String experience, boolean active) {
    
    String msg = null;
    String query = "INSERT INTO pharmacist (name, mobile, address, experience, active) VALUES (?,?,?,?,?)";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, mobile);
            psm.setString(3, address);
            psm.setString(4, experience);
            psm.setBoolean(5, active);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
    }
    
    public String insertCredentials(String username, String password) {
    String msg = null;
    String query = "SELECT `username` FROM pharmacist";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String uname = rs.getString("username");
                
                if(uname.equalsIgnoreCase(username)){
                    msg = "Username already exists";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
        if(msg==null){
            query = "UPDATE pharmacist SET username=?, password=? WHERE pharmacist_id=?";

            try {
                    PreparedStatement psm = conn.prepareStatement(query);
                    psm.setString(1, username);
                    psm.setString(2, password);
                    psm.setInt(3, pid);
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

    public void loadTable(String keyword, DefaultTableModel pharmacistTableModel) {
        
        String runningQuery = "SELECT * FROM pharmacist WHERE name LIKE ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            pharmacistTableModel.setRowCount(0);
            while(rs.next()){
                int id = rs.getInt("pharmacist_id");
                String name = rs.getString("name");
                int mobile = rs.getInt("mobile");
                String address = rs.getString("address");
                String experience = rs.getString("experience");
                boolean isActive = rs.getBoolean("active");
                
                rowData = new Object[]{id,name,mobile,address,experience,isActive};
                pharmacistTableModel.addRow(rowData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
    }
    
    public void loadComboBox(DefaultComboBoxModel comboBoxModel) {
        
        String runningQuery = "SELECT * FROM salary ORDER BY salary_per_day DESC";
        
        comboBoxModel.removeAllElements();
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String experience = rs.getString("experience");
                
                comboBoxModel.addElement(experience);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
    }

    public String updatePharmacist(String id, String name, String mobile, String address, String experience, boolean active) {
       String msg = null;
       String query = "UPDATE pharmacist SET name=?, mobile=?, address=?, experience=?, active=? WHERE pharmacist_id=? ";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, mobile);
            psm.setString(3, address);
            psm.setString(4, experience);
            psm.setBoolean(5, active);
            psm.setString(6, id);
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
