package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import Controlador.Conexion;

public class ProductoDAO {
	
	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	
	public boolean InsertarProducto(ProductoDTO producto) {
	    boolean resultado = false;
		try {
		   String sql="INSERT INTO productos VALUES(?,?,?,?,?,?)" ;
		   //prepara la consulta
		   ps = con.prepareStatement(sql);
		   //pasa los parametros
		   ps.setLong(1, producto.getCodigo_producto());
		   ps.setDouble(2, producto.getIvacompra());
		   ps.setLong(3, producto.getNitproveedor());
		   ps.setString(4, producto.getNombre_producto());
		   ps.setDouble(5, producto.getPrecio_compra());
		   ps.setDouble(6, producto.getPrecio_venta());
		   //executar la consulta, si es mayor que cero quiere decir 
           // se inserto el libro en la tabla, y enviarselo al controlador el
		   //resultado, para que este a su vez lo envie a la interfaz
		   resultado = ps.executeUpdate()>0;
		   
		}catch(SQLException e ) {
			JOptionPane.showMessageDialog(null, "Error al Insertar el Producto "+e);
		
		}
		return resultado;
	}
	
	
	public ProductoDTO ConsultarProducto(long codigo) {
		 //crear un objeto para guardar los datos que trajo la consulta
		  ProductoDTO prod = null;
		  try {
			  String sql="SELECT * FROM productos WHERE codigo_producto=?";
			  ps = con.prepareStatement(sql);
			  ps.setLong(1, codigo);  
			  res = ps.executeQuery();
			  while(res.next()) {
				  //en la variable cli cargo los datos del cliente
				  prod = new ProductoDTO(res.getLong(1),res.getDouble(2),res.getLong(3),res.getString(4),res.getDouble(5),res.getDouble(6));
			  }
			  
		  }catch(Exception e) {
			  JOptionPane.showMessageDialog(null,"Error al Consultar el Producto "+e);
			  
		  }
		  //retornar el usuario al controlador
	      return prod;
		
	}
	
	
	public boolean ActualizarProducto(ProductoDTO producto) {
	    boolean resultado = false;
		try {
		   String sql="UPDATE productos SET ivacompra=?,nitproveedor=?,nombre_producto=?,precio_compra=?,precio_venta=? WHERE codigo_producto=?" ;
		   //preparo la consulta
		   ps = con.prepareStatement(sql);
		   //pasamos los parametros			   
		   ps.setDouble(1, producto.getIvacompra());
		   ps.setLong(2, producto.getNitproveedor());
		   ps.setString(3, producto.getNombre_producto());
		   ps.setDouble(4, producto.getPrecio_compra());
		   ps.setDouble(5, producto.getPrecio_venta());
		   //el orden cambio porqu este es el ultimo en el where
		   ps.setLong(6, producto.getCodigo_producto());
		   //executar la consulta, si es mayor que cero quiere decir 
          // se inserto el cliente en la tabla, y se envia  al controlador el
		   //resultado, para que este a su vez lo envie a la interfaz
		   resultado = ps.executeUpdate()>0;
		   
		}catch(SQLException e ) {
			JOptionPane.showMessageDialog(null, "Error al Actualizar el Prodcuto "+e);
		
		}
		return resultado;
	}
	
	
	//Se crea el metodo para eliminar un producto en la base de datos
		public boolean EliminarProducto(long codigo) {
		    boolean resultado = false;
			try {
			   String sql="DELETE FROM productos WHERE codigo_producto=?" ;
			   //prepara la consulta
			   ps = con.prepareStatement(sql);
			   //pasar los parametros			   
			   ps.setLong(1, codigo);
			   //executar la consulta, si es mayor que cero quiere decir 
	          // se inserto el libro en la tabla, y enviarselo al controlador el
			   //resultado, para que este a su vez lo envie a la interfaz
			   resultado = ps.executeUpdate()>0;
			   
			}catch(SQLException e ) {
				JOptionPane.showMessageDialog(null, "Error al Eliminar el Producto "+e);
			
			}
			return resultado;
	      }
	
	
	
	
	
	public boolean CargarProductos(String Url) {
		boolean  resultado = false;
		try{
			
			String sql="load data infile '"+Url+"' into table productos fields terminated by ',' lines terminated by '\r\n'";
		    ps = con.prepareStatement(sql);
		    //ps.setString(1, Url);
		    resultado=ps.executeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al Insertar Libros "+ex);
			
		}	
		
		return resultado;
	}

	
	

}
