/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.*;
import javax.swing.JOptionPane;
import static project.Project.routeCollection;
import static project.Project.routesCollection;


/** Route Name ( File Name):
 * Pickup Destination
 * Pickup Destination
 * Drop off Destination
 * Drop off Destination
 * Drop off Destination
 * Drop off Destination
 */
public class Routes {
    String[] routePoints = new String[6];
    RouteFunctions routeFunc = new RouteFunctions();
    Search search = new Search();
    
    public String[] getDestinationPoints(String routeName) throws IOException {
        String[] destinationPoints = new String[4];
        if (search.isRouteAvailable(routeName) == true) {
            File file = new File(routeName + ".txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String route;
            int count = 2;
            while( (route = br.readLine()) != null && count < 6) {
                destinationPoints[count] = route;
                ++count;
            }
            fr.close();
            br.close();
        }
        return destinationPoints;
    }
    
        public String[] getPickupPoints(String routeName) throws FileNotFoundException, IOException {
        String[] pickupPoints = new String[2];
        if (search.isRouteAvailable(routeName) == true) {
            File file = new File(routeName + ".txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String route;
            int count = 0;
            while( (route = br.readLine()) != null && count < 2) {
                pickupPoints[count] = route;
                ++count;
            }
            fr.close();
            br.close();
        }
        return pickupPoints;
    }
        
    public void createRoute(String route, String[] points) throws FileNotFoundException, IOException, ClassNotFoundException {
        if (search.isRouteAvailable(route) == true) {
            JOptionPane.showMessageDialog(null, "This route already exists!", null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Route was created successfully");
        routeCollection.add(route);
        routeFunc.createRouteFile(route, points);
        routeFunc.saveRoutesToFile();
    }
    
    public boolean deleteRoute(String routeName) throws FileNotFoundException, IOException, ClassNotFoundException {
        if (search.isRouteAvailable(routeName) == true) {
            routeCollection.remove(routeName);
            routeFunc.saveRoutesToFile();
            return true;
        }
        return false;
    }
}
