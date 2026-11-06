/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LabSession2;

/**
 * SUBCLASS 2 (extends Hewan, implements BisaBergerak).
 */
public class Burung extends Hewan implements BisaBergerak {

    private int panjangSayap; // dalam cm

    public Burung(String nama, int umur, int panjangSayap) {
        super(nama, umur);
        this.panjangSayap = panjangSayap;
    }

    public int getPanjangSayap() {
        return panjangSayap;
    }

    public void setPanjangSayap(int panjangSayap) {
        this.panjangSayap = panjangSayap;
    }

    @Override
    public String suara() {
        return "Cuit cuit!";
    }

    @Override
    public void bergerak() {
        System.out.println(getNama() + " terbang dengan sayap " + panjangSayap + " cm.");
    }

    @Override
    public String info() {
        return super.info() + ", Panjang sayap: " + panjangSayap + " cm";
    }
}

