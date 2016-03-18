package server;
import java.io.File;
import java.io.IOException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Annuaire extends UnicastRemoteObject implements _Annuaire {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7305673753258466711L;
	Map<String,Numero> numeros;
	
	protected Annuaire(String filename) throws ParserConfigurationException, SAXException, IOException {
		String path = "Repository/DataStore/" + filename;
		
		/* Récupération de l'annuaire dans le fichier xml */
		DocumentBuilder docBuilder = null;
		Document doc = null;
		docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		doc = docBuilder.parse(new File(path));
		
		String name, numero;
		NodeList list = doc.getElementsByTagName("Telephone");
		NamedNodeMap attrs;
		
		numeros = new HashMap<String, Numero>();
		
		/* acquisition de toutes les entrées de l'annuaire */
		for(int i =0; i<list.getLength();i++) {
			attrs = list.item(i).getAttributes();
			name = attrs.getNamedItem("name").getNodeValue();
			numero = attrs.getNamedItem("numero").getNodeValue();
			numeros.put(name, new Numero(numero));
		}
		
	}

	@Override
	public Numero get(String abonne) {
		return numeros.get(abonne);
	}

}
