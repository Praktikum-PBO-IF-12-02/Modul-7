public interface Pembayaran {
    void bayar(double nominal);
    double cekSaldo();
    void getRiwayat();
}