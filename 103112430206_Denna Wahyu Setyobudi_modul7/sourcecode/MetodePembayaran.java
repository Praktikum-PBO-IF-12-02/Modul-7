import java.util.ArrayList;
import java.util.List;

public abstract class MetodePembayaran implements Pembayaran {
    protected String namaMetode;
    protected List<String> riwayatTransaksi;

    public MetodePembayaran(String namaMetode) {
        this.namaMetode = namaMetode;
        this.riwayatTransaksi = new ArrayList<>();
    }

    protected abstract boolean validasiPembayaran(double nominal);

    @Override
    public void getRiwayat() {
        System.out.println("Riwayat Transaksi - " + namaMetode + ":");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("- Belum ada transaksi.");
        } else {
            for (String riwayat : riwayatTransaksi) {
                System.out.println("- " + riwayat);
            }
        }
        System.out.println();
    }

    protected void tambahRiwayat(String pesan) {
        riwayatTransaksi.add(pesan);
    }
}