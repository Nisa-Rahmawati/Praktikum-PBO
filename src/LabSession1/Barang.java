package LabSession1;

public class Barang {

    // Poin 1: Class dan atribut
    String nama;
    int harga;
    int jumlah;

    // Poin 2: Constructor
    public Barang(String nama, int harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    // Poin 1: Method pertama
    public int hitungTotal() {
        return harga * jumlah;
    }

    // Poin 1: Method kedua
    public void tampilkanBarang() {
        System.out.println("Nama   : " + nama);
        System.out.println("Harga  : Rp" + harga);
        System.out.println("Jumlah : " + jumlah);
        System.out.println("Total  : Rp" + hitungTotal());
    }
}