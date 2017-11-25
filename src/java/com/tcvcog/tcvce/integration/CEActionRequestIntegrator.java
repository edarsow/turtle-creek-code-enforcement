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
    
    public void submitCEActionRequest(ActionRequest request){
        System.out.println("Writing Action Request Into DB");
//        Logger.getLogger(CEActionRequestIntegrator.class.getName()).log(Level.INFO, null, "Attempting ce request submission");
        
        StringBuilder qbuilder = new StringBuilder();
        qbuilder.append("INSERT INTO public.codeEnfActionRequest ("
//                + "requestid, "
                + "issuetype_issuetypeid, "
                + "actrequestor_requestorID, "
                + "addressline1, "
//                + "notataddress, "
                + "muni_muniid, "
                + "requestdescription " 
//                + "isurgent, "
//                + "dateofrecord, "
//                + "retrievalnumber, "
//                + "reqstat_requeststatusid, "
//                + "requestdate, "
//                + "requesttime, "
//                + "internalnotes");
                + ") ");
        qbuilder.append("VALUES (");
//        qbuilder.append("DEFAULT ,");  // DB creates with id sequence
        qbuilder.append(request.getIssueType_issueTypeID());
        qbuilder.append(" , ");
        
        qbuilder.append("1, ");
        
        qbuilder.append(" \'");
        qbuilder.append(request.getAddressLine1());
        qbuilder.append(" \'");
        
        qbuilder.append(" , ");
        qbuilder.append(request.getMuni_muniID());
        qbuilder.append(" , ");
        
        qbuilder.append(" \'");
        qbuilder.append(request.getRequestDescription());
        qbuilder.append(" \'");
        
        qbuilder.append(");"); // close INSERT
        System.out.println(qbuilder.toString());
        
        // Complete INSERT statement into codeEnfActionRequest table
        
        /*
        INSERT INTO public.codeenfactionrequest(
            requestid, issuetype_issuetypeid, actrequestor_requestorid, caseid, 
            addressline1, notataddress, muni_muniid, requestdescription, 
            isurgent, dateofrecord, retrievalnumber, reqstat_requeststatusid, 
            requestdate, requesttime, internalnotes)
    VALUES (?, ?, ?, ?, 
            ?, ?, ?, ?, 
            ?, ?, ?, ?, 
            ?, ?, ?);

        */
        
        try {
            Connection con = getPostgresCon();
            Statement stmt = con.createStatement();
            
            // INSERT REQUEST INTO DATABASE
            stmt.executeUpdate(qbuilder.toString());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CEActionRequestIntegrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } // close submitActionRequest
    
    public ActionRequest getActionRequest(int actionRequestId){
        ActionRequest req = new ActionRequest();
        StringBuilder sb = new StringBuilder();
        
        sb.append("SELECT requestid, issuetype_issuetypeid, actionRqstIssueType.typeName, caseid, \n" +
"       addressline1, notataddress, muni_muniid, muniName, requestdescription, \n" +
"       isurgent, dateofrecord, retrievalnumber, reqstat_requeststatusid, statusName,\n" +
"       requestdate, requesttime, coginternalnotes, muniinternalnotes, \n" +
"       publicexternalnotes, actrequestor_requestorid, actionRequestorType_typeID, actionRequestorType.typeName, \n" +
"       requestorFName, requestorLName, actionrequestor.phone, email, address_street, address_city, address_zip, anonymous\n" +
"	FROM public.codeenfactionrequest INNER JOIN public.actionrequestor ON actrequestor_requestorid = requestorid\n" +
"		INNER JOIN actionrqstissuetype ON issuetype_issuetypeid = issuetypeid\n" +
"		INNER JOIN requestStatus ON reqStat_requestStatusID = requestStatusID\n" +
"		INNER JOIN municipality ON muni_muniID = municipalityID\n" +
"		INNER JOIN actionRequestorType ON actionRequestorType_typeID = typeID ");
        sb.append("WHERE requestid = ");
        sb.append(actionRequestId);
        sb.append(";");
        
        ResultSet rs;
         try {
            Connection con = getPostgresCon();
            Statement stmt = con.createStatement();
            
            // Retrieve action data from postgres
           rs = stmt.executeQuery(sb.toString());
           rs.next();
           req.setRequestID(rs.getInt("requestid"));
           req.setIssueType_issueTypeID(rs.getInt("issuetype)issuetypeid"));
           req.setRequestID(rs.getInt("requestid"));
           
           
           
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CEActionRequestIntegrator.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
        
        
        return req;
    }
    
    
}
