package com.fnz.common;

public class SQLConstants
{
	
	public static final String CREATE_STATIC_UNIT = "CREATE TABLE if not exists STATIC_UNIT (UNIT text PRIMARY KEY)";
	
	
	public static final String CREATE_DB_RAW_MATERIALS = "CREATE TABLE if not exists RAW_MATERIALS (RAW_MATERIALS_NAME text PRIMARY KEY NOT NULL,RAW_MATERIAL_UNIT text,"+
			"FOREIGN KEY (RAW_MATERIAL_UNIT) REFERENCES STATIC_UNIT(UNIT))";
	
	public static final String CREATE_PRODUCTION_INVENTORY = "CREATE TABLE if not exists PRODUCTION_INVENTORY (id INTEGER PRIMARY KEY AUTOINCREMENT, DATE_OF_PRODUCTION text,"+
	"NO_OF_BRICKS_PRODUCED INTEGER, NO_OF_DAY_CURED INTEGER, STORAGE_SECTION text, STATUS text)";
			
	
	public static final String CREATE_DB_RAW_MATERIALS_INVENTORY = "CREATE TABLE if not exists RAW_MATERIALS_INVENTORY (id INTEGER PRIMARY KEY AUTOINCREMENT,NAME text," +
			"FOREIGN KEY (NAME) REFERENCES RAW_MATERIALS(RAW_MATERIALS_NAME))";
	
	public static final String INSERT_DB_RAW_MATERIALS = "INSERT INTO RAW_MATERIALS values (?,?)";
	
	public static final String FETCH_DB_RAW_MATERIALS = "SELECT RAW_MATERIALS_NAME FROM RAW_MATERIALS";
	
	
	public static final String INSERT_STATIC_UNIT = "INSERT INTO STATIC_UNIT values ('Kilogram')";
	
	public static final String FETCH_STATIC_UNIT = "select UNIT from STATIC_UNIT"; 
	
	public static final String DELETE_RAW_MATERIALS = "DELETE FROM RAW_MATERIALS where RAW_MATERIALS_NAME =?";
	
	public static final String INSERT_PRODUCTION_INVENTORY = "INSERT INTO PRODUCTION_INVENTORY values (NULL,?,?,?,?,?)";
	
	public static final String FETCH_PRODUCTION_INVENTORY = "SELECT * FROM PRODUCTION_INVENTORY ";
	
	
	public static final String CREATE_CUSTOMER = "CREATE TABLE if not exists CUSTOMER (CUST_ID text PRIMARY KEY,CUST_NAME text UNIQUE NOT NULL," +
			"CUST_ADD text, CUST_PHONE text, CUST_EMAIL text)";
	
	public static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER values (?,?,?,?,?)";
	
	public static final String CREATE_CLIENT_ORDER = "CREATE TABLE if not exists CLIENT_ORDER (ORDER_ID text PRIMARY KEY,DATE_OF_ORDER text NOT NULL," +
			"CUST_NAME text, ORDER_A INTEGER,ORDER_D INTEGER,AMOUNT REAL, ADVANCE REAL, DATE_OF_DELIVERY text, STATUS text,"+
			"FOREIGN KEY (CUST_NAME) REFERENCES CUSTOMER(CUST_NAME))";
	
	public static final String INSERT_CLIENT_ORDER = "INSERT INTO CLIENT_ORDER values (?,?,?,?,?,?,?,?,?)";
	
	public static final String FETCH_CLIENT_ORDER = "SELECT * FROM CLIENT_ORDER ";
	
	public static final String FETCH_LATEST_ORDER = "SELECT max(rowid) as row from CLIENT_ORDER";
	
	public static final String FETCH_LATEST_CUST = "SELECT max(rowid) as row from CUSTOMER";
	
	public static final String CREATE_VENDOR = "CREATE TABLE if not exists VENDOR (VENDOR_ID text PRIMARY KEY,VENDOR_NAME text UNIQUE NOT NULL," +
			"VENDOR_ADD text, VENDOR_PHONE text, VENDOR_EMAIL text)";
	
	public static final String INSERT_VENDOR = "INSERT INTO VENDOR values (?,?,?,?,?)";
	
	public static final String CREATE_VENDOR_ORDER = "CREATE TABLE if not exists VENDOR_ORDER (PURCHASE_ID text PRIMARY KEY,DATE_OF_ORDER text NOT NULL," +
			"VENDOR_NAME text, ORDER_A INTEGER,ORDER_D INTEGER, AMOUNT REAL, ADVANCE REAL, DATE_OF_DELIVERY text, STATUS text,"+
			"FOREIGN KEY (VENDOR_NAME) REFERENCES VENDOR(VENDOR_NAME))";
	
	public static final String INSERT_VENDOR_ORDER = "INSERT INTO VENDOR_ORDER values (?,?,?,?,?,?,?,?,?)";
	
	public static final String FETCH_VENDOR_ORDER = "SELECT * FROM VENDOR_ORDER ";
	
	public static final String FETCH_LATEST_VENDOR_ORDER = "SELECT max(rowid) as row from VENDOR_ORDER";
	
	public static final String FETCH_LATEST_VENDOR = "SELECT max(rowid) as row from VENDOR";
	
	public static final String FETCH_VENDORS = "SELECT VENDOR_NAME from VENDOR_ORDER where STATUS <> '"+CommonConstants.STATUS_RECEIVED+"' AND STATUS <> '"+CommonConstants.STATUS_CANCELLED+"'";
	
	public static final String FETCH_VENDOR_PURCHASES = "SELECT PURCHASE_ID from VENDOR_ORDER where VENDOR_NAME = ? AND STATUS <> '"+CommonConstants.STATUS_RECEIVED+"' AND STATUS <> '"+CommonConstants.STATUS_CANCELLED+"'";
	
	public static final String FETCH_CLIENTS = "SELECT CUST_NAME from CLIENT_ORDER where STATUS <> '"+CommonConstants.STATUS_DELIVERED+"' AND STATUS <> '"+CommonConstants.STATUS_CANCELLED+"'";
	
	public static final String FETCH_CLIENT_ORDERS = "SELECT ORDER_ID from CLIENT_ORDER where CUST_NAME = ? AND STATUS <> '"+CommonConstants.STATUS_DELIVERED+"' AND STATUS <> '"+CommonConstants.STATUS_CANCELLED+"'";
	
	public static final String CANCEL_CLIENT_ORDERS = "UPDATE CLIENT_ORDER SET STATUS = 'Cancelled' where ORDER_ID = ?";
	
	public static final String CANCEL_VENDOR_ORDERS = "UPDATE VENDOR_ORDER SET STATUS = 'Cancelled' where PURCHASE_ID = ?";
	
	public static final String FETCH_CLIENT_ORDER_DETAILS = "SELECT * FROM CLIENT_ORDER WHERE ORDER_ID = ?";
	
	public static final String FETCH_VENDOR_ORDER_DETAILS = "SELECT * FROM VENDOR WHERE PURCHASE_ID = ?";
	
	public static final String UPDATE_CLIENT_ORDER_DETAILS = "UPDATE CLIENT_ORDER SET ORDER_D = ? , ADVANCE = ?, STATUS = ? WHERE ORDER_ID = ?";
	
	public static final String UPDATE_VENDOR_PURCHASE_DETAILS = "UPDATE VENDOR_ORDER SET ORDER_D = ? , ADVANCE = ? WHERE PURCHASE_ID = ?";
}
