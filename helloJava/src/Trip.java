import java.util.List;

public class Trip {
    Vehicle arac;
    Route sefer;
    List<String>guzergah;

    void guzergahBul(){
            if (arac.aracTuru.equals("Demir")) {
                if (sefer.varis.equals("Ankara")) {
                    guzergah.add("İstanbul");
                    guzergah.add("Kocaeli");
                    guzergah.add("Bilecik");
                    guzergah.add("Eskişehir");
                    guzergah.add("Ankara");
                    guzergah.add("Eskişehir");
                    guzergah.add("Bilecik");
                    guzergah.add("Kocaeli");
                    guzergah.add("İstanbul");
                }
                if(sefer.varis.equals("Konya")){
                    guzergah.add("İstanbul");
                    guzergah.add("Kocaeli");
                    guzergah.add("Bilecik");
                    guzergah.add("Eskişehir");
                    guzergah.add("Konya");
                    guzergah.add("Eskişehir");
                    guzergah.add("Bilecik");
                    guzergah.add("Kocaeli");
                    guzergah.add("İstanbul");
                }
            }

            if(arac.aracTuru.equals("Kara")) {
                if (sefer.varis.equals("Ankara")) {
                    guzergah.add("İstanbul");
                    guzergah.add("Kocaeli");
                    guzergah.add("Ankara");
                    guzergah.add("Kocaeli");
                    guzergah.add("İstanbul");
                    guzergah.add("Kocaeli");
                    guzergah.add("Ankara");
                    guzergah.add("Kocaeli");
                    guzergah.add("İstanbul");
                }
                if (sefer.varis.equals("Ankara")){
                    guzergah.add("İstanbul");
                    guzergah.add("Kocaeli");
                    guzergah.add("Eskişehir");
                    guzergah.add("Konya");
                    guzergah.add("Eskişehir");
                    guzergah.add("Kocaeli");
                    guzergah.add("İstanbul");
                }

                if (arac.aracTuru.equals("Hava")){
                    if (sefer.varis.equals("Konya")){
                        guzergah.add("İstanbul");
                        guzergah.add("Konya");
                        guzergah.add("İstanbul");
                    }
                    if (sefer.varis.equals("Konya")){
                        guzergah.add("İstanbul");
                        guzergah.add("Ankara");
                        guzergah.add("İstanbul");
                    }
                }
            }


    }
}
