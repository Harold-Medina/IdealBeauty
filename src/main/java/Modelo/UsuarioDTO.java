package Modelo;
import java.math.*;

public class UsuarioDTO {

	private BigInteger cedula_usuario;
	private String email_usuario;
	private String nombre_usuario;
	private String password;
	private String usuario;
	
	public UsuarioDTO(BigInteger cedula,String correo, String nombre, String clave, String user) {
		cedula_usuario = cedula;
		email_usuario = correo;
		nombre_usuario = nombre;
		password = clave;
		usuario = user;
	}

	public BigInteger getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(BigInteger cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
}