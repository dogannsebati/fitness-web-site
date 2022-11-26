package dao;

import entity.ProgramListesi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramListesiDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    EgitimDAO egitimdao;
    UyeDAO uyedao;

    public void insert(ProgramListesi programListesi) {

        try {
            pst = this.getConnection().prepareStatement("insert into program_listesi (hareket_adi,tekrar_sayisi,hareket_bolgesi,egitim_id) values(?,?,?,?)");
            pst.setString(1, programListesi.getHareket_adi());
            pst.setString(2, programListesi.getTekrar_sayisi());
            pst.setString(3, programListesi.getHareket_bolgesi());
            pst.setInt(4, programListesi.getEgitim().getEgitim_id());

            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println(" ProgramListesiDAO HATA(Create): " + ex.getMessage());
        }
    }

    public void delete(ProgramListesi programListesi) {

        try {
            pst = this.getConnection().prepareStatement("delete from program_listesi where por_liste_id=?");
            pst.setInt(1, programListesi.getProgram_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" ProgramListesiDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public List<ProgramListesi> findAll(String deger, int page, int pageSize) {
        List<ProgramListesi> programListesi = new ArrayList();
        int start = (page - 1) * pageSize;

        try {
            pst = this.getConnection().prepareStatement("select * from program_listesi where  hareket_adi like ? order by por_liste_id asc limit " + start + " , " + pageSize);
            pst.setString(1, "%" + deger + "%"); // ara çubuğuna girilen herhangi bir değeri içeren bütün bilgileri getirmek için "%" + deger + "%" bu şekilde kullandık.

            rs = pst.executeQuery();
            while (rs.next()) {
                ProgramListesi temp = new ProgramListesi();
                temp.setProgram_id(rs.getInt("por_liste_id"));
                temp.setHareket_adi(rs.getString("hareket_adi"));
                temp.setTekrar_sayisi(rs.getString("tekrar_sayisi"));
                temp.setHareket_bolgesi(rs.getString("hareket_bolgesi"));
                temp.setEgitim(this.getEgitimdao().find(rs.getInt("egitim_id")));
                programListesi.add(temp);
            }

            return programListesi;
        } catch (SQLException ex) {
            System.out.println(" ProgramListesiDAO HATA(FindAll): " + ex.getMessage());
            return null;
        }
    }

    public ProgramListesi find(int id) {
        ProgramListesi programListesi = null;

        try {
            pst = this.getConnection().prepareStatement("select * from program_listesi where por_liste_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            rs.next();
            programListesi = new ProgramListesi();
            programListesi.setProgram_id(rs.getInt("por_liste_id"));
            programListesi.setHareket_adi(rs.getString("hareket_adi"));
            programListesi.setTekrar_sayisi(rs.getString("tekrar_sayisi"));
            programListesi.setHareket_bolgesi(rs.getString("hareket_bolgesi"));
            programListesi.setEgitim(this.getEgitimdao().find(rs.getInt("egitim_id")));

        } catch (SQLException ex) {
            System.out.println(" ProgramListesiDAO HATA(Find): " + ex.getMessage());
        }
        return programListesi;
    }

    public void update(ProgramListesi programListesi) {

        try {
            pst = this.getConnection().prepareStatement("update program_listesi set hareket_adi=?,tekrar_sayisi=?,hareket_bolgesi=?,egitim_id=? where por_liste_id=?");

            pst.setString(1, programListesi.getHareket_adi());
            pst.setString(2, programListesi.getTekrar_sayisi());
            pst.setString(3, programListesi.getHareket_bolgesi());
            pst.setInt(4, programListesi.getEgitim().getEgitim_id());

            pst.setInt(5, programListesi.getProgram_id());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("ProgramListesiDAO HATA(Update): " + ex.getMessage());
        }
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

    public int count() {
        int count = 0;

        try {
            pst = this.getConnection().prepareStatement("select count(por_liste_id) as por_count from program_listesi");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("por_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
