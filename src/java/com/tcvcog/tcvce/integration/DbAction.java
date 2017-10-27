/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcvcog.tcvce.integration;

import com.tcvcog.tcvce.entities.Property;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
//import javax.enterprise.context.SessionScoped;
import org.postgresql.jdbc3.Jdbc3PoolingDataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author cedba
 */
public class DbAction {
        
    Connection con;
    
    /**
     * Creates a new instance of DbAction
     */
    public DbAction() {
        Property prop =  null;
        
        System.out.println("Connecting to database");
        try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.toString());
            }
        
        Jdbc3PoolingDataSource source = new Jdbc3PoolingDataSource();
//        source.setDataSourceName("cogpgnew");
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
        
    }
    
    public Property getPropertyById(int id){
        Property p =  null;
        
       
        System.out.println("Looking up property in propSearchBean");
        String query = "SELECT propertyid, parid, lotandblock, address FROM property"
                + " WHERE propertyid =" + id;
        ResultSet rs;
        
        
 
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            
            
            if(rs.next() == true){
                p = new Property();
                p.setPropertyID(rs.getDouble("propertyid"));
                p.setParID(rs.getString("parid"));
                p.setLotAndBlock(rs.getString("lotandblock"));
                p.setAddress(rs.getString("address"));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        
        
        return p;
        
        
    }
    
        
    
}
