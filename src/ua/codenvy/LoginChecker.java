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
import java.io.OutputStream;
import java.net.URL;

/**
 * //
 *
 * @author Musienko Maxim
 */
public class LoginChecker {
  public String getSession(String login, String password) {
      HttpsURLConnection connection = null;
      String sessionId ="";
      {
          try {
              String apiUrl = "https://wiki.codenvycorp.com/login.action";
              URL url = new URL(apiUrl);
              connection = (HttpsURLConnection)url.openConnection();
              connection.setRequestMethod("POST");
              connection.setAllowUserInteraction(false);
              connection.setRequestProperty("Content-Type", "text/plain");
              connection.setInstanceFollowRedirects(true);
              connection.setDoOutput(true);
              connection.setDoInput(true);
              OutputStream output = connection.getOutputStream();
              output.write(("os_username="+login+"&os_password="+password+"&login=Log+In&os_destination=").getBytes());
              System.out.println(connection.getResponseCode());
//            if (connection.getResponseCode() != 200) {
//                throw new RuntimeException(
//                        new Exception("Can not stop application using REST API: " + "from workspace " + nameWs + "Name of the app.: " +
//                                      nameApp + "Server response code: " +
//                                      connection.getResponseCode()));
//            }
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              if (connection != null) {
                  connection.disconnect();
              }
          }
      }

      for(String value :connection.getHeaderFields().get("Set-Cookie")){
            sessionId = value;
      }

      return sessionId.split(";")[0];
  }
//
//    public String getkeys(){
//        https://wiki.codenvycorp.com/display/DPP/Installation
//    }

}
