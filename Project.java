/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.util.ArrayList;


public class Project {
        static ArrayList<Bus> busList = new ArrayList<>(5);
        static ArrayList<User> userList = new ArrayList<>();
        public static ArrayList<String> routeCollection = new ArrayList<>();
        public static ArrayList<Routes> routesCollection = new ArrayList<>();

        
    public static void main(String[] args) {
        // TODO code application logic here
        LoginFrame loginframe = new LoginFrame();
        loginframe.showFrame();
    }
}
