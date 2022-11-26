package converter;

import dao.UyeDAO;
import entity.Uye;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "uyeConverter")
public class UyeConverter implements Converter {

    private UyeDAO uyedao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getUyedao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object u) {
        Uye uye = (Uye) u;
        return String.valueOf(uye.getUye_id());
    }

    public UyeDAO getUyedao() {
        if (this.uyedao == null) {
            this.uyedao = new UyeDAO();
        }
        return uyedao;
    }

    public void setUyedao(UyeDAO uyedao) {
        this.uyedao = uyedao;
    }

}
