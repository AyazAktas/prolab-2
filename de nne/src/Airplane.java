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
    public void calculateFuelCost() {
        // Uçak için yakıt maliyeti hesaplama
    }

    // Airplane'e özgü başka metotlar buraya eklenebilir.
}