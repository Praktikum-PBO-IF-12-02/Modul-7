public class KartuKredit extends MetodePembayaran {

    private double limitKredit;
    private double totalTagihan;

    public KartuKredit(String pemilik, double limitKredit, double tagihanAwal) {
        super("Kartu Kredit", pemilik);
        this.limitKredit = limitKredit;
        this.totalTagihan = tagihanAwal;
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        return (totalTagihan + jumlah) <= limitKredit;
    }

    @Override
    protected void prosesDebit(double jumlah) {
        totalTagihan += jumlah;
    }

    @Override
    protected void tampilkanPesanGagal(double jumlah) {
        double sisaLimit = limitKredit - totalTagihan;
        System.out.printf("  Alasan : Melebihi limit kredit. Tagihan saat ini: Rp %,.0f | " +
                "Sisa limit: Rp %,.0f | Dibutuhkan: Rp %,.0f%n",
                totalTagihan, sisaLimit, jumlah);
    }

    @Override
    public double cekSaldo() {
        return limitKredit - totalTagihan;
    }

    public double getTotalTagihan() {
        return totalTagihan;
    }

    public double getLimitKredit() {
        return limitKredit;
    }
}