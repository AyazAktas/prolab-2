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

                if (girilenKullaniciAdi.equals(kullaniciAdi) && girilenSifre.equals(sifre)) {
                    JOptionPane.showMessageDialog(null, "Giriş Başarılı");
                    // Burada giriş başarılı olduğunda yapılacak işlemleri ekleyebilirsiniz.
                    // Örneğin, yeni bir pencere açabilir veya başka bir işlem gerçekleştirebilirsiniz.
                    cerceve.dispose(); // Giriş ekranını kapat
                    page();
                } else {
                    JOptionPane.showMessageDialog(null, "Hatalı Kullanıcı Adı veya Şifre");
                }
            }
        });

        cerceve.setVisible(true);}
    abstract void page();
}
