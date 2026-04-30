public class Main {
    public static void main(String[] args) {
        System.out.println("SIMULASI PEMBAYARAN SHOPKITA \n");

        Pembayaran gopay = new DompetDigital("GoPay", 100000);
        Pembayaran kartuKredit = new KartuKredit("Kartu Kredit BCA", 500000);
        Pembayaran mandiri = new RekeningBank("Rekening Mandiri", 200000);

        System.out.println("--- Transaksi Dompet Digital ---");
        gopay.bayar(60000); 
        gopay.bayar(50000); 

        System.out.println("\n--- Transaksi Kartu Kredit ---");
        kartuKredit.bayar(450000); 
        kartuKredit.bayar(100000); 

        System.out.println("\n--- Transaksi Rekening Bank ---");
        mandiri.bayar(150000); 
        mandiri.bayar(46000); 

        System.out.println("");
        System.out.println(" RIWAYAT TRANSAKSI KESELURUHAN ");
        System.out.println("");
        
        gopay.getRiwayat();
        kartuKredit.getRiwayat();
        mandiri.getRiwayat();
    }
}