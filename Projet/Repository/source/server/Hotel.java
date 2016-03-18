package server;
/**
 * J<i>ava</i> U<i>tilities</i> for S<i>tudents</i>
 */

import java.io.Serializable;

/**
 * Un hotel qui est caractérisé par son nom et sa localisation.
 * @author Morat 
 */
public class Hotel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** la localisation de l'hôtel */
	private String localisation;
	/** le nom de l'hôtel */
	private String name;
	/**
	 * Définition d'un hôtel par son nom et sa localisation.
	 * @param name le nom de l'hôtel
	 * @param localisation la localisation de l'hôtel
	 */
	public Hotel(String name, String localisation) { this.name=name; this.localisation=localisation;}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {return "Hotel{"+name+","+localisation+"}";}
	public String getLocalisation() {return this.localisation;}
	public String getName() {return this.name;}
}