package LabSession1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Poin 3: Konstanta
    static final String NAMA_TOKO = "TOKO NISA RAHMAWATI";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Poin 8: ArrayList
        ArrayList<Barang> daftarBarang = new ArrayList<>();

        System.out.println("================================");
        System.out.println("       " + NAMA_TOKO);
        System.out.println("================================");

        System.out.print("Jumlah jenis barang: ");
        int banyakBarang = input.nextInt();
        input.nextLine();

        // Poin 5: Looping
        for (int i = 0; i < banyakBarang; i++) {

            System.out.println("\nBarang ke-" + (i + 1));

            System.out.print("Nama barang: ");
            String nama = input.nextLine();

            // Poin 7: String method
            nama = nama.trim();
            nama = nama.toUpperCase();

            int panjangNama = nama.length();

            if (panjangNama < 2) {
                System.out.println("Nama barang terlalu pendek.");
            }

            try {

                System.out.print("Harga " + nama + ": Rp ");
                int harga = input.nextInt();

                System.out.print("Jumlah " + nama + " yang dibeli: ");
                int jumlah = input.nextInt();
                input.nextLine();

                // Poin 9: Membuat object
                Barang barang = new Barang(nama, harga, jumlah);

                daftarBarang.add(barang);

            } catch (Exception e) {

                // Poin 6: Exception Handling
                System.out.println("Input tidak valid!");
                input.nextLine();
            }
        }

        int total = 0;

        System.out.println("\n================================");
        System.out.println("          DAFTAR BELANJA");
        System.out.println("================================");

        // Poin 5: Looping
        for (Barang barang : daftarBarang) {

            barang.tampilkanBarang();
            total += barang.hitungTotal();

            System.out.println("--------------------------------");
        }

        System.out.println("Total belanja : Rp " + total);

        int totalBayar = total;

        System.out.println("Total bayar   : Rp " + totalBayar);

        // Poin 7: Character
        System.out.println("================================");
        System.out.println("Metode pembayaran");
        System.out.print("T(Tunai)/Q(Qris): ");
        char pembayaran = input.nextLine().toUpperCase().charAt(0);

        // Poin 4: Conditional
        if (pembayaran == 'T') {

            System.out.println("Pembayaran      : Tunai");

        } else if (pembayaran == 'Q') {

            System.out.println("Pembayaran      : QRIS");

        } else {

            System.out.println("Pembayaran      : Tidak tersedia");
        }

        System.out.println("\n================================");
        System.out.println("        TERIMA KASIH");
        System.out.println("================================");

        input.close();
    }
}