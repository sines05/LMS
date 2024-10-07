package lms;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import lms.gui.JFrameLogin;

public class LMS {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Sử dụng Look and Feel mặc định của hệ thống
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Hiển thị cửa sổ đăng nhập
                JFrameLogin login = new JFrameLogin();
                login.setVisible(true);
            }
        });
    }
}