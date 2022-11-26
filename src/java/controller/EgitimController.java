package controller;

import dao.DocumentDAO;
import dao.EgitimDAO;
import entity.Document;
import entity.Egitim;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class EgitimController implements Serializable {

    private List<Egitim> egitim_list;
    private List<Document> documentlist;
    private EgitimDAO egitim_dao;
    private DocumentDAO documendao;
    private Egitim egitim;
    private String bul = "";
    private List<Egitim> full_list;

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
        this.pageCount = (int) Math.ceil(this.getEgitim_dao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Inject
    private EgitmenController egitmenController;
    @Inject
    private DocumentController documentController;

    public DocumentController getDocumentController() {
        return documentController;
    }

    public void setDocumentController(DocumentController documentController) {
        this.documentController = documentController;
    }

    public EgitmenController getEgitmenController() {
        return egitmenController;
    }

    public void setEgitmenController(EgitmenController egitmenController) {
        this.egitmenController = egitmenController;
    }

    public void updateForm(Egitim egitim) {
        this.egitim = egitim;
    }

    public void clearForm() {
        this.egitim = new Egitim();
    }

    public void create() {
        this.getEgitim_dao().insert(this.egitim);
        this.clearForm();
    }

    public void delete() {
        this.getEgitim_dao().delete(this.egitim);
        this.clearForm();
    }

    public void update() {
        this.getEgitim_dao().update(this.egitim);
        this.clearForm();
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public List<Egitim> getFull_list() {
        this.full_list = this.getEgitim_dao().findAll();
        return full_list;
    }

    public void setFull_list(List<Egitim> full_list) {
        this.full_list = full_list;
    }

    public List<Document> getDocumentlist() {
        this.documentlist = this.getDocumendao().findAll(this.bul, page, pageSize);
        return documentlist;
    }

    public void setDocumentlist(List<Document> documentlist) {
        this.documentlist = documentlist;
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

    public List<Egitim> getEgitim_list() {
        this.egitim_list = this.getEgitim_dao().findAll(this.bul, page, pageSize);
        return egitim_list;
    }

    public List<Egitim> getElist() {
        this.egitim_list = getEgitim_dao().findAll();
        return egitim_list;
    }

    public void setEgitim_list(List<Egitim> egitim_list) {
        this.egitim_list = egitim_list;
    }

    public EgitimDAO getEgitim_dao() {
        if (this.egitim_dao == null) {
            this.egitim_dao = new EgitimDAO();
        }
        return egitim_dao;
    }

    public void setEgitim_dao(EgitimDAO egitim_dao) {
        this.egitim_dao = egitim_dao;
    }

    public Egitim getEgitim() {
        if (this.egitim == null) {
            this.egitim = new Egitim();
        }
        return egitim;
    }

    public void setEgitim(Egitim egitim) {
        this.egitim = egitim;
    }

}
