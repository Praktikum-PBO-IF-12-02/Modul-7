public class KartuKredit extends MetodePembayaran {
    private double limit;
    private double totalTagihan = 0;

    public KartuKredit(double limit) {
        super(0);
        this.limit = limit;
    }

    @Override
    boolean validasiPembayaran(double jumlah) {
        return (totalTagihan + jumlah) <= limit;
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            totalTagihan += jumlah;
            riwayat.add("Pembayaran dengan nominal Rp " + jumlah + " berhasil");
            System.out.println("Kartu Kredit : Pembayaran berhasil");
        } else {
            riwayat.add("Pembayaran dengan nominal Rp " + jumlah + " gagal, transaksi melebihi limit");
            System.out.println("Kartu Kredit : Pembayaran gagal");
        }
    }

    @Override
    public void cekSaldo() {
        System.out.println("Sisa limit: Rp " + (limit - totalTagihan));
    }
}