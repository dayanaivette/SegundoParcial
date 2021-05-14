package com.Dayana.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Dayana.Conexion.ConexionBD;
import com.Dayana.Entidades.Consulta;

public class clsConsulta {
	ConexionBD conexion = new ConexionBD();
	Connection con = conexion.RetornarConexion();

	public ArrayList<Consulta> ListadoUsuarios() {
		ArrayList<Consulta> Lista = new ArrayList<>();

		try {

			CallableStatement consulta = con.prepareCall("call SP_S_MOSTRARCONSULTA()");
			ResultSet rs = consulta.executeQuery();
			while (rs.next()) {
				Consulta user = new Consulta();
				user.setId(rs.getInt("Id"));
				user.setNombre(rs.getString("Nombre"));
				user.setApellido(rs.getString("Apellido"));
				Lista.add(user);
			}
		} catch (Exception e) {
			// JOptionPane.showMessageDialog(null, "Ha ocurrido un error en: \n\n\n\n" + e);
		}

		return Lista;
	}
	
	public void EliminarConsulta(Consulta consulta) {
		
		try {
			CallableStatement statement = con.prepareCall("call SP_D_CONSULTA(?)");
			statement.setInt("Pid", consulta.getId());
			statement.executeQuery();
			System.out.println("Eliminado Exitoso");
			con.close();
			
		} catch (Exception e) {
			System.out.println("Hubo un error en ConsultaDAO/EliminarConsulta " + e);
		}
	}
}
