public class KartuKredit extends MetodePembayaran {
    private double limitKredit;
    private double totalTagihan;

    public KartuKredit(double limitKredit, double totalTagihan) {
        super("Kartu Kredit");
        this.limitKredit = limitKredit;
        this.totalTagihan = totalTagihan;
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        return (totalTagihan + jumlah) <= limitKredit;
    }

    @Override
    public void bayar(double jumlah) {
        System.out.println("Memproses pembayaran Kartu Kredit sebesar Rp " + jumlah + "...");
        if (validasiPembayaran(jumlah)) {
            totalTagihan += jumlah;
            System.out.println("Berhasil! Tagihan bertambah.\n");
            catatRiwayat("SUKSES", jumlah, "(Sisa limit: Rp " + (limitKredit - totalTagihan) + ")");
        } else {
            System.out.println("Gagal! Transaksi melebihi limit kredit.\n");
            catatRiwayat("GAGAL", jumlah, "(Overlimit)");
        }
    }

    @Override
    public void cekSaldo() {
        System.out.println("Info " + namaMetode + " - Total Tagihan: Rp " + totalTagihan + " | Sisa Limit: Rp " + (limitKredit - totalTagihan));
    }
}