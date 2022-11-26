package entity;

import java.util.Objects;

public class BilgiIslem {

    private int bilgi_id;
    private String baslangic_tarihi;
    private String bitis_tarihi;

    private Uye uye;

    public BilgiIslem() {
    }

    public BilgiIslem(int bilgi_id, String baslangic_tarihi, String bitis_tarihi) {
        this.bilgi_id = bilgi_id;
        this.baslangic_tarihi = baslangic_tarihi;
        this.bitis_tarihi = bitis_tarihi;
    }

    public int getBilgi_id() {
        return bilgi_id;
    }

    public void setBilgi_id(int bilgi_id) {
        this.bilgi_id = bilgi_id;
    }

    public String getBaslangic_tarihi() {
        return baslangic_tarihi;
    }

    public void setBaslangic_tarihi(String baslangic_tarihi) {
        this.baslangic_tarihi = baslangic_tarihi;
    }

    public String getBitis_tarihi() {
        return bitis_tarihi;
    }

    public void setBitis_tarihi(String bitis_tarihi) {
        this.bitis_tarihi = bitis_tarihi;
    }

    public Uye getUye() {
        return uye;
    }

    public void setUye(Uye uye) {
        this.uye = uye;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.bilgi_id;
        hash = 71 * hash + Objects.hashCode(this.baslangic_tarihi);
        hash = 71 * hash + Objects.hashCode(this.bitis_tarihi);
        hash = 71 * hash + Objects.hashCode(this.uye);
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
        final BilgiIslem other = (BilgiIslem) obj;
        if (this.bilgi_id != other.bilgi_id) {
            return false;
        }
        if (!Objects.equals(this.baslangic_tarihi, other.baslangic_tarihi)) {
            return false;
        }
        if (!Objects.equals(this.bitis_tarihi, other.bitis_tarihi)) {
            return false;
        }
        if (!Objects.equals(this.uye, other.uye)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BilgiIslem{" + "bilgi_id=" + bilgi_id + ", baslangic_tarihi=" + baslangic_tarihi + ", bitis_tarihi=" + bitis_tarihi + ", uye=" + uye + '}';
    }

}
