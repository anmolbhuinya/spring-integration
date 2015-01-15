package leadgen.service;

import java.io.IOException;
import java.util.logging.Logger;

import leadgen.model.Rfi;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RfiServiceImpl implements RfiService {
	private static Logger log = Logger.getLogger("global");
	
	@Autowired
	private String submitRfiUri;

	public void submitRfi(Rfi rfi) {
		log.info("Submitting RFI");
		
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(submitRfiUri);
		post.addParameter("firstName", rfi.getFirstName());
		post.addParameter("lastName", rfi.getLastName());
		post.addParameter("address1", rfi.getAddress1());
		post.addParameter("address2", rfi.getAddress2());
		post.addParameter("city", rfi.getCity());
		post.addParameter("stateOrProvince", rfi.getState());
		post.addParameter("postalCode", rfi.getZipCode());
		post.addParameter("homePhone", rfi.getHomePhone());
		post.addParameter("workPhone", rfi.getWorkPhone());
		post.addParameter("mobilePhone", rfi.getMobilePhone());
		post.addParameter("email", rfi.getEmail());
		
		try {
			int statusCode = client.executeMethod(post);
			log.info("RFI submitted; HTTP status code=" + statusCode);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			post.releaseConnection();
		}
	}
}
