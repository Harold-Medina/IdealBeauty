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

import Modelo.ProductoDAO;

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
				//String Url = "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";  
				//Ruta para los que usan xampp
				String Url="C:\\Users\\Cristian\\eclipse-workspace\\Prestamos\\src\\main\\webapp\\Doc\\";
				
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
				    JOptionPane.showMessageDialog(null, "Archivo cargado Correctamente");
				    
			        if(proDao.CargarProductos(Url+nombre+".csv")) {
			        	JOptionPane.showMessageDialog(null, "Productos Registrados correctamente");
			        	response.sendRedirect("Productos.jsp");
			        }else {
			        	JOptionPane.showMessageDialog(null, "Productos no se Registraron");
			        	response.sendRedirect("Productos.jsp");
			        }
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Error al cargar el Archivo"+e);
					response.sendRedirect("Productos.jsp");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Formato de Archivo no permitido");
				response.sendRedirect("Productos.jsp");
			}
		}
		
	}

}
