public class Main {
    public static void main(String[] args) {
        System.out.println("========== SIMULASI PEMBAYARAN SHOPKITA ==========\n");

        DompetDigital dompetDigital = new DompetDigital(100000);
        KartuKredit kartuKredit = new KartuKredit(5000000, 4500000); 
        RekeningBank rekeningBank = new RekeningBank(50000);

        // Simulasi
        dompetDigital.bayar(60000);
        dompetDigital.bayar(50000); // Gagal

        kartuKredit.bayar(300000);
        kartuKredit.bayar(300000); // Gagal

        rekeningBank.bayar(30000);
        rekeningBank.bayar(20000); // Gagal

        System.out.println("==================================================");
        System.out.println("           MENAMPILKAN RIWAYAT TRANSAKSI          ");
        System.out.println("==================================================\n");

        dompetDigital.getRiwayat();
        kartuKredit.getRiwayat();
        rekeningBank.getRiwayat();
    }
}