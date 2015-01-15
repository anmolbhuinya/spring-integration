package xcrm.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LogServlet extends HttpServlet {
	private static Logger log = Logger.getLogger("global");
	
	public void service(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException {
		
		String line;
		BufferedReader br = new BufferedReader(req.getReader());
		while ((line = br.readLine()) != null) { log.info(line); }
		
		res.setStatus(HttpServletResponse.SC_CREATED);
		res.setHeader("Location", "http://blah.blah.blah/");
		res.flushBuffer();
	}
}
