package webprak.webprak.DAO.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import webprak.webprak.DAO.ThemesDAO;
import webprak.webprak.tables.themes;
import webprak.webprak.tables.topics;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class ThemesDAOimpl extends TableDAOimpl<themes, Long> implements ThemesDAO {
    public ThemesDAOimpl() {
        super(themes.class);
    }

    @Autowired

    private PersonDAOimpl personDAO;
    @Override
    public themes addTheme(String name, Long creator) {
        themes t = new themes();
        t.setTheme_name(name);
        t.setTheme_creator(personDAO.getPersonById(creator));
        this.save(t);
        return t;
    }
    @Override
    public void removeTheme(themes theme) {
        this.delete(theme);
    }

    @Override
    public List<Long> getTopics(themes theme) {
        java.util.List<topics> q = null;
        try (Session session = sessionFactory.openSession()) {
            Query<topics> query = session
                    .createQuery("SELECT tp FROM topics tp WHERE tp.theme_id = :ident", topics.class)
                    .setParameter("ident", theme);
            q = query.getResultList();
            List<Long> result = new ArrayList<>();
            for(topics q1: q) {
                result.add(q1.getTopic_id());
            }
//            return query.getResultList().size() == 0 ? null : query.getResultList();
            return result;
        }
    }
}
