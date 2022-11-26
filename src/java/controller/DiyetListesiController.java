package controller;

import dao.DiyetListesiDAO;
import entity.DiyetListesi;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class DiyetListesiController implements Serializable {

    private List<DiyetListesi> diyet_list;
    private DiyetListesiDAO diyet_dao;
    private DiyetListesi diyetListesi;
    private String bul = "";
    @Inject
    private EgitimController egitimController;
    @Inject
    private UyeController uyeController;

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
        this.pageCount = (int) Math.ceil(this.getDiyet_dao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void updateForm(DiyetListesi diyetListesi) {
        this.diyetListesi = diyetListesi;
    }

    public void clearForm() {
        this.diyetListesi = new DiyetListesi();
    }

    public void create() {
        this.getDiyet_dao().insert(this.diyetListesi);
        this.clearForm();
    }

    public void delete() {
        this.getDiyet_dao().delete(this.diyetListesi);
        this.clearForm();
    }

    public void update() {
        this.getDiyet_dao().update(this.diyetListesi);
        this.clearForm();
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public List<DiyetListesi> getDiyet_list() {
        this.diyet_list = this.getDiyet_dao().findAll(this.bul, page, pageSize);
        return diyet_list;
    }

    public void setDiyet_list(List<DiyetListesi> diyet_list) {
        this.diyet_list = diyet_list;
    }

    public DiyetListesiDAO getDiyet_dao() {
        if (this.diyet_dao == null) {
            this.diyet_dao = new DiyetListesiDAO();

        }
        return diyet_dao;
    }

    public void setDiyet_dao(DiyetListesiDAO diyet_dao) {
        this.diyet_dao = diyet_dao;
    }

    public DiyetListesi getDiyetListesi() {
        if (this.diyetListesi == null) {
            this.diyetListesi = new DiyetListesi();

        }
        return diyetListesi;
    }

    public void setDiyetListesi(DiyetListesi diyetListesi) {
        this.diyetListesi = diyetListesi;
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

    public UyeController getUyeController() {
        if (this.uyeController == null) {
            this.uyeController = new UyeController();
        }
        return uyeController;
    }

    public void setUyeController(UyeController uyeController) {
        this.uyeController = uyeController;
    }

}
