package com.fnz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import com.fnz.common.CommonConstants;
import com.fnz.common.SQLConstants;
import com.fnz.exception.DataAlreadyExistException;

public class TaxDAO 
{
	public void insertTaxDetails(String taxName,Double value ) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		Class.forName(CommonConstants.DRIVERNAME);
		String sDbUrl = CommonConstants.sJdbc + ":" + CommonConstants.DB_LOCATION + CommonConstants.sTempDb;
		
		try 
		{
			conn = DriverManager.getConnection(sDbUrl);
			pstmt = conn.prepareStatement(SQLConstants.INSERT_TAX_TABLE);
			
			pstmt.setQueryTimeout(CommonConstants.TIMEOUT);
				
			pstmt.setString(1, taxName);
			pstmt.setString(2, value.toString());
			pstmt.execute();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn !=null )
			{
				conn.close();
			}
			if(pstmt != null )
			{
				pstmt.close();
			}
		
		}
	}
	
	public ObservableMap<String, Double> fetchTaxDetails() throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ObservableList<HashMap<String,Double>> taxList = FXCollections.observableArrayList();
		ObservableMap<String, Double> taxMap = FXCollections.observableHashMap();
		
		Class.forName(CommonConstants.DRIVERNAME);
		
		String sDbUrl = CommonConstants.sJdbc + ":" + CommonConstants.DB_LOCATION + CommonConstants.sTempDb;
		
		try 
		{
			conn = DriverManager.getConnection(sDbUrl);
			pstmt = conn.prepareStatement(SQLConstants.FETCH_TAX_TABLE);
			
			pstmt.setQueryTimeout(CommonConstants.TIMEOUT);	
			resultSet =	pstmt.executeQuery();
			
			while(resultSet.next())
			{
				taxMap.put(resultSet.getString("TAX_NAME"),Double.parseDouble(resultSet.getString("TAX_AMOUNT")));
			}
		}
		catch (Exception e) 
		{
			throw new Exception();
		}
		finally
		{
			if(conn !=null )
			{
				conn.close();
			}
			if(pstmt != null )
			{
				pstmt.close();
			}
			if(resultSet != null)
			{
				resultSet.close();
			}
		}
		return taxMap;
	}
}
