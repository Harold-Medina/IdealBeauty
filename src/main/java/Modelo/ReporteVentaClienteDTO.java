package Modelo;

public class ReporteVentaClienteDTO {
	
	//tabla ventas con datos que necesito para crear la consulta
	private long cedula_cliente;
	private double valor_venta;
	private String nombre_cliente;
	
	public ReporteVentaClienteDTO(long cedula_cliente, double valor_venta, String nombre_cliente) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.valor_venta = valor_venta;
		this.nombre_cliente = nombre_cliente;
	}

	public long getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	
		
	

}
