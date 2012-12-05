package com.fnz.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.fnz.exception.DataAlreadyExistException;
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
				//stmt.execute("drop table RAW_MATERIALS");
				stmt.executeUpdate( SQLConstants.CREATE_DB_RAW_MATERIALS );
				stmt.executeUpdate( SQLConstants.CREATE_DB_RAW_MATERIALS_INVENTORY );
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
	
	public void insertRawMaterials(String rawMaterial) throws Exception
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
		
		@SuppressWarnings("finally")
		public List<String> fetchRawMaterials() throws Exception
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			List<String> list = new ArrayList<String>();
			
			
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
				return list;
			}
		}
	}
