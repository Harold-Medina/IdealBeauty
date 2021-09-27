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
				response.sendRedirect("Usuarios.jsp?mens=El Usuario no se registro.");
				}
			}
		
		if(request.getParameter("consult")!=null) {
			
			BigInteger cedula;
			String email,nombre,clave,usuario,identificacion;
			
			identificacion=request.getParameter("cedulaC");
			
			UsuarioDTO usu=usuDao.Buscar_Usuario(identificacion);
			
			if(usu!=null) {
			
			cedula=usu.getCedula_usuario();
			email=usu.getEmail_usuario();
			nombre=usu.getNombre_usuario();
			clave=usu.getPassword();
			usuario=usu.getUsuario();
			identificacion=cedula.toString();

			response.sendRedirect("Usuarios.jsp?cedula="+identificacion+"&&email="+email+"&&nombre="+nombre+"&&clave="+clave+"&&usuario="+usuario);

			}else {
				response.sendRedirect("Usuarios.jsp?mens=El Usuario no existe.");
				}
			}
		
		if(request.getParameter("limpiar")!=null) {
			
			String email,nombre,clave,usuario,identificacion;
			
			email=null;
			nombre=null;
			clave=null;
			usuario=null;
			identificacion=null;

			/*response.sendRedirect("Usuarios.jsp?cedula="+identificacion+"&&email="+email+"&&nombre="+nombre+"&&clave="+clave+"&&usuario="+usuario);*/
			response.sendRedirect("Usuarios.jsp?rest=limpio");
			}
		
		
		if(request.getParameter("update")!=null) {
			
			BigInteger cedula;
			String email,nombre,clave,usuario;

			cedula= new BigInteger(request.getParameter("cedulaH"));
			email=request.getParameter("email");
			nombre=request.getParameter("nombre");
			clave=request.getParameter("clave");
			usuario=request.getParameter("usuario");
			
			UsuarioDTO usuDto = new UsuarioDTO(cedula,email,nombre,clave,usuario);
			
			String op=request.getParameter("update");
			
			if(op.equals("true")) {
			if(usuDao.Actualizar_Usuario(usuDto)) { 
				response.sendRedirect("Usuarios.jsp?mens=Usuario actualizado exitosamente.");
			}else {
				response.sendRedirect("Usuarios.jsp?mens=Error al intentar modificar el usuario.");
					}
				}
			else {
				response.sendRedirect("Usuarios.jsp?mens=Usted ha cancelado la accion: Actualizar");
				}
			}
		
			if(request.getParameter("delete")!=null) {
			
			String cedula;

			cedula=request.getParameter("cedulaH");

			String op=request.getParameter("delete");
			
			if(op.equals("true")) {
			if(usuDao.Eliminar_Usuario(cedula)) { 
				response.sendRedirect("Usuarios.jsp?mens=Usuario eliminado exitosamente.");
			}else {
				response.sendRedirect("Usuarios.jsp?mens=Error al intentar eliminar el usuario.");
				}
			}else {
				response.sendRedirect("Usuarios.jsp?mens=Usted ha cancelado la accion: Eliminar");
				}
			}
		
		}	
		
	}
	
