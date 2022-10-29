
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Year;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class salaryModel {
    Connection conn;
    static Logger log = Logger.getLogger(salaryModel.class.getName());
    
    public salaryModel(){
        conn = db.dbConnection.getConnection();
    }

    public String insertPharmacistPayment(String pId, int month, String totSalary) {
        String msg = null;
        
        String query = "SELECT * FROM sallery_per_pharmacist";
        String strMonth = "";
            if(String.valueOf(month).length()==1){
                strMonth = "0"+String.valueOf(month);
            }
        int year = Year.now().getValue();
        String mmyyyy = strMonth+"/"+String.valueOf(year);
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int pid = rs.getInt("pharmacist_id");
                String monthYear = rs.getString("month/year");
                double salary = rs.getDouble("total_salary");
                if(String.valueOf(pid).equalsIgnoreCase(pId) && monthYear.equalsIgnoreCase(mmyyyy) && String.valueOf(salary).equalsIgnoreCase(totSalary)){
                    msg = "Salary already paid";
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        if(msg==null){
            strMonth = "";
            if(String.valueOf(month).length()==1){
                strMonth = "0"+String.valueOf(month);
            }
            query = "INSERT INTO sallery_per_pharmacist (`pharmacist_id`, `month/year`, `total_salary`) VALUES (?,CONCAT(?,?,YEAR(CURDATE())),?)";

                try {
                    PreparedStatement psm = conn.prepareStatement(query);
                    psm.setString(1, pId);
                    psm.setString(2, strMonth);
                    psm.setString(3, "/");
                    psm.setString(4, totSalary);
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

    public void loadTable(String keyword, DefaultTableModel salaryTableModel) {
        
        String runningQuery = "SELECT * FROM sallery_per_pharmacist s, pharmacist p WHERE s.pharmacist_id=p.pharmacist_id  AND p.name LIKE ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            salaryTableModel.setRowCount(0);
            while(rs.next()){
                String name = rs.getString("name");
                int mobile = rs.getInt("mobile");
                String month = rs.getString("month/year");
                double salary = rs.getDouble("total_salary");
                
                rowData = new Object[]{name, mobile, month, salary};
                salaryTableModel.addRow(rowData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
    }
    
    public String insertSalaries(String experience, String salary) {
    
    String msg = null;
    String query = "INSERT INTO salary (experience, salary_per_day) VALUES(?,?)";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, experience);
            psm.setString(2, salary);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
    }
    
    public String updateSalaries(String experience, String salary) {
    
    String msg = null;
    String query = "UPDATE salary SET salary_per_day=? WHERE experience=? ";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, salary);
            psm.setString(2, experience);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
    }
    
    public void loadSalaryTable(String keyword, DefaultTableModel salaryTableModel) {
        
        String query = "SELECT * FROM salary WHERE experience LIKE ? ORDER BY salary_per_day ASC";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            salaryTableModel.setRowCount(0);
            while(rs.next()){
                String experience = rs.getString("experience");
                double daySalary = rs.getDouble("salary_per_day");
                String strDaySalary = String.valueOf(daySalary);
                
                rowData = new Object[]{experience,strDaySalary};
                salaryTableModel.addRow(rowData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
    }
    
    public double getAttendanceForSalary(int pId, int month) {
        
        String query = "SELECT * FROM attendance WHERE MONTH(timeIn)=? AND YEAR(timeIn)=YEAR(CURDATE()) AND pharmacist_id=?";
        double totalDays = 0.0;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, month);
            ps.setInt(2, pId);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String status = rs.getString("status");
                
                if(status.equalsIgnoreCase("Full Day")){
                    totalDays = totalDays+1;
                }
                
                if(status.equalsIgnoreCase("Short Leave")){
                    totalDays = totalDays+0.5;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
        query = "SELECT * FROM pharmacist p, salary s WHERE p.experience = s.experience AND pharmacist_id=?";
        double daySalary = 0.0;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, pId);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                daySalary = rs.getDouble("salary_per_day");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
        double totalSalary = totalDays*daySalary;
        
        return totalSalary;
    }
}

