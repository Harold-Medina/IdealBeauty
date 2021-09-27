package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

import java.math.*;

public class UsuarioDAO {

	Conexion cnn= new Conexion();
	Connection con= cnn.Conectar();
	PreparedStatement ps=null;
	ResultSet res=null;
	
	public boolean Inserta_Usuario(UsuarioDTO usu) {
		boolean resul=false;
		try {
			String sql="insert into usuarios values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setObject(1, usu.getCedula_usuario(), java.sql.Types.BIGINT);
			ps.setString(2, usu.getEmail_usuario());
			ps.setString(3, usu.getNombre_usuario());
			ps.setString(4, usu.getPassword());
			ps.setString(5, usu.getUsuario());
			
			resul=ps.executeUpdate()>0;
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al insertar: "+ex);
		}
		return resul;
	}
	
	public UsuarioDTO Buscar_Usuario(String Ucedul) {
		
		UsuarioDTO usu=null;
		
		try {
			String sql="select * from usuarios where cedula_usuario=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, Ucedul);
			res=ps.executeQuery();
			while(res.next()) {
				usu = new UsuarioDTO(res.getObject(1, BigInteger.class),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"error al consultar"+ e);
		}
		
		return usu;
	}
	
	public boolean Actualizar_Usuario(UsuarioDTO usu) {
		boolean resul=false;
		try {
			String sql="update usuarios set email_usuario=?, nombre_usuario=?, password=?, usuario=? where cedula_usuario=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, usu.getEmail_usuario());
			ps.setString(2, usu.getNombre_usuario());
			ps.setString(3, usu.getPassword());
			ps.setString(4, usu.getUsuario());
			ps.setObject(5, usu.getCedula_usuario(), java.sql.Types.BIGINT);
			
			resul=ps.executeUpdate()>0;
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al actualizar: "+ex);
		}
		return resul;
	}
	
	public boolean Eliminar_Usuario(String usur) {
		boolean resul=false;
		try {
			String sql="delete from usuarios where cedula_usuario=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, usur);
			
			resul=ps.executeUpdate()>0;
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "error al Eliminar: "+ex);
		}
		return resul;
	}
	
	
}
