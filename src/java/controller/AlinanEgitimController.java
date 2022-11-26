package controller;

import dao.AlinanEgitimDAO;
import entity.AlinanEgitim;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class AlinanEgitimController implements Serializable {

    private List<AlinanEgitim> alinan_list;
    private AlinanEgitimDAO alinandao;
    private AlinanEgitim alinanEgitim;

    @Inject
    private UyeController uyeController;
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
        this.pageCount = (int) Math.ceil(this.getAlinandao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void updateForm(AlinanEgitim alinanEgitim) {
        this.alinanEgitim = alinanEgitim;
    }

    public void clearForm() {
        this.alinanEgitim = new AlinanEgitim();
    }

    public void create() {
        this.getAlinandao().insert(this.alinanEgitim);
        this.clearForm();
    }

    public void delete() {
        this.getAlinandao().delete(this.alinanEgitim);
        this.clearForm();
    }

    public void update() {
        this.getAlinandao().update(this.alinanEgitim);
        this.clearForm();
    }

    public List<AlinanEgitim> getAlinan_list() {
        this.alinan_list = this.getAlinandao().findAll();
        return alinan_list;
    }

    public void setAlinan_list(List<AlinanEgitim> alinan_list) {
        this.alinan_list = alinan_list;
    }

    public AlinanEgitimDAO getAlinandao() {
        if (this.alinandao == null) {
            this.alinandao = new AlinanEgitimDAO();

        }
        return alinandao;
    }

    public void setAlinandao(AlinanEgitimDAO alinandao) {
        this.alinandao = alinandao;
    }

    public AlinanEgitim getAlinanEgitim() {
        if (this.alinanEgitim == null) {
            this.alinanEgitim = new AlinanEgitim();

        }
        return alinanEgitim;
    }

    public void setAlinanEgitim(AlinanEgitim alinanEgitim) {
        this.alinanEgitim = alinanEgitim;
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

    public EgitimController getEgitimController() {
        if (this.egitimController == null) {
            this.egitimController = new EgitimController();

        }
        return egitimController;
    }

    public void setEgitimController(EgitimController egitimController) {
        this.egitimController = egitimController;
    }

}
