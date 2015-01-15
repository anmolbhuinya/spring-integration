package crm.integration.routers;

import java.util.logging.Logger;

import org.springframework.integration.annotation.Router;

import crm.model.Lead;

public class CountryRouter {
	private static Logger log = Logger.getLogger("global");
	
	@Router
	public String route(Lead lead) {
		String destination = (lead.isInternational() ?
				"internationalChannel" : "domesticChannel");
		log.info("Lead country is " +
				lead.getCountry() + "; routing to " + destination);
		return destination;
	}
}
