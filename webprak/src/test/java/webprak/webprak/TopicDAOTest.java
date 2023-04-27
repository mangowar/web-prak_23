package webprak.webprak;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import webprak.webprak.DAO.impl.ThemesDAOimpl;
import webprak.webprak.DAO.impl.TopicDAOimpl;
import webprak.webprak.tables.topics;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes=WebprakApplication.class)

public class TopicDAOTest {
    @Autowired
    ThemesDAOimpl themesDAO = new ThemesDAOimpl();

    @Autowired
    TopicDAOimpl top = new TopicDAOimpl();
    @Test
    void addTopicTest(){
        topics t = top.addTopic("test_topic", themesDAO.getById(1L));
        assertNotNull(t);
    }

    @Test
    void removeTopicTest(){
        topics t = top.addTopic("test_topic_remove", themesDAO.getById(1L));
        Long t_id = t.getId();
        top.removeTopic(t);
        assertNull(top.getById(t_id));
    }
    @Test
    void getMembersTest(){
        List<Long> lst = top.getMembers(top.getById(1L));
        System.out.println(lst);
        assertNotNull(lst);
    }
}
