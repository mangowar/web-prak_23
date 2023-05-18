package webprak.webprak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webprak.webprak.DAO.impl.PersonDAOimpl;
import webprak.webprak.tables.person;

@Controller
public class signupController {

    @Autowired
    PersonDAOimpl personDAOimpl;

    @GetMapping("/sign-up")
    public String GetSign_up(Model model){
        return "sign_up";
    }
    @PostMapping("/sign_up")
    public String reg(Model model, @RequestParam(name = "login", required = false) String log, @RequestParam(name = "password") String password){
        person p = personDAOimpl.addPerson(log, password);
        model.addAttribute("person", p);
        return "id_info";
    }
}
