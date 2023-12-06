abstract class Vehicle {
    public String id;
    public String tur;
    public String yakitTuru;

    public int kapasite;

    public Vehicle(String id, String tur, String yakitTuru, int kapasite) {
        this.id = id;
        this.tur = tur;
        this.yakitTuru = yakitTuru;
        this.kapasite=kapasite;
    }
    public Vehicle(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return tur;
    }

    public void setYear(int year) {
        this.tur = tur ;
    }

    public String getYakitTuru() {
        return yakitTuru;
    }

    public void setYakitTuru(String yakitTuru) {
        this.yakitTuru = yakitTuru;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public abstract int calculateFuelCost(Route trip);


    // Getter ve setter metotları buraya eklenebilir.
}