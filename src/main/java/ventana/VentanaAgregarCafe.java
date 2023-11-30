package ventana;

import controller.CafeteriaController;
import modelo.Cafeteria;
import modelo.*;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.ActionEvent;

public class VentanaAgregarCafe extends Ventana {
    private JLabel textoEncabezado, textoTamaño, textoIngredientesOpcionales, textoNombre, textoGramosDeCafe, textoMililitrosDeAgua;
    private JTextField campoNombre, campoGramosDeCafe, campoMililitrosDeAgua;
    private JButton botonRegistrar, botonCancelar;
    private JFormattedTextField campoTamaño, campoIngredientesOpcionales;
    private JComboBox listaTamaño, listaIngredientesOpcionales;
    private Cafeteria cafeteria;
    private void generarEncabezado() {
        String textoCabecera = "Registro de Libros";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    public VentanaAgregarCafe(Cafeteria cafeteria){
        super("Registro de Cafes", 500, 520);
        this.cafeteria = cafeteria;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarListaTamaño();
        generarListaIngredientesOpcionales();
        generarCampoNombre();
        generarCampoGramosDeCafe();
        generarCampoMililitrosDeAgua();
        generarBotonRegistrar();
        generarBotonCancelar();
    }

    private void generarCampoNombre(){
        String textoNombre= "Nombre Cafe: ";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }

    private void generarListaTamaño(){
        super.generarJLabel(this.textoTamaño,"Tamaño Cafe:",20,100,100,20);
        String [] listaDesplegable = new String[]{"Grande","Mediano","Pequeño"};
        this.listaTamaño=super.generarListaDesplegable(listaDesplegable,120,100, 100, 20);
        this.add(this.listaTamaño);
    }

    private void generarListaIngredientesOpcionales(){
        super.generarJLabel(this.textoIngredientesOpcionales,"Ingredientes opcionales Cafe:",20,100,100,20);
        String [] listaDesplegable = new String[]{"Crema","Leche","Chocolate"};
        this.listaIngredientesOpcionales=super.generarListaDesplegable(listaDesplegable,120,100, 100, 20);
        this.add(this.listaIngredientesOpcionales);
    }


    private void generarCampoGramosDeCafe() {
        super.generarJLabel(this.textoGramosDeCafe, "Gramos:", 20, 150, 200, 20);
        this.campoGramosDeCafe = super.generarJTextField(200, 150, 250, 20);
        this.add(this.campoGramosDeCafe);
    }

    private void generarCampoMililitrosDeAgua() {
        super.generarJLabel(this.textoMililitrosDeAgua, "Autor:", 20, 200, 200, 20);
        this.campoMililitrosDeAgua = super.generarJTextField(200, 200, 250, 20);
        this.add(this.campoMililitrosDeAgua);
    }

    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Libro";
        this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }

        private boolean registrarCafe() {
        if (this.campoNombre.getText().isEmpty() || this.campoGramosDeCafe.getText().isEmpty() ||
                this.campoMililitrosDeAgua.getText().isEmpty() || this.listaTamaño.getSelectedItem() == null || this.listaIngredientesOpcionales.getSelectedItem() == null) {
            return false;
        } else {
            try {
                String nombre = this.campoNombre.getText();
                int gramosDeCafe = Integer.parseInt(this.campoGramosDeCafe.getText());
                int mililitrosDeAgua = Integer.parseInt(this.campoMililitrosDeAgua.getText());

                // Obtén la especialidad seleccionada como String desde la lista desplegable
                String tamañoSeleccionado = (String) this.listaTamaño.getSelectedItem();
                String ingredienteOpcionalSeleccionado = (String) this.listaIngredientesOpcionales.getSelectedItem();

                // Convierte el String a un elemento del enum Especialidad
                TamañoCafe tamañoCafe = TamañoCafe.valueOf(tamañoSeleccionado.replace(" ", "_").toUpperCase());
                IngredientesOpcionales ingredientesOpcionales = IngredientesOpcionales.valueOf(ingredienteOpcionalSeleccionado.replace(" ", "_").toUpperCase());

                cafeteria.agregarCafe(nombre, gramosDeCafe, mililitrosDeAgua, tamañoCafe, ingredientesOpcionales);
                return true;
            } catch (IllegalArgumentException e) {
                // Manejo de excepciones si la conversión falla (por ejemplo, si el String no coincide con ningún valor del enum)
                return false;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonRegistrar){
            if(registrarCafe()){
                TamañoCafe tamañoCafe = TamañoCafe.valueOf(((String) this.listaTamaño.getSelectedItem()).replace(" ", "_").toUpperCase());
                JOptionPane.showMessageDialog(this,"Cafe registrado correctamente","Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(cafeteria);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == this.botonCancelar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(cafeteria);
            this.dispose();
        }

    }
}