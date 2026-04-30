public class RekeningBank extends MetodePembayaran {
    private final double BIAYA_ADMIN = 2500;

    public RekeningBank(double saldo) {
        super(saldo);
    }

    protected boolean validasiPembayaran(double jumlah) {
        return saldo >= (jumlah + BIAYA_ADMIN);
    }

    protected void prosesPembayaran(double jumlah) {
        saldo -= (jumlah + BIAYA_ADMIN);
    }
}