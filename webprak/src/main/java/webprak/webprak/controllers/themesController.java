package webprak.webprak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import webprak.webprak.DAO.impl.ThemesDAOimpl;
import webprak.webprak.tables.themes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Controller
public class themesController {
    @Autowired
    ThemesDAOimpl th;
    @GetMapping("/themes")
    public String GetThemes(Model model)
    {
//        List<themes> all_themes = th.getAll().stream().toList();
        Iterable<themes> all_themes = th.getAll();
//        List<String> l = new ArrayList<>();
//        for (themes t: all_themes){
////            System.out.println(t.theme_name);
//            l.add(t.getTheme_name());
//        }

        model.addAttribute("all_themes", all_themes);
        return "themes";
    }
}
