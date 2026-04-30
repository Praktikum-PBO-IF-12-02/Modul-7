import java.util.*;

// ================= Interface =================
interface Pembayaran {
    boolean bayar(double jumlah);
    double cekSaldo();
    List<String> getRiwayat();
    void tambahSaldo(double jumlah);
}

// ================= Abstract =================
abstract class MetodePembayaran implements Pembayaran {
    protected double saldo;
    protected double limit;
    protected List<String> riwayat = new ArrayList<>();

    public MetodePembayaran(double saldo, double limit) {
        this.saldo = saldo;
        this.limit = limit;
    }

    public double cekSaldo() {
        return saldo;
    }

    public List<String> getRiwayat() {
        return riwayat;
    }

    public void tambahSaldo(double jumlah) {
        if (saldo + jumlah <= limit) {
            saldo += jumlah;
            riwayat.add("TOP UP: " + jumlah);
            System.out.println("Top up berhasil");
        } else {
            riwayat.add("GAGAL TOP UP: " + jumlah);
            System.out.println("Gagal! Melebihi limit maksimum");
        }
    }

    public boolean bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            prosesPembayaran(jumlah);
            riwayat.add("SUKSES: " + jumlah);
            return true;
        } else {
            riwayat.add("GAGAL: " + jumlah);
            return false;
        }
    }

    protected abstract boolean validasiPembayaran(double jumlah);
    protected abstract void prosesPembayaran(double jumlah);
}

// ================= Dompet Digital =================
class DompetDigital extends MetodePembayaran {
    public DompetDigital(double saldo, double limit) {
        super(saldo, limit);
    }

    protected boolean validasiPembayaran(double jumlah) {
        return saldo >= jumlah;
    }

    protected void prosesPembayaran(double jumlah) {
        saldo -= jumlah;
    }
}

// ================= Kartu Kredit =================
class KartuKredit extends MetodePembayaran {
    public KartuKredit(double saldo, double limit) {
        super(saldo, limit);
    }

    protected boolean validasiPembayaran(double jumlah) {
        return saldo >= jumlah;
    }

    protected void prosesPembayaran(double jumlah) {
        saldo -= jumlah;
    }
}

// ================= Rekening Bank =================
class RekeningBank extends MetodePembayaran {
    private final double BIAYA_ADMIN = 2500;

    public RekeningBank(double saldo, double limit) {
        super(saldo, limit);
    }

    protected boolean validasiPembayaran(double jumlah) {
        return saldo >= (jumlah + BIAYA_ADMIN);
    }

    protected void prosesPembayaran(double jumlah) {
        saldo -= (jumlah + BIAYA_ADMIN);
    }

    @Override
    public boolean bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            prosesPembayaran(jumlah);
            riwayat.add("SUKSES TF: " + jumlah + " + admin 2500");
            return true;
        } else {
            riwayat.add("GAGAL TF: " + jumlah + " (saldo kurang + admin)");
            return false;
        }
    }
}

// ================= Main =================
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DompetDigital dompet = new DompetDigital(100000, 200000);
        KartuKredit kartu = new KartuKredit(50000, 200000);
        RekeningBank bank = new RekeningBank(100000, 300000);

        while (true) {
            System.out.println("\n=== PILIH METODE ===");
            System.out.println("1. Dompet Digital");
            System.out.println("2. Kartu Kredit");
            System.out.println("3. Rekening Bank");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int metode = input.nextInt();
            if (metode == 0) break;

            MetodePembayaran selected = null;
            String nama = "";

            switch (metode) {
                case 1: selected = dompet; nama = "Dompet Digital"; break;
                case 2: selected = kartu; nama = "Kartu Kredit"; break;
                case 3: selected = bank; nama = "Rekening Bank"; break;
                default: continue;
            }

            System.out.println("\n=== " + nama + " ===");
            System.out.println("1. Bayar / Transfer");
            System.out.println("2. Cek Saldo");
            System.out.println("3. Riwayat");
            System.out.println("4. Top Up");
            System.out.print("Pilih: ");
            int aksi = input.nextInt();

            switch (aksi) {
                case 1:
                    if (selected instanceof RekeningBank) {
                        System.out.println("Transfer ke: Opet");
                        System.out.println("Biaya admin: Rp 2500");
                    }

                    System.out.print("Nominal: ");
                    double n = input.nextDouble();

                    if (selected instanceof RekeningBank) {
                        System.out.println("Total dipotong: Rp " + (n + 2500));
                    }

                    System.out.println(selected.bayar(n) ? "Berhasil" : "Gagal");
                    break;

                case 2:
                    System.out.println("Saldo: Rp " + selected.cekSaldo());
                    break;

                case 3:
                    System.out.println("=== RIWAYAT ===");
                    selected.getRiwayat().forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Nominal top up: ");
                    double t = input.nextDouble();
                    selected.tambahSaldo(t);
                    break;
            }
        }

        input.close();
    }
}