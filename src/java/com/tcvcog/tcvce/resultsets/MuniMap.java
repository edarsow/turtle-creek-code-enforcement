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
package com.tcvcog.tcvce.resultsets;

import java.sql.*;
import org.postgresql.jdbc3.Jdbc3PoolingDataSource;
import java.util.HashMap;
import com.tcvcog.tcvce.util.Constants;
import com.tcvcog.tcvce.application.BackingBeanUtils;

/**
 *
 * @author cedba
 */

public class MuniMap extends BackingBeanUtils{
    
    private HashMap municipalities;

    /**
     * Creates a new instance of MuniSet
     */
    public MuniMap() {
        
    }
    
    /**
     * @return the muniset
     */
    public HashMap getMunicipalityMap() {
        HashMap<String, Integer> muniMap = new HashMap<>();
        
        Connection con = getPostgresCon();
        
     
        
        String query = "SELECT municipalityID, muniName FROM municipality;";
        ResultSet rs;
 
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                muniMap.put(rs.getString("muniName"), rs.getInt("municipalityID"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        municipalities = muniMap;
        
        return municipalities;
    } // close method

    /**
     * @param municipalityMap the municipalityMap to set
     */
    public void setMunicipalityMap(HashMap municipalityMap) {
        this.municipalities = municipalityMap;
    }
  
} // close class
