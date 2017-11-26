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
package com.tcvcog.tcvce.entities;

import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDateTime;

/**
 * Models the entity: code enforcement action request. 
 * This object blends data from several database tables to create
 * a conceptual model of a single request.
 * 
 * The jsf page for submitting a request act on an ActionRequest object
 * and will edit the values of member varibles
 * on this object and can then ask for the request to be read into the DB.
 * 
 * A reference to an ActionRequest object will be attached to the 
 * Visit object such that both public and logged in users will have access
 * to an ActionRequest to do with as they please (print, etc.)
 * @author Eric Darsow
 */
public class ActionRequest {
    
    private int requestID;
    private int requestPublicCC;
    private int muni_muniID;

    private int issueType_issueTypeID;
    private int requestorID;
    private java.time.LocalDateTime submittedTimeStamp;

    private java.time.LocalDate dateOfRecord;
    private String addressOfConcern;
    private String addressZip;
    
    private boolean notAtAddress;
    private String requestDescription;
    private boolean isUrgent;

    private int caseID;
    private int reqStat_requestStatusID;
    private String cogInternalNotes;
    
    private String muniInternalNotes;
    private String publicExternalNotes;
    // end threes
    
    // these are populated on the lookup when the linked
    // tables with the String values are selected
    private String issueTypeString;
    private String muniNameString;
    private String requestStatusString;
    
    // only editable by back-end users
    
    // Action requestor fields
    // names that appear without an _ map to db fields
    // names like requestor_notes means the db field name is
    // notes in the requestor table
    private String requestorFName;
    private String requestorLName;
    private String requestor_phone;
    private String requestor_email;
    private String requestor_notes;
    private String requestor_addressStreet;
    private String requestor_addressCity;
    private String requestor_addressZip;
    
    private int actionRequestorType_typeID;
    private String actionRequestorType;
    
    private boolean anonymous;
    
    // connection to a case object -- TODO in expansion
    //private int caseID;

    /**
     * Creates a new instance of ActionRequest
     */
    public ActionRequest() {
    }

    /**
     * @return the requestID
     */
    public int getRequestID() {
        return requestID;
    }

    /**
     * @param requestID the requestID to set
     */
    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    /**
     * @return the issueType_issueTypeID
     */
    public int getIssueType_issueTypeID() {
        return issueType_issueTypeID;
    }

    /**
     * @param issueType_issueTypeID the issueType_issueTypeID to set
     */
    public void setIssueType_issueTypeID(int issueType_issueTypeID) {
        this.issueType_issueTypeID = issueType_issueTypeID;
    }

    /**
     * @return the issueTypeString
     */
    public String getIssueTypeString() {
        return issueTypeString;
    }

    /**
     * @param issueTypeString the issueTypeString to set
     */
    public void setIssueTypeString(String issueTypeString) {
        this.issueTypeString = issueTypeString;
    }

    /**
     * @return the requestorID
     */
    public int getRequestorID() {
        return requestorID;
    }

    /**
     * @param requestorID the requestorID to set
     */
    public void setRequestorID(int requestorID) {
        this.requestorID = requestorID;
    }

    /**
     * @return the requestorFName
     */
    public String getRequestorFName() {
        return requestorFName;
    }

    /**
     * @param requestorFName the requestorFName to set
     */
    public void setRequestorFName(String requestorFName) {
        this.requestorFName = requestorFName;
    }

    /**
     * @return the requestorLName
     */
    public String getRequestorLName() {
        return requestorLName;
    }

    /**
     * @param requestorLName the requestorLName to set
     */
    public void setRequestorLName(String requestorLName) {
        this.requestorLName = requestorLName;
    }

    /**
     * @return the requestor_phone
     */
    public String getRequestor_phone() {
        return requestor_phone;
    }

    /**
     * @param requestor_phone the requestor_phone to set
     */
    public void setRequestor_phone(String requestor_phone) {
        this.requestor_phone = requestor_phone;
    }

    /**
     * @return the requestor_email
     */
    public String getRequestor_email() {
        return requestor_email;
    }

    /**
     * @param requestor_email the requestor_email to set
     */
    public void setRequestor_email(String requestor_email) {
        this.requestor_email = requestor_email;
    }

    /**
     * @return the requestor_notes
     */
    public String getRequestor_notes() {
        return requestor_notes;
    }

    /**
     * @param requestor_notes the requestor_notes to set
     */
    public void setRequestor_notes(String requestor_notes) {
        this.requestor_notes = requestor_notes;
    }

    /**
     * @return the requestor_addressStreet
     */
    public String getRequestor_addressStreet() {
        return requestor_addressStreet;
    }

    /**
     * @param requestor_addressStreet the requestor_addressStreet to set
     */
    public void setRequestor_addressStreet(String requestor_addressStreet) {
        this.requestor_addressStreet = requestor_addressStreet;
    }

    

    /**
     * @return the actionRequestorType_typeID
     */
    public int getActionRequestorType_typeID() {
        return actionRequestorType_typeID;
    }

    /**
     * @param actionRequestorType_typeID the actionRequestorType_typeID to set
     */
    public void setActionRequestorType_typeID(int actionRequestorType_typeID) {
        this.actionRequestorType_typeID = actionRequestorType_typeID;
    }

    /**
     * @return the actionRequestorType
     */
    public String getActionRequestorType() {
        return actionRequestorType;
    }

    /**
     * @param actionRequestorType the actionRequestorType to set
     */
    public void setActionRequestorType(String actionRequestorType) {
        this.actionRequestorType = actionRequestorType;
    }

    /**
     * @return the anonymous
     */
    public boolean isAnonymous() {
        return anonymous;
    }

    /**
     * @param anonymous the anonymous to set
     */
    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }

    /**
     * @return the addressOfConcern
     */
    public String getAddressOfConcern() {
        return addressOfConcern;
    }

    /**
     * @param addressOfConcern the addressOfConcern to set
     */
    public void setAddressOfConcern(String addressOfConcern) {
        this.addressOfConcern = addressOfConcern;
    }

    /**
     * @return the notAtAddress
     */
    public boolean isNotAtAddress() {
        return notAtAddress;
    }

    /**
     * @param notAtAddress the notAtAddress to set
     */
    public void setNotAtAddress(boolean notAtAddress) {
        this.notAtAddress = notAtAddress;
    }
    
    public boolean getNotAtAddress(){
        return notAtAddress;
    }

    /**
     * @return the muni_muniID
     */
    public int getMuni_muniID() {
        return muni_muniID;
    }

    /**
     * @param muni_muniID the muni_muniID to set
     */
    public void setMuni_muniID(int muni_muniID) {
        this.muni_muniID = muni_muniID;
    }

    /**
     * @return the muniNameString
     */
    public String getMuniNameString() {
        return muniNameString;
    }

    /**
     * @param muniNameString the muniNameString to set
     */
    public void setMuniNameString(String muniNameString) {
        this.muniNameString = muniNameString;
    }

    /**
     * @return the requestDescription
     */
    public String getRequestDescription() {
        return requestDescription;
    }

    /**
     * @param requestDescription the requestDescription to set
     */
    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    /**
     * @return the isUrgent
     */
    public boolean isIsUrgent() {
        return isUrgent;
    }

    /**
     * @param isUrgent the isUrgent to set
     */
    public void setIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    /**
     * @return the dateOfRecord
     */
    public LocalDate getDateOfRecord() {
        return dateOfRecord;
    }

    /**
     * @param dateOfRecord the dateOfRecord to set
     */
    public void setDateOfRecord(LocalDate dateOfRecord) {
        this.dateOfRecord = dateOfRecord;
    }

    /**
     * @return the reqStat_requestStatusID
     */
    public int getReqStat_requestStatusID() {
        return reqStat_requestStatusID;
    }

    /**
     * @param reqStat_requestStatusID the reqStat_requestStatusID to set
     */
    public void setReqStat_requestStatusID(int reqStat_requestStatusID) {
        this.reqStat_requestStatusID = reqStat_requestStatusID;
    }

    /**
     * @return the requestStatusString
     */
    public String getRequestStatusString() {
        return requestStatusString;
    }

    /**
     * @param requestStatusString the requestStatusString to set
     */
    public void setRequestStatusString(String requestStatusString) {
        this.requestStatusString = requestStatusString;
    }

 

    /**
     * @return the internalNotes
     */
   
    /**
     * @return the requestor_addressCity
     */
    public String getRequestor_addressCity() {
        return requestor_addressCity;
    }

    /**
     * @param requestor_addressCity the requestor_addressCity to set
     */
    public void setRequestor_addressCity(String requestor_addressCity) {
        this.requestor_addressCity = requestor_addressCity;
    }

    /**
     * @return the requestor_addressZip
     */
    public String getRequestor_addressZip() {
        return requestor_addressZip;
    }

    /**
     * @param requestor_addressZip the requestor_addressZip to set
     */
    public void setRequestor_addressZip(String requestor_addressZip) {
        this.requestor_addressZip = requestor_addressZip;
    }

    /**
     * @return the cogInternalNotes
     */
    public String getCogInternalNotes() {
        return cogInternalNotes;
    }

    /**
     * @param cogInternalNotes the cogInternalNotes to set
     */
    public void setCogInternalNotes(String cogInternalNotes) {
        this.cogInternalNotes = cogInternalNotes;
    }

    /**
     * @return the muniInternalNotes
     */
    public String getMuniInternalNotes() {
        return muniInternalNotes;
    }

    /**
     * @param muniInternalNotes the muniInternalNotes to set
     */
    public void setMuniInternalNotes(String muniInternalNotes) {
        this.muniInternalNotes = muniInternalNotes;
    }

    /**
     * @return the publicExternalNotes
     */
    public String getPublicExternalNotes() {
        return publicExternalNotes;
    }

    /**
     * @param publicExternalNotes the publicExternalNotes to set
     */
    public void setPublicExternalNotes(String publicExternalNotes) {
        this.publicExternalNotes = publicExternalNotes;
    }

    /**
     * @return the caseID
     */
    public int getCaseID() {
        return caseID;
    }

    /**
     * @param caseID the caseID to set
     */
    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    /**
     * @return the requestPublicCC
     */
    public int getRequestPublicCC() {
        return requestPublicCC;
    }

    /**
     * @param requestPublicCC the requestPublicCC to set
     */
    public void setRequestPublicCC(int requestPublicCC) {
        this.requestPublicCC = requestPublicCC;
    }

    /**
     * @return the submittedTimeStamp
     */
    public LocalDateTime getSubmittedTimeStamp() {
        return submittedTimeStamp;
    }

    /**
     * @param submittedTimeStamp the submittedTimeStamp to set
     */
    public void setSubmittedTimeStamp(LocalDateTime submittedTimeStamp) {
        this.submittedTimeStamp = submittedTimeStamp;
    }

    /**
     * @return the addressZip
     */
    public String getAddressZip() {
        return addressZip;
    }

    /**
     * @param addressZip the addressZip to set
     */
    public void setAddressZip(String addressZip) {
        this.addressZip = addressZip;
    }
    
}
