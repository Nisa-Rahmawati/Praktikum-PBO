/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LabSession2;

/**
 * SUBCLASS 3 (extends Hewan, implements BisaBergerak).
 */
public class Ikan extends Hewan implements BisaBergerak {

    private String jenisAir; // air tawar / air laut

    public Ikan(String nama, int umur, String jenisAir) {
        super(nama, umur);
        this.jenisAir = jenisAir;
    }

    public String getJenisAir() {
        return jenisAir;
    }

    public void setJenisAir(String jenisAir) {
        this.jenisAir = jenisAir;
    }

    @Override
    public String suara() {
        return "Blub blub!";
    }

    @Override
    public void bergerak() {
        System.out.println(getNama() + " berenang di " + jenisAir + ".");
    }

    @Override
    public String info() {
        return super.info() + ", Habitat: " + jenisAir;
    }
}
