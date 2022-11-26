package dao;

import entity.Egitmen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class EgitmenDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void insert(Egitmen egitmen) {
        try {
            if (egitmen.getEgitmen_email().equals(find(egitmen.getEgitmen_email()))) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bu Eğitmen Bulunmaktadır"));
            } else {
                pst = this.getConnection().prepareStatement("insert into egitmenler (egitmen_ad,egitmen_soyad,egitmen_cinsiyet,egitmen_tel,egitmen_yas,egitmen_mail,egitmen_tecrube,uz_alan) values (?,?,?,?,?,?,?,?)");
                pst.setString(1, egitmen.getEgitmen_ad());
                pst.setString(2, egitmen.getEgitmen_soyad());
                pst.setString(3, egitmen.getEgitmen_cinsiyet());
                pst.setString(4, egitmen.getEgitmen_cep_telefonu());
                pst.setInt(5, egitmen.getEgitmen_yas());
                pst.setString(6, egitmen.getEgitmen_email());
                pst.setString(7, egitmen.getTecrube());
                pst.setString(8, egitmen.getUz_alan());

                pst.executeUpdate();
                pst.close();
            }
        } catch (SQLException ex) {
            System.out.println(" EgitmenDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(Egitmen egitmen) {
        try {
            pst = this.getConnection().prepareStatement("delete from egitmenler where egitmen_id=?");
            pst.setInt(1, egitmen.getEgitmen_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" EgitmenDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public List<Egitmen> findAll(String deger, int page, int pageSize) {  //bu findall metodu tablo'da kullanılıyor
        List<Egitmen> elist = new ArrayList();
        int start = (page - 1) * pageSize;

        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM egitmenler where egitmen_ad like ? or egitmen_soyad like ? or uz_alan like ? order by egitmen_ad asc limit " + start + " , " + pageSize);
            pst.setString(1, "%" + deger + "%"); // ara çubuğuna girilen herhangi bir değeri içeren bütün bilgileri getirmek için "%" + deger + "%" bu şekilde kullandık.
            pst.setString(2, "%" + deger + "%");
            pst.setString(3, "%" + deger + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                Egitmen temp = new Egitmen();
                temp.setEgitmen_id(rs.getInt("egitmen_id"));
                temp.setUz_alan(rs.getString("uz_alan"));
                temp.setTecrube(rs.getString("egitmen_tecrube"));
                temp.setEgitmen_ad(rs.getString("egitmen_ad"));
                temp.setEgitmen_soyad(rs.getString("egitmen_soyad"));
                temp.setEgitmen_cinsiyet(rs.getString("egitmen_cinsiyet"));
                temp.setEgitmen_yas(rs.getInt("egitmen_yas"));
                temp.setEgitmen_cep_telefonu(rs.getString("egitmen_tel"));
                temp.setEgitmen_email(rs.getString("egitmen_mail"));

                elist.add(temp);

            }
            return elist;
        } catch (SQLException ex) {
            System.out.println("EgitmenDAO HATA(FindAll):" + ex.getMessage());
            return null;
        }

    }

    public List<Egitmen> findAll() {  // bu findall metodu one to many ilişkisideki eklemeler de selectmenubox ın içinde kullanılıyor.Sayfalamada çıkan hatayı önlemek için yazıldı.
        List<Egitmen> egitmen_list = new ArrayList();

        try {
            pst = this.getConnection().prepareStatement("SELECT * FROM egitmenler");

            rs = pst.executeQuery();

            while (rs.next()) {
                Egitmen temp = new Egitmen();
                temp.setEgitmen_id(rs.getInt("egitmen_id"));
                temp.setUz_alan(rs.getString("uz_alan"));
                temp.setTecrube(rs.getString("egitmen_tecrube"));
                temp.setEgitmen_ad(rs.getString("egitmen_ad"));
                temp.setEgitmen_soyad(rs.getString("egitmen_soyad"));
                temp.setEgitmen_cinsiyet(rs.getString("egitmen_cinsiyet"));
                temp.setEgitmen_yas(rs.getInt("egitmen_yas"));
                temp.setEgitmen_cep_telefonu(rs.getString("egitmen_tel"));
                temp.setEgitmen_email(rs.getString("egitmen_mail"));

                egitmen_list.add(temp);

            }
            return egitmen_list;
        } catch (SQLException ex) {
            System.out.println("EgitmenDAO HATA(FindAll):" + ex.getMessage());
            return null;
        }

    }

    public Egitmen find(int id) {
        Egitmen egitmen = null;

        try {
            pst = this.getConnection().prepareStatement("select * from egitmenler where egitmen_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            rs.next();

            egitmen = new Egitmen();

            egitmen.setEgitmen_id(rs.getInt("egitmen_id"));
            egitmen.setUz_alan(rs.getString("uz_alan"));
            egitmen.setTecrube(rs.getString("egitmen_tecrube"));
            egitmen.setEgitmen_ad(rs.getString("egitmen_ad"));
            egitmen.setEgitmen_soyad(rs.getString("egitmen_soyad"));
            egitmen.setEgitmen_cinsiyet(rs.getString("egitmen_cinsiyet"));
            egitmen.setEgitmen_yas(rs.getInt("egitmen_yas"));
            egitmen.setEgitmen_cep_telefonu(rs.getString("egitmen_tel"));
            egitmen.setEgitmen_email(rs.getString("egitmen_mail"));

        } catch (SQLException ex) {
            System.out.println(" EgitmenDAO HATA(Find): " + ex.getMessage());
        }

        return egitmen;
    }

    public String find(String mail) {
        Egitmen egitmen = null;
        String gelenmail;

        try {
            pst = this.getConnection().prepareStatement("select * from egitmenler where egitmen_mail=?");
            pst.setString(1, mail);
            rs = pst.executeQuery();

            rs.next();

            egitmen = new Egitmen();

            egitmen.setEgitmen_id(rs.getInt("egitmen_id"));
            egitmen.setUz_alan(rs.getString("uz_alan"));
            egitmen.setTecrube(rs.getString("egitmen_tecrube"));
            egitmen.setEgitmen_ad(rs.getString("egitmen_ad"));
            egitmen.setEgitmen_soyad(rs.getString("egitmen_soyad"));
            egitmen.setEgitmen_cinsiyet(rs.getString("egitmen_cinsiyet"));
            egitmen.setEgitmen_yas(rs.getInt("egitmen_yas"));
            egitmen.setEgitmen_cep_telefonu(rs.getString("egitmen_tel"));
            egitmen.setEgitmen_email(rs.getString("egitmen_mail"));

        } catch (SQLException ex) {
            System.out.println(" EgitmenDAO HATA(Find): " + ex.getMessage());
        }
        gelenmail = egitmen.getEgitmen_email();
        return gelenmail;
    }

    public void update(Egitmen egitmen) {
        try {
            pst = this.getConnection().prepareStatement("update egitmenler set egitmen_ad=? , egitmen_soyad=? , egitmen_cinsiyet=?,egitmen_tel=?, egitmen_yas=? , egitmen_mail=? , egitmen_tecrube=?,uz_alan=? where egitmen_id=?");

            pst.setString(1, egitmen.getEgitmen_ad());
            pst.setString(2, egitmen.getEgitmen_soyad());
            pst.setString(3, egitmen.getEgitmen_cinsiyet());
            pst.setString(4, egitmen.getEgitmen_cep_telefonu());
            pst.setInt(5, egitmen.getEgitmen_yas());
            pst.setString(6, egitmen.getEgitmen_email());
            pst.setString(7, egitmen.getTecrube());
            pst.setString(8, egitmen.getUz_alan());
            pst.setInt(9, egitmen.getEgitmen_id());

            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" EgitmenDAO HATA(Update): " + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count(egitmen_id) as egitmen_count from egitmenler");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("egitmen_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

}
