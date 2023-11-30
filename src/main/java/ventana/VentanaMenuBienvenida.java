package ventana;

import controller.CafeteriaController;
import modelo.Cafeteria;

import javax.swing.*;
import java.awt.event.*;

public class VentanaMenuBienvenida extends Ventana{
	private JLabel textoMenu;
	private JButton botonAgregarCafe, botonAgregarCafeteria, botonSalida;
	private JButton botonEditarCafeteria;
	protected Cafeteria cafeteria;

	public VentanaMenuBienvenida(Cafeteria cafeteria) {
		super("Menu Cafeteria", 500, 520);
		this.cafeteria = cafeteria;
		generarElementosVentana();
	}

	private void generarElementosVentana() {
		generarMensajeMenu();
		generarBotonAgregarCafe();
		generarBotonEditarCafeteria();
		generarBotonSalir();
	}

	private void generarMensajeMenu() {
		throw new UnsupportedOperationException();
	}

	private void generarBotonAgregarCafe() {
		String textoBoton = "Agregar Cafe";
		this.botonAgregarCafe = super.generarBoton(textoBoton, 175, 100, 150, 40);
		this.add(this.botonAgregarCafe);
		this.botonAgregarCafe.addActionListener(this);
	}

	private void generarBotonEditarCafeteria() {
		throw new UnsupportedOperationException();
	}


	private void generarBotonSalir() {
		throw new UnsupportedOperationException();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.botonAgregarCafe) {
			VentanaAgregarCafe ventanaAgregarCafe = new VentanaAgregarCafe(cafeteria);
			// Cierra la ventana actual
			this.dispose();
		}

		if (e.getSource() == this.botonAgregarCafeteria) {
			VentanaAgregarCafeteria ventanaAgregarCafeteria = new VentanaAgregarCafeteria(cafeteria);
			this.dispose();
		}

		if (e.getSource() == this.botonSalida) {
			CafeteriaController.almacenarDatos(this.cafeteria);
			this.dispose();
			System.exit(0);
		}
	}
}