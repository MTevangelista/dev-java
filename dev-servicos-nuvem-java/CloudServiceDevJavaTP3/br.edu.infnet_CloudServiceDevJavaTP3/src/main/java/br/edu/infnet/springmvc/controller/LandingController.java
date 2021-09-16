package br.edu.infnet.springmvc.controller;

import br.edu.infnet.springmvc.constants.JSPPagesConstants;
import br.edu.infnet.springmvc.constants.RoutersConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingController {
    
    @RequestMapping(RoutersConstants.INDEX_ROUTER)
    public String landing() {
        return JSPPagesConstants.LANDING;
    }
    
    @RequestMapping(RoutersConstants.SIGNUP_ROUTER)
    public String signUp() {
        return JSPPagesConstants.SIGNUP;
    }

}
