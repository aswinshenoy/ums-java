package com.rivivo.ums.ui.login;

import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.FileHandler;
import com.rivivo.ums.ui.commons.createForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


class ClickHandler implements ClickEventHandler {
    Login dispatcher;

    public ClickHandler(Login i) {
        dispatcher = i;
    }

    public void handleClick() {
        dispatcher.reset();
    }
}

public class Login {
    JPanel loginWindow;
    ClickEventHandler handler;

    static class LoginForm extends createForm {
        JTextField username;
        JTextField password;

        public LoginForm(ClickEventHandler ch) {
            super(ch);
        }

        public static String getMd5(String input) {
            try {

                MessageDigest md = MessageDigest.getInstance("MD5");

                byte[] messageDigest = md.digest(input.getBytes());

                BigInteger no = new BigInteger(1, messageDigest);

                String hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                return hashtext;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        public static boolean validateLogin(String username, String password) {
            List lines = FileHandler.readFileByLine("./data/admin_credentials.txt");
            HashMap<String, String> accounts = new HashMap<String, String>();
            for (String x : lines.getItems())
                accounts.put(x.split(",")[0], x.split(",")[1]);
            if (accounts.containsKey(username))
                if (accounts.get(username).equals(password))
                    return true;
            return false;
        }

        public JPanel getFormFields() {
            JPanel p = new JPanel();
            p.setLayout(new GridLayout(3, 2, 5, 10));

            p.add(new JLabel("Username: "));
            username = new JTextField();
            p.add(username);

            p.add(new JLabel("Password: "));
            password = new JPasswordField();
            p.add(password);

            return p;
        }

        public JPanel getButtons() {
            JPanel p = new JPanel();
            p.setLayout(new GridLayout(2, 1, 10, 10));
            JButton b2 = new JButton("Login");
            JLabel errorText = new JLabel("");
            errorText.setForeground(Color.RED);
            errorText.setVisible(false);
            p.add(errorText);
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String usernameText = username.getText();
                    String passwordText = getMd5(password.getText());
                    if (!usernameText.isEmpty() && !passwordText.isEmpty())
                        if (validateLogin(usernameText, passwordText))
                            onClick();
                        else {
                            System.err.println("Invalid Username or Password");
                            errorText.setText("Invalid Username or Password");
                            errorText.setVisible(true);
                        }
                    else {
                        System.err.println("Please complete the form.");
                        errorText.setText("Invalid Username or Password");
                        errorText.setVisible(true);
                    }
                }
            });
            p.add(b2);

            return p;
        }

    }

    public Login(ClickEventHandler j) {
        handler = j;
        loginWindow = new JPanel();
    }

    public void reset() {
        handler.handleClick();
    }

    public JPanel getLoginForm() {
        loginWindow.setLayout(new BorderLayout(3, 3));

        Login curr = this;
        ClickHandler ch = new ClickHandler(curr);
        LoginForm l = new LoginForm(ch);

        loginWindow.add(l.getUI("Login"), BorderLayout.CENTER);
        return loginWindow;
    }
}
