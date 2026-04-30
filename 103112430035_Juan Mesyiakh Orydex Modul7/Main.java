public class Main {
    public static void main(String[] args) {
        MetodePembayaran[] m = {
            new DompetDigital(150000),
            new KartuKredit(500000),
            new RekeningBank(200000)
        };

        m[0].bayar(50000); m[0].bayar(80000); m[0].bayar(50000);   // ke-3 gagal
        m[1].bayar(200000); m[1].bayar(250000); m[1].bayar(100000); // ke-3 gagal
        m[2].bayar(100000); m[2].bayar(80000); m[2].bayar(20000);   // ke-3 gagal

        for (MetodePembayaran mp : m) {
            System.out.println("\n" + mp.nama + " | Saldo: Rp" + (int)mp.cekSaldo());
            mp.getRiwayat().forEach(r -> System.out.println("  " + r));
        }
    }
}
