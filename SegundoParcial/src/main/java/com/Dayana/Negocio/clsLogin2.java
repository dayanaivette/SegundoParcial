package com.Dayana.Negocio;

import com.Dayana.DAO.clsLogin;
import com.Dayana.Entidades.Usuario;

public class clsLogin2 {
	
	public int VerificarUsuario(Usuario usuario) {
		
		int Acceso = 0;
		clsLogin validacion = new clsLogin();
		
		var validar = validacion.Login(usuario);
		
		if(validar == true) {
			Acceso = 1;
		}
		
		return Acceso;
	}
}
