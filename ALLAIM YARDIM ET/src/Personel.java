public class Personel extends Person{
    private String personelId;

    public Personel(String ad, String soyad, String tcKimlik , String dogumTarihi,String personelId) {
        super(ad, soyad ,tcKimlik,dogumTarihi);
        this.personelId=personelId;

    }
    public String getPersonelId()
    {
        return personelId;
    }
    public  void setPersonelId()
    {
        this.personelId=personelId;
    }


}
