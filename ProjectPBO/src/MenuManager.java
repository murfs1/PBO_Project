import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuManager {
    public static void tambahMenu(Menu menu) {
        String sql = "INSERT INTO menu (nama_menu, kategori, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, menu.getNamaMenu());
            pstmt.setString(2, menu.getKategori());
            pstmt.setDouble(3, menu.getHarga());
            pstmt.setInt(4, menu.getStok());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editMenu(Menu menu) {
        String sql = "UPDATE menu SET nama_menu = ?, kategori = ?, harga = ?, stok = ? WHERE id_menu = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, menu.getNamaMenu());
            pstmt.setString(2, menu.getKategori());
            pstmt.setDouble(3, menu.getHarga());
            pstmt.setInt(4, menu.getStok());
            pstmt.setInt(5, menu.getIdMenu());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void hapusMenu(int idMenu) {
        String sql = "DELETE FROM menu WHERE id_menu = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idMenu);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Menu getMenuById(int idMenu) {
        String sql = "SELECT * FROM menu WHERE id_menu = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idMenu);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Menu menu = new Menu();
                menu.setIdMenu(rs.getInt("id_menu"));
                menu.setNamaMenu(rs.getString("nama_menu"));
                menu.setKategori(rs.getString("kategori"));
                menu.setHarga(rs.getDouble("harga"));
                menu.setStok(rs.getInt("stok"));
                return menu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
