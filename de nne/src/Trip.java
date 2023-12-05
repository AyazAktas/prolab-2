import java.util.ArrayList;
import java.util.List;

public class Trip {
    Vehicle arac;
    Route sefer;
    List<String>guzergah;
    String tarih;

    int koltukSayisi;
    int bosKoltuk;
    int yolUzunlugu;
    Trip(){

    }
    Trip(Vehicle arac, int i, String tarih){
        this.arac = arac;
        this.tarih = tarih;
        if(guzergah != null){
        this.guzergah = guzergahBul(i);}

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
                    yolUzunlugu = 750;
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
                    yolUzunlugu = 900;
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
                    yolUzunlugu = 2000;
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
                    yolUzunlugu = 1200;
                }

                else if (arac.tur.equals("Hava yolu")) {
                    if (s.equals("İstanbul - Konya - İstanbul")) {
                        guzergah.add("İstanbul");
                        guzergah.add("Konya");
                        guzergah.add("İstanbul");
                        yolUzunlugu= 600;
                    }
                    if (s.equals("İstanbul - Ankara - İstanbul")) {
                        guzergah.add("İstanbul");
                        guzergah.add("Ankara");
                        guzergah.add("İstanbul");
                        yolUzunlugu = 500;
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
                    yolUzunlugu = 750;
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
                    yolUzunlugu = 900;
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
                    yolUzunlugu = 2000;
                }
                else if (a==4) {
                    guzergah.add("İstanbul");
                    guzergah.add("Kocaeli");
                    guzergah.add("Eskişehir");
                    guzergah.add("Konya");
                    guzergah.add("Eskişehir");
                    guzergah.add("Kocaeli");
                    guzergah.add("İstanbul");
                    yolUzunlugu = 1200;
                }

                else if (arac.tur.equals("Hava yolu")) {
                    if (a==5) {
                        guzergah.add("İstanbul");
                        guzergah.add("Konya");
                        guzergah.add("İstanbul");
                        yolUzunlugu = 600;
                    }
                    if (a==6) {
                        guzergah.add("İstanbul");
                        guzergah.add("Ankara");
                        guzergah.add("İstanbul");
                        yolUzunlugu = 500;
                    }
                }
            }
        }
        return guzergah;
    }
}
