/**
 * 
 */
package listadoEstructurasDeDatos3.TopMusic;

import java.util.Calendar;

/**
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Cancion {
	
		private String titulo, artista;
		private int anno;
		
		private Cancion(String titulo, String artista, int anno){
			setTitulo(titulo);
			setArtista(artista);
			setAnno(anno);
		}
		
		static Cancion getInstance(String titulo, String artista, int anno){
			Calendar calendar = Calendar.getInstance();
			if(!titulo.matches("[\\w\\d\\sñÑ'-]+") || !artista.matches("[\\w\\d\\sñÑ'-]+") || anno>calendar.get(Calendar.YEAR) || anno < 1900)
				return null;
			return new Cancion(titulo, artista, anno);
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getArtista() {
			return artista;
		}

		public void setArtista(String artista) {
			this.artista = artista;
		}

		public int getAnno() {
			return anno;
		}

		public void setAnno(int anno) {
			this.anno = anno;
		}
		

		@Override
		public String toString() {
			return "[titulo=" + titulo + ", artista=" + artista + ", anno=" + anno + "]";
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
