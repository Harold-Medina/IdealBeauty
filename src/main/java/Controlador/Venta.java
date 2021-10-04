package Controlador;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.UsuarioDTO;
import Modelo.VentasDAO;
import Modelo.VentasDTO;

/**
 * Servlet implementation class Venta
 */
@WebServlet("/Venta")
public class Venta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Venta() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("validar")!=null) {
			
			VentasDAO venDao=null;
			
			Long cedulaUsuario;
			Long cedulaCliente;			
			
			VentasDTO venta= new VentasDTO (cedulaCliente, cedulaUsuario);
			
			if(venta!=null) {
			
			cedulaUsuario=venta.getCedula_usuario();
			cedulaCliente=venta.getCedula_cliente();

			response.sendRedirect("Ventas.jsp?cedula="+identificacion+"&&email="+email+"&&nombre="+nombre+"&&clave="+clave+"&&usuario="+usuario);

			}else {
				response.sendRedirect("Usuarios.jsp?mens=El Usuario no existe.");
				}
			}
		
		
		
	}
}