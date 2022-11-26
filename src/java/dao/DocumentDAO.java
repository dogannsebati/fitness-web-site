/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Document;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentDAO extends SuperDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public void insert(Document d) {
        try {
            pst = this.getConnection().prepareStatement("insert into document(filepath,filename,filetype) values(?,?,?)");
            pst.setString(1, d.getFilePath());
            pst.setString(2, d.getFileName());
            pst.setString(3, d.getFileType());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Document document) {
        String query = "delete from document where document_id=?";

        try {
            pst = getConnection().prepareStatement(query);
            pst.setInt(1, document.getDocument_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Document> findAll(String deger, int page, int pageSize) { //bu findall metodu tablo'da kullanılıyor
        List<Document> dList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select*from document where filename like ? or filetype like ? order by document_id asc limit " + start + " , " + pageSize);
            pst.setString(1, "%" + deger + "%");  // ara çubuğuna girilen herhangi bir değeri içeren bütün bilgileri getirmek için "%" + deger + "%" bu şekilde kullandık.
            pst.setString(2, "%" + deger + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                Document d = new Document();
                d.setDocument_id(rs.getInt("document_id"));
                d.setFilePath(rs.getString("filepath"));
                d.setFileName(rs.getString("filename"));
                d.setFileType(rs.getString("filetype"));
                dList.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dList;
    }

    public List<Document> findAll() { // bu findall metodu one to many ilişkisideki eklemeler de selectmenubox ın içinde kullanılıyor.Sayfalamada çıkan hatayı önlemek için yazıldı.
        List<Document> dList = new ArrayList<>();

        try {
            pst = this.getConnection().prepareStatement("select*from document ");

            rs = pst.executeQuery();
            while (rs.next()) {
                Document d = new Document();
                d.setDocument_id(rs.getInt("document_id"));
                d.setFilePath(rs.getString("filepath"));
                d.setFileName(rs.getString("filename"));
                d.setFileType(rs.getString("filetype"));
                dList.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dList;
    }

    public Document find(int id) {
        Document document = null;

        try {
            pst = getConnection().prepareStatement("select * from document where document_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();

            document = new Document();
            document.setDocument_id(rs.getInt("document_id"));
            document.setFilePath(rs.getString("filepath"));
            document.setFileName(rs.getString("filename"));
            document.setFileType(rs.getString("filetype"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return document;

    }

    public int count() {
        int count = 0;

        try {
            pst = this.getConnection().prepareStatement("select count(document_id) as document_count from document");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("document_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

}
