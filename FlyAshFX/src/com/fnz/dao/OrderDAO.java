package com.fnz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.fnz.VO.CustomerVO;
import com.fnz.VO.FinshedProductVO;
import com.fnz.VO.OrderVO;
import com.fnz.common.CommonConstants;
import com.fnz.common.SQLConstants;

public class OrderDAO 
{
	
	/*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <addOrder(CustomerVO, OrderVO)><void><add an client order to DB>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */
	public void addOrder(CustomerVO customerVO, OrderVO orderVO) throws Exception 
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet resultSet = null;		
		
		Class.forName(CommonConstants.DRIVERNAME);
		
		String sDbUrl = CommonConstants.sJdbc + ":" + CommonConstants.DB_LOCATION + CommonConstants.sTempDb;
		
		try 
		{
			conn = DriverManager.getConnection(sDbUrl);
			pstmt = conn.prepareStatement(SQLConstants.INSERT_CUSTOMER);
			pstmt1 = conn.prepareStatement(SQLConstants.INSERT_CLIENT_ORDER);
			
			pstmt.setQueryTimeout(CommonConstants.TIMEOUT);
			
			pstmt.setString(1, customerVO.getCustomerName());
			pstmt.setString(2, customerVO.getCustomerAddress());
			pstmt.setString(3, customerVO.getCustomerPhone());
			pstmt.setString(4, customerVO.getCustomerEmail());
			pstmt.execute();
			
			pstmt1.setString(1, new Date().toString());
			pstmt1.setString(2, orderVO.getCustomerName());
			pstmt1.setString(3, orderVO.getOrderQuantity());
			pstmt1.setString(4, orderVO.getAmount());
			pstmt1.setString(5, orderVO.getAdvance());
			pstmt1.setString(6, orderVO.getDod());
			pstmt1.setString(6, orderVO.getStatus());
			
			pstmt1.execute();
			
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
			if(pstmt1 != null )
			{
				pstmt1.close();
			}
			if(resultSet != null)
			{
				resultSet.close();
			}
		}
	}

	/*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <viewOrder()><ObservableList<OrderVO>><view an client order from DB>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */
	public ObservableList<OrderVO> viewOrder() throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ObservableList<OrderVO> list = FXCollections.observableArrayList();
		OrderVO orderVO = new OrderVO();
		
		
		Class.forName(CommonConstants.DRIVERNAME);
		
		String sDbUrl = CommonConstants.sJdbc + ":" + CommonConstants.DB_LOCATION + CommonConstants.sTempDb;
		
		try 
		{
			conn = DriverManager.getConnection(sDbUrl);
			pstmt = conn.prepareStatement(SQLConstants.FETCH_CLIENT_ORDER);
			
			pstmt.setQueryTimeout(CommonConstants.TIMEOUT);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next())
			{
				orderVO = new OrderVO();
				orderVO.setDate(resultSet.getString(2));
				orderVO.setCustomerName(resultSet.getString(3));
				orderVO.setOrderQuantity(resultSet.getString(4));
				orderVO.setAmount(resultSet.getString(5));
				orderVO.setAdvance(resultSet.getString(6));
				orderVO.setStatus(resultSet.getString(7));
				list.add(orderVO);
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
