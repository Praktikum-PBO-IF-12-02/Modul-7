import java.util.ArrayList;

interface Pembayaran {
    void bayar(double nominal);
    void cekSaldo();
    void getRiwayat();
}

abstract class MetodePembayaran implements Pembayaran {
    protected double saldo;
    protected ArrayList<String> riwayat = new ArrayList<>();

    public MetodePembayaran(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void cekSaldo() {
        System.out.println("Saldo/Tagihan : Rp " + saldo);
    }

    @Override
    public void getRiwayat() {
        System.out.println("--- Riwayat Transaksi ---");
        // Jika riwayat kosong, beri tahu pengguna
        if (riwayat.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (String r : riwayat) {
                System.out.println(r);
            }
        }
        System.out.println("-------------------------");
    }

    public abstract boolean validasiPembayaran(double nominal);
}


class DompetDigital extends MetodePembayaran {

    public DompetDigital(double saldoAwal) {
        super(saldoAwal);
    }

    @Override
    public boolean validasiPembayaran(double nominal) {
        if (saldo >= nominal) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void bayar(double nominal) {
        if (validasiPembayaran(nominal) == true) {
            saldo = saldo - nominal;
            // INI YANG TERLEWAT: Catat ke riwayat jika sukses
            riwayat.add("Sukses: Pembayaran Dompet Digital Rp" + nominal);
        } else {
            riwayat.add("Gagal: Saldo Dompet Digital tidak cukup untuk Rp" + nominal);
        }
    }
}


class KartuKredit extends MetodePembayaran {
    private double limitKredit;

    public KartuKredit(double saldoAwal, double limitKredit) {
        super(saldoAwal);
        this.limitKredit = limitKredit;
    }

    @Override
    public boolean validasiPembayaran(double nominal) {
        if (saldo + nominal <= limitKredit) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void bayar(double nominal) {
        if (validasiPembayaran(nominal) == true) {
            // PERBAIKAN: Kartu kredit menambah tagihan, bukan mengurangi
            saldo = saldo + nominal;
            riwayat.add("Sukses: Pembayaran Kartu Kredit Rp" + nominal);
        } else {
            riwayat.add("Gagal: Pembayaran Kartu Kredit Rp" + nominal + " melebihi limit!");
        }
    }
}


class RekeningBank extends MetodePembayaran {

    public RekeningBank(double saldoAwal) {
        super(saldoAwal);
    }

    @Override
    public boolean validasiPembayaran(double nominal) {
        if (saldo >= nominal + 2500) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void bayar(double nominal) {
        if (validasiPembayaran(nominal) == true) {
            saldo = saldo - (nominal + 2500);
            riwayat.add("Sukses: Pembayaran Rekening Bank Rp" + nominal + " (Biaya Admin Rp2.500)");
        } else {
            riwayat.add("Gagal: Saldo Rekening Bank tidak cukup untuk Rp" + nominal + " + Admin");
        }
    }
}


public class Modul_7_103112430269_ArbyNassandro {
    public static void main(String[] args) {
        
        System.out.println("=== SIMULASI DOMPET DIGITAL ===");
        DompetDigital gopay = new DompetDigital(100000); 
        gopay.bayar(50000);  // Sukses
        gopay.bayar(30000);  // Sukses
        gopay.bayar(70000);  // Gagal (sisa 20rb)
        gopay.cekSaldo();
        gopay.getRiwayat();

        System.out.println("\n=== SIMULASI KARTU KREDIT ===");
        // Saldo awal di sini berfungsi sebagai tagihan (mulai dari 0), limit 5 juta
        KartuKredit cc = new KartuKredit(0, 5000000); 
        cc.bayar(2000000); // Sukses
        cc.bayar(4000000); // Gagal (tagihan 2jt + 4jt = 6jt, lewati limit 5jt)
        cc.cekSaldo(); 
        cc.getRiwayat();

        System.out.println("\n=== SIMULASI REKENING BANK ===");
        RekeningBank bca = new RekeningBank(100000); 
        bca.bayar(50000); // Sukses (potong 52.500, sisa 47.500)
        bca.bayar(48000); // Gagal (butuh 48.000 + 2.500 = 50.500)
        bca.cekSaldo();
        bca.getRiwayat();
    }
}