package ui;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.salaryModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

public class salaries extends javax.swing.JDialog {

    private salaryModel salaryModel;

    DefaultTableModel salaryTableModel;

    public salaries(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mainForm.tableEffects(salaryTable);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 102, 102)));

        salaryTableModel = (DefaultTableModel) salaryTable.getModel();

        salaryModel = new salaryModel();

        salaryModel.loadSalaryTable("", salaryTableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        pharmacistExperience = new javax.swing.JTextField();
        jScrollPane27 = new javax.swing.JScrollPane();
        salaryTable = new javax.swing.JTable();
        jButton59 = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        updatebtn1 = new javax.swing.JButton();
        jPanel54 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        savebtn = new javax.swing.JButton();
        daySalary = new javax.swing.JTextField();
        validation = new javax.swing.JLabel();
        experienceField = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        updatebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(400, 300));
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        kGradientPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1365, 2, -1, -1));

        getContentPane().add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 35));

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "Salaray Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel52.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pharmacistExperience.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pharmacistExperience.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel53.add(pharmacistExperience, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 310, 40));

        salaryTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Experience", "Salary Per Day"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salaryTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salaryTable.setFocusable(false);
        salaryTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        salaryTable.setRowHeight(25);
        salaryTable.setSelectionBackground(new java.awt.Color(7, 191, 227));
        salaryTable.getTableHeader().setReorderingAllowed(false);
        salaryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salaryTableMouseClicked(evt);
            }
        });
        jScrollPane27.setViewportView(salaryTable);

        jPanel53.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 660, 300));

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
        jPanel53.add(jButton59, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 140, 40));

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 102, 102));
        jLabel106.setText("Search by experience");
        jPanel53.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 30));

        updatebtn1.setBackground(new java.awt.Color(0, 204, 102));
        updatebtn1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        updatebtn1.setForeground(new java.awt.Color(255, 255, 255));
        updatebtn1.setText("Print Report");
        updatebtn1.setContentAreaFilled(false);
        updatebtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatebtn1.setOpaque(true);
        updatebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtn1ActionPerformed(evt);
            }
        });
        jPanel53.add(updatebtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 190, 40));

        jPanel52.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 700, 490));

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel112.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(0, 102, 102));
        jLabel112.setText("Salary Per Day :");
        jPanel54.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        savebtn.setBackground(new java.awt.Color(0, 204, 102));
        savebtn.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        savebtn.setForeground(new java.awt.Color(255, 255, 255));
        savebtn.setText("Save");
        savebtn.setContentAreaFilled(false);
        savebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        savebtn.setOpaque(true);
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });
        jPanel54.add(savebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 150, 50));

        daySalary.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        daySalary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel54.add(daySalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 320, 40));

        validation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        validation.setForeground(new java.awt.Color(255, 0, 0));
        validation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel54.add(validation, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 345, 30));

        experienceField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        experienceField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        experienceField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel54.add(experienceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 320, 40));

        jLabel117.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 102, 102));
        jLabel117.setText("Experience :");
        jPanel54.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        updatebtn.setBackground(new java.awt.Color(0, 204, 102));
        updatebtn.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        updatebtn.setForeground(new java.awt.Color(255, 255, 255));
        updatebtn.setText("Update");
        updatebtn.setContentAreaFilled(false);
        updatebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatebtn.setOpaque(true);
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel54.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 150, 50));

        jPanel52.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 580, 380));

        getContentPane().add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1380, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel37MouseClicked

    private void salaryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salaryTableMouseClicked
        int row = salaryTable.getSelectedRow();

        experienceField.setText((String) salaryTableModel.getValueAt(row, 0));
        daySalary.setText((String) salaryTableModel.getValueAt(row, 1));
    }//GEN-LAST:event_salaryTableMouseClicked

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        String keyword = pharmacistExperience.getText();

        salaryModel.loadSalaryTable(keyword, salaryTableModel);
    }//GEN-LAST:event_jButton59ActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        if (experienceField.getText().isEmpty() && daySalary.getText().isEmpty()) {
            validation.setText("Field(s) are Empty");
        } else {
            String expr = "0";
            for (int i = 0; i < salaryTableModel.getRowCount(); i++) {
                if (experienceField.getText().equals((String) salaryTableModel.getValueAt(i, 0))) {
                    expr = "1";
                    JOptionPane.showConfirmDialog(rootPane, "Experience already added", null, -1, 2);
                }
            }
            if (expr == "0") {
                String experience = experienceField.getText();
                String salary = daySalary.getText();

                String result = salaryModel.insertSalaries(experience, salary);

                salaryModel.loadSalaryTable("", salaryTableModel);
                if (result.contains("Success")) {
                    JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
                } else {
                    JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 0);
                }
            }
        }
    }//GEN-LAST:event_savebtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        if (experienceField.getText().isEmpty() && daySalary.getText().isEmpty()) {
            validation.setText("Field(s) are Empty");
        } else {
            String experience = experienceField.getText();
            String salary = daySalary.getText();

            String result = salaryModel.updateSalaries(experience, salary);

            salaryModel.loadSalaryTable("", salaryTableModel);
            if (result.contains("Success")) {
                JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 1);
            } else {
                JOptionPane.showConfirmDialog(rootPane, result, "Message", -1, 0);
            }
        }
    }//GEN-LAST:event_updatebtnActionPerformed

    private void updatebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtn1ActionPerformed
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dt = s.format(d);
        String reportPath = "D:\\Jasper\\MyReports\\basicSalaries.jrxml";
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

    }//GEN-LAST:event_updatebtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(salaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(salaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(salaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(salaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                salaries dialog = new salaries(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField daySalary;
    private javax.swing.JTextField experienceField;
    private javax.swing.JButton jButton59;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JScrollPane jScrollPane27;
    private keeptoo.KGradientPanel kGradientPanel3;
    private javax.swing.JTextField pharmacistExperience;
    private javax.swing.JTable salaryTable;
    private javax.swing.JButton savebtn;
    private javax.swing.JButton updatebtn;
    private javax.swing.JButton updatebtn1;
    private javax.swing.JLabel validation;
    // End of variables declaration//GEN-END:variables
}
