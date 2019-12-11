package com.formation.cifop.service;

import java.util.List;

import com.formation.cifop.model.Client;

public interface ClientService {
	
		 public List<Client> getAllClients();
		 
		 public Client getClientById(long id);
		  
		 public void saveOrUpdate(Client client);
		 
		 public void deleteClient(long id);

}
