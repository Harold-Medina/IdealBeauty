
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*import javax.swing.JOptionPane;*/

import Controlador.Conexion;

public class ReporteVentaClienteDAO {
	
	Conexion cnn= new Conexion();
	Connection con= cnn.Conectar();
	PreparedStatement ps= null;
	ResultSet res = null;
	
	
	//Metodo para cargar la lista de ventas por cliente
    public ArrayList<ReporteVentaClienteDTO> Cargar_select(){
		
    	ReporteVentaClienteDTO vencli=null;
		ArrayList<ReporteVentaClienteDTO> lista= new ArrayList<>();
		try {
		String sql="SELECT v.cedula_cliente,sum(v.valor_venta), c.nombre_cliente FROM ventas v INNER JOIN clientes c ON v.cedula_cliente=c.cedula_cliente GROUP BY v.cedula_cliente";
		ps= con.prepareStatement(sql);
		res=ps.executeQuery();
		while(res.next()) {			
			vencli= new ReporteVentaClienteDTO(res.getLong(1),res.getDouble(2),res.getString(3));
		    lista.add(vencli);
		}
		}catch(SQLException ex) {
			/*JOptionPane.showMessageDialog(null, "Error"+ex);*/	}
		
		return lista;
	  }
	
	

}
