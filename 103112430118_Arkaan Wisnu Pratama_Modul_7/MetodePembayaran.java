import java.util.ArrayList;
import java.util.List;

public abstract class MetodePembayaran implements Pembayaran {

    protected String namaMetode;
    protected String pemilik;
    protected List<String> riwayatTransaksi;

    public MetodePembayaran(String namaMetode, String pemilik) {
        this.namaMetode = namaMetode;
        this.pemilik = pemilik;
        this.riwayatTransaksi = new ArrayList<>();
    }

    public abstract boolean validasiPembayaran(double jumlah);

    @Override
    public boolean bayar(double jumlah, String keterangan) {
        System.out.println("\n[" + namaMetode + "] Memproses pembayaran: " + keterangan);
        System.out.printf("  Jumlah: Rp %,.0f%n", jumlah);

        if (validasiPembayaran(jumlah)) {
            prosesDebit(jumlah);
            String record = String.format("BERHASIL | %s | Rp %,.0f | Saldo akhir: Rp %,.0f",
                    keterangan, jumlah, cekSaldo());
            riwayatTransaksi.add(record);
            System.out.println("  Status : BERHASIL ");
            System.out.printf("  Saldo sisa: Rp %,.0f%n", cekSaldo());
            return true;
        } else {
            String record = String.format("GAGAL | %s | Rp %,.0f | Saldo tidak mencukupi / limit terlampaui",
                    keterangan, jumlah);
            riwayatTransaksi.add(record);
            System.out.println("  Status : GAGAL");
            tampilkanPesanGagal(jumlah);
            return false;
        }
    }

    protected abstract void prosesDebit(double jumlah);

    protected void tampilkanPesanGagal(double jumlah) {
        System.out.println("Alasan : Validasi pembayaran tidak lolos.");
    }

    @Override
    public void getRiwayat() {
        System.out.println("\nRIWAYAT TRANSAKSI - " + namaMetode + " (" + pemilik + ")");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("  Belum ada transaksi.");
        } else {
            for (int i = 0; i < riwayatTransaksi.size(); i++) {
                System.out.printf("  %d. %s%n", i + 1, riwayatTransaksi.get(i));
            }
        }
    }

    public String getNamaMetode() {
        return namaMetode;
    }
}