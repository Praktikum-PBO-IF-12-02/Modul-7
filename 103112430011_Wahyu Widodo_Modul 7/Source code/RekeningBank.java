/**
 *
 * @author wahyuuuwid
 */

public class RekeningBank extends MetodePembayaran {
    private final double BIAYA_ADMIN = 2500;

    public RekeningBank(double saldo) {
        super(saldo);
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return saldo >= (jumlah + BIAYA_ADMIN);
    }

    @Override
    protected void prosesPembayaran(double jumlah) {
        saldo -= (jumlah + BIAYA_ADMIN);
    }
}