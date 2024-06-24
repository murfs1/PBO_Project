public class Transaksi {
    private int idTransaksi;
    private int idPelanggan;
    private int idMenu;
    private int jumlahPesanan;
    private double totalHarga;
    private String tanggalTransaksi;

    public Transaksi() {}

    public Transaksi(int idTransaksi, int idPelanggan, int idMenu, int jumlahPesanan, double totalHarga, String tanggalTransaksi) {
        this.idTransaksi = idTransaksi;
        this.idPelanggan = idPelanggan;
        this.idMenu = idMenu;
        this.jumlahPesanan = jumlahPesanan;
        this.totalHarga = totalHarga;
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(int jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }
}
