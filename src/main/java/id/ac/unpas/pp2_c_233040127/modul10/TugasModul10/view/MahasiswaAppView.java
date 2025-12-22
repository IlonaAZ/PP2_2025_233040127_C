/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040127.modul10.TugasModul10.view;

import id.ac.unpas.pp2_c_233040127.modul10.TugasModul10.controller.MahasiswaAppController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Lenovo
 */
public class MahasiswaAppView extends JFrame {
    JTextField txtNama, txtNim, txtJurusan, txtCari;
    JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    JTable tableMahasiswa;
    DefaultTableModel model;

    public MahasiswaAppView() {
        setTitle("Aplikasi CRUD Mahasiswa JDBC");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        /* ================= PANEL FORM ================= */
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);

        panelForm.add(new JLabel("NIM:"));
        txtNim = new JTextField();
        panelForm.add(txtNim);

        panelForm.add(new JLabel("Jurusan:"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);

        /* ================= PANEL TOMBOL ================= */
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");

        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

        /* ================= PANEL CARI ================= */
        JPanel panelCari = new JPanel();
        panelCari.setLayout(new BoxLayout(panelCari, BoxLayout.Y_AXIS));
        panelCari.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JLabel lblCari = new JLabel("Cari Data Mahasiswa");
        lblCari.setFont(new Font("Arial", Font.BOLD, 14));
        lblCari.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCari.add(lblCari);

        JPanel panelCariBaris = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panelCariBaris.add(new JLabel("Cari Nama:"));
        txtCari = new JTextField(20);
        panelCariBaris.add(txtCari);

        btnCari = new JButton("Cari");
        panelCariBaris.add(btnCari);

        panelCari.add(panelCariBaris);

        /* ================= PANEL ATAS ================= */
        JPanel panelAtas = new JPanel();
        panelAtas.setLayout(new BoxLayout(panelAtas, BoxLayout.Y_AXIS));
        panelAtas.add(panelForm);
        panelAtas.add(panelTombol);
        panelAtas.add(panelCari);

        add(panelAtas, BorderLayout.NORTH);

        /* ================= TABEL ================= */
        model = new DefaultTableModel(
                new Object[]{"No", "Nama", "NIM", "Jurusan"}, 0
        );
        tableMahasiswa = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableMahasiswa);
        add(scrollPane, BorderLayout.CENTER);

        tableMahasiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableMahasiswa.getSelectedRow();
                txtNama.setText(model.getValueAt(row, 1).toString());
                txtNim.setText(model.getValueAt(row, 2).toString());
                txtJurusan.setText(model.getValueAt(row, 3).toString());
            }
        });
    }

    /* ================= GETTER ================= */
    public String getNama() {
        return txtNama.getText();
    }

    public String getNim() {
        return txtNim.getText();
    }

    public String getJurusan() {
        return txtJurusan.getText();
    }

    public String getCari() {
        return txtCari.getText();
    }

    public JButton getBtnSimpan() {
        return btnSimpan;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnHapus() {
        return btnHapus;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public JButton getBtnCari() {
        return btnCari;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void clearForm() {
        txtNama.setText("");
        txtNim.setText("");
        txtJurusan.setText("");
    }

}
