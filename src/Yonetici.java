import java.util.ArrayList;

public class Yonetici extends Kullanici {
    private ArrayList<Calisan> calisanListesi;
    private ArrayList<Kullanici> kullaniciListesi;

    public Yonetici(long tc) {
        super(tc);
        this.calisanListesi = new ArrayList<>();
        this.kullaniciListesi = new ArrayList<>();
    }
    public void calisanEkle(Calisan yeniCalisan) {
        calisanListesi.add(yeniCalisan);
    }

    public void calisanSil(Calisan calisan) {
        calisanListesi.remove(calisan);
    }

    public void calisanBilgileriniGoruntule() {
        for (Calisan calisan : calisanListesi) {
            System.out.println("TC: " + calisan.getTc() + ", Departman: " + calisan.getDepartment() + ", Maaş: " + calisan.getMaas());
        }
    }
    public void kullaniciEkle(Kullanici yeniKullanici) {
        kullaniciListesi.add(yeniKullanici);
    }

    public void kullaniciSil(Kullanici kullanici) {
        kullaniciListesi.remove(kullanici);
    }

    public void kullaniciBilgileriniGoruntule() {
        for (Kullanici kullanici : kullaniciListesi) {
            System.out.println("TC: " + kullanici.getTc() + ", Ad: " + kullanici.getAd() + ", Soyad: " + kullanici.getSoyad());
        }
    }

}
