public class GunlukKarZarar extends company {
    private company company;
    private Vehicle arac;

    public GunlukKarZarar() {
        this.company = new company();
        // Assuming you want to use a Train for the example


    }

    public int gunlukKar() {
        company company=new company();
        int count=0;
        String[] idList = new String[havaAraclari.size()];
        for (int i = 0; i < havaAraclari.size(); i++) {
            idList[i] = havaAraclari.get(i).id;
            count++;
        }
        Airplane airplane= new Airplane();
        //int AirplaneFuelCost= airplane.calculateFuelCost() * count;

        double hizmetBedeli = company.hizmetBedeli;
        double hizmetPersonelUcreti = company.seferBasiHizmetPersonelUcreti;
        double aracPersonelUcreti = company.seferBasiAracPersonelUcreti;
        //double fuelCost = arac.calculateFuelCost(/* Pass the appropriate Route object */);

        //double gunlukKar = hizmetBedeli - (hizmetPersonelUcreti + aracPersonelUcreti + fuelCost);

        // Convert the result to int if needed
        return (int) hizmetBedeli;
    }
}
