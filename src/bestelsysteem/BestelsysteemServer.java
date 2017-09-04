package bestelsysteem;

import org.restlet.*;
import org.restlet.data.Protocol;

public class BestelsysteemServer {
	
	public static void main(String[] args) throws Exception {  
	    // Create a new Component.  
	    Component component = new Component();  

	    // Add a new HTTP server listening on port 8182.  
	    component.getServers().add(Protocol.HTTP, 8182);  

	    // Attach the sample application.  
	    component.getDefaultHost().attach("/bestelsysteem",  new BestelsysteemApplication());  

	    // Start the component.  
	    component.start();  
	}

}
