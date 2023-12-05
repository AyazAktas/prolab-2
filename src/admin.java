import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class admin extends user{

    private String kullaniciAdi = "admin";
    private String sifre = "admin123";
    public static List<company> firmaListesi = new ArrayList<company>();
    private static double hizmetBedeli;



    public void page(admin kullanici) {
        JFrame cerceve = new JFrame("Yönetici Sayfası");
        cerceve.setSize(600, 400);
        cerceve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton btnGoruntule = new JButton("Firmaları Görüntüle");
        JButton btnYeniFirma = new JButton("Yeni Firma Kaydı");
        JButton btnFirmaSil = new JButton("Firma Sil");
        JButton btnHizmetBedeliBelirle = new JButton("Hizmet Bedeli Belirle");
        JButton btnGeri = new JButton("Geri");

        panel.add(btnGoruntule);
        panel.add(btnYeniFirma);
        panel.add(btnFirmaSil);
        panel.add(btnHizmetBedeliBelirle);
        panel.add(btnGeri);

        cerceve.add(panel); // Paneli JFrame'e ekle
        cerceve.setVisible(true); // JFrame'i görünür yap

        btnGoruntule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firmaListesi.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Kayıtlı firma bulunmamaktadır.");
                } else {
                    String firmalar = "";
                    for (company firma : firmaListesi) {
                        firmalar += firma.kullaniciAdi + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "Firmalar:\n" + firmalar);
                }
            }
        });

        btnYeniFirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String yeniFirmaAdi = JOptionPane.showInputDialog("Yeni firma adını girin:");
                company company = new company();
                company.firmaAdi = yeniFirmaAdi;
                String yeniFirmauser = JOptionPane.showInputDialog("Yeni firma kullanıcı adını girin:");
                company.kullaniciAdi = yeniFirmauser;
                String yeniFirmaPassword = JOptionPane.showInputDialog("Yeni firma şifresini girin:");
                company.sifre = yeniFirmaPassword;
                admin.firmaListesi.add(company);
                JOptionPane.showMessageDialog(null, "Yeni firma başarıyla kaydedildi.");
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
                    JOptionPane.showMessageDialog(null, "Geçersiz bir sayı girişi yapıldı.");
                }
            }
        });

        btnGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerceve.dispose(); // Close the current frame
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Open the new frame
                        new ArayuzTasarim().setVisible(true);
                    }
                });
            }
        });
    }

    @Override
    int sifreKontrol(String girilenKullaniciAdi, String girilenSifre) {
        if (girilenKullaniciAdi.equals(kullaniciAdi) && girilenSifre.equals(sifre)) {
            JOptionPane.showMessageDialog(null, "Giriş Başarılı");
            // Burada giriş başarılı olduğunda yapılacak işlemleri ekleyebilirsiniz.
            // Örneğin, yeni bir pencere açabilir veya başka bir işlem gerçekleştirebilirsiniz.
            return -2;
        }
        else{
            return -1;
        }
    }
}