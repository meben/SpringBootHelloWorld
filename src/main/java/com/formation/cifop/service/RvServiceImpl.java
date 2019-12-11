package com.formation.cifop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.cifop.model.Rv;
import com.formation.cifop.repository.RvRepository;

@Service
@Transactional

public class RvServiceImpl implements RvService {
	
	@Autowired
	RvRepository rdvrepo;
	@Override
	public List<Rv> getAllRvs() {
		// TODO Auto-generated method stub
		return (List<Rv>) rdvrepo.findAll() ;
	}

	@Override
	public Rv getRvById(long id) {
		// TODO Auto-generated method stub
		return rdvrepo.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Rv rdv) {
		// TODO Auto-generated method stub
		
		rdvrepo.save(rdv);
		
	}

	@Override
	public void deleteRv(long id) {
		// TODO Auto-generated method stub
		rdvrepo.deleteById(id);
		
	}

}
