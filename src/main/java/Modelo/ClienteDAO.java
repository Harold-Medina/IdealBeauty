package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ClienteDAO {
	
	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	//se crea el metodo para regristrar un cliente a la base de datos
	public boolean InsertarCliente(ClienteDTO cliente) {
	    boolean resultado = false;
		try {
		   String sql="INSERT INTO clientes VALUES(?,?,?,?,?)" ;
		   //prepara la consulta
		   ps = con.prepareStatement(sql);
		   //pasa los parametros
		   ps.setLong(1, cliente.getCedula_cliente());
		   ps.setString(2, cliente.getDireccion_cliente());
		   ps.setString(3, cliente.getEmail_cliente());
		   ps.setString(4, cliente.getNombre_cliente());
		   ps.setString(5, cliente.getTelefono_cliente());
		   //executar la consulta, si es mayor que cero quiere decir 
           // se inserto el libro en la tabla, y enviarselo al controlador el
		   //resultado, para que este a su vez lo envie a la interfaz
		   resultado = ps.executeUpdate()>0;
		   
		}catch(SQLException e ) {
			JOptionPane.showMessageDialog(null, "Error al Insertar el cliente "+e);
		
		}
		return resultado;
	}
	
	//se crea el metodo consultar un cliente de la base de datos
	public ClienteDTO ConsultarCliente(long cedula) {
		 //crear un objeto para guardar los datos que trajo la consulta
		  ClienteDTO cli = null;
		  try {
			  String sql="SELECT * FROM clientes WHERE cedula_cliente=?";
			  ps = con.prepareStatement(sql);
			  ps.setLong(1, cedula);  
			  res = ps.executeQuery();
			  while(res.next()) {
				  //en la variable cli cargo los datos del cliente
				  cli= new ClienteDTO(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			  }
			  
		  }catch(Exception e) {
			  JOptionPane.showMessageDialog(null,"Error al Consultar el Cliente "+e);
			  
		  }
		  //retornar el usuario al controlador
	      return cli;
		
	}
	
	
	//se crea el metodo para actualizar un cliente en la base de datos
	public boolean ActualizarCliente(ClienteDTO cliente) {
	    boolean resultado = false;
		try {
		   String sql="UPDATE clientes SET direccion_cliente=?,email_cliente=?,nombre_cliente=?,telefono_cliente=? WHERE cedula_cliente=?" ;
		   //preparo la consulta
		   ps = con.prepareStatement(sql);
		   //pasamos los parametros			   
		   ps.setString(1, cliente.getDireccion_cliente());
		   ps.setString(2, cliente.getEmail_cliente());
		   ps.setString(3, cliente.getNombre_cliente());
		   ps.setString(4, cliente.getTelefono_cliente());
		   //el orden cambio porqu este es el ultimo en el where
		   ps.setLong(5, cliente.getCedula_cliente());
		   //executar la consulta, si es mayor que cero quiere decir 
          // se inserto el cliente en la tabla, y se envia  al controlador el
		   //resultado, para que este a su vez lo envie a la interfaz
		   resultado = ps.executeUpdate()>0;
		   
		}catch(SQLException e ) {
			JOptionPane.showMessageDialog(null, "Error al Actualizar el cliente "+e);
		
		}
		return resultado;
	}
	
	//Se crea el metodo para eliminar un cliente en la base de datos
	public boolean EliminarCliente(long cedula) {
	    boolean resultado = false;
		try {
		   String sql="DELETE FROM clientes WHERE cedula_cliente=?" ;
		   //prepara la consulta
		   ps = con.prepareStatement(sql);
		   //pasar los parametros			   
		   ps.setLong(1, cedula);
		   //executar la consulta, si es mayor que cero quiere decir 
          // se inserto el libro en la tabla, y enviarselo al controlador el
		   //resultado, para que este a su vez lo envie a la interfaz
		   resultado = ps.executeUpdate()>0;
		   
		}catch(SQLException e ) {
			JOptionPane.showMessageDialog(null, "Error al Eliminar el Cliente "+e);
		
		}
		return resultado;
      }
	
	

}
