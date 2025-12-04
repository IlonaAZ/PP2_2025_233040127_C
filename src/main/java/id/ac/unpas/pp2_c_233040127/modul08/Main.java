/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040127.modul08;

import id.ac.unpas.pp2_c_233040127.modul08.controller.PersegiPanjangController;
import id.ac.unpas.pp2_c_233040127.modul08.model.PersegiPanjangModel;
import id.ac.unpas.pp2_c_233040127.modul08.view.PersegiPanjangView;

/**
 *
 * @author Lenovo
 */
public class Main {
    public static void main (String[] args){
        //1. instansiasi Model
        PersegiPanjangModel model = new PersegiPanjangModel();
        
        //2.instansiasi View
        PersegiPanjangView view = new PersegiPanjangView ();
        
        //3.Instansiasi Controller (Hubungkan Model & View)
        PersegiPanjangController controller = new PersegiPanjangController(model, view);
        
        //4.Tampilkan view
        view.setVisible (true);
    }
}
