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
                        new MusteriPage().setVisible(true);
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
                        new AdminLoginPage().setVisible(true);
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
                        new FirmaLoginPage().setVisible(true);
                    }
                });
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArayuzTasarim().setVisible(true);
            }
        });
    }
}

class MusteriPage extends JFrame {

    public MusteriPage() {
        setTitle("Müşteri Sayfası");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton btnRezervasyon = new JButton("Rezervasyon Yap");

        panel.add(btnRezervasyon);

        JButton btnGeri = new JButton("Geri");

        // Sağ alt köşeye geri butonu ekleme
        panel.add(btnGeri);

        add(panel);

        btnRezervasyon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new RezervasyonSayfasi().setVisible(true);
                    }
                });
            }
        });

        // Geri butonu için ActionListener ekleme
        btnGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Geri butonu tıklandığında tekrar giriş ekranına yönlendir
                        new ArayuzTasarim().setVisible(true);
                    }
                });
            }
        });
    }
}

class AdminLoginPage extends JFrame {

    public AdminLoginPage() {
        setTitle("Admin Giriş Sayfası");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        JButton btnGiris = new JButton("Giriş");

        panel.add(new JLabel("Kullanıcı Adı:"));
        panel.add(usernameField);
        panel.add(new JLabel("Şifre:"));
        panel.add(passwordField);
        panel.add(btnGiris);
        JButton btnGeri = new JButton("Geri");

        // Sağ alt köşeye geri butonu ekleme
        panel.add(btnGeri);
        add(panel);

        btnGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Geri butonu tıklandığında tekrar giriş ekranına yönlendir
                        new ArayuzTasarim().setVisible(true);
                    }
                });
            }
        });

        btnGiris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String adminUsername = "admin";
                String adminPassword = "admin123";

                String enteredUsername = usernameField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                if (enteredUsername.equals(adminUsername) && enteredPassword.equals(adminPassword)) {
                    JOptionPane.showMessageDialog(null, "Admin Girişi Başarılı");

                    dispose();
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new AdminPage().setVisible(true);
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Hatalı Kullanıcı Adı veya Şifre");
                }
            }
        });
    }
}

class FirmaLoginPage extends JFrame {

    public FirmaLoginPage() {
        setTitle("Firma Giriş Sayfası");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        JButton btnGiris = new JButton("Giriş");

        panel.add(new JLabel("Kullanıcı Adı:"));
        panel.add(usernameField);
        panel.add(new JLabel("Şifre:"));
        panel.add(passwordField);
        panel.add(btnGiris);
        JButton btnGeri = new JButton("Geri");

        // Sağ alt köşeye geri butonu ekleme
        panel.add(btnGeri);
        add(panel);

        btnGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Geri butonu tıklandığında tekrar giriş ekranına yönlendir
                        new ArayuzTasarim().setVisible(true);
                    }
                });
            }
        });


        btnGiris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Store multiple sets of usernames and passwords in a list


                String enteredUsername = usernameField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                boolean isAuthenticated = false;
                List<Firma> firmaListesi=AdminPage.firmaListesi;
                // Check if entered credentials match any entry in the list
                for (Firma firma : firmaListesi) {
                    if (enteredUsername.equals(firma.username) && enteredPassword.equals(firma.password)) {
                        isAuthenticated = true;
                        break;
                    }
                }

                if (isAuthenticated) {
                    JOptionPane.showMessageDialog(null, "Firma Girişi Başarılı");

                    dispose();
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            // Create a Firma object and pass it to the FirmaPage constructor
                            Firma firma = new Firma(enteredUsername, enteredPassword);
                            new FirmaPage(firma).setVisible(true);
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Hatalı Kullanıcı Adı veya Şifre");
                }
            }
        });
    }
}

class Firma {
    public String username;
    public String password;
    private List<Arac> aracBilgileri;

    public Firma(String username, String password) {
        this.username=username;
        this.password=password;
        this.aracBilgileri = new ArrayList<>();
    }

    public boolean girisYap(String kullaniciAdi, String sifre) {
        return this.username.equals(kullaniciAdi) && this.password.equals(sifre);
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void aracEkle(String aracBilgisi, String tur) {
        Arac yeniArac = new Arac(aracBilgisi, tur);
        aracBilgileri.add(yeniArac);
    }

    public void aracCikar(String aracBilgisi) {
        aracBilgileri.removeIf(arac -> arac.getBilgi().equals(aracBilgisi));
    }

    public double gunlukKarHesapla(int yolcuUcreti, double hizmetBedeli, double personelMaliyeti, double yakitMaliyeti) {
        // Basit bir örnek hesaplama
        int toplamYolcuSayisi = aracBilgileri.size() * 50; // Her aracın 50 yolcu kapasitesi olduğunu varsayalım
        return (yolcuUcreti * toplamYolcuSayisi) - (hizmetBedeli + personelMaliyeti + yakitMaliyeti);
    }

    public String getFirmaAdi() {
        return username;
    }

    public List<String> araclariListele(String tur) {
        List<String> turdekiAraclar = new ArrayList<>();
        for (Arac arac : aracBilgileri) {
            if (arac.getTur().equals(tur)) {
                turdekiAraclar.add(arac.getBilgi());
            }
        }
        return turdekiAraclar;
    }

    @Override
    public String toString() {
        return "Firma Adı: " + username;
    }
}

class Arac {
    private String bilgi;
    private String tur;

    public Arac(String bilgi, String tur) {
        this.bilgi = bilgi;
        this.tur = tur;
    }

    public String getBilgi() {
        return bilgi;
    }

    public String getTur() {
        return tur;
    }
}


class FirmaPaneli extends JFrame {
    private Firma firma;

    public FirmaPaneli(Firma firma) {
        setTitle("Firma Sayfası");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.firma = firma;

        JPanel panel = new JPanel();
        JButton btnAracEkle = new JButton("Araç Ekle");
        JButton btnAracCikar = new JButton("Araç Çıkar");
        JButton btnGunlukKarHesapla = new JButton("Günlük Kar Hesapla");
        JButton btnAraclariListele = new JButton("Araçları Listele");
        panel.add(btnAracEkle);
        panel.add(btnAracCikar);
        panel.add(btnGunlukKarHesapla);
        panel.add(btnAraclariListele);

        JButton btnGeri = new JButton("Geri");

        // Sağ alt köşeye geri butonu ekleme
        panel.add(btnGeri);
        add(panel);

        btnGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
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
                String aracBilgisi = JOptionPane.showInputDialog("Eklemek istediğiniz aracın bilgisini girin:");
                String tur = JOptionPane.showInputDialog("Aracın türünü girin (Hava Yolu, Demir Yolu, Kara Yolu):");
                firma.aracEkle(aracBilgisi, tur);
                JOptionPane.showMessageDialog(null, "Araç başarıyla eklendi.");
            }
        });

        btnAracCikar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aracBilgisi = JOptionPane.showInputDialog("Çıkarmak istediğiniz aracın bilgisini girin:");
                firma.aracCikar(aracBilgisi);
                JOptionPane.showMessageDialog(null, "Araç başarıyla çıkarıldı.");
            }
        });

        btnGunlukKarHesapla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yolcuUcreti = 10; // Örnek yolcu ücreti
                double hizmetBedeli = 100.0; // Örnek hizmet bedeli
                double personelMaliyeti = 200.0; // Örnek personel maliyeti
                double yakitMaliyeti = 300.0; // Örnek yakıt maliyeti

                double gunlukKar = firma.gunlukKarHesapla(yolcuUcreti, hizmetBedeli, personelMaliyeti, yakitMaliyeti);
                JOptionPane.showMessageDialog(null, "Günlük Kar: " + gunlukKar + " TL");
            }
        });

        btnAraclariListele.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tur = JOptionPane.showInputDialog("Araçları hangi türde listelemek istersiniz? (Hava Yolu, Demir Yolu, Kara Yolu):");
                List<String> turdekiAraclar = firma.araclariListele(tur);
                String araclar = String.join(", ", turdekiAraclar);
                JOptionPane.showMessageDialog(null, "Araçlar: " + araclar);
            }
        });
    }
}


class AdminPage extends JFrame {

    // Add more entries as needed
    private double hizmetBedeli;
    public static List<Firma> firmaListesi = new ArrayList<>(); // firmaListesi'ni burada başlat

    public AdminPage() {
        setTitle("Admin Sayfası");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firmaListesi.add(new Firma("user1", "password1"));
        firmaListesi.add(new Firma("user2", "password2"));
        // Add more entries as needed
        hizmetBedeli = 1000.0; // Sabit hizmet bedeli

        JPanel panel = new JPanel();
        JButton btnGoruntule = new JButton("Firmaları Görüntüle");
        JButton btnYeniFirma = new JButton("Yeni Firma Kaydı");
        JButton btnFirmaSil = new JButton("Firma Sil");
        JButton btnHizmetBedeliBelirle = new JButton("Hizmet Bedeli Belirle");

        panel.add(btnGoruntule);
        panel.add(btnYeniFirma);
        panel.add(btnFirmaSil);
        panel.add(btnHizmetBedeliBelirle);

        JButton btnGeri = new JButton("Geri");

        // Sağ alt köşeye geri butonu ekleme
        panel.add(btnGeri);

        btnGoruntule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firmaListesi.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Kayıtlı firma bulunmamaktadır.");
                } else {
                    String firmalar = "";
                    for (Firma firma : firmaListesi) {
                        firmalar += firma.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "Firmalar:\n" + firmalar);
                }
            }
        });

        btnYeniFirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String yeniFirmaAdi = JOptionPane.showInputDialog("Yeni firma adını girin:");
                String yeniFirmaSifre = JOptionPane.showInputDialog("Firma şifresini giriniz:");

                // Yeni firma oluşturuluyor
                Firma yeniFirma = new Firma(yeniFirmaAdi, yeniFirmaSifre);

                // Yeni firma kaydedilirken firma bilgileri kontrol ediliyor
                if (firmaListesi.stream().anyMatch(f -> f.girisYap(yeniFirmaAdi, yeniFirmaSifre)) ||
                        firmaListesi.stream().anyMatch(f -> f.getFirmaAdi().equals(yeniFirmaAdi))) {
                    JOptionPane.showMessageDialog(null, "Bu kullanıcı adı zaten mevcut veya hatalı şifre.");
                } else {
                    firmaListesi.add(yeniFirma);
                    JOptionPane.showMessageDialog(null, "Yeni firma başarıyla kaydedildi.");
                }
            }
        });

        btnFirmaSil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firmaListesi.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Silinecek firma bulunmamaktadır.");
                } else {
                    String[] firmaAdlari = new String[firmaListesi.size()];
                    for (int i = 0; i < firmaListesi.size(); i++) {
                        firmaAdlari[i] = firmaListesi.get(i).getFirmaAdi();
                    }
                    String secilenFirma = (String) JOptionPane.showInputDialog(null, "Silinecek firmayı seçin:",
                            "Firma Sil", JOptionPane.QUESTION_MESSAGE, null, firmaAdlari, firmaAdlari[0]);

                    if (secilenFirma != null) {
                        firmaListesi.removeIf(firma -> firma.getFirmaAdi().equals(secilenFirma));
                        JOptionPane.showMessageDialog(null, secilenFirma + " firma başarıyla silindi.");
                    }
                }
            }
        });

        btnHizmetBedeliBelirle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hizmetBedeliStr = JOptionPane.showInputDialog("Yeni hizmet bedelini girin:");
                try {
                    hizmetBedeli = Double.parseDouble(hizmetBedeliStr);
                    JOptionPane.showMessageDialog(null, "Hizmet bedeli başarıyla güncellendi.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Geçersiz bir sayı girdiniz.");
                }
            }
        });

        btnGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Geri butonuna basıldığında AdminPage penceresini kapat ve AnaSayfa penceresini aç
                dispose();
                ArayuzTasarim anaSayfa = new ArayuzTasarim();
                anaSayfa.setVisible(true);
            }
        });

        // Pencere düzenini ayarla
        panel.setLayout(new GridLayout(3, 2)); // 3 satır, 2 sütunlu bir düzen kullan

        // Paneli pencereye ekle
        add(panel);

        // Pencereyi görünür yap
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminPage();
            }
        });
    }
}
class FirmaPage extends JFrame {

    private Firma firma;

    public FirmaPage(Firma firma) {
        this.firma = firma;

        setTitle("Firma Sayfası");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JLabel labelFirmaAdi = new JLabel("Firma Adı: " + firma.getFirmaAdi());
        JButton btnFirmaIslemleri = new JButton("Firma İşlemleri");

        panel.add(labelFirmaAdi);
        panel.add(btnFirmaIslemleri);

        JButton btnGeri = new JButton("Geri");

        // Sağ alt köşeye geri butonu ekleme
        panel.add(btnGeri);

        btnFirmaIslemleri.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                new FirmaPaneli(firma).setVisible(true);
            });
        });

        // Geri butonu için ActionListener ekleme
        btnGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Geri butonu tıklandığında tekrar giriş ekranına yönlendir
                        new ArayuzTasarim().setVisible(true);
                    }
                });
            }
        });

        add(panel);
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
                        new RezervasyonSayfasi().setVisible(true);
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

    public String getKalkis() {
        return kalkis;
    }

    public String getVaris() {
        return varis;
    }

    public String getTarih() {
        return tarih;
    }

    public int getKoltukSayisi() {
        return koltukSayisi;
    }

    public int getBosKoltukSayisi() {
        return bosKoltukSayisi;
    }
}

class RezervasyonSayfasi extends JFrame {

    private SeyahatRezervasyonSistemi parent;
    private JComboBox<String> cmbGun;
    private JComboBox<String> cmbKalkis;
    private JComboBox<String> cmbVaris;
    private JComboBox<String> cmbUlasimYolu;
    private JTextField txtYolcuSayisi;

    public RezervasyonSayfasi() {
        setTitle("Rezervasyon Sayfası");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        parent = new SeyahatRezervasyonSistemi();

        JPanel panel = new JPanel();
        cmbGun = new JComboBox<>(SeyahatRezervasyonSistemi.GUNLER);
        cmbKalkis = new JComboBox<>(new String[]{"İstanbul", "Ankara", "İzmir"});
        cmbVaris = new JComboBox<>(new String[]{"Ankara", "İstanbul", "İzmir"});
        txtYolcuSayisi = new JTextField(10);
        cmbUlasimYolu = new JComboBox<>(new String[]{"Hava Yolu", "Demir Yolu", "Kara Yolu"});
        JButton btnSeferBul = new JButton("Sefer Bul");

        panel.add(new JLabel("Ulaşım Yolu:"));
        panel.add(cmbUlasimYolu);
        panel.add(new JLabel("Tarih:"));
        panel.add(cmbGun);
        panel.add(new JLabel("Kalkış Şehri:"));
        panel.add(cmbKalkis);
        panel.add(new JLabel("Varış Şehri:"));
        panel.add(cmbVaris);
        panel.add(new JLabel("Yolcu Sayısı:"));
        panel.add(txtYolcuSayisi);
        panel.add(btnSeferBul);

        add(panel);

        btnSeferBul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String secilenGun = (String) cmbGun.getSelectedItem();
                String secilenKalkis = (String) cmbKalkis.getSelectedItem();
                String secilenVaris = (String) cmbVaris.getSelectedItem();
                int yolcuSayisi = Integer.parseInt(txtYolcuSayisi.getText());
                String secilenUlasimYolu = (String) cmbUlasimYolu.getSelectedItem();

                Sefer uygunSefer = null;
                for (Sefer sefer : parent.getSeferListesi()) {
                    if (sefer.getTarih().equals(secilenGun) && sefer.getKalkis().equals(secilenKalkis)
                            && sefer.getVaris().equals(secilenVaris) && sefer.getBosKoltukSayisi() >= yolcuSayisi) {
                        uygunSefer = sefer;
                        break;
                    }
                }

                if (uygunSefer != null) {
                    dispose();
                    Sefer finalUygunSefer = uygunSefer;
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            double fiyat = fiyatlandirmaYap(finalUygunSefer, secilenUlasimYolu, yolcuSayisi);
                            new RezervasyonTamamlamaSayfasi(finalUygunSefer, yolcuSayisi, fiyat).setVisible(true);
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Uygun sefer bulunamadı.");
                }
            }
        });
    }

    private double fiyatlandirmaYap(Sefer sefer, String ulasimYolu, int yolcuSayisi) {
        double fiyat = 0;
        switch (ulasimYolu) {
            case "Hava Yolu":
                fiyat = sefer.getKoltukSayisi() * 5.0 * yolcuSayisi;
                break;
            case "Demir Yolu":
                fiyat = sefer.getKoltukSayisi() * 3.0 * yolcuSayisi;
                break;
            case "Kara Yolu":
                fiyat = sefer.getKoltukSayisi() * 2.0 * yolcuSayisi;
                break;
            default:
                break;
        }
        return fiyat;
    }
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
}