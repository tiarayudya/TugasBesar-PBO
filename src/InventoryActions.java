import java.sql.Connection;

public interface InventoryActions {
    void insertDimsum(Connection conn, Dimsum dimsum);
    void getAllDimsum(Connection conn);
    void updateStokDimsum(Connection conn, String idProduk, int stokBaru);
    void deleteDimsum(Connection conn, String idProduk);
}
