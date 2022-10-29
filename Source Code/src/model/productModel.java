
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class productModel {
    Connection conn;
    static Logger log = Logger.getLogger(productModel.class.getName());
    
    public productModel(){
        conn = db.dbConnection.getConnection();
    }
    
    public void loadExpiredProducts(String barcode, DefaultTableModel productTableModel) {
        String runningQuery = "SELECT * FROM product WHERE `exp` < NOW()";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            productTableModel.setRowCount(0);
            while(rs.next()){
                String bcode = rs.getString("barcode");
                String pname = rs.getString("product_name");
                Date expDt = rs.getDate("exp");
                
                rowData = new Object[]{bcode,pname,expDt};
                productTableModel.addRow(rowData);
                
                String query = "UPDATE product SET isactive='0' WHERE barcode=? ";

                try {
                    PreparedStatement psm = conn.prepareStatement(query);
                    psm.setString(1, bcode);
                    psm.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                    log.debug(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
    
    public String insertProduct(String code, String name, String brand, String sell, Date mfd, Date exp, boolean active) {
        String msg = null;
        String query = "INSERT INTO product (barcode, product_name, selling_price, mfd, exp, brand_id, isactive) VALUES(?,?,?,?,?,?,?)";

            try {
                PreparedStatement psm = conn.prepareStatement(query);
                psm.setString(1, code);
                psm.setString(2, name);
                psm.setString(3, sell);
                psm.setDate(4, new java.sql.Date(mfd.getTime()));
                psm.setDate(5, new java.sql.Date(exp.getTime()));
                psm.setString(6, brand);
                psm.setBoolean(7, active);
                psm.execute();
                msg="Success";
            } catch (Exception e) {
                e.printStackTrace();
                msg="Error : "+e.getMessage();
                log.debug(e.getMessage());
            }
        return msg;
    }
    
    public String insertStock(String code) {
        String msg = null;
        String query = "INSERT INTO stock (barcode) VALUES(?)";
        
            try {
                PreparedStatement psm = conn.prepareStatement(query);
                psm.setString(1, code);
                psm.execute();
                msg="Success";
            } catch (Exception e) {
                e.printStackTrace();
                msg="Error : "+e.getMessage();
                log.debug(e.getMessage());
            }
        return msg;
    }
    
    public String insertBrand(String bname, boolean activity) {
        String msg = null;
        String query = "INSERT INTO brand (brand_name,isactive) VALUES(?,?)";

            try {
                PreparedStatement psm = conn.prepareStatement(query);
                psm.setString(1, bname);
                psm.setBoolean(2, activity);
                
                psm.execute();
                msg="Success";
            } catch (Exception e) {
                e.printStackTrace();
                msg="Error : "+e.getMessage();
                log.debug(e.getMessage());
            }
        return msg;
    }
    
    public String getSelectedDataById(String barcode) {
        String runningQuery = "SELECT brand_id FROM product WHERE `barcode` = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, barcode);
            
            ResultSet rs = ps.executeQuery();
            String rowData = null;
            while(rs.next()){
                int bid = rs.getInt("brand_id");
                
                rowData = String.valueOf(bid);
            }
            return rowData;
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return null;
    }
    
    public void loadTable(String keyword, DefaultTableModel productTableModel) {
//                                                                                         AND `exp` > NOW()
        String runningQuery = "SELECT * FROM product p, brand b WHERE p.brand_id=b.brand_id AND product_name LIKE ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            productTableModel.setRowCount(0);
            while(rs.next()){
                String idProducts = rs.getString("barcode");
                String Pname = rs.getString("product_name");
                String Bname = rs.getString("brand_name");
                String sellPrice = rs.getString("selling_price");
                String mfd = rs.getString("mfd");
                String exp = rs.getString("exp");
                boolean activity = rs.getBoolean("isactive");
                
                rowData = new Object[]{idProducts,Pname,Bname,sellPrice,mfd,exp,activity};
                productTableModel.addRow(rowData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        
    }

    public void loadBrandTable(String keyword, DefaultTableModel teacherTableModel) {
        
        String runningQuery = "SELECT * FROM brand WHERE `brand_name` LIKE ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%"+keyword+"%");
            
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            teacherTableModel.setRowCount(0);
            while(rs.next()){
                int brandId = rs.getInt("brand_id");
                String name = rs.getString("brand_name");
                boolean activity = rs.getBoolean("isactive");
                
                rowData = new Object[]{brandId,name,activity};
                teacherTableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }  
    }

    public String updateProduct(String name, String brand, String sell, Date mfd, Date exp, String pid, boolean active) {
       String msg = null;
       String query = "UPDATE product SET product_name=?, selling_price=?, mfd=?, exp=?, brand_id=?, isactive=? WHERE barcode=? ";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, sell);
            psm.setDate(3, new java.sql.Date(mfd.getTime()));
            psm.setDate(4, new java.sql.Date(exp.getTime()));
            psm.setString(5, brand);
            psm.setBoolean(6, active);
            psm.setString(7, pid);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
    }
    
    public String updateBrand(String bid, String bname, boolean activity) {
       String msg = null;
       String query = "UPDATE brand SET brand_name=?, isactive=? WHERE brand_id=? ";
    
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, bname);
            psm.setBoolean(2, activity);
            psm.setString(3, bid);
            psm.execute();
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="Error : "+e.getMessage();
            log.debug(e.getMessage());
        }
    return msg;
    }
    
    public String deleteUser(String pid) {
        String query = "DELETE FROM product where barcode='" + pid + "' ";

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
}
