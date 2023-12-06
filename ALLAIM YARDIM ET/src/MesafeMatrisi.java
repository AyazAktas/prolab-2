import java.util.HashMap;
import java.util.Map;

public class MesafeMatrisi {
    private Map<String, Map<String, Integer>> karayoluMesafeleri;
    private Map<String, Map<String, Integer>> demiryoluMesafeleri;
    private Map<String, Map<String, Integer>> havayoluMesafeleri;

    public MesafeMatrisi() {
        karayoluMesafeleri = new HashMap<>();
        demiryoluMesafeleri = new HashMap<>();
        havayoluMesafeleri = new HashMap<>();


        Map<String, Integer> istanbulKarayolu = new HashMap<>();
        istanbulKarayolu.put("Kocaeli", 100);
        istanbulKarayolu.put("Ankara", 500);
        istanbulKarayolu.put("Eskişehir", 300);
        istanbulKarayolu.put("Konya", 600);
        karayoluMesafeleri.put("İstanbul", istanbulKarayolu);


        Map<String, Integer> kocaeliKarayolu = new HashMap<>();
        kocaeliKarayolu.put("İstanbul", 100);
        kocaeliKarayolu.put("Ankara", 400);
        kocaeliKarayolu.put("Eskişehir", 200);
        kocaeliKarayolu.put("Konya", 500);
        karayoluMesafeleri.put("Kocaeli", kocaeliKarayolu);

        Map<String, Integer> ankaraKarayolu = new HashMap<>();
        ankaraKarayolu.put("İstanbul", 500);
        ankaraKarayolu.put("Kocaeli", 400);
        karayoluMesafeleri.put("Ankara", ankaraKarayolu);

        Map<String, Integer> eskisehirKarayolu = new HashMap<>();
        eskisehirKarayolu.put("İstanbul", 300);
        eskisehirKarayolu.put("Kocaeli", 200);
        eskisehirKarayolu.put("Konya", 300);
        karayoluMesafeleri.put("Eskişehir", eskisehirKarayolu);

        Map<String, Integer> konyaKarayolu = new HashMap<>();
        konyaKarayolu.put("İstanbul", 600);
        konyaKarayolu.put("Kocaeli", 500);
        konyaKarayolu.put("Eskişehir", 300);
        karayoluMesafeleri.put("Konya", konyaKarayolu);



        Map<String, Integer> istanbulDemiryolu = new HashMap<>();
        istanbulDemiryolu.put("Kocaeli", 75);
        istanbulDemiryolu.put("Bilecik", 225);
        istanbulDemiryolu.put("Ankara", 375);
        istanbulDemiryolu.put("Eskişehir", 300);
        istanbulDemiryolu.put("Konya", 450);
        demiryoluMesafeleri.put("İstanbul", istanbulDemiryolu);


        Map<String, Integer> kocaeliDemiryolu = new HashMap<>();
        kocaeliDemiryolu.put("İstanbul", 75);
        kocaeliDemiryolu.put("Bilecik", 75);
        kocaeliDemiryolu.put("Ankara", 300);
        kocaeliDemiryolu.put("Eskişehir", 150);
        kocaeliDemiryolu.put("Konya", 350);
        demiryoluMesafeleri.put("Kocaeli", kocaeliDemiryolu);

        Map<String, Integer> bilecikDemiryolu = new HashMap<>();
        bilecikDemiryolu.put("İstanbul", 225);
        bilecikDemiryolu.put("Kocaeli", 75);
        bilecikDemiryolu.put("Ankara", 225);
        bilecikDemiryolu.put("Eskişehir", 75);
        bilecikDemiryolu.put("Konya", 300);
        demiryoluMesafeleri.put("Bilecik", bilecikDemiryolu);

        Map<String, Integer> ankaraDemiryolu = new HashMap<>();
        ankaraDemiryolu.put("İstanbul", 375);
        ankaraDemiryolu.put("Kocaeli", 300);
        ankaraDemiryolu.put("Bilecik", 225);
        ankaraDemiryolu.put("Eskişehir", 150);
        demiryoluMesafeleri.put("Ankara", ankaraDemiryolu);

        Map<String, Integer> eskisehirDemiryolu = new HashMap<>();
        eskisehirDemiryolu.put("İstanbul", 300);
        eskisehirDemiryolu.put("Kocaeli", 150);
        eskisehirDemiryolu.put("Bilecik", 75);
        eskisehirDemiryolu.put("Ankara", 150);
        eskisehirDemiryolu.put("Konya", 225);
        demiryoluMesafeleri.put("Eskişehir", eskisehirDemiryolu);

        Map<String, Integer> konyaDemiryolu = new HashMap<>();
        konyaDemiryolu.put("İstanbul", 450);
        konyaDemiryolu.put("Kocaeli", 350);
        konyaDemiryolu.put("Bilecik", 300);
        eskisehirDemiryolu.put("Eskişehir", 225);
        demiryoluMesafeleri.put("Konya", konyaDemiryolu);



        Map<String, Integer> istanbulHavayolu = new HashMap<>();
        istanbulHavayolu.put("Ankara", 250);
        istanbulHavayolu.put("Konya", 300);
        havayoluMesafeleri.put("İstanbul", istanbulHavayolu);

        Map<String, Integer> ankaraHavayolu = new HashMap<>();
        ankaraHavayolu.put("İstanbul", 250);
        havayoluMesafeleri.put("Ankara", ankaraHavayolu);

        Map<String, Integer> konyaHavayolu = new HashMap<>();
        konyaHavayolu.put("İstanbul", 300);
        havayoluMesafeleri.put("Konya", konyaHavayolu);

    }

    public void karayoluMesafesiEkle(String sehir1, String sehir2, int mesafe) {
        karayoluMesafeleri.computeIfAbsent(sehir1, k -> new HashMap<>()).put(sehir2, mesafe);
        karayoluMesafeleri.computeIfAbsent(sehir2, k -> new HashMap<>()).put(sehir1, mesafe);
    }

    public void demiryoluMesafesiEkle(String sehir1, String sehir2, int mesafe) {
        demiryoluMesafeleri.computeIfAbsent(sehir1, k -> new HashMap<>()).put(sehir2, mesafe);
        demiryoluMesafeleri.computeIfAbsent(sehir2, k -> new HashMap<>()).put(sehir1, mesafe);
    }

    public void havayoluMesafesiEkle(String sehir1, String sehir2, int mesafe) {
        havayoluMesafeleri.computeIfAbsent(sehir1, k -> new HashMap<>()).put(sehir2, mesafe);
        havayoluMesafeleri.computeIfAbsent(sehir2, k -> new HashMap<>()).put(sehir1, mesafe);
    }

    public int getKarayoluMesafe(String sehir1, String sehir2) {
        return karayoluMesafeleri.get(sehir1).get(sehir2);
    }

    public int getDemiryoluMesafe(String sehir1, String sehir2) {
        return demiryoluMesafeleri.get(sehir1).get(sehir2);
    }

    public int getHavayoluMesafe(String sehir1, String sehir2) {
        return havayoluMesafeleri.get(sehir1).get(sehir2);
    }

    // Kontrol metodları
    public boolean karayoluMesafesiVarMi(String sehir1, String sehir2) {
        return karayoluMesafeleri.containsKey(sehir1) && karayoluMesafeleri.get(sehir1).containsKey(sehir2);
    }

    public boolean demiryoluMesafesiVarMi(String sehir1, String sehir2) {
        return demiryoluMesafeleri.containsKey(sehir1) && demiryoluMesafeleri.get(sehir1).containsKey(sehir2);
    }

    public boolean havayoluMesafesiVarMi(String sehir1, String sehir2) {
        return havayoluMesafeleri.containsKey(sehir1) && havayoluMesafeleri.get(sehir1).containsKey(sehir2);
    }


}
