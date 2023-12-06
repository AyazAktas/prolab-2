import java.util.List;

abstract class Vehicle {
    public String id;
    public String tur;
    public String yakitTuru;

    public int kapasite;
    public int doluKoltukSayisi;
    public int bosKoltuk;


    public Vehicle(String id, String tur, String yakitTuru, int kapasite , int doluKoltukSayisi ,int bosKoltuk) {
        this.id = id;
        this.tur = tur;
        this.yakitTuru = yakitTuru;
        this.doluKoltukSayisi=doluKoltukSayisi;
        this.kapasite=kapasite;
    }
    public Vehicle(){

    }

    public int getBosKoltuk() {
        return bosKoltuk;
    }

    public void setBosKoltuk(int bosKoltuk) {
        this.bosKoltuk = bosKoltuk;
    }

    public int getDoluKoltukSayisi() {
        return doluKoltukSayisi;
    }

    public void setDoluKoltukSayisi(int doluKoltukSayisi) {
        this.doluKoltukSayisi = doluKoltukSayisi;
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

    public abstract int calculateFuelCost(List<Trip> seferler);


    public int bosKoltukSayisi() {
        return (kapasite-doluKoltukSayisi);
    }


    // Getter ve setter metotları buraya eklenebilir.
}