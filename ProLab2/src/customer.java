import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class customer extends Person {

    public customer(String ad, String soyad, String tcKimlik, String dogumTarihi) {
        super(ad, soyad, tcKimlik, dogumTarihi);
    }
    public customer(){

    }
    public static void createAndShowGUI() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Müşteri Sayfası");
            frame.setSize(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            JButton btnRezervasyon = new JButton("Rezervasyon Yap");
            JButton btnGeri = new JButton("Geri");
            panel.add(btnRezervasyon);
            panel.add(btnGeri);
            frame.add(panel);


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
            btnRezervasyon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    customer customer = new customer();
                    customer.initialize();
                }
            });

            frame.setVisible(true);
        });
    }

    public void initialize() {
        setTitle("Rezervasyon Sayfası");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        JComboBox<String>cmbGun = new JComboBox<>(new String[] {"4 Aralık 2023", "5 Aralık 2023", "6 Aralık 2023", "7 Aralık 2023", "8 Aralık 2023", "9 Aralık 2023", "10 Aralık 2023"});
        JComboBox<String>cmbKalkis = new JComboBox<>(new String[]{"İstanbul", "Ankara", "Kocaeli", "Eskişehir", "Konya","Bilecik"});
        JComboBox<String>cmbVaris = new JComboBox<>(new String[]{"İstanbul", "Ankara", "Kocaeli", "Eskişehir", "Konya","Bilecik"});
        //JTextField txtYolcuSayisi = new JTextField(7);
        JButton btnSeferBul = new JButton("Sefer Bul");


        panel.add(new JLabel("Tarih:"));
        panel.add(cmbGun);
        panel.add(new JLabel("Kalkış Şehri:"));
        panel.add(cmbKalkis);
        panel.add(new JLabel("Varış Şehri:"));
        panel.add(cmbVaris);
        //panel.add(new JLabel("Yolcu Sayısı:"));
        //panel.add(txtYolcuSayisi);
        panel.add(btnSeferBul);

        add(panel);

        btnSeferBul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String secilenGun = (String) cmbGun.getSelectedItem();
                String secilenKalkis = (String) cmbKalkis.getSelectedItem();
                String secilenVaris = (String) cmbVaris.getSelectedItem();
                List<Trip> seciliSeferler = new ArrayList<>();
                List<company> seferlerinFirmasi = new ArrayList<>();
                for(int i=0;i<admin.firmaListesi.size();i++){
                    for (int j=0; j<admin.firmaListesi.get(i).seyahatBilgileri.size();j++){
                        if(admin.firmaListesi.get(i).seyahatBilgileri.get(j)!=null &&admin.firmaListesi
                                .get(i).seyahatBilgileri.get(j).guzergah!= null){
                            if(admin.firmaListesi.get(i).seyahatBilgileri.get(j).guzergah.contains(secilenKalkis)&&admin.firmaListesi
                                    .get(i).seyahatBilgileri.get(j).guzergah.contains(secilenVaris)&&admin.firmaListesi.get(i).seyahatBilgileri
                                    .get(j).tarih.equals(secilenGun)){
                                seciliSeferler.add(admin.firmaListesi.get(i).seyahatBilgileri.get(j));
                                seferlerinFirmasi.add(admin.firmaListesi.get(i));

                                //Sefer bulunması durumu
                            }
                        }
                    }
                }

                if(!seferlerinFirmasi.isEmpty() &&!seciliSeferler.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Aradığınız sefer mevcuttur.");
                    dispose();
                    new Thread(() -> seferleriGoruntule(seferlerinFirmasi, seciliSeferler,secilenKalkis,secilenVaris)).start();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Sefer bulunmamaktadır");
                }
            }
        });

        setVisible(true);
    }
    void seferleriGoruntule(List<company> firmaList, List<Trip> seferList, String kalkis, String varis) {
        // Örnek bir JFrame oluşturup içeriği doldur
        String[] columnNames = {"Sıra no", "Firma", "Ulaşım yolu", "Kalkış", "Varış", "Tarih", "Fiyat","Boş Koltuk Sayısı"};
        Object[][] data = new Object[seferList.size()][8];
        FiyatMatrisi fiyatMatrisi = new FiyatMatrisi();
        for (int i = 0; i < seferList.size(); i++) {
            Trip sefer = seferList.get(i);
            data[i][0] = i + 1;
            data[i][1] = firmaList.get(i).kullaniciAdi;
            data[i][2] = sefer.arac.tur;
            data[i][3] = kalkis;
            data[i][4] = varis;
            data[i][5] = sefer.tarih;
            if(sefer.arac.tur.equals("Kara yolu")){
            data[i][6] = fiyatMatrisi.getKarayoluFiyatlari(kalkis,varis);}
            if(sefer.arac.tur.equals("Hava yolu")){
                data[i][6]=fiyatMatrisi.getHavayoluFiyatlari(kalkis,varis);
            }
            if(sefer.arac.tur.equals("Demir yolu")){
                data[i][6]=fiyatMatrisi.getDemiryoluFiyatlari(kalkis,varis);
            }
            data[i][7]=sefer.arac.bosKoltukSayisi();
        }

        JFrame seferGoruntuleFrame = new JFrame("Uygun Seferler");
        seferGoruntuleFrame.setSize(600, 400);
        seferGoruntuleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox<Integer> cmbSeferNo = new JComboBox<>();
        for (int i = 0; i < firmaList.size(); i++) {
            cmbSeferNo.addItem(i + 1);
        }
        JComboBox<Integer> cmbBiletSayisi = new JComboBox<>();
        for (int i = 0; i < 23; i++) {
            cmbBiletSayisi.addItem(i+1);
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        seferGoruntuleFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Gitmek istediğiniz sefer no seçiniz:"));
        panel.add(cmbSeferNo);

        panel.add(new JLabel("Kaç Adet Bilet alacağınızı seçin:"));
        panel.add(cmbBiletSayisi);

        JButton satinAlButton = new JButton("Satın Al");
        satinAlButton.addActionListener(e -> {
            // Satın alma işlemleri burada gerçekleştirilebilir
            int selectedSeferNo = (int) cmbSeferNo.getSelectedItem();
            System.out.println("Seçilen Sefer No: " + selectedSeferNo);
            // Burada satın alma işlemlerini gerçekleştirebilirsiniz
        });
        panel.add(satinAlButton);
        satinAlButton.addActionListener(e -> {
            int selectedSeferNo = (int) cmbSeferNo.getSelectedItem();
            int selectedBiletSayisi = (int) cmbBiletSayisi.getSelectedItem();

            // Get the selected trip and company
            Trip selectedSefer = seferList.get(selectedSeferNo - 1);
            company selectedFirma = firmaList.get(selectedSeferNo - 1);
            int fiyat = (int) data[selectedSeferNo-1][6];
            // Create a dialog to collect additional information
            JDialog infoDialog = new JDialog();
            infoDialog.setSize(300, 200);
            infoDialog.setLayout(new GridLayout(5, 2));

            JTextField txtAd = new JTextField();
            JTextField txtSoyad = new JTextField();
            JTextField txtTcKimlik = new JTextField();
            JTextField txtDogumTarihi = new JTextField();

            infoDialog.add(new JLabel("Ad:"));
            infoDialog.add(txtAd);
            infoDialog.add(new JLabel("Soyad:"));
            infoDialog.add(txtSoyad);
            infoDialog.add(new JLabel("TC Kimlik:"));
            infoDialog.add(txtTcKimlik);
            infoDialog.add(new JLabel("Doğum Tarihi:"));
            infoDialog.add(txtDogumTarihi);

            JButton btnOnayla = new JButton("Onayla");

            btnOnayla.addActionListener(e1 -> {
                JOptionPane.showMessageDialog(null, selectedBiletSayisi + " bilet satın alındı!");
                selectedFirma.bakiye+=selectedSefer.arac.doluKoltukSayisi*fiyat;
                int bakiyeArtisi = selectedBiletSayisi * fiyat;
                selectedFirma.bakiye += bakiyeArtisi;

                selectedSefer.arac.doluKoltukSayisi += selectedBiletSayisi;

                String ad = txtAd.getText();
                String soyad = txtSoyad.getText();
                String tcKimlik = txtTcKimlik.getText();
                String dogumTarihi = txtDogumTarihi.getText();
                Passenger passenger = new Passenger(ad,soyad,tcKimlik,dogumTarihi);
                Passenger.yolcuBilgileri.add(passenger);
                Reservation reservation = new Reservation(passenger,selectedSefer.arac,selectedBiletSayisi);
                Reservation.rezervasyonBilgileri.add(reservation);

                infoDialog.dispose();

                seferGoruntuleFrame.dispose();

                SwingUtilities.invokeLater(() -> {
                    new ArayuzTasarim().setVisible(true);
                });
            });

            infoDialog.add(btnOnayla);

            infoDialog.setVisible(true);
        });


        // Panel'i JFrame'e ekle
        seferGoruntuleFrame.getContentPane().add(panel, BorderLayout.SOUTH);

        // setVisible'ı buraya taşıyın
        seferGoruntuleFrame.setVisible(true);

    }


}