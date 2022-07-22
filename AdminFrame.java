/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;


public class AdminFrame extends JFrame {
    JFrame frame = new JFrame();
    FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 20);
    JButton setAdmin = new JButton("Set Admin");
    JButton addRoute = new JButton("Add Route");
    JButton deleteRoute = new JButton("Delete Route");
    JButton assignRoute = new JButton("Assign Route To Bus");
    JButton routeDetails = new JButton("View Route Details");
    JButton buses = new JButton("View assigned Buses");
    JButton passengerDetails = new JButton("View Passenger Details");
    JButton viewSuggestions = new JButton("View Suggestions"); 
    RouteFunctions routeFunc = new RouteFunctions();
    
    public AdminFrame() {
        frame.setLayout(layout);
        frame.add(addRoute);
        frame.add(deleteRoute);
        frame.add(assignRoute);
        frame.add(routeDetails);
        frame.add(buses);
        frame.add(passengerDetails);
        frame.add(viewSuggestions);
        
        addRoute.setActionCommand("Add Route");
        addRoute.addActionListener(new ButtonClickListener());
        
        deleteRoute.setActionCommand("Delete Route");
        deleteRoute.addActionListener(new ButtonClickListener());
        
        assignRoute.setActionCommand("Assign Route");
        assignRoute.addActionListener(new ButtonClickListener());
        
        routeDetails.setActionCommand("Route Details");
        routeDetails.addActionListener(new ButtonClickListener());
        
        buses.setActionCommand("Assigned Buses");
        buses.addActionListener(new ButtonClickListener());
        
        passengerDetails.setActionCommand("Passenger Details");
        passengerDetails.addActionListener(new ButtonClickListener());
        
        viewSuggestions.setActionCommand("View Suggestions");
        viewSuggestions.addActionListener(new ButtonClickListener());
    }
    
    public void showFrame() throws IOException, FileNotFoundException, ClassNotFoundException {
        frame.setTitle("Admin");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 230);
        frame.setVisible(true);
        routeFunc.loadRoutes();
        BusFunctions.loadBuses();
    }
    
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command == "Add Route") {
                AddRouteFrame adr = new AddRouteFrame();
                adr.showFrame();
            }
            else if (command == "Delete Route") {
                DeleteRouteFrame drf;
                try {
                    drf = new DeleteRouteFrame();
                    drf.showFrame();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "AdminFrameDeleteRouteBtn: ERROR in reading file", null, JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (command == "Assign Route") {
                AssignRouteFrame arf = new AssignRouteFrame();
                try {
                    arf.showFrame();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "AdminFrameAssignRouteBtn: ERROR", null, JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "AdminFrameAssignRouteBtn: ERROR", null, JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (command == "Route Details") {
                viewRouteDetailsFrame vrdf = new viewRouteDetailsFrame();
                vrdf.showFrame();
            }
            else if (command == "View Suggestions") {
                ViewSuggestionsFrame vsf = new ViewSuggestionsFrame();
                try {
                    vsf.showFrame();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "AdminFrameViewSuggestionButton: ERROR in reading file", null, JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (command == "Assigned Buses") {
                ViewAssignedBusesFrame vabf = new ViewAssignedBusesFrame();
                try {
                    vabf.showFrame();
                } catch (IOException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "ViewAssignedBusesFrame: ERROR in reading file", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
