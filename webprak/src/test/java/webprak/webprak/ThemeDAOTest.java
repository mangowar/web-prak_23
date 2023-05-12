package webprak.webprak;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import webprak.webprak.DAO.impl.ThemesDAOimpl;
import webprak.webprak.tables.themes;
import webprak.webprak.tables.topics;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes=WebprakApplication.class)

public class ThemeDAOTest {
    @Autowired
    ThemesDAOimpl themeDAO;

    @Test
    void addThemeTest(){
        themes t = themeDAO.addTheme("theme1", 17L);
        assertNotNull(themeDAO.getById(t.getId()));
        t.setId(1000L);
        t.getTheme_name();
        t.getTheme_id();
        t.getClass();
        t.getTheme_creator();
    }

    @Test
    void removeThemeTest(){
        themes t = themeDAO.addTheme("theme2", 17L);
        Long t_id = t.getTheme_id();
        themeDAO.removeTheme(t);
        assertNull(themeDAO.getById(t_id));
    }

    @Test
    void getTopicsTest(){
        List<Long> lst = themeDAO.getTopics(themeDAO.getById(1L));
        assertNotNull(lst);
    }

}
