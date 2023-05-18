package webprak.webprak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import webprak.webprak.DAO.impl.MessageDAOimpl;
import webprak.webprak.DAO.impl.PersonDAOimpl;
import webprak.webprak.DAO.impl.TopicDAOimpl;
import webprak.webprak.tables.messages;
import webprak.webprak.tables.topics;

import java.util.Comparator;
import java.util.List;


@Controller
public class topicsController {

    @Autowired
    TopicDAOimpl top;

    @Autowired
    MessageDAOimpl messageDAOimpl;

    @Autowired
    PersonDAOimpl personDAOimpl;
    @PostMapping("/")
    public String search(Model model, @RequestParam(name = "search_word", required = false) String search_word){
        List<topics> ls = top.searchTopic(search_word);
        model.addAttribute("list", ls);
        return "topic_search";
    }
    @GetMapping("/topic")
    public String enterTopic(Model model, @RequestParam(name = "id") Long id){
        topics cur_topic = top.getById(id);
        List<messages> ls = top.getMessages(cur_topic);
        model.addAttribute("list", ls);
        return "topic";
    }
    @PostMapping("/topic")
    public String addmess(Model model, @RequestParam(name = "password", required = false) String id, @RequestParam(name = "text", required = false) String message_text){
        messageDAOimpl.addMessage(top.getById(1L), personDAOimpl.getById(Long.parseLong(id)), message_text);
        topics cur_topic = top.getById(1L);
        List<messages> ls = top.getMessages(cur_topic);
        model.addAttribute("list", ls);
        return "topic";
    }
}
