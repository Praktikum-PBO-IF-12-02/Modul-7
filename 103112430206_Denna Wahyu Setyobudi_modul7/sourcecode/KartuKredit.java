public class KartuKredit extends MetodePembayaran {
    private double tagihan;
    private double limitKredit;

    public KartuKredit(String namaMetode, double limitKredit) {
        super(namaMetode);
        this.limitKredit = limitKredit;
        this.tagihan = 0; 
    }

    @Override
    protected boolean validasiPembayaran(double nominal) {
        return (tagihan + nominal) <= limitKredit;
    }

    @Override
    public void bayar(double nominal) {
        if (validasiPembayaran(nominal)) {
            tagihan += nominal;
            tambahRiwayat("Berhasil: Bayar Rp" + nominal + " - Total Tagihan: Rp" + tagihan);
            System.out.println(namaMetode + " - Pembayaran Rp" + nominal + " BERHASIL.");
        } else {
            tambahRiwayat("Gagal: Bayar Rp" + nominal + " - Melebihi limit kredit.");
            System.out.println(namaMetode + " - Pembayaran Rp" + nominal + " GAGAL.");
        }
    }

    @Override
    public double cekSaldo() {
        return limitKredit - tagihan; 
    }
}