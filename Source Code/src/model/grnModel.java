
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class grnModel {
    Connection conn;
    static Logger log = Logger.getLogger(grnModel.class.getName());
    
    public grnModel(){
        conn = db.dbConnection.getConnection();
    }

    public String insertGrn(Date gdate, String mob) {
    
    String msg = null;
    String query = "INSERT INTO grn (date_n_time, supplier_mobile) VALUES(?,?)";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setDate(1, new java.sql.Date(gdate.getTime()));
            psm.setString(2, mob);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
}
    
    public String insertGrnItem(String gid, String pid, String qty, String buy) {
    
    String msg = null;
    String query = "INSERT INTO grn_item (grn_id, barcode,qty,buying_price) VALUES(?,?,?,?)";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, gid);
            psm.setString(2, pid);
            psm.setString(3, qty);
            psm.setString(4, buy);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
}
 
    public void loadTable(String keyword, DefaultTableModel grnTableModel) {
        
        String runningQuery = "SELECT * FROM grn g, supplier s WHERE g.supplier_mobile=s.mobile AND s.supplier_name LIKE ? ORDER BY grn_id";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            grnTableModel.setRowCount(0);
            while(rs.next()){
                int grnid = rs.getInt("grn_id");
                Date date = rs.getDate("date_n_time");
                double total = rs.getDouble("payment");
                String sname = rs.getString("supplier_name");
                String smob = rs.getString("mobile");
                
                rowData = new Object[]{grnid,sname,smob,date,total};
                grnTableModel.addRow(rowData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
    }
    
    public void searchTable(String keyword, int categoryId, DefaultTableModel grnTableModel) {
        
        String loadDataById = "SELECT * FROM grn g, supplier s WHERE g.supplier_mobile=s.mobile AND g.grn_id LIKE ? ORDER BY grn_id";
        String loadDataByName = "SELECT * FROM grn g, supplier s WHERE g.supplier_mobile=s.mobile AND s.supplier_name LIKE ? ORDER BY grn_id";
        
        String runningQuery = null;
        
        if(categoryId==0){runningQuery = loadDataById;}
        else if(categoryId==1){runningQuery = loadDataByName;}
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            grnTableModel.setRowCount(0);
            while(rs.next()){
                int grnid = rs.getInt("grn_id");
                Date date = rs.getDate("date_n_time");
                double total = rs.getDouble("payment");
                String sname = rs.getString("supplier_name");
                String smob = rs.getString("mobile");
                
                rowData = new Object[]{grnid,sname,smob,date,total};
                grnTableModel.addRow(rowData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
    }
    
    public void loadGrnItemTable(String keyword, DefaultTableModel grnTableModel) {
        
        String runningQuery = "SELECT * FROM grn_item gi, grn g, product p WHERE gi.grn_id=g.grn_id AND"
                + " gi.barcode=p.barcode  AND p.product_name LIKE ? ORDER BY grn_item_id";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            grnTableModel.setRowCount(0);
            while(rs.next()){
                int grnItem = rs.getInt("grn_item_id");
                int grnid = rs.getInt("grn_id");
                String pname = rs.getString("product_name");
                int qty = rs.getInt("qty");
                double bp = rs.getDouble("buying_price");   
                
                rowData = new Object[]{grnItem,grnid,pname,qty,bp};
                grnTableModel.addRow(rowData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
    }
    
    public void searchGrnItemTable(String keyword, int categoryId, DefaultTableModel grnTableModel) {
        
        String loadDataById = "SELECT * FROM grn_item gi, grn g, product p WHERE gi.grn_id=g.grn_id AND"
                + " gi.barcode=p.barcode  AND g.grn_id LIKE ? ORDER BY grn_item_id";
        String loadDataByName = "SELECT * FROM grn_item gi, grn g, product p WHERE gi.grn_id=g.grn_id AND"
                + " gi.barcode=p.barcode  AND p.product_name LIKE ? ORDER BY grn_item_id";
        
        String runningQuery = null;
        
        if(categoryId==0){runningQuery = loadDataById;}
        else if(categoryId==1){runningQuery = loadDataByName;}
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            grnTableModel.setRowCount(0);
            while(rs.next()){
                int grnItem = rs.getInt("grn_item_id");
                int grnid = rs.getInt("grn_id");
                String pname = rs.getString("product_name");
                int qty = rs.getInt("qty");
                double bp = rs.getDouble("buying_price");   
                
                rowData = new Object[]{grnItem,grnid,pname,qty,bp};
                grnTableModel.addRow(rowData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
    }

    public String updateStock(String pid, String qty) {
        String msg = null;
       String query = "UPDATE stock SET qty=qty+? WHERE barcode=? ";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, qty);
            psm.setString(2, pid);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
    }

    public String updateGrn(String gid, String total) {
        String msg = null;
        String query = "UPDATE grn SET payment=payment+? WHERE grn_id=? ";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, total);
            psm.setString(2, gid);
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
