package demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named("CommonCtrl")
@ConversationScoped
public class Common implements Serializable {
	
	private static final long serialVersionUID = -2226229110204488886L;
	private List<TableItem> tbl = new ArrayList<TableItem>();
	private @Inject Config config;
	@Inject private Conversation conversation;
	
	public Common() {
		tbl.add(new TableItem(1, "janez"));
		tbl.add(new TableItem(2, "ivan"));
		tbl.add(new TableItem(3, "janša"));
	}
	
	@PostConstruct
	public void initBean() throws Exception {
		System.out.print("Removed from context");

		if (!FacesContext.getCurrentInstance().isPostback() && conversation.isTransient()) {
		     conversation.begin();
	    }

	}
	
	@PreDestroy
	public void removeBean() {
		System.out.print("Removed from context");
	}
	
	public String getGreeting(){
		return "greeeting from member method";
	}
	
	public String getConfigValue(){
		return config.getString("some.key", "Not able to retrieve key");
	}
	
	  public Conversation getConversation() {
		    return conversation;
		  }
	
	//producer fields
	
	@Produces @Named("tableModel")
    public List<TableItem> getSource() {
	    return this.tbl; 
	}
	
	public static class TableItem implements Serializable {
		private static final long serialVersionUID = -61955240530083612L;
		private Integer Id;
		private String Name;
		public TableItem(Integer id, String name) {
			super();
			Id = id;
			Name = name;
		}
		public Integer getId() {
			return Id;
		}
		public String getName() {
			return Name;
		}
	}
	

}
