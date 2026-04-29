public class DompetDigital extends MetodePembayaran {
    private double saldo;

    public DompetDigital(String namaMetode, double saldoAwal) {
        super(namaMetode);
        this.saldo = saldoAwal;
    }

    @Override
    boolean validasiPembayaran(double nominal) {
        return saldo >= nominal;
    }

    @Override
    public void bayar(double nominal) {
        System.out.println("Memproses pembayaran Rp" + nominal + " dengan " + namaMetode + "...");
        if (validasiPembayaran(nominal)) {
            saldo -= nominal;
            System.out.println("[SUKSES] Pembayaran berhasil.");
            rekamJejak("SUKSES", nominal, "Sisa Saldo: Rp" + saldo);
        } else {
            System.out.println("[GAGAL] Saldo tidak mencukupi.");
            rekamJejak("GAGAL", nominal, "Saldo Kurang");
        }
    }

    @Override
    public void cekSaldo() {
        System.out.println("Saldo " + namaMetode + " saat ini: Rp" + saldo);
    }
}