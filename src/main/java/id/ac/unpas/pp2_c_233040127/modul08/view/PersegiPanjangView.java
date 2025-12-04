package id.ac.unpas.pp2_c_233040127.modul08.view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PersegiPanjangView extends JFrame {

    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);

    private JLabel lblHasilLuas = new JLabel("-");
    private JLabel lblHasilKeliling = new JLabel("-");

    private JButton btnHitung = new JButton("Hitung");
    private JButton btnReset = new JButton("Reset");

    public PersegiPanjangView() {
        setTitle("MVC Kalkulator");
        setSize(380, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Grid utama: 5 baris, 2 kolom
        setLayout(new GridLayout(5, 2, 8, 10));

        add(new JLabel("Panjang"));
        add(txtPanjang);

        add(new JLabel("Lebar"));
        add(txtLebar);

        add(new JLabel("Hasil Luas"));
        add(lblHasilLuas);

        add(new JLabel("Hasil Keliling"));
        add(lblHasilKeliling);

        // Panel tombol: Hitung kiri, Reset kanan
        JPanel panelTombol = new JPanel(new GridLayout(1, 2, 15, 0));
        panelTombol.add(btnHitung);
        panelTombol.add(btnReset);

        // Tambahkan panel tombol ke grid
        add(new JLabel(""));   // placeholder
        add(panelTombol);

        setLocationRelativeTo(null);
    }

    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    public JButton getBtnHitung() {
        return btnHitung;
    }

    public JButton getBtnReset() {
        return btnReset;
    }
    
    public void setHasilLuas(double hasil) {
        lblHasilLuas.setText(String.valueOf(hasil));
    }

    public void setHasilKeliling(double hasil) {
        lblHasilKeliling.setText(String.valueOf(hasil));
    }

    public void resetForm() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasilLuas.setText("-");
        lblHasilKeliling.setText("-");
    }

    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Listener untuk Controller
    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }

    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
}