package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Cafeteria {
	private String nombre;
	private String direccion;
	private ArrayList<Cafe> cafes;
	private RedesSociales redesSociales;

	public Cafeteria(String nombre, String direccion, RedesSociales redesSociales) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.cafes = new ArrayList<>();
		this.redesSociales = redesSociales;
	}

	public Cafe agregarCafe(String nombre, int gramosDeCafe, int mililitrosDeAgua, TamañoCafe tamañoCafe, IngredientesOpcionales ingredientesOpcionales) {
		Cafe cafe = new Cafe(nombre,gramosDeCafe,mililitrosDeAgua,tamañoCafe,ingredientesOpcionales);
		this.cafes.add(cafe);

		return cafe;
	}

	public List<Cafe> obtenerCafePorNombre(String nombreCafe) {
		List<Cafe> cafesEncontrados = new ArrayList<>();

		for (Cafe cafe : this.cafes) {
			if (cafe.getNombre().equals(nombreCafe)) {
				cafesEncontrados.add(cafe);
			}
		}

		return cafesEncontrados;
	}

	public ArrayList<Cafe> obtenerCafeSegunTamaño(String tamaño) {
		throw new UnsupportedOperationException();
	}

	public void discontinuarCafe(Cafe cafe) {
		throw new UnsupportedOperationException();
	}

	public void modificarInformacion(String nuevoNombre, String nuevaDireccion, ArrayList<String> nuevasRedesSociales) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Cafe> getCafes(){
		return cafes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCafes(ArrayList<Cafe> cafes) {
		this.cafes = cafes;
	}
}