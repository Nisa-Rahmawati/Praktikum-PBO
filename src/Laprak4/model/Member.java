/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laprak4.model;

import java.util.ArrayList;

public class Member {

    private String id;
    private String nama;
    private ArrayList<Book> daftarPinjaman;

    public Member(String id, String nama) {
        this.id = id;
        this.nama = nama;
        this.daftarPinjaman = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public ArrayList<Book> getDaftarPinjaman() {
        return daftarPinjaman;
    }

    public void tambahPinjaman(Book book) {
        daftarPinjaman.add(book);
    }

    public void hapusPinjaman(Book book) {
        daftarPinjaman.remove(book);
    }

    public int jumlahPinjaman() {
        return daftarPinjaman.size();
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", Nama: " + nama
                + ", Jumlah Pinjaman: " + daftarPinjaman.size();
    }
}

