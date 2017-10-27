/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcvcog.tcvce.integration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
//import javax.enterprise.context.SessionScoped;
import org.postgresql.jdbc3.Jdbc3PoolingDataSource;
import java.sql.SQLException;


/**
 *
 * @author cedba
 */

public class DBConnection implements Serializable{

    private Connection con = null;
//    private static final String DBUSERNAME = "cogdba";
//    private static final String DBPASS = "c0d3";
    
    /**
     * Creates a new instance of DBConnection
     */
    public DBConnection() {
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
        
//        System.out.println("Looking up property in db connection");
//        String query = "SELECT parid, lotandblock, address, apartmentno FROM property"
//                + " WHERE parid='0297D00212000000';";
//        ResultSet rs;
//        String address = null;
// 
//        try {
//            Statement stmt = con.createStatement();
//            rs = stmt.executeQuery(query);
//            rs.next();
//            address = rs.getString("address");
//            System.out.println("Address Found: " + address);
//            
//            
//            
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
    }
    
//    public Connection getConnection(){
//        System.out.println("Creating DB Connection");
//        
//        Jdbc3PoolingDataSource source = new Jdbc3PoolingDataSource();
//        source.setDataSourceName("cogpgnew");
//        source.setServerName("localhost:5432");
//        source.setDatabaseName("cogdb");
//        source.setUser("cogdba");
//        source.setPassword("c0d3");
//        source.setMaxConnections(10);
//        try {
//            con = source.getConnection();
//            System.out.println("connection to db open");
//        } catch (SQLException ex) {
//            ex.toString();
//        }
//        
//        return con;
//        
//    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
  
    public void setCon(Connection con){
        this.con = con;
    }
    
}
