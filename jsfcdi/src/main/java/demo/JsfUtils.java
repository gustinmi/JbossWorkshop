package demo;

import java.io.IOException;
import java.util.Map;

import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class JsfUtils {

	/** JSF navigation by code 
	 * @param viewId
	 * @param params
	 */
	public static void navigate(String viewId, String params){
        FacesContext fc = FacesContext.getCurrentInstance();
        NavigationHandler nav = fc.getApplication().getNavigationHandler();
        try {
        	nav.handleNavigation(fc, null, viewId);
        	fc.renderResponse();
        } catch (Exception e) {
            fc.getExternalContext().log(String.format(".navigate for: ", viewId ), e);
        }       
	}
	
	//========================
	// ExternalContext  == ServletContext for JSF apps
	//

	/**
	 * invoking hard redirect (client side)
	 * @param url
	 */
	public static void hardRedirect(String url) {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String encUrl = ec.encodeActionURL(url);
		try { ec.redirect(encUrl); } catch (IOException e) { }	
	}	
	
	 /** invoking dispatch (server side redirect)
     * @return
     */
    public static String invokeRedirect(String localUrl) {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String encodeRedirectURL = extContext.encodeRedirectURL(localUrl, null);
        try {
			extContext.dispatch(encodeRedirectURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;

    }

	
	
}
