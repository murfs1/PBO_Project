import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManajemenPelanggan extends JFrame {
    private JTextField txtIdPelanggan;
    private JTextField txtNama;
    private JTextField txtAlamat;
    private JTextField txtNoTelepon;
    private JButton btnTambah;
    private JButton btnEdit;
    private JButton btnHapus;
    private JButton btnKembali;

    public ManajemenPelanggan(JFrame parent) {
        setTitle("Manajemen Pelanggan");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtIdPelanggan = new JTextField();
        txtNama = new JTextField();
        txtAlamat = new JTextField();
        txtNoTelepon = new JTextField();
        btnTambah = new JButton("Tambah");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnKembali = new JButton("Kembali");

        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahPelanggan();
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPelanggan();
            }
        });

        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusPelanggan();
            }
        });

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                dispose();
            }
        });

        setLayout(new GridLayout(6, 2));
        add(new JLabel("ID Pelanggan:"));
        add(txtIdPelanggan);
        add(new JLabel("Nama:"));
        add(txtNama);
        add(new JLabel("Alamat:"));
        add(txtAlamat);
        add(new JLabel("No Telepon:"));
        add(txtNoTelepon);
        add(btnTambah);
        add(btnEdit);
        add(btnHapus);
        add(btnKembali);
    }

    private void tambahPelanggan() {
        String nama = txtNama.getText();
        String alamat = txtAlamat.getText();
        String noTelepon = txtNoTelepon.getText();

        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setNoTelepon(noTelepon);

        PelangganManager.tambahPelanggan(pelanggan);
        JOptionPane.showMessageDialog(null, "Pelanggan berhasil ditambahkan.");
    }

    private void editPelanggan() {
        int idPelanggan = Integer.parseInt(txtIdPelanggan.getText());
        String nama = txtNama.getText();
        String alamat = txtAlamat.getText();
        String noTelepon = txtNoTelepon.getText();

        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setIdPelanggan(idPelanggan);
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setNoTelepon(noTelepon);

        PelangganManager.editPelanggan(pelanggan);
        JOptionPane.showMessageDialog(null, "Pelanggan berhasil diubah.");
    }

    private void hapusPelanggan() {
        int idPelanggan = Integer.parseInt(txtIdPelanggan.getText());

        PelangganManager.hapusPelanggan(idPelanggan);
        JOptionPane.showMessageDialog(null, "Pelanggan berhasil dihapus.");
    }
}
