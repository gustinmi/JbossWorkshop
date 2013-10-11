package com.antaranga.jsf.beans.menu;


public class MenuItem {
    private String id;
    private String text;
    private String uri;
    private String role;
    
    public MenuItem(){
        
    }
    
    public MenuItem(final String id, final String text, final String role, final String uri) {
        this();
        this.id = id;
        this.text = text;
        this.role = role;
        this.uri = uri;
    }

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getUri() {
        return this.uri;
    }
    
    public void setUri(String uri) {
        this.uri = uri;
    }
    
}
