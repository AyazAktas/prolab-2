import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            panel.add(btnRezervasyon);
            frame.add(panel);

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
        JComboBox<String>cmbGun = new JComboBox<>(SeyahatRezervasyonSistemi.GUNLER);
        JComboBox<String>cmbKalkis = new JComboBox<>(new String[]{"İstanbul", "Ankara", "İzmir"});
        JComboBox<String>cmbVaris = new JComboBox<>(new String[]{"Ankara", "İstanbul", "İzmir"});
        JTextField txtYolcuSayisi = new JTextField(10);
        JComboBox<String> cmbUlasimYolu = new JComboBox<>(new String[]{"Hava Yolu", "Demir Yolu", "Kara Yolu"});
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
            }
        });
        setVisible(true);
    }

}
