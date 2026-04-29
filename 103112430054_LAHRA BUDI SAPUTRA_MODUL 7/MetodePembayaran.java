import java.util.ArrayList;
import java.util.List;

public abstract class MetodePembayaran implements Pembayaran {
    protected List<String> riwayatTransaksi = new ArrayList<>();
    protected String namaMetode;

    public MetodePembayaran(String namaMetode) {
        this.namaMetode = namaMetode;
    }

    abstract boolean validasiPembayaran(double nominal);

    @Override
    public void getRiwayat() {
        System.out.println("=== Riwayat Transaksi: " + namaMetode + " ===");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (String riwayat : riwayatTransaksi) {
                System.out.println(riwayat);
            }
        }
        System.out.println();
    }

    protected void rekamJejak(String status, double nominal, String keteranganTambahan) {
        riwayatTransaksi.add("- " + status + " | Rp" + nominal + " | " + keteranganTambahan);
    }
}