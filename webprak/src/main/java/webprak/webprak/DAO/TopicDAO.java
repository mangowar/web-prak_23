package webprak.webprak.DAO;
import webprak.webprak.tables.messages;
import webprak.webprak.tables.themes;
import webprak.webprak.tables.topics;
import webprak.webprak.tables.person;

import java.util.HashSet;
import java.util.List;

public interface TopicDAO {
    public abstract topics addTopic(String name, themes t);
    public abstract void removeTopic(topics topic);
    public abstract List<Long> getMembers(topics topic);

    public abstract List<topics> searchTopic(String name);
    public abstract List<messages> getMessages(topics topic);

}
