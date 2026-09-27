package Laprak4.main;

import java.util.Scanner;

import Laprak4.model.Book;
import Laprak4.model.Member;
import Laprak4.service.LibraryService;
import Laprak4.exception.BookNotFoundException;
import Laprak4.exception.BookAlreadyBorrowedException;
import Laprak4.exception.BorrowLimitExceededException;

public class MainApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        LibraryService library = new LibraryService();

        boolean berjalan = true;

        while (berjalan) {

            tampilkanMenu();

            System.out.print("Pilih menu: ");
            String pilihan = input.nextLine();

            switch (pilihan) {

                case "1":
                    tambahBuku(input, library);
                    break;

                case "2":
                    library.tampilkanBuku();
                    break;

                case "3":
                    cariBuku(input, library);
                    break;

                case "4":
                    tambahMember(input, library);
                    break;

                case "5":
                    library.tampilkanMember();
                    break;

                case "6":
                    pinjamBuku(input, library);
                    break;

                case "7":
                    kembalikanBuku(input, library);
                    break;

                case "8":
                    library.tampilkanLaporan();
                    break;

                case "0":
                    berjalan = false;
                    System.out.println("\nProgram selesai. Terima kasih!");
                    break;

                default:
                    System.out.println(
                            "\nPilihan menu tidak tersedia."
                    );
            }

            if (berjalan) {
                System.out.println(
                        "\nTekan ENTER untuk melanjutkan..."
                );
                input.nextLine();
            }
        }

        input.close();
    }

    // =========================================
    // MENU UTAMA
    // =========================================

    public static void tampilkanMenu() {

        System.out.println();
        System.out.println("================================");
        System.out.println("       MINI LIBRARY SYSTEM");
        System.out.println("================================");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Daftar Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Tambah Anggota");
        System.out.println("5. Daftar Anggota");
        System.out.println("6. Pinjam Buku");
        System.out.println("7. Kembalikan Buku");
        System.out.println("8. Laporan Perpustakaan");
        System.out.println("0. Keluar");
        System.out.println("================================");
    }

    // =========================================
    // TAMBAH BUKU
    // =========================================

    public static void tambahBuku(
            Scanner input,
            LibraryService library) {

        System.out.println("\n===== TAMBAH BUKU =====");

        System.out.print("Judul       : ");
        String judul = input.nextLine();

        System.out.print("Penulis     : ");
        String penulis = input.nextLine();

        System.out.print("Tahun Terbit: ");
        int tahunTerbit = Integer.parseInt(input.nextLine());

        System.out.print("Kategori    : ");
        String kategori = input.nextLine();

        Book book = new Book(
                judul,
                penulis,
                tahunTerbit,
                kategori
        );

        library.tambahBuku(book);

        System.out.println("Buku berhasil ditambahkan.");
    }

    // =========================================
    // CARI BUKU
    // =========================================

    public static void cariBuku(
            Scanner input,
            LibraryService library) {

        System.out.println("\n===== CARI BUKU =====");

        System.out.print(
                "Masukkan judul atau kategori: "
        );

        String keyword = input.nextLine();

        library.cariBuku(keyword);
    }

    // =========================================
    // TAMBAH MEMBER
    // =========================================

    public static void tambahMember(
            Scanner input,
            LibraryService library) {

        System.out.println("\n===== TAMBAH ANGGOTA =====");

        System.out.print("ID Anggota : ");
        String id = input.nextLine();

        System.out.print("Nama       : ");
        String nama = input.nextLine();

        // Contoh penggunaan Character
        if (!nama.isEmpty()) {

            char karakterPertama = nama.charAt(0);

            if (!Character.isLetter(karakterPertama)) {

                System.out.println(
                        "Nama harus diawali dengan huruf."
                );

                return;
            }
        }

        Member member = new Member(id, nama);

        library.tambahMember(member);

        System.out.println(
                "Anggota berhasil ditambahkan."
        );
    }

    // =========================================
    // PEMINJAMAN
    // =========================================

    public static void pinjamBuku(
            Scanner input,
            LibraryService library) {

        System.out.println("\n===== PEMINJAMAN BUKU =====");

        System.out.print("ID Anggota : ");
        String idMember = input.nextLine();

        System.out.print("Judul Buku : ");
        String judulBuku = input.nextLine();

        try {

            library.pinjamBuku(
                    idMember,
                    judulBuku
            );

        } catch (BookNotFoundException e) {

            System.out.println(
                    "ERROR: " + e.getMessage()
            );

        } catch (BookAlreadyBorrowedException e) {

            System.out.println(
                    "ERROR: " + e.getMessage()
            );

        } catch (BorrowLimitExceededException e) {

            System.out.println(
                    "ERROR: " + e.getMessage()
            );
        }
    }

    // =========================================
    // PENGEMBALIAN
    // =========================================

    public static void kembalikanBuku(
            Scanner input,
            LibraryService library) {

        System.out.println("\n===== PENGEMBALIAN BUKU =====");

        System.out.print("ID Anggota : ");
        String idMember = input.nextLine();

        System.out.print("Judul Buku : ");
        String judulBuku = input.nextLine();

        try {

            library.kembalikanBuku(
                    idMember,
                    judulBuku
            );

        } catch (BookNotFoundException e) {

            System.out.println(
                    "ERROR: " + e.getMessage()
            );
        }
    }


}

