package webprak.webprak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import webprak.webprak.DAO.impl.PersonDAOimpl;
import webprak.webprak.tables.person;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes=WebprakApplication.class)
class WebprakApplicationTest {

	@Autowired
	public PersonDAOimpl personDao;

	@Test
	void contextLoads() {
	}



	@Test
	void testIsPersonDAONull() {
		person p = personDao.addPerson("login", "qwerty");
		assertNotNull(personDao.getPersonById(p.getId()));
	}

	@Test
	void testPersonDAOdelete(){
		person p = personDao.addPerson("password", "login");
		Long p_id = p.getId();
		assertNotNull(personDao.getPersonById(p.getId()));
		personDao.deletePerson(personDao.getById(p_id));
		assertNull(personDao.getById(p_id));
	}

	@Test
	void testPersonDAOchangeRole(){
		person p = personDao.getPersonById(17L);
		personDao.changeRole(p, "admin");
		assertEquals(p.getRole(), "admin");
	}

	@Test
	void testPersonDAOGetByID(){
		person p = personDao.getPersonById(17L);
		assertEquals(p.getId(), 17L);
	}

}
