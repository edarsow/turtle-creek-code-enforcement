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

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.*;
import javax.faces.component.html.HtmlSelectOneListbox;
import java.util.Date;
import com.tcvcog.tcvce.application.BackingBeanUtils;
import java.io.Serializable;
import com.tcvcog.tcvce.entities.ActionRequest;
import com.tcvcog.tcvce.integration.CEActionRequestIntegrator;
import com.tcvcog.tcvce.integration.CEActionRequestIntegrator;
/**
 *
 * @author cedba
 */

public class ActionRequestBean extends BackingBeanUtils implements Serializable{
    
    private ActionRequest submittedRequest;

    // UI Component bindings
    
    private int violationTypeID;
    private String violationTypeName;
    
    private int muniID;
    private String muniName;
    
    private String form_addressOfConcern;
    
    private boolean form_notAtAddress;
    
    private String form_requestDescription;
    private boolean form_isUrgent;
    private Date form_dateOfRecord;
    
    private String requestorType;
    private int requestorTypeID;
    
    // located address
    private String form_requestorFName;
    private String form_requestorLName;
    private String form_requestor_phone;
    private String form_requestor_email;
    private String form_requestor_addressStreet;
    private String form_requestor_addressCity;
    private String form_requestor_addressZip;
    private boolean form_anonymous;

    /**
     * Creates a new instance of ActionRequestBean
     */
    public ActionRequestBean(){
    }
    
    
    /**
     * This action method is called when the request code enforcement
     * action request is submitted online (submit button in submitCERequest
     * @return 
     */
    public String submitActionRequest(){
        System.out.println("Building action request in Bean");
        ActionRequest aRequest = new ActionRequest();
        aRequest.setIssueType_issueTypeID(violationTypeID);
        aRequest.setMuni_muniID(muniID);
        aRequest.setAddressLine1(form_addressOfConcern);
        aRequest.setNotAtAddress(form_notAtAddress);
        aRequest.setRequestDescription(form_requestDescription);
        aRequest.setIsUrgent(form_isUrgent);
        aRequest.setDateOfRecord(form_dateOfRecord);
        
        // Requestor Information
        aRequest.setRequestorID(requestorTypeID);
        aRequest.setActionRequestorType_typeID(requestorTypeID);
        aRequest.setRequestorFName(form_requestorFName);
        aRequest.setRequestorLName(form_requestorLName);
        aRequest.setRequestor_phone(form_requestor_phone);
        aRequest.setRequestor_email(form_requestor_email);
        aRequest.setRequestor_addressStreet(form_requestor_addressStreet);
        aRequest.setRequestor_addressCity(form_requestor_addressCity);
        aRequest.setRequestor_addressZip(form_requestor_addressZip);
        aRequest.setAnonymous(form_anonymous);
        
        // should't be making a business object in this actionMethod
        // TODO Fix this structure!
        CEActionRequestIntegrator integrator = new CEActionRequestIntegrator();
        integrator.submitCEActionRequest(aRequest);
        submittedRequest = aRequest;
        
        //getVisit().setActionRequest(aRequest);
        
        
        
        
        
        return "success";
    }
    
    public String refreshPage(){
        return "submitCERequest";
    }

  

    /**
     * @return the form_addressOfConcern
     */
    public String getForm_addressOfConcern() {
        return form_addressOfConcern;
    }

    /**
     * @param form_addressOfConcern the form_addressOfConcern to set
     */
    public void setForm_addressOfConcern(String form_addressOfConcern) {
        this.form_addressOfConcern = form_addressOfConcern;
    }

    /**
     * @return the form_notAtAddress
     */
    public boolean isForm_notAtAddress() {
        return form_notAtAddress;
    }

    /**
     * @param form_notAtAddress the form_notAtAddress to set
     */
    public void setForm_notAtAddress(boolean form_notAtAddress) {
        this.form_notAtAddress = form_notAtAddress;
    }

    /**
     * @return the form_requestDescription
     */
    public String getForm_requestDescription() {
        return form_requestDescription;
    }

    /**
     * @param form_requestDescription the form_requestDescription to set
     */
    public void setForm_requestDescription(String form_requestDescription) {
        this.form_requestDescription = form_requestDescription;
    }

    /**
     * @return the form_isUrgent
     */
    public boolean isForm_isUrgent() {
        return form_isUrgent;
    }

    /**
     * @param form_isUrgent the form_isUrgent to set
     */
    public void setForm_isUrgent(boolean form_isUrgent) {
        this.form_isUrgent = form_isUrgent;
    }

    /**
     * @return the form_dateOfRecord
     */
    public Date getForm_dateOfRecord() {
        return form_dateOfRecord;
    }

    /**
     * @param form_dateOfRecord the form_dateOfRecord to set
     */
    public void setForm_dateOfRecord(Date form_dateOfRecord) {
        this.form_dateOfRecord = form_dateOfRecord;
    }

    /**
     * @return the form_requestorFName
     */
    public String getForm_requestorFName() {
        return form_requestorFName;
    }

    /**
     * @param form_requestorFName the form_requestorFName to set
     */
    public void setForm_requestorFName(String form_requestorFName) {
        this.form_requestorFName = form_requestorFName;
    }

    /**
     * @return the form_requestorLName
     */
    public String getForm_requestorLName() {
        return form_requestorLName;
    }

    /**
     * @param form_requestorLName the form_requestorLName to set
     */
    public void setForm_requestorLName(String form_requestorLName) {
        this.form_requestorLName = form_requestorLName;
    }

    /**
     * @return the form_requestor_phone
     */
    public String getForm_requestor_phone() {
        return form_requestor_phone;
    }

    /**
     * @param form_requestor_phone the form_requestor_phone to set
     */
    public void setForm_requestor_phone(String form_requestor_phone) {
        this.form_requestor_phone = form_requestor_phone;
    }

    /**
     * @return the form_requestor_email
     */
    public String getForm_requestor_email() {
        return form_requestor_email;
    }

    /**
     * @param form_requestor_email the form_requestor_email to set
     */
    public void setForm_requestor_email(String form_requestor_email) {
        this.form_requestor_email = form_requestor_email;
    }

    /**
     * @return the form_requestor_addressStreet
     */
    public String getForm_requestor_addressStreet() {
        return form_requestor_addressStreet;
    }

    /**
     * @param form_requestor_addressStreet the form_requestor_addressStreet to set
     */
    public void setForm_requestor_addressStreet(String form_requestor_addressStreet) {
        this.form_requestor_addressStreet = form_requestor_addressStreet;
    }

    /**
     * @return the form_requestor_addressCity
     */
    public String getForm_requestor_addressCity() {
        return form_requestor_addressCity;
    }

    /**
     * @param form_requestor_addressCity the form_requestor_addressCity to set
     */
    public void setForm_requestor_addressCity(String form_requestor_addressCity) {
        this.form_requestor_addressCity = form_requestor_addressCity;
    }

    /**
     * @return the form_requestor_addressZip
     */
    public String getForm_requestor_addressZip() {
        return form_requestor_addressZip;
    }

    /**
     * @param form_requestor_addressZip the form_requestor_addressZip to set
     */
    public void setForm_requestor_addressZip(String form_requestor_addressZip) {
        this.form_requestor_addressZip = form_requestor_addressZip;
    }

    /**
     * @return the form_anonymous
     */
    public boolean isForm_anonymous() {
        return form_anonymous;
    }

    /**
     * @param form_anonymous the form_anonymous to set
     */
    public void setForm_anonymous(boolean form_anonymous) {
        this.form_anonymous = form_anonymous;
    }

    /**
     * @return the requestorType
     */
    public String getRequestorType() {
        return requestorType;
            
    }

    /**
     * @param requestorType the requestorType to set
     */
    public void setRequestorType(String requestorType) {
        this.requestorType = requestorType;
    }

    /**
     * @return the requestorTypeID
     */
    public int getRequestorTypeID() {
        return requestorTypeID;
    }

    /**
     * @param requestorTypeID the requestorTypeID to set
     */
    public void setRequestorTypeID(int requestorTypeID) {
        this.requestorTypeID = requestorTypeID;
    }

    /**
     * @return the violationTypeID
     */
    public int getViolationTypeID() {
        return violationTypeID;
    }

    /**
     * @param violationTypeID the violationTypeID to set
     */
    public void setViolationTypeID(int violationTypeID) {
        this.violationTypeID = violationTypeID;
    }

    /**
     * @return the violationTypeName
     */
    public String getViolationTypeName() {
        return violationTypeName;
    }

    /**
     * @param violationTypeName the violationTypeName to set
     */
    public void setViolationTypeName(String violationTypeName) {
        this.violationTypeName = violationTypeName;
    }

    /**
     * @return the muniID
     */
    public int getMuniID() {
        return muniID;
    }

    /**
     * @param muniID the muniID to set
     */
    public void setMuniID(int muniID) {
        this.muniID = muniID;
    }

    /**
     * @return the muniName
     */
    public String getMuniName() {
        return muniName;
    }

    /**
     * @param muniName the muniName to set
     */
    public void setMuniName(String muniName) {
        this.muniName = muniName;
    }

    /**
     * @return the submittedRequest
     */
    public ActionRequest getSubmittedRequest() {
        return submittedRequest;
    }

    /**
     * @param submittedRequest the submittedRequest to set
     */
    public void setSubmittedRequest(ActionRequest submittedRequest) {
        this.submittedRequest = submittedRequest;
    }

    
}
