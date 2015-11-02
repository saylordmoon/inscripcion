package org.apci.aplicaciones.inscripcion.dao;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.Data;
import org.apci.aplicaciones.inscripcion.services.IDataService;

public class DataDAO extends BaseDAO implements IDataService {

	@Override
	public String add(String pData) {
		
		Data data = new Data();
		
		data.setText(pData);
		
		insert(data);
		
		return pData;
	}
}