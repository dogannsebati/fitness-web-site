package controller;

import dao.EgitmenDAO;
import entity.Egitmen;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class EgitmenController implements Serializable {

    private List<Egitmen> egitmenlist;
    private List<Egitmen> full_list;
    private EgitmenDAO egitmendao;

    private Egitmen egitmen;
    private String bul = "";

    @Inject
    private EgitimController egitimController;

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
        this.pageCount = (int) Math.ceil(this.getEgitmendao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void updateForm(Egitmen egitmen) {
        this.egitmen = egitmen;
    }

    public void clearForm() {
        this.egitmen = new Egitmen();
    }

    public void create() {
        this.getEgitmendao().insert(this.egitmen);
        this.clearForm();
    }

    public void delete() {
        this.getEgitmendao().delete(this.egitmen);
        this.clearForm();
    }

    public void update() {
        this.getEgitmendao().update(this.egitmen);
        this.clearForm();
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public List<Egitmen> getFull_list() {
        this.full_list = this.getEgitmendao().findAll();
        return full_list;
    }

    public void setFull_list(List<Egitmen> full_list) {
        this.full_list = full_list;
    }

    public List<Egitmen> getEgitmenlist() {
        this.egitmenlist = this.getEgitmendao().findAll(this.bul, page, pageSize);
        return egitmenlist;
    }

    public void setEgitmenlist(List<Egitmen> egitmenlist) {
        this.egitmenlist = egitmenlist;
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

    public Egitmen getEgitmen() {
        if (this.egitmen == null) {
            this.egitmen = new Egitmen();
        }
        return egitmen;
    }

    public void setEgitmen(Egitmen egitmen) {
        this.egitmen = egitmen;
    }

    public EgitimController getEgitimController() {
        if (this.egitimController == null) {
            this.egitimController = new EgitimController();

        }
        return egitimController;
    }

    public void setEgitimController(EgitimController egitimController) {
        this.egitimController = egitimController;
    }

    @Override
    public String toString() {
        return "EgitmenController{" + "egitmenlist=" + egitmenlist + ", egitmendao=" + egitmendao + ", egitmen=" + egitmen + '}';
    }
}
