import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;


public class ArayuzTasarim extends JFrame {

    public ArayuzTasarim() {
        setTitle("Giriş Ekranı");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton btnMusteri = new JButton("Müşteri Girişi");
        JButton btnAdmin = new JButton("Admin Girişi");
        JButton btnFirma = new JButton("Firma Girişi");

        panel.add(btnMusteri);
        panel.add(btnAdmin);
        panel.add(btnFirma);

        add(panel);

        btnMusteri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        customer.createAndShowGUI();
                    }
                });
            }
        });

        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        user admin=new admin();
                        admin.login();
                        admin.kullaniciAdi = "admin";
                        admin.sifre="admin123";
                    }
                });
            }
        });

        btnFirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        user company = new company();
                        company.login();
                    }
                });
            }
        });
    }

    public static void main(String[] args) {
        company ilkFirma = new company();
        ilkFirma.kullaniciAdi ="A";
        ilkFirma.sifre ="A";
        Bus bus1 = new Bus("Otobüs 1","Kara yolu",40,"Benzin");
        Bus bus2 = new Bus("Otobüs2","Kara yolu",30,"Benzin");
        Trip trip1 = new Trip(bus1,3,"5 Aralık");
        Trip trip2 = new Trip(bus2,3,"7 Aralık");
        ilkFirma.seyahatBilgileri.add(trip1);
        ilkFirma.seyahatBilgileri.add(trip2);
        ilkFirma.karaAraclari.add(bus1);
        ilkFirma.karaAraclari.add(bus2);
        admin.firmaListesi.add(ilkFirma);

        company bFirma = new company();
        bFirma.kullaniciAdi ="B";
        bFirma.sifre ="B";
        Bus bus3 = new Bus("Otobüs 3","Kara yolu",30,"Motorin");
        Bus bus4 = new Bus("Otobüs 4","Kara yolu",40,"Motorin");
        Trip trip3 = new Trip(bus3,3,"5 Aralık");
        Trip trip4 = new Trip(bus4,4,"7 Aralık");
        bFirma.seyahatBilgileri.add(trip3);
        bFirma.seyahatBilgileri.add(trip4);
        bFirma.karaAraclari.add(bus1);
        bFirma.karaAraclari.add(bus2);
        admin.firmaListesi.add(bFirma);

        company cFirma = new company();
        cFirma.kullaniciAdi ="C";
        cFirma.sifre ="C";
        Bus bus5 = new Bus("Otobüs 5","Kara yolu",40,"Motorin");
        Airplane airplane1 = new Airplane("Uçak 1","Hava yolu",60);
        Airplane airplane2 = new Airplane("Uçak 2","Hava yolu",60);
        cFirma.havaAraclari.add(airplane1);
        cFirma.havaAraclari.add(airplane2);
        Trip trip5 = new Trip(airplane1,5,"5 Aralık");
        Trip trip6 = new Trip(airplane2,5,"7 Aralık");
        Trip trip7 = new Trip(bus5,4,"6 Aralık");
        cFirma.seyahatBilgileri.add(trip7);
        cFirma.seyahatBilgileri.add(trip5);
        cFirma.seyahatBilgileri.add(trip6);
        admin.firmaListesi.add(cFirma);

        company dFirma = new company();
        dFirma.kullaniciAdi ="D";
        dFirma.sifre ="D";
        Train train2 = new Train("Tren 2","Demir yolu",50,"Elektrik");
        Train train1 = new Train("Tren 1","Demir yolu",50,"Elektrik");
        Train train3 = new Train("Tren 3","Demir yolu",50,"Elektrik");
        Trip trip8 = new Trip(train1,1,"5 Aralık");
        Trip trip9 = new Trip(train2,2,"7 Aralık");
        Trip trip10 = new Trip(train3,2,"6 Aralık");
        dFirma.seyahatBilgileri.add(trip8);
        dFirma.seyahatBilgileri.add(trip9);
        dFirma.seyahatBilgileri.add(trip10);
        admin.firmaListesi.add(dFirma);

        company fFirma = new company();
        fFirma.kullaniciAdi ="F";
        fFirma.sifre ="F";
        Airplane airplane3 = new Airplane("Tren 2","Demir yolu",50);
        Airplane airplane4 = new Airplane("Tren 1","Demir yolu",50);
        Trip trip11 = new Trip(airplane3,6,"5 Aralık");
        Trip trip12 = new Trip(airplane4,6,"7 Aralık");
        fFirma.seyahatBilgileri.add(trip11);
        fFirma.seyahatBilgileri.add(trip12);
        admin.firmaListesi.add(fFirma);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArayuzTasarim().setVisible(true);
            }
        });
    }
}

class SeyahatRezervasyonSistemi extends JFrame {

    public static final String[] GUNLER = {"4 Aralık 2023", "5 Aralık 2023", "6 Aralık 2023", "7 Aralık 2023", "8 Aralık 2023", "9 Aralık 2023", "10 Aralık 2023"};

    private java.util.List<Sefer> seferListesi;

    public SeyahatRezervasyonSistemi() {
        seferListesi = new ArrayList<>();
        seferListesi.add(new Sefer("İstanbul", "Ankara", "4 Aralık 2023", 50, 10));
        seferListesi.add(new Sefer("Ankara", "İzmir", "5 Aralık 2023", 40, 15));
        seferListesi.add(new Sefer("İstanbul", "İzmir", "6 Aralık 2023", 60, 5));

        setTitle("Seyahat Rezervasyon Sistemi");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton btnRezervasyon = new JButton("Rezervasyon Yap");

        panel.add(btnRezervasyon);

        add(panel);

        btnRezervasyon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new customer().initialize();
                    }
                });
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SeyahatRezervasyonSistemi().setVisible(true);
            }
        });
    }

    public List<Sefer> getSeferListesi() {
        return seferListesi;
    }
}

class Sefer {
    private String kalkis;
    private String varis;
    private String tarih;
    private int koltukSayisi;
    private int bosKoltukSayisi;

    public Sefer(String kalkis, String varis, String tarih, int koltukSayisi, int bosKoltukSayisi) {
        this.kalkis = kalkis;
        this.varis = varis;
        this.tarih = tarih;
        this.koltukSayisi = koltukSayisi;
        this.bosKoltukSayisi = bosKoltukSayisi;
    }


class RezervasyonTamamlamaSayfasi extends JFrame {

    private Sefer uygunSefer;
    private int yolcuSayisi;
    private double fiyat;

    public RezervasyonTamamlamaSayfasi(Sefer uygunSefer, int yolcuSayisi, double fiyat) {
        this.uygunSefer = uygunSefer;
        this.yolcuSayisi = yolcuSayisi;
        this.fiyat = fiyat;

        setTitle("Rezervasyon Tamamlama Sayfası");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel labelSefer = new JLabel("Sefer Bilgileri: " + uygunSefer.toString());
        JLabel labelYolcu = new JLabel("Yolcu Sayısı: " + yolcuSayisi);
        JLabel labelFiyat = new JLabel("Toplam Fiyat: " + fiyat + " TL");

        panel.add(labelSefer);
        panel.add(labelYolcu);
        panel.add(labelFiyat);

        JButton btnTamamla = new JButton("Rezervasyonu Tamamla");
        btnTamamla.addActionListener(e -> {
            // Rezervasyonu tamamlama işlemleri
            dispose(); // Pencereyi kapat
        });

        panel.add(btnTamamla);

        add(panel);
    }
}}