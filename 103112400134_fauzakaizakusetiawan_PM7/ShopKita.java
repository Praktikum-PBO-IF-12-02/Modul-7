interface Pembayaran {
    void bayar(double jumlah);
    double cekSaldo();
    void getRiwayat();
}

abstract class MetodePembayaran implements Pembayaran {
    protected String nama;
    protected String[] riwayat = new String[10];
    protected int jumlahRiwayat = 0;

    public MetodePembayaran(String nama) {
        this.nama = nama;
    }

    protected abstract boolean validasiPembayaran(double jumlah);

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            prosesTransaksi(jumlah);
            riwayat[jumlahRiwayat++] = "[BERHASIL] Bayar Rp " + jumlah;
            System.out.println(nama + ": bayar Rp " + jumlah + " -> berhasil");
        } else {
            riwayat[jumlahRiwayat++] = "[GAGAL] Bayar Rp " + jumlah;
            System.out.println(nama + ": bayar Rp " + jumlah + " -> gagal");
        }
    }

    protected abstract void prosesTransaksi(double jumlah);

    @Override
    public void getRiwayat() {
        System.out.println("\nRiwayat " + nama + ":");
        for (int i = 0; i < jumlahRiwayat; i++) {
            System.out.println("  " + riwayat[i]);
        }
    }
}

class DompetDigital extends MetodePembayaran {
    private double saldo;

    public DompetDigital(String nama, double saldo) {
        super(nama);
        this.saldo = saldo;
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return saldo >= jumlah;
    }

    @Override
    protected void prosesTransaksi(double jumlah) {
        saldo -= jumlah;
    }

    @Override
    public double cekSaldo() {
        System.out.println(nama + ": saldo Rp " + saldo);
        return saldo;
    }
}

class KartuKredit extends MetodePembayaran {
    private double limitKredit;
    private double totalTagihan;

    public KartuKredit(String nama, double limitKredit) {
        super(nama);
        this.limitKredit = limitKredit;
        this.totalTagihan = 0;
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return (totalTagihan + jumlah) <= limitKredit;
    }

    @Override
    protected void prosesTransaksi(double jumlah) {
        totalTagihan += jumlah;
    }

    @Override
    public double cekSaldo() {
        System.out.println(nama + ": sisa limit Rp " + (limitKredit - totalTagihan) + ", tagihan Rp " + totalTagihan);
        return limitKredit - totalTagihan;
    }
}

class RekeningBank extends MetodePembayaran {
    private double saldo;
    private static final double BIAYA_ADMIN = 2500;

    public RekeningBank(String nama, double saldo) {
        super(nama);
        this.saldo = saldo;
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return saldo >= (jumlah + BIAYA_ADMIN);
    }

    @Override
    protected void prosesTransaksi(double jumlah) {
        saldo -= (jumlah + BIAYA_ADMIN);
    }

    @Override
    public double cekSaldo() {
        System.out.println(nama + ": saldo Rp " + saldo);
        return saldo;
    }
}

public class ShopKita {
    public static void main(String[] args) {

        DompetDigital gopay = new DompetDigital("GoPay", 100000);
        gopay.bayar(50000);
        gopay.bayar(80000);
        gopay.cekSaldo();

        KartuKredit kartu = new KartuKredit("BCA Visa", 200000);
        kartu.bayar(150000);
        kartu.bayar(100000);
        kartu.cekSaldo();

        RekeningBank bri = new RekeningBank("BRI", 80000);
        bri.bayar(50000);
        bri.bayar(50000);
        bri.cekSaldo();

        System.out.println("\n--- Riwayat Transaksi ---");
        gopay.getRiwayat();
        kartu.getRiwayat();
        bri.getRiwayat();
    }
}