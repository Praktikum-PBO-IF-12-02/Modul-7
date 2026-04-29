/**
 *
 * @author wahyuuuwid
 */

import java.util.ArrayList;

public abstract class MetodePembayaran implements Pembayaran {
    protected double saldo;
    protected ArrayList<String> riwayat = new ArrayList<>();

    public MetodePembayaran(double saldo) {
        this.saldo = saldo;
    }

    protected abstract boolean validasiPembayaran(double jumlah);

    @Override
    public boolean bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            prosesPembayaran(jumlah);
            riwayat.add("Berhasil bayar: " + jumlah);
            return true;
        } else {
            riwayat.add("Gagal bayar: " + jumlah);
            return false;
        }
    }

    protected void prosesPembayaran(double jumlah) {
        saldo -= jumlah;
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