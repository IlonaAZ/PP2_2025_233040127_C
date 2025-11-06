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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class Latihan2 {
    public static void main(String[] args){
        //1. Buat frame
        JFrame frame = new JFrame("Contoh ActionLayou");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        frame.setLayout(new FlowLayout());
        
        //2. Buat kompenen
        JLabel labelCelcius = new JLabel("Celcius");
        JTextField inputCelcius = new JTextField(10);
        JButton tombolKonversi = new JButton("Konversi");
        JLabel labelFahrenheit = new JLabel("Fahrenheit");
        JLabel labelHasil = new JLabel("");
        
        //3. Tambhkan kompenen ke frame
        frame.add(labelCelcius);
        frame.add(inputCelcius);
        frame.add(tombolKonversi);
        frame.add(labelFahrenheit);
        frame.add(labelHasil);
        
        //4. Tambahkan ActionListener ke tombol
        tombolKonversi.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                 double celcius = Double.parseDouble(inputCelcius.getText());
                 double fahrenheit = (celcius * 9 / 5) + 32;
                 labelHasil.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame,
                            "Input tidak valid! Masukan angka.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
           
        //5. Tampilkan frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
}
