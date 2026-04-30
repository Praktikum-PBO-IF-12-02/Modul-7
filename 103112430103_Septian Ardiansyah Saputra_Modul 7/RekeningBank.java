public class RekeningBank extends MetodePembayaran {
    private final double BIAYA_ADMIN = 2500;

    public RekeningBank(double saldo) {
        super(saldo);
    }

    @Override
    boolean validasiPembayaran(double jumlah) {
        return saldo >= (jumlah + BIAYA_ADMIN);
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= (jumlah + BIAYA_ADMIN);
            riwayat.add("Berhasil bayar Rp " + jumlah + " + admin Rp 2500");
            System.out.println("Rekening Bank : Pembayaran berhasil");
        } else {
            riwayat.add("Gagal bayar Rp " + jumlah + " (saldo tidak cukup + admin)");
            System.out.println("Rekening Bank : Pembayaran gagal");
        }
    }
}