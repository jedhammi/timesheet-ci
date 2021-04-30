package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {
	
	@Autowired 
	IContratService conts;
	
	@Test
	public void testAddOrUpdateCont() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-09-11");
		String typeContrat="cdd";
		float salaire=14;
		Contrat c = new Contrat(d,typeContrat,salaire); 
		Contrat addCont = conts.addOrUpdateCont(c);
		
	    assertEquals(c.getTypeContrat(),addCont.getTypeContrat());	
		}
	@Test
	public void testDeleteContratById() throws Exception  {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-02-09");
		String typeContrat="cdi";
		float salaire=13;
		Contrat c = new Contrat(d,typeContrat,salaire); 

		conts.addOrUpdateCont(c);
	    assertNotNull(c);
	    conts.deleteContratById(c.getReference());
	    		
	}
	
	@Test

	public void testGetAllContrats() {
		
		Assertions.assertFalse(conts.getAllContrats().isEmpty());

		
	}
	

}
