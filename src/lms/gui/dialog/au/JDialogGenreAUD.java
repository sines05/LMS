/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.gui.dialog.au;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import lms.util.AutoSearch;
import lms.util.ComboBoxList;
import lms.util.QueryLMS;

/**
 *
 * @author Aldrin
 */
public class JDialogGenreAUD extends javax.swing.JDialog {

    private lms.gui.JFrameMainSLM mainMenu;
    private String evt = new String();
    private File pictureFile = null;
    private File photo;
    private lms.model.Type type = new lms.model.Type();
    private lms.util.QueryLMS query = new lms.util.QueryLMS();
    private lms.model.Genre genre = new lms.model.Genre();
    private JTextComponent comboBoxEditor;

    /**
     * Creates new form JDialogSupplierAUD
     */
    public JDialogGenreAUD(lms.gui.JFrameMainSLM parent, boolean modal) {
        super(parent, modal);
        this.mainMenu = parent;
        initComponents();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Publisher
                jComboBoxType.setEditable(true);
                comboBoxEditor = (JTextComponent) jComboBoxType.getEditor().getEditorComponent();
                comboBoxEditor.setDocument(new AutoSearch(jComboBoxType));
                comboBoxEditor.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (jComboBoxType.isDisplayable()) {
                            jComboBoxType.setPopupVisible(true);
                        }
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                            jComboBoxProductKeyPressed(e);
                        }
                    }
                });

            }
        });
    }

    public JDialogGenreAUD(lms.gui.JFrameMainSLM parent, boolean modal, String evtl) {
        super(parent, modal);
        initComponents();
        comboBoxType();
        this.evt = evtl;
        setTitle("Add Category");
        jButtonSave.setText("Save");
        jButtonSave.setMnemonic('S');
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Publisher
                jComboBoxType.setEditable(true);
                comboBoxEditor = (JTextComponent) jComboBoxType.getEditor().getEditorComponent();
                comboBoxEditor.setDocument(new AutoSearch(jComboBoxType));
                comboBoxEditor.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (jComboBoxType.isDisplayable()) {
                            jComboBoxType.setPopupVisible(true);
                        }
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                            jComboBoxProductKeyPressed(e);
                        }
                    }
                });

            }
        });

    }

    public JDialogGenreAUD(lms.gui.JFrameMainSLM parent, boolean modal, String evtl, lms.model.Genre genre) {
        super(parent, modal);
        initComponents();
        this.evt = evtl;
        this.genre = genre;
        jButtonSave.setText("Update");
        jButtonSave.setMnemonic('U');
        jTextFieldGenre.setText(this.genre.getGenre());
        jTextAreaDescription.setText(this.genre.getDescription());
//        jComboBoxType.setEditable(true);
        comboBoxType();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(this.genre.getType().getId()), jComboBoxType);
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Publisher
//                jComboBoxType.setEditable(true);
                comboBoxEditor = (JTextComponent) jComboBoxType.getEditor().getEditorComponent();
                comboBoxEditor.setDocument(new AutoSearch(jComboBoxType));
                comboBoxEditor.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (jComboBoxType.isDisplayable()) {
                            jComboBoxType.setPopupVisible(true);
                        }
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                            jComboBoxProductKeyPressed(e);
                        }
                    }
                });

            }
        });

    }

    public JDialogGenreAUD(lms.gui.JFrameMainSLM parent, boolean modal, lms.model.Genre genre, String evtl) {
        super(parent, modal);
        initComponents();
        this.evt = evtl;
        this.genre = genre;
        jButtonSave.setText("Delete");
        jButtonSave.setMnemonic('D');
        jTextFieldGenre.setText(this.genre.getGenre());
        jTextAreaDescription.setText(this.genre.getDescription());
        comboBoxType();
        for (ComboBoxList a : this.query.getList()) {
            a.setSelectedId(query.getList(), String.valueOf(this.genre.getType().getId()), jComboBoxType);
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Publisher
//                jComboBoxType.setEditable(true);
                comboBoxEditor = (JTextComponent) jComboBoxType.getEditor().getEditorComponent();
                comboBoxEditor.setDocument(new AutoSearch(jComboBoxType));
                comboBoxEditor.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (jComboBoxType.isDisplayable()) {
                            jComboBoxType.setPopupVisible(true);
                        }
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                            jComboBoxProductKeyPressed(e);
                        }
                    }
                });

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldGenre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxType = new javax.swing.JComboBox<>();
        jPanelButton = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("Type");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, -1));

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setText("Description");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 180, -1));

        jTextFieldGenre.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jPanel2.add(jTextFieldGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 105, 290, -1));

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescription);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 290, 240));

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel5.setText("Genre");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 180, -1));

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxType.setPreferredSize(new java.awt.Dimension(56, 23));
        jPanel2.add(jComboBoxType, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, 290, -1));

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanelButton.setPreferredSize(new java.awt.Dimension(394, 60));
        jPanelButton.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSave.setMnemonic('S');
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, 36));

        jPanelButton.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setPreferredSize(new java.awt.Dimension(10, 100));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanelButton.add(jPanel6, java.awt.BorderLayout.WEST);

        jPanel7.setPreferredSize(new java.awt.Dimension(10, 100));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanelButton.add(jPanel7, java.awt.BorderLayout.EAST);

        jPanel1.add(jPanelButton, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(331, 516));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        if (jComboBoxType.getSelectedItem() == "Select Type") {
            JOptionPane.showMessageDialog(mainMenu, "Please select Type of genre.", "Please try again!!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ComboBoxList unitIdl = (ComboBoxList) this.jComboBoxType.getSelectedItem();
        type.setId(Integer.parseInt(unitIdl.getId()));
        genre.setType(type);

        try {
            switch (this.evt) {
                case "Add":
                    int reply = JOptionPane.showConfirmDialog(this,
                            "Are you sure  to save " + jTextFieldGenre.getText() + "   " + jTextAreaDescription.getText() + " ?",
                            "Confirmation - Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (reply == JOptionPane.YES_OPTION) {
                        genre.setGenre(jTextFieldGenre.getText());
                        genre.setDescription(jTextAreaDescription.getText());
                        new QueryLMS().addGenre(genre);
                    } else if (reply == JOptionPane.NO_OPTION) {

                    }
                    this.dispose();
                    break;

                case "Update":
                    int upate = JOptionPane.showConfirmDialog(this,
                            "Are you sure  to save " + jTextFieldGenre.getText() + "   " + jTextAreaDescription.getText() + " ?",
                            "Confirmation - Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (upate == JOptionPane.YES_OPTION) {
                        genre.setGenre(jTextFieldGenre.getText());
                        genre.setDescription(jTextAreaDescription.getText());
                        new QueryLMS().updateGenre(genre);
                    }
                    this.dispose();
                    break;
                case "Delete":
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + type.getType() + " " + type.getDescription() + " ?", "Delete Confirmation!!", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        new QueryLMS().deleteGenre(genre);
                        JOptionPane.showMessageDialog(null, type.getType() + " " + type.getDescription() + " is successfully deleted.", "Message", JOptionPane.PLAIN_MESSAGE);
                    }
                    this.dispose();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<Object> jComboBoxType;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldGenre;
    // End of variables declaration//GEN-END:variables
    private void comboBoxType() {
        this.jComboBoxType.removeAllItems();
//        jComboBoxType.addItem("<html><center><p style=\"font-weight: bold; color: red;padding-top: 0px;\">Select Type</p></center></html>");
//        jComboBoxType.addItem("Select Type");
        query.comboBoxType();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxType.addItem(a);
        }
    }
}
