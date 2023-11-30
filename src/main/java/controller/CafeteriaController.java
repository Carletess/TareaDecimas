package controller;

import data.GestorDatos;
import modelo.Cafe;
import modelo.Cafeteria;
import modelo.TamañoCafe;
import java.util.List;
import java.util.ArrayList;

public class CafeteriaController {

	public Cafeteria cargaMasivaDatos(Cafeteria cafeteria) {
		GestorDatos.leerArchivoCafe(cafeteria, "cafe.txt");
		GestorDatos.leerArchivoCafeteria(cafeteria, "cafeteria.txt");
		return cafeteria;
	}

	public List buscarCafe(Cafeteria cafeteria, String nombre) {
		throw new UnsupportedOperationException();
	}

	public void agregarCafe(Cafeteria cafeteria, int gramosDeCafe, int mililitrosDeAgua, TamañoCafe tamaño, ArrayList<String> ingredientesOpcionales) {
		throw new UnsupportedOperationException();
	}

	public static void almacenarDatos(Cafeteria cafeteria){
		GestorDatos.registrarDatos(cafeteria.getUsuarios(),"usuarios.txt");
		GestorDatos.registrarDatos(cafeteria.getCafes(),"cafes.txt");
	}
}