package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;


public interface IContratService {
	
	
	public List<Contrat> getAllContrats();


	public void deleteContratById(int contId);
	
	public Contrat addOrUpdateCont(Contrat c);
	
	
	

	
}
