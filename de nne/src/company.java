import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class company extends user implements IProfitable{

    String firmaAdi;
    public List<Bus> karaAraclari = new ArrayList<>();
    public List<Airplane> havaAraclari = new ArrayList<>();
    public List<Train> trenAraclari = new ArrayList<>();

    private int birimElektrikFiyati;
    private int birimBenzinFiyati;
    private int birimMotorinFiyati;
    private int birimGazFiyati;
    List<Trip> seyahatBilgileri = new ArrayList<>();
    void page(company kullanici) {
        JFrame frame = new JFrame();
        frame.setTitle("Firma Sayfası");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton btnAracEkle = new JButton("Araç Ekle");
        JButton btnAracCikar = new JButton("Araç Çıkar");
        JButton btnGunlukKarHesapla = new JButton("Günlük Kar Hesapla");
        JButton btnAraclariListele = new JButton("Araçları Listele");
        JButton btnSeferEkle = new JButton("Sefer Ekle");
        JButton btnSeferOlustur= new JButton("Sefer Oluştur");
        JButton btnGeri = new JButton("Geri");
        JButton btnBirimYakitMaliyeti = new JButton("Birim Yakıt Maliyeti Belirle");
        panel.add(btnAracEkle);
        panel.add(btnAracCikar);
        panel.add(btnAraclariListele);
        panel.add(btnGunlukKarHesapla);
        panel.add(btnBirimYakitMaliyeti);
        panel.add(btnSeferEkle);
        panel.add(btnSeferOlustur);
        panel.add(btnGeri);


        // Sağ alt köşeye geri butonu ekleme

        frame.add(panel); // frame'e panel'i ekleyin

        btnGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Geri butonu tıklandığında tekrar giriş ekranına yönlendir
                        new ArayuzTasarim().setVisible(true);
                    }
                });
            }
        });

        btnAracEkle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Türü seçmek için bir giriş penceresi
                String[] turSecenekleri = {"Uçak", "Tren", "Otobüs"};
                String tur = (String) JOptionPane.showInputDialog(
                        null,
                        "Aracın türünü seçin:",
                        "Tür Seçimi",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        turSecenekleri,
                        turSecenekleri[0]
                );

                // Seçilen türe göre işlemler
                if (tur != null) {
                    if (tur.equals("Uçak")) {
                        Airplane airplane = new Airplane();
                        String id = JOptionPane.showInputDialog("Hava Yolu aracının ID'sini girin:");
                        int kapasite = Integer.parseInt(JOptionPane.showInputDialog("Uçak kapasitesini girin:"));
                        airplane.id =id;
                        airplane.kapasite = kapasite;
                        havaAraclari.add(airplane);
                        // Hava Yolu ile ilgili işlemler
                        JOptionPane.showMessageDialog(null, "Hava Yolu aracı başarıyla eklendi. Bilgiler:\n" +
                                "Arac Bilgisi: " +"id: "+id + " Tür: " + tur +" kapasite: " +kapasite);

                    } else if (tur.equals("Tren")) {
                        // Demir Yolu ile ilgili işlemler
                        String[] karaYoluSecenekleri = {"Benzinli", "Motorinli"};
                        Train train = new Train();
                        String id = JOptionPane.showInputDialog("Demir Yolu aracının ID'sini girin:");
                        int kapasite = Integer.parseInt(JOptionPane.showInputDialog("Trenin kapasitesini girin:"));
                        train.id=id;
                        train.kapasite=kapasite;
                        trenAraclari.add(train);
                        JOptionPane.showMessageDialog(null, "Demir Yolu aracı başarıyla eklendi. Bilgiler:\n" +
                                "Arac Bilgisi: " +"id: "+id + " Tür: " + tur +" kapasite: " +kapasite);
                    } else if (tur.equals("Otobüs")) {
                        // Kara Yolu ile ilgili işlemler
                        Bus bus= new Bus();
                        String id = JOptionPane.showInputDialog("Kara Yolu aracının ID'sini girin:");
                        int kapasite = Integer.parseInt(JOptionPane.showInputDialog("Aracın kapasitesini girin:"));
                        bus.id =id;
                        bus.kapasite=kapasite;
                        String[] karaYoluSecenekleri = {"Benzin", "Motorin"};
                        int secilenKaraYolu = JOptionPane.showOptionDialog(
                                null,
                                "Kara Yolu aracı için yakıt türünü seçin:",
                                "Yakıt Türü Seçimi",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                karaYoluSecenekleri,
                                karaYoluSecenekleri[0]
                        );
                        String yakitTuru = karaYoluSecenekleri[secilenKaraYolu];
                        bus.yakitTuru = yakitTuru;

                        karaAraclari.add(bus);
                        JOptionPane.showMessageDialog(null, "Kara Yolu aracı başarıyla eklendi. Bilgiler:\n" +
                                "Arac Bilgisi: " +"id: "+id + " Tür: " + tur +" kapasite: " +kapasite);
                    } else {
                        // Tanımlı olmayan bir tür seçildiyse
                        JOptionPane.showMessageDialog(null, "Geçersiz tür seçildi.");
                    }
                }
            }
        });


        btnAracCikar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Türü seçmek için bir giriş penceresi
                String[] turSecenekleri = {"Uçak", "Tren", "Otobüs"};
                String tur = (String) JOptionPane.showInputDialog(
                        null,
                        "Silinecek aracın türünü seçin:",
                        "Araç Sil",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        turSecenekleri,
                        turSecenekleri[0]
                );
                if (tur != null) {
                    //Uçakları listele
                    if (tur.equals("Uçak")) {
                        String[] idList = new String[havaAraclari.size()];
                        for (int i = 0; i < havaAraclari.size(); i++) {
                            idList[i] = havaAraclari.get(i).id;
                        }
                        String arac = (String) JOptionPane.showInputDialog(
                                null,
                                "Hangi uçağın silineceğini seçin:",
                                "Silinecek Uçak Seçimi",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                idList,
                                idList[0]
                        );
                        //araçın indexini bulmak için
                        if (arac != null) {
                            int selectedIndex = Arrays.asList(idList).indexOf(arac);
                            havaAraclari.remove(havaAraclari.get(selectedIndex));
                        }

                    } else if (tur.equals("Tren")) {

                    } else if (tur.equals("Otobüs")) {

                    }
                    JOptionPane.showMessageDialog(null, "Araç başarıyla çıkarıldı.");
                }
            }
        });

        btnBirimYakitMaliyeti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] turSecenekleri2 = {"Benzin", "Motorin", "Elektrik", "Gaz"};
                String yakitTuru = (String) JOptionPane.showInputDialog(
                        null,
                        "Yakıt Türü Seçin:",
                        "Tür Seçimi",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        turSecenekleri2,
                        turSecenekleri2[0]
                );
                if (yakitTuru != null) {
                    if (yakitTuru.equals("Benzin")) {
                        birimBenzinFiyati = Integer.parseInt(JOptionPane.showInputDialog("Birim Benzin Fiyatını Girin:"));
                        JOptionPane.showMessageDialog(null, "Benzin Fiyatı : " + birimBenzinFiyati + " TL");

                    } else if (yakitTuru.equals("Motorin")) {
                        birimMotorinFiyati = Integer.parseInt(JOptionPane.showInputDialog("Birim Motorin Fiyatı Girin:"));
                        JOptionPane.showMessageDialog(null, "Motorin Fiyatı : " + birimMotorinFiyati + " TL");
                    } else if (yakitTuru.equals("Elektrik")) {
                        birimElektrikFiyati = Integer.parseInt(JOptionPane.showInputDialog("Birim Elektrik Fiyatı Girin:"));
                        JOptionPane.showMessageDialog(null, "Elektrik Fiyatı : " + birimElektrikFiyati + " TL");
                    } else if (yakitTuru.equals("Gaz")) {
                        birimGazFiyati = Integer.parseInt(JOptionPane.showInputDialog("Birim Gaz Fiyatı Girin:"));
                        JOptionPane.showMessageDialog(null, "Gaz Fiyatı : " + birimGazFiyati + " TL");
                    }
                }
            }
        });


        btnGunlukKarHesapla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yolcuUcreti = 10; // Örnek yolcu ücreti
                double hizmetBedeli = 100.0; // Örnek hizmet bedeli
                double personelMaliyeti = 200.0; // Örnek personel maliyeti
                double yakitMaliyeti = 300.0; // Örnek yakıt maliyeti

                JOptionPane.showMessageDialog(null, "Günlük Kar: " +  " TL");
            }
        });

        btnAraclariListele.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] turSecenekleri = {"Uçak", "Tren", "Otobüs"};
                String tur = (String) JOptionPane.showInputDialog(
                        null,
                        "Aracın türünü seçin:",
                        "Tür Seçimi",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        turSecenekleri,
                        turSecenekleri[0]
                );
                if(tur!=null){
                    if(tur.equals("Uçak")){
                        if(havaAraclari.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Araç bulunmamaktadır");
                        }
                        else {
                            StringBuilder yazacakYazi = new StringBuilder();
                            for(int i = 0; i < havaAraclari.size();i++){
                                yazacakYazi.append("id: ").append(havaAraclari.get(i).id);
                            }
                            yazacakYazi.toString();
                            JOptionPane.showMessageDialog(null,yazacakYazi);
                        }
                    }
                    else if(tur.equals("Tren")){
                        if(trenAraclari.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Araç bulunmamaktadır");
                        }
                        else {
                            StringBuilder yazacakYazi = new StringBuilder();
                            for(int i = 0; i < trenAraclari.size();i++){
                                yazacakYazi.append("id: ").append(trenAraclari.get(i).id);
                            }
                            yazacakYazi.toString();
                            JOptionPane.showMessageDialog(null,yazacakYazi);
                        }

                    } else if (tur.equals("Otobüs")) {
                        if(karaAraclari.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Araç bulunmamaktadır");
                        }
                        else {
                            StringBuilder yazacakYazi = new StringBuilder();
                            for(int i = 0; i < karaAraclari.size();i++){
                                yazacakYazi.append("id: ").append(karaAraclari.get(i).id);
                            }
                            yazacakYazi.toString();
                            JOptionPane.showMessageDialog(null,yazacakYazi);
                        }
                    }
                }
            }
        });

        btnSeferEkle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] turSecenekleri = {"Hava yolu", "Demir yolu", "Kara yolu"};
                String tur = (String) JOptionPane.showInputDialog(
                        null,
                        "Seferin hangi yolla olacağını seçin:",
                        "Tür Seçimi",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        turSecenekleri,
                        turSecenekleri[0]
                );
                if(tur != null){
                    Trip trip = new Trip();
                    if(tur.equals("Hava yolu")){
                        String[] idList = new String[10];
                        if(havaAraclari != null) {
                            for (int i = 0; i < havaAraclari.size(); i++) {
                                idList[i] = havaAraclari.get(i).id;
                            }
                            String arac = (String) JOptionPane.showInputDialog(
                                    null,
                                    "Sefere hangi uçak kullanılacağını seçin:",
                                    "Araç Seçimi",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    idList,
                                    idList[0]
                            );
                            if(arac != null){
                                int selectedIndexOfIdList = Arrays.asList(idList).indexOf(arac);
                                trip.arac = havaAraclari.get(selectedIndexOfIdList);
                                String[] seferSecenekleri = new String[]{"İstanbul - Konya - İstanbul", "İstanbul - Ankara - İstanbul"};
                                String sefer = (String) JOptionPane.showInputDialog(
                                        null,
                                        "Hangi güzergahı kullanacaksınız?",
                                        "Güzergah Seçimi",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        seferSecenekleri,
                                        seferSecenekleri[0]
                                );
                                if(sefer !=null){
                                    trip.guzergah = new ArrayList<>();
                                    trip.guzergah = trip.guzergahBul(sefer);
                                    String[] seferTarihleri = new String[]{"4 Aralık 2023", "5 Aralık 2023", "6 Aralık 2023",
                                            "7 Aralık 2023", "8 Aralık 2023", "9 Aralık 2023", "10 Aralık 2023"};
                                    String secilenTarih = (String) JOptionPane.showInputDialog(
                                            null,
                                            "Hangi tarihte sefer başlayacak",
                                            "Tarih Seçimi",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            seferTarihleri,
                                            seferTarihleri[0]
                                    );
                                    if(secilenTarih != null){
                                        trip.tarih = secilenTarih;
                                        seyahatBilgileri.add(trip);
                                        JOptionPane.showMessageDialog(null, "Sefer başarıyla eklendi.");
                                    }}}}

                    }
                    else if (tur.equals("Demir yolu")) {
                        String[] idList = new String[10];
                        for(int i =0; i<trenAraclari.size(); i++){
                            idList[i] = trenAraclari.get(i).id;
                        }
                        String arac = (String) JOptionPane.showInputDialog(
                                null,
                                "Sefere hangi tren kullanılacağını seçin:",
                                "Araç Seçimi",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                idList,
                                idList[0]
                        );if(arac != null) {
                            int selectedIndexOfIdList = Arrays.asList(idList).indexOf(arac);
                            trip.arac = trenAraclari.get(selectedIndexOfIdList);
                            String[] seferSecenekleri = new String[]{"İstanbul - Kocaeli - Bilecik - Eskişehir - Ankara - Eskişehir\n" +
                                    "- Bilecik - Kocaeli - İstanbul", "İstanbul - Kocaeli - Bilecik - Eskişehir - Konya - Eskişehir\n" +
                                    "- Bilecik - Kocaeli - İstanbul"};
                            String sefer = (String) JOptionPane.showInputDialog(
                                    null,
                                    "Hangi güzergahı kullanacaksınız?",
                                    "Güzergah Seçimi",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    seferSecenekleri,
                                    seferSecenekleri[0]
                            );if(sefer != null){
                                trip.guzergah = new ArrayList<>();
                                trip.guzergah = trip.guzergahBul(sefer);
                                String[] seferTarihleri = new String[]{"4 Aralık 2023", "5 Aralık 2023", "6 Aralık 2023",
                                        "7 Aralık 2023", "8 Aralık 2023", "9 Aralık 2023", "10 Aralık 2023"};
                                String secilenTarih = (String) JOptionPane.showInputDialog(
                                        null,
                                        "Hangi tarihte sefer başlayacak",
                                        "Tarih Seçimi",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        seferTarihleri,
                                        seferTarihleri[0]
                                );
                                if(secilenTarih != null){
                                    trip.tarih = secilenTarih;
                                    seyahatBilgileri.add(trip);
                                    JOptionPane.showMessageDialog(null, "Sefer başarıyla eklendi.");
                                }}}
                    } else if (tur.equals("Kara yolu")) {
                        String[] idList = new String[10];
                        for(int i =0; i<karaAraclari.size(); i++){
                            idList[i] = karaAraclari.get(i).id;
                        }
                        String arac = (String) JOptionPane.showInputDialog(
                                null,
                                "Sefere hangi otobüs kullanılacağını seçin:",
                                "Araç Seçimi",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                idList,
                                idList[0]
                        );if(arac!=null){
                            int selectedIndexOfIdList = Arrays.asList(idList).indexOf(arac);
                            trip.arac = karaAraclari.get(selectedIndexOfIdList);
                            String[] seferSecenekleri= new String[]{"İstanbul - Kocaeli - Ankara - Kocaeli - İstanbul - Kocaeli\n" +
                                    "- Ankara - Kocaeli - İstanbul", "İstanbul - Kocaeli - Eskişehir - Konya - Eskişehir - Kocaeli\n" +
                                    "-\n" +
                                    "İstanbul"};
                            String sefer = (String) JOptionPane.showInputDialog(
                                    null,
                                    "Hangi güzergahı kullanacaksınız?",
                                    "Güzergah Seçimi",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    seferSecenekleri,
                                    seferSecenekleri[0]
                            );if(sefer!=null){
                                trip.guzergah = new ArrayList<>();
                                trip.guzergah = trip.guzergahBul(sefer);
                                String[] seferTarihleri= new String[]{"4 Aralık 2023","5 Aralık 2023","6 Aralık 2023",
                                        "7 Aralık 2023","8 Aralık 2023","9 Aralık 2023","10 Aralık 2023"};
                                String secilenTarih = (String) JOptionPane.showInputDialog(
                                        null,
                                        "Hangi tarihte sefer başlayacak",
                                        "Tarih Seçimi",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        seferTarihleri,
                                        seferTarihleri[0]
                                );if(secilenTarih != null){
                                    trip.tarih = secilenTarih;
                                    seyahatBilgileri.add(trip);
                                    JOptionPane.showMessageDialog(null,"Sefer başarıyla eklendi.");
                                }}}}
                }
            }
        });

        btnSeferOlustur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] sehirSecenekleri = {"İstanbul", "Kocaeli", "Ankara", "Eskişehir", "Konya", "Bilecik"};
                String[] aracSecenekleri = {"Karayolu", "Demiryolu", "Havayolu"};
                String[] tarihSecenekleri = {"4 Aralık 2023", "5 Aralık 2023", "6 Aralık 2023", "7 Aralık 2023", "8 Aralık 2023", "9 Aralık 2023", "10 Aralık 2023"};

                MesafeMatrisi mesafeMatrisi = new MesafeMatrisi();
                Route guzergah = new Route(mesafeMatrisi);
                String arac = (String) JOptionPane.showInputDialog(
                        null,
                        "Bir araç seçin:",
                        "Araç Seçimi",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        aracSecenekleri,
                        aracSecenekleri[0]
                );
                while (true) {
                    String sehir = (String) JOptionPane.showInputDialog(
                            null,
                            "Bir şehir seçin (iptal etmek için Cancel):",
                            "Şehir Seçimi",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            sehirSecenekleri,
                            sehirSecenekleri[0]
                    );

                    if (sehir == null) {
                        // Kullanıcı Cancel butonuna tıkladı
                        break;
                    }

                    guzergah.sehirEkle(sehir);
                }



                // Kullanıcıdan tarih seçimini iste
                String tarih = (String) JOptionPane.showInputDialog(
                        null,
                        "Bir tarih seçin:",
                        "Tarih Seçimi",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        tarihSecenekleri,
                        tarihSecenekleri[0]
                );

                // Güzerğahı al ve kullan
                String olusturulanGuzergah = guzergah.getRoute();
                int toplamMesafe = guzergah.toplamMesafe(arac);

                if (!olusturulanGuzergah.isEmpty()) {
                    // olusturulanGuzergah'ı ve diğer bilgileri kullanarak gerekli işlemleri yap
                    JOptionPane.showMessageDialog(null, "Oluşturulan Sefer: " + olusturulanGuzergah +
                            "\nAraç: " + arac +
                            "\nTarih: " + tarih +
                            "\nToplam Mesafe: " + toplamMesafe + " km");
                    // Diğer sefer ekleme işlemleri buraya eklenir
                } else {
                    // Kullanıcı hiç şehir seçmedi veya işlemi iptal etti
                    System.out.println("Sefer eklenmedi. Kullanıcı şehir seçmedi veya işlemi iptal etti.");
                }
            }
        });




        frame.setVisible(true);
    }



    @Override
    int sifreKontrol(String girilenKullaniciAdi, String girilenSifre) {
        List<company> liste= admin.firmaListesi;
        for (int i=0;i<liste.size();i++){
            if(liste.get(i).kullaniciAdi.equals(girilenKullaniciAdi) && liste.get(i).sifre.equals(girilenSifre) ){
                JOptionPane.showMessageDialog(null, "Giriş Başarılı");
                return i;
            }
        }
        return -1;
    }

    String getFirmaAdi(){
        return firmaAdi;
    }
}
