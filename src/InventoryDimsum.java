import java.sql.*;
import java.util.ArrayList;

public class InventoryDimsum implements InventoryActions {

    @Override
    public void insertDimsum(Connection conn, Dimsum dimsum) {
       String sql = "INSERT INTO dimsum VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dimsum.getIdProduk());
            stmt.setString(2, dimsum.getNamaProduk());
            stmt.setDouble(3, dimsum.getHarga());
            stmt.setString(4, dimsum.getJenisDimsum());
            stmt.setInt(5, dimsum.getStok());
            stmt.setDate(6, Date.valueOf(dimsum.getTanggalInput()));

            stmt.executeUpdate();
            System.out.println("Data dimsum berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println("Gagal insert data: " + e.getMessage());
        }
    }

    @Override
    public void getAllDimsum(Connection conn) {
        String sql = "SELECT * FROM dimsum";
        ArrayList<Dimsum> listDimsum = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dimsum d = new Dimsum(
                        rs.getString("id_produk"),
                        rs.getString("nama_produk"),
                        rs.getDouble("harga"),
                        rs.getString("jenis_dimsum"),
                        rs.getInt("stok")
                );
                listDimsum.add(d);
            }

           for (Dimsum d : listDimsum) {
                System.out.println("ID Produk        : " + d.getIdProduk());
                System.out.println("Nama Produk      : " + d.getNamaProduk());
                System.out.println("Harga            : " + d.getHarga());
                System.out.println("Jenis Dimsum     : " + d.getJenisDimsum());
                System.out.println("Stok             : " + d.getStok());
                System.out.println("Tanggal Input    : " + d.getTanggalInput());
                System.out.println("Total Nilai Stok : " + d.hitungTotalNilaiStok());
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data: " + e.getMessage());
        }
    }

    @Override
    public void updateStokDimsum(Connection conn, String idProduk, int stokBaru) {
        String sql = "UPDATE dimsum SET stok = ? WHERE id_produk = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, stokBaru);
            stmt.setString(2, idProduk);

            stmt.executeUpdate();
            System.out.println("Stok berhasil diperbarui.");
        } catch (SQLException e) {
            System.out.println("Gagal update stok: " + e.getMessage());
        }
    }

    @Override
    public void deleteDimsum(Connection conn, String idProduk) {
        String sql = "DELETE FROM dimsum WHERE id_produk = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idProduk);
            stmt.executeUpdate();
            System.out.println("Data dimsum berhasil dihapus.");
        } catch (SQLException e) {
            System.out.println("Gagal hapus data: " + e.getMessage());
        }
    }
}
