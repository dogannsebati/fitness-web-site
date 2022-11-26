package dao;

import entity.Uye;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class YetkiDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public Uye girisYap(String mail, String sifre) {
        Uye temp = null;
        try {
            pst = this.getConnection().prepareStatement("select * from uyeler where uye_mail = ? and sifre = ?");
            pst.setString(1, mail);
            pst.setString(2, sifre);
            rs = pst.executeQuery();

            while (rs.next()) {
                temp = new Uye();
                temp.setUye_id(rs.getInt("uye_id"));
                temp.setUye_ad(rs.getString("uye_ad"));
                temp.setUye_soyad(rs.getString("uye_soyad"));
                temp.setUye_cinsiyet(rs.getString("uye_cinsiyet"));
                temp.setUye_tel(rs.getString("uye_tel"));
                temp.setUye_yas(rs.getInt("uye_yas"));
                temp.setUye_mail(rs.getString("uye_mail"));
                temp.setAdmin(rs.getBoolean("admin"));
                temp.setSifre(rs.getString("sifre"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

}
