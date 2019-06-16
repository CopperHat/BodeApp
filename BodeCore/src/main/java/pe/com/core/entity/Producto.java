package pe.com.core.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * Flujo 01
 * Clase mapeada de la tabla Producto
 * @author Henry Joe Wong Urquiza
 * @email hwongu@gmail.com
 */
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private int cantidad;
	private double precio;
	private String tipo;
	private String nacional;
	private String descuento;

	public Producto() {
		super();
	}
	
	public Producto(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNacional() {
		return nacional;
	}

	public void setNacional(String nacional) {
		this.nacional = nacional;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	
	
}