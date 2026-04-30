class RekeningBank extends MetodePembayaran {
    private final double ADMIN = 2500;

    public RekeningBank(double saldo) {
        super(saldo);
    }

    @Override
    protected boolean validasiPembayaran(double jumlah) {
        return saldo >= (jumlah + ADMIN);
    }

    @Override
    public boolean bayar(double jumlah) {
        if (validasiPembayaran(jumlah)) {
            saldo -= (jumlah + ADMIN);
            riwayat.add("Transfer berhasil: " + jumlah + " + admin 2500");
            return true;
        } else {
            riwayat.add("Transfer gagal: " + jumlah);
            return false;
        }
    }
}