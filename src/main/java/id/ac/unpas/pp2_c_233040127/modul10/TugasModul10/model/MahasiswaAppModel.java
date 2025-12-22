/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040127.modul10.TugasModul10.model;

import id.ac.unpas.pp2_c_233040127.modul10.TugasModul10.controller.MahasiswaAppController;
import id.ac.unpas.pp2_c_233040127.modul10.TugasModul10.model.MahasiswaAppModel;
import id.ac.unpas.pp2_c_233040127.modul10.TugasModul10.view.MahasiswaAppView;

/**
 *
 * @author Lenovo
 */
public class MahasiswaAppModel {
    private String nama;
    private String nim;
    private String jurusan;

    public MahasiswaAppModel(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getJurusan() {
        return jurusan;
    }
}
