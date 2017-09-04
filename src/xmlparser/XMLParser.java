package xmlparser;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;

import java.io.*;

public class XMLParser {

	private String INPUTFILE = "bestellingen.xml";

	
	/**
	 * Get all bestellingen from the xml file and return them in html format
	 */
	/*public String getBestellingen() {
		File inputFile = new File(INPUTFILE);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			String result = "<h2>Bestellingen</h2>";

			NodeList races = doc.getElementsByTagName("patient");

			for (int i = 0; i < races.getLength(); i++) {
				Node nNode = races.item(i);
				Element eElement = (Element) nNode;

				result += "<br/><b>Datum en uur : </b>" + eElement.getAttribute("datehour");
				result += "<br/><b>Naam patiënt : </b>" + eElement.getAttribute("namePatient");
				result += "<br/><b>Geboortedatum patiënt : </b>" + eElement.getAttribute("dobPatient");
				result += "<br/><b>Naam verpleegkundige : </b>" + eElement.getAttribute("nameNurse");
				result += "<br/><b>Diagnose : </b>" + eElement.getElementsByTagName("diagnose").item(0).getTextContent();
				result += "<br/>";
			}

			return result;
		} catch (Exception e) {
			return e.getMessage();
		}
	}*/
	
	
	/**
	 * Add a bestelling and return all bestellingen in html format
	 */
	public void addBestelling(String xml) {
		File inputFile = new File(INPUTFILE);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// set validating false to enable copying
		// node from one document to another
		dbFactory.setValidating(false);
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc1 = dBuilder.parse(inputFile);
			Document doc2 = dBuilder.parse(new InputSource(new StringReader(xml)));
			Element element = (Element) doc2.getDocumentElement();
			// imports a node from doc2 document to doc1, without altering
			// or removing the source node from the original document
			Node copiedNode = doc1.importNode(element, true);
			// adds the node to the end of the list of children of this node
			doc1.getDocumentElement().appendChild(copiedNode);

			/*
			 * FileWriter fw = new FileWriter(INPUTFILE);
			 * fw.write(doc1.toString()); fw.close();
			 */
			// write the new document to file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc1);
			StreamResult result = new StreamResult(new File(INPUTFILE));
			transformer.transform(source, result);

			/*return this.getPatients();*/
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Utility method to print xml document
	 */
	public String prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
		return out.toString();
	}
}
