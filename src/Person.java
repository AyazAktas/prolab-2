import javax.swing.*;

public abstract class Person extends JFrame {
    private String ad;
    private String soyad;

    private String tcKimlik;

    private String dogumTarihi;

    public Person(String ad, String soyad, String tcKimlik, String dogumTarihi) {
        this.ad = ad;
        this.soyad = soyad;
        this.tcKimlik = tcKimlik;
        this.dogumTarihi = dogumTarihi;
    }

    public Person(){

    }
// tc ,doğum tarihi:  doğum tarihi seçme ekranı yapılabilir .

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTcKimlik() {
        return tcKimlik;
    }

    public void setTcKimlik(String tcKimlik) {
        this.tcKimlik = tcKimlik;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }


}
