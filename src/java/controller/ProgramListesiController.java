package controller;

import dao.ProgramListesiDAO;
import entity.ProgramListesi;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ProgramListesiController implements Serializable {

    private List<ProgramListesi> plist;
    private ProgramListesiDAO pdao;
    private ProgramListesi programListesi;

    @Inject
    private EgitimController egitimController;

    @Inject
    private UyeController uyeController;

    private String bul = "";
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
        this.pageCount = (int) Math.ceil(this.getPdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void updateForm(ProgramListesi programListesi) {
        this.programListesi = programListesi;
    }

    public void clearForm() {
        this.programListesi = new ProgramListesi();
    }

    public void create() {
        this.getPdao().insert(this.programListesi);
        this.clearForm();
    }

    public void delete() {
        this.getPdao().delete(this.programListesi);
        this.clearForm();
    }

    public void update() {
        this.getPdao().update(this.programListesi);
        this.clearForm();
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public List<ProgramListesi> getPlist() {
        this.plist = this.getPdao().findAll(this.bul, page, pageSize);
        return plist;
    }

    public void setPlist(List<ProgramListesi> plist) {
        this.plist = plist;
    }

    public ProgramListesiDAO getPdao() {
        if (this.pdao == null) {
            this.pdao = new ProgramListesiDAO();
        }
        return pdao;
    }

    public void setPdao(ProgramListesiDAO pdao) {
        this.pdao = pdao;
    }

    public ProgramListesi getProgramListesi() {
        if (this.programListesi == null) {
            this.programListesi = new ProgramListesi();
        }
        return programListesi;
    }

    public void setProgramListesi(ProgramListesi programListesi) {
        this.programListesi = programListesi;
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
