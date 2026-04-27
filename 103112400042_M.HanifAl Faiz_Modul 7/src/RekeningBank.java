public class RekeningBank extends MetodePembayaran {
    private double saldo;
    private final double BIAYA_ADMIN = 2500.0;

    public RekeningBank(double saldoAwal) {
        super("Rekening Bank");
        this.saldo = saldoAwal;
    }

    @Override
    public boolean validasiPembayaran(double jumlah) {
        return saldo >= (jumlah + BIAYA_ADMIN);
    }

    @Override
    public void bayar(double jumlah) {
        System.out.println("Memproses pembayaran Rekening Bank sebesar Rp " + jumlah + "...");
        if (validasiPembayaran(jumlah)) {
            saldo -= (jumlah + BIAYA_ADMIN);
            System.out.println("Berhasil! Saldo terpotong beserta biaya admin Rp " + BIAYA_ADMIN + ".\n");
            catatRiwayat("SUKSES", jumlah, "(+ Admin Rp 2.500)");
        } else {
            System.out.println("Gagal! Saldo tidak mencukupi untuk bayar + biaya admin.\n");
            catatRiwayat("GAGAL", jumlah, "(Saldo < total + admin)");
        }
    }

    @Override
    public void cekSaldo() {
        System.out.println("Saldo " + namaMetode + ": Rp " + saldo);
    }
}