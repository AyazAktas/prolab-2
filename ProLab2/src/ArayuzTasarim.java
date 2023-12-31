import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;
import java.util.Random;


public class ArayuzTasarim extends JFrame {
    private static company currentLoggedInCompany;
    public static company getCurrentLoggedInCompany() {
        return currentLoggedInCompany;
    }
    public static void setCurrentLoggedInCompany(company company) {
        currentLoggedInCompany = company;
    }
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
                        company currentCompany = new company();
                        currentCompany.login();
                        setCurrentLoggedInCompany(currentCompany);
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
        Trip trip1 = new Trip(bus1,3,"5 Aralık 2023");
        Trip trip2 = new Trip(bus2,3,"7 Aralık 2023");
        ilkFirma.seyahatBilgileri.add(trip1);
        ilkFirma.seyahatBilgileri.add(trip2);
        ilkFirma.seferBasiHizmetPersonelUcreti=2000;
        ilkFirma.seferBasiAracPersonelUcreti=5000;
        ilkFirma.karaAraclari.add(bus1);
        ilkFirma.karaAraclari.add(bus2);

        admin.firmaListesi.add(ilkFirma);


        company bFirma = new company();
        bFirma.kullaniciAdi ="B";
        bFirma.sifre ="B";
        Bus bus3 = new Bus("Otobüs 3","Kara yolu",30,"Motorin");
        Bus bus4 = new Bus("Otobüs 4","Kara yolu",40,"Motorin");
        Trip trip3 = new Trip(bus3,3,"5 Aralık 2023");
        Trip trip4 = new Trip(bus4,4,"7 Aralık 2023");
        bFirma.seyahatBilgileri.add(trip3);
        bFirma.seyahatBilgileri.add(trip4);
        bFirma.karaAraclari.add(bus1);
        bFirma.karaAraclari.add(bus2);
        bFirma.seferBasiAracPersonelUcreti=3000;
        bFirma.seferBasiHizmetPersonelUcreti=1500;
        admin.firmaListesi.add(bFirma);

        company cFirma = new company();
        cFirma.kullaniciAdi ="C";
        cFirma.sifre ="C";
        Bus bus5 = new Bus("Otobüs 5","Kara yolu",40,"Motorin");
        Airplane airplane1 = new Airplane("Uçak 1","Hava yolu",60);
        Airplane airplane2 = new Airplane("Uçak 2","Hava yolu",60);
        cFirma.havaAraclari.add(airplane1);
        cFirma.havaAraclari.add(airplane2);
        Trip trip5 = new Trip(airplane1,5,"5 Aralık 2023");
        Trip trip6 = new Trip(airplane2,5,"7 Aralık 2023");
        Trip trip7 = new Trip(bus5,4,"6 Aralık 2023");
        cFirma.seyahatBilgileri.add(trip7);
        cFirma.seyahatBilgileri.add(trip5);
        cFirma.seyahatBilgileri.add(trip6);
        int seferBasiUcakAracC=10000;
        int seferBasiUcakHizmetC=6000;
        cFirma.seferBasiHizmetPersonelUcreti=2000;
        cFirma.seferBasiAracPersonelUcreti=4000;
        admin.firmaListesi.add(cFirma);

        company dFirma = new company();
        dFirma.kullaniciAdi ="D";
        dFirma.sifre ="D";
        Train train2 = new Train("Tren 2","Demir yolu",50,"Elektrik");
        Train train1 = new Train("Tren 1","Demir yolu",50,"Elektrik");
        Train train3 = new Train("Tren 3","Demir yolu",50,"Elektrik");
        Trip trip8 = new Trip(train1,1,"5 Aralık 2023");
        Trip trip9 = new Trip(train2,2,"7 Aralık 2023");
        Trip trip10 = new Trip(train3,2,"6 Aralık 2023");
        dFirma.seyahatBilgileri.add(trip8);
        dFirma.seyahatBilgileri.add(trip9);
        dFirma.seyahatBilgileri.add(trip10);
        dFirma.seferBasiAracPersonelUcreti=2000;
        dFirma.seferBasiHizmetPersonelUcreti=1000;
        admin.firmaListesi.add(dFirma);

        company fFirma = new company();
        fFirma.kullaniciAdi ="F";
        fFirma.sifre ="F";
        Airplane airplane3 = new Airplane("Tren 2","Demir yolu",50);
        Airplane airplane4 = new Airplane("Tren 1","Demir yolu",50);
        Trip trip11 = new Trip(airplane3,6,"5 Aralık 2023");
        Trip trip12 = new Trip(airplane4,6,"7 Aralık 2023");
        fFirma.seyahatBilgileri.add(trip11);
        fFirma.seyahatBilgileri.add(trip12); // YOLCU SAYISI KALDIR YERİNE BOŞ KOLTUK SAYISI KADAR NE KADAR BİLET ALABİLECEĞİNİ YA
        fFirma.seferBasiHizmetPersonelUcreti=7500;
        fFirma.seferBasiAracPersonelUcreti=4000;
        admin.firmaListesi.add(fFirma);

        for (company firma : admin.firmaListesi) {
            for (Trip trip : firma.seyahatBilgileri) {
                randomDoluKoltukAta(trip.arac);
            }
        }


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArayuzTasarim().setVisible(true);
            }
        });
    }
    private static void randomDoluKoltukAta(Vehicle arac) {
        if (arac instanceof Bus) {
            Bus otobus = (Bus) arac;
            Random random = new Random();
            int doluKoltukSayisi = random.nextInt(otobus.getKapasite() + 1); // 0 ile aracın kapasitesi arasında random sayı
            otobus.setDoluKoltukSayisi(doluKoltukSayisi);
        } else if (arac instanceof Airplane) {
            Airplane ucak = (Airplane) arac;
            Random random = new Random();
            int doluKoltukSayisi = random.nextInt(ucak.getKapasite() + 1); // 0 ile aracın kapasitesi arasında random sayı
            ucak.setDoluKoltukSayisi(doluKoltukSayisi);
        } else if (arac instanceof Train) {
            Train tren = (Train) arac;
            Random random = new Random();
            int doluKoltukSayisi = random.nextInt(tren.getKapasite() + 1); // 0 ile aracın kapasitesi arasında random sayı
            tren.setDoluKoltukSayisi(doluKoltukSayisi);
        }
    }
}