
package login;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.swing.JOptionPane;*/

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
		
		if(request.getParameter("enviar")!=null) {
			
			String usuario,clave,usuariodb="",clavedb="",nombredb="";
			String mensaje;
			
			usuario=request.getParameter("usuario-user");
			clave=request.getParameter("clave-user");
			
			/*BUSCAR Y TRAER*/
				
			UsuarioDTO usu=usuDao.Login_Usuario(usuario);
				
			if(usu!=null) {
				
			clavedb=usu.getPassword();
			nombredb=usu.getNombre_usuario();
			usuariodb=usu.getUsuario();
			
			/*LOGIN USER*/
			if(usuario.equals(usuariodb) && clave.equals(clavedb)) {
				mensaje=("Bienvenido "+nombredb);
				response.sendRedirect("Usuarios.jsp?welcome="+mensaje);
			}else {
				response.sendRedirect("login.jsp?mens=La clave o el usuario es incorrecto.");
				}

			}else {
				response.sendRedirect("login.jsp?mens=La clave o el usuario es incorrecto.");
				}
		}
		

	}

}
