package com.fnz.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.fnz.VO.FinshedProductVO;
import com.fnz.dao.DBInteraction;
import com.fnz.dao.InventoryDAO;

public class InventoryService 
{
	static InventoryDAO inventoryDAO;
	static DBInteraction dbInteraction;
	public InventoryService()
	{
		inventoryDAO = new InventoryDAO();
	}
	public void deleteRawMaterial(String rawMaterial)
	{
		try 
		{
			inventoryDAO.deleteRawMaterials(rawMaterial);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public ObservableList<String> fetchUnit() throws Exception
	{
		ObservableList<String> list = FXCollections.observableArrayList();
		try
		{
			list = dbInteraction.fetchUnit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertRawMaterials(String rawMaterial,String unit) throws Exception
	{
		inventoryDAO.insertRawMaterials(rawMaterial, unit);
	}
	
	public ObservableList<String> fetchRawMaterials() throws Exception
	{
		ObservableList<String> list = FXCollections.observableArrayList();
		try
		{
			list = inventoryDAO.fetchRawMaterials();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public void addProduction(int bricksProduced, String storageLocation, String dateProduction) 
	{
		try 
		{
			inventoryDAO.addProduction(bricksProduced, storageLocation, dateProduction);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	public static ObservableList<FinshedProductVO> viewFinishedProduct() 
	{
		ObservableList<FinshedProductVO> list = FXCollections.observableArrayList();;
		try
		{
			list = inventoryDAO.fetchProduction();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
