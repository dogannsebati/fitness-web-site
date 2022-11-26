package entity;

import java.util.Objects;

public class Egitim {

    private int egitim_id;
    private String egitim_icerik;
    private String egitim_adi;
    private String egitim_ucret;

    private Egitmen egitmen;
    private Document document;

    public Egitim() {
    }

    public Egitim(int egitim_id, String egitim_icerik, String egitim_adi, String egitim_ucret) {
        this.egitim_id = egitim_id;
        this.egitim_icerik = egitim_icerik;
        this.egitim_adi = egitim_adi;
        this.egitim_ucret = egitim_ucret;
    }

    public int getEgitim_id() {
        return egitim_id;
    }

    public void setEgitim_id(int egitim_id) {
        this.egitim_id = egitim_id;
    }

    public String getEgitim_icerik() {
        return egitim_icerik;
    }

    public void setEgitim_icerik(String egitim_icerik) {
        this.egitim_icerik = egitim_icerik;
    }

    public String getEgitim_adi() {
        return egitim_adi;
    }

    public void setEgitim_adi(String egitim_adi) {
        this.egitim_adi = egitim_adi;
    }

    public String getEgitim_ucret() {
        return egitim_ucret;
    }

    public void setEgitim_ucret(String egitim_ucret) {
        this.egitim_ucret = egitim_ucret;
    }

    public Egitmen getEgitmen() {
        if (egitmen == null) {
            egitmen = new Egitmen();
        }
        return egitmen;
    }

    public void setEgitmen(Egitmen egitmen) {
        this.egitmen = egitmen;
    }

    public Document getDocument() {
        if (this.document == null) {
            this.document = new Document();
        }
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.egitim_id;
        hash = 97 * hash + Objects.hashCode(this.egitim_icerik);
        hash = 97 * hash + Objects.hashCode(this.egitim_adi);
        hash = 97 * hash + Objects.hashCode(this.egitim_ucret);
        hash = 97 * hash + Objects.hashCode(this.egitmen);
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
        final Egitim other = (Egitim) obj;
        if (this.egitim_id != other.egitim_id) {
            return false;
        }
        if (!Objects.equals(this.egitim_icerik, other.egitim_icerik)) {
            return false;
        }
        if (!Objects.equals(this.egitim_adi, other.egitim_adi)) {
            return false;
        }
        if (!Objects.equals(this.egitim_ucret, other.egitim_ucret)) {
            return false;
        }
        if (!Objects.equals(this.egitmen, other.egitmen)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Egitim{" + "egitim_id=" + egitim_id + ", egitim_icerik=" + egitim_icerik + ", egitim_adi=" + egitim_adi + ", egitim_ucret=" + egitim_ucret + ", egitmen=" + egitmen + '}';
    }

}
