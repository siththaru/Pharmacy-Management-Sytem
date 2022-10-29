
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class supplierModel {
    Connection conn;
    static Logger log = Logger.getLogger(supplierModel.class.getName());
    
    public supplierModel(){
        conn = db.dbConnection.getConnection();
    }

    public String insertSupplier(String mobile, String name, String company, String email, boolean active) {
        String msg = null;
        String query = "INSERT INTO supplier (mobile, supplier_name, company_id, email, isactive) VALUES(?,?,?,?,?)";

            try {
                PreparedStatement psm = conn.prepareStatement(query);
                psm.setString(1, mobile);
                psm.setString(2, name);
                psm.setString(3, company);
                psm.setString(4, email);
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
    
    public String insertBrand(String bname) {
        String msg = null;
        String query = "INSERT INTO brand (brand_name) VALUES(?)";

            try {
                PreparedStatement psm = conn.prepareStatement(query);
                psm.setString(1, bname);
                
                psm.execute();
                msg="Success";
            } catch (Exception e) {
                e.printStackTrace();
                msg="Error : "+e.getMessage();
                log.debug(e.getMessage());
            }
        return msg;
    }
    
    public String insertCompany(String cname, String address, boolean activity) {
        String msg = null;
        String query = "INSERT INTO company (company_name, company_address, isactive) VALUES(?,?,?)";

            try {
                PreparedStatement psm = conn.prepareStatement(query);
                psm.setString(1, cname);
                psm.setString(2, address);
                psm.setBoolean(3, activity);
                
                psm.execute();
                msg="Success";
            } catch (Exception e) {
                e.printStackTrace();
                msg="Error : "+e.getMessage();
                log.debug(e.getMessage());
            }
        return msg;
    }

    public void loadTable(String keyword, DefaultTableModel supplierTableModel) {
        
        String runningQuery = "SELECT * FROM supplier s, company c WHERE s.company_id=c.company_id AND mobile LIKE ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            supplierTableModel.setRowCount(0);
            while(rs.next()){
                int Smob = rs.getInt("mobile");
                String Sname = rs.getString("supplier_name");
                String Cname = rs.getString("company_name");
                String email = rs.getString("email");
                boolean activity = rs.getBoolean("isactive");
                
                rowData = new Object[]{Smob,Sname,Cname,email,activity};
                supplierTableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }  
    }

    public void loadCompanyTable(String keyword, DefaultTableModel companyTableModel) {
        
        String runningQuery = "SELECT * FROM company WHERE `company_name` LIKE ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            companyTableModel.setRowCount(0);
            while(rs.next()){
                int cid = rs.getInt("company_id");
                String name = rs.getString("company_name");
                String address = rs.getString("company_address");
                boolean activity = rs.getBoolean("isactive");
                
                rowData = new Object[]{cid,name,address,activity};
                companyTableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }  
    }

    public Object[] getSelectedSupplierDataByMob(int smob) {
        String runningQuery = "SELECT * FROM supplier s, company c WHERE s.company_id=c.company_id AND mobile= ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setInt(1, smob);
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData = null;
            while(rs.next()){
                int mob = rs.getInt("mobile");
                String sname = rs.getString("supplier_name");
                int cid = rs.getInt("company_id");
                String email = rs.getString("email");
                boolean activity = rs.getBoolean("isactive");
                
                rowData = new Object[]{mob,sname,cid,email,activity};
            }
            return rowData;
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return null;
    }

    public String updateSupplier(String name, String company, String email, boolean active, String mobile) {
       String msg = null;
       String query = "UPDATE supplier SET supplier_name=?, company_id=?, email=?, isactive=? WHERE mobile=?";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, company);
            psm.setString(3, email);
            psm.setBoolean(4, active);
            psm.setString(5, mobile);
            
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
    }
    
    public String updateBrand(String bid, String bname) {
       String msg = null;
       String query = "UPDATE brand SET brand_name=? WHERE brand_id=? ";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, bname);
            psm.setString(2, bid);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
    }
    
    public String updateCompany(String cid, String cname, String address, boolean activity) {
       String msg = null;
       String query = "UPDATE company SET company_name=?, company_address=?, isactive=? WHERE company_id=? ";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, cname);
            psm.setString(2, address);
            psm.setBoolean(3, activity);
            psm.setString(4, cid);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
    }
    
    public String deleteSupplier(String mob) {
        String query = "DELETE FROM supplier where mobile='" + mob + "' ";

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            return "error" + e.getMessage();
        }
    }
    
    public String deleteBrand(String bid) {
        String query = "DELETE FROM brand where brand_id='" + bid + "' ";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            return "error" + e.getMessage();
        }
    }
    
    public String deleteCompany(String cid) {
        String query = "DELETE FROM company where company_id='" + cid + "' ";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            return "error" + e.getMessage();
        }
    }
}
