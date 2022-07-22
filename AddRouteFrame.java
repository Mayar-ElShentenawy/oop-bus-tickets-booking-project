/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class AddRouteFrame extends JFrame {
    JFrame frame = new JFrame();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);
    JLabel routeNameL = new JLabel("Route Name: ");
    JTextField routeNameF = new JTextField(7);
    JLabel pickupPoint1 = new JLabel("Pickup Point 1: ");
    JTextField pickupF1 = new JTextField(6);
    JLabel pickupPoint2 = new JLabel("Pickup Point 2: ");
    JTextField pickupF2 = new JTextField(6);
    JLabel dest1 = new JLabel("Destination Point 1: ");
    JTextField destF1 = new JTextField(6);
    JLabel dest2 = new JLabel("Destination Point 2: ");
    JTextField destF2 = new JTextField(6);
    JLabel dest3 = new JLabel("Destination Point 3: ");
    JTextField destF3 = new JTextField(6);
    JLabel dest4 = new JLabel("Destination Point 4: ");
    JTextField destF4 = new JTextField(6);
    JButton button = new JButton("Add Route");
    
    public AddRouteFrame() {
        frame.setLayout(layout);
        frame.add(routeNameL);
        frame.add(routeNameF);
        frame.add(pickupPoint1);
        frame.add(pickupF1);
        frame.add(pickupPoint2);
        frame.add(pickupF2);
        frame.add(dest1);
        frame.add(destF1);
        frame.add(dest2);
        frame.add(destF2);
        frame.add(dest3);
        frame.add(destF3);
        frame.add(dest4);
        frame.add(destF4);
        frame.add(button);
        
        button.setActionCommand("AddRouteBtn");
        button.addActionListener(new ButtonClickListener());
    }
    public void showFrame() {
        frame.setTitle("Route Management");
        frame.setLocationRelativeTo(null);
        frame.setSize(230, 400);
        frame.setVisible(true);
    }
    
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command == "AddRouteBtn") {
                //Routes route = new Routes();
                RouteFunctions routeFunc = new RouteFunctions();
                String routeName = routeNameF.getText();
                String[] points = new String[6];
                points[0] = pickupF1.getText();
                points[1] = pickupF2.getText();
                points[2] = destF1.getText();
                points[3] = destF2.getText();
                points[4] = destF3.getText();
                points[5] = destF4.getText();
                if (routeName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                for (int i = 0; i < 6; i++) {
                    if (points[i].isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all of the fields", null, JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                try {
                    Routes route = new Routes();
                    route.createRoute(routeName, points);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "AddRouteFrame: ERROR in reading file", null, JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddRouteFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
