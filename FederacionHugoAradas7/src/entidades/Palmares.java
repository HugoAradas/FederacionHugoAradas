package entidades;

import java.util.Arrays;

public class Palmares {

	private long id;
	
	
	private Prueba[] prueba;
	private String observaciones;
	
	
	public Palmares() {
	}
	
	public Palmares(long id, Prueba[] prueba, String observaciones) {
		super();
		this.id = id;
		this.prueba = prueba;
		this.observaciones = observaciones;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Prueba[] getPrueba() {
		return prueba;
	}


	public void setPrueba(Prueba[] prueba) {
		this.prueba = prueba;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "Palmares [id=" + id + ", prueba=" + Arrays.toString(prueba) + ", observaciones=" + observaciones + "]";
	}
	
	
	
}
