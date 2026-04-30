public class RekeningBank extends MetodePembayaran {
    private static final double BIAYA_ADMIN = 2500;

    public RekeningBank(String namaPemilik, double saldo) {
        super(namaPemilik, saldo);
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        return saldo >= (jumlah + BIAYA_ADMIN);
    }

    @Override
    public boolean bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= (jumlah + BIAYA_ADMIN);
            riwayatTransaksi.add(String.format(
                "[Rekening Bank] Pembayaran Rp %,.0f + Admin BERHASIL", jumlah));
            return true;
        } else {
            riwayatTransaksi.add(String.format(
                "[Rekening Bank] Pembayaran Rp %,.0f GAGAL", jumlah));
            return false;
        }
    }
}