package com.fnz.service;

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
import com.fnz.dao.DBInteraction;
import com.fnz.dao.InventoryDAO;
import com.fnz.dao.TaxDAO;
import com.fnz.exception.DataAlreadyExistException;

public class TaxService 
{
	
	static TaxDAO taxDAO;

	public TaxService()
	{
		taxDAO = new TaxDAO();
	}
	public void insertTaxDetails(String taxName,Double value ) throws Exception
	{
		try 
		{
			taxDAO.insertTaxDetails(taxName, value);
		}
		catch (Exception e) 
		{
			throw new DataAlreadyExistException();
		}
	}
	
	
	public ObservableMap<String, Double> fetchTaxDetails() throws Exception
	{
		ObservableMap<String, Double> taxMap = FXCollections.observableHashMap();
		try 
		{
			taxMap = taxDAO.fetchTaxDetails();
		}
		catch (Exception e) 
		{
			throw new Exception();
		}
		return taxMap;
	}
}
