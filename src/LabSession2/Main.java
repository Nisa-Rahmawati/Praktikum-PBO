
package LabSession2;

/**
 * Class Main = tempat program dijalankan.
 * Tema: Kebun Binatang Mini (Hewan -> Kucing, Burung, Ikan).
 */
public class Main {
    public static void main(String[] args) {

        // ===== 1. MEMBUAT OBJEK (4 objek) =====
        Kucing kucing1 = new Kucing("Mimi", 3, "Oranye");
        Burung burung1 = new Burung("Kenari", 2, 25);
        Ikan ikan1 = new Ikan("Nemo", 1, "air laut");
        Kucing kucing2 = new Kucing("Tom", 5, "Abu-abu");

        // Hewan hewan = new Hewan("X", 1);  // ERROR: abstract class tidak bisa dibuat objeknya

        // ===== 2. ENCAPSULATION =====
        // Data tidak diubah langsung (kucing1.umur = ...), tetapi lewat setter
        System.out.println("=== Encapsulation ===");
        kucing1.setUmur(4);                                   // perubahan valid
        System.out.println("Umur Mimi sekarang: " + kucing1.getUmur());
        kucing1.setUmur(-5);                                  // ditolak oleh setter
        System.out.println("Umur Mimi tetap    : " + kucing1.getUmur());

        // ===== 3. POLYMORPHISM (RUNTIME) =====
        // Array bertipe Hewan (superclass) diisi objek subclass.
        // Saat suara() dipanggil, Java memilih versi milik objek aslinya (Kucing/Burung/Ikan).
        System.out.println("\n=== Runtime Polymorphism ===");
        Hewan[] kebunBinatang = {kucing1, burung1, ikan1, kucing2};

        for (Hewan h : kebunBinatang) {
            System.out.println(h.info());                  // info() hasil override tiap subclass
            System.out.println("Suara: " + h.suara());     // suara() hasil override (abstract method)

            // INTERFACE: semua hewan di sini memenuhi kontrak BisaBergerak
            if (h instanceof BisaBergerak) {
                BisaBergerak pelaku = (BisaBergerak) h;    // referensi bertipe interface
                pelaku.bergerak();
            }
            System.out.println();
        }

        // ===== 4. METHOD OVERLOADING =====
        // Nama method sama (makan), jumlah/jenis parameter berbeda
        System.out.println("=== Method Overloading ===");
        kucing2.makan();                  // tanpa parameter
        burung1.makan("biji-bijian");     // 1 parameter
        ikan1.makan("pelet", 2);          // 2 parameter
    }
}
