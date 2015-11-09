package org.apci.aplicaciones.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private final String connectionUrl = "jdbc:sqlserver://192.168.1.10;databaseName=DB_APCIMRE;user=sa;password=apci2005";
	private final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private Connection con;
	
	public Conexion() {} 
	
	public void close()
	{
		if (con != null)
		{
			try 
			{
				con.close();
				con = null;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public Connection get(){
		Connection con = null;
		try{
			
			Class.forName(driver);
			con = DriverManager.getConnection(connectionUrl);
			
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();		
		} 
		catch(Exception e) 
		{	
			e.printStackTrace();
		}	
		
		return con;
	}
}
