package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ProveedorDAO {
	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;
	
	public boolean Insertarproveedor(ProveedorDTO proveedor) {
	    boolean resultado = false;
		try {
		   String sql="INSERT INTO proveedores VALUES(?,?,?,?,?)" ;
		   //prepara la consulta
		   ps = con.prepareStatement(sql);
		   //pasa los parametros
		   ps.setLong(1, proveedor.getNitproveedor());
		   ps.setString(2, proveedor.getCiudad_proveedor());
		   ps.setString(3, proveedor.getDireccion_proveedor());
		   ps.setString(4, proveedor.getNombre_proveedor());
		   ps.setString(5, proveedor.getTelefono_proveedor());
		   //executar la consulta, si es mayor que cero quiere decir 
           // se inserto el libro en la tabla, y enviarselo al controlador el
		   //resultado, para que este a su vez lo envie a la interfaz
		   resultado = ps.executeUpdate()>0;
		   
		}catch(SQLException e ) {
			JOptionPane.showMessageDialog(null, "Error al Insertar el proveedor"+e);
		
		}
		return resultado;
	}
	
	
	public ProveedorDTO ConsultarProveedor(long nit) {
		 //crear un objeto para guardar los datos que trajo la consulta
		  ProveedorDTO prov = null;
		  try {
			  String sql="SELECT * FROM proveedores WHERE nitproveedor=?";
			  ps = con.prepareStatement(sql);
			  ps.setLong(1, nit);  
			  res = ps.executeQuery();
			  while(res.next()) {
				  //en usuario cargo los datos del usuario 
				  prov = new ProveedorDTO(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			  }
			  
		  }catch(Exception e) {
			  JOptionPane.showMessageDialog(null,"Error al Consultar Proveedor "+e);
			  
		  }
		  //retornar el usuario al controlador
	      return prov;		
	}

	public boolean ActualizarProveedor(ProveedorDTO proveedor) {
	    boolean resultado = false;
		try {
		   String sql="UPDATE proveedores SET ciudad_proveedor=?,direccion_proveedor=?,nombre_proveedor=?,telefono_proveedor=? WHERE nitproveedor=?" ;
		   //prepara la consulta
		   ps = con.prepareStatement(sql);
		   //pasa los parametros			   
		   ps.setString(1, proveedor.getCiudad_proveedor());
		   ps.setString(2, proveedor.getDireccion_proveedor());
		   ps.setString(3, proveedor.getNombre_proveedor());
		   ps.setString(4, proveedor.getTelefono_proveedor());
		   //el orden cambio porqu este es el where
		   ps.setLong(5, proveedor.getNitproveedor());
		   //executar la consulta, si es mayor que cero quiere decir 
          // se inserto el libro en la tabla, y enviarselo al controlador el
		   //resultado, para que este a su vez lo envie a la interfaz
		   resultado = ps.executeUpdate()>0;
		   
		}catch(SQLException e ) {
			JOptionPane.showMessageDialog(null, "Error al Actualizar el Proveedor "+e);
		
		}
		return resultado;
	}
	
	public boolean EliminarProveedor(long nit) {
	    boolean resultado = false;
		try {
		   String sql="DELETE FROM proveedores WHERE nitproveedor=?" ;
		   //prepara la consulta
		   ps = con.prepareStatement(sql);
		   //pasar los parametros			   
		   ps.setLong(1, nit);
		   //executar la consulta, si es mayor que cero quiere decir 
          // se inserto el libro en la tabla, y enviarselo al controlador el
		   //resultado, para que este a su vez lo envie a la interfaz
		   resultado = ps.executeUpdate()>0;
		   
		}catch(SQLException e ) {
			JOptionPane.showMessageDialog(null, "Error al Eliminar el Proveedor "+e);
		
		}
		return resultado;
      }
	
   public ArrayList<ProveedorDTO> Cargar_select(){
		
		ProveedorDTO prov=null;
		ArrayList<ProveedorDTO> lista= new ArrayList<>();
		try {
		String sql="SELECT * FROM proveedores";
		ps= con.prepareStatement(sql);
		res=ps.executeQuery();
		while(res.next()) {			
			prov= new ProveedorDTO(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
		    lista.add(prov);
		}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error"+ex);	}
		
		return lista;
	}
	
	
}
