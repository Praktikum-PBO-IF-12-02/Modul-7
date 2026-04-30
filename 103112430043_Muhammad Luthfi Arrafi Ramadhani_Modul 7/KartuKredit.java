class KartuKredit extends MetodePembayaran {
    private double limit;
    private double tagihan = 0;

    public KartuKredit(double limit) {
        super(0);
        this.limit = limit;
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return (tagihan + jumlah) <= limit;
    }

    @Override
    public boolean bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            tagihan += jumlah;
            riwayat.add("Transaksi berhasil: " + jumlah);
            return true;
        } else {
            riwayat.add("Transaksi gagal: " + jumlah);
            return false;
        }
    }

    @Override
    public double cekSaldo() {
        return limit - tagihan; 
    }
}