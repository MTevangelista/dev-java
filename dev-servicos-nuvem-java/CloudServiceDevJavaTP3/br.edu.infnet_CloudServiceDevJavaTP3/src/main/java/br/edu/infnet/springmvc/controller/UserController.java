package br.edu.infnet.springmvc.controller;

import br.edu.infnet.springmvc.client.Address;
import br.edu.infnet.springmvc.client.ViaCepClient;
import br.edu.infnet.springmvc.constants.CommonsConstants;
import br.edu.infnet.springmvc.constants.ErrorMessagesConstants;
import br.edu.infnet.springmvc.constants.FormActionsConstants;
import br.edu.infnet.springmvc.constants.JSPPagesConstants;
import br.edu.infnet.springmvc.constants.RoutersConstants;
import br.edu.infnet.springmvc.model.service.UserService;
import br.edu.infnet.springmvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(FormActionsConstants.HANDLE_SIGNUP)
    public String handleSignUp(User userViewObj, ModelMap model) {
        User user;
        String errorMessage;
        String address;
        
        user = userService.getByEmail(userViewObj.getEmail());
        if (user != null) {
            errorMessage = ErrorMessagesConstants.EMAIL_ALREADY_EXISTS;
            model.addAttribute(CommonsConstants.ERROR_MESSAGE_JSP_VAR, errorMessage);
            return JSPPagesConstants.SIGNUP;
        }
        address = getAddressByCep(userViewObj.getCep());
        userService.save(
                new User(
                        userViewObj.getName(),
                        userViewObj.getEmail(),
                        userViewObj.getPhone(),
                        userViewObj.getCep(),
                        address
                ));
        return JSPPagesConstants.LANDING;
    }
    
    @RequestMapping(RoutersConstants.PROFILE_ROUTER)
    public String getUser(@RequestParam int id, ModelMap model) {
        User user;
        
        user = userService.getById(id);
        model.addAttribute(CommonsConstants.USER, user);
        return JSPPagesConstants.PROFILE;
    }
    
    @RequestMapping(FormActionsConstants.HANDLE_UPDATE_USER)
    public String updateUser(User user) {
        String address;
        address = getAddressByCep(user.getCep());
        user.setAddress(address);
        userService.save(user);
        return JSPPagesConstants.LANDING;
    }
    
    private String getAddressByCep(String cep) {
        String result;
        Address address;
        ViaCepClient viaCepClient = new ViaCepClient();
        
        try {
            address = viaCepClient.getAddressBy(cep);
            result = address.toString();
        } catch (Exception e) {
            result = "";
        }
        return result;
    }
    
}
