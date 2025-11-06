/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040127.modul06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class ContohMouseListener {
    public static void main(String[] args){
        //1. Buat frame
        JFrame frame = new JFrame("Contoh ActionLayou");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        
        //2. Buat kompenen (Event Source)
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(200, 200));
        
        //3. Buat Event Listener(menggunakan MouseAdapter)
        MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                //saat mouse masuk, ubah warna jadi biru
                panel.setBackground(Color.PINK);
            }
            @Override
            public void mouseExited(MouseEvent e){
                //saat mouse keluar, kembalikan warna
                panel.setBackground(Color.LIGHT_GRAY);
            }
            @Override 
            public void mouseClicked(MouseEvent e){
                //saat diklik, tampilkan koordinat klik
                System.out.println("Mouse dikilik di: x=" + e.getX() + ", y=" + e.getY());
            }
        };
        
        //4. Daftarkan listener ke source
        panel.addMouseListener(adapter);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
