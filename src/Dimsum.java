import java.time.LocalDate;

public class Dimsum extends Produk {

    private LocalDate tanggalInput;
    private String jenisDimsum;
    private int stok;
    
    // Konstruktor subclass
    public Dimsum(String id, String nama, double harga, String jenis, int stok) {
    super(id, nama, harga);
    this.jenisDimsum = jenis;
    this.stok = stok;
    this.tanggalInput = LocalDate.now();
}
    // Getter
    public LocalDate getTanggalInput() {
    return tanggalInput;
    }
    public String getJenisDimsum() {
        return jenisDimsum;
    }
    public int getStok() {
        return stok;
    }
    public double hitungTotalNilaiStok() {
        return getHarga() * stok;
}
    // Setter
    public void setJenisDimsum(String jenisDimsum) {
        this.jenisDimsum = jenisDimsum;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }
    
}
