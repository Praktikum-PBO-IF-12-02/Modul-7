import java.util.*;
public abstract class MetodePembayaran implements Pembayaran {
    protected String nama;
    protected double saldo;
    protected List<String> riwayat = new ArrayList<>();

    public MetodePembayaran(String nama, double saldo) {
        this.nama = nama;
        this.saldo = saldo;
    }

    protected abstract boolean valid(double jumlah);

    @Override
    public void bayar(double jumlah) {
        if (valid(jumlah)) {
            saldo -= jumlah;
            riwayat.add("OK   Rp" + (int)jumlah);
        } else {
            riwayat.add("FAIL Rp" + (int)jumlah);
        }
    }

    @Override public double cekSaldo() { return saldo; }
    @Override public List<String> getRiwayat() { return riwayat; }
}
