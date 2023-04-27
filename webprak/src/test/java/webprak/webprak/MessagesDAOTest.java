package webprak.webprak;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import webprak.webprak.DAO.impl.MessageDAOimpl;
import webprak.webprak.DAO.impl.PersonDAOimpl;
import webprak.webprak.DAO.impl.TopicDAOimpl;
import webprak.webprak.tables.messages;
import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(classes=WebprakApplication.class)

public class MessagesDAOTest {
    @Autowired
    MessageDAOimpl mesDAO = new MessageDAOimpl();

    @Autowired
    TopicDAOimpl top;

    @Autowired
    PersonDAOimpl personDAO;

    @Test
    public void addMesTest(){
        messages mes = mesDAO.addMessage(top.getById(14L), personDAO.getById(21L), "text");
        Long m_id = mes.getId();
        assertNotNull(mesDAO.getById(m_id));
    }

    @Test
    public void deleteMesTest(){
        messages mes = mesDAO.addMessage(top.getById(14L), personDAO.getById(21L), "text");
        Long m_id = mes.getId();
        mesDAO.deleteMessage(mes);
        assertNull(mesDAO.getById(m_id));
    }
}
