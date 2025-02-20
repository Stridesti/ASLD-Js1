import java.util.Scanner;
public class Tugas2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        
        do {
            System.out.println("==================================");
            System.out.println("Menu Perhitungan Kubus");
            System.out.println("1. Hitung Volume Kubus");
            System.out.println("2. Hitung Luas Permukaan Kubus");
            System.out.println("3. Hitung Keliling Kubus");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan = scanner.nextInt();
            
            switch (pilihan) {
                case 1:
                    hitungVolume(scanner);
                    break;
                case 2:
                    hitungLuasPermukaan(scanner);
                    break;
                case 3:
                    hitungKeliling(scanner);
                    break;
                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        } while (pilihan != 4);
        
        scanner.close();
    }
    
    public static void hitungVolume(Scanner scanner) {
        System.out.print("Masukkan panjang rusuk kubus: ");
        double rusuk = scanner.nextDouble();
        double volume = Math.pow(rusuk, 3);
        System.out.printf("Volume kubus dengan panjang rusuk %.2f adalah %.2f%n", rusuk, volume);
    }
    
    public static void hitungLuasPermukaan(Scanner scanner) {
        System.out.print("Masukkan panjang rusuk kubus: ");
        double rusuk = scanner.nextDouble();
        double luasPermukaan = 6 * Math.pow(rusuk, 2);
        System.out.printf("Luas permukaan kubus dengan panjang rusuk %.2f adalah %.2f%n", rusuk, luasPermukaan);
    }
    
    public static void hitungKeliling(Scanner scanner) {
        System.out.print("Masukkan panjang rusuk kubus: ");
        double rusuk = scanner.nextDouble();
        double keliling = 12 * rusuk;
        System.out.printf("Keliling kubus dengan panjang rusuk %.2f adalah %.2f%n", rusuk, keliling);
    }
}