
public class Operacion {
	
	private String tipo,cantidad,precio;
	
	public Operacion() {
		
	}
	
	public Operacion(String tipo, String cantidad, String precio) {
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	
}
