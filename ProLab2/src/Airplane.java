import javax.swing.*;
import java.util.List;

class Airplane extends Vehicle {
    private int maxAltitude;

    String yakitTuru = "Gaz";
    public Airplane(String id, String tur, int kapasite) {
        this.id = id;
        this.tur = tur;
        this.yakitTuru = yakitTuru;
        this.kapasite=kapasite;
    }
    public Airplane() {
        super();
        // Varsayılan değerlerle başlatma işlemleri burada yapılabilir
    }

    @Override
    public int calculateFuelCost(List<Trip> seferler){
        company company = new company();
        int toplamYol = 0;
        for (int i=0; i<seferler.size();i++){
            toplamYol += seferler.get(i).yolUzunlugu;
        }

        int fuelCost=0;
        for (int i = 0; i<seferler.size();i++){
        if(yakitTuru.equals("Gaz")){
        int birimBenzinFiyati = company.birimBenzinFiyati;
        fuelCost=birimBenzinFiyati*toplamYol;
       }}
        return fuelCost;
    }

    public int bosKoltukSayisi(){
        return kapasite-doluKoltukSayisi;
    }

    // Airplane'e özgü başka metotlar buraya eklenebilir.
}