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

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.faces.application.Application;
import java.sql.Connection;
import com.tcvcog.tcvce.integration.DBConnection;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author cedba
 */
//@ApplicationScoped
//@Named("backingBeanUtils")
public class BackingBeanUtils implements Serializable{

    private Visit visit;
    private UserCoordinator userCoordinator;
    private Connection postgresCon;
    
    /**
     * Creates a new instance of BackingBeanUtils
     */
    public BackingBeanUtils() {
        
        // this creation of the usercorodinator should be managed by the 
        // MBCF but doesn't seem to be--this is not a solid object-oriented
        // design concept that works well with the bean model
        // it should be made by the MBCF
        System.out.println("Constructing BackingBean Utils");
        //userCoordinator = new UserCoordinator();
        
       
        
    }
    
    public static java.sql.Timestamp getCurrentTimeStamp(){
        java.util.Date date = new java.util.Date();
        return new java.sql.Timestamp(date.getTime());
        
    }
    
    public FacesContext getFacesContext(){
        return FacesContext.getCurrentInstance();
    }
    
    public Application getApplication(){
        return getFacesContext().getApplication();
    }
    
    public Visit getVisit(){
        return visit;
    }
    
    public void setVisit(Visit visit){
        this.visit = visit;
    }
    
    public UserCoordinator getUserCorodinator(){
        System.out.println("Inside call to getUserCoordinator of class BackingBeanUtils");
        
        return userCoordinator;
    }
    
    public void setUserCoordinator(UserCoordinator userCoordinator){
        this.userCoordinator = userCoordinator;
    }

    /**
     * creates a DBConnection factory and calls getCon to get a handle on the
     * database connection
     * @return the postgresCon
     */
    public Connection getPostgresCon() {
        DBConnection factory = new DBConnection();
        postgresCon = factory.getCon();
        return postgresCon;
    }

    /**
     * @param postgresCon the postgresCon to set
     */
    public void setPostgresCon(Connection postgresCon) {
        this.postgresCon = postgresCon;
    }
    
    public int getControlCodeFromTime(){
         long dateInMs = new Date().getTime();
         
         String numAsString = String.valueOf(dateInMs);
         String reducedNum = numAsString.substring(7);
         int controlCode = Integer.parseInt(reducedNum);
         
            
         return controlCode;
    }
    
}
