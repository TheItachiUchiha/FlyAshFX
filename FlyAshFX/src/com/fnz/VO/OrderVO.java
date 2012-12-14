package com.fnz.VO;

public class OrderVO
{
	private String orderNo;
	private String date;
	private String customerName;
	private int orderQuantity;
	private int orderDelivered;
	private int orderPending;
	private double amount;
	private double advance;
	private String dod;
	private String status;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public int getOrderDelivered() {
		return orderDelivered;
	}
	public void setOrderDelivered(int orderDelivered) {
		this.orderDelivered = orderDelivered;
	}
	public int getOrderPending() {
		return orderPending;
	}
	public void setOrderPending(int orderPending) {
		this.orderPending = orderPending;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAdvance() {
		return advance;
	}
	public void setAdvance(double advance) {
		this.advance = advance;
	}
	public String getDod() {
		return dod;
	}
	public void setDod(String dod) {
		this.dod = dod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
