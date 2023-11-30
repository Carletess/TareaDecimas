package modelo;

import java.util.ArrayList;

public class Cafe {
	private String nombre;
	private int gramosDeCafe;
	private int mililitrosDeAgua;
	private TamañoCafe tamaño;
	private IngredientesOpcionales ingredientesOpcionales;

	public Cafe(String nombre, int gramosDeCafe, int mililitrosDeAgua, TamañoCafe tamaño, IngredientesOpcionales ingredientesOpcionales) {
		this.nombre = nombre;
		this.gramosDeCafe = gramosDeCafe;
		this.mililitrosDeAgua = mililitrosDeAgua;
		this.ingredientesOpcionales = ingredientesOpcionales;
		this.tamaño = tamaño;
	}

	public int getGramosDeCafe() {
		return this.gramosDeCafe;
	}

	public void setGramosDeCafe(int gramosDeCafe) {
		this.gramosDeCafe = gramosDeCafe;
	}

	public int getMililitrosDeAgua() {
		return this.mililitrosDeAgua;
	}

	public void setMililitrosDeAgua(int mililitrosDeAgua) {
		this.mililitrosDeAgua = mililitrosDeAgua;
	}

	public String getTamaño() {
		throw new UnsupportedOperationException();
	}

	public void setTamaño(String tamaño) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<String> getIngredientesOpcionales() {
		throw new UnsupportedOperationException();
	}

	public void setIngredientesOpcionales(ArrayList<String> ingredientesOpcionales) {
		throw new UnsupportedOperationException();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString(){
		return this.nombre + "," + this.gramosDeCafe + "," + this.mililitrosDeAgua + "," + this.ingredientesOpcionales + "," + this.tamaño;
	}
}