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
    public void calculateFuelCost() {
        // Tren için yakıt maliyeti hesaplama
        // Implementasyon buraya eklenecek
    }
}