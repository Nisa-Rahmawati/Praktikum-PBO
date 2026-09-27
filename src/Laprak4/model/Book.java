package Laprak4.model;


public class Book {

    private String judul;
    private String penulis;
    private int tahunTerbit;
    private String kategori;
    private boolean statusKetersediaan;

    public Book(String judul, String penulis, int tahunTerbit, String kategori) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.kategori = kategori;
        this.statusKetersediaan = true;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public String getKategori() {
        return kategori;
    }

    public boolean isStatusKetersediaan() {
        return statusKetersediaan;
    }

    public void setStatusKetersediaan(boolean statusKetersediaan) {
        this.statusKetersediaan = statusKetersediaan;
    }

    @Override
    public String toString() {
        return "Judul: " + judul
                + ", Penulis: " + penulis
                + ", Tahun: " + tahunTerbit
                + ", Kategori: " + kategori
                + ", Status: " + (statusKetersediaan ? "Tersedia" : "Dipinjam");
    }
}

