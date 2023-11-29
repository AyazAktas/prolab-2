import java.util.List;

public class company extends user implements IProfitable{
    String firmaAdi;
    private List<Vehicle> aracbilgileri;
    @Override
    void page() {

    }

    String getFirmaAdi(){
        return firmaAdi;
    }
}
