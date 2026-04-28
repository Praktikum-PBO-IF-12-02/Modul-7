import java.util.ArrayList;

public abstract class MetodePembayaran implements Pembayaran {
    protected double saldo;
    protected ArrayList<String> riwayat = new ArrayList<>();

    public MetodePembayaran(double saldo) {
        this.saldo = saldo;
    }

    // abstract method validasi
    protected abstract boolean validasiPembayaran(double jumlah);

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= jumlah;
            riwayat.add("Pembayaran berhasil: Rp " + jumlah);
            System.out.println("Pembayaran berhasil.");
        } else {
            riwayat.add("Pembayaran gagal: Rp " + jumlah);
            System.out.println("Pembayaran gagal.");
        }
    }

    @Override
    public double cekSaldo() {
        return saldo;
    }

    @Override
    public void getRiwayat() {
        for (String r : riwayat) {
            System.out.println(r);
        }
    }
}