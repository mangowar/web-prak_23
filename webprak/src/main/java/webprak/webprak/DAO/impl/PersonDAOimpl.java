package webprak.webprak.DAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import webprak.webprak.DAO.PersonDAO;
import webprak.webprak.tables.person;
import static webprak.webprak.utils.HibernateUtil.*;

public class PersonDAOimpl extends PersonDAO {
    @Override
    public void addPerson(person new_person) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(new_person);
        session.getTransaction().commit();
        session.close();
    }
    
}
