package entity;

import java.util.Objects;

public class Egitmen {

    private String egitmen_ad;
    private String egitmen_soyad;
    private String egitmen_cinsiyet;
    private int egitmen_yas;
    private String egitmen_cep_telefonu;
    private String egitmen_email;
    private int egitmen_id;
    private String uz_alan;
    private String tecrube;

    public Egitmen() {
    }

    public Egitmen(String egitmen_ad, String egitmen_soyad, String egitmen_cinsiyet, int egitmen_yas, String egitmen_cep_telefonu, String egitmen_email, int egitmen_id, String uz_alan, String tecrube) {
        this.egitmen_ad = egitmen_ad;
        this.egitmen_soyad = egitmen_soyad;
        this.egitmen_cinsiyet = egitmen_cinsiyet;
        this.egitmen_yas = egitmen_yas;
        this.egitmen_cep_telefonu = egitmen_cep_telefonu;
        this.egitmen_email = egitmen_email;
        this.egitmen_id = egitmen_id;
        this.uz_alan = uz_alan;
        this.tecrube = tecrube;

    }

    public String getEgitmen_ad() {
        return egitmen_ad;
    }

    public void setEgitmen_ad(String egitmen_ad) {
        this.egitmen_ad = egitmen_ad;
    }

    public String getEgitmen_soyad() {
        return egitmen_soyad;
    }

    public void setEgitmen_soyad(String egitmen_soyad) {
        this.egitmen_soyad = egitmen_soyad;
    }

    public String getEgitmen_cinsiyet() {
        return egitmen_cinsiyet;
    }

    public void setEgitmen_cinsiyet(String egitmen_cinsiyet) {
        this.egitmen_cinsiyet = egitmen_cinsiyet;
    }

    public int getEgitmen_yas() {
        return egitmen_yas;
    }

    public void setEgitmen_yas(int egitmen_yas) {
        this.egitmen_yas = egitmen_yas;
    }

    public String getEgitmen_cep_telefonu() {
        return egitmen_cep_telefonu;
    }

    public void setEgitmen_cep_telefonu(String egitmen_cep_telefonu) {
        this.egitmen_cep_telefonu = egitmen_cep_telefonu;
    }

    public String getEgitmen_email() {
        return egitmen_email;
    }

    public void setEgitmen_email(String egitmen_email) {
        this.egitmen_email = egitmen_email;
    }

    public int getEgitmen_id() {
        return egitmen_id;
    }

    public void setEgitmen_id(int egitmen_id) {
        this.egitmen_id = egitmen_id;
    }

    public String getUz_alan() {
        return uz_alan;
    }

    public void setUz_alan(String uz_alan) {
        this.uz_alan = uz_alan;
    }

    public String getTecrube() {
        return tecrube;
    }

    public void setTecrube(String tecrube) {
        this.tecrube = tecrube;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.egitmen_ad);
        hash = 73 * hash + Objects.hashCode(this.egitmen_soyad);
        hash = 73 * hash + Objects.hashCode(this.egitmen_cinsiyet);
        hash = 73 * hash + this.egitmen_yas;
        hash = 73 * hash + Objects.hashCode(this.egitmen_cep_telefonu);
        hash = 73 * hash + Objects.hashCode(this.egitmen_email);
        hash = 73 * hash + this.egitmen_id;
        hash = 73 * hash + Objects.hashCode(this.uz_alan);
        hash = 73 * hash + Objects.hashCode(this.tecrube);
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
        final Egitmen other = (Egitmen) obj;
        if (!Objects.equals(this.egitmen_ad, other.egitmen_ad)) {
            return false;
        }
        if (!Objects.equals(this.egitmen_soyad, other.egitmen_soyad)) {
            return false;
        }
        if (!Objects.equals(this.egitmen_cinsiyet, other.egitmen_cinsiyet)) {
            return false;
        }
        if (this.egitmen_yas != other.egitmen_yas) {
            return false;
        }
        if (!Objects.equals(this.egitmen_cep_telefonu, other.egitmen_cep_telefonu)) {
            return false;
        }
        if (!Objects.equals(this.egitmen_email, other.egitmen_email)) {
            return false;
        }
        if (this.egitmen_id != other.egitmen_id) {
            return false;
        }
        if (!Objects.equals(this.uz_alan, other.uz_alan)) {
            return false;
        }
        if (!Objects.equals(this.tecrube, other.tecrube)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Egitmen{" + "egitmen_ad=" + egitmen_ad + ", egitmen_soyad=" + egitmen_soyad + ", egitmen_cinsiyet=" + egitmen_cinsiyet + ", egitmen_yas=" + egitmen_yas + ", egitmen_cep_telefonu=" + egitmen_cep_telefonu + ", egitmen_email=" + egitmen_email + ", egitmen_id=" + egitmen_id + ", uz_alan=" + uz_alan + ", tecrube=" + tecrube + '}';
    }

}
