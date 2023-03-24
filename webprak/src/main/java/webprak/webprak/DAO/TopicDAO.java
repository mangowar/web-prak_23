package webprak.webprak.DAO;
import webprak.webprak.tables.topics;
import webprak.webprak.tables.person;

import java.util.List;

public abstract class TopicDAO {
    public abstract void addTopic(topics new_topic);
    public abstract void removeTopic(topics topic);
    public abstract List<person> getMembers(topics topic);

}
