public class DompetDigital extends MetodePembayaran {
    private double saldo;

    public DompetDigital(double saldoAwal) {
        super("Dompet Digital (GoPay/OVO)");
        this.saldo = saldoAwal;
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        return saldo >= jumlah;
    }

    @Override
    public void bayar(double jumlah) {
        System.out.println("Memproses pembayaran Dompet Digital sebesar Rp " + jumlah + "...");
        if (validasiPembayaran(jumlah)) {
            saldo -= jumlah;
            System.out.println("Berhasil! Pembayaran sukses.\n");
            catatRiwayat("SUKSES", jumlah, "(Pembayaran berhasil)");
        } else {
            System.out.println("Gagal! Saldo tidak mencukupi.\n");
            catatRiwayat("GAGAL", jumlah, "(Saldo tidak cukup)");
        }
    }

    @Override
    public void cekSaldo() {
        System.out.println("Saldo " + namaMetode + ": Rp " + saldo);
    }
}