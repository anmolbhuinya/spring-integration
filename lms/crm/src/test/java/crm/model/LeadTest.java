package crm.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LeadTest {
	
	@Test
	public void testIsInternational() {
		Lead lead = new Lead();
		
		lead.setCountry(null);
		assertFalse(lead.isInternational());
		
		lead.setCountry("US");
		assertFalse(lead.isInternational());
		
		lead.setCountry("MX");
		assertTrue(lead.isInternational());
	}
}
