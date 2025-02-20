import java.util.Scanner;
public class Pemilihan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Program Menghitung Nilai Akhir");
        System.out.println("======================");
        System.out.print("Masukkan nilai tugas: ");
        double tugas = scanner.nextDouble();
        System.out.print("Masukkan nilai kuis: ");
        double kuis = scanner.nextDouble();
        System.out.print("Masukkan nilai UTS: ");
        double uts = scanner.nextDouble();
        System.out.print("Masukkan nilai UAS: ");
        double uas = scanner.nextDouble();
        System.out.println("======================");
        
        System.out.println("======================");
        if (isNilaiValid(tugas) && isNilaiValid(kuis) && isNilaiValid(uts) && isNilaiValid(uas)) {

            double nilaiAkhir = hitungNilaiAkhir(tugas, kuis, uts, uas);
            String nilaiHuruf = konversiNilai(nilaiAkhir);
            String keterangan = (isLulus(nilaiHuruf)) ? "LULUS" : "TIDAK LULUS";

            System.out.printf("Nilai Akhir: %.2f%n", nilaiAkhir);
            System.out.println("Nilai Huruf: " + nilaiHuruf);
            System.out.println("======================");
            System.out.println("======================");
            System.out.println("SELAMAT ANDA LULUS");
            } else {
            System.out.println("nilai tidak valid");
            System.out.println("=================");
        }

        scanner.close();
    }

    private static double hitungNilaiAkhir(double tugas, double kuis, double uts, double uas) {
        return (0.2 * tugas) + (0.2 * kuis) + (0.3 * uts) + (0.4 * uas);
    }

    private static String konversiNilai(double nilaiAkhir) {
        if (nilaiAkhir >= 85) {
            return "A";
        } else if (nilaiAkhir >= 80) {
            return "B+";
        } else if (nilaiAkhir >= 75) {
            return "B";
        } else if (nilaiAkhir >= 65) {
            return "C+";
        } else if (nilaiAkhir >= 50) {
            return "C";
        } else if (nilaiAkhir >= 40) {
            return "D";
        } else {
            return "E";
        }
    }

    private static boolean isNilaiValid(double nilai) {
        return nilai >= 0 && nilai <= 100;
    }


    private static boolean isLulus(String nilaiHuruf) {
        return nilaiHuruf.equals("A") || nilaiHuruf.equals("B+") || nilaiHuruf.equals("B") || 
               nilaiHuruf.equals("C+") || nilaiHuruf.equals("C");
    }
}