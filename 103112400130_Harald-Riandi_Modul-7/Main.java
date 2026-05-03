import java.util.ArrayList;
import java.util.List;

interface Pembayaran {
    void bayar(double jumlah);
    void cekSaldo();
    void getRiwayat();
}

abstract class MetodePembayaran implements Pembayaran {
    protected List<String> riwayatTransaksi;

    public MetodePembayaran() {
        this.riwayatTransaksi = new ArrayList<>();
    }

    public abstract boolean validasiPembayaran(double jumlah);

    protected void catatRiwayat(String pesan) {
        riwayatTransaksi.add(pesan);
    }

    @Override
    public void getRiwayat() {
        System.out.println("Riwayat Transaksi:");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("- Belum ada transaksi.");
        } else {
            for (String riwayat : riwayatTransaksi) {
                System.out.println("- " + riwayat);
            }
        }
    }
}

class DompetDigital extends MetodePembayaran {
    private double saldo;

    public DompetDigital(double saldoAwal) {
        this.saldo = saldoAwal;
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        return saldo >= jumlah;
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= jumlah;
            catatRiwayat("BERHASIL: Pembayaran sebesar Rp" + jumlah);
        } else {
            catatRiwayat("GAGAL: Saldo tidak mencukupi untuk pembayaran Rp" + jumlah);
        }
    }

    @Override
    public void cekSaldo() {
        System.out.println("Saldo Dompet Digital saat ini: Rp" + saldo);
    }
}

class KartuKredit extends MetodePembayaran {
    private double limitKredit;
    private double totalTagihan;

    public KartuKredit(double limitKredit) {
        this.limitKredit = limitKredit;
        this.totalTagihan = 0;
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        return (totalTagihan + jumlah) <= limitKredit;
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            totalTagihan += jumlah;
            catatRiwayat("BERHASIL: Pembayaran sebesar Rp" + jumlah);
        } else {
            catatRiwayat("GAGAL: Melebihi limit kredit untuk pembayaran Rp" + jumlah);
        }
    }

    @Override
    public void cekSaldo() {
        System.out.println("Total Tagihan Kartu Kredit: Rp" + totalTagihan + " / Limit: Rp" + limitKredit);
    }
}

class RekeningBank extends MetodePembayaran {
    private double saldo;
    private final double BIAYA_ADMIN = 2500;

    public RekeningBank(double saldoAwal) {
        this.saldo = saldoAwal;
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        return saldo >= (jumlah + BIAYA_ADMIN);
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= (jumlah + BIAYA_ADMIN);
            catatRiwayat("BERHASIL: Pembayaran sebesar Rp" + jumlah + " (Termasuk Admin Rp" + BIAYA_ADMIN + ")");
        } else {
            catatRiwayat("GAGAL: Saldo tidak mencukupi untuk pembayaran Rp" + jumlah + " + admin");
        }
    }

    @Override
    public void cekSaldo() {
        System.out.println("Saldo Rekening Bank saat ini: Rp" + saldo);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIMULASI DOMPET DIGITAL ===");
        DompetDigital ovo = new DompetDigital(50000);
        ovo.cekSaldo();
        ovo.bayar(30000); // Transaksi Valid
        ovo.bayar(25000); // Transaksi Invalid (Sisa 20.000 < 25.000)
        ovo.cekSaldo();
        ovo.getRiwayat();

        System.out.println("\n=== SIMULASI KARTU KREDIT ===");
        KartuKredit cc = new KartuKredit(100000);
        cc.cekSaldo();
        cc.bayar(80000);  // Transaksi Valid
        cc.bayar(30000);  // Transaksi Invalid (Total 110.000 > Limit 100.000)
        cc.cekSaldo();
        cc.getRiwayat();

        System.out.println("\n=== SIMULASI REKENING BANK ===");
        RekeningBank bca = new RekeningBank(100000);
        bca.cekSaldo();
        bca.bayar(50000); // Transaksi Valid (50.000 + 2.500 = 52.500)
        bca.bayar(50000); // Transaksi Invalid (Sisa 47.500 < 52.500)
        bca.cekSaldo();
        bca.getRiwayat();
    }
}