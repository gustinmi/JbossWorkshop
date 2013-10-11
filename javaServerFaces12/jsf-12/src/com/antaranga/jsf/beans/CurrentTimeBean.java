/**
 * 
 */
package com.antaranga.jsf.beans;

import java.util.Date;


/**
 * @author gustinm
 *
 */
public class CurrentTimeBean {
    
    public String getGetTime() {
        return new Date().toString();
    }
    
}
