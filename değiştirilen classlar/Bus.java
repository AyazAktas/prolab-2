class Bus extends Vehicle {


    public Bus(String id, String tur, int kapasite, String yakitTuru) {
        super();
    }

    public Bus() {
        super();
        // Varsayılan değerlerle başlatma işlemleri burada yapılabilir
    }
    @Override
    public void calculateFuelCost() {
        // Otobüs için yakıt maliyeti hesaplama
    }

    // Bus'a özgü başka metotlar buraya eklenebilir.
}
