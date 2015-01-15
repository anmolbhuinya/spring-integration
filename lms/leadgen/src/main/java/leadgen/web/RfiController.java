package leadgen.web;

import leadgen.model.Rfi;
import leadgen.service.RfiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RfiController {
	
	@Autowired
	private RfiService rfiService;
	
	@RequestMapping(value = "/rfi/form.html", method = RequestMethod.GET)
	public void getForm(Model model) {
		model.addAttribute(new Rfi());
	}
	
	@RequestMapping(value = "/rfi/form.html", method = RequestMethod.POST)
	public String postForm(Rfi rfi) {
		
		// In a real implementation, we'd validate the RFI before doing
		// anything else with it.
		rfiService.submitRfi(rfi);
		return "redirect:thanks.html";
	}
	
	@RequestMapping(value = "/rfi/thanks.html", method = RequestMethod.GET)
	public void thanks() { }
}
