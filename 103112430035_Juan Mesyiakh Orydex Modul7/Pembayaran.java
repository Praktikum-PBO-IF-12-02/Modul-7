import java.util.*;
public interface Pembayaran {
    void bayar(double jumlah);
    double cekSaldo();
    List<String> getRiwayat();
}
