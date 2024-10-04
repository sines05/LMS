/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.gui.dialog;

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
import lms.gui.dialog.au.JDialogAddNewBooks;
import lms.model.Author;
import lms.model.Book;
import lms.model.BookRecieve;
import lms.model.CallNumberLine1;
import lms.model.Genre;
import lms.model.Publisher;
import lms.util.AutoSearch;
import lms.util.ComboBoxList;
import lms.util.LoginUser;
import lms.util.QueryLMS;

/**
 *
 * @author admin
 */
public class JDialogRecievedNewBooks extends javax.swing.JDialog implements MouseListener {

    private lms.gui.JFrameMainSLM jframeSLM;
    private lms.model.Book book;
    private lms.util.QueryLMS query = new lms.util.QueryLMS();
    private JTextComponent comboBoxEditor;
    private static String authorList;
    private lms.model.Purchaser purchaser = new lms.model.Purchaser();
    private ArrayList<Author> authorArrayList;
    private Publisher publisher = new Publisher();
    private CallNumberLine1 callNoLine1 = new CallNumberLine1();
    private Genre genre = new Genre();

    /**
     * Creates new form JDialogBooks
     */
    public JDialogRecievedNewBooks(lms.gui.JFrameMainSLM parent, boolean modal, String title) {
        super(parent, modal);
        initComponents();
        this.jframeSLM = parent;
        setTitle(title);
        setTable();
        comboPurchaser();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Publisher
                jComboBoxPurchaser.setEditable(true);
                comboBoxEditor = (JTextComponent) jComboBoxPurchaser.getEditor().getEditorComponent();
                comboBoxEditor.setDocument(new AutoSearch(jComboBoxPurchaser));
                comboBoxEditor.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (jComboBoxPurchaser.isDisplayable()) {
                            jComboBoxPurchaser.setPopupVisible(true);
                        }
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                            jComboBoxProductKeyPressed(e);
                        }
                    }
                });

            }
        });
        jButtonAdd.setEnabled(false);
        jButtonRemove.setEnabled(false);
        jButtonSave.setEnabled(false);

    }

    public JDialogRecievedNewBooks(lms.gui.JFrameMainSLM parent, boolean modal, String title, lms.model.Book book) {
        this.jframeSLM = parent;
        this.book = book;
        setTitle(title);
        comboPurchaser();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Publisher
                jComboBoxPurchaser.setEditable(true);
                comboBoxEditor = (JTextComponent) jComboBoxPurchaser.getEditor().getEditorComponent();
                comboBoxEditor.setDocument(new AutoSearch(jComboBoxPurchaser));
                comboBoxEditor.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (jComboBoxPurchaser.isDisplayable()) {
                            jComboBoxPurchaser.setPopupVisible(true);
                        }
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                            jComboBoxProductKeyPressed(e);
                        }
                    }
                });

            }
        });

    }

    public JDialogRecievedNewBooks(lms.gui.JFrameMainSLM parent, boolean modal, lms.model.Book book, String title) {
        this.jframeSLM = parent;
        this.book = book;
        setTitle(title);
        comboPurchaser();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Publisher
                jComboBoxPurchaser.setEditable(true);
                comboBoxEditor = (JTextComponent) jComboBoxPurchaser.getEditor().getEditorComponent();
                comboBoxEditor.setDocument(new AutoSearch(jComboBoxPurchaser));
                comboBoxEditor.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (jComboBoxPurchaser.isDisplayable()) {
                            jComboBoxPurchaser.setPopupVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField14 = new javax.swing.JTextField();
        jButtonRemove = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxPurchaser = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 190, 30));

        jButtonRemove.setMnemonic('R');
        jButtonRemove.setText("Remove");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 90, 30));

        jButtonSave.setMnemonic('S');
        jButtonSave.setText("Save");
        jButtonSave.setMaximumSize(new java.awt.Dimension(71, 23));
        jButtonSave.setMinimumSize(new java.awt.Dimension(71, 23));
        jButtonSave.setPreferredSize(new java.awt.Dimension(71, 23));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 480, 90, 30));

        jButtonAdd.setMnemonic('A');
        jButtonAdd.setText("Add");
        jButtonAdd.setMaximumSize(new java.awt.Dimension(71, 23));
        jButtonAdd.setMinimumSize(new java.awt.Dimension(71, 23));
        jButtonAdd.setPreferredSize(new java.awt.Dimension(71, 23));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 90, 30));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Search:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 80, 30));

        jComboBoxPurchaser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPurchaser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxPurchaserItemStateChanged(evt);
            }
        });
        jComboBoxPurchaser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxPurchaserPropertyChange(evt);
            }
        });
        jPanel2.add(jComboBoxPurchaser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 300, 30));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setMaximumSize(new java.awt.Dimension(3602, 102));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(3602, 102));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(3602, 102));

        jPanel4.setMaximumSize(new java.awt.Dimension(2600, 100));
        jPanel4.setMinimumSize(new java.awt.Dimension(2600, 100));
        jPanel4.setPreferredSize(new java.awt.Dimension(2600, 100));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setMaximumSize(new java.awt.Dimension(1600, 402));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1600, 402));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1600, 402));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jScrollPane2.setViewportView(jPanel4);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1090, 380));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Purchaser:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, 30));

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1146, 568));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        JDialogAddNewBooks newBook = new JDialogAddNewBooks(jframeSLM, true, "Add Books");
        newBook.setVisible(true);
        setBook(newBook.getBook());
        displayAuthor(newBook.getAuthorList());
        setAuthorArrayList(newBook.getAuthorList());
        if (newBook.getBook() == null) {
            return;
        }
        if ((getBook().getPublisher().getId() < 1) || (getBook().getCallNoLine1().getId() < 1) || (getBook().getGenre().getId() < 1) || (getBook().getIsbn().isEmpty()) || (getBook().getTitle().isEmpty()) || (getBook().getAuthorList() == null) || (getBook().getPublisher().getName().isEmpty()) || (getBook().getDescription().isEmpty()) || (getBook().getNotes().isEmpty()) || (getBook().getSubjects().isEmpty()) || (getBook().getQuantity() < 1) || (getBook().getPrice() < 1) || (getBook().getUrl().isEmpty()) || (getBook().getCallNoLine1().getDescription().isEmpty()) || (getBook().getCallNoLine2().isEmpty()) || (getBook().getCallNoLine3().isEmpty()) || (getBook().getCallNoLine4().isEmpty()) || (getBook().getGenre().getGenre().isEmpty())) {
            JOptionPane.showMessageDialog(jframeSLM, "Invalid input is not allowed!!", "Warring input!!!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (jTable1.getRowCount() == 0) {
            tableModel.addRow(new Object[]{getBook().getPublisher().getId(), getBook().getCallNoLine1().getId(), getBook().getGenre().getId(), getBook().getIsbn(), getBook().getTitle(), getAuthorList(), getBook().getPublisher().getName(), getBook().getDescription(), getBook().getNotes(), getBook().getSubjects(), getBook().getQuantity(), getBook().getPrice(), getBook().getUrl(), getBook().getCallNoLine1().getDescription() + " - " + getBook().getCallNoLine1().getDescription(), getBook().getCallNoLine2(), getBook().getCallNoLine3(), getBook().getCallNoLine4(), getBook().getGenre().getGenre(), getAuthorArrayList()});
        } else {
            tableModel.addRow(new Object[]{getBook().getPublisher().getId(), getBook().getCallNoLine1().getId(), getBook().getGenre().getId(), getBook().getIsbn(), getBook().getTitle(), getAuthorList(), getBook().getPublisher().getName(), getBook().getDescription(), getBook().getNotes(), getBook().getSubjects(), getBook().getQuantity(), getBook().getPrice(), getBook().getUrl(), getBook().getCallNoLine1().getDescription() + " - " + getBook().getCallNoLine1().getDescription(), getBook().getCallNoLine2(), getBook().getCallNoLine3(), getBook().getCallNoLine4(), getBook().getGenre().getGenre(), getAuthorArrayList()});
        }
        setAuthorList("");
        if (tableModel.getRowCount() > 0) {
            jButtonRemove.setEnabled(true);
            jButtonSave.setEnabled(true);
        }

    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Object al = jTable1.getValueAt(i, 18);
            ArrayList<Author> aa = (ArrayList<Author>) al;
            for (Author a : aa) {
                System.out.println("Firstname:" + a.getId());
                System.out.println("Firstname:" + a.getLastname());
            }
        }
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed

        int response = JOptionPane.showConfirmDialog(jframeSLM, "Are you sure to add this following new books?", "Add new book confirmation!!", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            saveNewBook();
            JOptionPane.showMessageDialog(jframeSLM, "New book successfully added.", "New book added!!", JOptionPane.PLAIN_MESSAGE);
            tableModel.setRowCount(0);
            jComboBoxPurchaser.setSelectedIndex(0);
        }

    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jComboBoxPurchaserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxPurchaserItemStateChanged

        if (0 == jComboBoxPurchaser.getSelectedIndex()) {
            jButtonAdd.setEnabled(false);
        } else {
            jButtonAdd.setEnabled(true);
        }

    }//GEN-LAST:event_jComboBoxPurchaserItemStateChanged

    private void jComboBoxPurchaserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxPurchaserPropertyChange

    }//GEN-LAST:event_jComboBoxPurchaserPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<Object> jComboBoxPurchaser;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField14;
    // End of variables declaration//GEN-END:variables
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
                    return String.class;
                case 6:
                    return String.class;
                case 7:
                    return String.class;
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
                "PublisherId",//
                "Call No Line1 Id",//1
                "Genre",//2
                "ISBN",//3
                "Title",//4
                "Author",//5
                "Publisher",//6
                "Description",//7
                "Notes",//8
                "Subjects",//9
                "Qty",//10
                "Price",//11
                "URL",//12
                "Line 1",//13 
                "Line 2",//14 
                "Line 3",//15 
                "Line 4",//16 
                "Genre",//17
                "Author ArrayList"//18

            };//15

            jTable1 = new javax.swing.JTable(tableModel);
            JTableHeader header = jTable1.getTableHeader();
            header.setPreferredSize(new Dimension(100, 25));
            header.setFont(new Font("Courier New", Font.PLAIN, 14));
            header.setBackground(new java.awt.Color(153, 153, 153));
            jTable1.setRowSorter(sorter);
            jTable1.addMouseListener(this);
            jTable1.setRowHeight(30);
            jTable1.setFont(new Font("Courier New", Font.PLAIN, 14));
//            jTable1.setCellSelectionEnabled(true);
            jTable1.setFocusable(false);
            for (int i = 0; i < columnNames.length;) {
                tableModel.addColumn(columnNames[i]);
                i++;
            }

            jScrollPane1.setViewportView(jTable1);

            TableColumn[] column = new TableColumn[100];

            column[0] = jTable1.getColumnModel().getColumn(0);
            column[0].setPreferredWidth(40);

            column[1] = jTable1.getColumnModel().getColumn(1);
            column[1].setPreferredWidth(50);

            column[2] = jTable1.getColumnModel().getColumn(2);
            column[2].setPreferredWidth(90);
            //ISBN
            column[3] = jTable1.getColumnModel().getColumn(3);
            column[3].setPreferredWidth(120);
            //Title
            column[4] = jTable1.getColumnModel().getColumn(4);
            column[4].setPreferredWidth(300);
            //Author
            column[5] = jTable1.getColumnModel().getColumn(5);
            column[5].setPreferredWidth(500);
            //Publisher
            column[6] = jTable1.getColumnModel().getColumn(6);
            column[6].setPreferredWidth(120);
            //Description
            column[7] = jTable1.getColumnModel().getColumn(7);
            column[7].setPreferredWidth(140);
            //Notes
            column[8] = jTable1.getColumnModel().getColumn(8);
            column[8].setPreferredWidth(140);
            //Subjects
            column[9] = jTable1.getColumnModel().getColumn(9);
            column[9].setPreferredWidth(140);
            //Quantity
            column[10] = jTable1.getColumnModel().getColumn(10);
            column[10].setPreferredWidth(140);
            //Price
            column[11] = jTable1.getColumnModel().getColumn(11);
            column[11].setPreferredWidth(140);
            //URL
            column[12] = jTable1.getColumnModel().getColumn(12);
            column[12].setPreferredWidth(140);
            //Line 1
            column[13] = jTable1.getColumnModel().getColumn(13);
            column[13].setPreferredWidth(240);
            //Line 2
            column[14] = jTable1.getColumnModel().getColumn(14);
            column[14].setPreferredWidth(140);
            //Line 3
            column[15] = jTable1.getColumnModel().getColumn(15);
            column[15].setPreferredWidth(140);
            //Line 4
            column[16] = jTable1.getColumnModel().getColumn(16);
            column[16].setPreferredWidth(140);
            //Genre
            column[17] = jTable1.getColumnModel().getColumn(17);
            column[17].setPreferredWidth(240);

            TableColumn hidden1 = jTable1.getColumnModel().getColumn(0);
            hidden1.setMinWidth(0);
            hidden1.setPreferredWidth(0);
            hidden1.setMaxWidth(0);
            TableColumn hidden2 = jTable1.getColumnModel().getColumn(1);
            hidden2.setMinWidth(0);
            hidden2.setPreferredWidth(0);
            hidden2.setMaxWidth(0);
            TableColumn hidden3 = jTable1.getColumnModel().getColumn(2);
            hidden3.setMinWidth(0);
            hidden3.setPreferredWidth(0);
            hidden3.setMaxWidth(0);
            TableColumn hidden4 = jTable1.getColumnModel().getColumn(18);
            hidden4.setMinWidth(0);
            hidden4.setPreferredWidth(0);
            hidden4.setMaxWidth(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jTable1) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (e.getClickCount() == 1) {
                    int row = jTable1.getSelectedRow();
                    if (row != -1) {
                        if (tableModel.getRowCount() < 0) {
                        } else {
                        }

                    }
                }
            }

        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    private void comboPurchaser() {
        this.jComboBoxPurchaser.removeAllItems();
        jComboBoxPurchaser.addItem("");
        query.purchaserComboBox();
        for (ComboBoxList a : query.getList()) {
            this.jComboBoxPurchaser.addItem(a);
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

    private void displayAuthor(ArrayList<Author> author) {
        try {
            Integer nAuthor = null;
            setAuthorList("[");
            if (author.size() < 0) {
                return;
            } else {
                nAuthor = author.size();
            }
            for (Author a : author) {
                if (nAuthor != 0) {
                    setAuthorList(getAuthorList() + "(" + a.getLastname() + ", " + a.getFirstname() + " " + a.getMiddlename().substring(0, 1) + "." + ")");
                    if (nAuthor > 1) {
                        setAuthorList(getAuthorList() + ", ");
                    }

                } else {
                    setAuthorList(getAuthorList() + "(" + a.getLastname() + ", " + a.getFirstname() + " " + a.getMiddlename().substring(0, 1) + "." + ")");
                }
                nAuthor--;
            }
            setAuthorList(getAuthorList() + "]");
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    private void saveNewBook() {
        try {
            //Add Recieve Book
            BookRecieve bookrecieve = new BookRecieve();
            if (jComboBoxPurchaser.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(jframeSLM, "No selected purchaser.", "Please try again!!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            ComboBoxList purchaserIdl = (ComboBoxList) this.jComboBoxPurchaser.getSelectedItem();
            purchaser.setId(Integer.parseInt(purchaserIdl.getId()));

            bookrecieve.setPurchaser(purchaser);
            bookrecieve.setUser(new LoginUser().getUser());
            new lms.util.QueryLMS().addRecieveBook(bookrecieve);
            bookrecieve.setId(new QueryLMS().getRecieveBooksMaxId());
            

            //Add Book
            for (int i = 0; i < jTable1.getRowCount(); i++) {

                Integer publisherId = (Integer) jTable1.getValueAt(i, 0);
                Integer callNoL1 = (Integer) jTable1.getValueAt(i, 1);
                Integer genderId = (Integer) jTable1.getValueAt(i, 2);
                String isbn = (String) jTable1.getValueAt(i, 3);
                String title = (String) jTable1.getValueAt(i, 4);
                String description = (String) jTable1.getValueAt(i, 7);
                String notes = (String) jTable1.getValueAt(i, 8);
                String subject = (String) jTable1.getValueAt(i, 9);
                Integer qty = (Integer) jTable1.getValueAt(i, 10);
                Float price = (Float) jTable1.getValueAt(i, 11);
                String url = (String) jTable1.getValueAt(i, 12);
                String line2 = (String) jTable1.getValueAt(i, 14);
                String line3 = (String) jTable1.getValueAt(i, 15);
                String line4 = (String) jTable1.getValueAt(i, 16);
                publisher.setId(publisherId);
                callNoLine1.setId(callNoL1);
                genre.setId(genderId);
                book.setPublisher(publisher);
                book.setCallNoLine1(callNoLine1);
                book.setGenre(genre);
                book.setIsbn(isbn);
                book.setTitle(title);
                book.setDescription(description);
                book.setNotes(notes);
                book.setSubjects(subject);
                book.setQuantity(qty);
                book.setPrice(price);
                book.setUrl(url);
                book.setCallNoLine2(line2);
                book.setCallNoLine3(line3);
                book.setCallNoLine4(line4);
                book.setBookRecieve(bookrecieve);
//                for (Integer n = 0; n < qty; n++) {
                new QueryLMS().addBook(book);
//                    System.out.println("");
//                }

                //Add Authors to each Book
                lms.model.BookAuthor bookAuthor = new lms.model.BookAuthor();
                ArrayList<Author> aa;
                Book b = new Book();
                Object al = jTable1.getValueAt(i, 18);
                aa = (ArrayList<Author>) al;
                b.setId(query.selectBookMaxId());
                for (Author a : aa) {
                    bookAuthor.setAuthor(a);
                    bookAuthor.setBook(b);
                    new QueryLMS().addBookAuthor(bookAuthor);
                }

            }

//            System.out.println("ISBN:" + getBook().getIsbn());
//            System.out.println("Publisher:" + getBook().getPublisher().getId());
//            System.out.println("Call Number L1:" + getBook().getCallNoLine1().getId());
//            System.out.println("Genre:" + getBook().getGenre().getId());
//            for (Author author : getBook().getAuthorList()) {
//                System.out.println("Author:" + author.getId());
//                System.out.println("Lastname:" + author.getLastname());
//                System.out.println("Firstname:" + author.getFirstname());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the authorList
     */
    public static String getAuthorList() {
        return authorList;
    }

    /**
     * @param aAuthorList the authorList to set
     */
    public static void setAuthorList(String aAuthorList) {
        authorList = aAuthorList;
    }

    private void addBookRecieved() {
        //addbook
//    private Integer id;
//    private String isbn;
//    private String title;
//    private ArrayList<Author> authorList;
//    private Publisher publisher;
//    private String description;
//    private String notes;
//    private String subjects;
//    private Integer quantity;
//    private Float price;
//    private String url;
//    private CallNumberLine1 callNoLine1;
//    private String callNoLine2;
//    private String callNoLine3;
//    private String callNoLine4;
//    private Genre genre; 
        for (int i = 0; i < jTable1.getRowCount(); i++) {

        }
        //add book-author

    }

    /**
     * @return the authorArrayList
     */
    public ArrayList<Author> getAuthorArrayList() {
        return authorArrayList;
    }

    /**
     * @param authorArrayList the authorArrayList to set
     */
    public void setAuthorArrayList(ArrayList<Author> authorArrayList) {
        this.authorArrayList = authorArrayList;
    }

}
