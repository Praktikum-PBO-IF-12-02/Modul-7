public interface Pembayaran {
    boolean bayar(double jumlah, String keterangan);
    double cekSaldo();
    void getRiwayat();
}