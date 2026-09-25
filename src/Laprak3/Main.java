package Laprak3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalScore = 0;
        int passedCount = 0;
        int failedCount = 0;
        
        // Langkah 2: Input Data
        System.out.print("Masukkan jumlah siswa: ");
        int totalStudents = scanner.nextInt();
        scanner.nextLine(); 

        // Membuat array dari objek Student
        Student[] students = new Student[totalStudents];

        // Loop untuk input data setiap siswa
        for (int i = 0; i < totalStudents; i++) {
            System.out.println("\nData siswa ke-" + (i + 1) + ":");
            System.out.print("Masukkan nama: ");
            String name = scanner.nextLine();
            
            System.out.print("Masukkan nilai: ");
            double score = scanner.nextDouble();
            scanner.nextLine(); 

            // objek Student disimpan di array
            students[i] = new Student(name, score);
            
            // Mengecek status kelulusan via method checkPassed()
            students[i].checkPassed();

            // Langkah 3: Kondisional untuk menampilkan status kelulusan 
            String status;
            if (students[i].passed == true) {
                status = "Lulus";
            } else {
                status = "Tidak Lulus";
            }
            System.out.println("--> Siswa bernama " + students[i].name + 
                    " dengan nilai " + students[i].score + " dinyatakan " + status);
        }

        // Langkah 4: Hitung Rata-rata dan Jumlah Status Kelulusan
        for (int i = 0; i < totalStudents; i++) {
            totalScore += students[i].score;
            if (students[i].passed) {
                passedCount++;
            } else {
                failedCount++;
            }
        }
        
        double averageScore = totalScore / totalStudents;

        // Menampilkan Ringkasan Output
        System.out.println();
        System.out.printf("Rata-rata nilai kelas: %.2f\n", averageScore);
        System.out.println("Jumlah siswa lulus: " + passedCount);
        System.out.println("Jumlah siswa tidak lulus: " + failedCount);

        scanner.close();
    }
}
