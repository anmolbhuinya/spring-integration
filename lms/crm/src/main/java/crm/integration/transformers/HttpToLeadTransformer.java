package crm.integration.transformers;

import java.util.Date;
import java.util.Map;

import org.springframework.integration.annotation.Transformer;

import crm.model.Lead;

public class HttpToLeadTransformer {
	
	@Transformer
	public Lead transform(Map<String, String[]> params) {
		Lead lead = new Lead();
		lead.setFirstName(value("firstName", params));
		lead.setMiddleInitial(value("middleInitial", params));
		lead.setLastName(value("lastName", params));
		lead.setCountry(value("country", params));
		lead.setAddress1(value("address1", params));
		lead.setAddress2(value("address2", params));
		lead.setCity(value("city", params));
		lead.setStateOrProvince(value("stateOrProvince", params));
		lead.setPostalCode(value("postalCode", params));
		lead.setHomePhone(value("homePhone", params));
		lead.setWorkPhone(value("workPhone", params));
		lead.setMobilePhone(value("mobilePhone", params));
		lead.setEmail(value("email", params));
		lead.setDateCreated(new Date());
		return lead;
	}
	
	private static String value(String name, Map<String, String[]> params) {
		String[] values = params.get(name);
		return (values == null ? null : values[0]);
	}
}
