package webprak.webprak.DAO;
import webprak.webprak.tables.person;
public interface PersonDAO extends TableDAO<person, Long> {
    public abstract person addPerson(String login, String password);
    public abstract void deletePerson(person new_person);
    public abstract void changeRole(person new_person, String role);
    public abstract person getPersonById(Long id);

}
