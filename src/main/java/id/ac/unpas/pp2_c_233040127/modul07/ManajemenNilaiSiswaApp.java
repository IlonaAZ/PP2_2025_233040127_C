/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_c_233040127.modul07;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Lenovo
 * 
 */

//Kelas ini digunakan untuk mengelola input dan menampilkan data nilai mahasiswa menggunakan komponen GUI lanjut.
public class ManajemenNilaiSiswaApp extends JFrame {

    // Deklarasi komponen input
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cbMataKuliah;

    // Deklarasi komponen output
    private JTable tableData;
    private DefaultTableModel tableModel;

    // Komponen tab
    private JTabbedPane tabbedPane;

    /**
     * Konstruktor tanpa parameter
     * Digunakan untuk inisialisasi seluruh komponen antarmuka
     */
    public ManajemenNilaiSiswaApp() {
        setTitle("Manajemen Nilai Siswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.add("Input Data", createInputPanel());
        tabbedPane.add("Daftar Nilai", createTablePanel());

        add(tabbedPane);
    }

    /**
     * Method untuk membuat panel input data
     */
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel lblNama = new JLabel("Nama");
        JLabel lblMataKuliah = new JLabel("Mata Kuliah");
        JLabel lblNilai = new JLabel("Nilai");
        

        txtNama = new JTextField();
        txtNilai = new JTextField();

        cbMataKuliah = new JComboBox<>();
        cbMataKuliah.addItem("Matematika Dasar");
        cbMataKuliah.addItem("Bahasa Indonesia");
        cbMataKuliah.addItem("Algoritma dan Pemograman I");
        cbMataKuliah.addItem("Praktikum Pemograman II");

        JButton btnSimpan = new JButton("Simpan Data");
        btnSimpan.addActionListener(e -> prosesSimpan());

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(lblNama);
        panel.add(txtNama);
        panel.add(lblMataKuliah);
        panel.add(cbMataKuliah);
        panel.add(lblNilai);
        panel.add(txtNilai);
        panel.add(new JLabel());
        panel.add(btnSimpan);

        return panel;
    }

    /**
     * Method untuk membuat panel tabel
     */
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] kolom = {"Nama", "Mata Kuliah", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Method untuk memproses dan menyimpan data input
     */
    private void prosesSimpan() {
        String nama = txtNama.getText();
        String strNilai = txtNilai.getText();
        String mataKuliah = cbMataKuliah.getSelectedItem().toString();

        // Validasi jika nama kosong
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!");
            return;
        }

        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!");
            return;
        }

        // Validasi rentang nilai
        if (nilai < 0 || nilai > 100) {
            JOptionPane.showMessageDialog(this, "Nilai harus antara 0 sampai 100!");
            return;
        }

        // Menentukan grade berdasarkan nilai
        String grade;
        if (nilai >= 85) {
            grade = "A";
        } else if (nilai >= 70) {
            grade = "B";
        } else if (nilai >= 55) {
            grade = "C";
        } else if (nilai >= 40) {
            grade = "D";
        } else {
            grade = "E";
        }

        // Menambahkan data ke dalam tabel
        Object[] data = {nama, mataKuliah, nilai, grade};
        tableModel.addRow(data);

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");
        tabbedPane.setSelectedIndex(1); // Pindah ke tab Daftar Nilai
    }

    /**
     * Method main untuk menjalankan aplikasi
     */
    public static void main(String[] args) {
        new ManajemenNilaiSiswaApp().setVisible(true);
    }
}

