import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PelangganManager {
    public static void tambahPelanggan(Pelanggan pelanggan) {
        String sql = "INSERT INTO pelanggan (nama, alamat, no_telepon) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pelanggan.getNama());
            pstmt.setString(2, pelanggan.getAlamat());
            pstmt.setString(3, pelanggan.getNoTelepon());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editPelanggan(Pelanggan pelanggan) {
        String sql = "UPDATE pelanggan SET nama = ?, alamat = ?, no_telepon = ? WHERE id_pelanggan = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pelanggan.getNama());
            pstmt.setString(2, pelanggan.getAlamat());
            pstmt.setString(3, pelanggan.getNoTelepon());
            pstmt.setInt(4, pelanggan.getIdPelanggan());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void hapusPelanggan(int idPelanggan) {
        String sql = "DELETE FROM pelanggan WHERE id_pelanggan = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPelanggan);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Pelanggan getPelangganById(int idPelanggan) {
        String sql = "SELECT * FROM pelanggan WHERE id_pelanggan = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPelanggan);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setIdPelanggan(rs.getInt("id_pelanggan"));
                pelanggan.setNama(rs.getString("nama"));
                pelanggan.setAlamat(rs.getString("alamat"));
                pelanggan.setNoTelepon(rs.getString("no_telepon"));
                return pelanggan;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
