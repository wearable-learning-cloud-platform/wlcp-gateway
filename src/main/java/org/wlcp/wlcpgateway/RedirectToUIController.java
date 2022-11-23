package org.wlcp.wlcpgateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.RedirectView;

@Controller
public class RedirectToUIController {
	
	@GetMapping("/")
	public RedirectView localRedirect() {
	    RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("../wlcp-ui/index.html");
	    return redirectView;
	}
	
	@GetMapping("/healthCheck")
	public ResponseEntity<String> healthCheckt() {
		return new ResponseEntity<String>("200 OK", HttpStatus.OK);
	}

}
