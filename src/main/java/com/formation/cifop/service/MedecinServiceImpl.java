package com.formation.cifop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.cifop.model.Medecin;
import com.formation.cifop.repository.MedecinRepository;

@Service
@Transactional

public class MedecinServiceImpl implements MedecinService{
	
	
	@Autowired	
	MedecinRepository medrepo;

	@Override
	public List<Medecin> getAllMedecins() {
		// TODO Auto-generated method stub
		return (List<Medecin>) medrepo.findAll();
	}

	@Override
	public Medecin getMedecinById(long id) {
		// TODO Auto-generated method stub
		return medrepo.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Medecin med) {
		// TODO Auto-generated method stub
		medrepo.save(med);
	}

	@Override
	public void deleteMedecin(long id) {
		// TODO Auto-generated method stub
		medrepo.deleteById(id);
		
	}

}
