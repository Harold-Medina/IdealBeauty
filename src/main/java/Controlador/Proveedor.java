package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.swing.JOptionPane;*/

import Modelo.ProveedorDAO;
import Modelo.ProveedorDTO;




/**
 * Servlet implementation class Proveedor
 */
@WebServlet("/Proveedor")
public class Proveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Proveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProveedorDAO proveedorDao = new ProveedorDAO();
		//pregunto si el proveedor hizo clic en el boton registrar
		if(request.getParameter("registrar")!=null) {
			String ciudad,direccion,nombre,telefono;
			long nit;
			nit = Long.parseLong(request.getParameter("nitproveedor"));
			ciudad = request.getParameter("ciudad_proveedor");
			direccion = request.getParameter("direccion_proveedor");
			nombre = request.getParameter("nombre_proveedor");
			telefono= request.getParameter("telefono_proveedor");
			ProveedorDTO proveedorDto = new ProveedorDTO(nit,ciudad,direccion,nombre,telefono);
		    if(proveedorDao.Insertarproveedor(proveedorDto)) {
		      //JOptionPane.showMessageDialog(null, "Proveedor Registrado Exitosamente!");	
              response.sendRedirect("Proveedores.jsp?men=Proveedor Registrado Exitosamente!");  		    
		    }else {
		      //JOptionPane.showMessageDialog(null, "El Proveedor no se Registro");	
	          response.sendRedirect("Proveedores.jsp?men=El Proveedor no se Registro");
		    }
		
       	}
		
		
		if(request.getParameter("consultar")!=null){
			String ciudad,direccion,nombre,telefono;
			long nit;
			nit =Long.parseLong(request.getParameter("nitproveedor2"));
			ProveedorDTO prov = proveedorDao.ConsultarProveedor(nit);
			if(prov!=null) {
				nit= prov.getNitproveedor();
				ciudad = prov.getCiudad_proveedor();
				direccion = prov.getDireccion_proveedor();
				nombre =  prov.getNombre_proveedor();
				telefono = prov.getTelefono_proveedor();
				
				//ahora enviar por la url con el response a Proveedores.jsp o la vista jsp
				response.sendRedirect("Proveedores.jsp?nit="+nit+"&&ciudad="+ciudad+"&&direccion="
						+direccion+"&&nombre="+nombre+"&&telefono="+telefono);
				
			}else {
				//JOptionPane.showMessageDialog(null, "El Proveedor NOOOO se consulto");
				response.sendRedirect("Proveedores.jsp?men=El Proveedor no Existe");
	     	}
         }
		
		
		if(request.getParameter("update")!=null) {
			String ciudad,direccion,nombre,telefono;
			long nit;
			nit = Long.parseLong(request.getParameter("nitprov"));
			ciudad = request.getParameter("ciudad_proveedor");
			direccion = request.getParameter("direccion_proveedor");
			nombre = request.getParameter("nombre_proveedor");
			telefono = request.getParameter("telefono_proveedor");
			
			ProveedorDTO provDto_Act = new ProveedorDTO(nit,ciudad,direccion,nombre,telefono);
			
			String op=request.getParameter("update");
			
			if(op.equals("true")) {			
				if(proveedorDao.ActualizarProveedor(provDto_Act)) {
			      //JOptionPane.showMessageDialog(null, "El Proveedor se Actualizo Exitosamente!");	
	              response.sendRedirect("Proveedores.jsp?men=El Proveedor se Actualizo Exitosamente!");  		    
			    }else {
			      //JOptionPane.showMessageDialog(null, "El Proveedor no se Actualizo");	
		          response.sendRedirect("Proveedores.jsp?men=El Proveedor no se Actualizo");
			    }
		   }else {
				response.sendRedirect("Proveedores.jsp?men=Usted ha cancelado la accion: Actualizar");
			}
		}
		
		
		if(request.getParameter("delete")!=null) {
			long codnit;			
			codnit = Long.parseLong(request.getParameter("nitprov"));
									
			String op =request.getParameter("delete");
			
			if(op.equals("true")) {
				if(proveedorDao.EliminarProveedor(codnit)) {
					response.sendRedirect("Proveedores.jsp?men=El Proveedor fue Eliminado");
				}else {
					response.sendRedirect("Proveedores.jsp?men=El Proveedor no se Elimino");
				}
			}else {
				response.sendRedirect("Proveedores.jsp?men=Usted ha cancelado la accion: Eliminar");
			}
		}	
		
		if(request.getParameter("limpiar")!=null) {
			long nit;
        	String ciudad,direccion,nombre,telefono;
        	
        	
        	nit=0L;
        	ciudad=null;
        	direccion=null;
        	nombre=null;
        	telefono=null;               	      	
			
			response.sendRedirect("Proveedores.jsp?rest=limpio");
			}
		
		
    }
}
