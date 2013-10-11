package com.antaranga.jsf.beans;

import i18n.I18N;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import com.antaranga.jsf.core.WebPageBean;
import com.antaranga.jsf.core.WebPageEvent;

@WebPageBean(scope="request", page="edit.xhtml")
public class EditBean {
    
    private TableItem selectedItem;
    
    public EditBean() {
    
    }
    
    @PostConstruct
    public void init(){
        System.out.print(selectedItem);
    }
    
    @PreDestroy
    public void flush(){
        
    }
    
  
    @WebPageEvent
    public String submit(){
        return "list";
    }

    
    public TableItem getSelectedItem() {
        return this.selectedItem;
    }

    
    public void setSelectedItem(TableItem selectedItem) {
        this.selectedItem = selectedItem;
    }

    
    
}
