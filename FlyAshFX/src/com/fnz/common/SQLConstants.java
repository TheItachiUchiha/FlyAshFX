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
	
	
	public static final String CREATE_CUSTOMER = "CREATE TABLE if not exists CUSTOMER (cust_id INTEGER PRIMARY KEY AUTOINCREMENT,CUST_NAME text NOT NULL," +
			"CUST_ADD text, CUST_PHONE text, CUST_EMAIL text)";
	
	public static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER values (NULL,?,?,?,?)";
	
	public static final String CREATE_CLIENT_ORDER = "CREATE TABLE if not exists CLIENT_ORDER (order_id INTEGER PRIMARY KEY AUTOINCREMENT,DATE_OF_ORDER text NOT NULL," +
			"CUST_NAME text, ORDER_A text, AMOUNT text, ADVANCE text, DATE_OF_DELIVERY text, STATUS text)";
			//"FOREIGN KEY (CUST_NAME) REFERENCES CUSTOMER(CUST_NAME))";
	
	public static final String INSERT_CLIENT_ORDER = "INSERT INTO CLIENT_ORDER values (NULL,?,?,?,?,?,?,?)";
	
	public static final String FETCH_CLIENT_ORDER = "SELECT * FROM CLIENT_ORDER ";
}
