package webprak.webprak.DAO;
import webprak.webprak.tables.person;
public abstract class PersonDAO {
    public abstract void addPerson(person new_person);
    public abstract void deletePerson(person new_person);
    public abstract void changeRole(person new_person);
    public abstract void getPersonById(int id);

}
