package com.formation.cifop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.formation.cifop.model.Client;
import com.formation.cifop.model.Medecin;
import com.formation.cifop.model.Rv;
import com.formation.cifop.service.ClientService;
import com.formation.cifop.service.MedecinService;
import com.formation.cifop.service.RvService;

@RestController
public class RvRest {
	
	@Autowired
	ClientService clientservice;
	
	@Autowired
	MedecinService medservice;
	
	@Autowired
	RvService rdvservice;

	@RequestMapping(value = "/rdvs/add", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView model = new ModelAndView();
		Rv rdv = new Rv();
			
		HashMap<String,String> meds = new HashMap<String, String>();
		List<Medecin> listmed = medservice.getAllMedecins();
		for(int i=0;i<listmed.size();i++){
			Medecin med = listmed.get(i);
			meds.put(""+med.getId(), med.getNom());
		}
		
		model.addObject("meds",meds);
		
		HashMap<String,String> clients = new HashMap<String, String>();
		
		List<Client> listclient = clientservice.getAllClients();
		for(int i=0;i<listclient.size();i++){
			Client c = listclient.get(i);
			clients.put(""+c.getId(), c.getNom());
		}
		model.addObject("clients",clients);
		
		model.addObject("rdvForm", rdv);
		model.setViewName("Rv_Form");
		return (model);

	}

	@RequestMapping(value = "/rdvs/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("rdvForm") Rv rdv) {
		
		Medecin med = medservice.getMedecinById(rdv.getMedecin().getId());
		rdv.setMedecin(med);
		
		Client c = clientservice.getClientById(rdv.getClient().getId());
		rdv.setClient(c);

		rdvservice.saveOrUpdate(rdv);
		return (new ModelAndView("redirect:/rdvs/list"));

	}

	@RequestMapping(value = "/rdvs/confirm", method = RequestMethod.GET)
	public String hello_med() {
		return ("tu es la bienvenue dans l'espace de gestion des endez-vous");
	}

	@RequestMapping(value = "/rdvs/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		List<Rv> listrdvs = rdvservice.getAllRvs();
		model.setViewName("Consulte_Rvs");
		model.addObject("listerdvs", listrdvs);
		return (model);

	}

	@RequestMapping(value = "/rdvs/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		
		HashMap<String,String> meds = new HashMap<String, String>();
		List<Medecin> listmed = medservice.getAllMedecins();
		for(int i=0;i<listmed.size();i++){
			Medecin med = listmed.get(i);
			meds.put(""+med.getId(), med.getNom());
		}
		
		model.addObject("meds",meds);
		
		HashMap<String,String> clients = new HashMap<String, String>();
		
		List<Client> listclient = clientservice.getAllClients();
		for(int i=0;i<listclient.size();i++){
			Client c = listclient.get(i);
			clients.put(""+c.getId(), c.getNom());
		}
		model.addObject("clients",clients);

		Rv rdv = rdvservice.getRvById(id);
		model.addObject("rdvForm", rdv);
		model.setViewName("Rv_Form");

		return model;
	}

	@RequestMapping(value = "/rdvs/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		rdvservice.deleteRv(id);
		return new ModelAndView("redirect:/rdvs/list");
	}

}
