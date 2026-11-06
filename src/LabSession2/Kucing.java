/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LabSession2;

/**
 * SUBCLASS 1.
 * INHERITANCE: "extends Hewan" = Kucing mewarisi atribut & method Hewan.
 * INTERFACE: "implements BisaBergerak" = Kucing wajib punya method bergerak().
 */
public class Kucing extends Hewan implements BisaBergerak {

    private String warnaBulu; // atribut khusus Kucing (private -> encapsulation)

    public Kucing(String nama, int umur, String warnaBulu) {
        super(nama, umur);        // memanggil constructor superclass (Hewan)
        this.warnaBulu = warnaBulu;
    }

    public String getWarnaBulu() {
        return warnaBulu;
    }

    public void setWarnaBulu(String warnaBulu) {
        this.warnaBulu = warnaBulu;
    }

    // METHOD OVERRIDING: mengisi abstract method dari Hewan
    @Override
    public String suara() {
        return "Meong!";
    }

    // Mengisi kontrak dari interface BisaBergerak
    @Override
    public void bergerak() {
        System.out.println(getNama() + " berjalan dengan empat kaki.");
    }

    // METHOD OVERRIDING: mengubah isi method info() milik superclass
    @Override
    public String info() {
        return super.info() + ", Warna bulu: " + warnaBulu; // super.info() = pakai versi induk
    }
}
