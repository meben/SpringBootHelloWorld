package com.formation.cifop.service;

import java.util.List;

import com.formation.cifop.model.Rv;

public interface RvService {
	
	public List<Rv> getAllRvs();
	 
	 public Rv getRvById(long id);
	  
	 public void saveOrUpdate(Rv rdv);
	 
	 public void deleteRv(long id);

}
