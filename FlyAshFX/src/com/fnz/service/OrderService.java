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
	public ObservableList<String> viewOrderList(String clientName)
	{
		ObservableList<String> list = FXCollections.observableArrayList();
		try
		{
			list = orderDAO.viewOrderList(clientName);
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
}
