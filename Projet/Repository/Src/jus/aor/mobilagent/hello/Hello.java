package jus.aor.mobilagent.hello;


import jus.aor.mobilagent.kernel._Action;
import jus.aor.mobilagent.kernel.Agent;

/**
 * Classe de test élémentaire pour le bus à agents mobiles
 * @author  Morat
 */
public class Hello extends Agent{

	private static final long serialVersionUID = 1L;
	private _Action doIt = new _Action() {
		private static final long serialVersionUID = 1L;
		public void execute() {
			System.out.println("Hello");
		}
		
	};
	
	private _Action retour = new _Action() {
		private static final long serialVersionUID = 1L;
		public void execute() {
			System.out.println("GoodBye");
		}
		
	};
	/**
	  * construction d'un agent de type hello.
	  * @param args aucun argument n'est requis
	  */
	 public Hello(Object... args) {
		 super();
	}
		// ...
	
	/* (non-Javadoc)
	 * @see jus.aor.mobilagent.kernel.Agent#retour()
	 */
	public _Action retour(){
		return this.retour;
	}

	public _Action getDoIt() {
		return doIt;
	}

	public void setDoIt(_Action doIt) {
		this.doIt = doIt;
	}
}