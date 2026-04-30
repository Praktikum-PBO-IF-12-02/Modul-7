public class Main {
    public static void main(String[] args) {

        System.out.println("=== Dompet Digital ===");
        DompetDigital dompet = new DompetDigital(100000);

        dompet.bayar(50000);
        dompet.bayar(60000);

        dompet.cekSaldo();
        dompet.getRiwayat();

        System.out.println("=== Kartu Kredit ===");
        KartuKredit kartu = new KartuKredit(100000);

        kartu.bayar(50000);
        kartu.bayar(60000);

        kartu.cekSaldo();
        kartu.getRiwayat();

        System.out.println("=== Rekening Bank ===");
        RekeningBank bank = new RekeningBank(100000);

        bank.bayar(50000);
        bank.bayar(60000);

        bank.cekSaldo();
        bank.getRiwayat();
    }
}