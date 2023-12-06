import javax.swing.*;

class Airplane extends Vehicle {
    private int maxAltitude;

    String yakitTuru = "Elektrik";
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
    public int calculateFuelCost(Route trip) {
        company company = new company();
        int yolUzunlugu= trip.toplamMesafe("Havayolu");
        int fuelCost=0;
        if (yakitTuru.equals("Gaz"))
        {
            int birimGazFiyati=company.birimGazFiyati;
            fuelCost=birimGazFiyati*yolUzunlugu;
            JOptionPane.showMessageDialog(null, "Güzergah için yakıt masrafı : "+fuelCost);
        }
        return fuelCost;
    }

    // Airplane'e özgü başka metotlar buraya eklenebilir.
}