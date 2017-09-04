package bestelsysteem;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import xmlparser.XMLParser;

public class BestelsysteemResource extends ServerResource {

	
	/*@Get("html")
	public String getPatients() {
		XMLParser parser = new XMLParser();
		return parser.getPatients();
	}*/
	
	@Post("txt")
	public void addBestelling(String xml) {
		XMLParser parser = new XMLParser();
		parser.addBestelling(xml);
	}
}
