import java.util.Scanner;
public class Tugas1 {
    public static void main(String[] args) {
        char[] KODE = {'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T'};
        
        String[][] KOTA = {
            {"BANTEN"},     // KODE 'A'
            {"JAKARTA"},     // KODE 'B'
            {"BANDUNG"},    // KODE 'D'
            {"CIREBON"},    // KODE 'E'
            {"BOGOR"},       // KODE 'F'
            {"PEKALONGAN"},    // KODE 'G'
            {"SEMARANG"},  // KODE 'H'
            {"SURABYA"},   // KODE 'L'
            {"MALANG"},        // KODE 'N'
            {"TEGAL"}        // KODE 'T'
        };

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan kode plat mobil (A-J): ");
        char inputKode = scanner.next().charAt(0);
        
        int index = -1;
        for (int i = 0; i < KODE.length; i++) {
            if (KODE[i] == inputKode) {
                index = i;
                break;
            }
        }
        
        if (index != -1) {
            System.out.println("Nama kota untuk kode plat " + inputKode + " adalah: " + KOTA[index][0]);
        } else {
            System.out.println("Kode plat tidak valid. Silakan masukkan kode dari A hingga J.");
        }
        
        scanner.close();
    }
}
