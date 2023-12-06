import java.util.HashMap;
import java.util.Map;

public class FiyatMatrisi {
    private Map<String, Map<String, Integer>> karayoluFiyatlari;
    private Map<String, Map<String, Integer>> demiryoluFiyatlari;
    private Map<String, Map<String, Integer>> havayoluFiyatlari;

    public FiyatMatrisi() {
        karayoluFiyatlari = new HashMap<>();
        demiryoluFiyatlari = new HashMap<>();
        havayoluFiyatlari = new HashMap<>();


        Map<String, Integer> istanbulKarayolu = new HashMap<>();
        istanbulKarayolu.put("Kocaeli", 50);
        istanbulKarayolu.put("Ankara", 300);
        istanbulKarayolu.put("Eskişehir", 150);
        istanbulKarayolu.put("Konya", 300);
        karayoluFiyatlari.put("İstanbul", istanbulKarayolu);


        Map<String, Integer> kocaeliKarayolu = new HashMap<>();
        kocaeliKarayolu.put("İstanbul", 50);
        kocaeliKarayolu.put("Ankara", 400);
        kocaeliKarayolu.put("Eskişehir", 100);
        kocaeliKarayolu.put("Konya", 250);
        karayoluFiyatlari.put("Kocaeli", kocaeliKarayolu);

        Map<String, Integer> ankaraKarayolu = new HashMap<>();
        ankaraKarayolu.put("İstanbul", 300);
        ankaraKarayolu.put("Kocaeli", 400);
        karayoluFiyatlari.put("Ankara", ankaraKarayolu);

        Map<String, Integer> eskisehirKarayolu = new HashMap<>();
        eskisehirKarayolu.put("İstanbul", 150);
        eskisehirKarayolu.put("Kocaeli", 100);
        eskisehirKarayolu.put("Konya", 150);
        karayoluFiyatlari.put("Eskişehir", eskisehirKarayolu);

        Map<String, Integer> konyaKarayolu = new HashMap<>();
        konyaKarayolu.put("İstanbul", 300);
        konyaKarayolu.put("Kocaeli", 250);
        konyaKarayolu.put("Eskişehir", 150);
        karayoluFiyatlari.put("Konya", konyaKarayolu);



        Map<String, Integer> istanbulDemiryolu = new HashMap<>();
        istanbulDemiryolu.put("Kocaeli", 50);
        istanbulDemiryolu.put("Bilecik", 150);
        istanbulDemiryolu.put("Ankara", 250);
        istanbulDemiryolu.put("Eskişehir", 200);
        istanbulDemiryolu.put("Konya", 300);
        demiryoluFiyatlari.put("İstanbul", istanbulDemiryolu);


        Map<String, Integer> kocaeliDemiryolu = new HashMap<>();
        kocaeliDemiryolu.put("İstanbul", 50);
        kocaeliDemiryolu.put("Bilecik", 50);
        kocaeliDemiryolu.put("Ankara", 200);
        kocaeliDemiryolu.put("Eskişehir", 100);
        kocaeliDemiryolu.put("Konya", 250);
        demiryoluFiyatlari.put("Kocaeli", kocaeliDemiryolu);

        Map<String, Integer> bilecikDemiryolu = new HashMap<>();
        bilecikDemiryolu.put("İstanbul", 150);
        bilecikDemiryolu.put("Kocaeli", 50);
        bilecikDemiryolu.put("Ankara", 150);
        bilecikDemiryolu.put("Eskişehir", 50);
        bilecikDemiryolu.put("Konya", 200);
        demiryoluFiyatlari.put("Bilecik", bilecikDemiryolu);

        Map<String, Integer> ankaraDemiryolu = new HashMap<>();
        ankaraDemiryolu.put("İstanbul", 250);
        ankaraDemiryolu.put("Kocaeli", 200);
        ankaraDemiryolu.put("Bilecik", 150);
        ankaraDemiryolu.put("Eskişehir", 100);
        demiryoluFiyatlari.put("Ankara", ankaraDemiryolu);

        Map<String, Integer> eskisehirDemiryolu = new HashMap<>();
        eskisehirDemiryolu.put("İstanbul", 200);
        eskisehirDemiryolu.put("Kocaeli", 100);
        eskisehirDemiryolu.put("Bilecik", 50);
        eskisehirDemiryolu.put("Ankara", 100);
        eskisehirDemiryolu.put("Konya", 150);
        demiryoluFiyatlari.put("Eskişehir", eskisehirDemiryolu);

        Map<String, Integer> konyaDemiryolu = new HashMap<>();
        konyaDemiryolu.put("İstanbul", 300);
        konyaDemiryolu.put("Kocaeli", 250);
        konyaDemiryolu.put("Bilecik", 200);
        eskisehirDemiryolu.put("Eskişehir", 150);
        demiryoluFiyatlari.put("Konya", konyaDemiryolu);



        Map<String, Integer> istanbulHavayolu = new HashMap<>();
        istanbulHavayolu.put("Ankara", 1000);
        istanbulHavayolu.put("Konya", 1200);
        havayoluFiyatlari.put("İstanbul", istanbulHavayolu);

        Map<String, Integer> ankaraHavayolu = new HashMap<>();
        ankaraHavayolu.put("İstanbul", 1000);
        havayoluFiyatlari.put("Ankara", ankaraHavayolu);

        Map<String, Integer> konyaHavayolu = new HashMap<>();
        konyaHavayolu.put("İstanbul", 1200);
        havayoluFiyatlari.put("Konya", konyaHavayolu);

    }

    public int getKarayoluFiyatlari(String sehir1, String sehir2) {
        return karayoluFiyatlari.get(sehir1).get(sehir2);
    }

    public int getDemiryoluFiyatlari(String sehir1, String sehir2) {
        return demiryoluFiyatlari.get(sehir1).get(sehir2);
    }

    public int getHavayoluFiyatlari(String sehir1, String sehir2) {
        return havayoluFiyatlari.get(sehir1).get(sehir2);
    }

}
