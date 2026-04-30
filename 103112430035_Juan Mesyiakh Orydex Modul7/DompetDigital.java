public class DompetDigital extends MetodePembayaran {
    public DompetDigital(double saldo) { super("Dompet Digital", saldo); }
    @Override protected boolean valid(double jumlah) { return saldo >= jumlah; }
}
