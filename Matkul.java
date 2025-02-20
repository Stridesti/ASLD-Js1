import java.util.Scanner;

public class Matkul {
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

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tampilkan seluruh jadwal kuliah");
            System.out.println("2. Tampilkan jadwal kuliah berdasarkan hari tertentu");
            System.out.println("3. Tampilkan jadwal kuliah berdasarkan semester tertentu");
            System.out.println("4. Cari mata kuliah berdasarkan nama");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanJadwal(namaMataKuliah, sks, semester, hariKuliah);
                    break;
                case 2:
                    System.out.print("Masukkan hari kuliah (misalnya, Senin, Selasa, dst.): ");
                    String hari = scanner.nextLine();
                    tampilkanJadwalBerdasarkanHari(namaMataKuliah, sks, semester, hariKuliah, hari);
                    break;
                case 3:
                    System.out.print("Masukkan semester: ");
                    int sem = scanner.nextInt();
                    tampilkanJadwalBerdasarkanSemester(namaMataKuliah, sks, semester, hariKuliah, sem);
                    break;
                case 4:
                    System.out.print("Masukkan nama mata kuliah yang dicari: ");
                    String namaDicari = scanner.nextLine();
                    cariMataKuliah(namaMataKuliah, sks, semester, hariKuliah, namaDicari);
                    break;
                case 5:
                    System.out.println("Terima kasih! Program selesai.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }

    public static void tampilkanJadwal(String[] namaMataKuliah, int[] sks, int[] semester, String[] hariKuliah) {
        System.out.println("Jadwal Kuliah:");
        System.out.printf("%-30s %-5s %-10s %-10s%n", "Nama Mata Kuliah", "SKS", "Semester", "Hari Kuliah");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < namaMataKuliah.length; i++) {
            System.out.printf("%-30s %-5d %-10d %-10s%n", namaMataKuliah[i], sks[i], semester[i], hariKuliah[i]);
        }
    }

    public static void tampilkanJadwalBerdasarkanHari(String[] namaMataKuliah, int[] sks, int[] semester, String[] hariKuliah, String hari) {
        System.out.println("Jadwal Kuliah pada hari " + hari + ":");
        System.out.printf("%-30s %-5s %-10s %-10s%n", "Nama Mata Kuliah", "SKS", "Semester", "Hari Kuliah");
        System.out.println("-------------------------------------------------------------");
        boolean found = false;
        for (int i = 0; i < hariKuliah.length; i++) {
            if (hariKuliah[i].equalsIgnoreCase(hari)) {
                System.out.printf("%-30s %-5d %-10d %-10s%n", namaMataKuliah[i], sks[i], semester[i], hariKuliah[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ada jadwal kuliah pada hari " + hari + ".");
        }
    }

    public static void tampilkanJadwalBerdasarkanSemester(String[] namaMataKuliah, int[] sks, int[] semester, String[] hariKuliah, int sem) {
        System.out.println("Jadwal Kuliah pada Semester " + sem + ":");
        System.out.printf("%-30s %-5s %-10s %-10s%n", "Nama Mata Kuliah", "SKS", "Semester", "Hari Kuliah");
        System.out.println("-------------------------------------------------------------");
        boolean found = false;
        for (int i = 0; i < semester.length; i++) {
            if (semester[i] == sem) {
                System.out.printf("%-30s %-5d %-10d %-10s%n", namaMataKuliah[i], sks[i], semester[i], hariKuliah[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ada jadwal kuliah pada Semester " + sem + ".");
        }
    }

    public static void cariMataKuliah(String[] namaMataKuliah, int[] sks, int[] semester, String[] hariKuliah, String namaDicari) {
        boolean found = false;
        for (int i = 0; i < namaMataKuliah.length; i++) {
            if (namaMataKuliah[i].equalsIgnoreCase(namaDicari)) {
                System.out.printf("Mata Kuliah Ditemukan: %s, SKS: %d, Semester: %d, Hari Kuliah: %s%n",
                        namaMataKuliah[i], sks[i], semester[i], hariKuliah[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Mata kuliah dengan nama '" + namaDicari + "' tidak ditemukan.");
        }
    }
}