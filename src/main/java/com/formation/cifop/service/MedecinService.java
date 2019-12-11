package com.formation.cifop.service;

import java.util.List;

import com.formation.cifop.model.Medecin;


public interface MedecinService {
	
	 public List<Medecin> getAllMedecins();
	 
	 public Medecin getMedecinById(long id);
	  
	 public void saveOrUpdate(Medecin med);
	 
	 public void deleteMedecin(long id);

}
