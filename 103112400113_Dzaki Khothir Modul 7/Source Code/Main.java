public class Main {
    public static void main(String[] args) {

        DompetDigital dompet = new DompetDigital(100000);
        KartuKredit kartu = new KartuKredit(500000);
        RekeningBank bank = new RekeningBank(100000);

        dompet.bayar(50000);   // berhasil
        dompet.bayar(60000);   // gagal

        kartu.bayar(200000);   // berhasil
        kartu.bayar(400000);   // gagal (limit)

        bank.bayar(50000);     // berhasil
        bank.bayar(60000);     // gagal (saldo kurang + admin)

        System.out.println("\n=== RIWAYAT DOMPET ===");
        dompet.getRiwayat();

        System.out.println("\n=== RIWAYAT KARTU ===");
        kartu.getRiwayat();

        System.out.println("\n=== RIWAYAT BANK ===");
        bank.getRiwayat();
    }
}