package dao;

import entity.Egitim;
import entity.Uye;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UyeDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    EgitimDAO egitimdao;

    public void insert(Uye uye) {
        try {

            pst = this.getConnection().prepareStatement("insert into uyeler (uye_ad,uye_soyad,uye_cinsiyet,uye_tel,uye_yas,uye_mail,uye_kartno,admin,sifre) values (?,?,?,?,?,?,?,0,?)");
            pst.setString(1, uye.getUye_ad());
            pst.setString(2, uye.getUye_soyad());
            pst.setString(3, uye.getUye_cinsiyet());
            pst.setString(4, uye.getUye_tel());
            pst.setInt(5, uye.getUye_yas());
            pst.setString(6, uye.getUye_mail());
            pst.setString(7, uye.getKart_no());
            pst.setString(8, uye.getSifre());
            pst.executeUpdate();
            pst.close();
            pst = this.getConnection().prepareStatement("select uye_id from uyeler where uye_tel=?");
            pst.setString(1, uye.getUye_tel());
            rs = pst.executeQuery();
            int uye_id = 0;
            if (rs.next()) {
                uye_id = rs.getInt(1);
            }

            for (Egitim egitim : uye.getAlegitim()) { // bu foreach döngüsü many to many ilişkisine ekleme yapılması için kullanılıyor
                pst = this.getConnection().prepareStatement("insert into alinan_egitim(egitim_id,uye_id) values(?,?)");
                pst.setInt(1, egitim.getEgitim_id());
                pst.setInt(2, uye_id);
                pst.executeUpdate();
            }
            pst.close();

        } catch (SQLException ex) {
            System.out.println("UyeDAO HATA(Create) : " + ex.getMessage());
        }

    }

    public void delete(Uye uye) {
        try {
            pst = this.getConnection().prepareStatement("delete from uyeler where uye_id=?");
            pst.setInt(1, uye.getUye_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" UyeDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public List<Uye> findAll(String deger, int page, int pageSize) { //bu findall metodu tablo'da kullanılıyor
        List<Uye> ulist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM uyeler where  uye_ad like ? or uye_soyad  like ? order by uye_id asc limit " + start + " , " + pageSize);
            pst.setString(1, "%" + deger + "%"); // ara çubuğuna girilen herhangi bir değeri içeren bütün bilgileri getirmek için "%" + deger + "%" bu şekilde kullandık.
            pst.setString(2, "%" + deger + "%");

            rs = pst.executeQuery();
            while (rs.next()) {
                Uye temp = new Uye();
                temp.setUye_id(rs.getInt("uye_id"));
                temp.setUye_ad(rs.getString("uye_ad"));
                temp.setUye_soyad(rs.getString("uye_soyad"));
                temp.setUye_cinsiyet(rs.getString("uye_cinsiyet"));
                temp.setUye_yas(rs.getInt("uye_yas"));
                temp.setUye_tel(rs.getString("uye_tel"));
                temp.setUye_mail(rs.getString("uye_mail"));
                temp.setKart_no(rs.getString("uye_kartno"));
                temp.setSifre(rs.getString("sifre"));
                temp.setAlegitim(this.getEgitimdao().getAlinanEgitim(temp.getUye_id()));
                ulist.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println("UyeDAO HATA(READ):" + ex.getMessage());

        }
        return ulist;
    }

    public List<Uye> findAll() { // bu findall metodu one to many ilişkisideki eklemeler de selectmenubox ın içinde kullanılıyor.Sayfalamada çıkan hatayı önlemek için yazıldı.
        List<Uye> uye_list = new ArrayList();

        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM uyeler where admin=0");

            rs = pst.executeQuery();
            while (rs.next()) {
                Uye temp = new Uye();
                temp.setUye_id(rs.getInt("uye_id"));
                temp.setUye_ad(rs.getString("uye_ad"));
                temp.setUye_soyad(rs.getString("uye_soyad"));
                temp.setUye_cinsiyet(rs.getString("uye_cinsiyet"));
                temp.setUye_yas(rs.getInt("uye_yas"));
                temp.setUye_tel(rs.getString("uye_tel"));
                temp.setUye_mail(rs.getString("uye_mail"));
                temp.setKart_no(rs.getString("uye_kartno"));
                temp.setSifre(rs.getString("sifre"));
                temp.setAlegitim(this.getEgitimdao().getAlinanEgitim(temp.getUye_id()));
                uye_list.add(temp);
            }

        } catch (SQLException ex) {
            System.out.println("UyeDAO HATA(READ):" + ex.getMessage());

        }
        return uye_list;
    }

    public Uye find(int id) {
        Uye uye = null;

        try {
            pst = this.getConnection().prepareStatement("select * from uyeler where uye_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                uye = new Uye();

                uye.setUye_id(rs.getInt("uye_id"));
                uye.setUye_ad(rs.getString("uye_ad"));
                uye.setUye_soyad(rs.getString("uye_soyad"));
                uye.setUye_cinsiyet(rs.getString("uye_cinsiyet"));
                uye.setUye_yas(rs.getInt("uye_yas"));
                uye.setUye_tel(rs.getString("uye_tel"));
                uye.setUye_mail(rs.getString("uye_mail"));
                uye.setKart_no(rs.getString("uye_kartno"));
                uye.setSifre(rs.getString("sifre"));
                uye.setAlegitim(this.getEgitimdao().getAlinanEgitim(uye.getUye_id()));
            }
        } catch (SQLException ex) {
            System.out.println(" UyeDAO HATA(Find): " + ex.getMessage());
        }

        return uye;
    }

    public void update(Uye uye) {
        try {
            pst = this.getConnection().prepareStatement("update uyeler set uye_ad=? , uye_soyad=? , uye_cinsiyet=?,uye_tel=?, uye_yas=? , uye_mail=? ,uye_kartno=?,admin=0,sifre=? where uye_id=?");

            pst.setString(1, uye.getUye_ad());
            pst.setString(2, uye.getUye_soyad());
            pst.setString(3, uye.getUye_cinsiyet());
            pst.setString(4, uye.getUye_tel());
            pst.setInt(5, uye.getUye_yas());
            pst.setString(6, uye.getUye_mail());
            pst.setString(7, uye.getKart_no());
            pst.setString(8, uye.getSifre());
            pst.setInt(9, uye.getUye_id());
            pst.executeUpdate();
            pst.close();

            pst = this.getConnection().prepareStatement("delete from alinan_egitim  where uye_id=?");
            pst.setInt(1, uye.getUye_id());
            pst.executeUpdate();
            pst.close();
            for (Egitim egitim : uye.getAlegitim()) {
                pst = this.getConnection().prepareStatement("insert into alinan_egitim (egitim_id,uye_id) values(?,?)");
                pst.setInt(1, egitim.getEgitim_id());
                pst.setInt(2, uye.getUye_id());
                pst.executeUpdate();

            }

        } catch (SQLException ex) {
            System.out.println(" UyeDAO HATA(Update): " + ex.getMessage());
        }
    }

    public List<Uye> AlinanEgitim(int egitim_id) { // many to many ilişkisi için oluşturulmuş ilişki tablosunun listesi
        List<Uye> list = new ArrayList<>();

        try {
            pst = this.getConnection().prepareStatement("select * from alinan_egitim where egitim_id=?");
            pst.setInt(1, egitim_id);
            rs = pst.executeQuery();

            while (rs.next()) {
                list.add(this.find(rs.getInt("uye_id")));
            }
        } catch (Exception ex) {
            System.out.println("EgitimDAO HATA(Update):" + ex.getMessage());
        }
        return list;
    }

    public int count() {
        int count = 0;

        try {
            pst = this.getConnection().prepareStatement("select count(uye_id) as uye_count from uyeler");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("uye_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public EgitimDAO getEgitimdao() {
        if (this.egitimdao == null) {
            this.egitimdao = new EgitimDAO();
        }
        return egitimdao;
    }

    public void setEgitimdao(EgitimDAO egitimdao) {
        this.egitimdao = egitimdao;
    }

    /* ----------------------------------------------------------------------------------------------------------------------------------------------------- */
    public void Kayitol(Uye uye) {
        try {

            pst = this.getConnection().prepareStatement("insert into uyeler (uye_ad,uye_soyad,uye_cinsiyet,uye_tel,uye_yas,uye_mail,admin,sifre) values (?,?,?,?,?,?,0,?)");
            pst.setString(1, uye.getUye_ad());
            pst.setString(2, uye.getUye_soyad());
            pst.setString(3, uye.getUye_cinsiyet());
            pst.setString(4, uye.getUye_tel());
            pst.setInt(5, uye.getUye_yas());
            pst.setString(6, uye.getUye_mail());
            pst.setString(7, uye.getSifre());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("UyeDAO HATA(Kayitol) : " + ex.getMessage());
        }
    }

    public String mailarama(String deger) { // şifremi unuttum kısmında ki email adresi kontrolü için kullanılıyor
        Uye uye = null;
        String gelenmail;
        try {
            pst = this.getConnection().prepareStatement("select * from uyeler where uye_mail=?");
            pst.setString(1, deger);
            rs = pst.executeQuery();

            while (rs.next()) {
                uye = new Uye();
                uye.setUye_id(rs.getInt("uye_id"));
                uye.setUye_ad(rs.getString("uye_ad"));
                uye.setUye_soyad(rs.getString("uye_soyad"));
                uye.setUye_cinsiyet(rs.getString("uye_cinsiyet"));
                uye.setUye_yas(rs.getInt("uye_yas"));
                uye.setUye_tel(rs.getString("uye_tel"));
                uye.setUye_mail(rs.getString("uye_mail"));
                uye.setKart_no(rs.getString("uye_kartno"));
                uye.setSifre(rs.getString("sifre"));
                uye.setAlegitim(this.getEgitimdao().getAlinanEgitim(uye.getUye_id()));
            }
        } catch (SQLException ex) {
            System.out.println(" UyeDAO HATA(mailarama): " + ex.getMessage());
        }
        gelenmail = uye.getUye_mail();
        return gelenmail;
    }

    public String sifre(String deger) { // girilen telefon numarasına göre şifreyi döndürmek için kullanılıyor
        Uye uye = null;
        String gelensifre;
        try {
            pst = this.getConnection().prepareStatement("select * from uyeler where uye_tel=?");
            pst.setString(1, deger);
            rs = pst.executeQuery();
            while (rs.next()) {
                uye = new Uye();
                uye.setUye_id(rs.getInt("uye_id"));
                uye.setUye_ad(rs.getString("uye_ad"));
                uye.setUye_soyad(rs.getString("uye_soyad"));
                uye.setUye_cinsiyet(rs.getString("uye_cinsiyet"));
                uye.setUye_yas(rs.getInt("uye_yas"));
                uye.setUye_tel(rs.getString("uye_tel"));
                uye.setUye_mail(rs.getString("uye_mail"));
                uye.setKart_no(rs.getString("uye_kartno"));
                uye.setSifre(rs.getString("sifre"));
                uye.setAlegitim(this.getEgitimdao().getAlinanEgitim(uye.getUye_id()));
            }
        } catch (SQLException ex) {
            System.out.println(" UyeDAO HATA(sifre): " + ex.getMessage());
        }
        gelensifre = uye.getSifre();
        return gelensifre;
    }

    public String telarama(String deger) { // şifremi unuttum kısmında telefon numarasını doğrulamak için kullanılıyor
        Uye uye = null;
        String gelentel;
        try {
            pst = this.getConnection().prepareStatement("select * from uyeler where uye_tel=?");
            pst.setString(1, deger);
            rs = pst.executeQuery();
            while (rs.next()) {
                uye = new Uye();
                uye.setUye_id(rs.getInt("uye_id"));
                uye.setUye_ad(rs.getString("uye_ad"));
                uye.setUye_soyad(rs.getString("uye_soyad"));
                uye.setUye_cinsiyet(rs.getString("uye_cinsiyet"));
                uye.setUye_yas(rs.getInt("uye_yas"));
                uye.setUye_tel(rs.getString("uye_tel"));
                uye.setUye_mail(rs.getString("uye_mail"));
                uye.setKart_no(rs.getString("uye_kartno"));
                uye.setSifre(rs.getString("sifre"));
                uye.setAlegitim(this.getEgitimdao().getAlinanEgitim(uye.getUye_id()));
            }
        } catch (SQLException ex) {
            System.out.println(" UyeDAO HATA(telarama): " + ex.getMessage());
        }
        gelentel = uye.getUye_tel();
        return gelentel;
    }

    public void sifremiunuttum(Uye uye) { // yukarıda ki telarama ve mailarama metodlarında gelen değer doğru ise şifreyi gösterecek metod
        if (uye.getUye_mail().equals(mailarama(uye.getUye_mail())) && uye.getUye_tel().equals(telarama(uye.getUye_tel()))) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(" Şifreniz : " + sifre(uye.getUye_tel())));
        }
    }

}
