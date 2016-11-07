package it.dragon.controller;

//import java.util.Map;

import it.dragon.Voce;
import it.dragon.dao.VoceDAO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerRegistrazione {

	@RequestMapping(value="/formElencoVoci",method=RequestMethod.GET)
	public ModelAndView chiedePagina(){
		
		ModelAndView model=new ModelAndView("listaVoci.jsp");
		
		return  model;
	}
	
	@RequestMapping(value="/registraVoce.html",method=RequestMethod.POST)
	public ModelAndView RegistraForm(@ModelAttribute("v") Voce voce, BindingResult bind){
		
		
		if(bind.hasErrors()){
		
		
		ModelAndView model=new ModelAndView("errorPage");

	  
		return  model;
		
		}
		VoceDAO vDao = new VoceDAO();
		vDao.createVoce(voce);
		ModelAndView model=new ModelAndView("listaVoci");

		return  model;
		
	}
	
	
@ModelAttribute	
public Model OggettoComune(Model model){
		
	    model.addAttribute("headerMessage", "Alfasoft");
		return  model;
	}

}
