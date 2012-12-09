package com.fnz.common;

public class SQLConstants
{
	public static final String CREATE_DB_RAW_MATERIALS = "CREATE TABLE if not exists RAW_MATERIALS (RAW_MATERIALS_NAME text PRIMARY KEY)";
	
	public static final String CREATE_DB_RAW_MATERIALS_INVENTORY = "CREATE TABLE if not exists RAW_MATERIALS_INVENTORY (id INTEGER PRIMARY KEY AUTOINCREMENT,NAME text," +
			"FOREIGN KEY (NAME) REFERENCES RAW_MATERIALS(RAW_MATERIALS_NAME))";
	
	public static final String INSERT_DB_RAW_MATERIALS = "INSERT INTO RAW_MATERIALS values (?)";
	
	public static final String FETCH_DB_RAW_MATERIALS = "SELECT RAW_MATERIALS_NAME FROM RAW_MATERIALS";
	
	
}
