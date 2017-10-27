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

import com.tcvcog.tcvce.domain.DataStoreException;
import com.tcvcog.tcvce.domain.ObjectNotFoundException;
import com.tcvcog.tcvce.entities.Property;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import org.postgresql.jdbc3.Jdbc3PoolingDataSource;
import java.sql.SQLException;
import java.io.Serializable;
import com.tcvcog.tcvce.domain.ObjectNotFoundException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import com.tcvcog.tcvce.entities.User;

/**
 *
 * @author cedba
 */
@ApplicationScoped
@Named("userCoordinator")
public class UserCoordinator implements Serializable {

     Connection con = null;
    
    /**
     * Creates a new instance of UserCoordinator
     */
    public UserCoordinator(){
        System.out.println("Initializing userCoordinator class");
        
    }
    
    /**
     * Responds to login requests by taking the loginName and loginPassword
     * and searching the database for a registered user. If a user is found
     * in the DB, a User object is created and returned, allow the user to progress 
     * pass the authentication screen.
     * 
     * @param loginName the login name entered by the user
     * @param loginPassword the password entered by the user
     * 
     * @return a User object loaded up with various attributes of the user, 
     * including the user's role in the system.
     * 
     * @throws com.tcvcog.tcvce.domain.ObjectNotFoundException
     * @throws com.tcvcog.tcvce.domain..DataStoreException
     */
    public User getUser(String loginName, String loginPassword) throws ObjectNotFoundException, DataStoreException {
        System.out.println("Inside getUser method inside Usercoordinator Class");
        
        try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.toString());
            }
        
        Jdbc3PoolingDataSource source = new Jdbc3PoolingDataSource();
        source.setServerName("localhost:5432");
        source.setDatabaseName("cogdb");
        source.setUser("cogdba");
        source.setPassword("c0d3");
        source.setMaxConnections(10);
        try {
            con = source.getConnection();
            System.out.println("connection to db open");
        } catch (SQLException ex) {
            ex.toString();
        }
        
         String query = "SELECT username, password FROM login"
                + " WHERE username='"+ loginName + "' AND password='" + loginPassword +"';";
        ResultSet rs;
        
        // login is successful if the result set has any rows in it
        // TODO: create value comparison check as a backup to avoid SQL injection risks
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if(rs.next()){
                User user = new User();
                return user;
            } else {
                throw new ObjectNotFoundException("No User found with those credentials. Try again, please.");
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return null;
        
    } // close getUser()
    
    
} // close class
