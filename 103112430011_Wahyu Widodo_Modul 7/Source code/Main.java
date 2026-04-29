/**
 *
 * @author wahyuuuwid
 */

public class Main {
    public static void main(String[] args) {

        // Dompet Digital
        DompetDigital dompet = new DompetDigital(100000);
        dompet.bayar(50000);   // berhasil
        dompet.bayar(60000);   // gagal

        System.out.println("\nRiwayat Dompet Digital:");
        dompet.getRiwayat();

        // Kartu Kredit
        KartuKredit kartu = new KartuKredit(100000);
        kartu.bayar(40000);   // berhasil
        kartu.bayar(70000);   // gagal

        System.out.println("\nRiwayat Kartu Kredit:");
        kartu.getRiwayat();

        // Rekening Bank
        RekeningBank bank = new RekeningBank(100000);
        bank.bayar(50000);   // berhasil (kena admin)
        bank.bayar(48000);   // gagal

        System.out.println("\nRiwayat Rekening Bank:");
        bank.getRiwayat();
    }
}