import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class user extends JFrame implements ILoginable{
    String kullaniciAdi;
    String sifre;
    @Override
    public void login(){// Giriş ekranını oluştur
        JFrame cerceve = new JFrame("Giriş Yap");
        cerceve.setSize(400, 200);
        cerceve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel kullaniciEtiketi = new JLabel("Kullanıcı Adı:");
        JLabel sifreEtiketi = new JLabel("Şifre:");
        JTextField kullaniciAlani = new JTextField(10);
        JPasswordField sifreAlani = new JPasswordField(10);
        JButton girisButonu = new JButton("Giriş");

        panel.add(kullaniciEtiketi);
        panel.add(kullaniciAlani);
        panel.add(sifreEtiketi);
        panel.add(sifreAlani);
        panel.add(girisButonu);

        cerceve.add(panel);

        // Giriş butonuna tıklandığında yapılacak işlemler
        girisButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String girilenKullaniciAdi = kullaniciAlani.getText();
                String girilenSifre = new String(sifreAlani.getPassword());
                if(sifreKontrol(girilenKullaniciAdi, girilenSifre)>=0){
                    cerceve.dispose(); // Giriş ekranını kapat
                    company kullanici = new company();
                    kullanici = (company) admin.firmaListesi.get(sifreKontrol(girilenKullaniciAdi, girilenSifre));
                    kullanici.page(kullanici);
                }
                else if(sifreKontrol(girilenKullaniciAdi, girilenSifre)==-2){
                    cerceve.dispose(); // Giriş ekranını kapat
                    admin kullanici = new admin();
                    kullanici.page(kullanici);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Hatalı Kullanıcı Adı veya Şifre");
                }
            }
        });

        cerceve.setVisible(true);}

    abstract int sifreKontrol(String girilenKullaniciAdi, String girilenSifre);
}
