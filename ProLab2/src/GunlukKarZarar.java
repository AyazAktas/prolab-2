public class GunlukKarZarar extends company {
    private company company;
    private Vehicle arac;

    public GunlukKarZarar() {
        this.company = new company();
        // Assuming you want to use a Train for the example


    }
    public int gunlukKar(company company) {
        int count=0;
        String[] idList = new String[havaAraclari.size()];
        for (int i = 0; i < havaAraclari.size(); i++) {
            idList[i] = havaAraclari.get(i).id;
            count++;
        }
        Airplane airplane= new Airplane();
        Train train = new Train();
        Bus bus =new Bus();
        //int AirplaneFuelCost= airplane.calculateFuelCost() * count;
        double biletGeliri = company.bakiye;
        double hizmetBedeli = company.hizmetBedeli;
        double hizmetPersonelUcreti = company.seferBasiHizmetPersonelUcreti;
        double aracPersonelUcreti = company.seferBasiAracPersonelUcreti;
        //double fuelCost = arac.calculateFuelCost(/* Pass the appropriate Route object */);
        double ciro = biletGeliri - hizmetBedeli - hizmetPersonelUcreti - aracPersonelUcreti - airplane.calculateFuelCost(company.seyahatBilgileri)
                -train.calculateFuelCost(company.seyahatBilgileri)-bus.calculateFuelCost(company.seyahatBilgileri);
        return (int) ciro;
    }
}
