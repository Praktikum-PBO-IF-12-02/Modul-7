import java.util.ArrayList;

abstract class MetodePembayaran implements Pembayaran {
    protected double saldo;
    protected ArrayList<String> riwayat = new ArrayList<>();

    public MetodePembayaran(double saldo) {
        this.saldo = saldo;
    }

    protected abstract boolean validasiPembayaran(double jumlah);

    @Override
    public boolean bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= jumlah;
            riwayat.add("Pembayaran berhasil: " + jumlah);
            return true;
        } else {
            riwayat.add("Pembayaran gagal: " + jumlah);
            return false;
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