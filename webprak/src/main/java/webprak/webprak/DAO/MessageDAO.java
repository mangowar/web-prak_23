package webprak.webprak.DAO;

import webprak.webprak.tables.messages;
import webprak.webprak.tables.person;
import webprak.webprak.tables.themes;
import webprak.webprak.tables.topics;

public interface MessageDAO {
    public abstract messages addMessage(topics topic_id, person pers_id, String mes_text);
    public abstract void deleteMessage(messages new_message);
}
