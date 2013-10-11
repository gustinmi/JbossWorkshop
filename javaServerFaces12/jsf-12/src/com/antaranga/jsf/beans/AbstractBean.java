package com.antaranga.jsf.beans;

import java.util.List;
import com.antaranga.jsf.beans.menu.MenuItem;


public class AbstractBean {

    private List<MenuItem> menuList;

    public List<MenuItem> getMenuList() {
        return this.menuList;
    }
    
    public void setMenuList(List<MenuItem> menuList) {
        this.menuList = menuList;
    }
    
}
