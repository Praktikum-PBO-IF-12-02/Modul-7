public class DompetDigital extends MetodePembayaran {
    private double saldo;

    public DompetDigital(String namaMetode, double saldoAwal) {
        super(namaMetode);
        this.saldo = saldoAwal;
    }

    @Override
    protected boolean validasiPembayaran(double nominal) {
        return saldo >= nominal;
    }

    @Override
    public void bayar(double nominal) {
        if (validasiPembayaran(nominal)) {
            saldo -= nominal;
            tambahRiwayat("Berhasil: Bayar Rp" + nominal + " - Sisa Saldo: Rp" + saldo);
            System.out.println(namaMetode + " - Pembayaran Rp" + nominal + " BERHASIL.");
        } else {
            tambahRiwayat("Gagal: Bayar Rp" + nominal + " - Saldo tidak mencukupi.");
            System.out.println(namaMetode + " - Pembayaran Rp" + nominal + " GAGAL.");
        }
    }

    @Override
    public double cekSaldo() {
        return saldo;
    }
}