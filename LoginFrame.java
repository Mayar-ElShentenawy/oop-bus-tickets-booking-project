
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;


public class LoginFrame extends JFrame {
    JFrame frame = new JFrame();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);
    
    JLabel username = new JLabel("Username");
    JTextField usernameText = new JTextField(8);
    
    JLabel password = new JLabel("Password");
    JTextField passwordText = new JTextField(8);
    
    JButton login = new JButton("Login");
    JButton register = new JButton("Register");
    
    public LoginFrame() {
        frame.setLayout(layout);
        
        frame.add(username);
        frame.add(usernameText);
        frame.add(password);
        frame.add(passwordText);
        frame.add(login);
        frame.add(register);
        
        login.setActionCommand("Login");
        login.addActionListener(new ButtonClickListener());
        
        register.setActionCommand("Register");
        register.addActionListener(new ButtonClickListener());
    }
    
    public void showFrame() {
        frame.setTitle("Login");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(210,230);
        frame.setVisible(true);
    }
    
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("Login".equals(command)) {
                String uText = usernameText.getText();
                String pText = passwordText.getText();
                if (uText.isEmpty() || pText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Wrong Username/Password", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                UserFunction userFunc = new UserFunction();
                try {
                    if (userFunc.userLogin(uText, pText) == true) {
                        frame.setVisible(false);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "LoginFrame: ERROR", null, JOptionPane.ERROR_MESSAGE);
                }
            }
            else if ("Register".equals(command)) {
                RegisterFrame rFrame = new RegisterFrame();
                frame.setVisible(false);
                rFrame.showFrame();
            }
        }
    }
}
