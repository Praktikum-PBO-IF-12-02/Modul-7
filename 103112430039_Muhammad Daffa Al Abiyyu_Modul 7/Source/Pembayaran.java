public interface Pembayaran {
    boolean bayar(double jumlah);
    double cekSaldo();
    void getRiwayat();
}