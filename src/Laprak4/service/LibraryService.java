package Laprak4.service;

import Laprak4.model.Book;
import Laprak4.model.Member;
import Laprak4.exception.BookAlreadyBorrowedException;
import Laprak4.exception.BookNotFoundException;
import Laprak4.exception.BorrowLimitExceededException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LibraryService {

    private ArrayList<Book> daftarBuku;
    private ArrayList<Member> daftarMember;

    // Menyimpan jumlah peminjaman setiap buku
    private HashMap<String, Integer> riwayatPeminjaman;

    // Menyimpan jumlah transaksi peminjaman setiap anggota
    private HashMap<String, Integer> riwayatPeminjamanMember;
    
    // Constructor
    public LibraryService() {
        daftarBuku = new ArrayList<>();
        daftarMember = new ArrayList<>();
        riwayatPeminjaman = new HashMap<>();
        riwayatPeminjamanMember = new HashMap<>();
    }

    // =========================
    // MANAJEMEN BUKU
    // =========================

    // Menambahkan buku
    public void tambahBuku(Book book) {
        daftarBuku.add(book);
        riwayatPeminjaman.put(book.getJudul(), 0);
    }

    // Menampilkan semua buku
    public void tampilkanBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada data buku.");
            return;
        }

        System.out.println("\n===== DAFTAR BUKU =====");

        for (Book book : daftarBuku) {
            System.out.println(book);
        }
    }

    // Mencari buku berdasarkan judul atau kategori
    public void cariBuku(String keyword) {
        boolean ditemukan = false;

        String kataKunci = keyword.toLowerCase();

        System.out.println("\n===== HASIL PENCARIAN =====");

        for (Book book : daftarBuku) {

            String judul = book.getJudul().toLowerCase();
            String kategori = book.getKategori().toLowerCase();

            if (judul.contains(kataKunci)
                    || kategori.contains(kataKunci)) {

                System.out.println(book);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    // =========================
    // MANAJEMEN MEMBER
    // =========================

    // Menambahkan anggota
    public void tambahMember(Member member) {
        daftarMember.add(member);
        riwayatPeminjamanMember.put(member.getId(), 0);
    }

    // Mencari member berdasarkan ID
    public Member cariMember(String id) {

        for (Member member : daftarMember) {

            if (member.getId().equalsIgnoreCase(id)) {
                return member;
            }
        }

        return null;
    }

    // Menampilkan semua anggota
    public void tampilkanMember() {

        if (daftarMember.isEmpty()) {
            System.out.println("Belum ada data anggota.");
            return;
        }

        System.out.println("\n===== DAFTAR ANGGOTA =====");

        for (Member member : daftarMember) {
            System.out.println(member);
        }
    }

    // =========================
    // PEMINJAMAN BUKU
    // =========================

    public void pinjamBuku(String idMember, String judulBuku)
            throws BookNotFoundException,
                   BookAlreadyBorrowedException,
                   BorrowLimitExceededException {

        // Mencari anggota
        Member member = cariMember(idMember);

        // Assertion untuk memastikan data anggota valid
        assert member != null : "Data anggota tidak valid.";

        // Jika assertion tidak aktif, tetap berikan pesan
        if (member == null) {
            System.out.println("Anggota tidak ditemukan.");
            return;
        }

        // Mencari buku
        Book buku = cariBukuByJudul(judulBuku);

        if (buku == null) {
            throw new BookNotFoundException(
                    "Buku dengan judul \"" + judulBuku + "\" tidak ditemukan."
            );
        }

        // Mengecek apakah buku tersedia
        if (!buku.isStatusKetersediaan()) {
            throw new BookAlreadyBorrowedException(
                    "Buku \"" + buku.getJudul() + "\" sedang dipinjam."
            );
        }

        // Maksimal 3 buku
        if (member.jumlahPinjaman() >= 3) {
            throw new BorrowLimitExceededException(
                    "Anggota sudah mencapai batas maksimal 3 buku."
            );
        }

        // Proses peminjaman
        buku.setStatusKetersediaan(false);
        member.tambahPinjaman(buku);

        // Menambah jumlah peminjaman
        int jumlah = riwayatPeminjaman.get(buku.getJudul());
        riwayatPeminjaman.put(buku.getJudul(), jumlah + 1);

        // Menambah riwayat peminjaman anggota
        int jumlahPinjamanMember =
                riwayatPeminjamanMember.get(idMember);

        riwayatPeminjamanMember.put(
                idMember,
                jumlahPinjamanMember + 1
        );
        
        System.out.println(
                "Buku \"" + buku.getJudul()
                + "\" berhasil dipinjam oleh "
                + member.getNama() + "."
        );
    }

    // =========================
    // PENGEMBALIAN BUKU
    // =========================

    public void kembalikanBuku(String idMember, String judulBuku)
            throws BookNotFoundException {

        Member member = cariMember(idMember);

        assert member != null : "Data anggota tidak valid.";

        if (member == null) {
            System.out.println("Anggota tidak ditemukan.");
            return;
        }

        Book buku = cariBukuByJudul(judulBuku);

        if (buku == null) {
            throw new BookNotFoundException(
                    "Buku tidak ditemukan."
            );
        }

        // Mengecek apakah buku benar-benar dipinjam anggota tersebut
        if (!member.getDaftarPinjaman().contains(buku)) {
            System.out.println(
                    "Buku tersebut tidak sedang dipinjam oleh anggota ini."
            );
            return;
        }

        buku.setStatusKetersediaan(true);
        member.hapusPinjaman(buku);

        System.out.println(
                "Buku \"" + buku.getJudul()
                + "\" berhasil dikembalikan."
        );
    }

    // =========================
    // PENCARIAN INTERNAL
    // =========================

    private Book cariBukuByJudul(String judul) {

        for (Book book : daftarBuku) {

            if (book.getJudul().equalsIgnoreCase(judul)) {
                return book;
            }
        }

        return null;
    }

    // =========================
    // ANALISIS PERPUSTAKAAN
    // =========================

    // Menghitung jumlah buku berdasarkan kategori
    public void hitungKategori() {

        HashMap<String, Integer> jumlahKategori = new HashMap<>();

        for (Book book : daftarBuku) {

            String kategori = book.getKategori();

            if (jumlahKategori.containsKey(kategori)) {

                int jumlah = jumlahKategori.get(kategori);
                jumlahKategori.put(kategori, jumlah + 1);

            } else {

                jumlahKategori.put(kategori, 1);
            }
        }

        System.out.println("\n===== JUMLAH BUKU PER KATEGORI =====");

        for (Map.Entry<String, Integer> entry : jumlahKategori.entrySet()) {

            System.out.println(
                    entry.getKey() + " : "
                    + entry.getValue() + " buku"
            );
        }
    }

    // Menentukan buku yang paling sering dipinjam
    public void bukuPalingSeringDipinjam() {

        if (riwayatPeminjaman.isEmpty()) {
            System.out.println("Belum ada data peminjaman.");
            return;
        }

        String bukuTerpopuler = null;
        int jumlahTerbanyak = 0;

        for (Map.Entry<String, Integer> entry
                : riwayatPeminjaman.entrySet()) {

            if (entry.getValue() > jumlahTerbanyak) {

                bukuTerpopuler = entry.getKey();
                jumlahTerbanyak = entry.getValue();
            }
        }

        if (bukuTerpopuler == null || jumlahTerbanyak == 0) {
            System.out.println("Belum ada buku yang pernah dipinjam.");
        } else {
            System.out.println(
                    "Buku paling sering dipinjam : "
                    + bukuTerpopuler
            );

            System.out.println(
                    "Jumlah peminjaman : "
                    + jumlahTerbanyak
            );
        }
    }

    // Menghitung total seluruh transaksi peminjaman
    public int totalPinjaman() {

        int total = 0;

        for (int jumlah : riwayatPeminjaman.values()) {
            total += jumlah;
        }

        return total;
    }

    // Menentukan anggota paling aktif
    public void anggotaPalingAktif() {

        if (riwayatPeminjamanMember.isEmpty()) {
            System.out.println("Belum ada data peminjaman anggota.");
            return;
        }

        String idAnggotaAktif = null;
        int jumlahTerbanyak = 0;

        for (Map.Entry<String, Integer> entry
                : riwayatPeminjamanMember.entrySet()) {

            if (entry.getValue() > jumlahTerbanyak) {

                idAnggotaAktif = entry.getKey();
                jumlahTerbanyak = entry.getValue();
            }
        }

        if (idAnggotaAktif == null || jumlahTerbanyak == 0) {

            System.out.println(
                    "Belum ada anggota yang pernah meminjam buku."
            );

        } else {

            Member anggotaAktif = cariMember(idAnggotaAktif);

            System.out.println(
                    "Anggota paling aktif : "
                    + anggotaAktif.getNama()
            );

            System.out.println(
                    "Total transaksi peminjaman : "
                    + jumlahTerbanyak
            );
        }
    }

    // Menentukan kategori paling populer berdasarkan total peminjaman
    public void kategoriPalingPopuler() {

        HashMap<String, Integer> jumlahKategori = new HashMap<>();

        for (Map.Entry<String, Integer> entry
                : riwayatPeminjaman.entrySet()) {

            String judul = entry.getKey();
            int jumlahPinjam = entry.getValue();

            Book buku = cariBukuByJudul(judul);

            if (buku != null) {

                String kategori = buku.getKategori();

                int jumlahSebelumnya =
                        jumlahKategori.getOrDefault(kategori, 0);

                jumlahKategori.put(
                        kategori,
                        jumlahSebelumnya + jumlahPinjam
                );
            }
        }

        String kategoriPopuler = null;
        int jumlahTerbanyak = 0;

        for (Map.Entry<String, Integer> entry
                : jumlahKategori.entrySet()) {

            if (entry.getValue() > jumlahTerbanyak) {

                kategoriPopuler = entry.getKey();
                jumlahTerbanyak = entry.getValue();
            }
        }

        if (kategoriPopuler == null || jumlahTerbanyak == 0) {

            System.out.println(
                    "Belum ada data peminjaman."
            );

        } else {

            System.out.println(
                    "Kategori paling populer : "
                    + kategoriPopuler
            );

            System.out.println(
                    "Jumlah peminjaman : "
                    + jumlahTerbanyak
            );
        }
    }

    // =========================
    // LAPORAN PERPUSTAKAAN
    // =========================

    public void tampilkanLaporan() {

        System.out.println("\n================================");
        System.out.println("      LAPORAN PERPUSTAKAAN");
        System.out.println("================================");

        System.out.println(
                "Total buku           : "
                + daftarBuku.size()
        );

        System.out.println(
                "Total anggota        : "
                + daftarMember.size()
        );

        System.out.println(
                "Total peminjaman     : "
                + totalPinjaman()
        );

        System.out.println();

        hitungKategori();

        System.out.println();

        bukuPalingSeringDipinjam();

        System.out.println();

        anggotaPalingAktif();

        System.out.println();

        kategoriPalingPopuler();

        System.out.println("================================");
    }
}

