package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
			nit = Long.parseLong(request.getParameter("nit_proveedor"));
			ciudad = request.getParameter("ciudad_proveedor");
			direccion = request.getParameter("direccion_proveedor");
			nombre = request.getParameter("nombre_proveedor");
			telefono= request.getParameter("telefono_proveedor");
			ProveedorDTO proveedorDto = new ProveedorDTO(nit,ciudad,direccion,nombre,telefono);
		    if(proveedorDao.Insertarproveedor(proveedorDto)) {
		      JOptionPane.showMessageDialog(null, "Proveedor Registrado Exitosamente!");	
              response.sendRedirect("Proveedores.jsp?men=Proveedor Registrado Exitosamente!");  		    
		    }else {
		      JOptionPane.showMessageDialog(null, "El Proveedor no se Registro");	
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
				JOptionPane.showMessageDialog(null, "El Proveedor se consulto");
			}else {
				JOptionPane.showMessageDialog(null, "El Proveedor NOOOO se consulto");
				response.sendRedirect("Proveedores.jsp?men=El Proveedor no Existe");
	     	}
         }
		
		
		if(request.getParameter("actualizar")!=null) {
			String ciudad,direccion,nombre,telefono;
			long nit;
			nit = Long.parseLong(request.getParameter("nitprov"));
			ciudad = request.getParameter("ciudad_proveedor");
			direccion = request.getParameter("direccion_proveedor");
			nombre = request.getParameter("nombre_proveedor");
			telefono = request.getParameter("telefono_proveedor");
			ProveedorDTO provDto_Act = new ProveedorDTO(nit,ciudad,direccion,nombre,telefono);
		    if(proveedorDao.ActualizarProveedor(provDto_Act)) {
		      JOptionPane.showMessageDialog(null, "El Proveedor se Actualizo Exitosamente!");	
              response.sendRedirect("Proveedores.jsp?men=El Proveedor se Actualizo Exitosamente!");  		    
		    }else {
		      JOptionPane.showMessageDialog(null, "El Proveedor no se Actualizo");	
	          response.sendRedirect("Proveedores.jsp?men=El Proveedor no se Actualizo");
		    }
		}
		
		
		if(request.getParameter("eliminar")!=null) {
			long codnit;
			/*long otronit;
			otronit=Long.parseLong(request.getParameter("nitprov"));
			JOptionPane.showMessageDialog(null, otronit);
			*/
			codnit = Long.parseLong(request.getParameter("nitprov"));
			int op = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el Proveedor "+codnit);
			if(op==0) {
				if(proveedorDao.EliminarProveedor(codnit)) {
					response.sendRedirect("Proveedores.jsp?men=El Proveedor fue Eliminado");
				}else {
					response.sendRedirect("Proveedores.jsp?men=El Proveedor no se Elimino");
				}
			}else {
				response.sendRedirect("Proveedores.jsp");
			}
		}		
		
    }
}
