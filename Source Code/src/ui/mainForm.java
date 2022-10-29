package ui;

//import AppPackage.AnimationClass;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import model.attendanceModel;
import model.backupRestoreCode;
import model.grnModel;
import model.customerModel;
import model.invoiceModel;
import model.pharmacistModel;
import model.productModel;
import model.salaryModel;
import model.supplierModel;
import model.userModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

public class mainForm extends javax.swing.JFrame {

    private grnModel grnModel;
    private customerModel customerModel;
    private productModel productModel;
    private supplierModel supplierModel;
    private invoiceModel invoiceModel;
    private userModel userModel;
    private pharmacistModel pharmacistModel;
    private attendanceModel attendanceModel;
    private salaryModel salaryModel;

    final Container glassPane;

    JInternalFrame jintf;

    DefaultTableModel invoiceTableModel;
    DefaultTableModel invoiceTableModel2;
    DefaultTableModel invoiceTableModel3;
    DefaultTableModel customerTableModel;
    DefaultTableModel customerTableModel2;
    DefaultTableModel customerTableModel3;
    DefaultTableModel productTableModel;
    DefaultTableModel productTableModel2;
    DefaultTableModel productTableModel3;
    DefaultComboBoxModel comboBoxModel;
    DefaultTableModel brandTableModel;
    DefaultTableModel brandTableModel2;
    DefaultTableModel supplierTableModel;
    DefaultTableModel supplierTableModel2;
    DefaultTableModel companyTableModel;
    DefaultTableModel companyTableModel2;
    DefaultTableModel grnTableModel;
    DefaultTableModel grnTableModel2;
    DefaultTableModel grnTableModel3;
    DefaultTableModel pharmacistTableModel;
    DefaultTableModel pharmacistTableModel1;
    DefaultTableModel pharmacistTableModel2;
    DefaultTableModel stockTableModel;
    DefaultTableModel attendanceTableModel;
    DefaultTableModel salaryTableModel;
    DefaultTableModel salesTableModel;
    DefaultTableModel profitTableModel;
//    AnimationClass ac = new AnimationClass();

    public mainForm() {
        initComponents();
        setIconImage();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        if (userModel.userType == 2) {
            jPanel8.setVisible(false);
        } else {
            jPanel43.setVisible(false);
        }

        invoiceTableModel = (DefaultTableModel) DataTable.getModel();
        customerTableModel = (DefaultTableModel) DataTable1.getModel();
        productTableModel = (DefaultTableModel) DataTable2.getModel();
        supplierTableModel = (DefaultTableModel) DataTable3.getModel();
        grnTableModel = (DefaultTableModel) DataTable4.getModel();
        brandTableModel2 = (DefaultTableModel) DataTable5.getModel();
        brandTableModel = (DefaultTableModel) DataTable6.getModel();
        customerTableModel2 = (DefaultTableModel) DataTable10.getModel();
        grnTableModel2 = (DefaultTableModel) DataTable11.getModel();
        companyTableModel = (DefaultTableModel) DataTable12.getModel();
        companyTableModel2 = (DefaultTableModel) DataTable13.getModel();
        supplierTableModel2 = (DefaultTableModel) DataTable14.getModel();
        grnTableModel3 = (DefaultTableModel) DataTable15.getModel();
        productTableModel2 = (DefaultTableModel) DataTable16.getModel();
        pharmacistTableModel = (DefaultTableModel) DataTable17.getModel();
        stockTableModel = (DefaultTableModel) DataTable18.getModel();
        invoiceTableModel2 = (DefaultTableModel) DataTable19.getModel();
        invoiceTableModel3 = (DefaultTableModel) DataTable20.getModel();
        salesTableModel = (DefaultTableModel) DataTable21.getModel();
        pharmacistTableModel1 = (DefaultTableModel) DataTable22.getModel();
        pharmacistTableModel2 = (DefaultTableModel) DataTable23.getModel();
        attendanceTableModel = (DefaultTableModel) DataTable24.getModel();
        salaryTableModel = (DefaultTableModel) DataTable25.getModel();
        profitTableModel = (DefaultTableModel) DataTable27.getModel();
        customerTableModel3 = (DefaultTableModel) DataTable28.getModel();
        productTableModel3 = (DefaultTableModel) DataTable29.getModel();
        comboBoxModel = (DefaultComboBoxModel) jComboBox1.getModel();

        grnModel = new grnModel();
        customerModel = new customerModel();
        productModel = new productModel();
        supplierModel = new supplierModel();
        invoiceModel = new invoiceModel();
        pharmacistModel = new pharmacistModel();
        attendanceModel = new attendanceModel();
        salaryModel = new salaryModel();

        //communicate with class
        customerModel.loadTable("", customerTableModel);
        customerModel.loadTable("", customerTableModel2);
        customerModel.loadDeletedTable("", customerTableModel3);
        productModel.loadTable("", productTableModel);
        productModel.loadTable("", productTableModel2);
        productModel.loadBrandTable("", brandTableModel);
        productModel.loadBrandTable("", brandTableModel2);
        productModel.loadExpiredProducts("", productTableModel3);
        supplierModel.loadTable("", supplierTableModel);
        supplierModel.loadTable("", supplierTableModel2);
        supplierModel.loadCompanyTable("", companyTableModel);
        supplierModel.loadCompanyTable("", companyTableModel2);
        grnModel.loadTable("", grnTableModel);
        grnModel.loadGrnItemTable("", grnTableModel2);
        grnModel.loadTable("", grnTableModel3);
        pharmacistModel.loadTable("", pharmacistTableModel);
        pharmacistModel.loadTable("", pharmacistTableModel1);
        pharmacistModel.loadTable("", pharmacistTableModel2);
        pharmacistModel.loadComboBox(comboBoxModel);
        invoiceModel.loadTable("", invoiceTableModel2);
        invoiceModel.loadStockTable("", stockTableModel);
        attendanceModel.loadTable("", attendanceTableModel);
        salaryModel.loadTable("", salaryTableModel);
        invoiceModel.loadSalesTable1(LocalDate.now().getMonthValue(), salesTableModel);
        invoiceModel.loadProfitTable(profitTableModel);

        DataTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 25));
        DataTable.getTableHeader().setOpaque(false);
        DataTable.getTableHeader().setBackground(new Color(0, 204, 102));
        DataTable.getTableHeader().setForeground(new Color(255, 255, 255));
        tableEffects(DataTable1);
        tableEffects(DataTable2);
        tableEffects(DataTable3);
        tableEffects(DataTable4);
        tableEffects(DataTable5);
        tableEffects(DataTable6);
        tableEffects(DataTable10);
        tableEffects(DataTable11);
        tableEffects(DataTable12);
        tableEffects(DataTable13);
        tableEffects(DataTable14);
        tableEffects(DataTable15);
        tableEffects(DataTable16);
        tableEffects(DataTable17);
        tableEffects(DataTable18);
        tableEffects(DataTable19);
        tableEffects(DataTable20);
        tableEffects(DataTable21);
        tableEffects(DataTable24);
        tableEffects(DataTable25);
        tableEffects(DataTable27);
        tableEffects(DataTable28);
        tableEffects(DataTable29);

        brandIdField.setEditable(false);
        companyIdField.setEditable(false);
        grnSupplierName.setEditable(false);
        invProduct.setEditable(false);
        custaName.setEditable(false);
        totalField.setEditable(false);
        balanceField.setEditable(false);
        pharmacistId.setEditable(false);
        pharmacistName3.setEditable(false);
        timeField.setEditable(false);

        totalField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            public void removeUpdate(DocumentEvent e) {
            }

            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                if (!custoPay.getText().isEmpty()) {
                    Double total = Double.parseDouble(totalField.getText());
                    Double custoPayment = Double.parseDouble(custoPay.getText());
                    if (custoPayment >= total) {
                        Double balance = custoPayment - total;
                        balanceField.setText(balance.toString());
                    } else {
                        balanceField.setText("0.0");
                    }
                }
            }
        });

        DataTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.INSERT) {
                    int row = e.getFirstRow();

                    Double subTotal = (Double) invoiceTableModel.getValueAt(row, 5);
                    String mainTotal = totalField.getText();
                    Double intTotal = Double.parseDouble(mainTotal) + subTotal;
                    totalField.setText(String.valueOf(intTotal));
                }

                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();

                    if (column == 2) {
                        String qty = (String) invoiceTableModel.getValueAt(row, column);
                        Double price = (Double) invoiceTableModel.getValueAt(row, 3);
                        Double total = Double.parseDouble(qty) * price;
                        String disc = (String) invoiceTableModel.getValueAt(row, 4);
                        Double subPrice = total * (100 - Double.parseDouble(disc)) / 100;
                        invoiceTableModel.setValueAt(subPrice, row, column + 3);
                    }
                    if (column == 4) {
                        String qty = (String) invoiceTableModel.getValueAt(row, 2);
                        Double price = (Double) invoiceTableModel.getValueAt(row, 3);
                        Double sum = Double.parseDouble(qty) * price;
                        String disc = (String) invoiceTableModel.getValueAt(row, column);
                        Double subPrice = sum * (100 - Double.parseDouble(disc)) / 100;
                        invoiceTableModel.setValueAt(subPrice, row, column + 1);
                    }
                    if (column == 5) {
                        totalField.setText("0.0");
                        for (int i = 0; i < invoiceTableModel.getRowCount(); i++) {
                            Double subTotal = (Double) invoiceTableModel.getValueAt(i, column);
                            String fullTotal = totalField.getText();
                            Double intTotal = Double.parseDouble(fullTotal) + subTotal;
                            totalField.setText(String.valueOf(intTotal));
                        }
                    }
                }
            }
        });

        setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI ifu1 = jInternalFrame8.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu1).setNorthPane(null);

        javax.swing.plaf.InternalFrameUI ifu2 = jInternalFrame9.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu2).setNorthPane(null);

        javax.swing.plaf.InternalFrameUI ifu6 = jInternalFrame14.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu6).setNorthPane(null);

        javax.swing.plaf.InternalFrameUI ifu7 = jInternalFrame15.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu7).setNorthPane(null);

        javax.swing.plaf.InternalFrameUI ifu8 = jInternalFrame16.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu8).setNorthPane(null);

        javax.swing.plaf.InternalFrameUI ifu9 = jInternalFrame18.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu9).setNorthPane(null);

        javax.swing.plaf.InternalFrameUI ifu10 = jInternalFrame19.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu10).setNorthPane(null);

        javax.swing.plaf.InternalFrameUI ifu11 = jInternalFrame20.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu11).setNorthPane(null);

        javax.swing.plaf.InternalFrameUI ifu12 = jInternalFrame25.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu12).setNorthPane(null);

        javax.swing.plaf.InternalFrameUI ifu13 = jInternalFrame28.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu13).setNorthPane(null);

        javax.swing.plaf.InternalFrameUI ifu14 = jInternalFrame29.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu14).setNorthPane(null);

        javax.swing.plaf.InternalFrameUI ifu15 = jInternalFrame32.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu15).setNorthPane(null);

        javax.swing.plaf.InternalFrameUI ifu16 = jInternalFrame33.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu16).setNorthPane(null);

        expField.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 102), 1));
        mfdField.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 102), 1));
        grndate.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 102), 1));

        transparentframes(jInternalFrame1);
        transparentframes(jInternalFrame2);
        transparentframes(jInternalFrame3);
        transparentframes(jInternalFrame4);
        transparentframes(jInternalFrame5);
        transparentframes(jInternalFrame6);
        transparentframes(jInternalFrame7);
        transparentframes(jInternalFrame13);
        transparentframes(jInternalFrame17);
        transparentframes(jInternalFrame21);
        transparentframes(jInternalFrame22);
        transparentframes(jInternalFrame23);
        transparentframes(jInternalFrame24);
        transparentframes(jInternalFrame26);
        transparentframes(jInternalFrame27);
        transparentframes(jInternalFrame30);

        setGlasspanes();
        glassPane = (Container) this.getGlassPane();
        glassPane.addMouseListener(new MouseAdapter() {
        });

        showdate();
        showtime();

    }

    public void showPopUp(MouseEvent e, JInternalFrame jif) {
        jintf = jif;
        PopupMenu.show(jif, e.getX(), e.getY());
    }

    public void setGlasspanes() {
        getRootPane().setGlassPane(new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0, 0, 0, 150));
                g.fillRect(300, 137, 1620, 865);
            }

        });
    }

    public final void glassPaneVisible(JInternalFrame jif) {
        glassPane.setVisible(true);
        glassPane.add(jif);
        jif.setVisible(true);
    }

    public final void glassPaneNotVisible(JInternalFrame jif) {
        glassPane.remove(jif);
        jif.setVisible(false);
        glassPane.setVisible(false);
    }

    public final void transparentframes(JInternalFrame jif) {
        jif.setBackground(new Color(0, 0, 0, 0));
    }

    public static final void tableEffects(JTable t) {
        t.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 22));
        t.getTableHeader().setOpaque(false);
        t.getTableHeader().setBackground(new Color(0, 204, 102));
        t.getTableHeader().setForeground(new Color(255, 255, 255));
    }

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {
        custoPay.setText("");
    }

    void showdate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        dateLab.setText(s.format(d));
    }

    void showtime() {

        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                timeLab.setText(s.format(d));
                timeField.setText(s.format(d));
            }
        }).start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopupMenu = new javax.swing.JPopupMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        dateLab = new javax.swing.JLabel();
        timeLab = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel21 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jInternalFrame20 = new javax.swing.JInternalFrame();
        jScrollPane17 = new javax.swing.JScrollPane();
        DataTable10 = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        kGradientPanel13 = new keeptoo.KGradientPanel();
        jLabel102 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        search1 = new javax.swing.JTextField();
        jButton64 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        balanceField = new javax.swing.JTextField();
        totalField = new javax.swing.JTextField();
        custoPay = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        DataTable = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        invBarcode = new javax.swing.JTextField();
        invProduct = new javax.swing.JTextField();
        invQty = new javax.swing.JTextField();
        invDisc = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        custaMob = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        custaName = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        totalSalary2 = new javax.swing.JLabel();
        totalSalary3 = new javax.swing.JLabel();
        totalSalary4 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jInternalFrame32 = new javax.swing.JInternalFrame();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane30 = new javax.swing.JScrollPane();
        DataTable28 = new javax.swing.JTable();
        jButton56 = new javax.swing.JButton();
        cusMobkeyword = new javax.swing.JTextField();
        jButton54 = new javax.swing.JButton();
        kGradientPanel15 = new keeptoo.KGradientPanel();
        jLabel131 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        DataTable1 = new javax.swing.JTable();
        jButton25 = new javax.swing.JButton();
        customerKeywordField = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        custoMobField = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        custoEmailField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        custoNameField = new javax.swing.JTextField();
        validate1 = new javax.swing.JLabel();
        jButton52 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jInternalFrame8 = new javax.swing.JInternalFrame();
        jScrollPane5 = new javax.swing.JScrollPane();
        DataTable5 = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        search2 = new javax.swing.JTextField();
        jButton65 = new javax.swing.JButton();
        jInternalFrame9 = new javax.swing.JInternalFrame();
        jPanel17 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        brandIdField = new javax.swing.JTextField();
        brandNameField = new javax.swing.JTextField();
        validate4 = new javax.swing.JLabel();
        brandIsActive = new javax.swing.JCheckBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        DataTable6 = new javax.swing.JTable();
        jButton30 = new javax.swing.JButton();
        keywordField4 = new javax.swing.JTextField();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel37 = new javax.swing.JLabel();
        jInternalFrame33 = new javax.swing.JInternalFrame();
        jScrollPane31 = new javax.swing.JScrollPane();
        DataTable29 = new javax.swing.JTable();
        kGradientPanel16 = new keeptoo.KGradientPanel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        productNameField = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        expField = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        barcodeField = new javax.swing.JTextField();
        mfdField = new com.toedter.calendar.JDateChooser();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        brandField = new javax.swing.JTextField();
        sellField = new javax.swing.JTextField();
        jButton45 = new javax.swing.JButton();
        validate3 = new javax.swing.JLabel();
        productIsActive = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        DataTable2 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        keywordField1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel116 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jInternalFrame14 = new javax.swing.JInternalFrame();
        jScrollPane12 = new javax.swing.JScrollPane();
        DataTable12 = new javax.swing.JTable();
        jLabel67 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        search3 = new javax.swing.JTextField();
        jButton66 = new javax.swing.JButton();
        jInternalFrame15 = new javax.swing.JInternalFrame();
        jPanel23 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        companyIdField = new javax.swing.JTextField();
        companyNameField = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        companyAddress = new javax.swing.JTextArea();
        validate5 = new javax.swing.JLabel();
        companyIsActive = new javax.swing.JCheckBox();
        jScrollPane13 = new javax.swing.JScrollPane();
        DataTable13 = new javax.swing.JTable();
        jButton38 = new javax.swing.JButton();
        keywordField6 = new javax.swing.JTextField();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        jLabel77 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        supplierNameField = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        supplierMobField = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        companyField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        validate6 = new javax.swing.JLabel();
        supplierIsActive = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        DataTable3 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        keywordField2 = new javax.swing.JTextField();
        jButton39 = new javax.swing.JButton();
        jLabel119 = new javax.swing.JLabel();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        jButton11 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jInternalFrame13 = new javax.swing.JInternalFrame();
        jInternalFrame16 = new javax.swing.JInternalFrame();
        jScrollPane14 = new javax.swing.JScrollPane();
        DataTable14 = new javax.swing.JTable();
        jLabel75 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jLabel98 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        search4 = new javax.swing.JTextField();
        jButton67 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        grnSupplierMob = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        grnSupplierName = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        grndate = new com.toedter.calendar.JDateChooser();
        validate7 = new javax.swing.JLabel();
        jButton50 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DataTable4 = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        keywordField3 = new javax.swing.JTextField();
        searchcategoryCombo = new javax.swing.JComboBox<>();
        jInternalFrame17 = new javax.swing.JInternalFrame();
        jInternalFrame18 = new javax.swing.JInternalFrame();
        jScrollPane15 = new javax.swing.JScrollPane();
        DataTable15 = new javax.swing.JTable();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        search5 = new javax.swing.JTextField();
        jButton68 = new javax.swing.JButton();
        jInternalFrame19 = new javax.swing.JInternalFrame();
        jScrollPane16 = new javax.swing.JScrollPane();
        DataTable16 = new javax.swing.JTable();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        jLabel99 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        search6 = new javax.swing.JTextField();
        jButton69 = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        grnId = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        productId = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        grnQty = new javax.swing.JTextField();
        buyPrice = new javax.swing.JTextField();
        validate8 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        keywordField5 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        DataTable11 = new javax.swing.JTable();
        jButton31 = new javax.swing.JButton();
        searchCombo = new javax.swing.JComboBox<>();
        jButton32 = new javax.swing.JButton();
        jInternalFrame6 = new javax.swing.JInternalFrame();
        jPanel18 = new javax.swing.JPanel();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jInternalFrame22 = new javax.swing.JInternalFrame();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        DataTable21 = new javax.swing.JTable();
        jButton37 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        salesMonth = new com.toedter.calendar.JMonthChooser();
        dateOnly = new com.toedter.calendar.JDateChooser();
        date2 = new com.toedter.calendar.JDateChooser();
        date1 = new com.toedter.calendar.JDateChooser();
        salesTotal = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jInternalFrame23 = new javax.swing.JInternalFrame();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        DataTable18 = new javax.swing.JTable();
        stockProductField = new javax.swing.JTextField();
        jButton48 = new javax.swing.JButton();
        jLabel120 = new javax.swing.JLabel();
        jButton72 = new javax.swing.JButton();
        jInternalFrame24 = new javax.swing.JInternalFrame();
        jInternalFrame25 = new javax.swing.JInternalFrame();
        jScrollPane23 = new javax.swing.JScrollPane();
        DataTable20 = new javax.swing.JTable();
        kGradientPanel10 = new keeptoo.KGradientPanel();
        jLabel97 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        DataTable19 = new javax.swing.JTable();
        invViewId = new javax.swing.JTextField();
        jButton46 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton47 = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        jInternalFrame21 = new javax.swing.JInternalFrame();
        jPanel16 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        pharmacistKeywordField = new javax.swing.JTextField();
        jScrollPane19 = new javax.swing.JScrollPane();
        DataTable17 = new javax.swing.JTable();
        jButton41 = new javax.swing.JButton();
        jLabel122 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        pharmacistMob = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        pharmacistAddress = new javax.swing.JTextField();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        pharmacistName = new javax.swing.JTextField();
        validate2 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        pharmacistId = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        isActive = new javax.swing.JCheckBox();
        jButton75 = new javax.swing.JButton();
        jInternalFrame26 = new javax.swing.JInternalFrame();
        jInternalFrame28 = new javax.swing.JInternalFrame();
        jScrollPane24 = new javax.swing.JScrollPane();
        DataTable22 = new javax.swing.JTable();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        kGradientPanel11 = new keeptoo.KGradientPanel();
        jLabel103 = new javax.swing.JLabel();
        search7 = new javax.swing.JTextField();
        jButton70 = new javax.swing.JButton();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        DataTable24 = new javax.swing.JTable();
        jPanel51 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        timeField = new javax.swing.JTextField();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        pharmacistName3 = new javax.swing.JTextField();
        validate11 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        pharmacistId3 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jButton73 = new javax.swing.JButton();
        jInternalFrame27 = new javax.swing.JInternalFrame();
        jInternalFrame29 = new javax.swing.JInternalFrame();
        jScrollPane25 = new javax.swing.JScrollPane();
        DataTable23 = new javax.swing.JTable();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        kGradientPanel12 = new keeptoo.KGradientPanel();
        jLabel109 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        search8 = new javax.swing.JTextField();
        jButton71 = new javax.swing.JButton();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        pharmacistNameKeyword = new javax.swing.JTextField();
        jScrollPane27 = new javax.swing.JScrollPane();
        DataTable25 = new javax.swing.JTable();
        jButton59 = new javax.swing.JButton();
        jLabel123 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jButton60 = new javax.swing.JButton();
        pharmacistName4 = new javax.swing.JTextField();
        validate12 = new javax.swing.JLabel();
        pharmacistId4 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jLabel118 = new javax.swing.JLabel();
        totalSalary = new javax.swing.JLabel();
        totalSalary1 = new javax.swing.JLabel();
        jButton61 = new javax.swing.JButton();
        jInternalFrame30 = new javax.swing.JInternalFrame();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jScrollPane29 = new javax.swing.JScrollPane();
        DataTable27 = new javax.swing.JTable();
        jPanel57 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        lecobill = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jMonthChooser2 = new com.toedter.calendar.JMonthChooser();
        jLabel132 = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        totallabe1 = new javax.swing.JLabel();
        totallabe2 = new javax.swing.JLabel();
        jInternalFrame7 = new javax.swing.JInternalFrame();
        jPanel22 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        backupPathField = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        restorePathField = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem4.setText("Refresh");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        PopupMenu.add(jMenuItem4);

        jMenuItem5.setText("Forward");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        PopupMenu.add(jMenuItem5);

        jMenuItem7.setText("Backward");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        PopupMenu.add(jMenuItem7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MedCure Pharmacy");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.setOpaque(false);
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pos.png"))); // NOI18N
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 42, 70));

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setOpaque(true);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 90));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("POS");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 70));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 300, 90));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setOpaque(false);
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 42, 70));

        jLabel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 90));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Customers");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 70));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 300, 90));

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.setOpaque(false);
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/products.png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 42, 70));

        jLabel8.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 90));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Products");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 70));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 300, 90));

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.setOpaque(false);
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supplier.png"))); // NOI18N
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 42, 70));

        jLabel11.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 90));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Suppliers");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 70));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 300, 90));

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.setOpaque(false);
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grn.png"))); // NOI18N
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 42, 70));

        jLabel14.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 90));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("GRN");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 70));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 300, 90));

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.setOpaque(false);
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.png"))); // NOI18N
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 42, 70));

        jLabel17.setBackground(new java.awt.Color(0, 153, 153));
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 90));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Admin");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 70));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 300, 90));

        jPanel43.setBackground(new java.awt.Color(0, 166, 183));
        jPanel43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel43.setOpaque(false);
        jPanel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel43MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel43MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel43MouseExited(evt);
            }
        });
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/account.png"))); // NOI18N
        jPanel43.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 42, 70));

        jLabel104.setBackground(new java.awt.Color(0, 153, 153));
        jPanel43.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 90));

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setText("Account");
        jPanel43.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 70));

        jPanel2.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 300, 90));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/medcureLogo.png"))); // NOI18N
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 220, 150));

        kGradientPanel1.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 220, 223));

        jPanel20.setBackground(new java.awt.Color(0, 153, 153));
        jPanel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel20.setOpaque(false);
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel20MouseExited(evt);
            }
        });
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/closing.png"))); // NOI18N
        jPanel20.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 80));

        jLabel38.setBackground(new java.awt.Color(0, 168, 92));
        jPanel20.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 70));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Logout");
        jPanel20.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, 80));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(895, Short.MAX_VALUE)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel2.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 1000));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 1000));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dateLab.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        dateLab.setForeground(new java.awt.Color(255, 255, 255));
        dateLab.setText("Date");
        jPanel9.add(dateLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 15, 180, 40));

        timeLab.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        timeLab.setForeground(new java.awt.Color(255, 255, 255));
        timeLab.setText("Time");
        jPanel9.add(timeLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 55, 180, 40));

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 205, 151));
        kGradientPanel2.setkGradientFocus(1000);
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 235, 145));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoLetters.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 1620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 120, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel9.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1740, 110));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 1740, 110));

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setBorder(null);
        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jInternalFrame20.setVisible(false);
        jInternalFrame20.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable10.setRowHeight(25);
        DataTable10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable10MouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(DataTable10);

        jInternalFrame20.getContentPane().add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 560, 310));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel60.setText("Click a row below to add the customer");
        jInternalFrame20.getContentPane().add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel63.setForeground(new java.awt.Color(255, 0, 0));
        jLabel63.setText("NOTE: Please add a customer first if u cannot find a customer below");
        jInternalFrame20.getContentPane().add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        kGradientPanel13.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel13.setkGradientFocus(800);
        kGradientPanel13.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel102.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel102MouseClicked(evt);
            }
        });
        kGradientPanel13.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 2, 30, 30));

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel61.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel61MouseClicked(evt);
            }
        });
        kGradientPanel13.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 0, 35, 35));

        jInternalFrame20.getContentPane().add(kGradientPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 35));

        search1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jInternalFrame20.getContentPane().add(search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 250, 30));

        jButton64.setBackground(new java.awt.Color(0, 204, 102));
        jButton64.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton64.setForeground(new java.awt.Color(255, 255, 255));
        jButton64.setText("Search");
        jButton64.setContentAreaFilled(false);
        jButton64.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton64.setOpaque(true);
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });
        jInternalFrame20.getContentPane().add(jButton64, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 140, 30));

        jInternalFrame1.getContentPane().add(jInternalFrame20, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 620, 590));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setOpaque(false);
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel10MouseReleased(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton17.setBackground(new java.awt.Color(0, 204, 102));
        jButton17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Create Invoice");
        jButton17.setContentAreaFilled(false);
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton17.setOpaque(true);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 740, 170, 50));

        balanceField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        balanceField.setText("0.0");
        balanceField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel10.add(balanceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 630, 110, 40));

        totalField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalField.setText("0.0");
        totalField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel10.add(totalField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 430, 110, 40));

        custoPay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        custoPay.setText("0.0");
        custoPay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        custoPay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                custoPayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                custoPayFocusLost(evt);
            }
        });
        custoPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                custoPayKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                custoPayKeyTyped(evt);
            }
        });
        jPanel10.add(custoPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 530, 110, 40));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("Balance");
        jPanel10.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 600, 70, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("Total");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 400, 40, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 102));
        jLabel26.setText("Cash Paid");
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 500, 90, -1));

        DataTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DataTable.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        DataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Product", "Qty", "Price", "Disc.%", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable.setFocusable(false);
        DataTable.setGridColor(new java.awt.Color(0, 0, 0));
        DataTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        DataTable.setRowHeight(35);
        DataTable.setSelectionBackground(new java.awt.Color(7, 191, 227));
        DataTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane18.setViewportView(DataTable);

        jPanel10.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 1080, 430));

        jButton18.setBackground(new java.awt.Color(0, 204, 102));
        jButton18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Remove");
        jButton18.setContentAreaFilled(false);
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.setOpaque(true);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 790, 140, 40));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Add Products To Table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel26.setForeground(new java.awt.Color(0, 102, 102));
        jPanel26.setOpaque(false);
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton.setBackground(new java.awt.Color(0, 204, 102));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.setContentAreaFilled(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setOpaque(true);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel26.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 90, 40));

        invBarcode.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        invBarcode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        invBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                invBarcodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                invBarcodeKeyTyped(evt);
            }
        });
        jPanel26.add(invBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 220, 40));

        invProduct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        invProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel26.add(invProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 200, 40));

        invQty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        invQty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        invQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invQtyActionPerformed(evt);
            }
        });
        jPanel26.add(invQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 105, 40));

        invDisc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        invDisc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        invDisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invDiscActionPerformed(evt);
            }
        });
        jPanel26.add(invDisc, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 105, 40));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 102, 102));
        jLabel30.setText("Disc");
        jPanel26.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 102));
        jLabel40.setText("Barcode");
        jPanel26.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 30));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 102, 102));
        jLabel41.setText("Product Name");
        jPanel26.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 102, 102));
        jLabel42.setText("Qty");
        jPanel26.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, 30));

        jPanel10.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 810, 280));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Customer (Optional)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel36.setOpaque(false);
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        custaMob.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        custaMob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        custaMob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        custaMob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custaMobMouseClicked(evt);
            }
        });
        jPanel36.add(custaMob, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 180, 40));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 102, 102));
        jLabel45.setText("Customer Name");
        jPanel36.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, 30));

        custaName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        custaName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel36.add(custaName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 180, 40));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 102, 102));
        jLabel46.setText("Customer Mobile ");
        jPanel36.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 30));

        jPanel10.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 580, 280));

        totalSalary2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        totalSalary2.setText("Rs.");
        jPanel10.add(totalSalary2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 630, 30, 40));

        totalSalary3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        totalSalary3.setText("Rs.");
        jPanel10.add(totalSalary3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 430, 30, 40));

        totalSalary4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        totalSalary4.setText("Rs.");
        jPanel10.add(totalSalary4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 530, 30, 40));

        jInternalFrame1.getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 890));

        jDesktopPane1.add(jInternalFrame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame2.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame2.setBorder(null);
        jInternalFrame2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jInternalFrame2.setVisible(false);
        jInternalFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame32.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame32.setVisible(false);
        jInternalFrame32.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Deleted Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable28.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Mobile", "Customer Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable28.setRowHeight(25);
        jScrollPane30.setViewportView(DataTable28);

        jPanel19.add(jScrollPane30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 620, 390));

        jButton56.setBackground(new java.awt.Color(0, 204, 102));
        jButton56.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton56.setForeground(new java.awt.Color(255, 255, 255));
        jButton56.setText("Search");
        jButton56.setContentAreaFilled(false);
        jButton56.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton56.setOpaque(true);
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });
        jPanel19.add(jButton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 58, 140, 45));

        cusMobkeyword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cusMobkeyword.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2), "Mobile", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel19.add(cusMobkeyword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 320, 55));

        jButton54.setBackground(new java.awt.Color(0, 204, 102));
        jButton54.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton54.setForeground(new java.awt.Color(255, 255, 255));
        jButton54.setText("Restore");
        jButton54.setContentAreaFilled(false);
        jButton54.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton54.setOpaque(true);
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });
        jPanel19.add(jButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 145, 45));

        jInternalFrame32.getContentPane().add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 700, 620));

        kGradientPanel15.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel15.setkGradientFocus(1600);
        kGradientPanel15.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel131.setForeground(new java.awt.Color(255, 255, 255));
        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel131.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel131.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel131MouseClicked(evt);
            }
        });
        kGradientPanel15.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 2, 30, 30));

        jInternalFrame32.getContentPane().add(kGradientPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 35));

        jInternalFrame2.getContentPane().add(jInternalFrame32, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 740, 700));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Customer Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel11.setOpaque(false);
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel11MouseReleased(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setOpaque(false);
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "Customer Name", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable1.setFocusable(false);
        DataTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        DataTable1.setRowHeight(25);
        DataTable1.setSelectionBackground(new java.awt.Color(7, 191, 227));
        DataTable1.getTableHeader().setReorderingAllowed(false);
        DataTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable1MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(DataTable1);

        jPanel31.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 112, 803, 360));

        jButton25.setBackground(new java.awt.Color(0, 204, 102));
        jButton25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Search");
        jButton25.setContentAreaFilled(false);
        jButton25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton25.setOpaque(true);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel31.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 35, 140, 40));

        customerKeywordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        customerKeywordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel31.add(customerKeywordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 37, 438, 40));

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 102, 102));
        jLabel106.setText("Search by mobile");
        jPanel31.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 30));

        jPanel11.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, -1, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setOpaque(false);
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        custoMobField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        custoMobField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        custoMobField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                custoMobFieldKeyTyped(evt);
            }
        });
        jPanel12.add(custoMobField, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 140, 310, 40));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 102, 102));
        jLabel32.setText("Customer Mobile :");
        jPanel12.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 102, 102));
        jLabel33.setText("Customer Name  :");
        jPanel12.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 102, 102));
        jLabel35.setText("Customer Email  :");
        jPanel12.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        custoEmailField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        custoEmailField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        custoEmailField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custoEmailFieldMouseClicked(evt);
            }
        });
        jPanel12.add(custoEmailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 320, 310, 40));

        jButton1.setBackground(new java.awt.Color(0, 204, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Save");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 130, 50));

        jButton2.setBackground(new java.awt.Color(0, 204, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 130, 50));

        jButton3.setBackground(new java.awt.Color(0, 204, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, 130, 50));

        custoNameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        custoNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        custoNameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custoNameFieldMouseClicked(evt);
            }
        });
        jPanel12.add(custoNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 230, 310, 40));

        validate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        validate1.setForeground(new java.awt.Color(255, 0, 0));
        validate1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel12.add(validate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 345, 30));

        jButton52.setBackground(new java.awt.Color(0, 204, 102));
        jButton52.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton52.setForeground(new java.awt.Color(255, 255, 255));
        jButton52.setText("View/Restore Deleted Customers");
        jButton52.setContentAreaFilled(false);
        jButton52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton52.setOpaque(true);
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 350, 50));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 650, 620));

        jButton74.setBackground(new java.awt.Color(0, 204, 102));
        jButton74.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton74.setForeground(new java.awt.Color(255, 255, 255));
        jButton74.setText("Print Report");
        jButton74.setContentAreaFilled(false);
        jButton74.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton74.setOpaque(true);
        jButton74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton74ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton74, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 670, 240, 50));

        jInternalFrame2.getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 930));

        jInternalFrame3.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame3.setBorder(null);
        jInternalFrame3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jInternalFrame3.setVisible(false);
        jInternalFrame3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame8.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame8.setVisible(false);
        jInternalFrame8.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Brand Id", "Brand Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable5.setRowHeight(25);
        DataTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(DataTable5);

        jInternalFrame8.getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 520, 320));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel36.setText("Click a row below to add the brand");
        jInternalFrame8.getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("NOTE: Please add a brand first if u cannot find a brand below");
        jInternalFrame8.getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        kGradientPanel4.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel4.setkGradientFocus(800);
        kGradientPanel4.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel94.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel94MouseClicked(evt);
            }
        });
        kGradientPanel4.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 2, 30, 30));

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });
        kGradientPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 0, 35, 35));

        jInternalFrame8.getContentPane().add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 35));

        search2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jInternalFrame8.getContentPane().add(search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 250, 30));

        jButton65.setBackground(new java.awt.Color(0, 204, 102));
        jButton65.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton65.setForeground(new java.awt.Color(255, 255, 255));
        jButton65.setText("Search");
        jButton65.setContentAreaFilled(false);
        jButton65.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton65.setOpaque(true);
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });
        jInternalFrame8.getContentPane().add(jButton65, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 140, 30));

        jInternalFrame3.getContentPane().add(jInternalFrame8, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 620, 600));

        jInternalFrame9.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame9.setVisible(false);
        jInternalFrame9.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Brand Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        jButton19.setBackground(new java.awt.Color(0, 204, 102));
        jButton19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Save");
        jButton19.setContentAreaFilled(false);
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.setOpaque(true);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(0, 204, 102));
        jButton26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("Update");
        jButton26.setContentAreaFilled(false);
        jButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton26.setOpaque(true);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 102));
        jLabel28.setText("Brand Id :");

        jLabel29.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 102));
        jLabel29.setText("Brand Name :");

        brandIdField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        brandIdField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        brandNameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        brandNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        validate4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        validate4.setForeground(new java.awt.Color(255, 0, 0));
        validate4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        brandIsActive.setBackground(new java.awt.Color(204, 255, 255));
        brandIsActive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        brandIsActive.setText("Active");
        brandIsActive.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 10));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(validate4, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(47, 47, 47)
                                .addComponent(brandIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(11, 11, 11)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(brandIsActive)
                                    .addComponent(brandNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 67, Short.MAX_VALUE))
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(validate4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(brandIsActive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        jPanel17.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 450));

        DataTable6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Brand Id", "Brand Name", "Active"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable6.setRowHeight(25);
        DataTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(DataTable6);

        jPanel17.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 620, 420));

        jButton30.setBackground(new java.awt.Color(0, 204, 102));
        jButton30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton30.setForeground(new java.awt.Color(255, 255, 255));
        jButton30.setText("Search");
        jButton30.setContentAreaFilled(false);
        jButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton30.setOpaque(true);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 58, 140, 45));

        keywordField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        keywordField4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2), "Brand Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel17.add(keywordField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 320, 55));

        jInternalFrame9.getContentPane().add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1380, 620));

        kGradientPanel3.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel3.setkGradientFocus(1600);
        kGradientPanel3.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });
        kGradientPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 2, 30, 30));

        jInternalFrame9.getContentPane().add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 35));

        jInternalFrame3.getContentPane().add(jInternalFrame9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 1420, 680));

        jInternalFrame33.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame33.setVisible(false);
        jInternalFrame33.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable29.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Product Name", "Expiry Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable29.setRowHeight(25);
        jScrollPane31.setViewportView(DataTable29);

        jInternalFrame33.getContentPane().add(jScrollPane31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 660, 380));

        kGradientPanel16.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel16.setkGradientFocus(800);
        kGradientPanel16.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel133.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel133.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel133MouseClicked(evt);
            }
        });
        kGradientPanel16.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 2, 30, 30));

        jLabel134.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel134.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel134.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel134MouseClicked(evt);
            }
        });
        kGradientPanel16.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 35, 35));

        jInternalFrame33.getContentPane().add(kGradientPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 35));

        jButton27.setBackground(new java.awt.Color(0, 204, 102));
        jButton27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("Clear All");
        jButton27.setContentAreaFilled(false);
        jButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton27.setOpaque(true);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jInternalFrame33.getContentPane().add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 140, 40));

        jInternalFrame3.getContentPane().add(jInternalFrame33, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 720, 600));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Product Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel13.setOpaque(false);
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel13MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel13MouseReleased(evt);
            }
        });
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setOpaque(false);
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 102));
        jLabel24.setText("Barcode :");
        jPanel21.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 40));

        jLabel44.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 102, 102));
        jLabel44.setText("Product  Name :");
        jPanel21.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, 40));

        productNameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel21.add(productNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 351, 40));

        jLabel47.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 102, 102));
        jLabel47.setText("EXP :");
        jPanel21.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, -1, 40));

        jLabel48.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 102, 102));
        jLabel48.setText("Brand :");
        jPanel21.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, 40));

        jButton4.setBackground(new java.awt.Color(0, 204, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Save");
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 720, 110, 45));

        expField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel21.add(expField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 351, 40));

        jButton5.setBackground(new java.awt.Color(0, 204, 102));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Update");
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 720, 120, 45));

        barcodeField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        barcodeField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel21.add(barcodeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 351, 40));

        mfdField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel21.add(mfdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 351, 40));

        jLabel58.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 102, 102));
        jLabel58.setText("MFD :");
        jPanel21.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, 40));

        jLabel59.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 102, 102));
        jLabel59.setText("Selling Price :");
        jPanel21.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, 40));

        brandField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        brandField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        brandField.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        brandField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brandFieldMouseClicked(evt);
            }
        });
        brandField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandFieldActionPerformed(evt);
            }
        });
        jPanel21.add(brandField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 351, 40));

        sellField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sellField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel21.add(sellField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 351, 40));

        jButton45.setBackground(new java.awt.Color(0, 204, 102));
        jButton45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton45.setForeground(new java.awt.Color(255, 255, 255));
        jButton45.setText("Clear Fields");
        jButton45.setContentAreaFilled(false);
        jButton45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton45.setOpaque(true);
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 720, 145, 45));

        validate3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        validate3.setForeground(new java.awt.Color(255, 0, 0));
        validate3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel21.add(validate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 249, 31));

        productIsActive.setBackground(new java.awt.Color(204, 255, 255));
        productIsActive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productIsActive.setText("Active");
        productIsActive.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 10));
        jPanel21.add(productIsActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 90, 30));

        jPanel13.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 790));

        DataTable2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Product Name", "Brand", "Selling Price", "MFD", "EXP", "Active"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable2.setRowHeight(25);
        DataTable2.setSelectionBackground(new java.awt.Color(7, 191, 227));
        DataTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(DataTable2);

        jPanel13.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 1050, 430));

        jButton8.setBackground(new java.awt.Color(0, 204, 102));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Search");
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setOpaque(true);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 180, 140, 40));

        keywordField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        keywordField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel13.add(keywordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 490, 40));

        jButton7.setBackground(new java.awt.Color(0, 204, 102));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Add/Update Brand");
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setOpaque(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 540, 50));

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(0, 102, 102));
        jLabel116.setText("Search by product name");
        jPanel13.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, -1, 30));

        jButton14.setBackground(new java.awt.Color(0, 204, 102));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Expired Products");
        jButton14.setContentAreaFilled(false);
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.setOpaque(true);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 740, 540, 50));

        jInternalFrame3.getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame4.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame4.setBorder(null);
        jInternalFrame4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jInternalFrame4.setVisible(false);
        jInternalFrame4.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame14.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame14.setVisible(false);
        jInternalFrame14.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company ID", "Company Name", "Company Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable12.setRowHeight(25);
        DataTable12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable12MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(DataTable12);

        jInternalFrame14.getContentPane().add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 680, 340));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel67.setText("Click a row below to add the company");
        jInternalFrame14.getContentPane().add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel71.setForeground(new java.awt.Color(255, 0, 0));
        jLabel71.setText("NOTE: Please add a company first if u cannot find a company below");
        jInternalFrame14.getContentPane().add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        kGradientPanel5.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel5.setkGradientFocus(850);
        kGradientPanel5.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel95.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel95MouseClicked(evt);
            }
        });
        kGradientPanel5.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 2, 30, 30));

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel66.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel66MouseClicked(evt);
            }
        });
        kGradientPanel5.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 40, 35));

        jInternalFrame14.getContentPane().add(kGradientPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 35));

        search3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jInternalFrame14.getContentPane().add(search3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 250, 30));

        jButton66.setBackground(new java.awt.Color(0, 204, 102));
        jButton66.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton66.setForeground(new java.awt.Color(255, 255, 255));
        jButton66.setText("Search");
        jButton66.setContentAreaFilled(false);
        jButton66.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton66.setOpaque(true);
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66ActionPerformed(evt);
            }
        });
        jInternalFrame14.getContentPane().add(jButton66, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 140, 30));

        jInternalFrame4.getContentPane().add(jInternalFrame14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 740, 600));

        jInternalFrame15.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame15.setVisible(false);
        jInternalFrame15.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Company Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton35.setBackground(new java.awt.Color(0, 204, 102));
        jButton35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton35.setForeground(new java.awt.Color(255, 255, 255));
        jButton35.setText("Save");
        jButton35.setContentAreaFilled(false);
        jButton35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton35.setOpaque(true);
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel34.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 137, 45));

        jButton36.setBackground(new java.awt.Color(0, 204, 102));
        jButton36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton36.setForeground(new java.awt.Color(255, 255, 255));
        jButton36.setText("Update");
        jButton36.setContentAreaFilled(false);
        jButton36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton36.setOpaque(true);
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel34.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 145, 45));

        jLabel72.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 102, 102));
        jLabel72.setText("Company Id :");
        jPanel34.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, -1, 40));

        jLabel76.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 102, 102));
        jLabel76.setText("Company Name :");
        jPanel34.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 164, -1, 40));

        companyIdField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel34.add(companyIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 95, 331, 40));

        companyNameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel34.add(companyNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 164, 331, 40));

        jLabel80.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 102, 102));
        jLabel80.setText("Company Address :");
        jPanel34.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 242, -1, 40));

        companyAddress.setColumns(20);
        companyAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        companyAddress.setRows(5);
        jScrollPane1.setViewportView(companyAddress);

        jPanel34.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 242, 332, 90));

        validate5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        validate5.setForeground(new java.awt.Color(255, 0, 0));
        validate5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel34.add(validate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 29, 260, 31));

        companyIsActive.setBackground(new java.awt.Color(204, 255, 255));
        companyIsActive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        companyIsActive.setText("Active");
        companyIsActive.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 10));
        jPanel34.add(companyIsActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 90, 30));

        jPanel23.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 510));

        DataTable13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company Id", "Company Name", "Company Address", "Active"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable13.setRowHeight(25);
        DataTable13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable13MouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(DataTable13);

        jPanel23.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 720, 440));

        jButton38.setBackground(new java.awt.Color(0, 204, 102));
        jButton38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton38.setForeground(new java.awt.Color(255, 255, 255));
        jButton38.setText("Search");
        jButton38.setContentAreaFilled(false);
        jButton38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton38.setOpaque(true);
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 65, 140, 40));
        jPanel23.add(keywordField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 65, 340, 40));

        jInternalFrame15.getContentPane().add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1400, 650));

        kGradientPanel6.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel6.setkGradientFocus(1600);
        kGradientPanel6.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel77.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel77MouseClicked(evt);
            }
        });
        kGradientPanel6.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(1383, 3, 30, 30));

        jInternalFrame15.getContentPane().add(kGradientPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 35));

        jInternalFrame4.getContentPane().add(jInternalFrame15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 1420, 700));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Supplier Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel14.setOpaque(false);
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel14MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel14MouseReleased(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setOpaque(false);
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 102, 102));
        jLabel78.setText("Supplier Mobile :");
        jPanel24.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 89, -1, 40));

        jLabel79.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 102, 102));
        jLabel79.setText("Supplier Name :");
        jPanel24.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 169, -1, 40));

        supplierNameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        supplierNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel24.add(supplierNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 169, 350, 40));

        jLabel81.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 102, 102));
        jLabel81.setText("Company ID :");
        jPanel24.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 247, -1, 40));

        jButton12.setBackground(new java.awt.Color(0, 204, 102));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Save");
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.setOpaque(true);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel24.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 137, 45));

        jButton13.setBackground(new java.awt.Color(0, 204, 102));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Update");
        jButton13.setContentAreaFilled(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.setOpaque(true);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel24.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 145, 45));

        supplierMobField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        supplierMobField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        supplierMobField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                supplierMobFieldKeyTyped(evt);
            }
        });
        jPanel24.add(supplierMobField, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 89, 351, 40));

        jLabel83.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 102, 102));
        jLabel83.setText("Email (optional) :");
        jPanel24.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, 40));

        companyField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        companyField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        companyField.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        companyField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                companyFieldMouseClicked(evt);
            }
        });
        jPanel24.add(companyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 247, 351, 40));

        emailField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        emailField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel24.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 351, 40));

        validate6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        validate6.setForeground(new java.awt.Color(255, 0, 0));
        validate6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel24.add(validate6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 249, 31));

        supplierIsActive.setBackground(new java.awt.Color(204, 255, 255));
        supplierIsActive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        supplierIsActive.setText("Active");
        supplierIsActive.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 10));
        jPanel24.add(supplierIsActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 90, 30));

        jPanel14.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, 540));

        DataTable3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "Supplier Name", "Company", "Email", "Active"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable3.setRowHeight(25);
        DataTable3.setSelectionBackground(new java.awt.Color(7, 191, 227));
        DataTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(DataTable3);

        jPanel14.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 810, 510));

        jButton15.setBackground(new java.awt.Color(0, 204, 102));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Search");
        jButton15.setContentAreaFilled(false);
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.setOpaque(true);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 182, 140, 40));

        keywordField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        keywordField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        keywordField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keywordField2KeyTyped(evt);
            }
        });
        jPanel14.add(keywordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 185, 490, 40));

        jButton39.setBackground(new java.awt.Color(0, 204, 102));
        jButton39.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton39.setForeground(new java.awt.Color(255, 255, 255));
        jButton39.setText("Add Company");
        jButton39.setContentAreaFilled(false);
        jButton39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton39.setOpaque(true);
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 540, 50));

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(0, 102, 102));
        jLabel119.setText("Search by mobile");
        jPanel14.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, -1, 30));

        jInternalFrame4.getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame5.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame5.setBorder(null);
        jInternalFrame5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jInternalFrame5.setPreferredSize(new java.awt.Dimension(1620, 913));
        jInternalFrame5.setVisible(false);
        jInternalFrame5.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton11.setBackground(new java.awt.Color(0, 204, 102));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Add GRN Items");
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setOpaque(true);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jInternalFrame5.getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 410, 410, 130));

        jButton23.setBackground(new java.awt.Color(0, 204, 102));
        jButton23.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Add GRN");
        jButton23.setContentAreaFilled(false);
        jButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton23.setOpaque(true);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jInternalFrame5.getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 410, 130));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 102, 102));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Good Recieve Note");
        jInternalFrame5.getContentPane().add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 710, 120));
        jInternalFrame5.getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 710, -1));

        jDesktopPane1.add(jInternalFrame5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame13.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame13.setBorder(null);
        jInternalFrame13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jInternalFrame13.setPreferredSize(new java.awt.Dimension(1620, 913));
        jInternalFrame13.setVisible(false);
        jInternalFrame13.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame16.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame16.setVisible(false);
        jInternalFrame16.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier Mobile", "Supplier Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable14.setRowHeight(25);
        DataTable14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable14MouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(DataTable14);

        jInternalFrame16.getContentPane().add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 680, 340));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel75.setText("Click a row below to add the supplier details");
        jInternalFrame16.getContentPane().add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel82.setForeground(new java.awt.Color(255, 0, 0));
        jLabel82.setText("NOTE: Please add a supplier first if u cannot find a supplier below");
        jInternalFrame16.getContentPane().add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        kGradientPanel7.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel7.setkGradientFocus(850);
        kGradientPanel7.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel98.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel98MouseClicked(evt);
            }
        });
        kGradientPanel7.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 2, 30, 30));

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel70MouseClicked(evt);
            }
        });
        kGradientPanel7.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 3, -1, -1));

        jInternalFrame16.getContentPane().add(kGradientPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 35));

        search4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jInternalFrame16.getContentPane().add(search4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 250, 30));

        jButton67.setBackground(new java.awt.Color(0, 204, 102));
        jButton67.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton67.setForeground(new java.awt.Color(255, 255, 255));
        jButton67.setText("Search");
        jButton67.setContentAreaFilled(false);
        jButton67.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton67.setOpaque(true);
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });
        jInternalFrame16.getContentPane().add(jButton67, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 140, 30));

        jInternalFrame13.getContentPane().add(jInternalFrame16, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 740, 600));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "GRN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel15.setOpaque(false);
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel15MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel15MouseReleased(evt);
            }
        });
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setOpaque(false);
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grnSupplierMob.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        grnSupplierMob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        grnSupplierMob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        grnSupplierMob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grnSupplierMobMouseClicked(evt);
            }
        });
        jPanel29.add(grnSupplierMob, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 335, 40));

        jLabel68.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 102, 102));
        jLabel68.setText("Supplier Mobile :");
        jPanel29.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, 40));

        jLabel69.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 102, 102));
        jLabel69.setText("Supplier Name :");
        jPanel29.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, 40));

        grnSupplierName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        grnSupplierName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel29.add(grnSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 335, 40));

        jButton22.setBackground(new java.awt.Color(0, 204, 102));
        jButton22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Save");
        jButton22.setContentAreaFilled(false);
        jButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton22.setOpaque(true);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel29.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 526, 122, 43));

        jLabel74.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 102, 102));
        jLabel74.setText("Date :");
        jPanel29.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, -1, 40));

        grndate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel29.add(grndate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 335, 40));

        validate7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        validate7.setForeground(new java.awt.Color(255, 0, 0));
        validate7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel29.add(validate7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 249, 31));

        jButton50.setBackground(new java.awt.Color(0, 204, 102));
        jButton50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton50.setForeground(new java.awt.Color(255, 255, 255));
        jButton50.setText("Add items >>");
        jButton50.setContentAreaFilled(false);
        jButton50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton50.setOpaque(true);
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });
        jPanel29.add(jButton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 610, 180, 43));

        jPanel15.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 700));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setOpaque(false);
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN ID", "Supplier Name", "Supplier Mobile", "Date", "Total Payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DataTable4.setRowHeight(25);
        DataTable4.setSelectionBackground(new java.awt.Color(7, 191, 227));
        jScrollPane4.setViewportView(DataTable4);

        jPanel25.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 860, 360));

        jButton16.setBackground(new java.awt.Color(0, 204, 102));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Search");
        jButton16.setContentAreaFilled(false);
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.setOpaque(true);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel25.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 140, 40));

        keywordField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        keywordField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel25.add(keywordField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 350, 40));

        searchcategoryCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchcategoryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grn Id", "Supplier Name" }));
        jPanel25.add(searchcategoryCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 180, 40));

        jPanel15.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 880, 470));

        jInternalFrame13.getContentPane().add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame17.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame17.setBorder(null);
        jInternalFrame17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jInternalFrame17.setPreferredSize(new java.awt.Dimension(1620, 913));
        jInternalFrame17.setVisible(false);
        jInternalFrame17.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame18.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame18.setVisible(false);
        jInternalFrame18.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable15.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN Id", "Supplier Name", "Supplier Mobile", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable15.setRowHeight(25);
        DataTable15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable15MouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(DataTable15);

        jInternalFrame18.getContentPane().add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 680, 340));

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel89.setText("Click a row below to add the GRN Id");
        jInternalFrame18.getContentPane().add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel90.setForeground(new java.awt.Color(255, 0, 0));
        jLabel90.setText("NOTE: Please add a GRN first if u cannot find a GRN below");
        jInternalFrame18.getContentPane().add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        kGradientPanel8.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel8.setkGradientFocus(850);
        kGradientPanel8.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel96.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel96.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel96MouseClicked(evt);
            }
        });
        kGradientPanel8.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 2, 30, 30));

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel88MouseClicked(evt);
            }
        });
        kGradientPanel8.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 3, -1, -1));

        jInternalFrame18.getContentPane().add(kGradientPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 35));

        search5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jInternalFrame18.getContentPane().add(search5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 250, 30));

        jButton68.setBackground(new java.awt.Color(0, 204, 102));
        jButton68.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton68.setForeground(new java.awt.Color(255, 255, 255));
        jButton68.setText("Search");
        jButton68.setContentAreaFilled(false);
        jButton68.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton68.setOpaque(true);
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton68ActionPerformed(evt);
            }
        });
        jInternalFrame18.getContentPane().add(jButton68, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 140, 30));

        jInternalFrame17.getContentPane().add(jInternalFrame18, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 740, 600));

        jInternalFrame19.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame19.setVisible(false);
        jInternalFrame19.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable16.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Product Name", "Brand"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable16.setRowHeight(25);
        DataTable16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable16MouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(DataTable16);

        jInternalFrame19.getContentPane().add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 680, 350));

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel92.setText("Click a row below to add the product details");
        jInternalFrame19.getContentPane().add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel93.setForeground(new java.awt.Color(255, 0, 0));
        jLabel93.setText("NOTE: Please add a product first if u cannot find a product below");
        jInternalFrame19.getContentPane().add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        kGradientPanel9.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel9.setkGradientFocus(850);
        kGradientPanel9.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel99.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel99MouseClicked(evt);
            }
        });
        kGradientPanel9.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 2, 30, 30));

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel91MouseClicked(evt);
            }
        });
        kGradientPanel9.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 3, -1, -1));

        jInternalFrame19.getContentPane().add(kGradientPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 35));

        search6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jInternalFrame19.getContentPane().add(search6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 250, 30));

        jButton69.setBackground(new java.awt.Color(0, 204, 102));
        jButton69.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton69.setForeground(new java.awt.Color(255, 255, 255));
        jButton69.setText("Search");
        jButton69.setContentAreaFilled(false);
        jButton69.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton69.setOpaque(true);
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69ActionPerformed(evt);
            }
        });
        jInternalFrame19.getContentPane().add(jButton69, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 140, 30));

        jInternalFrame17.getContentPane().add(jInternalFrame19, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 740, 600));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "GRN Item", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel32.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel32.setOpaque(false);
        jPanel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel32MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel32MouseReleased(evt);
            }
        });
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setOpaque(false);
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grnId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        grnId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        grnId.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        grnId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grnIdMouseClicked(evt);
            }
        });
        jPanel33.add(grnId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 335, 40));

        jLabel84.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 102, 102));
        jLabel84.setText("GRN Id :");
        jPanel33.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, 40));

        jLabel85.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 102, 102));
        jLabel85.setText("Product Barcode :");
        jPanel33.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, 40));

        productId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        productId.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productIdMouseClicked(evt);
            }
        });
        jPanel33.add(productId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 335, 40));

        jLabel86.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 102, 102));
        jLabel86.setText("Qty :");
        jPanel33.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, 40));

        jButton24.setBackground(new java.awt.Color(0, 204, 102));
        jButton24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("Save ");
        jButton24.setContentAreaFilled(false);
        jButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton24.setOpaque(true);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel33.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 630, 150, 47));

        jLabel87.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 102, 102));
        jLabel87.setText("Buying Price :");
        jPanel33.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, -1, 40));

        grnQty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        grnQty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        grnQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                grnQtyKeyTyped(evt);
            }
        });
        jPanel33.add(grnQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 335, 40));

        buyPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buyPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel33.add(buyPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 335, 40));

        validate8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        validate8.setForeground(new java.awt.Color(255, 0, 0));
        validate8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel33.add(validate8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 249, 31));

        jPanel32.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 630, 740));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setOpaque(false);
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        keywordField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel35.add(keywordField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 25, 300, 40));

        DataTable11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN Item Id", "GRN Id", "Product", "Qty", "Buying Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DataTable11.setRowHeight(25);
        DataTable11.setSelectionBackground(new java.awt.Color(7, 191, 227));
        jScrollPane7.setViewportView(DataTable11);

        jPanel35.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 103, 756, 360));

        jButton31.setBackground(new java.awt.Color(0, 204, 102));
        jButton31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("Search");
        jButton31.setContentAreaFilled(false);
        jButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton31.setOpaque(true);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel35.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 25, 120, 40));

        searchCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grn Id", "Product Name" }));
        jPanel35.add(searchCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 25, 180, 40));

        jPanel32.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, -1, -1));

        jButton32.setBackground(new java.awt.Color(0, 204, 102));
        jButton32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setText("Generate Grn");
        jButton32.setContentAreaFilled(false);
        jButton32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton32.setOpaque(true);
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel32.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 670, 250, 47));

        jInternalFrame17.getContentPane().add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame6.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame6.setBorder(null);
        jInternalFrame6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jInternalFrame6.setPreferredSize(new java.awt.Dimension(1620, 913));
        jInternalFrame6.setVisible(false);
        jInternalFrame6.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Admin Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel18.setOpaque(false);
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton28.setBackground(new java.awt.Color(0, 204, 102));
        jButton28.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setText("Stocks");
        jButton28.setContentAreaFilled(false);
        jButton28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton28.setOpaque(true);
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 410, 130));

        jButton29.setBackground(new java.awt.Color(0, 204, 102));
        jButton29.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setText("Invoices");
        jButton29.setContentAreaFilled(false);
        jButton29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton29.setOpaque(true);
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 410, 130));

        jButton33.setBackground(new java.awt.Color(0, 204, 102));
        jButton33.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton33.setForeground(new java.awt.Color(255, 255, 255));
        jButton33.setText("Backup/Restore");
        jButton33.setContentAreaFilled(false);
        jButton33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton33.setOpaque(true);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 640, 410, 130));

        jButton34.setBackground(new java.awt.Color(0, 204, 102));
        jButton34.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("Sales");
        jButton34.setContentAreaFilled(false);
        jButton34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton34.setOpaque(true);
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 410, 130));

        jButton40.setBackground(new java.awt.Color(0, 204, 102));
        jButton40.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton40.setForeground(new java.awt.Color(255, 255, 255));
        jButton40.setText("Pharmacists");
        jButton40.setContentAreaFilled(false);
        jButton40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton40.setOpaque(true);
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 410, 130));

        jButton44.setBackground(new java.awt.Color(0, 204, 102));
        jButton44.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton44.setForeground(new java.awt.Color(255, 255, 255));
        jButton44.setText("Attendance");
        jButton44.setContentAreaFilled(false);
        jButton44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton44.setOpaque(true);
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 410, 130));

        jButton49.setBackground(new java.awt.Color(0, 204, 102));
        jButton49.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton49.setForeground(new java.awt.Color(255, 255, 255));
        jButton49.setText("Payroll/Salary");
        jButton49.setContentAreaFilled(false);
        jButton49.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton49.setOpaque(true);
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 460, 410, 130));

        jButton51.setBackground(new java.awt.Color(0, 204, 102));
        jButton51.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton51.setForeground(new java.awt.Color(255, 255, 255));
        jButton51.setText("Profits");
        jButton51.setContentAreaFilled(false);
        jButton51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton51.setOpaque(true);
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 640, 410, 130));

        jInternalFrame6.getContentPane().add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame22.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame22.setBorder(null);
        jInternalFrame22.setVisible(false);
        jInternalFrame22.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Sales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel38.setOpaque(false);
        jPanel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel38MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel38MouseReleased(evt);
            }
        });
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable21.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice Id", "Invoice Date", "Invoice Total", "Discount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable21.setRowHeight(25);
        DataTable21.setSelectionBackground(new java.awt.Color(7, 191, 227));
        jScrollPane22.setViewportView(DataTable21);

        jPanel38.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 1250, 410));

        jButton37.setBackground(new java.awt.Color(0, 204, 102));
        jButton37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton37.setForeground(new java.awt.Color(255, 255, 255));
        jButton37.setText("Search");
        jButton37.setContentAreaFilled(false);
        jButton37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton37.setOpaque(true);
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel38.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 120, 40));

        jButton53.setBackground(new java.awt.Color(0, 204, 102));
        jButton53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton53.setForeground(new java.awt.Color(255, 255, 255));
        jButton53.setText("Search");
        jButton53.setContentAreaFilled(false);
        jButton53.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton53.setOpaque(true);
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });
        jPanel38.add(jButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 120, 40));

        jButton55.setBackground(new java.awt.Color(0, 204, 102));
        jButton55.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton55.setForeground(new java.awt.Color(255, 255, 255));
        jButton55.setText("Search");
        jButton55.setContentAreaFilled(false);
        jButton55.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton55.setOpaque(true);
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });
        jPanel38.add(jButton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 190, 120, 40));

        salesMonth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        salesMonth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salesMonth.setMonth(0);
        salesMonth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                salesMonthPropertyChange(evt);
            }
        });
        jPanel38.add(salesMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 140, 40));

        dateOnly.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel38.add(dateOnly, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 240, 40));

        date2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel38.add(date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 120, 240, 40));

        date1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel38.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, 240, 40));

        salesTotal.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        salesTotal.setForeground(new java.awt.Color(0, 102, 102));
        salesTotal.setText("0.0");
        jPanel38.add(salesTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 740, -1, -1));

        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(0, 102, 102));
        jLabel130.setText("Total Sales Amount : Rs.");
        jPanel38.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 740, -1, -1));

        jInternalFrame22.getContentPane().add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame23.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame23.setBorder(null);
        jInternalFrame23.setVisible(false);
        jInternalFrame23.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Stocks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel40.setOpaque(false);
        jPanel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel40MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel40MouseReleased(evt);
            }
        });
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable18.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Id", "Barcode", "Product Name", "Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable18.setRowHeight(25);
        DataTable18.setSelectionBackground(new java.awt.Color(7, 191, 227));
        jScrollPane20.setViewportView(DataTable18);

        jPanel40.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 1250, 450));

        stockProductField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        stockProductField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel40.add(stockProductField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 330, 40));

        jButton48.setBackground(new java.awt.Color(0, 204, 102));
        jButton48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton48.setForeground(new java.awt.Color(255, 255, 255));
        jButton48.setText("Search");
        jButton48.setContentAreaFilled(false);
        jButton48.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton48.setOpaque(true);
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });
        jPanel40.add(jButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, 140, 40));

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(0, 102, 102));
        jLabel120.setText("Search by product name");
        jPanel40.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, -1, 30));

        jButton72.setBackground(new java.awt.Color(0, 204, 102));
        jButton72.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton72.setForeground(new java.awt.Color(255, 255, 255));
        jButton72.setText("Generate Report");
        jButton72.setContentAreaFilled(false);
        jButton72.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton72.setOpaque(true);
        jButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton72ActionPerformed(evt);
            }
        });
        jPanel40.add(jButton72, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 740, 300, 50));

        jInternalFrame23.getContentPane().add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame24.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame24.setBorder(null);
        jInternalFrame24.setVisible(false);
        jInternalFrame24.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame25.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame25.setVisible(false);
        jInternalFrame25.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable20.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Brand", "Product Name", "Qty", "Selling Price", "Discount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DataTable20.setRowHeight(25);
        jScrollPane23.setViewportView(DataTable20);

        jInternalFrame25.getContentPane().add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 1310, 450));

        kGradientPanel10.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel10.setkGradientFocus(1400);
        kGradientPanel10.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel97.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel97MouseClicked(evt);
            }
        });
        kGradientPanel10.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(1385, 3, 30, 30));

        jInternalFrame25.getContentPane().add(kGradientPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 35));

        jInternalFrame24.getContentPane().add(jInternalFrame25, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 102, 1420, 630));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Invoices", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel41.setOpaque(false);
        jPanel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel41MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel41MouseReleased(evt);
            }
        });
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable19.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice Id", "Date", "Total", "Discount", "Customer Mobile"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable19.setRowHeight(25);
        DataTable19.setSelectionBackground(new java.awt.Color(7, 191, 227));
        DataTable19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable19MouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(DataTable19);

        jPanel41.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 1320, 490));

        invViewId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        invViewId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        invViewId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                invViewIdKeyTyped(evt);
            }
        });
        jPanel41.add(invViewId, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 110, 40));

        jButton46.setBackground(new java.awt.Color(0, 204, 102));
        jButton46.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton46.setForeground(new java.awt.Color(255, 255, 255));
        jButton46.setText("Search");
        jButton46.setContentAreaFilled(false);
        jButton46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton46.setOpaque(true);
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });
        jPanel41.add(jButton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 130, 140, 40));

        jDateChooser1.setDateFormatString("yyyy-MM-d");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel41.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 220, 40));

        jButton47.setBackground(new java.awt.Color(0, 204, 102));
        jButton47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton47.setForeground(new java.awt.Color(255, 255, 255));
        jButton47.setText("Search");
        jButton47.setContentAreaFilled(false);
        jButton47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton47.setOpaque(true);
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        jPanel41.add(jButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 140, 40));

        jLabel121.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(0, 102, 102));
        jLabel121.setText("Invoice Id");
        jPanel41.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, 30));

        jInternalFrame24.getContentPane().add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame21.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame21.setBorder(null);
        jInternalFrame21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jInternalFrame21.setVisible(false);
        jInternalFrame21.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Pharmacist Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel16.setOpaque(false);
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel16MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel16MouseReleased(evt);
            }
        });
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setOpaque(false);
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pharmacistKeywordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pharmacistKeywordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel37.add(pharmacistKeywordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 25, 403, 40));

        DataTable17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable17.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pharmacist Id", "Pharmacist Name", "Mobile", "Address", "Experience", "Active"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable17.setFocusable(false);
        DataTable17.setIntercellSpacing(new java.awt.Dimension(0, 0));
        DataTable17.setRowHeight(25);
        DataTable17.setSelectionBackground(new java.awt.Color(7, 191, 227));
        DataTable17.getTableHeader().setReorderingAllowed(false);
        DataTable17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable17MouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(DataTable17);

        jPanel37.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 95, 850, 360));

        jButton41.setBackground(new java.awt.Color(0, 204, 102));
        jButton41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton41.setForeground(new java.awt.Color(255, 255, 255));
        jButton41.setText("Search");
        jButton41.setContentAreaFilled(false);
        jButton41.setOpaque(true);
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        jPanel37.add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 23, 140, 40));

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(0, 102, 102));
        jLabel122.setText("Search by pharmacist name");
        jPanel37.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 30));

        jPanel16.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 140, 880, 470));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setOpaque(false);
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pharmacistMob.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pharmacistMob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        pharmacistMob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pharmacistMobKeyTyped(evt);
            }
        });
        jPanel39.add(pharmacistMob, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 370, 40));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 102, 102));
        jLabel43.setText("Mobile :");
        jPanel39.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel52.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 102));
        jLabel52.setText("Pharmacist Name :");
        jPanel39.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel64.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 102, 102));
        jLabel64.setText("Experience :");
        jPanel39.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        pharmacistAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pharmacistAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        pharmacistAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pharmacistAddressMouseClicked(evt);
            }
        });
        jPanel39.add(pharmacistAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 370, 40));

        jButton42.setBackground(new java.awt.Color(0, 204, 102));
        jButton42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton42.setForeground(new java.awt.Color(255, 255, 255));
        jButton42.setText("Save");
        jButton42.setContentAreaFilled(false);
        jButton42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton42.setOpaque(true);
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel39.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 120, 40));

        jButton43.setBackground(new java.awt.Color(0, 204, 102));
        jButton43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton43.setForeground(new java.awt.Color(255, 255, 255));
        jButton43.setText("Update");
        jButton43.setContentAreaFilled(false);
        jButton43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton43.setOpaque(true);
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel39.add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 620, 120, 40));

        pharmacistName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pharmacistName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        pharmacistName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pharmacistNameMouseClicked(evt);
            }
        });
        jPanel39.add(pharmacistName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 370, 40));

        validate2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        validate2.setForeground(new java.awt.Color(255, 0, 0));
        validate2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel39.add(validate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 23, 345, 30));

        jLabel65.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 102, 102));
        jLabel65.setText("Address :");
        jPanel39.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel39.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 370, 40));

        pharmacistId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pharmacistId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel39.add(pharmacistId, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 370, 40));

        jLabel73.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 102, 102));
        jLabel73.setText("Pharmacist Id :");
        jPanel39.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        isActive.setBackground(new java.awt.Color(204, 255, 255));
        isActive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        isActive.setText("Active");
        isActive.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 10));
        jPanel39.add(isActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 90, 30));

        jPanel16.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 650, 680));

        jButton75.setBackground(new java.awt.Color(0, 204, 102));
        jButton75.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton75.setForeground(new java.awt.Color(255, 255, 255));
        jButton75.setText("Print Report");
        jButton75.setContentAreaFilled(false);
        jButton75.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton75.setOpaque(true);
        jButton75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton75ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton75, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 660, 190, 50));

        jInternalFrame21.getContentPane().add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame26.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame26.setBorder(null);
        jInternalFrame26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jInternalFrame26.setVisible(false);
        jInternalFrame26.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame28.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame28.setVisible(false);
        jInternalFrame28.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable22.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pharmacist ID", "Pharmacist Name", "Pharmacist Mobile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable22.setRowHeight(25);
        DataTable22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable22MouseClicked(evt);
            }
        });
        jScrollPane24.setViewportView(DataTable22);

        jInternalFrame28.getContentPane().add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 680, 350));

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel100.setText("Click a row below to add the pharmacist");
        jInternalFrame28.getContentPane().add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel101.setForeground(new java.awt.Color(255, 0, 0));
        jLabel101.setText("NOTE: Please add a pharmacist first if u cannot find a pharmacist below");
        jInternalFrame28.getContentPane().add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        kGradientPanel11.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel11.setkGradientFocus(850);
        kGradientPanel11.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel103MouseClicked(evt);
            }
        });
        kGradientPanel11.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 40, 35));

        jInternalFrame28.getContentPane().add(kGradientPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 35));

        search7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jInternalFrame28.getContentPane().add(search7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 250, 30));

        jButton70.setBackground(new java.awt.Color(0, 204, 102));
        jButton70.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton70.setForeground(new java.awt.Color(255, 255, 255));
        jButton70.setText("Search");
        jButton70.setContentAreaFilled(false);
        jButton70.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton70.setOpaque(true);
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton70ActionPerformed(evt);
            }
        });
        jInternalFrame28.getContentPane().add(jButton70, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 140, 30));

        jInternalFrame26.getContentPane().add(jInternalFrame28, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 740, 600));

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Attendance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel49.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel49.setOpaque(false);
        jPanel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel49MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel49MouseReleased(evt);
            }
        });
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.setOpaque(false);
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable24.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pharmacist Id", "Pharmacist Name", "Pharmacist Mobile", "Date", "Arrived Time", "Left Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable24.setFocusable(false);
        DataTable24.setIntercellSpacing(new java.awt.Dimension(0, 0));
        DataTable24.setRowHeight(25);
        DataTable24.setSelectionBackground(new java.awt.Color(7, 191, 227));
        DataTable24.getTableHeader().setReorderingAllowed(false);
        DataTable24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable24MouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(DataTable24);

        jPanel50.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 850, 360));

        jPanel49.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 880, 400));

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setOpaque(false);
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel111.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(0, 102, 102));
        jLabel111.setText("Pharmacist Name :");
        jPanel51.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        timeField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        timeField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        timeField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timeFieldMouseClicked(evt);
            }
        });
        jPanel51.add(timeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 370, 40));

        jButton57.setBackground(new java.awt.Color(0, 204, 102));
        jButton57.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton57.setForeground(new java.awt.Color(255, 255, 255));
        jButton57.setText("Arrive");
        jButton57.setContentAreaFilled(false);
        jButton57.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton57.setOpaque(true);
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });
        jPanel51.add(jButton57, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 120, 40));

        jButton58.setBackground(new java.awt.Color(0, 204, 102));
        jButton58.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton58.setForeground(new java.awt.Color(255, 255, 255));
        jButton58.setText("Leave");
        jButton58.setContentAreaFilled(false);
        jButton58.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton58.setOpaque(true);
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });
        jPanel51.add(jButton58, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 120, 40));

        pharmacistName3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pharmacistName3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        pharmacistName3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pharmacistName3MouseClicked(evt);
            }
        });
        jPanel51.add(pharmacistName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 370, 40));

        validate11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        validate11.setForeground(new java.awt.Color(255, 0, 0));
        validate11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel51.add(validate11, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 23, 345, 30));

        jLabel113.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 102, 102));
        jLabel113.setText("Time :");
        jPanel51.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        pharmacistId3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pharmacistId3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        pharmacistId3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pharmacistId3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pharmacistId3MouseClicked(evt);
            }
        });
        jPanel51.add(pharmacistId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 370, 40));

        jLabel114.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 102, 102));
        jLabel114.setText("Pharmacist Id :");
        jPanel51.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jPanel49.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 650, 530));

        jButton73.setBackground(new java.awt.Color(0, 204, 102));
        jButton73.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton73.setForeground(new java.awt.Color(255, 255, 255));
        jButton73.setText("Print Report");
        jButton73.setContentAreaFilled(false);
        jButton73.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton73.setOpaque(true);
        jButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton73ActionPerformed(evt);
            }
        });
        jPanel49.add(jButton73, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 660, 190, 50));

        jInternalFrame26.getContentPane().add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame27.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame27.setBorder(null);
        jInternalFrame27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jInternalFrame27.setVisible(false);
        jInternalFrame27.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrame29.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jInternalFrame29.setVisible(false);
        jInternalFrame29.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable23.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pharmacist ID", "Pharmacist Name", "Pharmacist Mobile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable23.setRowHeight(25);
        DataTable23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable23MouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(DataTable23);

        jInternalFrame29.getContentPane().add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 680, 350));

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel107.setText("Click a row below to add the pharmacist");
        jInternalFrame29.getContentPane().add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel108.setForeground(new java.awt.Color(255, 0, 0));
        jLabel108.setText("NOTE: Please add a pharmacist first if u cannot find a pharmacist below");
        jInternalFrame29.getContentPane().add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        kGradientPanel12.setkEndColor(new java.awt.Color(7, 139, 203));
        kGradientPanel12.setkGradientFocus(850);
        kGradientPanel12.setkStartColor(new java.awt.Color(0, 235, 145));
        kGradientPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel109.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel109MouseClicked(evt);
            }
        });
        kGradientPanel12.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 2, 30, 30));

        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jLabel115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel115MouseClicked(evt);
            }
        });
        kGradientPanel12.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 40, 35));

        jInternalFrame29.getContentPane().add(kGradientPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 35));

        search8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jInternalFrame29.getContentPane().add(search8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 250, 30));

        jButton71.setBackground(new java.awt.Color(0, 204, 102));
        jButton71.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton71.setForeground(new java.awt.Color(255, 255, 255));
        jButton71.setText("Search");
        jButton71.setContentAreaFilled(false);
        jButton71.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton71.setOpaque(true);
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton71ActionPerformed(evt);
            }
        });
        jInternalFrame29.getContentPane().add(jButton71, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 140, 30));

        jInternalFrame27.getContentPane().add(jInternalFrame29, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 740, 600));

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Salaray Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel52.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel52.setOpaque(false);
        jPanel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel52MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel52MouseReleased(evt);
            }
        });
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setOpaque(false);
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pharmacistNameKeyword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pharmacistNameKeyword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel53.add(pharmacistNameKeyword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 403, 40));

        DataTable25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable25.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pharmacist Name", "Pharmacist Mobile", "Month/Year", "Salary Paid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable25.setFocusable(false);
        DataTable25.setIntercellSpacing(new java.awt.Dimension(0, 0));
        DataTable25.setRowHeight(25);
        DataTable25.setSelectionBackground(new java.awt.Color(7, 191, 227));
        DataTable25.getTableHeader().setReorderingAllowed(false);
        jScrollPane27.setViewportView(DataTable25);

        jPanel53.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 95, 920, 360));

        jButton59.setBackground(new java.awt.Color(0, 204, 102));
        jButton59.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton59.setForeground(new java.awt.Color(255, 255, 255));
        jButton59.setText("Search");
        jButton59.setContentAreaFilled(false);
        jButton59.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton59.setOpaque(true);
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });
        jPanel53.add(jButton59, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 140, 40));

        jLabel123.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(0, 102, 102));
        jLabel123.setText("Search by pharmacist name");
        jPanel53.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 30));

        jPanel52.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 950, 470));

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setOpaque(false);
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel110.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 102, 102));
        jLabel110.setText("Salary Payable     :");
        jPanel54.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel112.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(0, 102, 102));
        jLabel112.setText("Pharmacist Name :");
        jPanel54.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jButton60.setBackground(new java.awt.Color(0, 204, 102));
        jButton60.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton60.setForeground(new java.awt.Color(255, 255, 255));
        jButton60.setText("Save & Generate Pay Sheet");
        jButton60.setContentAreaFilled(false);
        jButton60.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton60.setOpaque(true);
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });
        jPanel54.add(jButton60, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 320, 60));

        pharmacistName4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pharmacistName4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel54.add(pharmacistName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 320, 40));

        validate12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        validate12.setForeground(new java.awt.Color(255, 0, 0));
        validate12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel54.add(validate12, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 23, 345, 30));

        pharmacistId4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pharmacistId4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        pharmacistId4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pharmacistId4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pharmacistId4MouseClicked(evt);
            }
        });
        pharmacistId4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pharmacistId4KeyReleased(evt);
            }
        });
        jPanel54.add(pharmacistId4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 320, 40));

        jLabel117.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 102, 102));
        jLabel117.setText("Pharmacist Id       :");
        jPanel54.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jMonthChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jMonthChooser1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jMonthChooser1.setMonth(0);
        jMonthChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jMonthChooser1PropertyChange(evt);
            }
        });
        jPanel54.add(jMonthChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 140, 40));

        jLabel118.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(0, 102, 102));
        jLabel118.setText("Month                   :");
        jPanel54.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        totalSalary.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        totalSalary.setText("0.0");
        jPanel54.add(totalSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 170, 40));

        totalSalary1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        totalSalary1.setText("Rs.");
        jPanel54.add(totalSalary1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 30, 40));

        jPanel52.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 580, 680));

        jButton61.setBackground(new java.awt.Color(0, 204, 102));
        jButton61.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton61.setForeground(new java.awt.Color(255, 255, 255));
        jButton61.setText("Manage Salary Amounts");
        jButton61.setContentAreaFilled(false);
        jButton61.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton61.setOpaque(true);
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });
        jPanel52.add(jButton61, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 90, 300, 50));

        jInternalFrame27.getContentPane().add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame30.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame30.setBorder(null);
        jInternalFrame30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jInternalFrame30.setVisible(false);
        jInternalFrame30.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Profit Calculation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel55.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel55.setOpaque(false);
        jPanel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel55MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel55MouseReleased(evt);
            }
        });
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));
        jPanel56.setOpaque(false);
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTable27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DataTable27.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN Amount", "Invoice Amount", "Electricity Bill", "Total Profit", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable27.setFocusable(false);
        DataTable27.setIntercellSpacing(new java.awt.Dimension(0, 0));
        DataTable27.setRowHeight(25);
        DataTable27.setSelectionBackground(new java.awt.Color(7, 191, 227));
        DataTable27.getTableHeader().setReorderingAllowed(false);
        jScrollPane29.setViewportView(DataTable27);

        jPanel56.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 850, 360));

        jPanel55.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, 880, 400));

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setOpaque(false);
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel127.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(0, 102, 102));
        jLabel127.setText("Electricity Bill :");
        jPanel57.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        jButton62.setBackground(new java.awt.Color(0, 204, 102));
        jButton62.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton62.setForeground(new java.awt.Color(255, 255, 255));
        jButton62.setText("Search");
        jButton62.setContentAreaFilled(false);
        jButton62.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton62.setOpaque(true);
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });
        jPanel57.add(jButton62, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 120, 40));

        jButton63.setBackground(new java.awt.Color(0, 204, 102));
        jButton63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton63.setForeground(new java.awt.Color(255, 255, 255));
        jButton63.setText("Calculate");
        jButton63.setContentAreaFilled(false);
        jButton63.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton63.setOpaque(true);
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });
        jPanel57.add(jButton63, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 150, 50));

        lecobill.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lecobill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        lecobill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lecobillMouseClicked(evt);
            }
        });
        lecobill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lecobillKeyTyped(evt);
            }
        });
        jPanel57.add(lecobill, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 230, 40));

        jLabel128.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(0, 102, 102));
        jLabel128.setText("Invoice Total :");
        jPanel57.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jLabel129.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(0, 102, 102));
        jLabel129.setText("TOTAL AMOUNT :");
        jPanel57.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        jMonthChooser2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jMonthChooser2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jMonthChooser2.setMonth(0);
        jMonthChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jMonthChooser2PropertyChange(evt);
            }
        });
        jPanel57.add(jMonthChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 140, 40));

        jLabel132.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(0, 102, 102));
        jLabel132.setText("GRN Total :");
        jPanel57.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        totalAmount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        totalAmount.setText("0.00");
        jPanel57.add(totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 120, 40));

        totallabe1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totallabe1.setText("0.00");
        jPanel57.add(totallabe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 100, 40));

        totallabe2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totallabe2.setText("0.00");
        jPanel57.add(totallabe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 100, 40));

        jPanel55.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 650, 530));

        jInternalFrame30.getContentPane().add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jInternalFrame7.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame7.setBorder(null);
        jInternalFrame7.setPreferredSize(new java.awt.Dimension(1620, 913));
        jInternalFrame7.setVisible(false);
        jInternalFrame7.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Administrator Backup and Restore Database", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel22.setOpaque(false);
        jPanel22.setPreferredSize(new java.awt.Dimension(1596, 855));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Backup", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel27.setOpaque(false);

        backupPathField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backupPathField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jButton9.setBackground(new java.awt.Color(0, 204, 102));
        jButton9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Backup");
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setOpaque(true);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 204, 102));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Backup Path");
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setOpaque(true);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(backupPathField, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backupPathField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Restore", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel28.setOpaque(false);

        restorePathField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        restorePathField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        jButton20.setBackground(new java.awt.Color(0, 204, 102));
        jButton20.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Restore");
        jButton20.setContentAreaFilled(false);
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.setOpaque(true);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(0, 204, 102));
        jButton21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("Restore Path");
        jButton21.setContentAreaFilled(false);
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton21.setOpaque(true);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(restorePathField, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restorePathField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backRes.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel55)))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jInternalFrame7.getContentPane().add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 850));

        jDesktopPane1.add(jInternalFrame7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, 1620, 920));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.png"))); // NOI18N
        jDesktopPane1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1620, 890));

        jPanel1.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 1740, 890));

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/website.png"))); // NOI18N
        jMenuItem8.setText("Open Website");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        jMenuItem6.setText("Logout");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Navigate");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem9.setText("POS");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N
        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/headphones.png"))); // NOI18N
        jMenuItem3.setText("Support");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        JFileChooser backupPathFileChooser = new JFileChooser();

        int returnVal = backupPathFileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String selectedFileName = backupPathFileChooser.getSelectedFile().getName();
            String selectedFilePath = backupPathFileChooser.getCurrentDirectory().getPath();

            String backupPath = selectedFilePath + "\\" + selectedFileName;
            restorePathField.setText(backupPath);
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if (restorePathField.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(rootPane, "Path not found", "Warning", -1, 2);
        } else {
            String path = restorePathField.getText();
            String result = new backupRestoreCode().restoreDB(path);

            JOptionPane.showConfirmDialog(rootPane, result, "info", -1, 1);
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        JFileChooser backupPathFileChooser = new JFileChooser();

        int returnVal = backupPathFileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String selectedFileName = backupPathFileChooser.getSelectedFile().getName();
            String selectedFilePath = backupPathFileChooser.getCurrentDirectory().getPath();

            String backupPath = selectedFilePath + "\\" + selectedFileName;
            backupPathField.setText(backupPath);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (backupPathField.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(rootPane, "Path not found", "Warning", -1, 2);
        } else {
            String path = backupPathField.getText();
            String result = new backupRestoreCode().backupDB(path);
            JOptionPane.showConfirmDialog(rootPane, result, "info", -1, 1);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        if (grndate.getDate() == null || grnSupplierMob.getText().isEmpty()) {
            validate7.setText("Field(s) are Empty");
        } else {
            //read fields
            Date gdate = grndate.getDate();
            String mob = grnSupplierMob.getText();

            //call userModel
            String result = grnModel.insertGrn(gdate, mob);
            grnModel.loadTable("", grnTableModel);
            JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);

            grnSupplierMob.setText("");
            grnSupplierName.setText("");
            grndate.setDate(null);
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String keyword = keywordField3.getText();
        int categoryId = searchcategoryCombo.getSelectedIndex();

        grnModel.searchTable(keyword, categoryId, grnTableModel);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void DataTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable1MouseClicked
        int row = DataTable1.getSelectedRow();
        int customerMob = (int) customerTableModel.getValueAt(row, 0);
        Object[] userData = customerModel.getSelectedUserDataById(customerMob);

        custoMobField.setText(new String(userData[0] + ""));
        custoNameField.setText(String.valueOf(userData[1]));
        custoEmailField.setText(String.valueOf(userData[2]));
    }//GEN-LAST:event_DataTable1MouseClicked

    private void custoNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custoNameFieldMouseClicked

    }//GEN-LAST:event_custoNameFieldMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (custoMobField.getText().isEmpty()) {
            validate1.setText("Please select a row from the table");
        } else {
            String mob = custoMobField.getText();

            String result = customerModel.deleteUser(mob);

            JOptionPane.showConfirmDialog(rootPane, result, result, -1, 1);
            customerModel.loadTable("", customerTableModel);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //validate fields
        if (custoMobField.getText().isEmpty() || custoNameField.getText().isEmpty()) {
            validate1.setText("Field(s) are Empty");
        } else {
            String custoMob = custoMobField.getText();
            String custoName = custoNameField.getText();
            String custoEmail = custoEmailField.getText();

            //call userModel
            String result = customerModel.updateUser(custoMob, custoName, custoEmail);

            customerModel.loadTable("", customerTableModel);
            JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //validate fields
        if (custoMobField.getText().isEmpty() || custoNameField.getText().isEmpty()) {
            validate1.setText("Field(s) are Empty");
        } else {
            //read fields
            String mobile = custoMobField.getText();
            String name = custoNameField.getText();
            String email = custoEmailField.getText();

            //call userModel
            String result = customerModel.insertCustomer(mobile, name, email);
            customerModel.loadTable("", customerTableModel);
            JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void custoEmailFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custoEmailFieldMouseClicked

    }//GEN-LAST:event_custoEmailFieldMouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        glassPaneNotVisible(jInternalFrame8);
    }//GEN-LAST:event_jLabel34MouseClicked

    private void DataTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable5MouseClicked
        int row = DataTable5.getSelectedRow();
        int brandId = (int) brandTableModel2.getValueAt(row, 0);
        brandField.setText(String.valueOf(brandId));
        glassPaneNotVisible(jInternalFrame8);
    }//GEN-LAST:event_DataTable5MouseClicked

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        jPanel8.setOpaque(false);
        jPanel8.repaint();
    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        jPanel8.setOpaque(true);
        jPanel8.repaint();
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        bar(jLabel17);
        guiVisibility(jInternalFrame6);
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        jPanel7.setOpaque(false);
        jPanel7.repaint();
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        jPanel7.setOpaque(true);
        jPanel7.repaint();
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        bar(jLabel14);
        guiVisibility(jInternalFrame5);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        jPanel6.setOpaque(false);
        jPanel6.repaint();
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        jPanel6.setOpaque(true);
        jPanel6.repaint();
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        bar(jLabel11);
        guiVisibility(jInternalFrame4);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        jPanel5.setOpaque(false);
        jPanel5.repaint();
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        jPanel5.setOpaque(true);
        jPanel5.repaint();
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        bar(jLabel8);
        guiVisibility(jInternalFrame3);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        jPanel4.setOpaque(false);
        jPanel4.repaint();
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        jPanel4.setOpaque(true);
        jPanel4.repaint();
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        bar(jLabel5);
        guiVisibility(jInternalFrame2);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        jPanel3.setOpaque(false);
        jPanel3.repaint();
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        jPanel3.setOpaque(true);
        jPanel3.repaint();
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        bar(jLabel2);
        guiVisibility(jInternalFrame1);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (barcodeField.getText().isEmpty() || productNameField.getText().isEmpty() || brandField.getText().isEmpty() || sellField.getText().isEmpty() || mfdField.getDate() == null || expField.getDate() == null) {
            validate3.setText("Field(s) are Empty");
        } else {
            String pid = barcodeField.getText();
            String name = productNameField.getText();
            String brand = brandField.getText();
            String sell = sellField.getText();
            Date mfd = mfdField.getDate();
            Date exp = expField.getDate();
            boolean active = productIsActive.isSelected();

            String result = productModel.updateProduct(name, brand, sell, mfd, exp, pid, active);
            productModel.loadTable("", productTableModel);
            JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (barcodeField.getText().isEmpty() || productNameField.getText().isEmpty() || brandField.getText().isEmpty() || sellField.getText().isEmpty() || mfdField.getDate() == null || expField.getDate() == null) {
            validate3.setText("Field(s) are Empty");
        } else {
            String bcodeTest = "0";
            for (int i = 0; i < productTableModel.getRowCount(); i++) {
                if (barcodeField.getText().equals((String) productTableModel.getValueAt(i, 0))) {
                    bcodeTest = "1";
                    JOptionPane.showConfirmDialog(rootPane, "Barcode already exists", null, -1, 2);
                }
            }
            if (bcodeTest == "0") {
                //read fields
                String code = barcodeField.getText();
                String name = productNameField.getText();
                String brand = brandField.getText();
                String sell = sellField.getText();
                Date mfd = mfdField.getDate();
                Date exp = expField.getDate();
                boolean active = productIsActive.isSelected();

                String result = productModel.insertProduct(code, name, brand, sell, mfd, exp, active);
                if (result.equalsIgnoreCase("Success")) {
                    String result1 = productModel.insertStock(code);
                    JOptionPane.showConfirmDialog(rootPane, result1, "Stock", -1, 1);
                }
                productModel.loadTable("", productTableModel);
                barcodeField.setText("");
                productNameField.setText("");
                brandField.setText("");
                sellField.setText("");
                mfdField.setDate(null);
                expField.setDate(null);
                JOptionPane.showConfirmDialog(rootPane, result, "Product", -1, 1);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String keyword = keywordField1.getText();

        productModel.loadTable(keyword, productTableModel);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void DataTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable2MouseClicked
        int row = DataTable2.getSelectedRow();
        String barcode = (String) productTableModel.getValueAt(row, 0);
        String productData = productModel.getSelectedDataById(barcode);

        barcodeField.setText((String) productTableModel.getValueAt(row, 0));
        productNameField.setText((String) productTableModel.getValueAt(row, 1));
        brandField.setText(productData);
        sellField.setText((String) productTableModel.getValueAt(row, 3));
        try {
            mfdField.setDate(new SimpleDateFormat("yyyy-MM-dd").parse((String) productTableModel.getValueAt(row, 4)));
            expField.setDate(new SimpleDateFormat("yyyy-MM-dd").parse((String) productTableModel.getValueAt(row, 5)));
        } catch (ParseException ex) {
            Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        productIsActive.setSelected((boolean) productTableModel.getValueAt(row, 6));
    }//GEN-LAST:event_DataTable2MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        glassPaneVisible(jInternalFrame9);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if (brandNameField.getText().isEmpty()) {
            validate4.setText("Brand name field is empty");
        } else {
            //read fields
            String bname = brandNameField.getText();
            boolean activity = brandIsActive.isSelected();

            String result = productModel.insertBrand(bname, activity);
            productModel.loadBrandTable("", brandTableModel);
            JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        if (brandNameField.getText().isEmpty() || brandNameField.getText().isEmpty()) {
            validate4.setText("Field(s) are empty");
        } else {
            //read fields
            String bid = brandIdField.getText();
            String bname = brandNameField.getText();
            boolean activity = brandIsActive.isSelected();

            String result = productModel.updateBrand(bid, bname, activity);
            productModel.loadBrandTable("", brandTableModel);
            JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
            brandIdField.setText("");
            brandNameField.setText("");
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void DataTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable6MouseClicked
        int row = DataTable6.getSelectedRow();
        int bid = (int) brandTableModel.getValueAt(row, 0);
        String bname = (String) brandTableModel.getValueAt(row, 1);

        brandIdField.setText(String.valueOf(bid));
        brandNameField.setText((String) bname);
    }//GEN-LAST:event_DataTable6MouseClicked

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        //read fields
        String keyword = keywordField4.getText();
        //communicate with class
        productModel.loadBrandTable(keyword, brandTableModel);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        glassPaneNotVisible(jInternalFrame9);
    }//GEN-LAST:event_jLabel37MouseClicked

    private void brandFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brandFieldMouseClicked
        productModel.loadBrandTable("", brandTableModel2);
        glassPaneVisible(jInternalFrame8);
    }//GEN-LAST:event_brandFieldMouseClicked

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            new loginForm().setVisible(true);
            dispose();
        } else {
        }
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jPanel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseEntered
        jPanel20.setOpaque(true);
        jPanel20.repaint();
    }//GEN-LAST:event_jPanel20MouseEntered

    private void jPanel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseExited
        jPanel20.setOpaque(false);
        jPanel20.repaint();
    }//GEN-LAST:event_jPanel20MouseExited

    private void DataTable12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable12MouseClicked
        int row = DataTable12.getSelectedRow();

        companyField.setText(String.valueOf((int) companyTableModel.getValueAt(row, 0)));
        glassPaneNotVisible(jInternalFrame14);
    }//GEN-LAST:event_DataTable12MouseClicked

    private void jLabel66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel66MouseClicked
        glassPaneNotVisible(jInternalFrame14);
    }//GEN-LAST:event_jLabel66MouseClicked

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        if (companyNameField.getText().isEmpty() || companyAddress.getText().isEmpty()) {
            validate5.setText("Field(s) are Empty");
        } else {
            String bname = "0";
            for (int i = 0; i < companyTableModel2.getRowCount(); i++) {
                if (companyNameField.getText().equals((String) companyTableModel2.getValueAt(i, 1))) {
                    bname = "1";
                    JOptionPane.showConfirmDialog(rootPane, "Brand already listed", null, -1, 2);
                    companyIdField.setText("");
                    companyNameField.setText("");
                    companyAddress.setText("");
                }
            }
            if (bname == "0") {
                String cname = companyNameField.getText();
                String address = companyAddress.getText();
                boolean activity = companyIsActive.isSelected();

                String result = supplierModel.insertCompany(cname, address, activity);
                supplierModel.loadCompanyTable("", companyTableModel2);
                JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
            }
        }
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        if (companyIdField.getText().isEmpty() || companyNameField.getText().isEmpty() || companyAddress.getText().isEmpty()) {
            validate5.setText("Field(s) are Empty");
        } else {
            String cid = companyIdField.getText();
            String cname = companyNameField.getText();
            String address = companyAddress.getText();
            boolean activity = companyIsActive.isSelected();

            String result = supplierModel.updateCompany(cid, cname, address, activity);
            supplierModel.loadCompanyTable("", companyTableModel2);
            JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
        }
    }//GEN-LAST:event_jButton36ActionPerformed

    private void DataTable13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable13MouseClicked
        int row = DataTable13.getSelectedRow();
        int cid = (int) companyTableModel2.getValueAt(row, 0);
        String cname = (String) companyTableModel2.getValueAt(row, 1);
        String address = (String) companyTableModel2.getValueAt(row, 2);
        boolean activity = (boolean) companyTableModel2.getValueAt(row, 3);

        companyIdField.setText(String.valueOf(cid));
        companyNameField.setText((String) cname);
        companyAddress.setText((String) address);
        companyIsActive.setSelected(activity);
    }//GEN-LAST:event_DataTable13MouseClicked

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        String keyword = keywordField6.getText();
        supplierModel.loadCompanyTable(keyword, companyTableModel2);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jLabel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseClicked
        glassPaneNotVisible(jInternalFrame15);
    }//GEN-LAST:event_jLabel77MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (supplierMobField.getText().isEmpty() || supplierNameField.getText().isEmpty() || companyField.getText().isEmpty()) {
            validate6.setText("Field(s) are Empty");
        } else {
            String test = "0";
            for (int i = 0; i < supplierTableModel.getRowCount(); i++) {
                if (supplierMobField.getText().equals(String.valueOf((int) supplierTableModel.getValueAt(i, 0)))) {
                    test = "1";
                    JOptionPane.showConfirmDialog(rootPane, "Supplier already added", null, -1, 2);
                    supplierMobField.setText("");
                    supplierNameField.setText("");
                    companyField.setText("");
                    emailField.setText("");
                }
            }
            if (test == "0") {
                String mobile = supplierMobField.getText();
                String name = supplierNameField.getText();
                String company = companyField.getText();
                String email = emailField.getText();
                boolean activity = supplierIsActive.isSelected();

                String result = supplierModel.insertSupplier(mobile, name, company, email, activity);
                supplierModel.loadTable("", supplierTableModel);
                JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (supplierMobField.getText().isEmpty() || supplierNameField.getText().isEmpty() || companyField.getText().isEmpty()) {
            validate6.setText("Field(s) are Empty");
        } else {
            String mobile = supplierMobField.getText();
            String name = supplierNameField.getText();
            String company = companyField.getText();
            String email = emailField.getText();
            boolean isactive = supplierIsActive.isSelected();

            String result = supplierModel.updateSupplier(name, company, email, isactive, mobile);
            supplierModel.loadTable("", supplierTableModel);
            JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void companyFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyFieldMouseClicked
        supplierModel.loadCompanyTable("", companyTableModel);
        glassPaneVisible(jInternalFrame14);
    }//GEN-LAST:event_companyFieldMouseClicked

    private void DataTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable3MouseClicked
        int row = DataTable3.getSelectedRow();
        int smob = (int) supplierTableModel.getValueAt(row, 0);
        Object[] supplierData = supplierModel.getSelectedSupplierDataByMob(smob);

        supplierMobField.setText(new String(supplierData[0] + ""));
        supplierNameField.setText((String) supplierData[1]);
        companyField.setText(String.valueOf(supplierData[2]));
        emailField.setText((String) supplierData[3]);
        supplierIsActive.setSelected((boolean) supplierData[4]);
    }//GEN-LAST:event_DataTable3MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String keyword = keywordField2.getText();

        //communicate with class
        supplierModel.loadTable(keyword, supplierTableModel);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        glassPaneVisible(jInternalFrame15);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void DataTable14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable14MouseClicked
        int row = DataTable14.getSelectedRow();

        grnSupplierMob.setText(String.valueOf((int) supplierTableModel2.getValueAt(row, 0)));
        grnSupplierName.setText((String) supplierTableModel2.getValueAt(row, 1));
        glassPaneNotVisible(jInternalFrame16);
    }//GEN-LAST:event_DataTable14MouseClicked

    private void jLabel70MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel70MouseClicked
        glassPaneNotVisible(jInternalFrame16);
    }//GEN-LAST:event_jLabel70MouseClicked

    private void grnSupplierMobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnSupplierMobMouseClicked
        supplierModel.loadTable("", supplierTableModel2);
        glassPaneVisible(jInternalFrame16);
    }//GEN-LAST:event_grnSupplierMobMouseClicked

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        String keyword = customerKeywordField.getText();

        customerModel.loadTable(keyword, customerTableModel);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        guiVisibility(jInternalFrame17);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        guiVisibility(jInternalFrame13);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void grnIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnIdMouseClicked
        grnModel.loadTable("", grnTableModel3);
        glassPaneVisible(jInternalFrame18);
    }//GEN-LAST:event_grnIdMouseClicked

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        if (grnId.getText().isEmpty() || productId.getText().isEmpty() || grnQty.getText().isEmpty() || buyPrice.getText().isEmpty()) {
            validate8.setText("Field(s) are Empty");
        } else {
            String gid = grnId.getText();
            String pid = productId.getText();
            String qty = grnQty.getText();
            String buy = buyPrice.getText();

            //call userModel
            String result = grnModel.insertGrnItem(gid, pid, qty, buy);
            if (result.equalsIgnoreCase("Success")) {
                Double grnTotal = Double.parseDouble(qty) * Double.parseDouble(buy);
                String total = String.valueOf(grnTotal);
                String result1 = grnModel.updateGrn(gid, total);
                String result2 = grnModel.updateStock(pid, qty);
                grnModel.loadGrnItemTable("", grnTableModel2);
                JOptionPane.showConfirmDialog(rootPane, result1, "Grn", -1, 1);
                JOptionPane.showConfirmDialog(rootPane, result2, "Stock", -1, 1);

            }
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        String keyword = keywordField5.getText();
        int categoryId = searchCombo.getSelectedIndex();
        grnModel.searchGrnItemTable(keyword, categoryId, grnTableModel2);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void DataTable15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable15MouseClicked
        int row = DataTable15.getSelectedRow();
        grnId.setText(String.valueOf((int) grnTableModel3.getValueAt(row, 0)));

        glassPaneNotVisible(jInternalFrame18);
    }//GEN-LAST:event_DataTable15MouseClicked

    private void jLabel88MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel88MouseClicked
        glassPaneNotVisible(jInternalFrame18);
    }//GEN-LAST:event_jLabel88MouseClicked

    private void DataTable16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable16MouseClicked
        int row = DataTable16.getSelectedRow();
        productId.setText((String) productTableModel2.getValueAt(row, 0));

        glassPaneNotVisible(jInternalFrame19);
    }//GEN-LAST:event_DataTable16MouseClicked

    private void jLabel91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseClicked
        glassPaneNotVisible(jInternalFrame19);
    }//GEN-LAST:event_jLabel91MouseClicked

    private void productIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productIdMouseClicked
        productModel.loadTable("", productTableModel2);
        glassPaneVisible(jInternalFrame19);
    }//GEN-LAST:event_productIdMouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        Double custoPayment = Double.parseDouble(custoPay.getText());
        Double totalPayment = Double.parseDouble(totalField.getText());
        if (DataTable.getRowCount() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Items Not Found!", "Message", -1, 2);
            invBarcode.requestFocus();
        } else if (custoPayment < totalPayment) {
            JOptionPane.showConfirmDialog(rootPane, "Invalid Payment", "Message", -1, 2);
            custoPay.requestFocus();
        } else {
            String custa = custaMob.getText();
            String total = totalField.getText();
            int id = invoiceModel.insertInvoice(custa, total);
            String msg = "";
            for (int i = 0; i < invoiceTableModel.getRowCount(); i++) {
                String bcode = (String) invoiceTableModel.getValueAt(i, 0);
                String qty = (String) invoiceTableModel.getValueAt(i, 2);
                String disc = (String) invoiceTableModel.getValueAt(i, 4);
                msg = invoiceModel.insertInvoiceItems(bcode, qty, disc);
                String result1 = invoiceModel.updateStock(bcode, qty);
            }

            String cusPayment = "0.0";
            if (custoPay.getText().contains(".")) {
                cusPayment = custoPay.getText();
            } else {
                String cuspay = custoPay.getText();
                custoPay.setText(cuspay + ".0");
                cusPayment = custoPay.getText();
            }
            String balance = balanceField.getText();
            String mobile = custaMob.getText();
            String name = custaName.getText();

            String reportPath = "D:\\Jasper\\MyReports\\medcure.jrxml";
            //parameters
            Map m = new HashMap();
            m.put("invoice_id", id);
            if (mobile.isEmpty() && name.isEmpty()) {
                m.put("Name", "Guest");
                m.put("Mobile", "--");
            } else {
                m.put("Name", name);
                m.put("Mobile", mobile);
            }
            m.put("customer_payment", cusPayment);
            m.put("balance", balance);
            //datasource
            invoice newinv = new invoice();
            try {
                JasperReport jr = JasperCompileManager.compileReport(reportPath);
                JasperPrint jp = JasperFillManager.fillReport(jr, m, db.dbConnection.getConnection());
                newinv.jTabbedPane1.add(new JRViewer(jp));
                newinv.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

            invoiceTableModel.setRowCount(0);
            totalField.setText("0.0");
            custoPay.setText("0.0");
            balanceField.setText("0.0");

            invBarcode.requestFocus();
        }

    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if (DataTable.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showConfirmDialog(rootPane, "Please select a row", null, -1, 2);
        } else {
            int row = DataTable.getSelectedRow();
            Double subTotal = (Double) invoiceTableModel.getValueAt(row, 5);
            String mainTotal = totalField.getText();
            Double intTotal = Double.parseDouble(mainTotal) - subTotal;
            totalField.setText(String.valueOf(intTotal));
            invoiceTableModel.removeRow(row);
            JOptionPane.showConfirmDialog(rootPane, "Product Removed", null, -1, 1);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void custaMobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custaMobMouseClicked
        customerModel.loadTable("", customerTableModel2);
        glassPaneVisible(jInternalFrame20);
    }//GEN-LAST:event_custaMobMouseClicked

    private void DataTable10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable10MouseClicked
        int row = DataTable10.getSelectedRow();
        int custoMob = (int) customerTableModel.getValueAt(row, 0);
        String custoName = (String) customerTableModel.getValueAt(row, 1);

        custaMob.setText(String.valueOf(custoMob));
        custaName.setText(custoName);

        glassPaneNotVisible(jInternalFrame20);
    }//GEN-LAST:event_DataTable10MouseClicked

    private void invBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invBarcodeKeyReleased
        String bcode = invBarcode.getText();

        Object[] productData = invoiceModel.getSelectedData(bcode);
        if (productData == null) {
        } else {
            invProduct.setText((String) productData[0]);
            invQty.setText("1");
            invDisc.setText("0");
            invQty.requestFocus();
        }

        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            invBarcode.setText("");
            custoPay.requestFocus();
        }
    }//GEN-LAST:event_invBarcodeKeyReleased

    private void invQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invQtyActionPerformed
        invDisc.requestFocus();
    }//GEN-LAST:event_invQtyActionPerformed

    private void invDiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invDiscActionPerformed
        addButton.requestFocus();
    }//GEN-LAST:event_invDiscActionPerformed

    private void custoPayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custoPayKeyReleased
        if (!custoPay.getText().isEmpty()) {
            Double total = Double.parseDouble(totalField.getText());
            Double custoPayment = Double.parseDouble(custoPay.getText());
            if (custoPayment >= total) {
                Double balance = custoPayment - total;
                balanceField.setText(balance.toString());
            } else {
                balanceField.setText("0.0");
            }
        } else {
            balanceField.setText("0.0");
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton17.requestFocus();
        }
    }//GEN-LAST:event_custoPayKeyReleased

    private void custoPayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_custoPayFocusGained
        if (custoPay.getText().equals("0.0")) {
            custoPay.setText("");
        }
    }//GEN-LAST:event_custoPayFocusGained

    private void custoPayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_custoPayFocusLost
        if (custoPay.getText().equals("")) {
            custoPay.setText("0.0");
        }
    }//GEN-LAST:event_custoPayFocusLost

    private void DataTable17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable17MouseClicked
        int row = DataTable17.getSelectedRow();

        pharmacistId.setText(String.valueOf((int) pharmacistTableModel.getValueAt(row, 0)));
        pharmacistName.setText((String) pharmacistTableModel.getValueAt(row, 1));
        pharmacistMob.setText(String.valueOf((int) pharmacistTableModel.getValueAt(row, 2)));
        pharmacistAddress.setText((String) pharmacistTableModel.getValueAt(row, 3));
        jComboBox1.setSelectedItem((String) pharmacistTableModel.getValueAt(row, 4));
        isActive.setSelected((boolean) pharmacistTableModel.getValueAt(row, 5));
    }//GEN-LAST:event_DataTable17MouseClicked

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        String keyword = pharmacistKeywordField.getText();

        pharmacistModel.loadTable(keyword, pharmacistTableModel);
    }//GEN-LAST:event_jButton41ActionPerformed

    private void pharmacistAddressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pharmacistAddressMouseClicked

    }//GEN-LAST:event_pharmacistAddressMouseClicked

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        if (pharmacistName.getText().isEmpty() || pharmacistMob.getText().isEmpty() || pharmacistAddress.getText().isEmpty()) {
            validate2.setText("Field(s) are Empty");
        } else {
            //read fields
            String name = pharmacistName.getText();
            String mobile = pharmacistMob.getText();
            String address = pharmacistAddress.getText();
            String experience = (String) jComboBox1.getSelectedItem();
            boolean isactive = isActive.isSelected();
            //call userModel
            String result = pharmacistModel.insertPharmacist(name, mobile, address, experience, isactive);
            pharmacistModel.loadTable("", pharmacistTableModel);
            JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
        }
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        //validate fields
        if (pharmacistId.getText().isEmpty() || pharmacistName.getText().isEmpty() || pharmacistMob.getText().isEmpty() || pharmacistAddress.getText().isEmpty()) {
            validate2.setText("Field(s) are Empty");
        } else {
            String id = pharmacistId.getText();
            String name = pharmacistName.getText();
            String mobile = pharmacistMob.getText();
            String address = pharmacistAddress.getText();
            String experience = (String) jComboBox1.getSelectedItem();
            boolean isactive = isActive.isSelected();
            //call userModel
            String result = pharmacistModel.updatePharmacist(id, name, mobile, address, experience, isactive);

            pharmacistModel.loadTable("", pharmacistTableModel);
            JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
        }
    }//GEN-LAST:event_jButton43ActionPerformed

    private void pharmacistNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pharmacistNameMouseClicked

    }//GEN-LAST:event_pharmacistNameMouseClicked

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        barcodeField.setText("");
        productNameField.setText("");
        brandField.setText("");
        sellField.setText("");
        mfdField.setDate(null);
        expField.setDate(null);
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        guiVisibility(jInternalFrame23);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        guiVisibility(jInternalFrame24);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        guiVisibility(jInternalFrame7);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        guiVisibility(jInternalFrame22);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        pharmacistModel.loadComboBox(comboBoxModel);
        guiVisibility(jInternalFrame21);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (invBarcode.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(rootPane, "Barcode not found", null, -1, 2);
            invBarcode.requestFocus();
        } else if (invQty.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(rootPane, "Please set a quantity", null, -1, 2);
            invQty.requestFocus();
        } else {
            String barcodee = invBarcode.getText();
            String inqtyy = invQty.getText();

            String result = invoiceModel.checkqty(barcodee, inqtyy);
            if (result.startsWith("Not Avalable qty")) {
                JOptionPane.showConfirmDialog(rootPane, "Out of Stock", "Warning", -1, 2);
            } else {
                String bcodeTest = "0";
                for (int i = 0; i < invoiceTableModel.getRowCount(); i++) {
                    if (invBarcode.getText().equals((String) invoiceTableModel.getValueAt(i, 0))) {
                        bcodeTest = "1";
                        JOptionPane.showConfirmDialog(rootPane, "Product already added, please update the quantity", null, -1, 2);
                        invBarcode.setText("");
                        invProduct.setText("");
                        invQty.setText("");
                        invDisc.setText("");
                    }
                }
                if (bcodeTest == "0") {
                    if (invDisc.getText().isEmpty()) {
                        invDisc.setText("0");
                    }
                    String bcode = invBarcode.getText();
                    String product = invProduct.getText();
                    String qty = invQty.getText();
                    String disc = invDisc.getText();

                    Object[] productData = invoiceModel.getSelectedData(bcode);

                    Double sum = Double.parseDouble(qty) * (Double) productData[1];

                    Double subPrice = sum * (100 - Double.parseDouble(disc)) / 100;

                    Object[] rowData = new Object[]{bcode, product, qty, productData[1], disc, subPrice};
                    invoiceTableModel.addRow(rowData);

                    invBarcode.setText("");
                    invProduct.setText("");
                    invQty.setText("");
                    invDisc.setText("");

                    invBarcode.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void DataTable19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable19MouseClicked
        jInternalFrame25.setVisible(true);

        int row = DataTable19.getSelectedRow();
        int invId = (int) invoiceTableModel2.getValueAt(row, 0);
        invoiceModel.getSelectedDataById(invId, invoiceTableModel3);
    }//GEN-LAST:event_DataTable19MouseClicked

    private void jLabel97MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel97MouseClicked
        jInternalFrame25.setVisible(false);
    }//GEN-LAST:event_jLabel97MouseClicked

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showConfirmDialog(rootPane, "Please set a date", "Message", -1, 2);
        } else {
            Date dt = jDateChooser1.getDate();
            dt = new java.sql.Date(dt.getTime());
            invoiceModel.loadTable(dt, invoiceTableModel2);
        }
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        String keyword = invViewId.getText();

        invoiceModel.loadTable(keyword, invoiceTableModel2);
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        String keyword = stockProductField.getText();

        invoiceModel.loadStockTable(keyword, stockTableModel);
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jLabel94MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel94MouseClicked

    private void jLabel95MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel95MouseClicked

    private void brandFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandFieldActionPerformed
        productModel.loadBrandTable("", brandTableModel2);
        glassPaneVisible(jInternalFrame8);
    }//GEN-LAST:event_brandFieldActionPerformed

    private void jLabel98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel98MouseClicked

    private void jLabel96MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel96MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel96MouseClicked

    private void jLabel99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel99MouseClicked

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        pharmacistModel.loadTable("", pharmacistTableModel1);
        guiVisibility(jInternalFrame26);
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        pharmacistModel.loadTable("", pharmacistTableModel2);
        guiVisibility(jInternalFrame27);
    }//GEN-LAST:event_jButton49ActionPerformed

    private void DataTable24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable24MouseClicked
        int row = DataTable24.getSelectedRow();

        pharmacistId3.setText(String.valueOf((int) attendanceTableModel.getValueAt(row, 0)));
        pharmacistName3.setText((String) attendanceTableModel.getValueAt(row, 1));
    }//GEN-LAST:event_DataTable24MouseClicked

    private void timeFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeFieldMouseClicked

    }//GEN-LAST:event_timeFieldMouseClicked

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        if (pharmacistId3.getText().isEmpty()) {
            validate11.setText("Field(s) are Empty");
        } else {
            String attendance = "0";
            for (int i = 0; i < attendanceTableModel.getRowCount(); i++) {
                String pid = String.valueOf((int) attendanceTableModel.getValueAt(i, 0));
                if (pharmacistId3.getText().equals(pid)) {
                    attendance = "1";
                    JOptionPane.showConfirmDialog(rootPane, "Attendance already marked", null, -1, 2);
                }
            }
            if (attendance == "0") {
                //read fields
                String id = pharmacistId3.getText();
                //call userModel
                String result = attendanceModel.insertAttendance(id);
                attendanceModel.loadTable("", attendanceTableModel);
                JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
            }
        }
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        //validate fields
        if (pharmacistId3.getText().isEmpty()) {
            validate11.setText("Field(s) are Empty");
        } else {
            validate11.setText("");
            String id = pharmacistId3.getText();
            Date dt = (Date) attendanceTableModel.getValueAt(0, 3);
            //call userModel
            String result = attendanceModel.updateAttendance(id, dt);

            attendanceModel.loadTable("", attendanceTableModel);
            JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
        }
    }//GEN-LAST:event_jButton58ActionPerformed

    private void pharmacistName3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pharmacistName3MouseClicked

    }//GEN-LAST:event_pharmacistName3MouseClicked

    private void pharmacistId3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pharmacistId3MouseClicked
        pharmacistModel.loadTable("", pharmacistTableModel1);
        glassPaneVisible(jInternalFrame28);
    }//GEN-LAST:event_pharmacistId3MouseClicked

    private void DataTable22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable22MouseClicked
        int row = DataTable22.getSelectedRow();
        int pId = (int) pharmacistTableModel1.getValueAt(row, 0);
        String pname = (String) pharmacistTableModel1.getValueAt(row, 1);
        pharmacistId3.setText(String.valueOf(pId));
        pharmacistName3.setText(pname);
        glassPaneNotVisible(jInternalFrame28);
    }//GEN-LAST:event_DataTable22MouseClicked

    private void jLabel103MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel103MouseClicked
        glassPaneNotVisible(jInternalFrame28);
    }//GEN-LAST:event_jLabel103MouseClicked

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        String keyword = pharmacistNameKeyword.getText();

        salaryModel.loadTable(keyword, salaryTableModel);
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        if (pharmacistId4.getText().isEmpty()) {
            validate12.setText("Field(s) are Empty");
        } else if (totalSalary.getText().equalsIgnoreCase("0.0")) {
            JOptionPane.showConfirmDialog(rootPane, "Invalid total salary amount", "Message", -1, 2);
        } else {
            String pId = pharmacistId4.getText();
            int month = ((Integer) jMonthChooser1.getMonth()).intValue() + 1;
            String strMonth = new DateFormatSymbols().getMonths()[month - 1];
            int year = Year.now().getValue();
            String totSalary = totalSalary.getText();

            String result = salaryModel.insertPharmacistPayment(pId, month, totSalary);
            salaryModel.loadTable("", salaryTableModel);
            if (result.contains("Success")) {
                JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
            } else if (result.contains("Error")) {
                JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 0);
            } else {
                JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 2);
            }

            String reportPath = "D:\\Jasper\\MyReports\\medcurePaysheet.jrxml";
            //parameters
            Map m = new HashMap();
            m.put("pharmacist_id", pId);
            m.put("month", strMonth);
            m.put("year", year);
            //datasource
            invoice newinv = new invoice();
            try {
                JasperReport jr = JasperCompileManager.compileReport(reportPath);
                JasperPrint jp = JasperFillManager.fillReport(jr, m, db.dbConnection.getConnection());
                newinv.jTabbedPane1.add(new JRViewer(jp));
                newinv.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton60ActionPerformed

    private void pharmacistId4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pharmacistId4MouseClicked
        glassPaneVisible(jInternalFrame29);
    }//GEN-LAST:event_pharmacistId4MouseClicked

    private void jPanel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel43MouseClicked
        bar(jLabel104);
        new pharmacistAccount(this, true).setVisible(true);
    }//GEN-LAST:event_jPanel43MouseClicked

    private void jPanel43MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel43MouseEntered
        jPanel43.setOpaque(true);
        jPanel43.repaint();
    }//GEN-LAST:event_jPanel43MouseEntered

    private void jPanel43MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel43MouseExited
        jPanel43.setOpaque(false);
        jPanel43.repaint();
    }//GEN-LAST:event_jPanel43MouseExited

    private void DataTable23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable23MouseClicked
        int row = DataTable23.getSelectedRow();
        int pId = (int) pharmacistTableModel2.getValueAt(row, 0);
        String pname = (String) pharmacistTableModel2.getValueAt(row, 1);
        pharmacistId4.setText(String.valueOf(pId));
        pharmacistName4.setText(pname);
        glassPaneNotVisible(jInternalFrame29);

        int month = ((Integer) jMonthChooser1.getMonth()).intValue() + 1;
        double result = salaryModel.getAttendanceForSalary(pId, month);
        totalSalary.setText(String.valueOf(result));
    }//GEN-LAST:event_DataTable23MouseClicked

    private void jLabel109MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel109MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel109MouseClicked

    private void jLabel115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel115MouseClicked
        glassPaneNotVisible(jInternalFrame29);
    }//GEN-LAST:event_jLabel115MouseClicked

    private void jMonthChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jMonthChooser1PropertyChange
        if (!pharmacistId4.getText().isEmpty()) {
            int pId = Integer.parseInt(pharmacistId4.getText());
            int month = ((Integer) jMonthChooser1.getMonth()).intValue() + 1;
            double result = salaryModel.getAttendanceForSalary(pId, month);
            totalSalary.setText(String.valueOf(result));
        }
    }//GEN-LAST:event_jMonthChooser1PropertyChange

    private void pharmacistId4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pharmacistId4KeyReleased
        if (pharmacistId4.getText().isEmpty()) {
            pharmacistName4.setText("");
            totalSalary.setText("");
        }
    }//GEN-LAST:event_pharmacistId4KeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new about(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        glassPane.setVisible(true);
        new salaries(this, true).setVisible(true);
        glassPane.setVisible(false);
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        guiVisibility(jInternalFrame17);
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Support(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame1);
        }
    }//GEN-LAST:event_jPanel10MousePressed

    private void jPanel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame1);
        }
    }//GEN-LAST:event_jPanel10MouseReleased

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel102MouseClicked

    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        glassPaneNotVisible(jInternalFrame20);
    }//GEN-LAST:event_jLabel61MouseClicked

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        guiVisibility(jInternalFrame30);
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame2);
        }
    }//GEN-LAST:event_jPanel11MousePressed

    private void jPanel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame2);
        }
    }//GEN-LAST:event_jPanel11MouseReleased

    private void jPanel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame3);
        }
    }//GEN-LAST:event_jPanel13MousePressed

    private void jPanel13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame3);
        }
    }//GEN-LAST:event_jPanel13MouseReleased

    private void jPanel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame4);
        }
    }//GEN-LAST:event_jPanel14MousePressed

    private void jPanel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame4);
        }
    }//GEN-LAST:event_jPanel14MouseReleased

    private void jPanel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame13);
        }
    }//GEN-LAST:event_jPanel15MousePressed

    private void jPanel15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame13);
        }
    }//GEN-LAST:event_jPanel15MouseReleased

    private void jPanel32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame17);
        }
    }//GEN-LAST:event_jPanel32MousePressed

    private void jPanel32MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel32MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame17);
        }
    }//GEN-LAST:event_jPanel32MouseReleased

    private void jPanel38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame22);
        }
    }//GEN-LAST:event_jPanel38MousePressed

    private void jPanel38MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel38MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame22);
        }
    }//GEN-LAST:event_jPanel38MouseReleased

    private void jPanel40MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel40MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame23);
        }
    }//GEN-LAST:event_jPanel40MousePressed

    private void jPanel40MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel40MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame23);
        }
    }//GEN-LAST:event_jPanel40MouseReleased

    private void jPanel41MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel41MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame24);
        }
    }//GEN-LAST:event_jPanel41MousePressed

    private void jPanel41MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel41MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame24);
        }
    }//GEN-LAST:event_jPanel41MouseReleased

    private void jPanel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame21);
        }
    }//GEN-LAST:event_jPanel16MousePressed

    private void jPanel16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame21);
        }
    }//GEN-LAST:event_jPanel16MouseReleased

    private void jPanel49MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel49MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame26);
        }
    }//GEN-LAST:event_jPanel49MousePressed

    private void jPanel49MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel49MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame26);
        }
    }//GEN-LAST:event_jPanel49MouseReleased

    private void jPanel52MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel52MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame27);
        }
    }//GEN-LAST:event_jPanel52MousePressed

    private void jPanel52MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel52MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame27);
        }
    }//GEN-LAST:event_jPanel52MouseReleased

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if (jintf == jInternalFrame1) {
            guiVisibility(jInternalFrame2);
            bar(jLabel5);
        } else if (jintf == jInternalFrame2) {
            guiVisibility(jInternalFrame3);
            bar(jLabel8);
        } else if (jintf == jInternalFrame3) {
            guiVisibility(jInternalFrame4);
            bar(jLabel11);
        } else if (jintf == jInternalFrame4) {
            guiVisibility(jInternalFrame5);
            bar(jLabel14);
        } else if (jintf == jInternalFrame13) {
            guiVisibility(jInternalFrame17);
        } else if (jintf == jInternalFrame17) {
            guiVisibility(jInternalFrame5);
        } else if (jintf == jInternalFrame22) {
            guiVisibility(jInternalFrame23);
        } else if (jintf == jInternalFrame23) {
            guiVisibility(jInternalFrame24);
        } else if (jintf == jInternalFrame24) {
            guiVisibility(jInternalFrame21);
        } else if (jintf == jInternalFrame21) {
            guiVisibility(jInternalFrame26);
        } else if (jintf == jInternalFrame26) {
            guiVisibility(jInternalFrame27);
        } else if (jintf == jInternalFrame27) {
            guiVisibility(jInternalFrame30);
        } else if (jintf == jInternalFrame30) {
            guiVisibility(jInternalFrame7);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        String month = null;
        if (jMonthChooser2.getMonth() == 0) {
            month = "1";
            String query = "select SUM(payment) from grn where MONTH(date_n_time) ='" + month + "'";
            double paymentplus = 00;
            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String payment = "0.00";
                while (rs.next()) {
                    payment = String.valueOf(rs.getDouble("SUM(payment)"));
                }
                totallabe1.setText(payment);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String queryy = "select SUM(total) from invoice where MONTH(date_n_time) ='" + month + "'";

            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryy);
                String paymentt = "0.00";
                while (rs.next()) {
                    paymentt = String.valueOf(rs.getString("SUM(total)"));
                }
                totallabe2.setText(paymentt);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jMonthChooser2.getMonth() == 1) {
            month = "2";
            String query = "select SUM(payment) from grn where MONTH(date_n_time) ='" + month + "'";
            double paymentplus = 00;
            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String payment = "0.00";
                while (rs.next()) {
                    payment = String.valueOf(rs.getDouble("SUM(payment)"));
                }
                totallabe1.setText(payment);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String queryy = "select SUM(total) from invoice where MONTH(date_n_time) ='" + month + "'";

            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryy);
                String paymentt = "0.00";
                while (rs.next()) {
                    paymentt = String.valueOf(rs.getString("SUM(total)"));
                }
                totallabe2.setText(paymentt);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jMonthChooser2.getMonth() == 2) {
            month = "3";
            String query = "select SUM(payment) from grn where MONTH(date_n_time) ='" + month + "'";
            double paymentplus = 00;
            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String payment = "0.00";
                while (rs.next()) {
                    payment = String.valueOf(rs.getDouble("SUM(payment)"));
                }
                totallabe1.setText(payment);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String queryy = "select SUM(total) from invoice where MONTH(date_n_time) ='" + month + "'";

            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryy);
                String paymentt = "0.00";
                while (rs.next()) {
                    paymentt = String.valueOf(rs.getString("SUM(total)"));
                }
                totallabe2.setText(paymentt);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jMonthChooser2.getMonth() == 4) {
            month = "5";
            
             String query = "select SUM(payment) from grn where MONTH(date_n_time) ='" + month + "'";
            double paymentplus = 00;
            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String payment = "0.00";
                while (rs.next()) {
                    payment = String.valueOf(rs.getDouble("SUM(payment)"));
                }
                totallabe1.setText(payment);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String queryy = "select SUM(total) from invoice where MONTH(date_n_time) ='" + month + "'";

            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryy);
                String paymentt = "0.00";
                while (rs.next()) {
                    paymentt = String.valueOf(rs.getString("SUM(total)"));
                }
                totallabe2.setText(paymentt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (jMonthChooser2.getMonth() == 5) {
            month = "6";
            String query = "select SUM(payment) from grn where MONTH(date_n_time) ='" + month + "'";
            double paymentplus = 00;
            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String payment = "0.00";
                while (rs.next()) {
                    payment = String.valueOf(rs.getDouble("SUM(payment)"));
                }
                totallabe1.setText(payment);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String queryy = "select SUM(total) from invoice where MONTH(date_n_time) ='" + month + "'";

            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryy);
                String paymentt = "0.00";
                while (rs.next()) {
                    paymentt = String.valueOf(rs.getString("SUM(total)"));
                }
                totallabe2.setText(paymentt);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jMonthChooser2.getMonth() == 6) {
            month = "7";
            String query = "select SUM(payment) from grn where MONTH(date_n_time) ='" + month + "'";
            double paymentplus = 00;
            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String payment = "0.00";
                while (rs.next()) {
                    payment = String.valueOf(rs.getDouble("SUM(payment)"));
                }
                totallabe1.setText(payment);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String queryy = "select SUM(total) from invoice where MONTH(date_n_time) ='" + month + "'";

            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryy);
                String paymentt = "0.00";
                while (rs.next()) {
                    paymentt = String.valueOf(rs.getString("SUM(total)"));
                }
                totallabe2.setText(paymentt);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jMonthChooser2.getMonth() == 7) {
            month = "8";
            String query = "select SUM(payment) from grn where MONTH(date_n_time) ='" + month + "'";
            double paymentplus = 00;
            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String payment = "0.00";
                while (rs.next()) {
                    payment = String.valueOf(rs.getDouble("SUM(payment)"));
                }
                totallabe1.setText(payment);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String queryy = "select SUM(total) from invoice where MONTH(date_n_time) ='" + month + "'";

            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryy);
                String paymentt = "0.00";
                while (rs.next()) {
                    paymentt = String.valueOf(rs.getString("SUM(total)"));
                }
                totallabe2.setText(paymentt);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jMonthChooser2.getMonth() == 8) {
            month = "9";
            String query = "select SUM(payment) from grn where MONTH(date_n_time) ='" + month + "'";
            double paymentplus = 00;
            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String payment = "0.00";
                while (rs.next()) {
                    payment = String.valueOf(rs.getDouble("SUM(payment)"));
                }
                totallabe1.setText(payment);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String queryy = "select SUM(total) from invoice where MONTH(date_n_time) ='" + month + "'";

            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryy);
                String paymentt = "0.00";
                while (rs.next()) {
                    paymentt = String.valueOf(rs.getString("SUM(total)"));
                }
                totallabe2.setText(paymentt);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jMonthChooser2.getMonth() == 9) {
            month = "10";
            String query = "select SUM(payment) from grn where MONTH(date_n_time) ='" + month + "'";
            double paymentplus = 00;
            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String payment = "0.00";
                while (rs.next()) {
                    payment = String.valueOf(rs.getDouble("SUM(payment)"));
                }
                totallabe1.setText(payment);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String queryy = "select SUM(total) from invoice where MONTH(date_n_time) ='" + month + "'";

            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryy);
                String paymentt = "0.00";
                while (rs.next()) {
                    paymentt = String.valueOf(rs.getString("SUM(total)"));
                }
                totallabe2.setText(paymentt);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jMonthChooser2.getMonth() == 10) {
            month = "11";
            String query = "select SUM(payment) from grn where MONTH(date_n_time) ='" + month + "'";
            double paymentplus = 00;
            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String payment = "0.00";
                while (rs.next()) {
                    payment = String.valueOf(rs.getDouble("SUM(payment)"));
                }
                totallabe1.setText(payment);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String queryy = "select SUM(total) from invoice where MONTH(date_n_time) ='" + month + "'";

            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryy);
                String paymentt = "0.00";
                while (rs.next()) {
                    paymentt = String.valueOf(rs.getString("SUM(total)"));
                }
                totallabe2.setText(paymentt);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (jMonthChooser2.getMonth() == 11) {
            month = "12";
            String query = "select SUM(payment) from grn where MONTH(date_n_time) ='" + month + "'";
            double paymentplus = 00;
            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                String payment = "0.00";
                while (rs.next()) {
                    payment = String.valueOf(rs.getDouble("SUM(payment)"));
                }
                totallabe1.setText(payment);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String queryy = "select SUM(total) from invoice where MONTH(date_n_time) ='" + month + "'";

            try {
                Connection conn = db.dbConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryy);
                String paymentt = "";
                while (rs.next()) {
                    paymentt = String.valueOf(rs.getString("SUM(total)"));
                }
                totallabe2.setText(paymentt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        if(lecobill.getText().isEmpty()){
            JOptionPane.showConfirmDialog(rootPane, "Electricity Bill Field is Empty");
        }else{
        String grn = totallabe1.getText();
        double grncast = Double.valueOf(grn);
        String inv = totallabe2.getText();
        double invcast = Double.valueOf(inv);
        String leco = lecobill.getText();
        double lecocast = Double.valueOf(leco);

        double total1 = invcast - grncast;
        double total3 = invcast - lecocast;
        double total4 = total1 + total3;
        String casttotal4 = String.valueOf(total4);
        totalAmount.setText(casttotal4);
        
        invoiceModel.insertprofit(grn,inv,leco,casttotal4);
        }
    }//GEN-LAST:event_jButton63ActionPerformed

    private void lecobillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lecobillMouseClicked

    }//GEN-LAST:event_lecobillMouseClicked

    private void jPanel55MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel55MousePressed
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame30);
        }
    }//GEN-LAST:event_jPanel55MousePressed

    private void jPanel55MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel55MouseReleased
        if (evt.isPopupTrigger()) {
            showPopUp(evt, jInternalFrame30);
        }
    }//GEN-LAST:event_jPanel55MouseReleased

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (jintf == jInternalFrame2) {
            guiVisibility(jInternalFrame1);
            bar(jLabel2);
        } else if (jintf == jInternalFrame3) {
            guiVisibility(jInternalFrame2);
            bar(jLabel5);
        } else if (jintf == jInternalFrame4) {
            guiVisibility(jInternalFrame3);
            bar(jLabel8);
        } else if (jintf == jInternalFrame5) {
            guiVisibility(jInternalFrame4);
            bar(jLabel11);
        } else if (jintf == jInternalFrame17) {
            guiVisibility(jInternalFrame13);
            bar(jLabel14);
        } else if (jintf == jInternalFrame5) {
            guiVisibility(jInternalFrame17);
        } else if (jintf == jInternalFrame22 || jintf == jInternalFrame23 || jintf == jInternalFrame24 || jintf == jInternalFrame21 || jintf == jInternalFrame26 || jintf == jInternalFrame27 || jintf == jInternalFrame30) {
            guiVisibility(jInternalFrame6);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://www.medcureslk.com/"));
        } catch (IOException ex) {
            Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            new loginForm().setVisible(true);
            dispose();
        } else {
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        customerModel.loadDeletedTable("", customerTableModel3);
        glassPaneVisible(jInternalFrame32);
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        if (DataTable28.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showConfirmDialog(rootPane, "Please select a row from the table", "Message", -1, 2);
        } else {
            int row = DataTable28.getSelectedRow();
            int customerMob = (int) customerTableModel3.getValueAt(row, 0);
            String custoMob = String.valueOf(customerMob);
            //call userModel
            String result = customerModel.restoreUser(custoMob);

            customerModel.loadDeletedTable("", customerTableModel3);
            customerModel.loadTable("", customerTableModel);
            JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
        }
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        String keyword = cusMobkeyword.getText();

        customerModel.loadDeletedTable(keyword, customerTableModel3);
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jLabel131MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel131MouseClicked
        customerModel.loadTable("", customerTableModel);
        glassPaneNotVisible(jInternalFrame32);
    }//GEN-LAST:event_jLabel131MouseClicked

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        int month = ((Integer) salesMonth.getMonth()).intValue() + 1;

        invoiceModel.loadSalesTable1(month, salesTableModel);
        double Stotal = 0.0;
        for (int i = 0; i < salesTableModel.getRowCount(); i++) {
            double saleTotal = (double) salesTableModel.getValueAt(i, 2);
            Stotal = Stotal + saleTotal;
        }
        salesTotal.setText(String.valueOf(Stotal));
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        if (dateOnly.getDate() == null) {
            JOptionPane.showConfirmDialog(rootPane, "Please set a date", "Message", -1, 2);
        } else {
            Date dt = dateOnly.getDate();
            invoiceModel.loadSalesTable3(dt, salesTableModel);

            double Stotal = 0.0;
            for (int i = 0; i < salesTableModel.getRowCount(); i++) {
                double saleTotal = (double) salesTableModel.getValueAt(i, 2);
                Stotal = Stotal + saleTotal;
            }
            salesTotal.setText(String.valueOf(Stotal));
        }
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        if (date1.getDate() == null && date2.getDate() == null) {
            JOptionPane.showConfirmDialog(rootPane, "Date fields are empty", "Message", -1, 2);
        } else {
            Date dt1 = date1.getDate();
            Date dt2 = date2.getDate();

            invoiceModel.loadSalesTable2(dt1, dt2, salesTableModel);

            double Stotal = 0.0;
            for (int i = 0; i < salesTableModel.getRowCount(); i++) {
                double saleTotal = (double) salesTableModel.getValueAt(i, 2);
                Stotal = Stotal + saleTotal;
            }
            salesTotal.setText(String.valueOf(Stotal));
        }
    }//GEN-LAST:event_jButton55ActionPerformed

    private void salesMonthPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_salesMonthPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_salesMonthPropertyChange

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        productModel.loadExpiredProducts("", productTableModel3);
        glassPaneVisible(jInternalFrame33);
        productModel.loadTable("", productTableModel);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jLabel133MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel133MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel133MouseClicked

    private void jLabel134MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel134MouseClicked
        glassPaneNotVisible(jInternalFrame33);
    }//GEN-LAST:event_jLabel134MouseClicked

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        productTableModel3.setRowCount(0);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        bar(jLabel2);
        guiVisibility(jInternalFrame1);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        String keyword = search1.getText();
        customerModel.loadTable(keyword, customerTableModel);
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        String keyword = search2.getText();
        productModel.loadBrandTable(keyword, brandTableModel2);
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66ActionPerformed
        String keyword = search3.getText();
        productModel.loadBrandTable(keyword, brandTableModel2);
    }//GEN-LAST:event_jButton66ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        String keyword = search4.getText();
        supplierModel.loadTable(keyword, supplierTableModel2);
    }//GEN-LAST:event_jButton67ActionPerformed

    private void jButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68ActionPerformed
        String keyword = search5.getText();
        grnModel.loadTable(keyword, grnTableModel3);
    }//GEN-LAST:event_jButton68ActionPerformed

    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed
        String keyword = search6.getText();
        productModel.loadTable(keyword, productTableModel2);
    }//GEN-LAST:event_jButton69ActionPerformed

    private void jButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70ActionPerformed
        String keyword = search7.getText();
        pharmacistModel.loadTable(keyword, pharmacistTableModel1);
    }//GEN-LAST:event_jButton70ActionPerformed

    private void jButton71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton71ActionPerformed
        String keyword = search8.getText(); 
        pharmacistModel.loadTable(keyword, pharmacistTableModel2);
    }//GEN-LAST:event_jButton71ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (jintf == jInternalFrame1) {
            invBarcode.setText("");
            invProduct.setText("");
            invQty.setText("");
            invDisc.setText("");
            custaMob.setText("");
            custaName.setText("");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        if (DataTable11.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showConfirmDialog(rootPane, "Please select a row from the table", "Message", -1, 2);
        } else {
            int row = DataTable11.getSelectedRow();
            int gid = (int) grnTableModel2.getValueAt(row, 1);
            String reportPath = "D:\\Jasper\\MyReports\\medcureGrn.jrxml";
            //parameters
            Map m = new HashMap();
            m.put("grn_id", gid);
            //datasource
            invoice newinv = new invoice();
            try {
                JasperReport jr = JasperCompileManager.compileReport(reportPath);
                JasperPrint jp = JasperFillManager.fillReport(jr, m, db.dbConnection.getConnection());
                newinv.jTabbedPane1.add(new JRViewer(jp));
                newinv.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton72ActionPerformed
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dt = s.format(d);
        String reportPath = "D:\\Jasper\\MyReports\\pharmacyStocks.jrxml";
        //parameters
        Map m = new HashMap();
        m.put("Date", dt);
        //datasource
        invoice newinv = new invoice();
        try {
            JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr, m, db.dbConnection.getConnection());
            newinv.jTabbedPane1.add(new JRViewer(jp));
            newinv.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton72ActionPerformed

    private void jButton73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton73ActionPerformed
        Date dt = (Date) attendanceTableModel.getValueAt(0, 3);
        String reportPath = "D:\\Jasper\\MyReports\\medcureAttendance.jrxml";
        //parameters
        Map m = new HashMap();
        m.put("Date", dt);
        //datasource
        invoice newinv = new invoice();
        try {
            JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr, m, db.dbConnection.getConnection());
            newinv.jTabbedPane1.add(new JRViewer(jp));
            newinv.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton73ActionPerformed

    private void jMonthChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jMonthChooser2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jMonthChooser2PropertyChange

    private void jButton74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton74ActionPerformed
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dt = s.format(d);
        String reportPath = "D:\\Jasper\\MyReports\\medcureCustomers.jrxml";
            //parameters
            Map m = new HashMap();
            m.put("Date", dt);
//            m.put("grn_id", gid);
            //datasource
            invoice newinv = new invoice();
            try {
                JasperReport jr = JasperCompileManager.compileReport(reportPath);
                JasperPrint jp = JasperFillManager.fillReport(jr, m, db.dbConnection.getConnection());
                newinv.jTabbedPane1.add(new JRViewer(jp));
                newinv.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_jButton74ActionPerformed

    private void custoPayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custoPayKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();

        }
    }//GEN-LAST:event_custoPayKeyTyped

    private void invBarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invBarcodeKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();

        }
    }//GEN-LAST:event_invBarcodeKeyTyped

    private void custoMobFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custoMobFieldKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();

        }
    }//GEN-LAST:event_custoMobFieldKeyTyped

    private void supplierMobFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierMobFieldKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();

        }
    }//GEN-LAST:event_supplierMobFieldKeyTyped

    private void grnQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grnQtyKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();

        }
    }//GEN-LAST:event_grnQtyKeyTyped

    private void invViewIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invViewIdKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();

        }
    }//GEN-LAST:event_invViewIdKeyTyped

    private void pharmacistMobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pharmacistMobKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();

        }
    }//GEN-LAST:event_pharmacistMobKeyTyped

    private void lecobillKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lecobillKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();

        }
    }//GEN-LAST:event_lecobillKeyTyped

    private void jButton75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton75ActionPerformed
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dt = s.format(d);
        String reportPath = "D:\\Jasper\\MyReports\\pharmacists.jrxml";
        //parameters
        Map m = new HashMap();
        m.put("Date", dt);
        //datasource
        invoice newinv = new invoice();
        try {
            JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr, m, db.dbConnection.getConnection());
            newinv.jTabbedPane1.add(new JRViewer(jp));
            newinv.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton75ActionPerformed

    private void keywordField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keywordField2KeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();

        }
    }//GEN-LAST:event_keywordField2KeyTyped

    public void bar(JLabel lab) {
        jLabel11.setOpaque(false);
        jLabel8.setOpaque(false);
        jLabel14.setOpaque(false);
        jLabel2.setOpaque(false);
        jLabel5.setOpaque(false);
        jLabel17.setOpaque(false);
        jLabel104.setOpaque(false);
        lab.setOpaque(true);
        jPanel2.repaint();
    }

    public void guiVisibility(JInternalFrame jif) {
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(false);
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(false);
        jInternalFrame5.setVisible(false);
        jInternalFrame6.setVisible(false);
        jInternalFrame7.setVisible(false);
        jInternalFrame13.setVisible(false);
        jInternalFrame17.setVisible(false);
        jInternalFrame21.setVisible(false);
        jInternalFrame22.setVisible(false);
        jInternalFrame23.setVisible(false);
        jInternalFrame24.setVisible(false);
        jInternalFrame26.setVisible(false);
        jInternalFrame27.setVisible(false);
        jInternalFrame30.setVisible(false);
        jif.setVisible(true);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DataTable;
    private javax.swing.JTable DataTable1;
    private javax.swing.JTable DataTable10;
    private javax.swing.JTable DataTable11;
    private javax.swing.JTable DataTable12;
    private javax.swing.JTable DataTable13;
    private javax.swing.JTable DataTable14;
    private javax.swing.JTable DataTable15;
    private javax.swing.JTable DataTable16;
    private javax.swing.JTable DataTable17;
    private javax.swing.JTable DataTable18;
    private javax.swing.JTable DataTable19;
    private javax.swing.JTable DataTable2;
    private javax.swing.JTable DataTable20;
    private javax.swing.JTable DataTable21;
    private javax.swing.JTable DataTable22;
    private javax.swing.JTable DataTable23;
    private javax.swing.JTable DataTable24;
    private javax.swing.JTable DataTable25;
    private javax.swing.JTable DataTable27;
    private javax.swing.JTable DataTable28;
    private javax.swing.JTable DataTable29;
    private javax.swing.JTable DataTable3;
    private javax.swing.JTable DataTable4;
    private javax.swing.JTable DataTable5;
    private javax.swing.JTable DataTable6;
    private javax.swing.JPopupMenu PopupMenu;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField backupPathField;
    private javax.swing.JTextField balanceField;
    private javax.swing.JTextField barcodeField;
    private javax.swing.JTextField brandField;
    private javax.swing.JTextField brandIdField;
    private javax.swing.JCheckBox brandIsActive;
    private javax.swing.JTextField brandNameField;
    private javax.swing.JTextField buyPrice;
    private javax.swing.JTextArea companyAddress;
    private javax.swing.JTextField companyField;
    private javax.swing.JTextField companyIdField;
    private javax.swing.JCheckBox companyIsActive;
    private javax.swing.JTextField companyNameField;
    private javax.swing.JTextField cusMobkeyword;
    private javax.swing.JTextField custaMob;
    private javax.swing.JTextField custaName;
    private javax.swing.JTextField custoEmailField;
    private javax.swing.JTextField custoMobField;
    private javax.swing.JTextField custoNameField;
    private javax.swing.JTextField custoPay;
    private javax.swing.JTextField customerKeywordField;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JLabel dateLab;
    private com.toedter.calendar.JDateChooser dateOnly;
    private javax.swing.JTextField emailField;
    private com.toedter.calendar.JDateChooser expField;
    private javax.swing.JTextField grnId;
    private javax.swing.JTextField grnQty;
    private javax.swing.JTextField grnSupplierMob;
    private javax.swing.JTextField grnSupplierName;
    private com.toedter.calendar.JDateChooser grndate;
    private javax.swing.JTextField invBarcode;
    private javax.swing.JTextField invDisc;
    private javax.swing.JTextField invProduct;
    private javax.swing.JTextField invQty;
    private javax.swing.JTextField invViewId;
    private javax.swing.JCheckBox isActive;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame13;
    private javax.swing.JInternalFrame jInternalFrame14;
    private javax.swing.JInternalFrame jInternalFrame15;
    private javax.swing.JInternalFrame jInternalFrame16;
    private javax.swing.JInternalFrame jInternalFrame17;
    private javax.swing.JInternalFrame jInternalFrame18;
    private javax.swing.JInternalFrame jInternalFrame19;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame20;
    private javax.swing.JInternalFrame jInternalFrame21;
    private javax.swing.JInternalFrame jInternalFrame22;
    private javax.swing.JInternalFrame jInternalFrame23;
    private javax.swing.JInternalFrame jInternalFrame24;
    private javax.swing.JInternalFrame jInternalFrame25;
    private javax.swing.JInternalFrame jInternalFrame26;
    private javax.swing.JInternalFrame jInternalFrame27;
    private javax.swing.JInternalFrame jInternalFrame28;
    private javax.swing.JInternalFrame jInternalFrame29;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame30;
    private javax.swing.JInternalFrame jInternalFrame32;
    private javax.swing.JInternalFrame jInternalFrame33;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
    private javax.swing.JInternalFrame jInternalFrame6;
    private javax.swing.JInternalFrame jInternalFrame7;
    private javax.swing.JInternalFrame jInternalFrame8;
    private javax.swing.JInternalFrame jInternalFrame9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private com.toedter.calendar.JMonthChooser jMonthChooser2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel10;
    private keeptoo.KGradientPanel kGradientPanel11;
    private keeptoo.KGradientPanel kGradientPanel12;
    private keeptoo.KGradientPanel kGradientPanel13;
    private keeptoo.KGradientPanel kGradientPanel15;
    private keeptoo.KGradientPanel kGradientPanel16;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KGradientPanel kGradientPanel9;
    private javax.swing.JTextField keywordField1;
    private javax.swing.JTextField keywordField2;
    private javax.swing.JTextField keywordField3;
    private javax.swing.JTextField keywordField4;
    private javax.swing.JTextField keywordField5;
    private javax.swing.JTextField keywordField6;
    private javax.swing.JTextField lecobill;
    private com.toedter.calendar.JDateChooser mfdField;
    private javax.swing.JTextField pharmacistAddress;
    private javax.swing.JTextField pharmacistId;
    private javax.swing.JTextField pharmacistId3;
    private javax.swing.JTextField pharmacistId4;
    private javax.swing.JTextField pharmacistKeywordField;
    private javax.swing.JTextField pharmacistMob;
    private javax.swing.JTextField pharmacistName;
    private javax.swing.JTextField pharmacistName3;
    private javax.swing.JTextField pharmacistName4;
    private javax.swing.JTextField pharmacistNameKeyword;
    private javax.swing.JTextField productId;
    private javax.swing.JCheckBox productIsActive;
    private javax.swing.JTextField productNameField;
    private javax.swing.JTextField restorePathField;
    private com.toedter.calendar.JMonthChooser salesMonth;
    private javax.swing.JLabel salesTotal;
    private javax.swing.JTextField search1;
    private javax.swing.JTextField search2;
    private javax.swing.JTextField search3;
    private javax.swing.JTextField search4;
    private javax.swing.JTextField search5;
    private javax.swing.JTextField search6;
    private javax.swing.JTextField search7;
    private javax.swing.JTextField search8;
    private javax.swing.JComboBox<String> searchCombo;
    private javax.swing.JComboBox<String> searchcategoryCombo;
    private javax.swing.JTextField sellField;
    private javax.swing.JTextField stockProductField;
    private javax.swing.JCheckBox supplierIsActive;
    private javax.swing.JTextField supplierMobField;
    private javax.swing.JTextField supplierNameField;
    private javax.swing.JTextField timeField;
    private javax.swing.JLabel timeLab;
    private javax.swing.JLabel totalAmount;
    private javax.swing.JTextField totalField;
    private javax.swing.JLabel totalSalary;
    private javax.swing.JLabel totalSalary1;
    private javax.swing.JLabel totalSalary2;
    private javax.swing.JLabel totalSalary3;
    private javax.swing.JLabel totalSalary4;
    private javax.swing.JLabel totallabe1;
    private javax.swing.JLabel totallabe2;
    private javax.swing.JLabel validate1;
    private javax.swing.JLabel validate11;
    private javax.swing.JLabel validate12;
    private javax.swing.JLabel validate2;
    private javax.swing.JLabel validate3;
    private javax.swing.JLabel validate4;
    private javax.swing.JLabel validate5;
    private javax.swing.JLabel validate6;
    private javax.swing.JLabel validate7;
    private javax.swing.JLabel validate8;
    // End of variables declaration//GEN-END:variables

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
}
