/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.*;
import java.util.ArrayList;
import static project.Project.routeCollection;


public class RouteFunctions {
    Search search = new Search();
    
    public ArrayList<String> returnRoutes() {
        return routeCollection;
    }
     public void createRouteFile(String routeName, String[] points) throws IOException {
        File file = new File(routeName+".txt");
        Writer inFile = new FileWriter(file);
        for (int i = 0; i < 6; i++) {
            inFile.write(points[i]+'\n');
        }
        inFile.close();
    }
    
    public void saveRoutesToFile() throws IOException {
        File file = new File("Routes.txt");
        Writer inFile = new FileWriter(file);
        for (int i = 0; i < routeCollection.size(); i++) {
            String curRoute = routeCollection.get(i);
            inFile.write(curRoute+'\n');
        }
        inFile.close();
    }
    
    public void loadRoutes() throws FileNotFoundException, IOException {
        File routesFile = new File("Routes.txt");
        FileReader fr = new FileReader(routesFile);
        BufferedReader br = new BufferedReader(fr);
        String route;
        while( (route = br.readLine()) != null) {
            routeCollection.add(route);
        }
        fr.close();
        br.close();
    }
}
