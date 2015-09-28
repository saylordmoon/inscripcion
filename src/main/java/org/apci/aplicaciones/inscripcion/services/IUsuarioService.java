package org.apci.aplicaciones.inscripcion.services;

import org.apci.aplicaciones.inscripcion.models.Usuario;

public interface IUsuarioService {
	
	Usuario getByName(String pUsuario);

	Boolean validate(String pUsuario,String pHash);

}