import java.util.ArrayList;
import java.util.List;

// 1. Interface Pembayaran
interface Pembayaran {
    void bayar(double jumlah);
    double cekSaldo();
    List<String> getRiwayat();
}

// 2. Abstract Class MetodePembayaran
abstract class MetodePembayaran implements Pembayaran {
    protected double saldo; // Bisa juga bertindak sebagai sisa limit pada Kartu Kredit
    protected List<String> riwayatTransaksi;

    public MetodePembayaran() {
        this.riwayatTransaksi = new ArrayList<>();
    }

    // Abstract method untuk validasi
    public abstract boolean validasiPembayaran(double jumlah);

    @Override
    public List<String> getRiwayat() {
        return riwayatTransaksi;
    }
}

// 3a. Class DompetDigital
class DompetDigital extends MetodePembayaran {
    private String namaProvider;

    public DompetDigital(String namaProvider, double saldoAwal) {
        super();
        this.namaProvider = namaProvider;
        this.saldo = saldoAwal;
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        // Aturan: Saldo harus >= jumlah yang dibayar
        return saldo >= jumlah;
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= jumlah;
            System.out.println("✅ [Dompet Digital " + namaProvider + "] Pembayaran Rp" + jumlah + " berhasil.");
            riwayatTransaksi.add("Berhasil: Bayar Rp" + jumlah);
        } else {
            System.out.println("❌ [Dompet Digital " + namaProvider + "] Pembayaran Rp" + jumlah + " gagal! Saldo tidak mencukupi.");
            riwayatTransaksi.add("Gagal: Bayar Rp" + jumlah + " (Saldo tidak cukup)");
        }
    }

    @Override
    public double cekSaldo() {
        return saldo;
    }
}

// 3b. Class KartuKredit
class KartuKredit extends MetodePembayaran {
    private double limitKredit;
    private double totalTagihan;

    public KartuKredit(double limitKredit) {
        super();
        this.limitKredit = limitKredit;
        this.totalTagihan = 0; // Awalnya tidak ada tagihan
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        // Aturan: (Total tagihan + jumlah bayar) harus <= limit kredit
        return (totalTagihan + jumlah) <= limitKredit;
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            totalTagihan += jumlah;
            System.out.println("✅ [Kartu Kredit] Pembayaran Rp" + jumlah + " berhasil.");
            riwayatTransaksi.add("Berhasil: Bayar Rp" + jumlah);
        } else {
            System.out.println("❌ [Kartu Kredit] Pembayaran Rp" + jumlah + " gagal! Melebihi limit kredit.");
            riwayatTransaksi.add("Gagal: Bayar Rp" + jumlah + " (Overlimit)");
        }
    }

    @Override
    public double cekSaldo() {
        return limitKredit - totalTagihan; // Mengembalikan sisa limit yang bisa dipakai
    }
}

// 3c. Class RekeningBank
class RekeningBank extends MetodePembayaran {
    private static final double BIAYA_ADMIN = 2500;

    public RekeningBank(double saldoAwal) {
        super();
        this.saldo = saldoAwal;
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        // Aturan: Saldo harus >= jumlah bayar + biaya admin Rp 2.500
        return saldo >= (jumlah + BIAYA_ADMIN);
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= (jumlah + BIAYA_ADMIN);
            System.out.println("✅ [Rekening Bank] Pembayaran Rp" + jumlah + " berhasil. (Termasuk biaya admin Rp" + BIAYA_ADMIN + ")");
            riwayatTransaksi.add("Berhasil: Bayar Rp" + jumlah + " (Biaya Admin: Rp" + BIAYA_ADMIN + ")");
        } else {
            System.out.println("❌ [Rekening Bank] Pembayaran Rp" + jumlah + " gagal! Saldo tidak mencukupi untuk bayar + admin.");
            riwayatTransaksi.add("Gagal: Bayar Rp" + jumlah + " (Saldo tidak cukup + Admin)");
        }
    }

    @Override
    public double cekSaldo() {
        return saldo;
    }
}

// 4. Class Main untuk Simulasi
public class Main {
    public static void main(String[] args) {
        System.out.println("========== SIMULASI PEMBAYARAN SHOPKITA ==========\n");

        // Inisialisasi objek metode pembayaran
        DompetDigital gopay = new DompetDigital("GoPay", 50000);
        KartuKredit cc = new KartuKredit(100000);
        RekeningBank bca = new RekeningBank(100000);

        // Simulasi Dompet Digital
        System.out.println("--- Transaksi Dompet Digital ---");
        gopay.bayar(30000); // Harus berhasil (Saldo: 50.000 -> 20.000)
        gopay.bayar(30000); // Harus gagal (Saldo sisa 20.000)
        System.out.println("Sisa Saldo: Rp" + gopay.cekSaldo() + "\n");

        // Simulasi Kartu Kredit
        System.out.println("--- Transaksi Kartu Kredit ---");
        cc.bayar(80000); // Harus berhasil (Tagihan: 80.000)
        cc.bayar(30000); // Harus gagal (Tagihan 80.000 + 30.000 > 100.000)
        System.out.println("Sisa Limit Kredit: Rp" + cc.cekSaldo() + "\n");

        // Simulasi Rekening Bank
        System.out.println("--- Transaksi Rekening Bank ---");
        bca.bayar(50000); // Harus berhasil (Dipotong 50.000 + 2.500 = 52.500)
        bca.bayar(46000); // Harus gagal (Sisa saldo 47.500. Bayar + admin = 48.500)
        System.out.println("Sisa Saldo: Rp" + bca.cekSaldo() + "\n");

        // Menampilkan Riwayat Transaksi
        System.out.println("========== RIWAYAT TRANSAKSI KESELURUHAN ==========");
        System.out.println(">> Dompet Digital:");
        for (String riwayat : gopay.getRiwayat()) {
            System.out.println("  - " + riwayat);
        }

        System.out.println("\n>> Kartu Kredit:");
        for (String riwayat : cc.getRiwayat()) {
            System.out.println("  - " + riwayat);
        }

        System.out.println("\n>> Rekening Bank:");
        for (String riwayat : bca.getRiwayat()) {
            System.out.println("  - " + riwayat);
        }
    }
}