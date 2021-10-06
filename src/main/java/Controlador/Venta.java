package Controlador;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.UsuarioDAO;
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
		
		VentasDAO ventaDao = new VentasDAO();
		UsuarioDAO usuDao = new UsuarioDAO();
		ClienteDAO clientedao = new ClienteDAO();
		
		if(request.getParameter("Confirmar")!=null) {			
			
			Long cedulaUsuario;
			Long cedulaCliente;
			Double ivaventa;
			Double total_venta;
			Double valor_venta;

			cedulaUsuario = Long.parseLong(request.getParameter("cedulaUsu"));
			cedulaCliente = Long.parseLong(request.getParameter("cedulaCli"));
			ivaventa = Double.parseDouble(request.getParameter("ivatotal"));
			total_venta = Double.parseDouble(request.getParameter("totalventa"));
			valor_venta = Double.parseDouble(request.getParameter("valorventa"));
			
			VentasDTO ventaDto = new VentasDTO(cedulaUsuario,cedulaCliente,ivaventa,total_venta,valor_venta);
			
			if(ventaDao.Insertar_Venta(ventaDto)) { 
				response.sendRedirect("Ventas.jsp?mens=Venta registrada exitosamente.");
			}else {
				response.sendRedirect("Ventas.jsp?mens=La Venta no se registro.");
				}
			}
				
		
		if(request.getParameter("Validar")!=null) {
			
			BigInteger cedulaU;
			String nombreU,identificacion;
			
			String nombreC;
			long cedulaC;
			
			long Consecutivo;
			long estimado;
			
			identificacion=request.getParameter("cedulaUsu1");
			
			UsuarioDTO usu=usuDao.Buscar_Usuario(identificacion);
			
			if(usu!=null) {
			
			cedulaU=usu.getCedula_usuario();
			nombreU=usu.getNombre_usuario();
			identificacion=cedulaU.toString();
			/*aqui se acaba usuarios*/
			
			cedulaC =Long.parseLong(request.getParameter("cedulaCli1"));
			ClienteDTO cli = clientedao.ConsultarCliente(cedulaC);
			
			if(cli!=null) {
				cedulaC= cli.getCedula_cliente();
				nombreC =  cli.getNombre_cliente();
				
				Consecutivo=ventaDao.Buscar_Venta();
				estimado=Consecutivo+1;
			
				response.sendRedirect("Ventas.jsp?cedulaUsu="+identificacion+"&&nombreUsu="+nombreU+"&&cedulaCli="+cedulaC+"&&nombreCli="+nombreC+"&&consecutivo="+estimado);

			}else{
				response.sendRedirect("Ventas.jsp?mens=El Cliente no Existe");
	     		}
			}else {
				response.sendRedirect("Ventas.jsp?mens=El Usuario no existe.");
				}
         }
		
		
		
		
		
		
		
		
		
		}
}