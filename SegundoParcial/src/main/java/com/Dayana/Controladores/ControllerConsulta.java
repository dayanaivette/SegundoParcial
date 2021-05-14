package com.Dayana.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dayana.DAO.clsConsulta;
import com.Dayana.Entidades.Consulta;
import com.google.gson.Gson;

/**
 * Servlet implementation class ControllerConsulta
 */
public class ControllerConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerConsulta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String Evaluar = request.getParameter("Eliminar");
		
		clsConsulta clsC = new clsConsulta();
		Consulta consulta = new Consulta();
		
		if(Evaluar != null) {
			HttpSession sesion = (HttpSession) request.getSession();
			String usuSession = String.valueOf(sesion.getAttribute("usuario"));
			
			if(usuSession.equals(null)||usuSession.equals(null)) {
				response.sendRedirect("index.jsp");
			}
			else {
				consulta.setId(Integer.parseInt(request.getParameter("Id")));
				clsC.EliminarConsulta(consulta);
				response.sendRedirect("index.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Gson json = new Gson();
		clsConsulta consulta = new clsConsulta();		
		response.getWriter().append(json.toJson(consulta.ListadoUsuarios()));
	}

}
