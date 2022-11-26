package dao;

import entity.BilgiIslem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BilgiIslemDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    UyeDAO uyedao;

    public void insert(BilgiIslem bilgi) {
        try {
            pst = this.getConnection().prepareStatement("insert into bilgi_islem (baslangic_tarih,bitis_tarih,uye_id) values(?,?,?)");
            pst.setString(1, bilgi.getBaslangic_tarihi());
            pst.setString(2, bilgi.getBitis_tarihi());
            pst.setInt(3, bilgi.getUye().getUye_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("BilgiIslemDAO HATA(Create) : " + ex.getMessage());
        }
    }

    public void delete(BilgiIslem bilgi) {
        try {
            pst = this.getConnection().prepareStatement("delete from bilgi_islem where bilgi_id=?");
            pst.setInt(1, bilgi.getBilgi_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" BilgiIslemDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public List<BilgiIslem> findAll(int page, int pageSize) {
        List<BilgiIslem> bilgilist = new ArrayList();
        int start = (page - 1) * pageSize;

        try {
            pst = this.getConnection().prepareStatement("select* from bilgi_islem order by bilgi_id asc limit " + start + " , " + pageSize);
            rs = pst.executeQuery();

            while (rs.next()) {
                BilgiIslem temp = new BilgiIslem();

                temp.setBilgi_id(rs.getInt("bilgi_id"));
                temp.setBaslangic_tarihi(rs.getString("baslangic_tarih"));
                temp.setBitis_tarihi(rs.getString("bitis_tarih"));
                temp.setUye(this.getUyedao().find(rs.getInt("uye_id")));

                bilgilist.add(temp);
            }
            return bilgilist;
        } catch (SQLException ex) {
            System.out.println("BilgiIslemDAO HATA(FindAll):" + ex.getMessage());
            return null;
        }
    }

    public BilgiIslem find(int id) {
        BilgiIslem bilgi = null;
        try {
            pst = this.getConnection().prepareStatement("select * from bilgi_islem where bilgi_id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            rs.next();
            bilgi = new BilgiIslem();
            bilgi.setBilgi_id(rs.getInt("bilgi_id"));
            bilgi.setBaslangic_tarihi(rs.getString("baslangic_tarih"));
            bilgi.setBitis_tarihi(rs.getString("bitis_tarih"));
            bilgi.setUye(this.getUyedao().find(rs.getInt("uye_id")));

        } catch (SQLException ex) {
            System.out.println("BilgiIslemDAO HATA(Find):" + ex.getMessage());
        }
        return bilgi;
    }

    public void update(BilgiIslem bilgi) {
        try {
            pst = this.getConnection().prepareStatement("update bilgi_islem set baslangic_tarih=?,bitis_tarih=?,uye_id=? where bilgi_id=?");
            pst.setString(1, bilgi.getBaslangic_tarihi());
            pst.setString(2, bilgi.getBitis_tarihi());
            pst.setInt(3, bilgi.getUye().getUye_id());

            pst.setInt(4, bilgi.getBilgi_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("BilgiIslemDAO HATA(Update):" + ex.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            pst = this.getConnection().prepareStatement("select count(bilgi_id) as bilgi_count from bilgi_islem");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("bilgi_count");
        } catch (SQLException ex) {
            System.out.println("BilgiIslemDAO HATA(Count):" + ex.getMessage());
        }
        return count;
    }

    public UyeDAO getUyedao() {
        if (this.uyedao == null) {
            this.uyedao = new UyeDAO();

        }
        return uyedao;
    }

    public void setUyedao(UyeDAO uyedao) {
        this.uyedao = uyedao;
    }

}
