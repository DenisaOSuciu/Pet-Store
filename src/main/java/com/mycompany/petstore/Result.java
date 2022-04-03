/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.petstore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denisasuciu
 */
public final class Result extends javax.swing.JFrame {

    /**
     * Creates new form Result
     */
    public Result()  throws FileNotFoundException, IOException{
        initComponents();
        showResult();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Felicitari!");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 2, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("rasa");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Rasa potrivita pentru dumneavostra este:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3)))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public boolean showResult() throws FileNotFoundException, IOException{
       
        BufferedReader readResult = new BufferedReader(new FileReader("Result.txt"));
        //resultReader citeste "rezultatul" intrebarilor din fisierul result.txt
        
        String result = readResult.readLine();
        //se stocheaza rezultatul in variabila result
        Boolean petfound = false;
        // true cand gasim un match in fisierul de reguli
        BufferedReader readRules;
        //pt a citi din fifieru cu reguli
        
        try
        {
            
            readRules = new BufferedReader(new FileReader("rules.txt"));
            //citim fisierul cu reguli
            String line = readRules.readLine();
            //stocam in line cate o linie 
            
            // While there are still lines to be read
            while (line != null) {
                // atat timp cat linia nu e goala
                
                
                
                String fileName=line.substring(line.lastIndexOf(" "),line.length());
                // luam din line ce e scris dupa untimul spatiu, adica numele rasei
                String rules = "";
                
            char[] chars = fileName.toCharArray();
            String petName="";
            for (int i =0; i < chars.length; i++)
            {
                      if(chars[i]=='_')
                          chars[i]=' ';
                      petName=petName+chars[i];
            }
                
             
                for (int i = 0; i < line.lastIndexOf(" ") ; ++i)
                {
                    //parcurgem fiecare linie, caracter cu caracter pana avem Y sau N
                    if (line.charAt(i) =='Y' || line.charAt(i) == 'N')
                    {
                        //daca avem Y sau N il salvam in S
                        rules = rules + line.charAt(i);
                    }
                }
                if(rules.equals(result))
                {
                    //daca result e egal cu una din variantele din fisier, petfoud e true
                    petfound = true;
                    jLabel2.setText(petName);
                    //afisam numele rasei
                    return true;
                    //returnam true sa iesim din bucla
                    
                }
                else{
                // citim urmatoarea linie
                line = readRules.readLine();
                }
           //     
            //}
              
            }
            
          
            readRules.close();
            // inchidem readRules cand nu mai avem alte linii de citit
            
        
           
        } catch (IOException e1)
        {
            e1.printStackTrace();
        }
       if(petfound == false){
        jLabel2.setText("We couldn't find the perfect pet for you.");}
        return false;
        
        //daca nu s-a gasit nici o rasa, afisam un mesaj
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Result().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
