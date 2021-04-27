package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {
	private static final Logger logger = LogManager.getLogger(ContratServiceImpl.class);

	@Autowired
	ContratRepository contratRepository;

	public List<Contrat> getAllContrats() {
		logger.info("In  retrieveAllContrats : ");
		List<Contrat> listCont =  contratRepository.findAll();
		logger.info(" all contrat retrieved");
		return listCont;
	}

	@Override

	public Contrat addOrUpdateCont(Contrat c) {
	
		Contrat cont = contratRepository.save(c);
		logger.info(c + "added");
		return cont;
	}

	@Override
	public void deleteContratById(int contId) {
		logger.info("delted contrat id : " + contId);
		contratRepository.deleteById(contId);

	}

}