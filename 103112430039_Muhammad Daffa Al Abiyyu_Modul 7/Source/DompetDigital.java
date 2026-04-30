public class DompetDigital extends MetodePembayaran {

    public DompetDigital(double saldo) {
        super(saldo);
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return saldo >= jumlah;
    }
}