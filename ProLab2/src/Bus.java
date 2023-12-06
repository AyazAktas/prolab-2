import javax.swing.*;
import java.util.List;

class Bus extends Vehicle {


    public Bus(String id, String tur, int kapasite, String yakitTuru) {
            this.id = id;
            this.tur = tur;
            this.yakitTuru = yakitTuru;
            this.kapasite=kapasite;
    }


    public Bus() {
        super();
        // Varsayılan değerlerle başlatma işlemleri burada yapılabilir
    }
    public int bosKoltukSayisi(){
        return kapasite-doluKoltukSayisi;
    }

    @Override
    public int calculateFuelCost(List<Trip> seferler){
        company company = new company();
        int toplamYol = 0;
        for (int i=0; i<seferler.size();i++){
            toplamYol += seferler.get(i).yolUzunlugu;
        }

        int fuelCost=0;
        for (int i=0;i<seferler.size();i++){
        if (seferler.get(i).arac.yakitTuru.equals("Benzin"))
        {
            int birimBenzinFiyati = company.birimBenzinFiyati;
            fuelCost=birimBenzinFiyati*toplamYol;
            return fuelCost;
        }
        if (seferler.get(i).arac.yakitTuru.equals("Motorin"))
        {
            int birimMotorinFiyati=company.birimMotorinFiyati;
            fuelCost=birimMotorinFiyati*toplamYol;
        }}
        return fuelCost;
    }

    // Bus'a özgü başka metotlar buraya eklenebilir.
}
