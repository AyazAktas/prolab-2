import javax.swing.*;

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
    public int calculateFuelCost(Route trip) {
        company company = new company();
        int yolUzunlugu= trip.toplamMesafe("Karayolu");
        int fuelCost=0;
        if (yakitTuru.equals("Benzin"))
        {
            int birimBenzinFiyati = company.birimBenzinFiyati;
            fuelCost=birimBenzinFiyati*yolUzunlugu;
            JOptionPane.showMessageDialog(null, "Güzergah için yakıt masrafı : "+fuelCost);
        }
        if (yakitTuru.equals("Motorin"))
        {
            int birimMotorinFiyati=company.birimMotorinFiyati;
            fuelCost=birimMotorinFiyati*yolUzunlugu;
            JOptionPane.showMessageDialog(null, "Güzergah için yakıt masrafı : "+fuelCost);

        }
        return yolUzunlugu;
    }

    // Bus'a özgü başka metotlar buraya eklenebilir.
}
