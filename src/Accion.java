import java.util.ArrayList;

public class Accion {
	
	private String nombre;
	private ArrayList<Operacion> operacion;
	
	public Accion() {
		
	}
	
	public Accion(String nombre, ArrayList<Operacion> operacion) {
		
		this.nombre = nombre;
		this.operacion = operacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Operacion> getOperacion() {
		return operacion;
	}

	public void setOperacion(ArrayList<Operacion> operacion) {
		this.operacion = operacion;
	}

}
