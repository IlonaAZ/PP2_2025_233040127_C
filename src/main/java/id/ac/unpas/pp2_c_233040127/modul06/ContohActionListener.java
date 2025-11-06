/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040127.modul06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Lenovo
 */
public class ContohActionListener {
    public static void main(String[] args) {
        //1. Buat frame
        JFrame frame = new JFrame("Contoh ActionLayou");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
        
        //2. Buat kompenen (Event source dan kompenen lain)
        JLabel label = new JLabel ("Halo, klik tombol di bawah!");
        JButton button = new JButton("Klik saya!");
        
        //3. Buat Event Listener
        //Kita menggunakna "anonymous inner class" di sini
        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //4. Logika yang dieksekusi saat event terjadi
                label.setText("Tombol telah diklil");
            }
        };
        
        //5. Daftarkan listener ke source
        button.addActionListener(listener);
        
        //Tambahkan kompenen ke frame
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }
}
