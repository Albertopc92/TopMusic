/**
 * 
 */
package listadoEstructurasDeDatos3.TopMusic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class TopMusic {
	
	private ArrayList<Cancion> topMusic = new ArrayList<Cancion>();
	
	/**
	 * Comprueba si la posicion indicada por el usuario es correcta
	 * @param index
	 * 				Posicion introducida por el usuario
	 * @return
	 * 				false si no es correcta
	 */
	boolean posicionValida(int index) {
		if(index-1 < 0 || index-1 > size())
			return false;
		return true;
	}
	
	/**
	 * Añade una cancion a la lista
	 * @param titulo
	 * 					Titulo de la cancion
	 * @param artista
	 * 					Artista de la cancion
	 * @param anno
	 * 					Año de la cancion
	 * @param index
	 * 					Posicion en la que añadir la cancion
	 * @return
	 * 					false si no se ha podido añadir la cancion
	 */
	boolean addCancion(String titulo, String artista, int anno, int index) {
			Cancion cancion = new Cancion(titulo, artista, anno);
			if(topMusic.contains(cancion))
				return false;
			topMusic.add(index - 1, cancion);
			return true;
	}
	
	/**
	 * Elimina una cancion de la lista
	 * @param index
	 * 				Posicion de la cancion en la lista
	 * @return
	 * 				false si no se ha podido eliminar
	 */
	boolean delCancion(int index) {
		if(isEmpty() || index-1 < 0 || index-1 > size())
			return false;
		if(topMusic.remove(topMusic.get(index-1)))
			return true;
		return false;
	}
	
	/**
	 * Sube la posicion de un elemento en el TopMusic
	 * @param index
	 * 				Elemento que va a subir una posicion
	 * @return
	 * 				false si no se ha podido realizar la operacion
	 */
	boolean upPosition(int index) {
		if(isEmpty() || index-1 < 0 || index-1 > size() || index-1 < 1) {
			return false;
		}else {
			topMusic.add(index - 2, topMusic.remove(index-1));
			return true;
		}
	}
	
	/**
	 * Baja la posicion de un elemento en el TopMusic
	 * @param index
	 * 				Elemento que va a bajar una posicion
	 * @return
	 * 				false si no se ha podido realizar la operacion
	 */
	boolean downPosition(int index) {
		if(isEmpty() ||index-1 < 0 || index-1 > size() || index-1 > size()-1) {
			return false;
		}else {
			topMusic.add((index-1) + 1, topMusic.remove(index-1));
			return true;
		}
	}
	
	/**
	 * Devuelve el valor del tamaño de la lista
	 * @return
	 * 			Tamaño de la lista
	 */
	private int size() {
		return topMusic.size();
	}
	
	/**
	 * Muestra las 10 canciones mas escuchadas
	 * @return
	 */
	StringBuilder top10() {
		StringBuilder top10 = new StringBuilder();
		
		Iterator<Cancion> it = topMusic.iterator();
		int i = 0;
		while(it.hasNext()) {
			top10.append(it.next().toString());
			if(i++ == 9)
				break;
		}
		
		return top10;
	}
	
	/**
	 * Muestra la lista
	 */
	StringBuilder show() {
		StringBuilder lista = new StringBuilder();
		
		Iterator<Cancion> it = topMusic.iterator();
		while(it.hasNext()) {
			lista.append(it.next().toString());
		}
		
			return lista;
	}
	
	/**
	 * Muestra el elemento primero de la lista
	 */
	Cancion top() {
		if(isEmpty())
			return null;
		return topMusic.get(0);
	}
	
	/**
	 * Comprueba si la lista esta vacia
	 * @return
	 * 			true si esta vacia
	 */
	private boolean isEmpty() {
		return topMusic.isEmpty();
	}
	
}
