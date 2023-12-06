public class Passenger extends Person{
    private String reservazyonKodu;

    public Passenger(String ad, String soyad, String tcKimlik , String dogumTarihi, String rezervasyonKodu) {
        super(ad, soyad, tcKimlik,dogumTarihi);
        this.reservazyonKodu = rezervasyonKodu;
    }

    public String getReservazyonKodu() {
        return reservazyonKodu;
    }

    public void setReservazyonKodu(String reservazyonKodu) {
        this.reservazyonKodu = reservazyonKodu;
    }
}
