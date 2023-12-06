import javax.swing.*;
import java.util.List;

public class Train extends Vehicle {
    private int trackLength;
    String yakitTuru ="Elektrik";
    public Train(String id, String tur, int kapasite,String yakitTuru) {
        this.id = id;
        this.tur = tur;
        this.yakitTuru = yakitTuru;
        this.kapasite=kapasite;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }


    public Train() {
        super();
        // Varsayılan değerlerle başlatma işlemleri burada yapılabilir
    }

    @Override
    public int calculateFuelCost(List<Trip> seferler) {
            company company = new company();
            int toplamYol = 0;
            for (int i=0; i<seferler.size();i++){
                toplamYol += seferler.get(i).yolUzunlugu;
            }
            int fuelCost=0;
            for (int i=0;i < seferler.size();i++){
            if(seferler.get(i).arac.yakitTuru.equals("Elektrik")){
            int birimBenzinFiyati = company.birimBenzinFiyati;
            fuelCost=birimBenzinFiyati*toplamYol;}}
            return fuelCost;
    }


    public int bosKoltukSayisi(){
        return kapasite-doluKoltukSayisi;
    }
}