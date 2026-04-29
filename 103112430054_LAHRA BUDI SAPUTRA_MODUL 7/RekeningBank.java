public class RekeningBank extends MetodePembayaran {
    private double saldo;
    private final double BIAYA_ADMIN = 2500;

    public RekeningBank(String namaMetode, double saldoAwal) {
        super(namaMetode);
        this.saldo = saldoAwal;
    }

    @Override
    boolean validasiPembayaran(double nominal) {
        return saldo >= (nominal + BIAYA_ADMIN);
    }

    @Override
    public void bayar(double nominal) {
        System.out.println("Memproses pembayaran Rp" + nominal + " dengan " + namaMetode + "...");
        if (validasiPembayaran(nominal)) {
            saldo -= (nominal + BIAYA_ADMIN);
            System.out.println("[SUKSES] Pembayaran berhasil (Termasuk Admin Rp2500).");
            rekamJejak("SUKSES", nominal, "Dipotong Admin Rp2500. Sisa Saldo: Rp" + saldo);
        } else {
            System.out.println("[GAGAL] Saldo tidak mencukupi untuk bayar + admin.");
            rekamJejak("GAGAL", nominal, "Saldo Kurang");
        }
    }

    @Override
    public void cekSaldo() {
        System.out.println("Saldo " + namaMetode + " saat ini: Rp" + saldo);
    }
}