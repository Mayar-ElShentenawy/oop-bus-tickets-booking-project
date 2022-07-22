/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

public class ViewAssignedBusesFrame extends JFrame {
    BusFunctions busFunc = new BusFunctions();
    JFrame frame = new JFrame();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);
    JLabel busNumber = new JLabel("Select Bus: ");
    JComboBox busesNos;
    JLabel routeName = new JLabel("Route Name: ");
    JTextField routeNameF = new JTextField(5);
    JLabel timeDepart = new JLabel("Time Departure: ");
    JTextField timeDepartF = new JTextField(5);
    JButton selectBusBtn = new JButton("Select Bus");
    
    public ViewAssignedBusesFrame() {
        busesNos = new JComboBox(busFunc.getAssignedBusesNos());
        frame.setLayout(layout);
        frame.add(busNumber);
        frame.add(busesNos);
        frame.add(routeName);
        frame.add(routeNameF);
        frame.add(timeDepart);
        frame.add(timeDepartF);
        frame.add(selectBusBtn);
        routeNameF.setEditable(false);
        timeDepartF.setEditable(false);
        selectBusBtn.setActionCommand("SelectBusBtn");
        selectBusBtn.addActionListener(new ButtonClickListener());
    }
    
    public void showFrame() throws IOException, FileNotFoundException, ClassNotFoundException {
        frame.setTitle("Bus Details");
        frame.setLocationRelativeTo(null);
        frame.setSize(200, 300);
        frame.setVisible(true);
        BusFunctions.loadBuses();
    }
    
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command == "SelectBusBtn") {
                if (busesNos.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "You haven't choosen any bus", null, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String busNumberSelected = (String) busesNos.getSelectedItem();
                routeNameF.setText(busFunc.getBusRouteName(Integer.parseInt(busNumberSelected)));
                timeDepartF.setText(busFunc.getTimeDeparture(Integer.parseInt(busNumberSelected)));
            }
        }
    }
}
