package com.fnz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.fnz.VO.FinshedProductVO;
import com.fnz.common.CommonConstants;
import com.fnz.common.SQLConstants;
import com.fnz.exception.DataAlreadyExistException;

public class InventoryDAO 
{
	public void insertRawMaterials(String rawMaterial,String unit) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		Class.forName(CommonConstants.DRIVERNAME);
		
		String sDbUrl = CommonConstants.sJdbc + ":" + CommonConstants.DB_LOCATION + CommonConstants.sTempDb;
		
		try 
		{
			conn = DriverManager.getConnection(sDbUrl);
			pstmt = conn.prepareStatement(SQLConstants.INSERT_DB_RAW_MATERIALS);
			
			pstmt.setQueryTimeout(CommonConstants.TIMEOUT);
				
			pstmt.setString(1, rawMaterial);
			pstmt.setString(2, unit);
			pstmt.execute();
		}
		catch (Exception e) 
		{
			throw new DataAlreadyExistException();
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
		

		public ObservableList<String> fetchRawMaterials() throws Exception
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			ObservableList<String> list = FXCollections.observableArrayList();
			
			
			Class.forName(CommonConstants.DRIVERNAME);
			
			String sDbUrl = CommonConstants.sJdbc + ":" + CommonConstants.DB_LOCATION + CommonConstants.sTempDb;
			
			try 
			{
				conn = DriverManager.getConnection(sDbUrl);
				pstmt = conn.prepareStatement(SQLConstants.FETCH_DB_RAW_MATERIALS);
				
				pstmt.setQueryTimeout(CommonConstants.TIMEOUT);
				resultSet = pstmt.executeQuery();
				
				while(resultSet.next())
				{
					list.add(resultSet.getString(1));
				}
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
				if(resultSet != null)
				{
					resultSet.close();
				}
			}
			return list;
		}
		
		
		public void deleteRawMaterials(String rawMaterial) throws Exception
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			
			
			Class.forName(CommonConstants.DRIVERNAME);
			
			String sDbUrl = CommonConstants.sJdbc + ":" + CommonConstants.DB_LOCATION + CommonConstants.sTempDb;
			
			try 
			{
				conn = DriverManager.getConnection(sDbUrl);
				pstmt = conn.prepareStatement(SQLConstants.DELETE_RAW_MATERIALS);
				
				pstmt.setQueryTimeout(CommonConstants.TIMEOUT);
				
				pstmt.setString(1, rawMaterial);
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
				if(resultSet != null)
				{
					resultSet.close();
				}
			}
		}
		public void addProduction(int bricksProduced, String storageLocation,String dateProduction) throws Exception 
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			ObservableList<String> list = FXCollections.observableArrayList();
			
			
			Class.forName(CommonConstants.DRIVERNAME);
			
			String sDbUrl = CommonConstants.sJdbc + ":" + CommonConstants.DB_LOCATION + CommonConstants.sTempDb;
			
			try 
			{
				conn = DriverManager.getConnection(sDbUrl);
				pstmt = conn.prepareStatement(SQLConstants.INSERT_PRODUCTION_INVENTORY);
				
				pstmt.setQueryTimeout(CommonConstants.TIMEOUT);
				
				pstmt.setString(1, dateProduction);
				pstmt.setInt(2, bricksProduced);
				pstmt.setString(3, "");
				pstmt.setString(4, storageLocation);
				pstmt.setString(5, "Available");
				
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
				if(resultSet != null)
				{
					resultSet.close();
				}
			}
		}
		
		public ObservableList<FinshedProductVO> fetchProduction() throws Exception
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			ObservableList<FinshedProductVO> list = FXCollections.observableArrayList();
			FinshedProductVO finshedProductVO = new FinshedProductVO();
			
			
			Class.forName(CommonConstants.DRIVERNAME);
			
			String sDbUrl = CommonConstants.sJdbc + ":" + CommonConstants.DB_LOCATION + CommonConstants.sTempDb;
			
			try 
			{
				conn = DriverManager.getConnection(sDbUrl);
				pstmt = conn.prepareStatement(SQLConstants.FETCH_PRODUCTION_INVENTORY);
				
				pstmt.setQueryTimeout(CommonConstants.TIMEOUT);
				resultSet = pstmt.executeQuery();
				
				while(resultSet.next())
				{
					finshedProductVO = new FinshedProductVO();
					finshedProductVO.setDateOfProduction(resultSet.getString(2));
					finshedProductVO.setBricksProduced(resultSet.getInt(3));
					finshedProductVO.setDaysCured(resultSet.getString(4));
					finshedProductVO.setStorageSection(resultSet.getString(5));
					finshedProductVO.setStatus(resultSet.getString(6));
					list.add(finshedProductVO);
				}
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
				if(resultSet != null)
				{
					resultSet.close();
				}
			}
			return list;
		}
}
