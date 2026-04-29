public class KartuKredit extends MetodePembayaran {
    private double limitKredit;
    private double totalTagihan;

    public KartuKredit(String namaMetode, double limitKredit) {
        super(namaMetode);
        this.limitKredit = limitKredit;
        this.totalTagihan = 0;
    }

    @Override
    boolean validasiPembayaran(double nominal) {
        return (totalTagihan + nominal) <= limitKredit;
    }

    @Override
    public void bayar(double nominal) {
        System.out.println("Memproses pembayaran Rp" + nominal + " dengan " + namaMetode + "...");
        if (validasiPembayaran(nominal)) {
            totalTagihan += nominal;
            System.out.println("[SUKSES] Pembayaran berhasil.");
            rekamJejak("SUKSES", nominal, "Total Tagihan: Rp" + totalTagihan);
        } else {
            System.out.println("[GAGAL] Melebihi limit kredit.");
            rekamJejak("GAGAL", nominal, "Over Limit");
        }
    }

    @Override
    public void cekSaldo() {
        System.out.println("Tagihan " + namaMetode + " saat ini: Rp" + totalTagihan + " (Limit: Rp" + limitKredit + ")");
    }
}