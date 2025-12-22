/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040127.modul10.TugasModul10;

import id.ac.unpas.pp2_c_233040127.modul10.TugasModul10.controller.MahasiswaAppController;
import id.ac.unpas.pp2_c_233040127.modul10.TugasModul10.view.MahasiswaAppView;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lenovo
 */
public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MahasiswaAppView view = new MahasiswaAppView();
            new MahasiswaAppController(view);
            view.setVisible(true);
        });
    }
}
