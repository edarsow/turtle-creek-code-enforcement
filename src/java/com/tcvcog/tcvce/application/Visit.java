 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcvcog.tcvce.application;

import com.tcvcog.tcvce.entities.Property;
import com.tcvcog.tcvce.entities.Case;
import com.tcvcog.tcvce.entities.Event;
import com.tcvcog.tcvce.entities.User;
import com.tcvcog.tcvce.entities.ActionRequest;

/**
 *
 * @author cedba
 */
public class Visit {

    private Property activeProp;
    private Case activeCase;
    private Event activeEvent;
    private User currentUser;
    private ActionRequest actionRequest;
    
    /**
     * Creates a new instance of Visit
     */
    public Visit() {
    }

    /**
     * @return the activeProp
     */
    public Property getActiveProp() {
        return activeProp;
    }

    /**
     * @param activeProp the activeProp to set
     */
    public void setActiveProp(Property activeProp) {
        this.activeProp = activeProp;
    }

    /**
     * @return the activeCase
     */
    public Case getActiveCase() {
        return activeCase;
    }

    /**
     * @param activeCase the activeCase to set
     */
    public void setActiveCase(Case activeCase) {
        this.activeCase = activeCase;
    }

    /**
     * @return the activeEvent
     */
    public Event getActiveEvent() {
        return activeEvent;
    }

    /**
     * @param activeEvent the activeEvent to set
     */
    public void setActiveEvent(Event activeEvent) {
        this.activeEvent = activeEvent;
    }

    /**
     * @return the actionRequest
     */
    public ActionRequest getActionRequest() {
        return actionRequest;
    }

    /**
     * @param actionRequest the actionRequest to set
     */
    public void setActionRequest(ActionRequest actionRequest) {
        this.actionRequest = actionRequest;
    }

    /**
     * @return the currentUser
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    
    
}
