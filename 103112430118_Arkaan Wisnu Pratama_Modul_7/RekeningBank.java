public class RekeningBank extends MetodePembayaran {

    private double saldo;
    private String namaBank;
    private static final double BIAYA_ADMIN = 2500.0;

    public RekeningBank(String pemilik, String namaBank, double saldoAwal) {
        super("Rekening Bank (" + namaBank + ")", pemilik);
        this.namaBank = namaBank;
        this.saldo = saldoAwal;
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        return saldo >= (jumlah + BIAYA_ADMIN);
    }

    @Override
    protected void prosesDebit(double jumlah) {
        saldo -= (jumlah + BIAYA_ADMIN);
    }

    @Override
    protected void tampilkanPesanGagal(double jumlah) {
        double totalDibutuhkan = jumlah + BIAYA_ADMIN;
        System.out.printf("  Alasan : Saldo tidak mencukupi di %s (termasuk biaya admin Rp %,.0f). " +
                "Saldo: Rp %,.0f | Dibutuhkan: Rp %,.0f%n",
                namaBank, BIAYA_ADMIN, saldo, totalDibutuhkan);
    }

    @Override
    public boolean bayar(double jumlah, String keterangan) {
        System.out.printf("  Info   : Akan dipotong biaya admin sebesar Rp %,.0f%n", BIAYA_ADMIN);
        return super.bayar(jumlah, keterangan);
    }

    @Override
    public double cekSaldo() {
        return saldo;
    }

    public static double getBiayaAdmin() {
        return BIAYA_ADMIN;
    }
}