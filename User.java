/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.Serializable;


public class User implements Serializable {
    String username;
    String password;
    String email;
    
    User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
