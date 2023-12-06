import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class Transport implements IReservable {

    public List<Bus> karaAraclari = new ArrayList<>();
    public List<Airplane> havaAraclari = new ArrayList<>();
    public List<Train> trenAraclari = new ArrayList<>();

    public void seferBilgisi() {

        company currentCompany = ArayuzTasarim.getCurrentLoggedInCompany();

        if (currentCompany != null) {
            List<Trip> seyahatBilgileri = currentCompany.seyahatBilgileri;

            if (!seyahatBilgileri.isEmpty()) {
                for (Trip trip : seyahatBilgileri) {
                    // Check for null values in trip fields to avoid NullPointerException
                    String guzergah = trip.guzergah != null ? trip.guzergah.toString() : "N/A";
                    String aracInfo = trip.arac != null ? trip.arac.toString() : "N/A";
                    String tarih = trip.tarih != null ? trip.tarih : "N/A";
                    String seferInfo = trip.sefer != null ? trip.sefer.toString() : "N/A";

                    JOptionPane.showMessageDialog(null,
                            "Oluşturulan Sefer: " + trip.guzergah +
                                    "\nAraç: " + aracInfo +
                                    "\nTarih: " + tarih +
                                    "\nToplam Mesafe: " + trip.yolUzunlugu + " km" +
                                    "\nKoltuk Sayısı: " + trip.koltukSayisi +
                                    "\nBoş Koltuk Sayısı: " + trip.bosKoltuk +
                                    "\nRota: " + seferInfo);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bu firma için seyahat bilgisi bulunmamaktadır.");
            }
        }

    }

    public void sirketler() {
        if (admin.firmaListesi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kayıtlı firma bulunmamaktadır.");
        } else {
            String firmalar = "";
            for (company firma : admin.firmaListesi) {
                firmalar += firma.kullaniciAdi + "\n";
            }
            JOptionPane.showMessageDialog(null, "Firmalar:\n" + firmalar);
        }

    }

    public void koltukBilgileri() {
        StringBuilder koltukBilgisi = new StringBuilder("Koltuk Bilgileri:\n");
        if (!karaAraclari.isEmpty()) {
            koltukBilgisi.append("Otobüsler:\n");
            for (Bus otobus : karaAraclari) {
                koltukBilgisi.append("Araç ID: ").append(otobus.id).append(", Boş Koltuk Sayısı: ").append(otobus.bosKoltuk).append("\n");
            }
        }

        if (!havaAraclari.isEmpty()) {
            koltukBilgisi.append("Uçaklar:\n");
            for (Airplane ucak : havaAraclari) {
                koltukBilgisi.append("Araç ID: ").append(ucak.id).append(", Boş Koltuk Sayısı: ").append(ucak.bosKoltuk).append("\n");
            }
        }

        if (!trenAraclari.isEmpty()) {
            koltukBilgisi.append("Trenler:\n");
            for (Train tren : trenAraclari) {
                koltukBilgisi.append("Araç ID: ").append(tren.id).append(", Boş Koltuk Sayısı: ").append(tren.bosKoltuk).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, koltukBilgisi.toString());
    }

    public void araclar() {
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

        if (tur != null) {
            if (tur.equals("Uçak")) {
                if (havaAraclari.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Araç bulunmamaktadır");
                } else {
                    StringBuilder yazacakYazi = new StringBuilder();
                    for (int i = 0; i < havaAraclari.size(); i++) {
                        yazacakYazi.append("id: ").append(havaAraclari.get(i).id);
                    }
                    JOptionPane.showMessageDialog(null, yazacakYazi);
                }
            } else if (tur.equals("Tren")) {
                if (trenAraclari.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Araç bulunmamaktadır");
                } else {
                    StringBuilder yazacakYazi = new StringBuilder();
                    for (int i = 0; i < trenAraclari.size(); i++) {
                        yazacakYazi.append("id: ").append(trenAraclari.get(i).id);
                    }
                    JOptionPane.showMessageDialog(null, yazacakYazi);
                }
            } else if (tur.equals("Otobüs")) {
                if (karaAraclari.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Araç bulunmamaktadır");
                } else {
                    StringBuilder yazacakYazi = new StringBuilder();
                    for (int i = 0; i < karaAraclari.size(); i++) {
                        yazacakYazi.append("id: ").append(karaAraclari.get(i).id);
                    }
                    JOptionPane.showMessageDialog(null, yazacakYazi);
                }
            }
        }
    }
}

