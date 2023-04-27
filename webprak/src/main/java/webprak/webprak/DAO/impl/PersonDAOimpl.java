package webprak.webprak.DAO.impl;

import lombok.NonNull;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import webprak.webprak.DAO.PersonDAO;
import webprak.webprak.DAO.TableDAO;
import webprak.webprak.tables.person;

import java.sql.Date;
import java.time.Instant;

import static webprak.webprak.utils.HibernateUtil.*;

@Repository
@Component
public class PersonDAOimpl extends TableDAOimpl<person, Long> implements PersonDAO {

    public PersonDAOimpl() {
        super(person.class);
    }

    @Override
    public person addPerson(String login, String password) {
        person new_person = new person();
        new_person.setLogin(login);
        new_person.setPassword(password);
        new_person.setRole("user");
        long millis = System.currentTimeMillis();
        new_person.setRegistration_date(new Date(millis));
        this.save(new_person);
        return new_person;
    }

    @Override
    public void deletePerson(person new_person){
        this.delete(new_person);
    }

    @Override
    public void changeRole(person entity_person, String role){
        entity_person.setRole(role);
        this.update(entity_person);
    }

    @Override
    public person getPersonById(Long id) {
        person p = getById(id);
        return p;
    }
}
