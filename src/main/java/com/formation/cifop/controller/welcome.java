package com.formation.cifop.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.formation.cifop.model.Medecin;
import com.formation.cifop.service.MedecinService;


@RestController
public class welcome {
	
	@Autowired
	MedecinService medservice;
	
	@RequestMapping(value="/medecins/add",method=RequestMethod.GET)
	public ModelAndView hello(){
		ModelAndView model = new ModelAndView();
		Medecin med = new Medecin();
		model.addObject("medecinForm",med);
		model.setViewName("Medecin_Form");
		return(model);
		
	}
	
	@RequestMapping(value="/medecins/save",method= RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("medecinForm") Medecin med){
		
		medservice.saveOrUpdate(med);
		
		return(new ModelAndView("redirect:/medecins/list"));
		
	}
	
	@RequestMapping(value="/medecins/confirm",method=RequestMethod.GET)
	public String hello_med(){
		return("tu es la bienvenue dans l'espace de gestion des médecins ");
	}
	
	@RequestMapping(value="/medecins/list",method= RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView model = new ModelAndView();		
		List<Medecin> listmed = medservice.getAllMedecins();	
		model.setViewName("Consulte_Medecins");
		model.addObject("listemedecins", listmed);
		return(model);
		
	}
	
	 @RequestMapping(value="/medecins/update/{id}", method=RequestMethod.GET)
	 public ModelAndView update(@PathVariable long id) {
	  ModelAndView model = new ModelAndView();
	  
	  Medecin med = medservice.getMedecinById(id);
	  model.addObject("medecinForm", med);
	  model.setViewName("Medecin_Form");
	  
	  return model;
	 }
	 
	 @RequestMapping(value="/medecins/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView delete(@PathVariable("id") long id) {
	  medservice.deleteMedecin(id);
	  
	  return new ModelAndView("redirect:/medecins/list");
	 }

}
