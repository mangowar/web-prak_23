package webprak.webprak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import webprak.webprak.DAO.impl.TopicDAOimpl;
import webprak.webprak.tables.topics;

@Controller
public class homeController {
    @Autowired
    TopicDAOimpl top;

    @GetMapping("/")
    public String start(Model model){
        topics last = top.getLatest();
        model.addAttribute("post", last.getTopic_name());
        return "home";
    }
}
