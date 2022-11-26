package converter;

import dao.EgitmenDAO;
import entity.Egitmen;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "egitmenConverter")
public class egitmenConverter implements Converter {

    private EgitmenDAO egitmendao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getEgitmendao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Egitmen egitmen = (Egitmen) o;
        return String.valueOf(egitmen.getEgitmen_id());
    }

    public EgitmenDAO getEgitmendao() {
        if (this.egitmendao == null) {
            this.egitmendao = new EgitmenDAO();
        }
        return egitmendao;
    }

}
