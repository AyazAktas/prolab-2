import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Passenger extends Person{
    static List<Passenger> yolcuBilgileri = new ArrayList<>();
    private int reservazyonKodu;

    public Passenger(String ad, String soyad, String tcKimlik , String dogumTarihi) {
        super(ad, soyad, tcKimlik,dogumTarihi);
        Random random = new Random();
        reservazyonKodu = random.nextInt(9000)+1000;

    }

    public int getReservazyonKodu() {
        return reservazyonKodu;
    }

    public void setReservazyonKodu(int reservazyonKodu) {
        this.reservazyonKodu = reservazyonKodu;
    }
}
