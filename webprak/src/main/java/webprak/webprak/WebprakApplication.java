package webprak.webprak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import webprak.webprak.DAO.impl.PersonDAOimpl;
import webprak.webprak.DAO.impl.ThemesDAOimpl;
import webprak.webprak.tables.themes;

@SpringBootApplication
public class WebprakApplication {
	public static void main(String[] args) {
		try{
			SpringApplication.run(WebprakApplication.class, args);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
