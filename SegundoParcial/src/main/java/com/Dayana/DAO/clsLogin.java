package com.Dayana.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.Dayana.Conexion.ConexionBD;
import com.Dayana.Entidades.Usuario;

public class clsLogin {
	
		ConexionBD conexion = new ConexionBD();
		Connection con = conexion.RetornarConexion();
		
		public boolean Login(Usuario usu) {
			
			boolean verificar = false;
			
			try {
				CallableStatement consulta = con.prepareCall("call SP_S_LOGIN(?,?)");
				consulta.setString("PNombre", usu.getNombre());
				consulta.setString("PContrasena", usu.getContrasena());
				ResultSet resultado = consulta.executeQuery();
				
				if(resultado.next()) {
					verificar = true;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return verificar;
			}
		}