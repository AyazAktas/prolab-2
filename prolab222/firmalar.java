import java.util.ArrayList;

public class firmalar {
    ArrayList<Firma> firmaListesi = new ArrayList<>();

    public firmalar() {
        firmaListesi.add(new Firma("user1", "password1"));
        firmaListesi.add(new Firma("user2", "password2"));
    }
}
