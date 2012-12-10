package com.fnz.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import com.fnz.exception.DataAlreadyExistException;
import com.fnz.VO.FinshedProductVO;
import com.fnz.common.CommonConstants;
import com.fnz.common.SQLConstants;

public class DBInteraction 
{
	public void createDB() throws Exception
	{
		Connection conn = null;
		Statement stmt = null;
		Class.forName(CommonConstants.DRIVERNAME);
		
		String sDbUrl = CommonConstants.sJdbc + ":" +CommonConstants.DB_LOCATION + CommonConstants.sTempDb;
		
		//create Folder to store DB
		File dir=new File("/C:/"+"/FlyAsh");
		if(!dir.exists())
		{
			dir.mkdir();
		}
		
		//Creating tables if they don't exist
		
		try 
		{
			conn = DriverManager.getConnection(sDbUrl);
			stmt = conn.createStatement();
			
				stmt.setQueryTimeout(CommonConstants.TIMEOUT);
				stmt.execute(SQLConstants.CREATE_STATIC_UNIT);
				stmt.executeUpdate( SQLConstants.CREATE_DB_RAW_MATERIALS );
				stmt.executeUpdate( SQLConstants.CREATE_DB_RAW_MATERIALS_INVENTORY );
				stmt.execute(SQLConstants.INSERT_STATIC_UNIT);
				stmt.execute(SQLConstants.CREATE_PRODUCTION_INVENTORY);
				stmt.execute(SQLConstants.CREATE_CUSTOMER);
				stmt.execute(SQLConstants.CREATE_CLIENT_ORDER);
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
			if(stmt != null )
			{
				stmt.close();
			}
		
		}
	}	
	
	
		
		
		
		public ObservableList<String> fetchUnit() throws Exception
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
				pstmt = conn.prepareStatement(SQLConstants.FETCH_STATIC_UNIT);
				
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
	}
