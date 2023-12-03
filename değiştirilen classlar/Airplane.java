class Airplane extends Vehicle {
    private int maxAltitude;

    public Airplane(String id, String tur, String yakitTuru, int kapasite, int maxAltitude) {
        super();
        this.maxAltitude = maxAltitude;
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