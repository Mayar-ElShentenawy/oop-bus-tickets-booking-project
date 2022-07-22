/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class RegisterFrame extends JFrame {
    JFrame frame = new JFrame();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);
    JLabel username = new JLabel("Username: ");
    JTextField usernameText = new JTextField(8);
    JLabel password = new JLabel("Password: ");
    JTextField passwordText = new JTextField(8);
    JLabel email = new JLabel("Email: ");
    JTextField emailText = new JTextField(8);
    JButton register = new JButton("Register");
    
    public RegisterFrame() {
        frame.setLayout(layout);
        frame.add(username);
        frame.add(usernameText);
        frame.add(password);
        frame.add(passwordText);
        frame.add(email);
        frame.add(emailText);
        frame.add(register);
        register.setActionCommand("Register");
        register.addActionListener(new ButtonClickListener());
    }
    
    public void showFrame() {
        frame.setTitle("Register");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(210,230);
        frame.setVisible(true);
        
    }
    
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            UserFunction userFunc = new UserFunction();
            String command = e.getActionCommand();
            if (command == "Register") {
                String uText = usernameText.getText();
                String pText = passwordText.getText();
                String eText = emailText.getName();
                if (uText.isEmpty() || pText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the required fields", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    if (userFunc.userRegister(uText, pText, eText) == true) {
                        frame.setVisible(false);
                        LoginFrame loginF = new LoginFrame();
                        loginF.showFrame();
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "RegisterFrame: ERROR", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
