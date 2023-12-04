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
    @Override
    public void calculateFuelCost() {
        // Otobüs için yakıt maliyeti hesaplama
    }

    // Bus'a özgü başka metotlar buraya eklenebilir.
}
