/**
 * 
 */
package listadoEstructurasDeDatos3.TopMusic;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Cancion {

	private static final Pattern patronArtista = Pattern.compile("[\\w\\d\\s��'-]+");
	private static final Calendar calendar = Calendar.getInstance();
	private String titulo, artista;
	private int anno;

	public Cancion(String titulo, String artista, int anno) throws CancionNoValidaException, FechaNoValidaException{
		setTitulo(titulo);
		setArtista(artista);
		setAnno(anno);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws CancionNoValidaException {
			Matcher matcherArtista = patronArtista.matcher(titulo);
		
			if(!matcherArtista.matches()) 
				throw new CancionNoValidaException("Titulo no valido");
			
			this.titulo = titulo;
		}
	
	public void setArtista(String artista) throws CancionNoValidaException {
		Matcher matcherArtista = patronArtista.matcher(artista);
	
		if(!matcherArtista.matches()) 
			throw new CancionNoValidaException("Artista no valido");
		
		this.artista = artista;
	}

	public String getArtista() {
		return artista;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) throws FechaNoValidaException {
		if (anno > calendar.get(Calendar.YEAR) || anno < 1900)
			throw new FechaNoValidaException("Año no valido");
		
		this.anno = anno;
	}

	@Override
	public String toString() {
		return "[titulo=" + titulo + ", artista=" + artista + ", anno=" + anno + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
