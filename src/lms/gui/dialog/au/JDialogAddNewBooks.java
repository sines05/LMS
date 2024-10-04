/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.gui.dialog.au;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;
import lms.gui.dialog.JDialogAddAuthorToList;
import lms.model.Book;
import lms.model.CallNumberLine1;
import lms.model.Genre;
import lms.model.Publisher;
import lms.util.AutoSearch;
import lms.util.ComboBoxList;
import lms.util.QueryLMS;

/**
 *
 * @author admin
 */
public class JDialogAddNewBooks extends javax.swing.JDialog implements MouseListener {

    private lms.gui.JFrameMainSLM mainMenu;
    private lms.model.Book book;
    private ArrayList<lms.model.Author> authorList = new ArrayList<>();
    private QueryLMS query = new QueryLMS();
    private Publisher publisher = new Publisher();
    private CallNumberLine1 callNumberLine1 = new CallNumberLine1();
    private Genre genre = new Genre();
    private JTextComponent comboBoxEditor;

    /**
     * Creates new form JDialogBooks
     */
    public JDialogAddNewBooks(lms.gui.JFrameMainSLM parent, boolean modal, String title) {
        super(parent, modal);
        initComponents();
        this.mainMenu = parent;
        setTitle(title);
        jButtonRemove.setEnabled(false);
        setTable();
        comboPublisher();
        comboCallNumberLine1();
        comboLine4();
        comboGenre();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Publisher
                jComboBoxPublisher.setEditable(true);
                comboBoxEditor = (JTextComponent) jComboBoxPublisher.getEditor().getEditorComponent();
                comboBoxEditor.setDocument(new AutoSearch(jComboBoxPublisher));
                comboBoxEditor.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (jComboBoxPublisher.isDisplayable()) {
                            jComboBoxPublisher.setPopupVisible(true);
                        }
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                            jComboBoxProductKeyPressed(e);
                        }
                    }
                });

                //Call Number Line 1
                jComboBoxLine1.setEditable(true);
                comboBoxEditor = (JTextComponent) jComboBoxLine1.getEditor().getEditorComponent();
                comboBoxEditor.setDocument(new AutoSearch(jComboBoxLine1));
                comboBoxEditor.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (jComboBoxLine1.isDisplayable()) {
                            jComboBoxLine1.setPopupVisible(true);
                        }
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                            jComboBoxProductKeyPressed(e);
                        }
                    }
                });

                //Genre
                jComboBoxGenre.setEditable(true);
                comboBoxEditor = (JTextComponent) jComboBoxGenre.getEditor().getEditorComponent();
                comboBoxEditor.setDocument(new AutoSearch(jComboBoxGenre));
                comboBoxEditor.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (jComboBoxGenre.isDisplayable()) {
                            jComboBoxGenre.setPopupVisible(true);
                        }
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                            jComboBoxProductKeyPressed(e);
                        }
                    }
                });

            }
        });

    }

    public JDialogAddNewBooks(lms.gui.JFrameMainSLM parent, boolean modal, String title, lms.model.Book book) {
        this.mainMenu = parent;
        this.book = book;
        setTitle(title);
        jButtonRemove.setEnabled(false);
        setTable();
        comboPublisher();
        comboCallNumberLine1();
        comboLine4();
        comboGenre();
    }

    public JDialogAddNewBooks(lms.gui.JFrameMainSLM parent, boolean modal, lms.model.Book book, String title) {
        this.mainMenu = parent;
        this.book = book;
        setTitle(title);
        jButtonRemove.setEnabled(false);
        setTable();
        comboPublisher();
        comboCallNumberLine1();
        comboLine4();
        comboGenre();
    }

    public JDialogAddNewBooks(ArrayList<lms.model.Author> authorList) {
        this.authorList = authorList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldISBN = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAuthor = new javax.swing.JTable();
        jButtonRemove = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldTitle = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldDescription = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldNotes = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldSubject = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldQty = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBoxPublisher = new javax.swing.JComboBox<>();
        jButtonNew = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldURL = new javax.swing.JTextField();
        jTextFieldL2 = new javax.swing.JTextField();
        jTextFieldL3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxL4 = new javax.swing.JComboBox<>();
        jComboBoxLine1 = new javax.swing.JComboBox<>();
        jComboBoxGenre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Books");

        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setMaximumSize(new java.awt.Dimension(402, 902));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(402, 902));

        jPanel3.setMaximumSize(new java.awt.Dimension(400, 700));
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 700));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 600));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(410, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(410, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Genre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 80, 23));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ISBN-13:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 23, 80, 23));
        jPanel1.add(jTextFieldISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 23, 310, 23));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Title:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 23));

        jTableAuthor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Author"
            }
        ));
        jScrollPane1.setViewportView(jTableAuthor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 220, 110));

        jButtonRemove.setText("Remove");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 80, 30));

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 103, 80, 30));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Author:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 23));
        jPanel1.add(jTextFieldTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 310, 23));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Publisher:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 80, 23));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Description:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 80, 23));
        jPanel1.add(jTextFieldDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 310, 23));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Notes:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 80, 23));
        jPanel1.add(jTextFieldNotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 310, 23));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Subjects:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 80, 23));
        jPanel1.add(jTextFieldSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 310, 23));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Quantity:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 80, 23));
        jPanel1.add(jTextFieldQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 310, 23));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Price:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 80, 23));
        jPanel1.add(jTextFieldPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 310, 23));

        jButton3.setMnemonic('S');
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 610, 70, 30));

        jComboBoxPublisher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBoxPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 310, 23));

        jButtonNew.setText("New");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 80, 30));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("URL:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 80, 23));
        jPanel1.add(jTextFieldURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 310, 23));
        jPanel1.add(jTextFieldL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 310, 23));
        jPanel1.add(jTextFieldL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 310, 23));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Call No:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 80, 23));
        jPanel1.add(jComboBoxL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 310, 23));
        jPanel1.add(jComboBoxLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 310, 23));

        jPanel1.add(jComboBoxGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 310, 23));

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        jScrollPane2.setViewportView(jPanel3);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(490, 704));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        int i = jTableAuthor.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "NO SELECTED ITEM", "EMPTY SELECTION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (confirm("REMOVE SELECTED ITEM?")) {
            DefaultTableModel tbl = (DefaultTableModel) jTableAuthor.getModel();
            tbl.removeRow(i);
            jTableAuthor.updateUI();

        }
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        JDialogAddAuthorToList aatlist = new JDialogAddAuthorToList(mainMenu, true);
        aatlist.setVisible(true);
        setAuthorList(aatlist.getAuthorList());
        addToTable();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        JDialogAuthorAUD u = new JDialogAuthorAUD(mainMenu, true, "Add");
        u.setTitle("Add Author");
        u.setVisible(true);

    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        fieldValidation();
        addNewBookPerList();

    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    public javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JComboBox<Object> jComboBoxGenre;
    private javax.swing.JComboBox<Object> jComboBoxL4;
    private javax.swing.JComboBox<Object> jComboBoxLine1;
    private javax.swing.JComboBox<Object> jComboBoxPublisher;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAuthor;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldISBN;
    private javax.swing.JTextField jTextFieldL2;
    private javax.swing.JTextField jTextFieldL3;
    private javax.swing.JTextField jTextFieldNotes;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldQty;
    private javax.swing.JTextField jTextFieldSubject;
    private javax.swing.JTextField jTextFieldTitle;
    private javax.swing.JTextField jTextFieldURL;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the authorList
     */
    public ArrayList<lms.model.Author> getAuthorList() {
        return authorList;
    }

    /**
     * @param authorList the authorList to set
     */
    public void setAuthorList(ArrayList<lms.model.Author> authorList) {
        this.authorList = authorList;
    }

    public DefaultTableModel tableModel = new DefaultTableModel() {
        public Class getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return String.class;
            }
            switch (columnIndex) {
                case 1:
                    return Integer.class;
                case 2:
                    return String.class;
                case 3:
                    return String.class;
                case 4:
                    return String.class;
                case 5:
                    return Boolean.class;
                default:
                    return String.class;
            }
        }

        public boolean isCellEditable(int row, int col) {
            if (col < 10) {
                return false;

            } else {
                return true;
            }
        }
    };

    private TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);

    public void setTable() {
        try {
            String[] columnNames = {
                "ID",//
                "Firstname", "Middlename", "Lastname", "Author"//1
            };//15

            jTableAuthor = new javax.swing.JTable(tableModel);
            JTableHeader header = jTableAuthor.getTableHeader();
            header.setPreferredSize(new Dimension(100, 0));
            header.setFont(new Font("Courier New", Font.PLAIN, 14));
            header.setBackground(new java.awt.Color(153, 153, 153));
            jTableAuthor.setRowSorter(sorter);
            jTableAuthor.addMouseListener(this);
            jTableAuthor.setRowHeight(50);
            jTableAuthor.setFont(new Font("Courier New", Font.PLAIN, 12));
//            jTable1.setCellSelectionEnabled(true);
            jTableAuthor.setFocusable(false);
            for (int i = 0; i < columnNames.length;) {
                tableModel.addColumn(columnNames[i]);
                i++;
            }

            jScrollPane1.setViewportView(jTableAuthor);

            TableColumn[] column = new TableColumn[100];
            column[0] = jTableAuthor.getColumnModel().getColumn(0);
            column[0].setPreferredWidth(0);
            TableColumn hidden = jTableAuthor.getColumnModel().getColumn(0);
            hidden.setMinWidth(0);
            hidden.setPreferredWidth(0);
            hidden.setMaxWidth(0);
            TableColumn hidden1 = jTableAuthor.getColumnModel().getColumn(1);
            hidden1.setMinWidth(0);
            hidden1.setPreferredWidth(0);
            hidden1.setMaxWidth(0);
            TableColumn hidden2 = jTableAuthor.getColumnModel().getColumn(2);
            hidden2.setMinWidth(0);
            hidden2.setPreferredWidth(0);
            hidden2.setMaxWidth(0);
            TableColumn hidden3 = jTableAuthor.getColumnModel().getColumn(3);
            hidden3.setMinWidth(0);
            hidden3.setPreferredWidth(0);
            hidden3.setMaxWidth(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addToTable() {
        if (getAuthorList() == null) {
            return;
        } else {
            try {
                for (lms.model.Author a : getAuthorList()) {
                    tableModel.addRow(new Object[]{a.getId(), a.getFirstname(), a.getMiddlename(), a.getLastname(), a.getLastname() + ", " + a.getFirstname() + " " + a.getMiddlename()});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean confirm(String confirmMessage) {
        int ans = JOptionPane.showConfirmDialog(this, confirmMessage, "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        return (ans == JOptionPane.YES_OPTION);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jTableAuthor) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (e.getClickCount() == 1) {
                    int row = jTableAuthor.getSelectedRow();
                    if (row != -1) {
                        jButtonRemove.setEnabled(true);
                    }
                }
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void comboPublisher() {
        this.jComboBoxPublisher.removeAllItems();
        jComboBoxPublisher.addItem("");
        query.publisherComboBox();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxPublisher.addItem(a);
        }
    }

    private void fieldValidation() {

        try {
            if (jTableAuthor.getRowCount() < 1) {
                JOptionPane.showMessageDialog(mainMenu, "No added author!!", "Warning!!!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (jTextFieldISBN.getText().equals("") || jTextFieldTitle.getText().equals("") || jTextFieldDescription.getText().equals("") || jTextFieldNotes.getText().equals("") || jTextFieldSubject.getText().equals("") || jTextFieldQty.getText().equals("") || jTextFieldPrice.getText().equals("") || jTextFieldURL.getText().equals("") || jTextFieldL2.getText().equals("") || jTextFieldL3.getText().equals("")) {
                JOptionPane.showMessageDialog(mainMenu, "There's empty text field is not allowed!", "Warning!!!", JOptionPane.WARNING_MESSAGE);
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void comboCallNumberLine1() {
        this.jComboBoxLine1.removeAllItems();
        jComboBoxLine1.addItem("");
        query.callNumberLine1ComboBox();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxLine1.addItem(a);
        }
    }

    private void comboLine4() {
        for (int i = 2022; i > 1950; --i) {
            this.jComboBoxL4.addItem(i);
        }
    }

    private void comboGenre() {
        this.jComboBoxGenre.removeAllItems();
        jComboBoxGenre.addItem("");
        query.genreComboBox();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxGenre.addItem(a);
        }
    }

    private void addNewBookPerList() {
        try {
            if (jComboBoxPublisher.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(mainMenu, "No publisher selected!! try again.", "Warring!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                ComboBoxList publisherIdl = (ComboBoxList) this.jComboBoxPublisher.getSelectedItem();
                publisher.setId(Integer.parseInt(publisherIdl.getId()));
                publisher.setName(publisherIdl.getName());
            }

            if (jComboBoxLine1.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(mainMenu, "No call number line 1 selected!! try again.", "Warring!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                ComboBoxList callNumberL1l = (ComboBoxList) this.jComboBoxLine1.getSelectedItem();
                callNumberLine1.setId(Integer.parseInt(callNumberL1l.getId()));
                callNumberLine1.setDescription(callNumberL1l.getName());
            }

            if (jComboBoxGenre.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(mainMenu, "No genre selected!! try again.", "Warring!!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                ComboBoxList genrel = (ComboBoxList) this.jComboBoxGenre.getSelectedItem();
                genre.setId(Integer.parseInt(genrel.getId()));
                genre.setGenre(genrel.getName());
            }

            setBook(new Book(jTextFieldISBN.getText(), jTextFieldTitle.getText(), getAuthorList(), publisher, jTextFieldDescription.getText(), jTextFieldNotes.getText(), jTextFieldSubject.getText(), Integer.parseInt(jTextFieldQty.getText()), Float.parseFloat(jTextFieldPrice.getText()), jTextFieldURL.getText(), callNumberLine1, jTextFieldL2.getText(), jTextFieldL3.getText(), jComboBoxL4.getSelectedItem().toString(), genre));
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the book
     */
    public lms.model.Book getBook() {
        return book;
    }

    /**
     * @param book the book to set
     */
    public void setBook(lms.model.Book book) {
        this.book = book;
    }

}
