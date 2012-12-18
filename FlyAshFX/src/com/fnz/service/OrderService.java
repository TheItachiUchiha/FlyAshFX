package com.fnz.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.fnz.VO.CustomerVO;
import com.fnz.VO.OrderVO;
import com.fnz.VO.VendorVO;
import com.fnz.dao.OrderDAO;

public class OrderService 
{
	OrderDAO orderDAO = new OrderDAO();
	public void addOrder(CustomerVO customerVO, OrderVO orderVO, ObservableList<String> clientList)
	{
		try
		{
			orderDAO.addOrder(customerVO, orderVO, clientList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ObservableList<OrderVO> viewOrder()
	{
		ObservableList<OrderVO> list = FXCollections.observableArrayList();
		try
		{
			list = orderDAO.viewOrder();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public void addVendorOrder(VendorVO vendorVO, OrderVO orderVO, ObservableList<String> vendorList) 
	{
		try
		{
			orderDAO.addVendorOrder(vendorVO, orderVO, vendorList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ObservableList<OrderVO> viewVendorOrder()
	{
		ObservableList<OrderVO> list = FXCollections.observableArrayList();
		try
		{
			list = orderDAO.viewVendorOrder();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public ObservableList<String> viewVendors()
	{
		ObservableList<String> list = FXCollections.observableArrayList();
		try
		{
			list = orderDAO.viewVendors();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public ObservableList<String> viewPurchaseList(String vendorName)
	{
		ObservableList<String> list = FXCollections.observableArrayList();
		try
		{
			list = orderDAO.viewPurchaseList(vendorName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public ObservableList<String> viewClients()
	{
		ObservableList<String> list = FXCollections.observableArrayList();
		try
		{
			list = orderDAO.viewClients();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public ObservableList<String> viewOrderList(String customer)
	{
		ObservableList<String> list = FXCollections.observableArrayList();
		try
		{
			list = orderDAO.viewOrderList(customer);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public void cancelClientOrder(String orderNumber)
	{
		try
		{
			orderDAO.cancelClientOrder(orderNumber);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void cancelVendorOrder(String orderNumber)
	{
		try
		{
			orderDAO.cancelVendorOrder(orderNumber);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public OrderVO fetchClientOrderDetails(String orderNo) throws Exception
	{
		OrderVO orderVO = new OrderVO();
		try
		{
			orderVO = orderDAO.fetchClientOrderDetails(orderNo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderVO; 
	}
	public OrderVO fetchVendorOrderDetails(String orderNo) throws Exception
	{
		OrderVO orderVO = new OrderVO();
		try
		{
			orderVO = orderDAO.fetchVendorOrderDetails(orderNo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderVO; 
	}
	
	public void editClientOrder(String orderNo, int quantityDelivered, double amountReceived ) throws Exception
	{
		try
		{
			orderDAO.editClientOrder(orderNo, quantityDelivered, amountReceived);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void editVendorOrder(String orderNo, int quantityDelivered, double amountReceived ) throws Exception
	{
		try
		{
			orderDAO.editVendorOrder(orderNo, quantityDelivered, amountReceived);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public ObservableList<CustomerVO> fetchClientDetails() throws Exception
	{
		ObservableList<CustomerVO> list=FXCollections.observableArrayList();
		try 
		{
			list=orderDAO.fetchClientDetails();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	public ObservableList<VendorVO> fetchVendorDetails() throws Exception
	{
		ObservableList<VendorVO> list=FXCollections.observableArrayList();
		try 
		{
			list=orderDAO.fetchVendorDetails();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return list;
	}
}
