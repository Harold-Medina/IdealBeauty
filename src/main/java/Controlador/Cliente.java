package Controlador;

import java.io.IOException;
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

/**
 * Servlet implementation class Cliente
 */
@WebServlet("/Cliente")
public class Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteDAO clientedao = new ClienteDAO();
		//pregunto si el cliente hizo clic en el boton registrar
		if(request.getParameter("registrar")!=null) {
			String email,nombre,direccion,telefono;
			long cedula;
			cedula = Long.parseLong(request.getParameter("cedula_cliente"));
			direccion = request.getParameter("direccion_cliente");
			email = request.getParameter("email_cliente");
			nombre = request.getParameter("nombre_cliente");
			telefono = request.getParameter("telefono_cliente");
			ClienteDTO clientedto = new ClienteDTO(cedula,direccion,email,nombre,telefono);
			if(clientedao.InsertarCliente(clientedto)) {
		      JOptionPane.showMessageDialog(null, "Cliente Registrado Exitosamente!");	
              response.sendRedirect("Clientes.jsp?men=Cliente Registrado Exitosamente!");  		    
		    }else {
		      JOptionPane.showMessageDialog(null, "El Cliente no se Registro");	
	          response.sendRedirect("Clientes.jsp?men=El Cliente no se Registro");
		    }
		}
		
		
		if(request.getParameter("consultar")!=null){
			String email,nombre,direccion,telefono;
			long cedula;
			cedula =Long.parseLong(request.getParameter("cedula_cliente2"));
			ClienteDTO cli = clientedao.ConsultarCliente(cedula);
			if(cli!=null) {
				cedula= cli.getCedula_cliente();
				direccion = cli.getDireccion_cliente();
				email = cli.getEmail_cliente();
				nombre =  cli.getNombre_cliente();
				telefono = cli.getTelefono_cliente();
				
				//ahora enviar por la url con el response a Libros.jsp o la vista jsp
				response.sendRedirect("Clientes.jsp?cedula="+cedula+"&&direccion="+direccion+"&&email="
						+email+"&&nombre="+nombre+"&&telefono="+telefono);
				
			}else {
				response.sendRedirect("Clientes.jsp?men=El Cliente no Existe");
	     	}
         }
		
		if(request.getParameter("actualizar")!=null) {
			String email,nombre,direccion,telefono;
			long cedula;
			cedula = Long.parseLong(request.getParameter("cedula_cliente"));
			direccion = request.getParameter("direccion_cliente");
			email = request.getParameter("email_cliente");
			nombre = request.getParameter("nombre_cliente");
			telefono = request.getParameter("telefono_cliente");
			ClienteDTO clidto_Act = new ClienteDTO(cedula,direccion,email,nombre,telefono);
		    if(clientedao.ActualizarCliente(clidto_Act)) {
		      JOptionPane.showMessageDialog(null, "El Cliente se Actualizo Exitosamente!");	
              response.sendRedirect("Clientes.jsp?men=El Cliente se Actualizo Exitosamente!");  		    
		    }else {
		      JOptionPane.showMessageDialog(null, "El Cliente no se Actualizo");	
	          response.sendRedirect("Clientes.jsp?men=El Cliente no se Actualizo");
		    }
		}
		
		
		if(request.getParameter("eliminar")!=null) {
			long num_cedula;
			num_cedula = Long.parseLong(request.getParameter("ced"));
			int op = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el Cliente "+num_cedula);
			if(op==0) {
				if(clientedao.EliminarCliente(num_cedula)) {
					response.sendRedirect("Clientes.jsp?men=El Cliente fue Eliminado");
				}else {
					response.sendRedirect("Clientes.jsp?men=El Cliente no se Elimino");
				}
			}else {
				response.sendRedirect("Clientes.jsp");
			}
		}
		
		
	}

}
