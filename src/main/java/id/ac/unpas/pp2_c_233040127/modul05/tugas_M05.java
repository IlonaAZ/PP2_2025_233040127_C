/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040127.modul05;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JButton;

/**
 *
 * @author Lenovo
 */
public class tugas_M05 {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize (400, 300);
                frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                
                frame.setLayout(new BorderLayout());
                
                JLabel label = new JLabel ("Label ada di Atas (NORTH)");
      
                JButton buttonsouth = new JButton ("tombol di bawah (SOUTH)");
                JButton buttoncenter = new JButton ("(CENTER)");
                JButton buttonwest = new JButton ("(WEST)");
                JButton buttoneast = new JButton ("(EAST)");
                
                buttonsouth.addActionListener (e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });
                buttonsouth.addActionListener (e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });
                buttoncenter.addActionListener(e -> {
                    label.setText("Tombol CENTER diklik");
                });
                buttonwest.addActionListener(e -> {
                    label.setText("Tombol WEST diklik");
                });
                buttoneast.addActionListener(e -> {
                    label.setText("Tombol EAST diklik");
                });
                
                frame.add(label, BorderLayout.NORTH);
                frame.add(buttonsouth, BorderLayout.SOUTH);
                frame.add(buttoncenter, BorderLayout.CENTER);
                frame.add(buttonwest, BorderLayout.WEST);
                frame.add(buttoneast, BorderLayout.EAST);
                
                frame.setVisible (true);
            }
        });
   }
}
