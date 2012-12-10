package com.fnz.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.fnz.VO.CustomerVO;
import com.fnz.VO.OrderVO;
import com.fnz.dao.OrderDAO;

public class OrderService 
{
	OrderDAO orderDAO = new OrderDAO();
	public void addOrder(CustomerVO customerVO, OrderVO orderVO)
	{
		try
		{
			orderDAO.addOrder(customerVO, orderVO);
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
}
