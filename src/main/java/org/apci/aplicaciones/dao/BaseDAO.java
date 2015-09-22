package org.apci.aplicaciones.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apci.aplicaciones.util.Conexion;
import org.apci.aplicaciones.util.DaoUtil;
import org.apci.aplicaciones.util.sql.Call;
import org.apci.aplicaciones.util.sql.Insert;
import org.apci.aplicaciones.util.sql.Select;
import org.apci.aplicaciones.util.sql.Update;

public class BaseDAO {
	
	private Conexion conexion;
	
	public BaseDAO()
	{
		conexion = new Conexion();
	}
	
	// Select con parametros y mapea el resultado a la clase
	protected <T> List<T> query(String pSQL, Class<T> pClassType, Object...pParameters)
	{
		List<T> result= null;
		try 
		{
			PreparedStatement statement = conexion.get().prepareStatement(pSQL);		
			statement = DaoUtil.setStatementParameters(statement, pParameters);
			ResultSet rs = statement.executeQuery();
			
			result =  DaoUtil.mapper(rs,pClassType);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			conexion.close();
		}
		
		return result;
	}
	// Select sin parametros y mapea el resultado a la clase
	protected <T> List<T> query(String sql, Class<T> pClassType) 
	{
		try 
		{
			PreparedStatement statement = conexion.get().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			return DaoUtil.mapper(rs,pClassType);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			conexion.close();
		}
		
		return null;
	}
	
	// Select
	protected <T> List<T> select(Class<T> pClassType)
	{
		Select select = new Select(pClassType);
		String sql = select.getSql();
		return query(sql,pClassType);
	}
	
	protected <T> List<T> selectById(Class<T> pClassType,int pId)
	{
		Select select = new Select(pClassType);
		select.wherePrimaryKey();
		String sql = select.getSql();
		return query(sql,pClassType,pId);
	}
	
	protected <T> List<T> selectWhere(Class<T> pClassType, String pColumn , Object pValue)
	{
		Select select = new Select(pClassType);
		select.where(pColumn);
		String sql = select.getSql();
		return query(sql,pClassType,pValue);
	}
	
	protected <T> List<T> selectLike(Class<T> pClassType,String pColumn, Object pValue)
	{
		Select select = new Select(pClassType);
		select.whereLike(pColumn);
		String sql = select.getSql();
		return query(sql,pClassType,pValue);
	}
	
	protected <T> List<T> selectLikeAnd(Class<T> pClassType,String pColumn, Object pValue,String pColumnAnd,Object pValueAnd)
	{
		Select select = new Select(pClassType);
		select.whereLike(pColumn);
		select.and(pColumnAnd);
		String sql = select.getSql();
		return query(sql,pClassType,pValue,pValueAnd);
	}
	
	// Insert
	public int insert(Object pDataObject){
		
		int generatedID = -1;
		Class<?> classType = pDataObject.getClass();
		
		try 
		{
			Insert insert = new Insert(classType);
			
			String sql = insert.getSql();
			
			PreparedStatement statement = conexion.get().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			statement = DaoUtil.setStatementParameters(statement, pDataObject);
			
			statement.executeUpdate();
			
			ResultSet rs = statement.getGeneratedKeys();

			if(rs != null && rs.next()){
                generatedID = rs.getInt(1);
            }
			statement.close();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			conexion.close();
		}
		
		return generatedID;
	} 
	// Update
	public boolean update(Object pDataObject)
	{
		boolean result = false;
		Class<?> classType = pDataObject.getClass();
		try 
		{
			Update update = new Update(classType);
			
			String sql = update.getSql();
			
			PreparedStatement statement = conexion.get().prepareStatement(sql);
			
			statement = DaoUtil.setStatementParameters(statement, pDataObject);
						
			statement = DaoUtil.setStatementPrimaryKeyParameter(statement, pDataObject, 4);
			
			statement.executeUpdate();
			
			statement.close();
			
			result = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			conexion.close();
		}
		
		return result;
	}

	// Stored Procedures sin resultados
	public boolean call(String pStoredProcedureName,Object pDataObject)
	{
		boolean result = false;
		Class<?> spClassType = pDataObject.getClass();
		CallableStatement statement = null;
		try
		{
			Call call = new Call(pStoredProcedureName,spClassType);
			String sql = call.getSql();
			statement = conexion.get().prepareCall(sql);
			// Set parameters
			
			statement.execute();
		
			result = true;
			
			statement.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			conexion.close();
		}
				
		return result;
	}
	//Stored procedures con  resultados (pClassType)
	public <T> List<T> call(String pStoredProcedureName,Object pDataObject, Class<T> pClassType)
	{
		Class<?> spClassType = pDataObject.getClass();
		CallableStatement statement = null;
		try
		{
			Call call = new Call(pStoredProcedureName,spClassType);
			String sql = call.getSql();
			statement = conexion.get().prepareCall(sql);
			//Set parameters 
			
			boolean hasResult = statement.execute();
			
			if (hasResult) {
				ResultSet rs = statement.getResultSet();
				return DaoUtil.mapper(rs,pClassType);
			}
			statement.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			conexion.close();
		}
		return null;
	}

}
