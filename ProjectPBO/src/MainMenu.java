import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JButton btnManajemenMenu;
    private JButton btnManajemenPelanggan;
    private JButton btnTransaksi;

    public MainMenu() {
        setTitle("Menu Utama");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnManajemenMenu = new JButton("Manajemen Menu");
        btnManajemenPelanggan = new JButton("Manajemen Pelanggan");
        btnTransaksi = new JButton("Transaksi");

        btnManajemenMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManajemenMenu(MainMenu.this).setVisible(true);
                setVisible(false);
            }
        });

        btnManajemenPelanggan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManajemenPelanggan(MainMenu.this).setVisible(true);
                setVisible(false);
            }
        });

        btnTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransaksiView(MainMenu.this).setVisible(true);
                setVisible(false);
            }
        });

        setLayout(new GridLayout(3, 1));
        add(btnManajemenMenu);
        add(btnManajemenPelanggan);
        add(btnTransaksi);
    }
}
