package Controlador;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.swing.JOptionPane;*/

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;
import Modelo.VentasDAO;
import Modelo.VentasDTO;
/*NUEVO DANIEL*/
import Modelo.DetVenDTO;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;

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
		VentasDAO detventaDao = new VentasDAO();
		
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
				int cantidad_producto;
				long codigo_producto;
				long codigo_venta;
				double valor_detalle_total;
				double valor_detalle_venta;
				double valor_detalle_iva;
				
				if(request.getParameter("cant1")!="") {
				cantidad_producto= Integer.parseInt(request.getParameter("cant1"));
				codigo_producto= Long.parseLong(request.getParameter("prod1"));
				codigo_venta = ventaDao.Buscar_Venta() ;
				valor_detalle_total = Double.parseDouble(request.getParameter("prodtot1") );
				valor_detalle_venta= Double.parseDouble(request.getParameter("valven1") );
				valor_detalle_iva= Double.parseDouble(request.getParameter("totiva1") );
				
				DetVenDTO detvendto=new DetVenDTO(cantidad_producto,codigo_producto,codigo_venta,valor_detalle_total,valor_detalle_venta, valor_detalle_iva);
				if(detventaDao.Inserta_detalle_venta(detvendto)) {}
				else {response.sendRedirect("Ventas.jsp?mens=detalle venta 1 no se registro.");}
				;
				}
				
				if(request.getParameter("cant2")!="") {
					cantidad_producto= Integer.parseInt(request.getParameter("cant2"));
					codigo_producto= Long.parseLong(request.getParameter("prod2"));
					codigo_venta = ventaDao.Buscar_Venta() ;
					valor_detalle_total = Double.parseDouble(request.getParameter("prodtot2") );
					valor_detalle_venta= Double.parseDouble(request.getParameter("valven2") );
					valor_detalle_iva= Double.parseDouble(request.getParameter("totiva2") );
					
					DetVenDTO detvendto=new DetVenDTO(cantidad_producto,codigo_producto,codigo_venta,valor_detalle_total,valor_detalle_venta, valor_detalle_iva);
					if(detventaDao.Inserta_detalle_venta(detvendto)) {}
					else {response.sendRedirect("Ventas.jsp?mens=detalle venta 2 no se registro.");}
					;
					}
				
				if(request.getParameter("cant3")!="") {
					cantidad_producto= Integer.parseInt(request.getParameter("cant3"));
					codigo_producto= Long.parseLong(request.getParameter("prod3"));
					codigo_venta = ventaDao.Buscar_Venta() ;
					valor_detalle_total = Double.parseDouble(request.getParameter("prodtot3") );
					valor_detalle_venta= Double.parseDouble(request.getParameter("valven3") );
					valor_detalle_iva= Double.parseDouble(request.getParameter("totiva3") );
					
					DetVenDTO detvendto=new DetVenDTO(cantidad_producto,codigo_producto,codigo_venta,valor_detalle_total,valor_detalle_venta, valor_detalle_iva);
					if(detventaDao.Inserta_detalle_venta(detvendto)) {}
					else {response.sendRedirect("Ventas.jsp?mens=detalle venta 3 no se registro.");}
					;
					}
				
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
			
			cedulaC =Long.parseLong(request.getParameter("cedulaCli1"));
			ClienteDTO cli = clientedao.ConsultarCliente(cedulaC);
			
			if(cli!=null) {
				cedulaC= cli.getCedula_cliente();
				nombreC =  cli.getNombre_cliente();
				Consecutivo=0;
				estimado=0;
				try{
					Consecutivo=ventaDao.Buscar_Venta();
					estimado=Consecutivo+1;
				}catch(Exception e){
					Consecutivo=1;
					estimado=1;
				};
				response.sendRedirect("Ventas.jsp?cedulaUsu="+identificacion+"&&nombreUsu="+nombreU+"&&cedulaCli="+cedulaC+"&&nombreCli="+nombreC+"&&consecutivo="+estimado);

			}else{
				response.sendRedirect("Ventas.jsp?mens=El Cliente no Existe");
	     		}
			}else {
				response.sendRedirect("Ventas.jsp?mens=El Usuario no existe.");
				}
         }
		
		if(request.getParameter("Consultar1")!=null) {		
			
			long CodProd;
			
			CodProd=Long.parseLong(request.getParameter("prod1"));
			ProductoDAO prodao=new ProductoDAO();
			try {
			ProductoDTO prod=prodao.ConsultarProducto(CodProd);
			
			if(prod!=null) {
				
				
			    double ivaprod=prod.getIvacompra();
				String nomprod=prod.getNombre_producto();
				double costuni=prod.getPrecio_venta();
				
				response.sendRedirect("Ventas.jsp?prod1="+CodProd+"&&nompro1="+nomprod+"&&costu1="+costuni+"&&iva1="+ivaprod);

			}else {
				response.sendRedirect("Ventas.jsp?mens=El producto no existe.");
			}
			}catch (Exception e) {
				response.sendRedirect("Ventas.jsp?mens=El producto no existe.");
			}
			
		}

		if(request.getParameter("Consultar2")!=null) {		
				
				long CodProd;
				
				CodProd=Long.parseLong(request.getParameter("prod2"));
				ProductoDAO prodao=new ProductoDAO();
				try {
				ProductoDTO prod=prodao.ConsultarProducto(CodProd);
				
				if(prod!=null) {
					
					
				    double ivaprod=prod.getIvacompra();
					String nomprod=prod.getNombre_producto();
					double costuni=prod.getPrecio_venta();
					
					response.sendRedirect("Ventas.jsp?prod2="+CodProd+"&&nompro2="+nomprod+"&&costu2="+costuni+"&&iva2="+ivaprod);

				}else {
					response.sendRedirect("Ventas.jsp?mens=El producto no existe.");
				}
				}catch (Exception e) {
					response.sendRedirect("Ventas.jsp?mens=El producto no existe.");
				}
				
			}
			
		if(request.getParameter("Consultar3")!=null) {		
				
				long CodProd;
				
				CodProd=Long.parseLong(request.getParameter("prod3"));
				ProductoDAO prodao=new ProductoDAO();
				try {
				ProductoDTO prod=prodao.ConsultarProducto(CodProd);
				
				if(prod!=null) {
					
					
				    double ivaprod=prod.getIvacompra();
					String nomprod=prod.getNombre_producto();
					double costuni=prod.getPrecio_venta();
					
					response.sendRedirect("Ventas.jsp?prod3="+CodProd+"&&nompro3="+nomprod+"&&costu3="+costuni+"&&iva3="+ivaprod);

				}else {
					response.sendRedirect("Ventas.jsp?mens=El producto no existe.");
				}
				}catch (Exception e) {
					response.sendRedirect("Ventas.jsp?mens=El producto no existe.");
				}
				
			}
		
		if(request.getParameter("limpiar")!=null) {
			response.sendRedirect("Ventas.jsp?limpiar=ok");
		}
		
		}
	}