package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

import java.math.*;
import java.sql.SQLException;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UsuarioDAO usuDao = new UsuarioDAO();
		
		if(request.getParameter("CrearU")!=null) {
			
			BigInteger cedula;
			String email,nombre,clave,usuario;

			cedula= new BigInteger(request.getParameter("cedula"));
			email=request.getParameter("email");
			nombre=request.getParameter("nombre");
			clave=request.getParameter("clave");
			usuario=request.getParameter("usuario");
			
			UsuarioDTO usuDto = new UsuarioDTO(cedula,email,nombre,clave,usuario);
			
			if(usuDao.Inserta_Usuario(usuDto)) { 
				response.sendRedirect("Usuarios.jsp?mens=Usuario registrado exitosamente.");
			}else {
				response.sendRedirect("Usuarios.jsp?=El Usuario no se registro.");
				}
			}
		
		if(request.getParameter("consult")!=null) {
			
			BigInteger cedula;
			String email,nombre,clave,usuario,identificacion;
			
			identificacion=request.getParameter("cedula");
			
			UsuarioDTO usu=usuDao.Buscar_Usuario(identificacion);
			
			cedula=usu.getCedula_usuario();
			email=usu.getEmail_usuario();
			nombre=usu.getNombre_usuario();
			clave=usu.getPassword();
			usuario=usu.getUsuario();
			identificacion=cedula.toString();
			try {
			response.sendRedirect("Usuarios.jsp?cedula="+identificacion+"&&email="+email+"&&nombre="+nombre+"&&clave="+clave+"&&usuario="+usuario);}
			catch(NullPointerException e) {
				response.sendRedirect("Usuarios.jsp?=El Usuario no se existe. "+e);
			}
		}			
		
		if(request.getParameter("update")!=null) {
			
			BigInteger cedula;
			String email,nombre,clave,usuario;

			cedula= new BigInteger(request.getParameter("cedula"));
			email=request.getParameter("email");
			nombre=request.getParameter("nombre");
			clave=request.getParameter("clave");
			usuario=request.getParameter("usuario");
			
			UsuarioDTO usuDto = new UsuarioDTO(cedula,email,nombre,clave,usuario);
			
			if(usuDao.Actualizar_Usuario(usuDto)) { 
				response.sendRedirect("Usuarios.jsp?mens=Usuario actualizado exitosamente.");
			}else {
				response.sendRedirect("Usuarios.jsp?=El Usuario no se modifico.");
				}
			}
		
			if(request.getParameter("delete")!=null) {
			
			BigInteger cedula;
			String email,nombre,clave,usuario;

			cedula= new BigInteger(request.getParameter("cedula"));
			email=request.getParameter("email");
			nombre=request.getParameter("nombre");
			clave=request.getParameter("clave");
			usuario=request.getParameter("usuario");
			
			UsuarioDTO usuDto = new UsuarioDTO(cedula,email,nombre,clave,usuario);
			
			if(usuDao.Eliminar_Usuario(usuDto)) { 
				response.sendRedirect("Usuarios.jsp?mens=Usuario eliminado exitosamente.");
			}else {
				response.sendRedirect("Usuarios.jsp?=El Usuario no se elimino.");
				}
			}
		
		}	
		
	}
	
