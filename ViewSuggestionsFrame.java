/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.BorderLayout;
import java.io.*;
import javax.swing.*;


public class ViewSuggestionsFrame extends JFrame {
    JFrame frame = new JFrame();
    JTextArea suggestions = new JTextArea(300, 300);
    
    public ViewSuggestionsFrame() {
        frame.add(suggestions);
        frame.getContentPane().add(BorderLayout.CENTER, suggestions);
    }
    
    public void showFrame() throws FileNotFoundException {
        frame.setTitle("Suggestions");
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 300);
        frame.setVisible(true);
        readSuggestionFile();
    }
    
    void readSuggestionFile() throws FileNotFoundException {
        File file = new File("suggestions.txt");
        try {
            FileReader reader = new FileReader(file );
            BufferedReader br = new BufferedReader(reader);
            suggestions.read(br, null);
            br.close();
            suggestions.requestFocus();
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
