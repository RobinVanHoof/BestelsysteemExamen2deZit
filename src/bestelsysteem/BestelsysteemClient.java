package bestelsysteem;

import org.restlet.resource.ClientResource;

public class BestelsysteemClient {

	public static void main(String[] args) {
        
        try {
       	ClientResource resource = new ClientResource("http://localhost:8182/bestelsysteem/bestellingen");
       	// Post a new bestelling
       	String bestelling1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
       	bestelling1 += "<bestelling naam_klant=\"Robin\" adres=\"meistraat 5\" datum_bestelling=\"4/09/2017\" productnaam=\"laptop\" hoeveelheid=\"1\">";
       	bestelling1 += "</bestelling>";
   		resource.post(bestelling1);
   		// get the response
       	System.out.println(resource.getResponseEntity().getText());
       	
       	String bestelling2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
       	bestelling2 += "<bestelling naam_klant=\"Jan\" adres=\"meistraat 5\" datum_bestelling=\"4/09/2017\" productnaam=\"desktop\" hoeveelheid=\"5\">";
       	bestelling2 += "</bestelling>";
   		resource.post(bestelling2);
   		// get the response
       	System.out.println(resource.getResponseEntity().getText());
       }
       catch (Exception e) {
           System.out.println("In main : " + e.getMessage());
       }

	}

}
