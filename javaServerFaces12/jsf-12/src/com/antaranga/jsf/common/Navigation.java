package com.antaranga.jsf.common;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


public class Navigation {

    /** Hardcoded redirect. Should not be used except in error cases or hardcoded links
     * @param url (must be runtime link like /edit.jsf
     * @param error A link that "always" exists
     */
    public static void redirect(String url, String error) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.dispatch(externalContext.getRequestContextPath() +  url);
        }
        catch (IOException e) {
            try {
                externalContext.dispatch(externalContext.getRequestContextPath() +  error);
            }
            catch (IOException e1) { //should not happen
                ;
            }
        }
    }
    
}
