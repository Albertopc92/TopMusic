package listadoEstructurasDeDatos3.TopMusic;

import utiles.Menu;
import utiles.Teclado;

/**
 * TopMusic. Implementa un programa que gestione una lista de las canciones más
 * escuchadas. El usuario podrá: a. Añadir una canción (en una posición) al
 * TopMusic. b. Sacar un elemento del TopMusic. c. Subir un puesto en el
 * TopMusic. d. Bajar un puesto en el TopMusic. e. Mostrar la lista TopMusic. f.
 * Mostrar la canción más escuchada. Sobre la canción se almacenará el título,
 * artista o grupo y año de grabación.
 * 
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class TestTopMusic {

	static TopMusic topMusic = new TopMusic();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Menu menu = new Menu("---------- TopMusic ----------", new String[] { "Añadir cancion", "Eliminar cancion",
				"Subir puesto", "Bajar puesto", "Mostrar lista", "Mostrar cancion mas escuchada", "Mostrar top 10" });

		do {
			switch (menu.gestionar()) {
			case 1:
				addCancion();
				break;
			case 2:
				delCancion();
				break;
			case 3:
				upPosition();
				break;
			case 4:
				downPosition();
				break;
			case 5:
				show();
				break;
			case 6:
				top();
				break;
			case 7:
				top10();
				break;
			default:
				System.out.println("Has salido del programa.");
				return;
			}
		} while (true);
		
	}

	/**
	 * Muestra el top 10 de la lista
	 */
	private static void top10() {
		System.out.println(topMusic.top10());
	}

	/**
	 * Muestra la cancion mas escuchada
	 */
	private static void top() {
		if (topMusic.top() == null)
			System.out.println("La lista esta vacia");
		else
			System.out.println(topMusic.top());
	}

	/**
	 * Muestra el TopMusic
	 */
	private static void show() {
		System.out.println(topMusic.show());
	}

	/**
	 * Baja la posicion de una cancion
	 */
	private static void downPosition() {
		if (topMusic.downPosition(Teclado.leerEntero("Indice de la cancion:")))
			System.out.println("Bajo una posicion");
		else
			System.out.println("No se pudo realizar la operacion");
	}

	/**
	 * Sube la posicion de una cancion en la lista
	 */
	private static void upPosition() {
		if (topMusic.upPosition(Teclado.leerEntero("Indice de la cancion:")))
			System.out.println("Subio una posicion");
		else
			System.out.println("No se ha podido realizar la operacion");
	}

	/**
	 * Elimina una cancion de la lista
	 */
	private static void delCancion() {
		if (topMusic.delCancion(Teclado.leerEntero("Introduce el indice de la cancion que desea eliminar: ")))
			System.out.println("Se ha eliminado correctamente");
		else
			System.out.println("No se ha podido eliminar");
	}

	/**
	 * Añade una cancion al topMusic
	 */
	private static void addCancion() {
		int posicion = Teclado.leerEntero("Posicion:");
		if (topMusic.posicionValida(posicion)) {
			if (topMusic.addCancion(Teclado.leerCadena("Titulo:"), Teclado.leerCadena("Nombre del artista:"),
					Teclado.leerEntero("Año:"), posicion))
				System.out.println("Se ha añadido con exito");
			else
				System.out.println("No se ha podido añadir");
		}else {
			System.out.println("Posicion no valida");
		}
	}

}
