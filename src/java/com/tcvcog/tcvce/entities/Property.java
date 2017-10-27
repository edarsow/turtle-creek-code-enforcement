/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcvcog.tcvce.entities;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.LinkedList;

/**
 *
 * @author cedba
 */
@Dependent
@Named
public class Property {
    
    private double propertyID;
    private String parID;
    private String borough;
    private String lotAndBlock;
    private String rental;
    private String address;
    private String apartmetnNo;
    
    LinkedList<Case> cases;
    
    
  /**
     * Creates a new instance of Property
     */
    public Property() {
        cases = getCases();
    }
    
    private LinkedList getCases(){
        LinkedList<Case> casesLocal = new LinkedList();
        return casesLocal;
        
    }
    
    /**
     * @return the propertyID
     */
    public double getPropertyID() {
        return propertyID;
    }

    /**
     * @param propertyID the propertyID to set
     */
    public void setPropertyID(double propertyID) {
        this.propertyID = propertyID;
    }

    /**
     * @return the parID
     */
    public String getParID() {
        return parID;
    }

    /**
     * @param parID the parID to set
     */
    public void setParID(String parID) {
        this.parID = parID;
    }

    /**
     * @return the logAndBlock
     */
    public String getLotAndBlock() {
        return lotAndBlock;
    }

    /**
     * @param logAndBlock the logAndBlock to set
     */
    public void setLotAndBlock(String lotAndBlock) {
        this.lotAndBlock = lotAndBlock;
    }

    /**
     * @return the rental
     */
    public String getRental() {
        return rental;
    }

    /**
     * @param rental the rental to set
     */
    public void setRental(String rental) {
        this.rental = rental;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the apartmetnNo
     */
    public String getApartmetnNo() {
        return apartmetnNo;
    }

    /**
     * @param apartmetnNo the apartmetnNo to set
     */
    public void setApartmetnNo(String apartmetnNo) {
        this.apartmetnNo = apartmetnNo;
    }

    /**
     * @return the borough
     */
    public String getBorough() {
        return borough;
    }

    /**
     * @param borough the borough to set
     */
    public void setBorough(String borough) {
        this.borough = borough;
    }
    

    
    
}
