public class DompetDigital extends MetodePembayaran {

    private double saldo;
    private String namaAplikasi;

    public DompetDigital(String pemilik, String namaAplikasi, double saldoAwal) {
        super("Dompet Digital (" + namaAplikasi + ")", pemilik);
        this.namaAplikasi = namaAplikasi;
        this.saldo = saldoAwal;
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        return saldo >= jumlah;
    }

    @Override
    protected void prosesDebit(double jumlah) {
        saldo -= jumlah;
    }

    @Override
    protected void tampilkanPesanGagal(double jumlah) {
        System.out.printf("  Alasan : Saldo %s tidak mencukupi. Saldo: Rp %,.0f | Dibutuhkan: Rp %,.0f%n",
                namaAplikasi, saldo, jumlah);
    }

    @Override
    public double cekSaldo() {
        return saldo;
    }
}