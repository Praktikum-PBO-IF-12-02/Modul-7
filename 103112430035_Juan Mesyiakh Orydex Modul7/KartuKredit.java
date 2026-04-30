public class KartuKredit extends MetodePembayaran {
    private double limit;
    public KartuKredit(double limit) { super("Kartu Kredit", 0); this.limit = limit; }
    @Override protected boolean valid(double jumlah) { return saldo + jumlah <= limit; }
    @Override public void bayar(double jumlah) {
        if (valid(jumlah)) { saldo += jumlah; riwayat.add("OK   Rp" + (int)jumlah); }
        else riwayat.add("FAIL Rp" + (int)jumlah);
    }
    @Override public double cekSaldo() { return limit - saldo; }
}
