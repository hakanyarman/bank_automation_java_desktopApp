public class Calisan extends Kullanici{
    private int maas;
    private String department;

    public Calisan(int maas,String department, long tc){
        super(tc);
        this.maas = maas;
        this.department = department;
    }

    public void setMaas(int maas){
        this.maas = maas;
    }
    public int getMaas(){
        return this.maas;
    }

    public String getDepartment() {
        return this.department;
    }

    public void krediOnayiVer(Kullanici kullanici, double miktar) {
        boolean krediIzın = kullanici.getBakiye() >= 500;
        if(krediIzın){
            System.out.println("Çalışan " + this.getAd() + " kredi onayı veriyor: " + kullanici.getAd() + ", Miktar: " + miktar);
        }else{
            System.out.println("Kredi başvurusunun onaylanması için bakiyenin en az 500 Tl olması gerekmektedir.");
        }

    }
}
