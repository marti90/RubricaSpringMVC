package it.dragon.controller;

//import java.util.Map;

import it.dragon.Voce;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerRegistrazione {

	
	@RequestMapping(value="/formRegistrazione.html",method=RequestMethod.GET)
	public ModelAndView chidereForm(){
		
		ModelAndView model=new ModelAndView("");
		
		return  model;
	}
	
	

	// prendere tutti parametri in una mappa
	@RequestMapping(value="/registraCliente_2.html",method=RequestMethod.POST)
	public ModelAndView RegistraForm(@ModelAttribute("v") Voce voce,BindingResult bind){
		
		
		if(bind.hasErrors()){
		
		ModelAndView model=new ModelAndView("RegistrazioneModelAttribute/RegistrzaioneFormModelAttribute");

	  
		return  model;
		
		}
		
		ModelAndView model=new ModelAndView("RegistrazioneModelAttribute/HomePageCliente");

		  
		return  model;
		
	}
	
	
@ModelAttribute	
public Model OggettoComune(Model model){
		
		

	    model.addAttribute("headerMessage", "Alfasoft");
		return  model;
	}

}
