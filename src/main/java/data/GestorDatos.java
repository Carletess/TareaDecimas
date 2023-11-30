package data;

import modelo.*;

import java.io.*;
import java.util.List;

public class GestorDatos {
	public static Cafeteria leerArchivoCafeteria(Cafeteria cafeteria, String direccionArchivo) {
		String textoArchivo = "";
		try {
			File archivo = new File(direccionArchivo);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			// Lee cada línea del archivo hasta que la línea sea nula
			while ((textoArchivo = br.readLine()) != null) {
				System.out.println("Encontre el archivo" + direccionArchivo);
				String[] data = textoArchivo.split(",");
				cafeteria.getCafes().add(new Cafe(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), TamañoCafe.valueOf(data[3]), IngredientesOpcionales.valueOf(data[4])));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("cafe.txt no disponible, favor contactar con administrador");
		}
		return cafeteria;
	}

	public static Cafeteria leerArchivoCafe(Cafeteria cafeteria, String direccionArchivo) {
		String textoArchivo = "";

		try {
			File archivo = new File(direccionArchivo);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			//Lee cada linea del archivo hasta que la linea sea nula
			while ((textoArchivo = br.readLine()) != null) {
				String[] data = textoArchivo.split(",");
				cafeteria = new Cafeteria(data[0], data[1], RedesSociales.valueOf(data[3]));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Usuarios.txt no disponible, favor contactar con administrador");
		}
		return cafeteria;
	}

	public static boolean registrarDatos(List objetos, String direccionArchivo) {
		try {
			File file = new File(direccionArchivo);

			// Elimina el archivo existente, si es posible
			if (file.exists() && file.delete()) {
				System.out.println("El fichero " + direccionArchivo +  " ha sido borrado satisfactoriamente");
			} else {
				System.out.println("El fichero " + direccionArchivo + " no puede ser borrado");
			}

			// Crea un nuevo archivo
			if (file.createNewFile()) {
				System.out.println("Se ha creado un nuevo archivo " + direccionArchivo);
			} else {
				System.out.println("No se pudo crear el nuevo archivo " + direccionArchivo);
			}

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);

			// Escribe los datos en el nuevo archivo
			for (Object objeto : objetos) {
				bw.write(objeto.toString());
				bw.newLine();
			}

			bw.close();
			fw.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error al registrar datos, favor contactar con administrador");
			return false;
		}
	}
}