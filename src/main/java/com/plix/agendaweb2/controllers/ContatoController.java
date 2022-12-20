package com.plix.agendaweb2.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import com.plix.agendaweb2.models.Contato;
import com.plix.agendaweb2.repositories.ContatoRepository;

@Controller
public class ContatoController {
	
	
	@Autowired
	private ContatoRepository contatoRepository;
		
	
	@GetMapping("/contatos")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("contatos/index");
		List<Contato> contatos = contatoRepository.findAll();
		 mv.addObject("contatos", contatos);
		 return mv;

			
		 
	}
	

}
