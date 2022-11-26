package entity;

public class Olcum {

    private int olcum_id;
    private double kilo;
    private double boy;
    private double vucut_kitle_indeksi;

    public Olcum() {
    }

    public Olcum(int olcum_id, double kilo, double boy, double vucut_kitle_indeksi) {
        this.olcum_id = olcum_id;
        this.kilo = kilo;
        this.boy = boy;
        this.vucut_kitle_indeksi = vucut_kitle_indeksi;
    }

    public int getOlcum_id() {
        return olcum_id;
    }

    public void setOlcum_id(int olcum_id) {
        this.olcum_id = olcum_id;
    }

    public double getKilo() {
        return kilo;
    }

    public void setKilo(double kilo) {
        this.kilo = kilo;
    }

    public double getBoy() {
        return boy;
    }

    public void setBoy(double boy) {
        this.boy = boy;
    }

    public double getVucut_kitle_indeksi() {
        return vucut_kitle_indeksi;
    }

    public void setVucut_kitle_indeksi(double vucut_kitle_indeksi) {
        this.vucut_kitle_indeksi = vucut_kitle_indeksi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.olcum_id;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.kilo) ^ (Double.doubleToLongBits(this.kilo) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.boy) ^ (Double.doubleToLongBits(this.boy) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.vucut_kitle_indeksi) ^ (Double.doubleToLongBits(this.vucut_kitle_indeksi) >>> 32));
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
        final Olcum other = (Olcum) obj;
        if (this.olcum_id != other.olcum_id) {
            return false;
        }
        if (Double.doubleToLongBits(this.kilo) != Double.doubleToLongBits(other.kilo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.boy) != Double.doubleToLongBits(other.boy)) {
            return false;
        }
        if (Double.doubleToLongBits(this.vucut_kitle_indeksi) != Double.doubleToLongBits(other.vucut_kitle_indeksi)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Olcum{" + "olcum_id=" + olcum_id + ", kilo=" + kilo + ", boy=" + boy + ", vucut_kitle_indeksi=" + vucut_kitle_indeksi + '}';
    }

}
