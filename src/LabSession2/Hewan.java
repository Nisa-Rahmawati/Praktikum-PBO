/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LabSession2;

/**
 * ABSTRACT CLASS + SUPERCLASS.
 * Hewan tidak boleh dibuat objeknya langsung (new Hewan(...) akan error),
 * hanya boleh diwariskan ke subclass (Kucing, Burung, Ikan).
 */
public abstract class Hewan {

    // ENCAPSULATION: atribut dibuat private, hanya bisa diakses lewat getter/setter
    private String nama;
    private int umur;

    // Constructor superclass; akan dipanggil oleh subclass lewat super(...)
    public Hewan(String nama, int umur) {
        this.nama = nama;
        setUmur(umur); // pakai setter supaya validasi umur ikut berjalan
    }

    // ---------- GETTER (membaca data) ----------
    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    // ---------- SETTER (mengubah data dengan aturan) ----------
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        if (umur >= 0) {            // perubahan data dikontrol: umur tidak boleh negatif
            this.umur = umur;
        } else {
            System.out.println("Umur tidak valid, perubahan ditolak.");
        }
    }

    // ABSTRACT METHOD: hanya deklarasi, tanpa isi.
    // Setiap subclass WAJIB mengisinya (karena suara tiap hewan berbeda).
    public abstract String suara();

    // ---------- METHOD OVERLOADING ----------
    // Nama method sama (makan), tetapi parameternya berbeda-beda.
    public void makan() {
        System.out.println(nama + " sedang makan.");
    }

    public void makan(String makanan) {
        System.out.println(nama + " sedang makan " + makanan + ".");
    }

    public void makan(String makanan, int porsi) {
        System.out.println(nama + " sedang makan " + porsi + " porsi " + makanan + ".");
    }

    // Method biasa yang nanti di-override oleh subclass
    public String info() {
        return "Nama: " + nama + ", Umur: " + umur + " tahun";
    }
}
