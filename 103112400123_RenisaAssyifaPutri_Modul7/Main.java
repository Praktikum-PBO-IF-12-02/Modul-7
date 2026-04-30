import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Inisialisasi metode pembayaran
        DompetDigital andi = new DompetDigital("Andi", 100000);
        KartuKredit budi = new KartuKredit("Budi", 500000);
        RekeningBank citra = new RekeningBank("Citra", 200000);

        System.out.println("========================================");
        System.out.println("   SIMULASI SISTEM PEMBAYARAN SHOPKITA  ");
        System.out.println("========================================");

        // Dompet Digital
        System.out.println("\n--- Dompet Digital (Pemilik: " + andi.getNamaPemilik() + ") ---");
        System.out.printf("Saldo awal: Rp %,.0f%n", andi.cekSaldo());
        andi.bayar(50000);
        andi.bayar(75000);
        System.out.printf("Saldo akhir: Rp %,.0f%n", andi.cekSaldo());

        // Kartu Kredit
        System.out.println("\n--- Kartu Kredit (Pemilik: " + budi.getNamaPemilik() + ") ---");
        System.out.printf("Sisa limit: Rp %,.0f%n", budi.cekSaldo());
        budi.bayar(200000);
        budi.bayar(400000);
        System.out.printf("Sisa limit: Rp %,.0f%n", budi.cekSaldo());

        // Rekening Bank
        System.out.println("\n--- Rekening Bank (Pemilik: " + citra.getNamaPemilik() + ") ---");
        System.out.printf("Saldo awal: Rp %,.0f%n", citra.cekSaldo());
        citra.bayar(100000);
        citra.bayar(100000);
        System.out.printf("Saldo akhir: Rp %,.0f%n", citra.cekSaldo());

        // Riwayat transaksi
        System.out.println("\n========================================");
        System.out.println("       RIWAYAT SELURUH TRANSAKSI        ");
        System.out.println("========================================");

        MetodePembayaran[] semuaMetode = {andi, budi, citra};
        String[] namaMetode = {"Dompet Digital", "Kartu Kredit", "Rekening Bank"};

        for (int i = 0; i < semuaMetode.length; i++) {
            System.out.println("\n[" + namaMetode[i] + " - " + semuaMetode[i].getNamaPemilik() + "]");
            ArrayList<String> riwayat = semuaMetode[i].getRiwayat();
            for (String transaksi : riwayat) {
                System.out.println("  " + transaksi);
            }
        }
    }
}