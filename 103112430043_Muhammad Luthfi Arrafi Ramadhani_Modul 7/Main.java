public class Main {
    public static void main(String[] args) {

        DompetDigital dompet = new DompetDigital(10000);
        KartuKredit kartu = new KartuKredit(5000);
        RekeningBank bank = new RekeningBank(10000);

        // Dompet Digital
        dompet.bayar(3000);   // berhasil
        dompet.bayar(8000);   // gagal

        // Kartu Kredit
        kartu.bayar(2000);    // berhasil
        kartu.bayar(4000);    // gagal (limit)

        // Rekening Bank
        bank.bayar(5000);     // berhasil
        bank.bayar(6000);     // gagal (saldo kurang + admin)

        // Tampilkan riwayat
        System.out.println("=== Dompet Digital ===");
        dompet.getRiwayat();

        System.out.println("\n=== Kartu Kredit ===");
        kartu.getRiwayat();

        System.out.println("\n=== Rekening Bank ===");
        bank.getRiwayat();
    }
}