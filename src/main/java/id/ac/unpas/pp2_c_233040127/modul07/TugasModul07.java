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
 * @author Fitriyani Rahmadini
 */
public class TugasModul07 extends JFrame {
   
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private JTabbedPane tabbedPane;
    private DefaultTableModel tableModel;
    
    //Method untuk membuat desain Tab Input    
    private JPanel createInputPanel(){
    JPanel panel = new JPanel(new GridLayout(5,2,10,10));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
    //Komponen Nama
    panel.add(new JLabel("Nama Siswa:"));
    txtNama = new JTextField();
    panel.add(txtNama);
    
    //Komponen Mata Pelajaran (Combo Box)
    panel.add(new JLabel("Mata Pelajaran:"));
    String[] matkul = {"Matematika Dasar", "Bahasa Indonesia", 
        "Algoritma dan Pemograman", "Praktikum Pemograman II"};
    cmbMatkul = new JComboBox<>(matkul);
    panel.add(cmbMatkul);
    
    //Komponen Nilai
    panel.add(new JLabel("Nilai (0-100):"));
    txtNilai = new JTextField();
    panel.add(txtNilai);
    
    //Tombol Simpan
    JButton btnSimpan = new JButton("Simpan Data");
    panel.add(new JLabel(""));
    panel.add(btnSimpan);
    
    //Event Handling Tombol Simpan
    btnSimpan.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            prosesSimpan();
        }
    });
    
    //button reset
    JButton btnReset = new JButton("Reset");
    panel.add(new JLabel(""));
    panel.add(btnReset);
    
    //Memanggil fungsi button reset
    btnReset.addActionListener(e -> {
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
    });
    
    return panel;   
}

    //Method untuk membuat desain Tab Tabel
    private JPanel createTablePanel(){
    JPanel panel = new JPanel(new BorderLayout());
    
    //Setup Model Tabel (Kolom)
    String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
    tableModel = new DefaultTableModel(kolom, 0);
    tableData = new JTable(tableModel);
    
    //Membungkus tabel dengan ScrollPane (agar bisa discrol jika data banyak
    JScrollPane scrollPane = new JScrollPane(tableData);
    panel.add(scrollPane, BorderLayout.CENTER);
    
    //button hapus
        JPanel buttonPanel = new JPanel();
        JButton btnHapus = new JButton("Hapus Data");
        buttonPanel.add(btnHapus);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        //memanggil button hapus
        btnHapus.addActionListener(e -> {
             prosesHapus();
        });
        
    return panel;
}
    
    //Logika Validasi dan Penyimpanan Data
    private void prosesSimpan(){
        
        //1. Ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();
        
        //2. VALIDASI INPUT
    
        // validasi 1: Cek apakah nama kosong
        if (nama.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (nama.length() <3){ //nama minimal 3 karakter
            JOptionPane.showMessageDialog(this, "Nama harus minimal 3 karakter",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //validasi 2: Cek apakah nilai berupa angka dan dalam range valid
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai <0 || nilai > 100){
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0-100!",
                        "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Nilai Harus berupa angka!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
    //3. Logika Bisnis (Menentukan Grade)
    //  SWITCH CASE UNTUK GRADE    
    int rangeNilai = nilai / 10;
    String grade;
        
    switch (rangeNilai){
        case 10:
        case 9:
        case 8:
            grade = "A";
            break;
        case 7:
            grade = "AB";
            break;
        case 6:
            grade = "B";
            break;
        case 5:
            grade = "BC";
            break;
        case 4:
            grade = "C";
            break;
        case 3:
            grade = "D";
            break;
        default:
            grade = "E";
            break;
        }
        
        //4. Menentukan ke Tabel (Update Model)
        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);
        
         //5. Reset Form dan Pindah Tab
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
        
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        tabbedPane.setSelectedIndex(1);
    }
    
    private void prosesHapus(){
        int selectedRow = tableData.getSelectedRow();
        
        if (selectedRow > -1){
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        }
        
    }
    
    public TugasModul07(){
        
    //1. Konfigurasi Frame Utama
    setTitle("Aplikasi Manajemen Nilai Siswa");
    setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //2. Inisialisasi Tabbed Pane
        tabbedPane = new JTabbedPane();
        
        //3. Membuat Panel utnuk Tab 1 (Form Input)
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);
    
        //4. Membuat Panel untuk tab 2 (Tabel Data)
        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);
        
        add(tabbedPane);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new TugasModul07().setVisible(true);
        });
    }
}
