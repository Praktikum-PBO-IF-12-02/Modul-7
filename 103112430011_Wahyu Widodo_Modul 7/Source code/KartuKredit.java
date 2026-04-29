/**
 *
 * @author wahyuuuwid
 */

public class KartuKredit extends MetodePembayaran {
    private double limit;
    private double totalTagihan = 0;

    public KartuKredit(double limit) {
        super(0);
        this.limit = limit;
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return (totalTagihan + jumlah) <= limit;
    }

    @Override
    protected void prosesPembayaran(double jumlah) {
        totalTagihan += jumlah;
    }

    @Override
    public double cekSaldo() {
        return limit - totalTagihan;
    }
}