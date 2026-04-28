public class KartuKredit extends MetodePembayaran {
    private double limit;
    private double tagihan;

    public KartuKredit(double limit) {
        super(0); // saldo ga kepake
        this.limit = limit;
        this.tagihan = 0;
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return (tagihan + jumlah) <= limit;
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            tagihan += jumlah;
            riwayat.add("Pembayaran berhasil: Rp " + jumlah);
            System.out.println("Pembayaran berhasil.");
        } else {
            riwayat.add("Pembayaran gagal: Rp " + jumlah);
            System.out.println("Pembayaran gagal.");
        }
    }

    @Override
    public double cekSaldo() {
        return limit - tagihan;
    }
}