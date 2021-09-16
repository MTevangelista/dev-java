package br.edu.infnet.springmvc.controller;

import br.edu.infnet.springmvc.model.service.UserService;
import br.edu.infnet.springmvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("handleSignUp")
    public String handleSignUp(User user) {
        userService.signUp(user);
        return "successful-register";
    }
    
    @RequestMapping("goToLogin")
    public String goToLogin() {
        return "login";
    }
    
//    @RequestMapping("handleLogin")
//    public String handleLogin(@RequestParam("email")String email, @RequestParam("password")String password, Model model) {
//        String msg = "";
//        boolean userAlreadyExists;
//        String returnState;
//        
//        userAlreadyExists = userService.validate(email, password);
//        if (userAlreadyExists) {
//            returnState = "successful-login";
//        } else {
//            msg = "Credenciais inválidas";
//            returnState = "login";
//        }
//        model.addAttribute("msg", msg);
//        return returnState;
//    }
//    
    @RequestMapping("handleLogin")
    public String handleLogin(@RequestParam("email")String email, @RequestParam("password")String password, Model model) {
        String msg;
        String returnState;
        
        User user = userService.validate(email, password);
        if ((user != null) && (password.equals(user.getPassword()))) {
            model.addAttribute("user", user);
            returnState = "successful-login";
        } else {
            msg = "Credenciais inválidas";
            model.addAttribute("msg", msg);
            returnState = "login";
        }
        return returnState;
    }

}
