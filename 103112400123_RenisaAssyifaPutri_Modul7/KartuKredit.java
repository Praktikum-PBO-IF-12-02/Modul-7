public class KartuKredit extends MetodePembayaran {
    private double limitKredit;
    private double totalTagihan;

    public KartuKredit(String namaPemilik, double limitKredit) {
        super(namaPemilik, limitKredit);
        this.limitKredit = limitKredit;
        this.totalTagihan = 0;
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        return (totalTagihan + jumlah) <= limitKredit;
    }

    @Override
    public double cekSaldo() {
        return limitKredit - totalTagihan; // sisa limit
    }

    @Override
    public boolean bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            totalTagihan += jumlah;
            riwayatTransaksi.add(String.format(
                "[Kartu Kredit] Pembayaran Rp %,.0f BERHASIL", jumlah));
            return true;
        } else {
            riwayatTransaksi.add(String.format(
                "[Kartu Kredit] Pembayaran Rp %,.0f GAGAL", jumlah));
            return false;
        }
    }
}