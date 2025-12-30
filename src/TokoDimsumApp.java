import java.sql.Connection;
import java.util.Scanner;

public class TokoDimsumApp {

    public static void main(String[] args) {

        Connection conn = DatabaseConnection.getConnection();
        InventoryActions inventory = new InventoryDimsum();
        Scanner input = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU TOKO DIMSUM =====");
            System.out.println("1. Tambah Data Dimsum");
            System.out.println("2. Lihat Data Dimsum");
            System.out.println("3. Update Stok Dimsum");
            System.out.println("4. Hapus Data Dimsum");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan;

            try {
                pilihan = input.nextInt();
                input.nextLine(); // buang enter
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
                continue;
            }

            switch (pilihan) {

                case 1:
                    System.out.print("ID Produk        : ");
                    String id = input.nextLine();

                    System.out.print("Nama Produk      : ");
                    String nama = input.nextLine().toUpperCase();


                    System.out.print("Harga Jual       : ");
                    double harga = input.nextDouble();

                    input.nextLine(); // buang enter

                    System.out.print("Jenis Dimsum     : ");
                    String jenis = input.nextLine().trim();


                    System.out.print("Stok             : ");
                    int stok = input.nextInt();
                    input.nextLine();

                    Dimsum dimsum = new Dimsum(id, nama, harga, jenis, stok);
                    inventory.insertDimsum(conn, dimsum);
                    break;

                case 2:
                    inventory.getAllDimsum(conn);
                    break;

                case 3:
                    System.out.print("Masukkan ID Produk: ");
                    String idUpdate = input.nextLine();

                    System.out.print("Stok Baru        : ");
                    int stokBaru = input.nextInt();
                    input.nextLine();

                    inventory.updateStokDimsum(conn, idUpdate, stokBaru);
                    break;

                case 4:
                    System.out.print("Masukkan ID Produk yang dihapus: ");
                    String idHapus = input.nextLine();

                    inventory.deleteDimsum(conn, idHapus);
                    break;

                case 5:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia!");
            }
        }

        input.close();
    }
}
