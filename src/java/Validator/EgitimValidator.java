package Validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("egitimvalidator")
@SessionScoped
public class EgitimValidator implements Serializable {

    private Collection<FacesMessage> msgList = new ArrayList<>();

    public boolean validateAd(FacesContext fc, UIComponent uı, Object v) {

        boolean isValid = true;
        msgList.clear();

        String value = (String) v;
        if (value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Eğitim Adını Giriniz ! "));
            isValid = false;
        } else if (value.length() < 3 || value.length() > 50) {
            msgList.add(new FacesMessage("Eğitim Adı 3'den Küçük 50 den Büyük Olamaz!"));
            isValid = false;
        }

        if (!isValid) {
            throw new ValidatorException(msgList);
        } else {
            return true;
        }

    }

    public boolean validateİcerik(FacesContext fc, UIComponent uı, Object v) {

        boolean isValid = true;
        msgList.clear();

        String value = (String) v;
        if (value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Eğitimin İçeriğini Giriniz  ! "));
            isValid = false;
        } else if (value.length() < 10) {
            msgList.add(new FacesMessage("Eğitim İçeriği 10 Kelimeden Fazla Giriniz!"));
            isValid = false;
        }

        if (!isValid) {
            throw new ValidatorException(msgList);
        } else {
            return true;
        }

    }

    public boolean validateUcret(FacesContext fc, UIComponent uı, Object v) {
        boolean isValid = true;
        msgList.clear();

        String value = (String) v;

        if (value == null || value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Ücret Giriniz!"));
            isValid = false;
        }
        if (!isValid) {
            throw new ValidatorException(msgList);

        } else {
            return true;
        }
    }

    public Collection<FacesMessage> getMsgList() {
        return msgList;
    }

    public void setMsgList(Collection<FacesMessage> msgList) {
        this.msgList = msgList;
    }

}
