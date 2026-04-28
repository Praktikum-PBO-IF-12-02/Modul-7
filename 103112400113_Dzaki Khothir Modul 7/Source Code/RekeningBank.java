public class RekeningBank extends MetodePembayaran {
    private final double BIAYA_ADMIN = 2500;

    public RekeningBank(double saldo) {
        super(saldo);
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return saldo >= (jumlah + BIAYA_ADMIN);
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= (jumlah + BIAYA_ADMIN);
            riwayat.add("Pembayaran berhasil: Rp " + jumlah + " + admin");
            System.out.println("Pembayaran berhasil.");
        } else {
            riwayat.add("Pembayaran gagal: Rp " + jumlah);
            System.out.println("Pembayaran gagal.");
        }
    }
}