import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransaksiView extends JFrame {
    private JTextField txtIdTransaksi;
    private JTextField txtIdPelanggan;
    private JTextField txtIdMenu;
    private JTextField txtJumlahPesanan;
    private JTextField txtTotalHarga;
    private JTextField txtTanggalTransaksi;
    private JButton btnTambah;
    private JButton btnEdit;
    private JButton btnHapus;
    private JButton btnKembali;

    public TransaksiView(JFrame parent) {
        setTitle("Manajemen Transaksi");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtIdTransaksi = new JTextField();
        txtIdPelanggan = new JTextField();
        txtIdMenu = new JTextField();
        txtJumlahPesanan = new JTextField();
        txtTotalHarga = new JTextField();
        txtTanggalTransaksi = new JTextField();
        btnTambah = new JButton("Tambah");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnKembali = new JButton("Kembali");

        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahTransaksi();
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editTransaksi();
            }
        });

        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusTransaksi();
            }
        });

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                dispose();
            }
        });

        setLayout(new GridLayout(8, 2));
        add(new JLabel("ID Transaksi:"));
        add(txtIdTransaksi);
        add(new JLabel("ID Pelanggan:"));
        add(txtIdPelanggan);
        add(new JLabel("ID Menu:"));
        add(txtIdMenu);
        add(new JLabel("Jumlah Pesanan:"));
        add(txtJumlahPesanan);
        add(new JLabel("Total Harga:"));
        add(txtTotalHarga);
        add(new JLabel("Tanggal Transaksi:"));
        add(txtTanggalTransaksi);
        add(btnTambah);
        add(btnEdit);
        add(btnHapus);
        add(btnKembali);
    }

    private void tambahTransaksi() {
        int idPelanggan = Integer.parseInt(txtIdPelanggan.getText());
        int idMenu = Integer.parseInt(txtIdMenu.getText());
        int jumlahPesanan = Integer.parseInt(txtJumlahPesanan.getText());
        double totalHarga = Double.parseDouble(txtTotalHarga.getText());
        String tanggalTransaksi = txtTanggalTransaksi.getText();

        Transaksi transaksi = new Transaksi();
        transaksi.setIdPelanggan(idPelanggan);
        transaksi.setIdMenu(idMenu);
        transaksi.setJumlahPesanan(jumlahPesanan);
        transaksi.setTotalHarga(totalHarga);
        transaksi.setTanggalTransaksi(tanggalTransaksi);

        TransaksiManager.tambahTransaksi(transaksi);
        JOptionPane.showMessageDialog(null, "Transaksi berhasil ditambahkan.");
    }

    private void editTransaksi() {
        int idTransaksi = Integer.parseInt(txtIdTransaksi.getText());
        int idPelanggan = Integer.parseInt(txtIdPelanggan.getText());
        int idMenu = Integer.parseInt(txtIdMenu.getText());
        int jumlahPesanan = Integer.parseInt(txtJumlahPesanan.getText());
        double totalHarga = Double.parseDouble(txtTotalHarga.getText());
        String tanggalTransaksi = txtTanggalTransaksi.getText();

        Transaksi transaksi = new Transaksi();
        transaksi.setIdTransaksi(idTransaksi);
        transaksi.setIdPelanggan(idPelanggan);
        transaksi.setIdMenu(idMenu);
        transaksi.setJumlahPesanan(jumlahPesanan);
        transaksi.setTotalHarga(totalHarga);
        transaksi.setTanggalTransaksi(tanggalTransaksi);

        TransaksiManager.editTransaksi(transaksi);
        JOptionPane.showMessageDialog(null, "Transaksi berhasil diubah.");
    }

    private void hapusTransaksi() {
        int idTransaksi = Integer.parseInt(txtIdTransaksi.getText());

        TransaksiManager.hapusTransaksi(idTransaksi);
        JOptionPane.showMessageDialog(null, "Transaksi berhasil dihapus.");
    }
}
