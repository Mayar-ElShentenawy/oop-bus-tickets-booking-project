/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class AssignRouteFrame extends JFrame {
    JFrame frame = new JFrame();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);
    JLabel busNum = new JLabel("Bus Number: ");
    JTextField busNumF = new JTextField(4);
    JLabel routeName = new JLabel("Route Name: ");
    JTextField routeNameF = new JTextField(6);
    JLabel timeDepart = new JLabel("Time Departrue: ");
    JTextField timeDepartF = new JTextField(4);
    JButton button = new JButton("Assign Route");
    
    public AssignRouteFrame() {
        frame.setLayout(layout);
        frame.add(busNum);
        frame.add(busNumF);
        frame.add(routeName);
        frame.add(routeNameF);
        frame.add(timeDepart);
        frame.add(timeDepartF);
        frame.add(button);
        
        button.setActionCommand("AssignRouteBtn");
        button.addActionListener(new ButtonClickListener());
    }
    
    public void showFrame() throws IOException, FileNotFoundException, ClassNotFoundException {
        frame.setTitle("Route Management");
        frame.setLocationRelativeTo(null);
        frame.setSize(200, 250);
        frame.setVisible(true);
        BusFunctions.loadBuses();
    }
    
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command == "AssignRouteBtn") {
                String busNo = busNumF.getText();
                String route = routeNameF.getText();
                String time = timeDepartF.getText();
                if (busNo.isEmpty() || route.isEmpty() || time.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int busNoInt = Integer.parseInt(busNo);
                int timeInt = Integer.parseInt(time);
                try {
                    Bus busEntered = new Bus(busNoInt, route, timeInt);
                    busEntered.createBus();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "AssignRouteFrame: ERROR in reading file", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
