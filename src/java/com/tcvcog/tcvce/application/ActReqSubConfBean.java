/*
 * Copyright (C) 2017 sylvia
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

import javax.faces.FactoryFinder;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.lifecycle.LifecycleFactory;
import javax.faces.lifecycle.Lifecycle;

/**
 *
 * @author sylvia
 */
public class ActReqSubConfBean {

    /**
     * Creates a new instance of ActReqSubConfBean
     */
    public ActReqSubConfBean() {
        
        /**
        LifecycleFactory lifeCycleFactory = (LifecycleFactory)
                FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
        Lifecycle lifecycle = lifeCycleFactory
                .getLifecycle(lifeCycleFactory.DEFAULT_LIFECYCLE);
        
        lifecycle.addPhaseListener(
            new PhaseListener(){
                @Override
                public void beforePhase(PhaseEvent event){
                    
                }
                
                public void afterPhase(PhaseEvent event){
                    
                }
                
                public PhaseId getPhaseId(){
                    return PhaseId.RENDER_RESPONSE;
                }
                
            } // close anony class
                
        ); // close call to addPhaseListener
        * 
        */
        
    } // close constructor
    
    
    
    
    
}
