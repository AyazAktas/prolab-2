import java.util.ArrayList;
import java.util.List;

public class Reservation {
    Vehicle arac;
    int yolcununKoltukSayisi;
    Passenger passenger;
    static List<Reservation> rezervasyonBilgileri= new ArrayList<>();
    Reservation(){

    }
    Reservation(Passenger passenger, Vehicle arac, int yolcununKoltukSayisi){
        this.arac = arac;
        this.passenger = passenger;
        this.yolcununKoltukSayisi= yolcununKoltukSayisi;
    }
}
