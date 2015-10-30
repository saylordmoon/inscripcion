package org.apci.aplicaciones.inscripcion.dao;

import java.util.List;

import org.apci.aplicaciones.dao.BaseDAO;
import org.apci.aplicaciones.inscripcion.models.Usuario;
import org.apci.aplicaciones.inscripcion.services.IUsuarioService;

public class UsuarioDAO extends BaseDAO implements IUsuarioService {
	
	@Override
	public Boolean validate(String pUsuario, String pHash) {

		return (query("SELECT InscripcionId as UsuarioId, Usuario, Hash , InstitucionId FROM Inscripcion WHERE Usuario = ? AND Hash = ?",Usuario.class, pUsuario, pHash).size() == 1);
	}

	@Override
	public Usuario getByName(String pUsuario) {

		List<Usuario> lstUsuario = query("SELECT InscripcionId as UsuarioId, Usuario, Hash, InstitucionId FROM Inscripcion WHERE Usuario = ?", Usuario.class, pUsuario);
		Usuario usuario = null;

		if (lstUsuario.size() > 0){
			usuario = lstUsuario.get(0);
		}

		return usuario;
	}
}