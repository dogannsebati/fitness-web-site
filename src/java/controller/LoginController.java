package controller;

import dao.YetkiDAO;
import entity.Uye;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class LoginController implements Serializable {

    private YetkiDAO yetkidao;
    private Uye uye;

    public String login() {
        uye = this.getYetkidao().girisYap(this.uye.getUye_mail(), this.uye.getSifre());
        if (this.uye != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.uye);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hoşgeldiniz" + " " + uye.getUye_ad() + " " + uye.getUye_soyad()));
            return "/back_end/egitim/egitim?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı kullanıcı adı veya şifre"));
            return "/index";
        }
    }

    public YetkiDAO getYetkidao() {
        return yetkidao == null ? yetkidao = new YetkiDAO() : yetkidao;
    }

    public Uye getUye() {
        return uye == null ? uye = new Uye() : uye;
    }

    public void setUye(Uye uye) {
        this.uye = uye;
    }

}
