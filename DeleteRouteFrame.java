/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static project.Project.routesCollection;


public class DeleteRouteFrame extends JFrame {
    Admin admin = new Admin();
    JFrame frame = new JFrame();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);
    JLabel routeChoose = new JLabel("Route Name: ");
    JComboBox routesNames;
    JButton button = new JButton("Delete Route");
    RouteFunctions routeFunc = new RouteFunctions();

    public DeleteRouteFrame() throws FileNotFoundException {
        routesNames = new JComboBox(routeFunc.returnRoutes().toArray());
        frame.setLayout(layout);
        frame.add(routeChoose);
        frame.add(routesNames);
        frame.add(button);
        
        button.setActionCommand("Delete Route");
        button.addActionListener(new ButtonClickListener());
    }
    
    public void showFrame() {
        frame.setTitle("Route Managment");
        frame.setLocationRelativeTo(null);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
    
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if ("Delete Route".equals(command)) {
                if (routesNames.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "You haven't choosen any route", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String routeSelected = (String) routesNames.getSelectedItem();
                Routes route = new Routes();
                try {
                    if (route.deleteRoute(routeSelected)) {
                        frame.setVisible(false);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "DeleteRouteFrame: ERROR", null, JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DeleteRouteFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
