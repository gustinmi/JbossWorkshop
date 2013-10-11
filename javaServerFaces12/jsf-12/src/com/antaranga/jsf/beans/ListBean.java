package com.antaranga.jsf.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import com.antaranga.jsf.core.WebPageBean;
import com.antaranga.jsf.core.WebPageEvent;

@WebPageBean(scope="request", page="list.xhtml")
public class ListBean {

    private List<TableItem> itemList;
    private TableItem selectedItem;
    
    //private @Resource(name="env/welcomeMsg") String welcomeMsg;
    
    public ListBean() {
        super();
    }
    
    @PostConstruct
    public void init(){
        if (itemList == null){
            itemList = new ArrayList<TableItem>();
        }
    }
    
    @PreDestroy
    public void flush(){
        
    }
    
    @WebPageEvent()
    public String delete(){
        itemList.remove(selectedItem);
        return null;
    }
    
    public List<TableItem> getItemList() {
        return this.itemList;
    }
    
    public void setItemList(List<TableItem> itemList) {
        this.itemList = itemList;
    }
    
    public TableItem getSelectedItem() {
        return this.selectedItem;
    }
    
    public void setSelectedItem(TableItem selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    
}
