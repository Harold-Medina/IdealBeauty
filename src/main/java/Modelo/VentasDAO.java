
package Modelo;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*import javax.swing.JOptionPane;*/

import Controlador.Conexion;

public class VentasDAO {

	Conexion cnn= new Conexion();
	Connection con= cnn.Conectar();
	PreparedStatement ps= null;
	ResultSet res = null;
	
	/*public boolean Insertar_Venta(VentasDTO v) {
		
		boolean resul=false;
		try {
			String sql="insert into ventas(cedula_cliente, cedula_usuario) values(?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setLong(1, v.getCedula_cliente());
			ps.setLong(2, v.getCedula_usuario());
			
			resul=ps.executeUpdate()>0;
			
			if (resul) {
				sql="select codigo_venta from ventas order by codigo_venta desc limit 1;";
				ps = con.prepareStatement(sql);
				res=ps.executeQuery();
				Long codigo=null;
				while(res.next()) {
					ESTE ES EL CODIGO DE LA FACTURA ACTUAL, esta variable "codigo"
					codigo=res.getLong(1);
					queda pendiente de enviar este codigo al input "consecutivo" en ventas.jsp
				}
				
				
				/*Ejecuto el update de la venta en el codigo que es el actual*/
				/*sql="update ventas set ivaventa=? where codigo_venta=? ";	/*VOY AQUIIIIIIIIIII 20:1:27:11
				ps= con.prepareStatement(sql);
				ps.setDouble(1, 0.1);
				ps.setLong(2, codigo);
				resul=ps.executeUpdate()>0; 
			}			
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al insertar: "+ex);
		}
		return resul;
		
	} 
	*/
	
	public Long Buscar_Venta() {
		Long consecutivo=null;
		
		try {
			String sql="select codigo_venta from ventas order by codigo_venta desc limit 1;";
		
			ps = con.prepareStatement(sql);
			res=ps.executeQuery();
			while(res.next()) {
				consecutivo=res.getLong(1);
				
			}/*con.close(); /*SUPER IMPORTANTE*/
		} catch(SQLException e) {
			/*JOptionPane.showMessageDialog(null,"error al consultar"+ e);*/
		}
		return consecutivo;
	}
	
	public boolean Insertar_Venta(VentasDTO venta) {
		boolean resul=false;
		try {
			String sql="insert into ventas(cedula_usuario,cedula_cliente,ivaventa,total_venta,valor_venta) values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setLong(1, venta.getCedula_cliente());
			ps.setLong(2, venta.getCedula_usuario());
			ps.setDouble(3, venta.getIvaventa());
			ps.setDouble(4, venta.getTotal_venta());
			ps.setDouble(5, venta.getValor_venta());
			
			/*JOptionPane.showMessageDialog(null, venta.getCedula_cliente());
			JOptionPane.showMessageDialog(null, venta.getCedula_usuario());
			JOptionPane.showMessageDialog(null, venta.getIvaventa());
			JOptionPane.showMessageDialog(null, venta.getTotal_venta());
			JOptionPane.showMessageDialog(null, venta.getValor_venta());
			*/
			
			resul=ps.executeUpdate()>0;
			/*con.close(); /*SUPER IMPORTANTE*/
		} catch(SQLException ex) {
			/*JOptionPane.showMessageDialog(null, "error al insertar: "+ex);*/
		}
		return resul;
	}
	
	
	public boolean Confirmar_cedula(Long Ccedul,Long Ucedul) {
		boolean resul=false;
		boolean bandera = true;
		boolean bandera2 = false;
		boolean bandera3 = false;
		Long cedulaUsuario=null;
		Long cedulaCliente=null;		
		
			if (bandera=true) {
				try {		
					String sql2="select * from usuarios where cedula_usuario=?";
					ps=con.prepareStatement(sql2);
					
					ps.setLong(1, Ucedul);
					res=ps.executeQuery();
					while(res.next()) {
						bandera2=true;
						cedulaUsuario= res.getLong(1); 
						
						}/*con.close(); /*SUPER IMPORTANTE*/
					}
						
				 catch(SQLException e) {
				    	/*JOptionPane.showMessageDialog(null,"error al consultar"+ e);*/
				 }
				}
			
			if (bandera2=true) {
					 
					  try {
						  String sql3="SELECT * FROM clientes WHERE cedula_cliente=?";
						  ps = con.prepareStatement(sql3);
						  ps.setLong(1, Ccedul);  
						  res = ps.executeQuery();
						  while(res.next()) {
							  bandera3=true;
							  cedulaCliente= res.getLong(1);
							  
						  }/*con.close(); /*SUPER IMPORTANTE*/
						  
					  }catch(Exception e) {
						  /*JOptionPane.showMessageDialog(null,"Error al Consultar el Cliente "+e);*/  
					  }
			}
			
			if (bandera3=true) {
				try {String sql="insert into ventas(cedula_cliente, cedula_usuario) values(?,?)";
				ps=con.prepareStatement(sql);
				
				ps.setLong(1, cedulaCliente);
				ps.setLong(2, cedulaUsuario);
				
				resul=ps.executeUpdate()>0;
				/*con.close(); /*SUPER IMPORTANTE*/}
				
				catch(SQLException ex){/*JOptionPane.showMessageDialog(null, "error al inicializar la factura: "+ex)*/;}					
			}
			return resul;
		}
	
	 /*NUEVO DE DANIEL*/
	public boolean Inserta_detalle_venta(DetVenDTO detven) {
		boolean resul=false;
		try {
			String sql="INSERT INTO `Grupo31_Equipo_2`.`detalle_ventas` (`cantidad_producto`, `codigo_producto`, `codigo_venta`, `valor_total`, `valor_venta`, `valorIva`) VALUES (?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setObject(1, detven.getCantidad_producto());
			ps.setLong(2, detven.getCodigo_producto());
			ps.setLong(3, detven.getCodigo_venta());
			/*Cambiado a Double*/
			ps.setDouble(4, detven.getValor_total());
			ps.setDouble(5, detven.getValor_venta());
			ps.setDouble(6, detven.getValoriva());
			
			
			resul=ps.executeUpdate()>0;
			/*con.close(); /*SUPER IMPORTANTE*/
		} catch(SQLException ex) {
			/*JOptionPane.showMessageDialog(null, "error al insertar detalle de venta: "+ex);*/
		}
		return resul;
	}
	
	
	
	
	}

