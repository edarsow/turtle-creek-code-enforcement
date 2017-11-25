/*
 * Copyright (C) 2017 cedba
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tcvcog.tcvce.application;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.tcvcog.tcvce.entities.User;


import com.tcvcog.tcvce.domain.*;


/**
 *
 * @author cedba
 */
public class Authentication extends BackingBeanUtils{
    
    private String loginName;
    private String loginPassword;

    /**
     * Creates a new instance of Authentication
     */
    public Authentication() {
        System.out.println("Creating Authentication Bean");
        
    }
    
    public String login() {
        System.out.println("Login method inside Authentication bean");
        
        FacesContext facesContext = getFacesContext();
        User newUser = null;
        
        try {
            newUser = getUserCorodinator().getUser(loginName, loginPassword);
            
        } catch(ObjectNotFoundException e){
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Name or Password", ""));
            return "failure";
        } catch(DataStoreException e){
            return "failure";
            
        }
        
        return "success";
        
        
    }
    

    /**
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return the loginPassword
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * @param loginPassword the loginPassword to set
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
    
    
} // close clas