import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Chaine extends UnicastRemoteObject implements _Chaine {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	List<Hotel> hotels;
	
	protected Chaine(String path) throws SAXException, IOException, ParserConfigurationException {
		String[] tmp =  path.split("/");
		tmp = tmp[tmp.length-1].split(".");
		this.name = tmp[0];
		
		/* récupération des hôtels de la chaîne dans le fichier xml passé en 1er argument */
		DocumentBuilder docBuilder = null;
		Document doc=null;
		docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		doc = docBuilder.parse(new File(path));

		String name, localisation;
		NodeList list = doc.getElementsByTagName("Hotel");
		NamedNodeMap attrs;
		/* acquisition de toutes les entrées de la base d'hôtels */
		for(int i =0; i<list.getLength();i++) {
			attrs = list.item(i).getAttributes();
			name=attrs.getNamedItem("name").getNodeValue();
			localisation=attrs.getNamedItem("localisation").getNodeValue();
			hotels.add(new Hotel(name,localisation));
		}
	}

	
	public String name() throws RemoteException {
		return this.name.toString();
	}
	
	
	
	
	@Override
	public List<Hotel> get(String localisation) {
		// TODO Auto-generated method stub
		return null;
	}

}