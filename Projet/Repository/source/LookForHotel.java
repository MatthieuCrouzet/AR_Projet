import java.util.HashMap;

/**
 * J<i>ava</i> U<i>tilities</i> for S<i>tudents</i>
 */
import java.util.*;
/**
 * Repr�sente un client effectuant une requ�te lui permettant d'obtenir les num�ros de t�l�phone des hôtels r�pondant à son crit�re de choix.
 * @author  Morat
 */
public class LookForHotel{
	/** le crit�re de localisaton choisi */
	private String localisation;
	private AbstractList<Numero> ListeNum;
	// ...
	/**
	 * D�finition de l'objet repr�sentant l'interrogation.
	 * @param args les arguments n'en comportant qu'un seul qui indique le crit�re
	 *          de localisation
	 */
	public LookForHotel(String... args){
		localisation = args[0];
	}
	/**
	 * r�alise une interrogation
	 * @return la dur�e de l'interrogation
	 * @throws RemoteException
	 */
	public long call() {
		long time = System.currentTimeMillis();
		// ...
		return System.currentTimeMillis()-time;
	}

	// ...
}
