# Lab Session 1: Sistem Kasir Toko Nisa Rahmawati

## 📌 Deskripsi Program

Program ini merupakan aplikasi Java sederhana dengan studi kasus **sistem kasir toko**. Program digunakan untuk memasukkan beberapa barang yang dibeli, menghitung total harga setiap barang, menghitung total belanja, serta menentukan metode pembayaran.

Program dibuat untuk menerapkan konsep dasar pemrograman Java, yaitu **Class, Object, Constructor, Konstanta, Kondisional, Looping, Exception Handling, Character, String, dan ArrayList**.

## ⚙️ Fitur Program

Program memiliki beberapa fitur, yaitu:

- Memasukkan jumlah jenis barang.
- Memasukkan nama barang.
- Memasukkan harga barang.
- Memasukkan jumlah barang yang dibeli.
- Menghitung total harga setiap barang.
- Menampilkan daftar barang yang dibeli.
- Menghitung total seluruh belanja.
- Memilih metode pembayaran Tunai atau QRIS.
- Menangani input yang tidak valid menggunakan `try-catch`.

## 📁 Struktur Berkas

Program terdiri dari dua class:

### `Barang.java`

Class `Barang` digunakan untuk menyimpan data barang.

Atribut yang digunakan:

- `nama` : menyimpan nama barang.
- `harga` : menyimpan harga barang.
- `jumlah` : menyimpan jumlah barang yang dibeli.

Method yang digunakan:

- `hitungTotal()` : menghitung total harga barang.
- `tampilkanBarang()` : menampilkan informasi barang dan total harga.

### `Main.java`

Class `Main` merupakan class utama yang digunakan untuk menjalankan program.

Class ini digunakan untuk menerima input pengguna, menyimpan data barang ke dalam `ArrayList`, melakukan perulangan, menghitung total belanja, serta menentukan metode pembayaran.

## 📋 Penerapan Poin Tugas

| No. | Konsep | Implementasi |
|---|---|---|
| 1 | Class & Object | Class `Barang` memiliki atribut `nama`, `harga`, `jumlah` serta dua method yaitu `hitungTotal()` dan `tampilkanBarang()` |
| 2 | Constructor | Constructor `Barang()` digunakan untuk menginisialisasi atribut barang |
| 3 | Konstanta | `static final String NAMA_TOKO` digunakan untuk menyimpan nama toko |
| 4 | Kondisional | `if-else` digunakan untuk menentukan metode pembayaran |
| 5 | Looping | `for` digunakan untuk memproses beberapa barang |
| 6 | Exception Handling | `try-catch` digunakan untuk menangani input yang tidak valid |
| 7 | Character & String | `char` digunakan untuk metode pembayaran dan String method `trim()`, `toUpperCase()`, serta `length()` |
| 8 | Array/Collection | `ArrayList<Barang>` digunakan untuk menyimpan beberapa data barang |
| 9 | Object & Output | Object `Barang` dibuat menggunakan `new Barang()` dan hasil program ditampilkan menggunakan `System.out.println()` |

## 💻 Contoh Output

```text
================================
       TOKO NISA RAHMAWATI
================================
Jumlah jenis barang: 2

Barang ke-1
Nama barang: Sabun
Harga SABUN: Rp 5000
Jumlah SABUN yang dibeli: 2

Barang ke-2
Nama barang: Shampoo
Harga SHAMPOO: Rp 12000
Jumlah SHAMPOO yang dibeli: 1

================================
          DAFTAR BELANJA
================================
Nama   : SABUN
Harga  : Rp5000
Jumlah : 2
Total  : Rp10000
--------------------------------
Nama   : SHAMPOO
Harga  : Rp12000
Jumlah : 1
Total  : Rp12000
--------------------------------
Total belanja : Rp22000
Total bayar   : Rp22000

================================
Metode pembayaran (T/Q): T
Pembayaran             : Tunai
================================
        TERIMA KASIH
================================
📝 Kesimpulan

Lab Session 1 menggunakan studi kasus sistem kasir untuk menerapkan konsep dasar pemrograman Java. Program mencakup penggunaan class, object, constructor, konstanta, kondisional, looping, exception handling, character, string, serta ArrayList.