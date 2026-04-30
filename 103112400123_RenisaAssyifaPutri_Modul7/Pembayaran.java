import java.util.ArrayList;

public interface Pembayaran {
    boolean bayar(double jumlah);
    double cekSaldo();
    ArrayList<String> getRiwayat();
}