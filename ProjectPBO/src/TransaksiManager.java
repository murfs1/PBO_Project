import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransaksiManager {
    public static void tambahTransaksi(Transaksi transaksi) {
        String sql = "INSERT INTO transaksi (id_pelanggan, id_menu, jumlah_pesanan, total_harga, tanggal_transaksi) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, transaksi.getIdPelanggan());
            pstmt.setInt(2, transaksi.getIdMenu());
            pstmt.setInt(3, transaksi.getJumlahPesanan());
            pstmt.setDouble(4, transaksi.getTotalHarga());
            pstmt.setString(5, transaksi.getTanggalTransaksi());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editTransaksi(Transaksi transaksi) {
        String sql = "UPDATE transaksi SET id_pelanggan = ?, id_menu = ?, jumlah_pesanan = ?, total_harga = ?, tanggal_transaksi = ? WHERE id_transaksi = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, transaksi.getIdPelanggan());
            pstmt.setInt(2, transaksi.getIdMenu());
            pstmt.setInt(3, transaksi.getJumlahPesanan());
            pstmt.setDouble(4, transaksi.getTotalHarga());
            pstmt.setString(5, transaksi.getTanggalTransaksi());
            pstmt.setInt(6, transaksi.getIdTransaksi());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void hapusTransaksi(int idTransaksi) {
        String sql = "DELETE FROM transaksi WHERE id_transaksi = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idTransaksi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Transaksi getTransaksiById(int idTransaksi) {
        String sql = "SELECT * FROM transaksi WHERE id_transaksi = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idTransaksi);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getInt("id_transaksi"));
                transaksi.setIdPelanggan(rs.getInt("id_pelanggan"));
                transaksi.setIdMenu(rs.getInt("id_menu"));
                transaksi.setJumlahPesanan(rs.getInt("jumlah_pesanan"));
                transaksi.setTotalHarga(rs.getDouble("total_harga"));
                transaksi.setTanggalTransaksi(rs.getString("tanggal_transaksi"));
                return transaksi;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
