package Controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import Modelo.ClienteDTO;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;

/**
 * Servlet implementation class Producto
 */
@WebServlet("/Producto")
@MultipartConfig
public class Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producto() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoDAO proDao = new ProductoDAO();
		
		
		if(request.getParameter("cargar")!=null) {
			   //recibo el multiplat del jsp
				Part archivo=request.getPart("archivo");
				String nombre = request.getParameter("nombreArchivo");
				//copiamos en una ruta de mi proyecto, el archivo que seleccion en la interfaz
				//Ruta para los que usan mysql 
				String Url = "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";  
				//Ruta para los que usan xampp
				//String Url="C:\\Users\\Cristian\\git\\IdealBeauty\\src\\main\\webapp\\Doc\\";
				
				//Verificamos si el tipo de archivo a cargar es csv
				if (archivo.getContentType().equals("application/vnd.ms-excel")) {
				try {
					//vamos a leer el archivos desde el formualrio
					InputStream file = archivo.getInputStream();
					//crear un nuevo archivo de la copia de ese archivo
			        File copia = new File(Url+nombre+".csv");
			        //escribimos en el archivo copia;
			        FileOutputStream escribir=new FileOutputStream(copia);
			        //leemos linea por linea el archivo
			        int num=file.read();
			        while(num != -1) {
			        	escribir.write(num);
			        	num=file.read();
			        }
				    escribir.close();
				    file.close();
				    JOptionPane.showMessageDialog(null, "Archivo Cargado Correctamente");
				    //response.sendRedirect("Productos.jsp?men=Archivo Cargado Correctamente");
			        if(proDao.CargarProductos(Url+nombre+".csv")) {
			        	//JOptionPane.showMessageDialog(null, "Productos Registrados Correctamente");
			        	response.sendRedirect("Productos.jsp?men=Productos Registrados Correctamente");
			        }else {
			        	//JOptionPane.showMessageDialog(null, "Productos no se Registraron");
			        	response.sendRedirect("Productos.jsp?men=Productos no se Registraron");
			        }
				}catch(Exception e) {
					//JOptionPane.showMessageDialog(null, "Error al cargar el Archivo"+e);
					response.sendRedirect("Productos.jsp?men=Error al Cargar el Archivo");
				}
			}else {
				//JOptionPane.showMessageDialog(null, "Formato de Archivo no Permitido");
				response.sendRedirect("Productos.jsp?men=Formato de Archivo no Permitido");
			}
		}
		
		if(request.getParameter("registrar")!=null) {
			String nombre;
			long codigo,nit;			
			double ivacom,preciocom,precioven;
			
			codigo = Long.parseLong(request.getParameter("codigo_producto"));
			ivacom =Double.parseDouble(request.getParameter("iva_compra"));
			nit = Long.parseLong(request.getParameter("nitproveedor"));
			nombre = request.getParameter("nombre_producto");
			preciocom =Double.parseDouble(request.getParameter("precio_compra"));
			precioven =Double.parseDouble(request.getParameter("precio_venta"));
			ProductoDTO prodto = new ProductoDTO(codigo,ivacom,nit,nombre,preciocom,precioven);
			if(proDao.InsertarProducto(prodto)) {
		      response.sendRedirect("ProductosActualizar.jsp?men=Producto Registrado Exitosamente!");  		    
		    }else {
		      	
	          response.sendRedirect("ProductosActualizar.jsp?men=El Producto no se Registro");
		    }
		}
		
		
		if(request.getParameter("consultar")!=null){
			String nombre;
			long codigo,nit;
			double ivacom,preciocom,precioven;
			codigo = Long.parseLong(request.getParameter("codigo_producto2"));			
			
			ProductoDTO prod = proDao.ConsultarProducto(codigo);
			if(prod!=null) {
				codigo= prod.getCodigo_producto();
				ivacom = prod.getIvacompra();
				nit = prod.getNitproveedor() ;
				nombre = prod.getNombre_producto() ;
				preciocom = prod.getPrecio_compra();
				precioven = prod.getPrecio_venta();
				
				//ahora enviar por la url con el response a Libros.jsp o la vista jsp
				response.sendRedirect("ProductosActualizar.jsp?codigo="+codigo+"&&iva="+ivacom+"&&nit="
				+nit+"&&nombre="+nombre+"&&preciocompra="+preciocom+"&&precioventa="+precioven);
				
			}else {
				response.sendRedirect("ProductosActualizar.jsp?men=El Producto no Existe");
	     	}
         }
		
		
		if(request.getParameter("actualizar")!=null) {
			String nombre;
			long codigo,nit;			
			double ivacom,preciocom,precioven;
			
			codigo = Long.parseLong(request.getParameter("cod"));
			ivacom =Double.parseDouble(request.getParameter("ivaoculto"));
			nit = Long.parseLong(request.getParameter("nitoculto"));
			nombre = request.getParameter("nombre_producto");
			preciocom =Double.parseDouble(request.getParameter("preciocomoculto"));
			precioven =Double.parseDouble(request.getParameter("precio_venta"));
			
			ProductoDTO proddto_Act = new ProductoDTO(codigo,ivacom,nit,nombre,preciocom,precioven);
					    
			String op=request.getParameter("actualizar");
			if(op.equals("true")) {
				if(proDao.ActualizarProducto(proddto_Act)) {
			      	
	              response.sendRedirect("ProductosActualizar.jsp?men=El Producto se Actualizo Exitosamente!");  		    
			    }else {
			      
		          response.sendRedirect("ProductosActualizar.jsp?men=El Producto no se Actualizo");
			    }
			}else {
				response.sendRedirect("ProductosActualizar.jsp?men=Usted ha cancelado la accion: Actualizar");
			}
				
		}
		
		
		if(request.getParameter("eliminar")!=null) {
			long num_codigo;
			num_codigo = Long.parseLong(request.getParameter("cod"));
			
			String op=request.getParameter("eliminar");
			
			if(op.equals("true")) {
				if(proDao.EliminarProducto(num_codigo)) {
					response.sendRedirect("ProductosActualizar.jsp?men=El Producto fue Eliminado Exitosamente");
				}else {
					response.sendRedirect("ProductosActualizar.jsp?men=El Producto no se Elimino");
				}
			}else {
				response.sendRedirect("ProductosActualizar.jsp");
			}
		}
		
		//llamar la pagina para cargar productos por archivo csv
		if(request.getParameter("cargararchivo")!=null) {
			       	
			response.sendRedirect("ProductosArchivo.jsp?");
			}
		//llamar la pagina para hacer crud al modulo de productos
		if(request.getParameter("cargarmanualmente")!=null) {
	       	
			response.sendRedirect("ProductosActualizar.jsp?");
			}
		
		
		if(request.getParameter("limpiar")!=null) {
			String nombre;
			long codigo,nit;			
			double ivacompra,preciocompra,precioventa;
			
			codigo=0L;
			ivacompra=0;
			nit=0L;
			nombre=null;
			preciocompra=0;
			precioventa=0;		
        	
			response.sendRedirect("ProductosActualizar.jsp?rest=limpio");
			}
		
	}

}
