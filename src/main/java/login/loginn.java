package login;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

@WebServlet("/loginn")
public class loginn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginn() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UsuarioDAO usuDao = new UsuarioDAO();
		
		if(request.getParameter("send")!=null) {
			
			String usuario,clave;
			String mensaje;
			
			usuario=request.getParameter("user");
			clave=request.getParameter("key");
			
			if(usuario.equals("admininicial") && clave.equals("admin123456")) {
				/*JOptionPane.showMessageDialog(null, "Bienvenido Administrador");*/
				mensaje="Bienvenido Administrador";
				response.sendRedirect("Usuarios.jsp?mens="+mensaje);
			}else {
				/*JOptionPane.showMessageDialog(null, "datos incorrectos");*/
				mensaje="Datos incorrectos";
				response.sendRedirect("login.jsp?mens="+mensaje);
			}	
		}
		
		
		if(request.getParameter("enviar")!=null) {
			
			String usuario,clave,usuariodb="",clavedb="",nombredb="";
			String mensaje;
			BigInteger ceduladb=null;
			
			usuario=request.getParameter("usuario-user");
			clave=request.getParameter("clave-user");
			
			/*BUSCAR Y TRAER*/
				
			UsuarioDTO usu=usuDao.Login_Usuario(usuario);
				
			if(usu!=null) {
				
			clavedb=usu.getPassword();
			nombredb=usu.getNombre_usuario();
			ceduladb=usu.getCedula_usuario();
			usuariodb=usu.getUsuario();

			/*response.sendRedirect("Usuarios.jsp?cedula="+identificacion+"&&email="+email+"&&nombre="+nombre+"&&clave="+clave+"&&usuario="+usuario);*/

			}else {
				response.sendRedirect("Usuarios.jsp?mens=El Usuario no existe.");
				}
			
			/*LOGIN USER*/
			if(usuario.equals(usuariodb) && clave.equals(clavedb)) {
				/*JOptionPane.showMessageDialog(null, "Bienvenido Administrador");*/
				mensaje=("Bienvenido "+nombredb);
				/*response.sendRedirect("Ventas.jsp?mens="+mensaje+"&&cedulaUsu="+ceduladb+"&&nombreUsu"+nombredb);*/
				response.sendRedirect("Ventas.jsp?cedula-user="+ceduladb+"&&nombre-user="+nombredb+"&&welcome="+mensaje);
			}else {
				/*JOptionPane.showMessageDialog(null, "datos incorrectos");*/
				mensaje="Datos incorrectos";
				response.sendRedirect("login.jsp?mens="+mensaje);
			}
		}
		

	}

}
