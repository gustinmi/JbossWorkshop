/**
 * 
 */
package com.antaranga.jsf.beans.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gustinm
 *
 */
public class MenuOptions {

    private List<MenuItem> options = new ArrayList<MenuItem>();

    private MenuItem selectedOption;
    
    public String navigate(){
        return this.selectedOption.getText();
    }
    
    public MenuOptions() {
        options.add(new MenuItem("1", "home", "all", "home.jsf"));
        options.add(new MenuItem("2", "list", "all", "list.jsf"));
        options.add(new MenuItem("4", "admin", "admin", "admin.jsf"));
    }
    
    public java.util.List<MenuItem>  getUserOptions(){
       List<MenuItem> tempOptions = new ArrayList<MenuItem>();
       for (MenuItem i : options){
           if (i.getRole().equals("all") || i.getRole().equals("user"))
               tempOptions.add(i);
       }
       return tempOptions;
    }

    public java.util.List<MenuItem>  getAdminOptions(){
        List<MenuItem> tempOptions = new ArrayList<MenuItem>();
        for (MenuItem i : options){
            if (i.getRole().equals("all") || i.getRole().equals("admin"))
                tempOptions.add(i);
        }
        return tempOptions;
    }

    public MenuItem getSelectedOption() {
        return this.selectedOption;
    }
    
    public void setSelectedOption(MenuItem selectedOption) {
        this.selectedOption = selectedOption;
    }
    
}
