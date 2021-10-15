package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.swing.JOptionPane;*/

import com.google.gson.Gson;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;
import Modelo.ProveedorDAO;
import Modelo.ProveedorDTO;
import Modelo.ReporteVentaClienteDAO;
import Modelo.ReporteVentaClienteDTO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Reportes
 */
@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Reportes() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        //procedimiento para seleccionar todos los clientes de la base de dtaos
				String op = request.getParameter("opcion");
				//JOptionPane.showMessageDialog(null, op);
				
				//generar variables para convertir en json
						PrintWriter salida=response.getWriter();
						Gson datos = new Gson();
						
						//cuando se haga click en la opcion clientes cargueme los clientes
						if (op.equals("clientes")) {					
							//llamo DAO clientes
							ClienteDAO cliDao = new ClienteDAO();
							ArrayList<ClienteDTO> lista = new ArrayList<>();
							lista = cliDao.Cargar_select();
							//ya tenemos la lista lo convertimos a json
							salida.println(datos.toJson(lista));			
			         	}
						
						
				 //procedimiento para seleccionar todos los clientes de la base de dtaos
				 		if (op.equals("usuarios")) {					
						//llamo DAO clientes
						UsuarioDAO usuDao = new UsuarioDAO();
				    	ArrayList<UsuarioDTO> lista = new ArrayList<>();
						lista = usuDao.Cargar_select();
						//ya tenemos la lista lo convertimos a json
						salida.println(datos.toJson(lista));			
					 	}	
				 		
				 		
				 //procedimiento para seleccionar todos los productos de la base de dtaos
				 		if (op.equals("productos")) {					
						//llamo DAO clientes
						ProductoDAO prodDao = new ProductoDAO();
				    	ArrayList<ProductoDTO> lista = new ArrayList<>();
						lista = prodDao.Cargar_select();
						//ya tenemos la lista lo convertimos a json
						salida.println(datos.toJson(lista));			
					 	}
				 		
				 //procedimiento para seleccionar todos los productos de la base de dtaos
				 		if (op.equals("proveedores")) {					
						//llamo DAO clientes
						ProveedorDAO provDao = new ProveedorDAO();
				    	ArrayList<ProveedorDTO> lista = new ArrayList<>();
						lista = provDao.Cargar_select();
						//ya tenemos la lista lo convertimos a json
						salida.println(datos.toJson(lista));			
					 	}
				 //procedimiento para seleccionar el total de ventas por cliente		
				 		if (op.equals("ventascliente")) {	
							//llamo DAO Reportes Venta Cliente
							ReporteVentaClienteDAO vencliDao = new ReporteVentaClienteDAO();
							ArrayList<ReporteVentaClienteDTO> lista = new ArrayList<>();
							lista = vencliDao.Cargar_select();
							//ya tenemos la lista lo convertimos a json
							salida.println(datos.toJson(lista));			
							
						}
						
			
		
	}

}
