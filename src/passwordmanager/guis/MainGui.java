/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.guis;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import passwordmanager.PasswordManager;

/**
 *
 * @author Matthew
 */
public class MainGui extends javax.swing.JFrame {

    EditorGui editGui = new EditorGui(this);
    PasswordManager main = new PasswordManager();
    
    
    /**
     * Creates new form MainGui
     */
    public MainGui() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        TableScrollPane = new javax.swing.JScrollPane();
        PassTable = new javax.swing.JTable();
        ButtonPannel = new javax.swing.JPanel();
        AddPass = new javax.swing.JButton();
        RemovePass = new javax.swing.JButton();
        SavePass = new javax.swing.JButton();
        EditPass = new javax.swing.JButton();
        SearchPannel = new javax.swing.JPanel();
        SearchPass = new javax.swing.JButton();
        SearchPassField = new javax.swing.JTextField();
        SearchSelect = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password Manager");

        PassTable.setAutoCreateRowSorter(true);
        PassTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PassTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "App Name", "Email", "Username", "Password", "Other Information"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        PassTable.setCellSelectionEnabled(true);
        PassTable.getTableHeader().setReorderingAllowed(false);
        TableScrollPane.setViewportView(PassTable);
        PassTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(TableScrollPane, java.awt.BorderLayout.CENTER);

        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel2Layout.rowHeights = new int[] {0};
        ButtonPannel.setLayout(jPanel2Layout);

        AddPass.setText("Add");
        AddPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPassActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        ButtonPannel.add(AddPass, gridBagConstraints);

        RemovePass.setText("Remove");
        RemovePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemovePassActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        ButtonPannel.add(RemovePass, gridBagConstraints);

        SavePass.setText("Save");
        SavePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavePassActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        ButtonPannel.add(SavePass, gridBagConstraints);

        EditPass.setText("Edit");
        EditPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditPassActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        ButtonPannel.add(EditPass, gridBagConstraints);

        getContentPane().add(ButtonPannel, java.awt.BorderLayout.PAGE_END);

        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[] {0, 5, 0, 5, 0};
        jPanel4Layout.rowHeights = new int[] {0};
        SearchPannel.setLayout(jPanel4Layout);

        SearchPass.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        SearchPannel.add(SearchPass, gridBagConstraints);

        SearchPassField.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        SearchPannel.add(SearchPassField, gridBagConstraints);

        SearchSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "App Name", "Email", "Username", "Password", "Other Information" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        SearchPannel.add(SearchSelect, gridBagConstraints);

        getContentPane().add(SearchPannel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPassActionPerformed
        DefaultTableModel model =(DefaultTableModel) PassTable.getModel();
        String[] newItem = editGui.addNew();
        if (newItem[0] != null) {
            model.addRow(new Object[]{newItem[0], newItem[1], newItem[2], newItem[3], newItem[4]});
        }
        
        
        
    }//GEN-LAST:event_AddPassActionPerformed

    private void EditPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditPassActionPerformed
        int selected = PassTable.getSelectedRow();
      DefaultTableModel model =(DefaultTableModel) PassTable.getModel();
        String[] values = editGui.Edit((String)model.getValueAt(selected, 0), (String)model.getValueAt(selected, 1), (String)model.getValueAt(selected, 2), (String)model.getValueAt(selected, 3), (String)model.getValueAt(selected, 4));
        if (values[0] != null) {
            model.setValueAt((Object)values[0], selected, 0);
            model.setValueAt((Object)values[1], selected, 1);
            model.setValueAt((Object)values[2], selected, 2);
            model.setValueAt((Object)values[3], selected, 3);
            model.setValueAt((Object)values[4], selected, 4);
        }
        
        
    }//GEN-LAST:event_EditPassActionPerformed

    private void RemovePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemovePassActionPerformed
        DefaultTableModel model =(DefaultTableModel) PassTable.getModel();
        int selected = PassTable.getSelectedRow();
        System.out.print(selected);
        model.removeRow(selected);
    }//GEN-LAST:event_RemovePassActionPerformed

    private void SavePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavePassActionPerformed
        DefaultTableModel model =(DefaultTableModel) PassTable.getModel();
        JSONObject saveData = new JSONObject();
        for (int i=0 ; i < model.getRowCount(); i++) {
            Map rowData = new LinkedHashMap(5);
            rowData.put(0, model.getValueAt(i, 0));
            rowData.put(1, model.getValueAt(i, 1));
            rowData.put(2, model.getValueAt(i, 2));
            rowData.put(3, model.getValueAt(i, 3));
            rowData.put(4, model.getValueAt(i, 4));
            saveData.put(Integer.toString(i), rowData);
            System.out.println(i);
        }
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(PasswordManager.passwordFile));
            writer.write(saveData.toString());
            writer.flush();
            writer.close();
        }
        catch (IOException ex){
            
        }
        
        
        
        
    }//GEN-LAST:event_SavePassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGui().setVisible(true);
            }
        });
    }
    
    public void loadData() {
        DefaultTableModel model =(DefaultTableModel) PassTable.getModel();
        JSONParser parser = new JSONParser();
        
        try (FileReader reader = new FileReader(PasswordManager.passwordFile)) {
            Object obj = parser.parse(reader);
            JSONObject data = (JSONObject) obj;
            for (int i = 0 ; i < data.size(); i++) {
                JSONObject rowData= (JSONObject)(data.get(Integer.toString(i))) ;
                model.addRow(new Object[]{rowData.get("0"), rowData.get("1"), rowData.get("2"), rowData.get("3"), rowData.get("4")});
            }
            
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPass;
    private javax.swing.JPanel ButtonPannel;
    private javax.swing.JButton EditPass;
    private javax.swing.JTable PassTable;
    private javax.swing.JButton RemovePass;
    private javax.swing.JButton SavePass;
    private javax.swing.JPanel SearchPannel;
    private javax.swing.JButton SearchPass;
    private javax.swing.JTextField SearchPassField;
    private javax.swing.JComboBox<String> SearchSelect;
    private javax.swing.JScrollPane TableScrollPane;
    // End of variables declaration//GEN-END:variables
}

