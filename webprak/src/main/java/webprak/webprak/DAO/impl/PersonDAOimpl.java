package webprak.webprak.DAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import webprak.webprak.DAO.PersonDAO;
import webprak.webprak.DAO.TableDAO;
import webprak.webprak.tables.person;
import static webprak.webprak.utils.HibernateUtil.*;

@Repository
public class PersonDAOimpl extends TableDAOimpl<person, Long> implements PersonDAO {

    @Override
    public void addPerson(person new_person) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(new_person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deletePerson(person new_person){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(new_person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void changeRole(person new_person){
    }

    @Override
    public void getPersonById(int id) {

    }
}
