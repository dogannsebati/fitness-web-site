package entity;

import java.util.Objects;

public class DiyetListesi {

    private int diyet_id;
    private String yemek_isim;
    private String gramaj;
    private String saat_araligi;

    private Egitim egitim;

    public DiyetListesi() {
    }

    public DiyetListesi(int diyet_id, String yemek_isim, String gramaj, String saat_araligi) {
        this.diyet_id = diyet_id;
        this.yemek_isim = yemek_isim;
        this.gramaj = gramaj;
        this.saat_araligi = saat_araligi;

    }

    public int getDiyet_id() {
        return diyet_id;
    }

    public void setDiyet_id(int diyet_id) {
        this.diyet_id = diyet_id;
    }

    public String getYemek_isim() {
        return yemek_isim;
    }

    public void setYemek_isim(String yemek_isim) {
        this.yemek_isim = yemek_isim;
    }

    public String getGramaj() {
        return gramaj;
    }

    public void setGramaj(String gramaj) {
        this.gramaj = gramaj;
    }

    public String getSaat_araligi() {
        return saat_araligi;
    }

    public void setSaat_araligi(String saat_araligi) {
        this.saat_araligi = saat_araligi;
    }

    public Egitim getEgitim() {
        if (this.egitim == null) {
            this.egitim = new Egitim();

        }
        return egitim;
    }

    public void setEgitim(Egitim egitim) {
        this.egitim = egitim;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.diyet_id;
        hash = 83 * hash + Objects.hashCode(this.yemek_isim);
        hash = 83 * hash + Objects.hashCode(this.gramaj);
        hash = 83 * hash + Objects.hashCode(this.saat_araligi);
        hash = 83 * hash + Objects.hashCode(this.egitim);
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
        final DiyetListesi other = (DiyetListesi) obj;
        if (this.diyet_id != other.diyet_id) {
            return false;
        }
        if (!Objects.equals(this.yemek_isim, other.yemek_isim)) {
            return false;
        }
        if (!Objects.equals(this.gramaj, other.gramaj)) {
            return false;
        }
        if (!Objects.equals(this.saat_araligi, other.saat_araligi)) {
            return false;
        }
        if (!Objects.equals(this.egitim, other.egitim)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DiyetListesi{" + "diyet_id=" + diyet_id + ", yemek_isim=" + yemek_isim + ", gramaj=" + gramaj + ", saat_araligi=" + saat_araligi + ", egitim=" + egitim + '}';
    }

}
