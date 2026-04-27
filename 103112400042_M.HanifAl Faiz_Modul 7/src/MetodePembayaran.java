import java.util.ArrayList;
import java.util.List;

public abstract class MetodePembayaran implements Pembayaran {
    protected List<String> riwayatTransaksi;
    protected String namaMetode;

    public MetodePembayaran(String namaMetode) {
        this.namaMetode = namaMetode;
        this.riwayatTransaksi = new ArrayList<>();
    }

    public abstract boolean validasiPembayaran(double jumlah);

    protected void catatRiwayat(String status, double jumlah, String keterangan) {
        String riwayat = String.format("[%s] %s - Rp %,.2f %s", namaMetode, status, jumlah, keterangan);
        riwayatTransaksi.add(riwayat);
    }

    @Override
    public void getRiwayat() {
        System.out.println("--- Riwayat Transaksi: " + namaMetode + " ---");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (String riwayat : riwayatTransaksi) {
                System.out.println(riwayat);
            }
        }
        System.out.println();
    }
}