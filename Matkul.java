import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matkul {

    private static List<MataKuliah> daftarMataKuliah = new ArrayList<>();

    public static void main(String[] args) {
        inisialisasiData();

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            tampilkanMenu();
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanSemuaJadwal();
                    break;
                case 2:
                    tampilkanJadwalBerdasarkanHari(scanner);
                    break;
                case 3:
                    tampilkanJadwalBerdasarkanSemester(scanner);
                    break;
                case 4:
                    cariMataKuliah(scanner);
                    break;
                case 0:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            System.out.println();
        } while (pilihan != 0);

        scanner.close();
    }

    private static void inisialisasiData() {
        daftarMataKuliah.add(new MataKuliah("IF123", "Struktur Data", "Selasa", "10:00", 2));
        daftarMataKuliah.add(new MataKuliah("KI234", "Kimia Dasar", "Senin", "08:00", 1));
        daftarMataKuliah.add(new MataKuliah("MT345", "Matematika Lanjut", "Rabu", "13:00", 3));
        daftarMataKuliah.add(new MataKuliah("IF456", "Basis Data", "Selasa", "13:00", 4));
    }

    private static void tampilkanMenu() {
        System.out.println("=== Menu Jadwal Kuliah ===");
        System.out.println("1. Tampilkan Semua Jadwal");
        System.out.println("2. Tampilkan Jadwal Berdasarkan Hari");
        System.out.println("3. Tampilkan Jadwal Berdasarkan Semester");
        System.out.println("4. Cari Mata Kuliah");
        System.out.println("0. Keluar");
    }

    private static void tampilkanSemuaJadwal() {
        System.out.println("=== Semua Jadwal Kuliah ===");
        if (daftarMataKuliah.isEmpty()) {
            System.out.println("Tidak ada jadwal kuliah.");
            return;
        }
        for (MataKuliah mk : daftarMataKuliah) {
            System.out.println(mk);
        }
    }

    private static void tampilkanJadwalBerdasarkanHari(Scanner scanner) {
        System.out.print("Masukkan hari (Senin, Selasa, Rabu, dst.): ");
        String hari = scanner.nextLine();
        System.out.println("=== Jadwal Kuliah Hari " + hari + " ===");
        boolean ditemukan = false;
        for (MataKuliah mk : daftarMataKuliah) {
            if (mk.getHari().equalsIgnoreCase(hari)) {
                System.out.println(mk);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada jadwal kuliah pada hari " + hari);
        }
    }

    private static void tampilkanJadwalBerdasarkanSemester(Scanner scanner) {
        System.out.print("Masukkan semester: ");
        int semester = scanner.nextInt();
        scanner.nextLine();
        System.out.println("=== Jadwal Kuliah Semester " + semester + " ===");
        boolean ditemukan = false;
        for (MataKuliah mk : daftarMataKuliah) {
            if (mk.getSemester() == semester) {
                System.out.println(mk);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada jadwal kuliah pada semester " + semester);
        }
    }

    private static void cariMataKuliah(Scanner scanner) {
        System.out.print("Masukkan nama mata kuliah yang dicari: ");
        String namaMK = scanner.nextLine();
        System.out.println("=== Hasil Pencarian Mata Kuliah ===");
        boolean ditemukan = false;
        for (MataKuliah mk : daftarMataKuliah) {
            if (mk.getNama().toLowerCase().contains(namaMK.toLowerCase())) {
                System.out.println(mk);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Mata kuliah dengan nama '" + namaMK + "' tidak ditemukan.");
        }
    }
}

class MataKuliah {
    private String kode;
    private String nama;
    private String hari;
    private String jam;
    private int semester;

    public MataKuliah(String kode, String nama, String hari, String jam, int semester) {
        this.kode = kode;
        this.nama = nama;
        this.hari = hari;
        this.jam = jam;
        this.semester = semester;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getHari() {
        return hari;
    }

    public String getJam() {
        return jam;
    }

    public int getSemester() {
        return semester;
    }

    public String toString() {
        return String.format("Kode: %s, Nama: %s, Hari: %s, Jam: %s, Semester: %d",
                kode, nama, hari, jam, semester);
    }
    
}
