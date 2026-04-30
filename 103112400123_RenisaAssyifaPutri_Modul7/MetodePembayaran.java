import java.util.ArrayList;

public abstract class MetodePembayaran implements Pembayaran {
    protected String namaPemilik;
    protected double saldo;
    protected ArrayList<String> riwayatTransaksi;

    public MetodePembayaran(String namaPemilik, double saldo) {
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
        this.riwayatTransaksi = new ArrayList<>();
    }

    public abstract boolean validasiPembayaran(double jumlah);

    @Override
    public double cekSaldo() {
        return saldo;
    }

    @Override
    public ArrayList<String> getRiwayat() {
        return riwayatTransaksi;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }
}
