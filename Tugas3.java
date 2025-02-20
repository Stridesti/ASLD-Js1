import java.util.Scanner;

public class Tugas3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah mata kuliah: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] namaMataKuliah = new String[n];
        int[] sks = new int[n];
        int[] semester = new int[n];
        String[] hariKuliah = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Mata Kuliah " + (i + 1) + ":");
            System.out.print("Nama Mata Kuliah: ");
            namaMataKuliah[i] = scanner.nextLine();
            System.out.print("SKS: ");
            sks[i] = scanner.nextInt();
            System.out.print("Semester: ");
            semester[i] = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Hari Kuliah: ");
            hariKuliah[i] = scanner.nextLine();
            System.out.println();
        }

        System.out.println("Jadwal Kuliah:");
        System.out.printf("%-30s %-5s %-10s %-10s%n", "Nama Mata Kuliah", "SKS", "Semester", "Hari Kuliah");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-30s %-5d %-10d %-10s%n", namaMataKuliah[i], sks[i], semester[i], hariKuliah[i]);
        }
        scanner.close();
    }
}