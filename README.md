# Laporan Praktikum Pemrograman Berorientasi Objek

Repositori ini berisi kodingan dan dokumentasi tugas praktikum mata kuliah **Pemrograman Berorientasi Objek (PBO)** menggunakan bahasa pemrograman **Java**.

## 👤 Identitas Praktikan

* **Nama**: Nisa Rahmawati
* **NIM**: L0325032
* **Program Studi**: Informatika
* **Instansi**: Universitas Sebelas Maret

---

## 📚 Daftar Pertemuan & Tugas

| Pertemuan | Topik / Tugas                                  |              Folder              |  Status |
| :-------: | ---------------------------------------------- | :------------------------------: | :-----: |
|     01    | Instalasi dan Eksplorasi Fitur Apache NetBeans |      [Laprak 1](src/Laprak1)     | Selesai |
|     03    | Program Pengelolaan Data Nilai Siswa           |      [Laprak 3](src/Laprak3)     | Selesai |
|     04    | Mini Library Management System                 |      [Laprak 4](src/Laprak4)     | Selesai |
|     05    | Sistem Kasir Toko Nisa Rahmawati               | [Lab Session 1](src/LabSession1) | Selesai |

---

## 🛠️ Cara Menjalankan Kode

1. Buka aplikasi **Apache NetBeans IDE**.
2. Pilih **File → Open Project**.
3. Arahkan ke folder project `PraktikumPBO`.
4. Pilih folder praktikum yang ingin dijalankan.
5. Buka file utama `Main.java` atau `MainApp.java` sesuai program.
6. Klik **Run** atau tekan `F6` untuk menjalankan program.

---

## 📁 Struktur Repository

```text
PraktikumPBO/
│
├── README.md
│
└── src/
    │
    ├── LabSession1/
    │   ├── Barang.java
    │   ├── Main.java
    │   └── README.md
    │
    ├── Laprak1/
    │   ├── Main.java
    │   ├── README.md
    │   └── Smartphone.java
    │
    ├── Laprak3/
    │   ├── Main.java
    │   ├── README.md
    │   └── Student.java
    │
    └── Laprak4/
        ├── README.md
        │
        ├── model/
        │   ├── Book.java
        │   └── Member.java
        │
        ├── service/
        │   └── LibraryService.java
        │
        ├── exception/
        │   ├── BookNotFoundException.java
        │   ├── BookAlreadyBorrowedException.java
        │   └── BorrowLimitExceededException.java
        │
        └── main/
            └── MainApp.java
```

Folder `Laprak4` berisi program **Mini Library Management System** yang menerapkan konsep Pemrograman Berorientasi Objek. Program dibagi ke dalam beberapa package, yaitu:

* **`model`** : berisi class yang merepresentasikan data buku dan anggota.
* **`service`** : berisi class yang menangani proses utama sistem perpustakaan.
* **`exception`** : berisi custom exception untuk menangani kondisi kesalahan pada proses peminjaman.
* **`main`** : berisi class utama untuk menjalankan program.
* **`README.md`** : berisi dokumentasi dan penjelasan mengenai program Laprak4.

---

## 💻 Teknologi

* **Bahasa Pemrograman**: Java
* **IDE**: Apache NetBeans
* **Repository**: GitHub

---

## 📝 Keterangan

Repository ini digunakan untuk menyimpan hasil praktikum, kodingan, dokumentasi, dan perkembangan tugas mata kuliah **Pemrograman Berorientasi Objek**.

Setiap folder praktikum dilengkapi dengan kode program dan `README.md` yang berisi penjelasan mengenai program, konsep yang diterapkan, serta contoh percobaan dan output.
