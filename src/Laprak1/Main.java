package Laprak1;

public class Main {
    public static void main(String[] args) {
        Smartphone hp = new Smartphone();

        hp.setMerk("Samsung");
        hp.setModel("A55");
        hp.setBattery(5000);
        hp.setColor("Black");
        hp.setSize(11);
        hp.setPrice(3000000);

        System.out.println("Merk hp: " +hp.getMerk());
        System.out.println("dengan model: " +hp.getModel());
        System.out.println("dengan kapasitas battery " + hp.getBattery() + "mAh");
        System.out.println("warna " +hp.getColor());
        System.out.println("ukuran sebesar " +hp.getSize());
        System.out.println("hanya seharga Rp." + hp.getPrice());
    }
}
