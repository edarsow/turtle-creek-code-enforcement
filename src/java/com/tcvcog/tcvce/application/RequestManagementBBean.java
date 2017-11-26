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
package com.tcvcog.tcvce.application;

import java.util.LinkedList;
import javax.faces.component.html.HtmlDataTable;
import org.primefaces.component.datatable.DataTable;
import com.tcvcog.tcvce.entities.ActionRequest;
import com.tcvcog.tcvce.integration.CEActionRequestIntegrator;
import javax.faces.event.ActionEvent;

/**
 *
 * @author sylvia
 */
public class RequestManagementBBean {
    
    private LinkedList<ActionRequest> requestList;
    private DataTable requestTable;
    private String currentRequestCC;
    private ActionRequest selectedRequest;
    
    /**
     * Creates a new instance of RequestManagementBBean
     */
    public RequestManagementBBean() {
    }

    // action listener method for managing requests by COG staff
    public void manage(ActionEvent event){
        System.out.println("inside action listener for managing request");
        //ActionRequest currentRequest = (ActionRequest) requestTable.getRowData();
        currentRequestCC = String.valueOf(selectedRequest.getRequestPublicCC());
        
    }
    
    /**
     * @return the requestList
     */
    public LinkedList getRequestList() {
        CEActionRequestIntegrator integrator = new CEActionRequestIntegrator();
        return integrator.getCEActionRequestList();
    }

    /**
     * @param requestList the requestList to set
     */
    public void setRequestList(LinkedList requestList) {
        this.requestList = requestList;
    }

    /**
     * @return the requestTable
     */
    public DataTable getRequestTable() {
        return requestTable;
    }

    /**
     * @param requestTable the requestTable to set
     */
    public void setRequestTable(DataTable requestTable) {
        this.requestTable = requestTable;
    }

    /**
     * @return the currentRequestCC
     */
    public String getCurrentRequestCC() {
        return currentRequestCC;
    }

    /**
     * @param currentRequestCC the currentRequestCC to set
     */
    public void setCurrentRequestCC(String currentRequestCC) {
        this.currentRequestCC = currentRequestCC;
    }

    /**
     * @return the selectedRequest
     */
    public ActionRequest getSelectedRequest() {
        return selectedRequest;
    }

    /**
     * @param selectedRequest the selectedRequest to set
     */
    public void setSelectedRequest(ActionRequest selectedRequest) {
        this.selectedRequest = selectedRequest;
    }
    
}
