/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcvcog.tcvce.application;

import javax.inject.Named;
import java.io.Serializable;
import javax.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.LinkedList;
import com.tcvcog.tcvce.entities.Property;
import org.postgresql.jdbc3.Jdbc3PoolingDataSource;
import java.sql.SQLException;

/** 
 *
 * @author cedba
 */
@Named(value = "propSearchBean")
public class PropSearchBean implements Serializable {
    // data source injection
//    @Inject DBConnection db;
    
    // connects to our facelet
    private String parid = null;
    private String address = null;
    private String addrPart = null;
    Connection con = null;
    private static String dbUsername = "cogdba";
    private static String dbPassword = "c0d3";
  
    
    private List<Property> propList;
    /**
     * Creates a new instance of PropSearchBean
     */
    public PropSearchBean() {

        
    } // close constructor
    
    public void lookUpProperty(){
        
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
        source.setUser("sylvia");
        source.setPassword("c0d3");
        source.setMaxConnections(10);
        try {
            con = source.getConnection();
            System.out.println("connection to db open");
        } catch (SQLException ex) {
            ex.toString();
        }
        
        System.out.println("Looking up property in propSearchBean");
        String query = "SELECT propertyid, parid, lotandblock, address FROM property"
                + " WHERE address LIKE '%" + addrPart + "%'";
        ResultSet rs;
        
        propList = new LinkedList<>();
 
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                Property p = new Property();
                p.setPropertyID(rs.getDouble("propertyid"));
                p.setParID(rs.getString("parid"));
                p.setLotAndBlock(rs.getString("lotandblock"));
                p.setAddress(rs.getString("address"));
                propList.add(p);
                con.close();
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
    }

    /**
     * @return the parid
     */
    public String getParid() {
        return this.parid;
    }

    /**
     * @param parid the parid to set
     */
    public void setParid(String parid) {
        this.parid = parid;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the addrPart
     */
    public String getAddrPart() {
        return addrPart;
    }

    /**
     * @param addrPart the addrPart to set
     */
    public void setAddrPart(String addrPart) {
        this.addrPart = addrPart;
    }

    /**
     * @return the propList
     */
    public List<Property> getPropList() {
        return propList;
    }

    /**
     * @param propList the propList to set
     */
    public void setPropList(List<Property> propList) {
        this.propList = propList;
    }
    
    
    
}
