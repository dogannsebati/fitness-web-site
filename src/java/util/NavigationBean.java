package util;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NavigationBean implements Serializable {

    public String page(String p) {
        return "/back_end/" + p + "/" + p + "?faces-redirct=true";
    }

}
