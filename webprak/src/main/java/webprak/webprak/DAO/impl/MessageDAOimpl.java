package webprak.webprak.DAO.impl;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import webprak.webprak.DAO.MessageDAO;
import webprak.webprak.tables.messages;
import webprak.webprak.tables.person;
import webprak.webprak.tables.themes;
import webprak.webprak.tables.topics;

import java.sql.Date;

@Repository
@Component
public class MessageDAOimpl extends TableDAOimpl<messages, Long> implements MessageDAO {
    public MessageDAOimpl() {
        super(messages.class);
    }

    public messages addMessage(topics topic_id, person pers_id, String mes_text){
        messages m = new messages();
        m.setTopic_id(topic_id);
        m.setPerson_id(pers_id);
        m.setMessage_text(mes_text);
        long millis = System.currentTimeMillis();
        m.setDate(new Date(millis));
        this.save(m);
        return m;
    }

    @Override
    public void deleteMessage(messages new_message) {
        this.delete(new_message);
    }
}
