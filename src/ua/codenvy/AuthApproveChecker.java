/**
 * ****************************************************************************
 * Copyright (c) 2012-2015 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * <p/>
 * Contributors:
 * Codenvy, S.A. - initial API and implementation
 * *****************************************************************************
 */
package ua.codenvy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * //
 *
 * @author Musienko Maxim
 */
public class AuthApproveChecker {
    private JTextField     userNameField     = new JTextField(15);
    private JPasswordField userPasswordField = new JPasswordField(15);
    private JLabel         userLabel         = new JLabel("Enter user name:");
    private JLabel         passwordLabel     = new JLabel("Enter your password");
    private JButton        btnLogin          = new JButton("Login");
    private JButton btnCancel;
    private JTextArea textArea = new JTextArea(5, 30);
    private JPanel    panel    = new JPanel(new GridBagLayout());
    JScrollPane scroll = new JScrollPane (textArea);

    public void createForm() {
        JFrame frame = new JFrame("JDialog Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(userLabel, constraints);

        constraints.gridx = 1;
        panel.add(userNameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        panel.add(userPasswordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(btnLogin, constraints);
        btnLogin.addActionListener(new PerformButton());


        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.WEST;
        textArea.setMargin(new Insets(5, 5, 5, 5));
        textArea.setEditable(false);
        panel.add(scroll, constraints);

        frame.add(panel);
        frame.setSize(400, 500);
        frame.setVisible(true);

    }


    private class PerformButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LoginChecker lgnCheck = new LoginChecker();
            String responceInfo = lgnCheck.getSession(userNameField.getText(), String.valueOf(userPasswordField.getPassword()), textArea);
            if (!responceInfo.equals("[OK]")) {
                textArea.setForeground(Color.RED);
                textArea.append(responceInfo + "\n");
            } else {
                textArea.setForeground(Color.GREEN);
                textArea.append("authorization success");
            }
        }
    }

}