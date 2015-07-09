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

import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import java.io.OutputStream;
import java.net.URL;

/**
 * //
 *
 * @author Musienko Maxim
 */
public class LoginChecker {


    public String getSession(String login, String password, JTextArea infopanel) {
        HttpsURLConnection connection = null;
        StringBuilder responceData = new StringBuilder();
        {
            try {
                String apiUrl = "https://wiki.codenvycorp.com/login.action";
                URL url = new URL(apiUrl);
                connection = (HttpsURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                connection.setRequestProperty("Connection", "keep-alive");
                connection.setAllowUserInteraction(false);
                connection.setInstanceFollowRedirects(false);
                connection.setDoOutput(true);
                connection.setDoInput(true);
                OutputStream output = connection.getOutputStream();
                output.write(("os_username=" + login + "&os_password=" + password + "&login=Log+In&os_destination=").getBytes());
                if (connection.getResponseCode() != 200 && connection.getResponseCode() != 302) {
                    infopanel.append("Something went wrong after authorized on codenvy wiki page. " + connection.getErrorStream());
                    throw new Exception("Something went wrong after authorized on codenvy wiki page. " + connection.getErrorStream());
                }
            } catch (Exception e) {
                infopanel.append(e.getMessage());
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }
        return connection.getHeaderFields().get("X-Seraph-LoginReason").toString();
    }


}
