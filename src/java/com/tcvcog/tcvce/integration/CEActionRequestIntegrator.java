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
package com.tcvcog.tcvce.integration;

import com.tcvcog.tcvce.application.BackingBeanUtils;
import com.tcvcog.tcvce.entities.ActionRequest;
import java.sql.*;
import java.util.HashMap;
import com.tcvcog.tcvce.util.Constants;
import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sylvia
 */
public class CEActionRequestIntegrator extends BackingBeanUtils {

    /**
     * Creates a new instance of CEActionRequestIntegrator
     */
    public CEActionRequestIntegrator() {
    }
    
    public int submitCEActionRequest(ActionRequest request){
        System.out.println("Writing Action Request Into DB");
        int controlCode = 0;
        PreparedStatement insertAction = null;
        
        System.out.println("DATE DEBUGGING:");
        System.out.println("Get current time stamp:");
        System.out.println(getCurrentTimeStamp().toString());
        System.out.println("Date of record:");
        Date pracDate = new Date(request.getDateOfRecord().toEpochDay());
        System.out.println(pracDate.toString());
        
//        Logger.getLogger(CEActionRequestIntegrator.class.getName()).log(Level.INFO, null, "Attempting ce request submission");
        
        StringBuilder qbuilder = new StringBuilder();
        qbuilder.append("INSERT INTO public.codeenfactionrequest(\n" 
                + "requestpubliccc, muni_muniid, "
                + "issuetype_issuetypeid, actrequestor_requestorid, submittedtimestamp, "
                + "dateofrecord, addressofconcern, addressZip, "
                + "notataddress, requestdescription, isurgent, "
                + "caseid, reqstat_requeststatusid, coginternalnotes, "
                + "muniinternalnotes, publicexternalnotes)\n" +
                "    VALUES (?, ?, ?, \n" +
                "            ?, ?, ?, ?, \n" +
                "            ?, ?, ?, ?, ?, \n" +
                "            ?, ?, ?, \n" +
                "            ?);");
        
      
        
        try {
            Connection con = getPostgresCon();
            
            insertAction = con.prepareStatement(qbuilder.toString());
            
           // insertAction.setInt(1, request.getRequestID());
            controlCode = getControlCodeFromTime();
            insertAction.setInt(1, controlCode);
            insertAction.setInt(2, request.getMuni_muniID());
            
            insertAction.setInt(3, request.getIssueType_issueTypeID());
            // TODO deal with requestor flow
            insertAction.setInt(4, 1); 
            
            insertAction.setTimestamp(5, getCurrentTimeStamp());
            
            java.sql.Date date = new Date(request.getDateOfRecord().toEpochDay()) ;
            insertAction.setDate(6, date);
//            insertAction.setDate(7, java.sql.Date.valueOf(request.getDateOfRecord()));
            insertAction.setString(7, request.getAddressOfConcern());
            insertAction.setString(8, request.getAddressZip());
            
            insertAction.setBoolean(9, request.getNotAtAddress());
            insertAction.setString(10, request.getRequestDescription());
            insertAction.setBoolean(11, request.isIsUrgent());
            
            insertAction.setInt(12, request.getCaseID());
            
            insertAction.setInt(13, 1);
          //  insertAction.setInt(14, request.getReqStat_requestStatusID());
            insertAction.setString(14, request.getCogInternalNotes());
            
            insertAction.setString(15, request.getMuniInternalNotes());
            insertAction.setString(16, request.getPublicExternalNotes());
            
            // INSERT REQUEST INTO DATABASE
            insertAction.executeUpdate();
            insertAction.close();
            
            
            
            insertAction.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CEActionRequestIntegrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return controlCode;
        
    } // close submitActionRequest
    
    public ActionRequest getActionRequest(int controlCode){
        ActionRequest actionRequest = new ActionRequest();
        StringBuilder sb = new StringBuilder();
        
        sb.append("SELECT requestid, requestpubliccc, muni_muniid, \n" +
"	issuetype_issuetypeid, actrequestor_requestorid, submittedtimestamp, \n" +
"	dateofrecord, addressofconcern, codeenfactionrequest.addresszip, \n" +
"	notataddress, requestdescription, isurgent, \n" +
"	caseid,reqstat_requeststatusid, coginternalnotes, \n" +
"	muniinternalnotes, publicexternalnotes,\n" +
"	actionRqstIssueType.typeName AS typename, municipality.muniName AS muniname, requestStatus.statusName AS statusname \n" +
"	FROM public.codeenfactionrequest INNER JOIN public.actionrequestor ON actrequestor_requestorid = requestorid\n" +
"		INNER JOIN actionrqstissuetype ON issuetype_issuetypeid = issuetypeid\n" +
"		INNER JOIN requestStatus ON reqStat_requestStatusID = requestStatusID\n" +
"		INNER JOIN municipality ON muni_muniID = municipalityID\n" +
"		INNER JOIN actionRequestorType ON actionRequestorType_typeID = typeID");
        sb.append(" WHERE requestpubliccc = ");
        sb.append(String.valueOf(controlCode));
        sb.append(";");
        
        System.out.println("Select Statement: ");
        System.out.println(sb.toString());
        
         ResultSet rs;
         try {
            Connection con = getPostgresCon();
            Statement stmt = con.createStatement();
            
            // Retrieve action data from postgres
           rs = stmt.executeQuery(sb.toString());
           while(rs.next()){
           
           actionRequest.setRequestID(rs.getInt("requestid"));
           actionRequest.setRequestPublicCC(rs.getInt("requestPubliccc"));
           actionRequest.setMuni_muniID(rs.getInt("muni_muniid"));
           
           actionRequest.setIssueType_issueTypeID(rs.getInt("issuetype_issuetypeid"));
           // TODO integrate requestorID
           actionRequest.setSubmittedTimeStamp(rs.getTimestamp("submittedtimestamp").toLocalDateTime());
           
           actionRequest.setDateOfRecord(rs.getDate("dateofrecord").toLocalDate());
           actionRequest.setAddressOfConcern(rs.getString("addressofconcern"));
           actionRequest.setAddressZip(rs.getString("addresszip"));
           
           actionRequest.setNotAtAddress(rs.getBoolean("notataddress"));
           actionRequest.setRequestDescription(rs.getString("requestDescription"));
           actionRequest.setIsUrgent(rs.getBoolean("isurgent"));
           
           actionRequest.setCaseID(rs.getInt("caseid"));;
           actionRequest.setReqStat_requestStatusID(rs.getInt("reqStat_requestStatusID"));
           actionRequest.setCogInternalNotes(rs.getString("coginternalnotes"));
           
           actionRequest.setMuniInternalNotes(rs.getString("muniinternalnotes"));
           actionRequest.setPublicExternalNotes(rs.getString("publicexternalnotes"));
           
           // pulling from auxillary tables' columns from the SQL joins
           actionRequest.setIssueTypeString(rs.getString("typeName"));
           actionRequest.setMuniNameString(rs.getString("muniName"));
           actionRequest.setRequestStatusString(rs.getString("statusname"));
           }
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CEActionRequestIntegrator.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return actionRequest;
    } // close getActionRequest
    
    public LinkedList getCEActionRequestList(){
        LinkedList<ActionRequest> requestList = new LinkedList();
        String query = "SELECT requestpubliccc FROM public.codeenfactionrequest"; 
        ResultSet rs;
         
         int cc;
         try {
            Connection con = getPostgresCon();
            Statement stmt = con.createStatement();
            
            // Retrieve action data from postgres
           rs = stmt.executeQuery(query);
           while(rs.next()){
               cc = rs.getInt("requestpubliccc");
               requestList.add(getActionRequest(cc));
           } // close while
           rs.close();
           con.close();
               
         } catch (SQLException ex) {
                Logger.getLogger(CEActionRequestIntegrator.class.getName()).log(Level.SEVERE, null, ex);
        } // close try/catch
         
         return requestList;
         
    } // close method
} // close class
