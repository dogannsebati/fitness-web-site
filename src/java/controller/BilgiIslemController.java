package controller;

import dao.BilgiIslemDAO;
import entity.BilgiIslem;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class BilgiIslemController implements Serializable {

    private List<BilgiIslem> bilgi_list;
    private BilgiIslemDAO bilgidao;
    private BilgiIslem bilgi;

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
        this.pageCount = (int) Math.ceil(this.getBilgidao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void updateForm(BilgiIslem islem_bilgi) {
        this.bilgi = islem_bilgi;
        System.out.println(this.bilgi.getUye().toString());
    }

    public void clearForm() {
        this.bilgi = new BilgiIslem();
    }

    public void create() {
        this.getBilgidao().insert(this.bilgi);
        this.clearForm();
    }

    public void update() {
        this.getBilgidao().update(this.bilgi);
        this.clearForm();
    }

    public void delete() {
        this.getBilgidao().delete(this.bilgi);
        this.clearForm();
    }

    public List<BilgiIslem> getBilgi_list() {
        this.bilgi_list = this.getBilgidao().findAll(page, pageSize);
        return bilgi_list;
    }

    public void setBilgi_list(List<BilgiIslem> bilgi_list) {
        this.bilgi_list = bilgi_list;
    }

    public BilgiIslemDAO getBilgidao() {
        if (this.bilgidao == null) {
            this.bilgidao = new BilgiIslemDAO();
        }
        return bilgidao;
    }

    public void setBilgidao(BilgiIslemDAO bilgidao) {
        this.bilgidao = bilgidao;
    }

    public BilgiIslem getBilgi() {
        if (this.bilgi == null) {
            this.bilgi = new BilgiIslem();
        }
        return bilgi;
    }

    public void setBilgi(BilgiIslem bilgi) {
        this.bilgi = bilgi;
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
