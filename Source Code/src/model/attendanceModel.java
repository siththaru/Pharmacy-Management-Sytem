
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class attendanceModel {
    Connection conn;
    static Logger log = Logger.getLogger(attendanceModel.class.getName());
    
    public attendanceModel(){
        conn = db.dbConnection.getConnection();
    }

    public String insertAttendance(String id) {
    String msg = null;
    String query = "INSERT INTO attendance (pharmacist_id, timeIn) VALUES (?,now())";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, id);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
}

    public void loadTable(String keyword, DefaultTableModel attendanceTableModel) {
        
        String runningQuery = "SELECT * FROM attendance a, pharmacist p WHERE a.pharmacist_id=p.pharmacist_id AND CAST(timeIn AS DATE) = CAST(NOW() AS DATE)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            attendanceTableModel.setRowCount(0);
            while(rs.next()){
                int id = rs.getInt("pharmacist_id");
                String name = rs.getString("name");
                int mobile = rs.getInt("mobile");
                Date dt = rs.getDate("timeIn");
                Date dt1 = rs.getTime("timeIn");
                Date dt2 = rs.getTime("timeOut");
                
                rowData = new Object[]{id, name,mobile, dt, dt1, dt2};
                attendanceTableModel.addRow(rowData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
    }

    public String updateAttendance(String id, Date dt) {
    String msg = null;
       String query1 = "UPDATE attendance SET timeOut=now() WHERE pharmacist_id=? AND CAST(timeIn AS DATE)=?";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query1);
            psm.setString(1, id);
            psm.setDate(2, new java.sql.Date(dt.getTime()));
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
        
        String query2 = "SELECT ROUND(TIMESTAMPDIFF(minute,`timeIn`,`timeOut`)/60,2) AS FractHours FROM attendance WHERE pharmacist_id=? AND CAST(timeIn AS DATE)=?";
        String day = "";
            try {
                PreparedStatement ps = conn.prepareStatement(query2);
                ps.setString(1, id);
                ps.setDate(2, new java.sql.Date(dt.getTime()));
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Double timeDiff = Double.parseDouble(rs.getString("FractHours"));
                    if(timeDiff<8){
                        day="Short Leave";
                        System.out.println("Short Leave");
                    }else{
                        day="Full Day";
                        System.out.println("Full Day");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.debug(e.getMessage());
            }
        
        String query3 = "UPDATE attendance SET status='"+day+"' WHERE pharmacist_id=? AND CAST(timeIn AS DATE)=?";
        
            try{
                PreparedStatement psm = conn.prepareStatement(query3);
                psm.setString(1, id);
                psm.setDate(2, new java.sql.Date(dt.getTime()));
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
