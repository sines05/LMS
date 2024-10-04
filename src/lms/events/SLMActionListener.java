/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lms.gui.JFrameMainSLM;

/**
 *
 * @author Aldrin
 */
public class SLMActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Exit")) {
            System.exit(0);

        } else if (command.equals("Close")) {
        } else if (command.equals("Log-in")) {
        }

    }

}
