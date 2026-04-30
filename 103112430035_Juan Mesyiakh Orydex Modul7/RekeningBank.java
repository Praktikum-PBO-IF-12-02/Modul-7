public class RekeningBank extends MetodePembayaran {
    public RekeningBank(double saldo) { super("Rekening Bank", saldo); }
    @Override protected boolean valid(double jumlah) { return saldo >= jumlah + 2500; }
    @Override public void bayar(double jumlah) {
        if (valid(jumlah)) { saldo -= jumlah + 2500; riwayat.add("OK   Rp" + (int)jumlah); }
        else riwayat.add("FAIL Rp" + (int)jumlah);
    }
}
