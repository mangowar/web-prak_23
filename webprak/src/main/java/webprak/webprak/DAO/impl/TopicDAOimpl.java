package webprak.webprak.DAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import webprak.webprak.DAO.TopicDAO;
import webprak.webprak.tables.messages;
import webprak.webprak.tables.person;
import webprak.webprak.tables.themes;
import webprak.webprak.tables.topics;

import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class TopicDAOimpl extends TableDAOimpl<topics, Long> implements TopicDAO {

    public TopicDAOimpl() {
        super(topics.class);
    }
    @Autowired
    ThemesDAOimpl themesDAO;
    @Override
    public topics addTopic(String name, themes t){
        topics new_topic = new topics();
        new_topic.setTopic_name(name);
        new_topic.setTheme_id(t);
        this.save(new_topic);
        return new_topic;
    }

    @Override
    public void removeTopic(topics topic){
        this.delete(topic);
    }

    public List<Long> getMembers(topics t){
        java.util.List<messages> q = null;
        try (Session session = sessionFactory.openSession())
        {
            Query<messages> query = session
                    .createQuery("SELECT ms FROM messages ms WHERE ms.topic_id = :ident", messages.class)
                    .setParameter("ident", t);
            q = query.getResultList();
            List<Long> result = new ArrayList<>();
            for(messages q1: q) {
                result.add(q1.getPerson_id().getPerson_id());
            }
            return result;
        }
    }

    public topics getLatest(){
        topics latest = null;
        try (Session session = sessionFactory.openSession())
        {
            Query<topics> query = session.createQuery("SELECT t from topics t order by t.topic_id desc", topics.class);
            List<topics> l = query.getResultList();
            latest = l.get(0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return latest;
    }

    public List<topics> searchTopic(String name){
        List<topics> ls = null;
        try (Session session = sessionFactory.openSession())
        {
            String templ = "%"+name+"%";
            Query<topics> query = session
                    .createQuery("SELECT t from topics t where t.topic_name like :n", topics.class)
                    .setParameter("n", templ);
            ls = query.getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ls;
    }
    public List<messages> getMessages(topics topic){
        List<messages> ls = null;
        try (Session session = sessionFactory.openSession())
        {
            Query<messages> query = session
                    .createQuery("SELECT m from messages m where m.topic_id = :n order by m.message_id desc", messages.class)
                    .setParameter("n", topic);
            ls = query.getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ls;
    }
}
