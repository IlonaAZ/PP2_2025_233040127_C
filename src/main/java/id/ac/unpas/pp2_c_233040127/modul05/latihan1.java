/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040127.modul05;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lenovo
 */
public class latihan1 {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Ini Bingkai");
                frame.setSize (400, 300);
                frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                frame.setVisible (true);
            }
        });
   }
}
