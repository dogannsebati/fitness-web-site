package controller;

import dao.OlcumDAO;
import entity.Olcum;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class OlcumController implements Serializable {

    private List<Olcum> olcum_list;
    private OlcumDAO olcum_dao;
    private Olcum olcum;

    private int page = 1;
    private int pageSize = 6;
    private int pageCount;

    public void ileri() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
        this.clearForm();
    }

    public void geri() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
        this.clearForm();
    }

    public void create() {
        this.olcum.setVucut_kitle_indeksi(vkihesap());
        this.getOlcum_dao().insert(this.olcum);
        this.clearForm();
    }

    public void delete() {
        this.getOlcum_dao().delete(this.olcum);
        this.clearForm();
    }

    public double vkihesap() {
        return this.olcum.getKilo() / Math.pow(this.olcum.getBoy(), 2) * 10000; // üyeler değerlerini girdiği an vki hesabı yapması için kullanılan metod
    }

    public void update() {
        this.olcum.setVucut_kitle_indeksi(vkihesap());
        this.getOlcum_dao().update(this.olcum);
        this.clearForm();
    }

    public List<Olcum> getOlcum_list() {
        this.olcum_list = this.getOlcum_dao().findAll(page, pageSize);
        return olcum_list;
    }

    public void setOlcum_list(List<Olcum> olcum_list) {
        this.olcum_list = olcum_list;
    }

    public OlcumDAO getOlcum_dao() {
        if (this.olcum_dao == null) {
            this.olcum_dao = new OlcumDAO();
        }
        return olcum_dao;
    }

    public void setOlcum_dao(OlcumDAO olcum_dao) {
        this.olcum_dao = olcum_dao;
    }

    public Olcum getOlcum() {
        if (this.olcum == null) {
            this.olcum = new Olcum();
        }
        return olcum;
    }

    public void setOlcum(Olcum olcum) {
        this.olcum = olcum;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getOlcum_dao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void updateForm(Olcum olcum) {
        this.olcum = olcum;
    }

    public void clearForm() {
        this.olcum = new Olcum();
    }

}
