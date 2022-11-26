package entity;

public class AlinanEgitim {

    private int alinan_id;
    private Uye uye;
    private Egitim egitim;

    public AlinanEgitim() {
    }

    public AlinanEgitim(int alinan_id) {
        this.alinan_id = alinan_id;

    }

    public int getAlinan_id() {
        return alinan_id;
    }

    public void setAlinan_id(int alinan_id) {
        this.alinan_id = alinan_id;
    }

    public Uye getUye() {
        if (this.uye == null) {
            this.uye = new Uye();

        }
        return uye;
    }

    public void setUye(Uye uye) {
        this.uye = uye;
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
        hash = 89 * hash + this.alinan_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlinanEgitim other = (AlinanEgitim) obj;
        if (this.alinan_id != other.alinan_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AlinanEgitim{" + "alinan_id=" + alinan_id + ", uye=" + uye + ", egitim=" + egitim + '}';
    }

}
