import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<String> sehirListesi;
    private MesafeMatrisi mesafeMatrisi;
    private List<String> sehirler;
    public Route(MesafeMatrisi mesafeMatrisi) {
        this.mesafeMatrisi = mesafeMatrisi;
        this.sehirListesi = new ArrayList<>();
        this.sehirler = new ArrayList<>();
    }

    public Route() {
        this.sehirListesi = new ArrayList<>();
        this.sehirler = new ArrayList<>();
    }


    public void sehirEkle(String sehir) {
        sehirListesi.add(sehir);
    }

    public String getRoute() {
        StringBuilder guzergah = new StringBuilder();
        for (String sehir : sehirListesi) {
            guzergah.append(sehir).append(" -> ");
        }
        // Son "->" işaretini kaldır
        if (guzergah.length() > 0) {
            guzergah.setLength(guzergah.length() - 4);
        }
        return guzergah.toString();
    }

    public int toplamMesafe(String ulasimYolu) {
        int toplamMesafe = 0;
        for (int i = 0; i < sehirListesi.size() - 1; i++) {
            String sehir1 = sehirListesi.get(i);
            String sehir2 = sehirListesi.get(i + 1);

            // Hangi ulaşım yolunu seçtiğine göre ilgili mesafe matrisini kullan
            if (!ulasimYoluMevcutMu(ulasimYolu, sehir1, sehir2)) {
                JOptionPane.showMessageDialog(null, "Seçilen şehirler arasında yol bulunmamaktadır !");
                return -1;
            }

            int mesafe = 0;
            switch (ulasimYolu) {
                case "Karayolu":
                    mesafe = mesafeMatrisi.getKarayoluMesafe(sehir1, sehir2);
                    break;
                case "Demiryolu":
                    mesafe = mesafeMatrisi.getDemiryoluMesafe(sehir1, sehir2);
                    break;
                case "Havayolu":
                    mesafe = mesafeMatrisi.getHavayoluMesafe(sehir1, sehir2);
                    break;
                default:
                    System.out.println("Geçersiz ulaşım yolu: " + ulasimYolu);
                    return -1; // veya başka bir değer veya isteğe bağlı olarak bir hata işareti
            }

            toplamMesafe += mesafe;
        }
        return toplamMesafe;
    }

    public boolean ulasimYoluMevcutMu(String ulasimYolu, String sehir1, String sehir2) {
        switch (ulasimYolu) {
            case "Karayolu":
                return mesafeMatrisi.karayoluMesafesiVarMi(sehir1, sehir2);
            case "Demiryolu":
                return mesafeMatrisi.demiryoluMesafesiVarMi(sehir1, sehir2);
            case "Havayolu":
                return mesafeMatrisi.havayoluMesafesiVarMi(sehir1, sehir2);
            default:
                return false;
        }
    }


}
