/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040127.modul10.TugasModul10.controller;

import id.ac.unpas.pp2_c_233040127.modul10.KoneksiDB;
import id.ac.unpas.pp2_c_233040127.modul10.TugasModul10.model.MahasiswaAppModel;
import id.ac.unpas.pp2_c_233040127.modul10.TugasModul10.view.MahasiswaAppView;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author Lenovo
 */
public class MahasiswaAppController {
    private MahasiswaAppView view;

    public MahasiswaAppController(MahasiswaAppView view) {
        this.view = view;

        // Action Listener Tombol
        view.getBtnSimpan().addActionListener(e -> simpan());
        view.getBtnEdit().addActionListener(e -> edit());
        view.getBtnHapus().addActionListener(e -> hapus());
        view.getBtnCari().addActionListener(e -> cari());

        // FIX: Tombol Clear
        view.getBtnClear().addActionListener(e -> clear());

        loadData();
    }

    private void loadData() {
        view.getModel().setRowCount(0);
        try {
            Connection conn = KoneksiDB.configDB();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM mahasiswa");

            int no = 1;
            while (rs.next()) {
                view.getModel().addRow(new Object[]{
                    no++,
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void simpan() {
        if (view.getNama().isEmpty()
                || view.getNim().isEmpty()
                || view.getJurusan().isEmpty()) {

            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
            return;
        }

        try {
            if (cekNIM(view.getNim())) {
                JOptionPane.showMessageDialog(view, "NIM sudah terdaftar!");
                return;
            }

            String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?,?,?)";
            PreparedStatement pst = KoneksiDB.configDB().prepareStatement(sql);
            pst.setString(1, view.getNama());
            pst.setString(2, view.getNim());
            pst.setString(3, view.getJurusan());
            pst.execute();

            JOptionPane.showMessageDialog(view, "Data berhasil disimpan");
            loadData();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void edit() {
        try {
            String sql = "UPDATE mahasiswa SET nama=?, jurusan=? WHERE nim=?";
            PreparedStatement pst = KoneksiDB.configDB().prepareStatement(sql);
            pst.setString(1, view.getNama());
            pst.setString(2, view.getJurusan());
            pst.setString(3, view.getNim());
            pst.execute();

            JOptionPane.showMessageDialog(view, "Data berhasil diubah");
            loadData();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void hapus() {
        try {
            String sql = "DELETE FROM mahasiswa WHERE nim=?";
            PreparedStatement pst = KoneksiDB.configDB().prepareStatement(sql);
            pst.setString(1, view.getNim());
            pst.execute();

            JOptionPane.showMessageDialog(view, "Data berhasil dihapus");
            loadData();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void cari() {
        view.getModel().setRowCount(0);
        try {
            String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
            PreparedStatement pst = KoneksiDB.configDB().prepareStatement(sql);
            pst.setString(1, "%" + view.getCari() + "%");
            ResultSet rs = pst.executeQuery();

            int no = 1;
            while (rs.next()) {
                view.getModel().addRow(new Object[]{
                    no++,
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    // Method Clear (lebih rapi)
    private void clear() {
        view.clearForm();
    }

    private boolean cekNIM(String nim) throws SQLException {
        String sql = "SELECT nim FROM mahasiswa WHERE nim=?";
        PreparedStatement pst = KoneksiDB.configDB().prepareStatement(sql);
        pst.setString(1, nim);
        return pst.executeQuery().next();
    }
}