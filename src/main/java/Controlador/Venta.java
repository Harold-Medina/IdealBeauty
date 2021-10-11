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
		/* NUEVO DANIEL*/
		VentasDAO detventaDao = new VentasDAO();
		
		/* VERSION CLASICA 
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
			*/
		
		boolean detalleV=false;
		
		/*NUEVA DANIEL*/
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
			
		/*codigo antes*/
		
			if(ventaDao.Insertar_Venta(ventaDto)) {
				detalleV=true;
				response.sendRedirect("Ventas.jsp?mens=Venta registrada exitosamente.");
			}else {
				response.sendRedirect("Ventas.jsp?mens=La Venta no se registro.");
				}
		}
		/* daniel */
		
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
		
		/* NUEVO DANIEL*/
		if(request.getParameter("Consultar1")!=null) {		
			
			long CodProd;
			
			CodProd=Long.parseLong(request.getParameter("prod1"));
			JOptionPane.showMessageDialog(null, CodProd);
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
				JOptionPane.showMessageDialog(null, CodProd);
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
				JOptionPane.showMessageDialog(null, CodProd);
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
		/*daniel*/
			
			if(detalleV==true) {
				if(request.getParameter("prod1")!=null) {
					int cantidad_producto= Integer.parseInt(request.getParameter("cant1"));
					long codigo_producto= Long.parseLong(request.getParameter("prod1"));
					long codigo_venta = Long.parseLong(request.getParameter("Consecutivo")) ;
					/*
					float valor_total = Float.parseFloat(request.getParameter("prodtot1") );
					float valor_ventaprod= Float.parseFloat(request.getParameter("valven1") );
					float valoriva= Float.parseFloat(request.getParameter("totiva1") );
					*/
					double valor_total = Double.parseDouble(request.getParameter("prodtot1") );
					double valor_ventaprod= Double.parseDouble(request.getParameter("valven1") );
					double valoriva= Double.parseDouble(request.getParameter("totiva1") );
					
					DetVenDTO detvendto=new DetVenDTO(cantidad_producto,codigo_producto,codigo_venta,valor_total,valor_ventaprod, valoriva);
					detventaDao.Inserta_detalle_venta(detvendto);
				}
				
				if(request.getParameter("prod2")!=null) {
					JOptionPane.showMessageDialog(null, request.getParameter("prod2"));
					int cantidad_producto= Integer.parseInt(request.getParameter("cant2"));
					long codigo_producto= Long.parseLong(request.getParameter("prod2"));
					long codigo_venta = Long.parseLong(request.getParameter("Consecutivo")) ;
					double valor_total = Double.parseDouble(request.getParameter("prodtot2") );
					double valor_ventaprod= Double.parseDouble(request.getParameter("valven2") );
					double valoriva= Double.parseDouble(request.getParameter("totiva2") );
					
					
					DetVenDTO detvendto=new DetVenDTO(cantidad_producto,codigo_producto,codigo_venta,valor_total,valor_ventaprod, valoriva);
					detventaDao.Inserta_detalle_venta(detvendto);
				}	
				
				if(request.getParameter("prod3")!=null) {
					int cantidad_producto= Integer.parseInt(request.getParameter("cant3"));
					long codigo_producto= Long.parseLong(request.getParameter("prod3"));
					long codigo_venta = Long.parseLong(request.getParameter("Consecutivo")) ;
					double valor_total = Double.parseDouble(request.getParameter("prodtot3") );
					double valor_ventaprod= Double.parseDouble(request.getParameter("valven3") );
					double valoriva= Double.parseDouble(request.getParameter("totiva3") );
					
					
					DetVenDTO detvendto=new DetVenDTO(cantidad_producto,codigo_producto,codigo_venta,valor_total,valor_ventaprod, valoriva);
					detventaDao.Inserta_detalle_venta(detvendto);
				}
			}
		
		
		
		
		
		
		
		}
}