package dao;

import entity.Egitim;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EgitimDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    EgitmenDAO egitmendao;
    DocumentDAO documendao;

    public void insert(Egitim egitim) {
        try {
            pst = this.getConnection().prepareStatement("insert into egitimler (egitim_icerik,egitim_adi,egitim_ucret,egitmen_id,document_id) values(?,?,?,?,?) ");

            pst.setString(1, egitim.getEgitim_icerik());
            pst.setString(2, egitim.getEgitim_adi());
            pst.setString(3, egitim.getEgitim_ucret());
            pst.setInt(4, egitim.getEgitmen().getEgitmen_id());
            pst.setInt(5, egitim.getDocument().getDocument_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("EgitimDAO HATA(Create) : " + ex.getMessage());
        }
    }

    public void delete(Egitim egitim) {

        try {
            pst = this.getConnection().prepareStatement("delete from egitimler where egitim_id=?");
            pst.setInt(1, egitim.getEgitim_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" EgitimDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public List<Egitim> findAll(String deger, int page, int pageSize) {  //bu findall metodu tablo'da kullanılıyor
        List<Egitim> egitimlist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from egitimler where egitim_adi like ? order by egitim_adi asc limit " + start + " , " + pageSize);
            pst.setString(1, "%" + deger + "%"); // ara çubuğuna girilen herhangi bir değeri içeren bütün bilgileri getirmek için "%" + deger + "%" bu şekilde kullandık.

            rs = pst.executeQuery();
            while (rs.next()) {
                Egitim temp = new Egitim();
                temp.setEgitim_id(rs.getInt("egitim_id"));
                temp.setEgitim_icerik(rs.getString("egitim_icerik"));
                temp.setEgitim_adi(rs.getString("egitim_adi"));
                temp.setEgitim_ucret(rs.getString("egitim_ucret"));
                temp.setEgitmen(this.getEgitmendao().find(rs.getInt("egitmen_id")));
                temp.setDocument(this.getDocumendao().find(rs.getInt("document_id")));
                egitimlist.add(temp);
            }

            return egitimlist;
        } catch (SQLException ex) {
            System.out.println("EgitimDAO HATA(FindAll):" + ex.getMessage());
            return null;
        }

    }

    public List<Egitim> getAlinanEgitim(int uye_id) {
        List<Egitim> egitimalinan = new ArrayList<>();

        try {
            PreparedStatement pst1 = this.getConnection().prepareStatement("select * from alinan_egitim where uye_id=?");
            pst1.setInt(1, uye_id);
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {
                egitimalinan.add(this.find(rs1.getInt("egitim_id")));

            }

        } catch (Exception ex) {
            System.out.println("EgitimDAO HATA(Update):" + ex.getMessage());
        }

        return egitimalinan;
    }

    public Egitim find(int id) {
        Egitim egitim = null;
        try {
            pst = this.getConnection().prepareStatement("select * from egitimler where egitim_id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                egitim = new Egitim();
                egitim.setEgitim_id(rs.getInt("egitim_id"));
                egitim.setEgitim_icerik(rs.getString("egitim_icerik"));
                egitim.setEgitim_adi(rs.getString("egitim_adi"));
                egitim.setEgitim_ucret(rs.getString("egitim_ucret"));
                egitim.setEgitmen(this.getEgitmendao().find(rs.getInt("egitmen_id")));
                egitim.setDocument(this.getDocumendao().find(rs.getInt("document_id")));
            }
        } catch (SQLException ex) {

            System.out.println("EgitimDAO HATA(Find):" + ex.getMessage());;
        }
        return egitim;
    }

    public void update(Egitim egitim) {
        try {
            pst = this.getConnection().prepareStatement("update egitimler set egitim_icerik=? , egitim_adi=? , egitim_ucret=? , egitmen_id=? , document_id=? where egitim_id=?");

            pst.setString(1, egitim.getEgitim_icerik());
            pst.setString(2, egitim.getEgitim_adi());
            pst.setString(3, egitim.getEgitim_ucret());
            pst.setInt(4, egitim.getEgitmen().getEgitmen_id());
            pst.setInt(5, egitim.getDocument().getDocument_id());
            pst.setInt(6, egitim.getEgitim_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("EgitimDAO HATA(Update):" + ex.getMessage());
        }
    }

    public List<Egitim> findAll() { // bu findall metodu one to many ilişkisideki eklemeler de selectmenubox ın içinde kullanılıyor.Sayfalamada çıkan hatayı önlemek için yazıldı.
        List<Egitim> Elist = new ArrayList<>();

        try {
            pst = this.getConnection().prepareStatement("select * from egitimler");
            rs = pst.executeQuery();

            while (rs.next()) {
                Egitim temp = new Egitim();

                temp.setEgitim_id(rs.getInt("egitim_id"));
                temp.setEgitim_icerik(rs.getString("egitim_icerik"));
                temp.setEgitim_adi(rs.getString("egitim_adi"));
                temp.setEgitim_ucret(rs.getString("egitim_ucret"));
                temp.setEgitmen(this.getEgitmendao().find(rs.getInt("egitmen_id")));
                temp.setDocument(this.getDocumendao().find(rs.getInt("document_id")));

                Elist.add(temp);
            }
        } catch (SQLException ex) {

            System.out.println("EgitimDAO HATA(FİNDALL):" + ex.getMessage());
        }
        return Elist;
    }

    public EgitmenDAO getEgitmendao() {
        if (this.egitmendao == null) {
            this.egitmendao = new EgitmenDAO();
        }
        return egitmendao;
    }

    public void setEgitmendao(EgitmenDAO egitmendao) {
        this.egitmendao = egitmendao;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count(egitim_id) as egitim_count from egitimler");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("egitim_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public List<Egitim> find(int page, int pageSize) {
        List<Egitim> egitimlist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from egitimler order by egitim_id asc limit " + start + " , " + pageSize);
            rs = pst.executeQuery();
            while (rs.next()) {
                Egitim temp = new Egitim();
                temp.setEgitim_id(rs.getInt("egitim_id"));
                temp.setEgitim_icerik(rs.getString("egitim_icerik"));
                temp.setEgitim_adi(rs.getString("egitim_adi"));
                temp.setEgitim_ucret(rs.getString("egitim_ucret"));
                temp.setEgitmen(this.getEgitmendao().find(rs.getInt("egitmen_id")));
                temp.setDocument(this.getDocumendao().find(rs.getInt("document_id")));
                egitimlist.add(temp);
            }
            return egitimlist;
        } catch (SQLException ex) {
            System.out.println("EgitimDAO HATA(FindAll):" + ex.getMessage());
            return null;
        }
    }

    public DocumentDAO getDocumendao() {
        if (this.documendao == null) {
            this.documendao = new DocumentDAO();
        }
        return documendao;
    }

    public void setDocumendao(DocumentDAO documendao) {
        this.documendao = documendao;
    }

}
