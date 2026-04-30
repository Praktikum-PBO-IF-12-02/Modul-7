public class RekeningBank extends MetodePembayaran {
    private double saldo;
    private final double BIAYA_ADMIN = 2500; 

    public RekeningBank(String namaMetode, double saldoAwal) {
        super(namaMetode);
        this.saldo = saldoAwal;
    }

    @Override
    protected boolean validasiPembayaran(double nominal) {
        return saldo >= (nominal + BIAYA_ADMIN);
    }

    @Override
    public void bayar(double nominal) {
        if (validasiPembayaran(nominal)) {
            saldo -= (nominal + BIAYA_ADMIN);
            tambahRiwayat("Berhasil: Bayar Rp" + nominal + " (+Admin Rp" + BIAYA_ADMIN + ") - Sisa Saldo: Rp" + saldo);
            System.out.println(namaMetode + " - Pembayaran Rp" + nominal + " BERHASIL.");
        } else {
            tambahRiwayat("Gagal: Bayar Rp" + nominal + " - Saldo tidak cukup (termasuk admin).");
            System.out.println(namaMetode + " - Pembayaran Rp" + nominal + " GAGAL.");
        }
    }

    @Override
    public double cekSaldo() {
        return saldo;
    }
}