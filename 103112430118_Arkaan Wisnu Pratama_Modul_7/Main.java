public class Main {

    public static void main(String[] args) {

        System.out.println("  SHOPKITA - SISTEM PEMBAYARAN E-COMMERCE");

        System.out.println("  METODE 1: DOMPET DIGITAL (GoPay)");
        System.out.println("  Saldo Awal: Rp 150.000");

        DompetDigital gopay = new DompetDigital("Budi Santoso", "GoPay", 150_000);

        gopay.bayar(75_000, "Pembelian Kaos Polos");

        gopay.bayar(60_000, "Pembelian Celana Chino");

        gopay.bayar(200_000, "Pembelian Sepatu Sneakers");

        System.out.println("  METODE 2: KARTU KREDIT");
        System.out.println("  Limit: Rp 5.000.000 | Tagihan Awal: Rp 4.200.000");

        KartuKredit kartuKredit = new KartuKredit("Sari Dewi", 5_000_000, 4_200_000);

        kartuKredit.bayar(500_000, "Pembelian Tas Ransel");

        kartuKredit.bayar(250_000, "Pembelian Parfum");

        kartuKredit.bayar(8_000_000, "Pembelian Laptop Gaming");

        System.out.println("  METODE 3: REKENING BANK (BCA)");
        System.out.println("  Saldo Awal: Rp 500.000 | Biaya Admin: Rp 2.500/transaksi");

        RekeningBank rekeningBCA = new RekeningBank("Andi Prasetyo", "BCA", 500_000);

        rekeningBCA.bayar(120_000, "Pembelian Buku Programming");

        rekeningBCA.bayar(350_000, "Pembelian Headset Bluetooth");

        rekeningBCA.bayar(25_000, "Pembelian Monitor LED");

        System.out.println("\n");
        System.out.println("  REKAP RIWAYAT SELURUH TRANSAKSI");

        gopay.getRiwayat();
        kartuKredit.getRiwayat();
        rekeningBCA.getRiwayat();

        System.out.println("  RINGKASAN SALDO AKHIR");
        System.out.printf("  GoPay (Budi)         Saldo tersisa  : Rp %,.0f%n", gopay.cekSaldo());
        System.out.printf("  Kartu Kredit (Sari)  Sisa limit     : Rp %,.0f%n", kartuKredit.cekSaldo());
        System.out.printf("                       Total tagihan  : Rp %,.0f%n", kartuKredit.getTotalTagihan());
        System.out.printf("  Rek. BCA (Andi)      Saldo tersisa  : Rp %,.0f%n", rekeningBCA.cekSaldo());
    }
}