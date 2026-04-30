public class Main {
    public static void main(String[] args) {

        DompetDigital dompet = new DompetDigital(100000);
        dompet.bayar(50000); 
        dompet.bayar(60000);  

        System.out.println("\nRiwayat Dompet Digital:");
        dompet.getRiwayat();

        KartuKredit kartu = new KartuKredit(100000);
        kartu.bayar(40000);   
        kartu.bayar(70000);  

        System.out.println("\nRiwayat Kartu Kredit:");
        kartu.getRiwayat();

        RekeningBank bank = new RekeningBank(100000);
        bank.bayar(50000);  
        bank.bayar(48000);  
        System.out.println("\nRiwayat Rekening Bank:");
        bank.getRiwayat();
    }
}