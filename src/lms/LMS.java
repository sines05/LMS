/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import lms.gui.JFrameLogin;

/**
 *
 *
 * @author Aldrin
 */
public class LMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceCeruleanLookAndFeel");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Substance Graphite failed to initialize");
                }
                lms.util.DBConnection c = new lms.util.DBConnection();
                new lms.util.DBConnection().getDBConn();
                if (c.getCon() != null) {
                    JFrameLogin login = new JFrameLogin();
                    login.setVisible(true);
                }

            }
        });

    }

}
