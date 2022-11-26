package entity;

import java.util.List;

public class Uye {

    private int uye_id;
    private String uye_ad;
    private String uye_soyad;
    private String uye_cinsiyet;
    private String uye_tel;
    private int uye_yas;
    private String uye_mail;
    private String kart_no;
    private boolean admin;
    private String sifre;

    private List<Egitim> alegitim;

    public Uye(int uye_id, String uye_ad, String uye_soyad, String uye_cinsiyet, String uye_tel, int uye_yas, String uye_mail, String kart_no, boolean admin, String sifre, List<Egitim> alegitim) {
        this.uye_id = uye_id;
        this.uye_ad = uye_ad;
        this.uye_soyad = uye_soyad;
        this.uye_cinsiyet = uye_cinsiyet;
        this.uye_tel = uye_tel;
        this.uye_yas = uye_yas;
        this.uye_mail = uye_mail;
        this.kart_no = kart_no;
        this.admin = admin;
        this.sifre = sifre;
        this.alegitim = alegitim;
    }

    public Uye() {
    }

    public int getUye_id() {
        return uye_id;
    }

    public void setUye_id(int uye_id) {
        this.uye_id = uye_id;
    }

    public String getUye_ad() {
        return uye_ad;
    }

    public void setUye_ad(String uye_ad) {
        this.uye_ad = uye_ad;
    }

    public String getUye_soyad() {
        return uye_soyad;
    }

    public void setUye_soyad(String uye_soyad) {
        this.uye_soyad = uye_soyad;
    }

    public String getUye_cinsiyet() {
        return uye_cinsiyet;
    }

    public void setUye_cinsiyet(String uye_cinsiyet) {
        this.uye_cinsiyet = uye_cinsiyet;
    }

    public String getUye_tel() {
        return uye_tel;
    }

    public void setUye_tel(String uye_tel) {
        this.uye_tel = uye_tel;
    }

    public int getUye_yas() {
        return uye_yas;
    }

    public void setUye_yas(int uye_yas) {
        this.uye_yas = uye_yas;
    }

    public String getUye_mail() {
        return uye_mail;
    }

    public void setUye_mail(String uye_mail) {
        this.uye_mail = uye_mail;
    }

    public String getKart_no() {
        return kart_no;
    }

    public void setKart_no(String kart_no) {
        this.kart_no = kart_no;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public List<Egitim> getAlegitim() {
        return alegitim;
    }

    public void setAlegitim(List<Egitim> alegitim) {
        this.alegitim = alegitim;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.uye_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Uye other = (Uye) obj;
        if (this.uye_id != other.uye_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Uye{" + "uye_id=" + uye_id + ", uye_ad=" + uye_ad + ", uye_soyad=" + uye_soyad + ", uye_cinsiyet=" + uye_cinsiyet + ", uye_tel=" + uye_tel + ", uye_yas=" + uye_yas + ", uye_mail=" + uye_mail + ", kart_no=" + kart_no + ", admin=" + admin + ", sifre=" + sifre + ", alegitim=" + alegitim + '}';
    }

}
