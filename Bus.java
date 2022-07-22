/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.*;
import javax.swing.JOptionPane;
import static project.Project.busList;

public class Bus implements Serializable {
    private static final int seats = 10; // Info
    private static int availableBus = 5; // Info
    private int busNo;
    private String route;
    private int timeDepart;
    private int reservedSeats;
    private int availableSeats;
    Search search = new Search();
    
    Bus(int busNo, String route, int timeDepart) {
        this.busNo = busNo;
        this.route = route;
        this.timeDepart = timeDepart;
    }
    
    String getRouteName() {
        return route;
    }
    
    int getBusNo() {
        return busNo;
    }
    
    int getTimeDepart() {
        return timeDepart;
    }
    
    String getTimeDepartString() {
        return Integer.toString(timeDepart);
    }
    
    void createBus() throws IOException {
         Routes curRoute;
         if (search.isRouteAvailable(route) == false) {
             JOptionPane.showMessageDialog(null, "This route doesn't exist", null, JOptionPane.ERROR_MESSAGE);
             return;
         }
         if (busNo > 5) {
             JOptionPane.showMessageDialog(null, "There are only 5 buses available", null, JOptionPane.ERROR_MESSAGE);
             return;
         }
         if(timeDepart > 11) {
             JOptionPane.showMessageDialog(null, "Departure time should be between 6 am - 11 pm", null, JOptionPane.ERROR_MESSAGE);
             return;
         }
         if (busList.size() > 0) {
             for (int i = 0; i < busList.size(); i++) {
                 Bus curBus = busList.get(i);
                 if (curBus.getBusNo() == busNo) {
                     JOptionPane.showMessageDialog(null, "This bus is already reserved", null, JOptionPane.ERROR_MESSAGE);
                     return;
                 }
                 if (curBus.getRouteName().equals(route)) {
                     JOptionPane.showMessageDialog(null, "This routes is already reserevd to another bus", null, JOptionPane.ERROR_MESSAGE);
                     return;
                 }
             }
         }
         busList.add(this);
         JOptionPane.showMessageDialog(null, "Bus was assigned to route successfully");
         BusFunctions.saveBusToFile();
    }
}