package demo;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@ConversationScoped
@Named("detailsBean")
public class Details implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer item = 1;
	
	@Inject
	private Conversation conversation;

	//***********************  LIFECYCLE

	public Details(){

	}
	
	@PostConstruct
	public void initBean() throws Exception {
		final String selectedItem = getRequestParameter("item");
		this.item = Integer.parseInt(selectedItem);
	}
	
	@PreDestroy
	public void removeBean() {
		System.out.print("Removed from context");
	}
	
	/**
	 * Retrieve request query string
	 * @param parameterName
	 * @return
	 */
	public static String getRequestParameter(String parameterName) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(parameterName);
	}
	
	@Produces @Named("selectedItem")
	public String selectedItem(){
		return this.item.toString();
	}
	
	@Produces @Named("quitUrl")
	public String quit() {
	    if(!conversation.isTransient()){
	      conversation.end();
	    }
	    return "common?faces-redirect=true";
	}	
	
	
}
