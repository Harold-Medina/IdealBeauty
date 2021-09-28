package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import Controlador.Conexion;

public class ProductoDAO {
	
	Conexion cnn = new Conexion();
	Connection con = cnn.Conectar();
	PreparedStatement ps = null;
	ResultSet res = null;
	
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
