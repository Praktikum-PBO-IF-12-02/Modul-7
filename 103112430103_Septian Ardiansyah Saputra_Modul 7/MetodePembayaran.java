import java.util.*;

public abstract class MetodePembayaran implements Pembayaran {
    protected double saldo;
    protected List<String> riwayat = new ArrayList<>();

    public MetodePembayaran(double saldo) {
        this.saldo = saldo;
    }

    abstract boolean validasiPembayaran(double jumlah);

    @Override
    public void cekSaldo() {
        System.out.println("Saldo saat ini : Rp " + saldo);
    }

    @Override
    public void getRiwayat() {
        System.out.println("Riwayat Transaksi :");
        for (String r : riwayat) {
            System.out.println("- " + r);
        }
        System.out.println();
    }
}