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
    private JButton btnLogin;
    private JButton btnCancel;
    private JPanel panel = new JPanel(new BorderLayout());

    public void createForm() {
        JFrame frame = new JFrame("JDialog Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));
        panel.add(userLabel, BorderLayout.NORTH);
        userNameField.setSize(20, 30);
        panel.add(userNameField, BorderLayout.WEST);
        frame.add(panel);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    public String getText() {
        return userNameField.getText();
    }
}
