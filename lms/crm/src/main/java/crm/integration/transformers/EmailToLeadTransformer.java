package crm.integration.transformers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.integration.annotation.Transformer;

import crm.model.Lead;

public class EmailToLeadTransformer {
	private static Logger log = Logger.getLogger("global");
	
	@Transformer
	public Lead transform(MimeMessage email) {
		log.info("Transforming e-mail to lead");
		try {
			InternetAddress from = (InternetAddress) email.getFrom()[0];
			String fullName = from.getPersonal();
			
			Lead lead = new Lead();
			lead.guessNamesFromFullName(fullName);
			lead.setEmail(from.getAddress());
			lead.setDateCreated(email.getSentDate());
			
			StringBuilder builder = new StringBuilder("Full name: " + fullName);
			builder.append("\nSubject: " + email.getSubject());
			
			// FIXME Doesn't work with MimeMultipart. Output looks like this:
			// javax.mail.internet.MimeMultipart@598d00
			builder.append("\n\n" + email.getContent().toString());
			
			List<String> notes = new ArrayList<String>();
			notes.add(builder.toString());
			lead.setNotes(notes);
			
			log.info("Transformed e-mail to lead: " + lead);
			return lead;
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
