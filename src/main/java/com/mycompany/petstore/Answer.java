/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petstore;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
/**
 *
 * @author denisasuciu
 */
public class Answer {
   
    
    public void putStringToFile(String str)
    {
        // Try block to check for exceptions
        try {

            // Writing on output stream
            try ( // Open given file in append mode by creating an
            // object of BufferedWriter class
                BufferedWriter out = new BufferedWriter(new FileWriter("Result.txt", true))) {
                // Writing on output stream
                out.write(str);
                // Closing the connection
            }
        }
        // Catch block to handle the exceptions
        catch (IOException e) {
            // Display message when exception occurs
            System.out.println("Exception occurred" + e);
        }
    }  
}
    

