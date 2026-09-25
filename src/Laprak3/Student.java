package Laprak3;

// Langkah 1: Buat Kelas Student
class Student {
    String name;
    double score;
    boolean passed;

    // Constructor untuk mengisi name dan score
    public Student(String name, double score) {
        this.name = name;
        this.score = score;
        this.passed = false; // Nilai awal
    }

    // Method untuk mengecek kelulusan 
    public void checkPassed() {
        if (this.score >= 70) {
            this.passed = true;
        } else {
            this.passed = false;
        }
    }
}

