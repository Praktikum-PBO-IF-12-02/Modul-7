public class DompetDigital extends MetodePembayaran {

    public DompetDigital(double saldo) {
        super(saldo);
    }

    @Override
    boolean validasiPembayaran(double jumlah) {
        return saldo >= jumlah;
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= jumlah;
            riwayat.add("Berhasil bayar Rp " + jumlah);
            System.out.println("Dompet Digital : Pembayaran berhasil");
        } else {
            riwayat.add("Gagal bayar Rp " + jumlah + " (saldo tidak cukup)");
            System.out.println("Dompet Digital : Pembayaran gagal");
        }
    }
}