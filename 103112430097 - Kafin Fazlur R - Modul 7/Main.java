import java.util.*;

interface Pembayaran {
    void bayar(double jumlah);
    double cekSaldo();
    List<String> getRiwayat();
}

abstract class MetodePembayaran implements Pembayaran {
    protected double saldo;
    protected List<String> riwayat = new ArrayList<>();

    public MetodePembayaran(double saldoAwal) {
        this.saldo = saldoAwal;
    }

    protected abstract boolean validasiPembayaran(double jumlah);

    @Override
    public double cekSaldo() {
        return saldo;
    }

    @Override
    public List<String> getRiwayat() {
        return riwayat;
    }
}

class DompetDigital extends MetodePembayaran {

    public DompetDigital(double saldoAwal) {
        super(saldoAwal);
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return saldo >= jumlah;
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= jumlah;
            riwayat.add("DompetDigital: Bayar " + jumlah + " (BERHASIL)");
        } else {
            riwayat.add("DompetDigital: Bayar " + jumlah + " (GAGAL - saldo kurang)");
        }
    }
}

class KartuKredit extends MetodePembayaran {
    private double limit;
    private double totalTagihan = 0;

    public KartuKredit(double limit) {
        super(0); 
        this.limit = limit;
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return (totalTagihan + jumlah) <= limit;
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            totalTagihan += jumlah;
            riwayat.add("KartuKredit: Bayar " + jumlah + " (BERHASIL)");
        } else {
            riwayat.add("KartuKredit: Bayar " + jumlah + " (GAGAL - melebihi limit)");
        }
    }

    @Override
    public double cekSaldo() {
        return limit - totalTagihan;
    }
}

class RekeningBank extends MetodePembayaran {
    private final double biayaAdmin = 2500;

    public RekeningBank(double saldoAwal) {
        super(saldoAwal);
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return saldo >= (jumlah + biayaAdmin);
    }

    @Override
    public void bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= (jumlah + biayaAdmin);
            riwayat.add("RekeningBank: Bayar " + jumlah + " + admin (BERHASIL)");
        } else {
            riwayat.add("RekeningBank: Bayar " + jumlah + " (GAGAL - saldo kurang)");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        DompetDigital dompet = new DompetDigital(50000);
        KartuKredit kartu = new KartuKredit(100000);
        RekeningBank bank = new RekeningBank(50000);

        
        dompet.bayar(20000); 
        dompet.bayar(40000); 

        
        kartu.bayar(50000); 
        kartu.bayar(60000); 

        
        bank.bayar(20000); 
        bank.bayar(40000); 

        
        System.out.println("=== RIWAYAT TRANSAKSI ===");

        for (String r : dompet.getRiwayat()) {
            System.out.println(r);
        }

        for (String r : kartu.getRiwayat()) {
            System.out.println(r);
        }

        for (String r : bank.getRiwayat()) {
            System.out.println(r);
        }
    }
}