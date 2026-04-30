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
            riwayat.add("Pembayaran dengan nominal Rp " + jumlah + " berhasil (biaya admin Rp " + BIAYA_ADMIN + ")");
            System.out.println("Rekening Bank : Pembayaran berhasil");
        } else {
            riwayat.add("Pembayaran dengan nominal Rp " + jumlah + " gagal, saldo anda tidak cukup untuk membayar biaya admin sebesar Rp " + BIAYA_ADMIN);
            System.out.println("Rekening Bank : Pembayaran gagal");
        }
    }
}