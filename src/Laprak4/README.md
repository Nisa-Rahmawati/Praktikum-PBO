# Laprak 04 - Mini Library Management System

## 📌 Deskripsi

Program Java sederhana untuk mengelola sistem perpustakaan mini. Program ini memanfaatkan konsep Pemrograman Berorientasi Objek (Class, Object, Method, Package, Constructor, dan Variabel), penggunaan tipe data primitive dan reference, struktur kontrol, exception handling, assertion, serta manipulasi Character dan String.

Program tidak hanya digunakan untuk CRUD data buku, tetapi juga melakukan analisis sederhana terhadap koleksi buku dan aktivitas peminjaman.

---
## 🚀 Fitur Utama

1. **Tambah Buku**
   - Memasukkan judul buku.
   - Memasukkan nama penulis.
   - Memasukkan tahun terbit.
   - Memasukkan kategori buku.

2. **Daftar Buku**
   - Menampilkan seluruh buku yang telah ditambahkan.
   - Menampilkan status ketersediaan buku.

3. **Cari Buku**
   - Mencari buku berdasarkan judul atau kategori.
   - Menggunakan `toLowerCase()` dan `contains()`.

4. **Tambah Anggota**
   - Menambahkan data anggota perpustakaan.
   - Setiap anggota memiliki ID dan nama.

5. **Daftar Anggota**
   - Menampilkan data anggota.
   - Menampilkan jumlah buku yang sedang dipinjam.

6. **Peminjaman Buku**
   - Meminjam buku berdasarkan ID anggota dan judul buku.
   - Buku yang sedang dipinjam tidak dapat dipinjam kembali.
   - Setiap anggota memiliki batas maksimal 3 buku.

7. **Pengembalian Buku**
   - Mengembalikan buku yang sedang dipinjam oleh anggota.

8. **Laporan Perpustakaan**
   - Menampilkan jumlah buku.
   - Menampilkan jumlah anggota.
   - Menampilkan total transaksi peminjaman.
   - Menampilkan jumlah buku berdasarkan kategori.
   - Menampilkan buku yang paling sering dipinjam.
   - Menampilkan anggota yang paling aktif berdasarkan total transaksi peminjaman.
   - Menampilkan kategori yang paling populer.
---
## 📁 Struktur Package

```text
Laprak4
├── model
│   ├── Book.java
│   └── Member.java
├── service
│   └── LibraryService.java
├── exception
│   ├── BookNotFoundException.java
│   ├── BookAlreadyBorrowedException.java
│   └── BorrowLimitExceededException.java
└── main
    └── MainApp.java
```
---
## 📄 Penjelasan Berkas
- `Book.java` : Class yang digunakan untuk menyimpan data buku, yaitu judul, penulis, tahun terbit, kategori, dan status ketersediaan buku.
- `Member.java` : Class yang digunakan untuk menyimpan data anggota berupa ID, nama, dan daftar buku yang sedang dipinjam.
- `LibraryService.java` : Class yang menangani proses utama sistem perpustakaan, seperti menambah buku dan anggota, mencari data, melakukan peminjaman dan pengembalian, serta menghasilkan analisis dan laporan perpustakaan.
- `BookNotFoundException.java` : Custom exception yang digunakan ketika buku yang dicari tidak ditemukan.
- `BookAlreadyBorrowedException.java` : Custom exception yang digunakan ketika buku yang ingin dipinjam sedang dipinjam oleh anggota lain.
- `BorrowLimitExceededException.java` : Custom exception yang digunakan ketika anggota telah mencapai batas maksimal peminjaman, yaitu 3 buku.
- `MainApp.java` : Class utama yang digunakan untuk menjalankan program, menampilkan menu, menerima input menggunakan Scanner, dan memanggil fungsi dari LibraryService.
---
## 🧩 Konsep PBO yang Diterapkan
**1. Class**
   
   Program menggunakan beberapa class, yaitu Book, Member, LibraryService, dan MainApp.
   Class digunakan sebagai cetak biru untuk membuat object dan mengatur data serta perilaku yang dimiliki oleh masing-masing bagian program.

**2. Object**

   Object dibuat berdasarkan class yang telah didefinisikan.

   Contoh:
   ```text
   Book book = new Book(
      judul,
      penulis,
      tahunTerbit,
      kategori
   );
   ```
   Object book merupakan hasil instansiasi dari class Book.

**3. Method**

   Method digunakan untuk menjalankan fungsi tertentu dalam program.

   Contohnya:
   ```text
   tambahBuku()
   tampilkanBuku()
   cariBuku()
   tambahMember()
   pinjamBuku()
   kembalikanBuku()
   tampilkanLaporan()
   ```
**4. Package**

   Package digunakan untuk mengelompokkan class berdasarkan fungsinya agar program lebih terstruktur.

   Program menggunakan:
   ```text
   Laprak4.model
   Laprak4.service
   Laprak4.exception
   Laprak4.main
   ```
**5. Constructor**

   Constructor digunakan untuk memberikan nilai awal ketika object dibuat.

   Contoh pada class Book:
   ```text 
   public Book(String judul, String penulis, int tahunTerbit, String kategori) {
      this.judul = judul;
      this.penulis = penulis;
      this.tahunTerbit = tahunTerbit;
      this.kategori = kategori;
      this.statusKetersediaan = true;
   }
   ```
**6. Encapsulation**

   Encapsulation diterapkan dengan membuat atribut menggunakan access modifier private dan mengaksesnya melalui getter atau setter.

   Contoh:
   ```text
   private String judul;
   private int tahunTerbit;
   private boolean statusKetersediaan;
   ```
   Data tersebut kemudian diakses menggunakan method seperti:
   ```text
   getJudul()
   getTahunTerbit()
   isStatusKetersediaan()
   setStatusKetersediaan()
   ```
**7. ArrayList**

   ArrayList digunakan untuk menyimpan kumpulan data buku dan anggota.
   ```text
   private ArrayList<Book> daftarBuku;
   private ArrayList<Member> daftarMember;
   ```
**8. HashMap**

   HashMap digunakan untuk menyimpan riwayat jumlah peminjaman.
   ```text
   private HashMap<String, Integer> riwayatPeminjaman;
   private HashMap<String, Integer> riwayatPeminjamanMember;
   ```
   riwayatPeminjaman digunakan untuk menghitung jumlah peminjaman setiap buku, sedangkan riwayatPeminjamanMember digunakan untuk menghitung total transaksi peminjaman setiap anggota.

---
## 🧪 Contoh Percobaan Program
Saat program pertama kali dijalankan, akan muncul menu utama.

**Output**
```text
================================
       MINI LIBRARY SYSTEM
================================
1. Tambah Buku
2. Daftar Buku
3. Cari Buku
4. Tambah Anggota
5. Daftar Anggota
6. Pinjam Buku
7. Kembalikan Buku
8. Laporan Perpustakaan
0. Keluar
================================
```
**Percobaan 1 - Menambahkan Buku**

   Pengguna memilih menu 1 kemudian memasukkan data buku.

   Input:
   ```text
   Pilih menu: 1

   ===== TAMBAH BUKU =====
   Judul       : Laskar Pelangi
   Penulis     : Andrea Hirata
   Tahun Terbit: 2005
   Kategori    : Novel
   ```

   Output:
   ```text
   Buku berhasil ditambahkan.
   ```
   Contoh buku lainnya:

   ```text
   Judul       : Clean Code
   Penulis     : Robert Martin
   Tahun Terbit: 2008
   Kategori    : Programming
   Judul       : Atomic Habits
   Penulis     : James Clear
   Tahun Terbit: 2018
   Kategori    : Self Development
   ```

**Percobaan 2 - Menampilkan Daftar Buku**

   Pengguna memilih menu 2.

   Input:
   ```text
   Pilih menu: 2
   ```

   Output:
   ```text
   ===== DAFTAR BUKU =====
   Judul: Laskar Pelangi, Penulis: Andrea Hirata, Tahun: 2005, Kategori: Novel, Status: Tersedia
   Judul: Clean Code, Penulis: Robert Martin, Tahun: 2008, Kategori: Programming, Status: Tersedia
   Judul: Atomic Habits, Penulis: James Clear, Tahun: 2018, Kategori: Self Development, Status: Tersedia
   ```

**Percobaan 3 - Mencari Buku**

   Pencarian dilakukan berdasarkan judul atau kategori.

   Input:
   ```text
   Pilih menu: 3

   ===== CARI BUKU =====
   Masukkan judul atau kategori: programming
   ```
   Output:
   ```text
   ===== HASIL PENCARIAN =====
   Judul: Clean Code, Penulis: Robert Martin, Tahun: 2008, Kategori: Programming, Status: Tersedia
   ```
   Pencarian menggunakan toLowerCase() dan contains() sehingga pencarian tidak bergantung pada penggunaan huruf besar atau kecil.

**Percobaan 4 - Menambahkan Anggota**

   Pengguna memilih menu 4.

   Input:
   ```text
   Pilih menu: 4

   ===== TAMBAH ANGGOTA =====
   ID Anggota : M001
   Nama       : Nisa
   ```
   Output:
   ```text
   Anggota berhasil ditambahkan.
   ```

**Percobaan 5 - Menampilkan Daftar Anggota**

   Pengguna memilih menu 5.

   Input:
   ```text
   Pilih menu: 5
   ```

   Output:
   ```text
   ===== DAFTAR ANGGOTA =====
   ID: M001, Nama: Nisa, Jumlah Pinjaman: 0
   ID: M002, Nama: Budi, Jumlah Pinjaman: 0
   ```

**Percobaan 6 - Peminjaman Buku Berhasil**

   Pengguna memilih menu 6.

   Input:
   ```text
   Pilih menu: 6

   ===== PEMINJAMAN BUKU =====
   ID Anggota : M001
   Judul Buku : Laskar Pelangi
   ```

   Output:
   ```text
   Buku "Laskar Pelangi" berhasil dipinjam oleh Nisa.

   Status buku kemudian berubah menjadi:

   Status: Dipinjam
   ```

**Percobaan 7 - Meminjam Buku yang Sudah Dipinjam**

   Pengguna mencoba meminjam buku yang statusnya sedang dipinjam.

   Input:
   ```text
   Pilih menu: 6

   ===== PEMINJAMAN BUKU =====
   ID Anggota : M002
   Judul Buku : Laskar Pelangi
   ```

   Output:
   ```text
   ERROR: Buku "Laskar Pelangi" sedang dipinjam.
   ```

   Kondisi tersebut ditangani menggunakan BookAlreadyBorrowedException.

**Percobaan 8 - Buku Tidak Ditemukan**

   Pengguna memasukkan judul buku yang tidak terdapat dalam data.

   Input:
   ```text
   Pilih menu: 6

   ===== PEMINJAMAN BUKU =====
   ID Anggota : M001
   Judul Buku : Harry Potter
   ```

   Output:
   ```text
   ERROR: Buku dengan judul "Harry Potter" tidak ditemukan.
   ```

   Kondisi tersebut ditangani menggunakan BookNotFoundException.

**Percobaan 9 - Batas Maksimal Peminjaman**

   Setiap anggota memiliki batas maksimal 3 buku.
   Misalnya anggota M001 telah meminjam:

   Laskar Pelangi
   Clean Code
   Atomic Habits

   Kemudian anggota mencoba meminjam buku keempat.

   Output:
   ```text
   ERROR: Anggota sudah mencapai batas maksimal 3 buku.
   ```

   Kondisi tersebut ditangani menggunakan BorrowLimitExceededException.

**Percobaan 10 - Mengembalikan Buku**

   Pengguna memilih menu 7.

   Input:
   ```text
   Pilih menu: 7

   ===== PENGEMBALIAN BUKU =====
   ID Anggota : M001
   Judul Buku : Laskar Pelangi
   ```

   Output:
   ```text
   Buku "Laskar Pelangi" berhasil dikembalikan.
   ```

   Status buku kembali menjadi:
   ```text
   Status: Tersedia
   ```

**Percobaan 11 - Laporan Perpustakaan**

   Pengguna memilih menu 8.

   Input:
   ```text
   Pilih menu: 8
   ```

   Contoh Output:
   ```text
   ================================
         LAPORAN PERPUSTAKAAN
   ================================
   Total buku           : 3
   Total anggota        : 2
   Total peminjaman     : 4

   ===== JUMLAH BUKU PER KATEGORI =====
   Novel : 1 buku
   Programming : 1 buku
   Self Development : 1 buku

   Buku paling sering dipinjam : Laskar Pelangi
   Jumlah peminjaman : 2

   Anggota paling aktif : Nisa
   Total transaksi peminjaman : 3

   Kategori paling populer : Novel
   Jumlah peminjaman : 2
   ================================
   ```

   Laporan digunakan untuk melihat kondisi koleksi dan aktivitas perpustakaan berdasarkan data yang telah dimasukkan.

---
## 🛠️ Konsep Java yang Digunakan

Program menerapkan beberapa konsep dan fitur Java, yaitu:

- Class dan Object
- Package
- Constructor
- Method
- Variable
- Encapsulation
- Primitive Data Type, seperti int, boolean, dan char
- Reference Data Type, seperti String, ArrayList, HashMap, Book, dan Member
- ArrayList untuk menyimpan data buku, anggota, dan daftar pinjaman
- HashMap untuk menyimpan riwayat peminjaman
- If-Else untuk percabangan kondisi
- Switch-Case untuk pilihan menu
- For Loop untuk melakukan perulangan dan analisis data
- While Loop untuk menjalankan menu program
- Exception Handling menggunakan try-catch
- Custom Exception untuk menangani kondisi kesalahan dalam peminjaman
- Assertion untuk memastikan data anggota valid sebelum transaksi
- Character menggunakan charAt() dan Character.isLetter()
- String Manipulation menggunakan toLowerCase(), contains(), dan equalsIgnoreCase()
- Scanner untuk menerima input dari pengguna
---
## 📌 Kesimpulan

Program Mini Library Management System merupakan implementasi konsep dasar Pemrograman Berorientasi Objek menggunakan bahasa Java. Program dapat digunakan untuk mengelola data buku dan anggota, melakukan pencarian, peminjaman, pengembalian, serta menghasilkan laporan sederhana berdasarkan aktivitas perpustakaan.

Melalui program ini, konsep class, object, constructor, method, package, variable, ArrayList, HashMap, looping, conditional, exception, assertion, character, dan string dapat diterapkan dalam sebuah program yang saling terhubung.