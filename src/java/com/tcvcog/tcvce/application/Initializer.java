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

import com.tcvcog.tcvce.entities.Case;
import com.tcvcog.tcvce.util.Constants;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
//interface that allows us to handle servlet created initialization events
import javax.servlet.ServletContextListener; 

import javax.servlet.annotation.WebListener;



/**
 *
 * @author cedba
 */
@WebListener
public class Initializer implements ServletContextListener{

    /**
     * Creates a new instance of Initializer
     */
    public Initializer() {
        System.out.println("Creating Initializer Bean");
        
    
    }
    
   @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("inside overriden method contextInitialized");
        
        ServletContext servletContext = event.getServletContext();
        UserCoordinator userCoordinator = new UserCoordinator();
        
        // this setAttribute system is not working as planned.
        
        //servletContext.setAttribute(Constants.USER_COORDINATOR_SCOPE, userCoordinator);
        servletContext.setAttribute(Constants.USER_COORDINATOR_KEY, userCoordinator);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event){
        
    }
    
    
    
}
