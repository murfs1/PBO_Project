import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManajemenMenu extends JFrame {
    private JTextField txtIdMenu;
    private JTextField txtNamaMenu;
    private JTextField txtKategori;
    private JTextField txtHarga;
    private JTextField txtStok;
    private JButton btnTambah;
    private JButton btnEdit;
    private JButton btnHapus;
    private JButton btnKembali;

    public ManajemenMenu(JFrame parent) {
        setTitle("Manajemen Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtIdMenu = new JTextField();
        txtNamaMenu = new JTextField();
        txtKategori = new JTextField();
        txtHarga = new JTextField();
        txtStok = new JTextField();
        btnTambah = new JButton("Tambah");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnKembali = new JButton("Kembali");

        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahMenu();
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editMenu();
            }
        });

        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusMenu();
            }
        });

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                dispose();
            }
        });

        setLayout(new GridLayout(7, 2));
        add(new JLabel("ID Menu:"));
        add(txtIdMenu);
        add(new JLabel("Nama Menu:"));
        add(txtNamaMenu);
        add(new JLabel("Kategori:"));
        add(txtKategori);
        add(new JLabel("Harga:"));
        add(txtHarga);
        add(new JLabel("Stok:"));
        add(txtStok);
        add(btnTambah);
        add(btnEdit);
        add(btnHapus);
        add(btnKembali);
    }

    private void tambahMenu() {
        String namaMenu = txtNamaMenu.getText();
        String kategori = txtKategori.getText();
        double harga = Double.parseDouble(txtHarga.getText());
        int stok = Integer.parseInt(txtStok.getText());

        Menu menu = new Menu();
        menu.setNamaMenu(namaMenu);
        menu.setKategori(kategori);
        menu.setHarga(harga);
        menu.setStok(stok);

        MenuManager.tambahMenu(menu);
        JOptionPane.showMessageDialog(null, "Menu berhasil ditambahkan.");
    }

    private void editMenu() {
        int idMenu = Integer.parseInt(txtIdMenu.getText());
        String namaMenu = txtNamaMenu.getText();
        String kategori = txtKategori.getText();
        double harga = Double.parseDouble(txtHarga.getText());
        int stok = Integer.parseInt(txtStok.getText());

        Menu menu = new Menu();
        menu.setIdMenu(idMenu);
        menu.setNamaMenu(namaMenu);
        menu.setKategori(kategori);
        menu.setHarga(harga);
        menu.setStok(stok);

        MenuManager.editMenu(menu);
        JOptionPane.showMessageDialog(null, "Menu berhasil diubah.");
    }

    private void hapusMenu() {
        int idMenu = Integer.parseInt(txtIdMenu.getText());

        MenuManager.hapusMenu(idMenu);
        JOptionPane.showMessageDialog(null, "Menu berhasil dihapus.");
    }
}
