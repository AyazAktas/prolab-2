import java.util.ArrayList;
import java.util.List;

public class Trip {
    Vehicle arac;
    Route sefer;
    List<String>guzergah;
    String tarih;
    Trip(){

    }
    Trip(Vehicle arac, int i, String tarih){
        this.arac = arac;
        this.tarih = tarih;
        if(this.guzergah != null)
        this.guzergah = guzergahBul(i);
    }
    List<String> guzergahBul(String s){
        if (arac.tur != null) {
            if (arac.tur.equals("Demir yolu")) {
                if (s.equals("İstanbul - Kocaeli - Bilecik - Eskişehir - Ankara - Eskişehir\n" +
                        "- Bilecik - Kocaeli - İstanbul")) {
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
                if (s.equals("İstanbul - Kocaeli - Bilecik - Eskişehir - Konya - Eskişehir\n" +
                        "- Bilecik - Kocaeli - İstanbul")) {
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

            else if (arac.tur.equals("Kara yolu")) {
                if (s.equals("İstanbul - Kocaeli - Ankara - Kocaeli - İstanbul - Kocaeli\n" +
                        "- Ankara - Kocaeli - İstanbul")) {
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
                else if (s.equals("İstanbul - Kocaeli - Eskişehir - Konya - Eskişehir - Kocaeli\n" +
                        "-\n" +
                        "İstanbul")) {
                    guzergah.add("İstanbul");
                    guzergah.add("Kocaeli");
                    guzergah.add("Eskişehir");
                    guzergah.add("Konya");
                    guzergah.add("Eskişehir");
                    guzergah.add("Kocaeli");
                    guzergah.add("İstanbul");
                }

                else if (arac.tur.equals("Hava yolu")) {
                    if (s.equals("İstanbul - Konya - İstanbul")) {
                        guzergah.add("İstanbul");
                        guzergah.add("Konya");
                        guzergah.add("İstanbul");
                    }
                    if (s.equals("İstanbul - Ankara - İstanbul")) {
                        guzergah.add("İstanbul");
                        guzergah.add("Ankara");
                        guzergah.add("İstanbul");
                    }
                }
            }
        }
        return guzergah;
    }

    List<String> guzergahBul(int a){
        if (arac.tur != null) {
            if (arac.tur.equals("Demir yolu")) {
                if (a==1) {
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
                if (a==2) {
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

            else if (arac.tur.equals("Kara yolu")) {
                if (a ==3) {
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
                else if (a==4) {
                    guzergah.add("İstanbul");
                    guzergah.add("Kocaeli");
                    guzergah.add("Eskişehir");
                    guzergah.add("Konya");
                    guzergah.add("Eskişehir");
                    guzergah.add("Kocaeli");
                    guzergah.add("İstanbul");
                }

                else if (arac.tur.equals("Hava yolu")) {
                    if (a==5) {
                        guzergah.add("İstanbul");
                        guzergah.add("Konya");
                        guzergah.add("İstanbul");
                    }
                    if (a==6) {
                        guzergah.add("İstanbul");
                        guzergah.add("Ankara");
                        guzergah.add("İstanbul");
                    }
                }
            }
        }
        return guzergah;
    }
}
