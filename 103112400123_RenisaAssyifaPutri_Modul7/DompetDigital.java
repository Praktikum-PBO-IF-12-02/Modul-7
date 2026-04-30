public class DompetDigital extends MetodePembayaran {

    public DompetDigital(String namaPemilik, double saldo) {
        super(namaPemilik, saldo);
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        return saldo >= jumlah;
    }

    @Override
    public boolean bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= jumlah;
            riwayatTransaksi.add(String.format(
                "[Dompet Digital] Pembayaran Rp %,.0f BERHASIL", jumlah));
            return true;
        } else {
            riwayatTransaksi.add(String.format(
                "[Dompet Digital] Pembayaran Rp %,.0f GAGAL", jumlah));
            return false;
        }
    }
}