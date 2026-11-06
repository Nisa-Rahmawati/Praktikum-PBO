# Lab Session 2: Program Kebun Binatang Mini

## 📌 Deskripsi Program

Program ini merupakan aplikasi Java sederhana dengan studi kasus **kebun binatang mini**. Program digunakan untuk membuat beberapa hewan (kucing, burung, dan ikan), menampilkan informasi setiap hewan, menampilkan suara hewan, menampilkan cara hewan bergerak, serta menampilkan berbagai cara hewan makan.

Program dibuat untuk menerapkan konsep Pemrograman Berorientasi Objek (OOP), yaitu **Encapsulation, Inheritance, Polymorphism, Abstract Class, dan Interface**.

## ⚙️ Fitur Program

Program memiliki beberapa fitur, yaitu:

- Membuat objek hewan (`Kucing`, `Burung`, dan `Ikan`).
- Mengubah umur hewan melalui setter dengan validasi (umur tidak boleh negatif).
- Menampilkan informasi setiap hewan.
- Menampilkan suara setiap hewan.
- Menampilkan cara setiap hewan bergerak.
- Menampilkan cara makan hewan dengan tiga bentuk method `makan()`.
- Menyimpan beberapa objek hewan ke dalam array bertipe `Hewan` dan memprosesnya dengan perulangan.

## 📁 Struktur Berkas

Program terdiri dari lima class dan satu interface:

### `BisaBergerak.java`

Interface `BisaBergerak` digunakan sebagai kontrak untuk hewan yang dapat bergerak.

Method yang digunakan:

- `bergerak()` : method tanpa isi yang wajib diisi oleh class yang mengimplementasikannya.

### `Hewan.java`

Class `Hewan` merupakan **abstract class** sekaligus superclass yang menyimpan data umum hewan.

Atribut yang digunakan:

- `nama` : menyimpan nama hewan (`private`).
- `umur` : menyimpan umur hewan (`private`).

Method yang digunakan:

- `getNama()`, `getUmur()` : getter untuk membaca data.
- `setNama()`, `setUmur()` : setter untuk mengubah data (`setUmur()` menolak nilai negatif).
- `suara()` : abstract method yang wajib diisi oleh subclass.
- `makan()`, `makan(String)`, `makan(String, int)` : method overloading.
- `info()` : menampilkan informasi hewan.

### `Kucing.java`

Class `Kucing` merupakan subclass dari `Hewan` dan mengimplementasikan interface `BisaBergerak`.

Atribut tambahan: `warnaBulu`.

Method: `suara()` (mengembalikan "Meong!"), `bergerak()` (berjalan dengan empat kaki), dan `info()` yang di-override untuk menambahkan warna bulu.

### `Burung.java`

Class `Burung` merupakan subclass dari `Hewan` dan mengimplementasikan interface `BisaBergerak`.

Atribut tambahan: `panjangSayap`.

Method: `suara()` (mengembalikan "Cuit cuit!"), `bergerak()` (terbang), dan `info()` yang di-override untuk menambahkan panjang sayap.

### `Ikan.java`

Class `Ikan` merupakan subclass dari `Hewan` dan mengimplementasikan interface `BisaBergerak`.

Atribut tambahan: `jenisAir`.

Method: `suara()` (mengembalikan "Blub blub!"), `bergerak()` (berenang), dan `info()` yang di-override untuk menambahkan habitat.

### `Main.java`

Class `Main` merupakan class utama yang digunakan untuk menjalankan program.

Class ini digunakan untuk membuat objek hewan, mengubah data melalui setter, menyimpan objek ke dalam array `Hewan[]`, memanggil method secara polimorfik, serta mendemonstrasikan method overloading.

## 📋 Penerapan Poin Tugas

| No. | Konsep | Implementasi |
|---|---|---|
| 1 | Encapsulation | Atribut `nama`, `umur`, `warnaBulu`, `panjangSayap`, dan `jenisAir` dibuat `private` dan diakses melalui getter dan setter. `setUmur()` menolak nilai negatif |
| 2 | Inheritance | Class `Kucing`, `Burung`, dan `Ikan` menggunakan `extends Hewan` serta memanggil `super()` pada constructor |
| 3 | Method Overriding | `suara()`, `bergerak()`, dan `info()` ditulis ulang pada subclass menggunakan anotasi `@Override` |
| 4 | Method Overloading | Method `makan()` memiliki tiga bentuk: tanpa parameter, dengan satu parameter `String`, dan dengan parameter `String` dan `int` |
| 5 | Runtime Polymorphism | Objek `Kucing`, `Burung`, dan `Ikan` disimpan dalam array `Hewan[]`, lalu method `suara()` dan `info()` dipanggil sehingga versi milik objek aslinya yang dijalankan |
| 6 | Abstract Class | Class `Hewan` bersifat `abstract` dan memiliki abstract method `suara()` yang diimplementasikan oleh ketiga subclass |
| 7 | Interface | Interface `BisaBergerak` memiliki method `bergerak()` dan diimplementasikan oleh `Kucing`, `Burung`, dan `Ikan` menggunakan `implements` |
| 8 | Ketentuan Tambahan | Program memiliki 5 class (termasuk `Main`) dan 4 objek, yaitu `kucing1`, `burung1`, `ikan1`, dan `kucing2` |

## 💻 Contoh Output

```text
=== Encapsulation ===
Umur Mimi sekarang: 4
Umur tidak valid, perubahan ditolak.
Umur Mimi tetap    : 4

=== Runtime Polymorphism ===
Nama: Mimi, Umur: 4 tahun, Warna bulu: Oranye
Suara: Meong!
Mimi berjalan dengan empat kaki.

Nama: Kenari, Umur: 2 tahun, Panjang sayap: 25 cm
Suara: Cuit cuit!
Kenari terbang dengan sayap 25 cm.

Nama: Nemo, Umur: 1 tahun, Habitat: air laut
Suara: Blub blub!
Nemo berenang di air laut.

Nama: Tom, Umur: 5 tahun, Warna bulu: Abu-abu
Suara: Meong!
Tom berjalan dengan empat kaki.

=== Method Overloading ===
Tom sedang makan.
Kenari sedang makan biji-bijian.
Nemo sedang makan 2 porsi pelet.
```

## 📝 Kesimpulan

Lab Session 2 menggunakan studi kasus kebun binatang mini untuk menerapkan konsep OOP pada Java. Program mencakup penggunaan encapsulation, inheritance, polymorphism (overriding, overloading, dan runtime polymorphism), abstract class, serta interface.
