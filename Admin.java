/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

public class viewRouteDetailsFrame extends JFrame {
    RouteFunctions routeFunc = new RouteFunctions();
    Routes route = new Routes();
    JFrame frame = new JFrame();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);
    JLabel routesLabel = new JLabel("Routes Available: ");
    JComboBox routesComboBox;
    JLabel PickupPoint1 = new JLabel("Pickup Point 1: ");
    JTextField pickupPoint1T = new JTextField(6);
    JLabel PickupPoint2 = new JLabel("Pickup Point 2: ");
    JTextField pickupPoint2T = new JTextField(6);
    JLabel destinationPoint1 = new JLabel("Destination Point 1: ");
    JTextField destinationPoint1T = new JTextField(6);
    JLabel destinationPoint2 = new JLabel("Destination Point 2: ");
    JTextField destinationPoint2T = new JTextField(6);
    JLabel destinationPoint3 = new JLabel("Destination Point 3: ");
    JTextField destinationPoint3T = new JTextField(6);
    JLabel destinationPoint4 = new JLabel("Destination Point 4: ");
    JTextField destinationPoint4T = new JTextField(6);
    JButton chooseRoute = new JButton("Select Route");
    
    public viewRouteDetailsFrame() {
        routesComboBox = new JComboBox(routeFunc.returnRoutes().toArray());
        frame.setLayout(layout);
        frame.add(routesLabel);
        frame.add(routesComboBox);
        frame.add(PickupPoint1);
        frame.add(pickupPoint1T);
        frame.add(PickupPoint2);
        frame.add(pickupPoint2T);
        frame.add(destinationPoint1);
        frame.add(destinationPoint1T);
        frame.add(destinationPoint2);
        frame.add(destinationPoint2T);
        frame.add(destinationPoint3);
        frame.add(destinationPoint3T);
        frame.add(destinationPoint4);
        frame.add(destinationPoint4T);
        frame.add(chooseRoute);
        pickupPoint1T.setEditable(false);
        pickupPoint2T.setEditable(false);
        destinationPoint1T.setEditable(false);
        destinationPoint2T.setEditable(false);
        destinationPoint3T.setEditable(false);
        destinationPoint4T.setEditable(false);
        chooseRoute.setActionCommand("SelectRouteBtn");
        chooseRoute.addActionListener(new ButtonClickListener());
    }
    
    public void showFrame() {
        frame.setTitle("Route Details");
        frame.setLocationRelativeTo(null);
        frame.setSize(250, 400);
        frame.setVisible(true);
    }
    
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command == "SelectRouteBtn") {
                if (routesComboBox.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "You haven't choosen any route", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String routeName = (String) routesComboBox.getSelectedItem();
                try {
                    pickupPoint1T.setText(route.getPickupPoints(routeName)[0]);
                    pickupPoint2T.setText(route.getPickupPoints(routeName)[1]);
                    destinationPoint1T.setText(route.getDestinationPoints(routeName)[0]);
                    destinationPoint2T.setText(route.getDestinationPoints(routeName)[1]);
                    destinationPoint3T.setText(route.getDestinationPoints(routeName)[2]);
                    destinationPoint4T.setText(route.getDestinationPoints(routeName)[3]);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "ViewRouteDetailsFrame: ERROR in reading file", null, JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "ViewRouteDetailsFrame: ERROR in reading file", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
