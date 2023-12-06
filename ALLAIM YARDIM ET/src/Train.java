import javax.swing.*;

public class Train extends Vehicle {
    private int trackLength;

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
    public int calculateFuelCost(Route trip) {
        // Tren için yakıt maliyeti hesaplama
        company company = new company();
        int yolUzunlugu= trip.toplamMesafe("Demiryolu");
        int fuelCost=0;
        if (yakitTuru.equals("Elektrik"))
        {
            int birimElektrikFiyati=company.birimElektrikFiyati;
            fuelCost=birimElektrikFiyati*yolUzunlugu;
            JOptionPane.showMessageDialog(null, "Güzergah için yakıt masrafı : "+fuelCost);
        }

        return yolUzunlugu;
    }

    public int bosKoltukSayisi(){
        return kapasite-doluKoltukSayisi;
    }
}