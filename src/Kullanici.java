import javax.swing.*;

public abstract class Kullanici {
    private String ad, soyad, telefonNo, dogumGunu, sifre = "";
    private long tc;
    private int bakiye;

    public Kullanici(long tc) {
        this.tc = tc;
        setAd("");
        setSoyad("");
        setTelefonNo("");
        setDogumGunu("");
        setSifre("");
        setBakiye(0);
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getBakiye() {
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public String getDogumGunu() {
        return dogumGunu;
    }

    public void setDogumGunu(String dogumGunu) {
        this.dogumGunu = dogumGunu;
    }


    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public long getTc() {
        return tc;
    }

    public void setTc(long tc) {
        this.tc = tc;
    }
    public void girisyapildi() {
        JOptionPane.showMessageDialog(null, "Giriş İşlemi Başarıyla yapıldı.");
    }

}

