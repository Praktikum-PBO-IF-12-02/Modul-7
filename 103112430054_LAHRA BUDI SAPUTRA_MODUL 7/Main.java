public class Main {
    public static void main(String[] args) {
        DompetDigital gopay = new DompetDigital("GoPay", 50000);
        KartuKredit cc = new KartuKredit("Kartu Kredit BCA", 100000);
        RekeningBank mandiri = new RekeningBank("Bank Mandiri", 30000);

        System.out.println("=== SIMULASI TRANSAKSI SHOPKITA ===\n");

        // Skenario Dompet Digital
        gopay.cekSaldo();
        gopay.bayar(40000);
        gopay.bayar(20000);
        System.out.println();

        // Skenario Kartu Kredit
        cc.cekSaldo();
        cc.bayar(80000);
        cc.bayar(50000);
        System.out.println();

        // Skenario Rekening Bank
        mandiri.cekSaldo();
        mandiri.bayar(20000);
        mandiri.bayar(10000);
        System.out.println();

        // Rekap Riwayat
        System.out.println("=== REKAP RIWAYAT SELURUH METODE ===");
        gopay.getRiwayat();
        cc.getRiwayat();
        mandiri.getRiwayat();
    }
}