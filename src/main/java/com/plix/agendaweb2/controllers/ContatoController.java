package com.plix.agendaweb2.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.plix.agendaweb2.dto.RequisicaoNovoContato;
import com.plix.agendaweb2.models.Contato;
import com.plix.agendaweb2.models.StatusContato;
import com.plix.agendaweb2.repositories.ContatoRepository;

import jakarta.validation.Valid;

@Controller
public class ContatoController {
	
	@Autowired
	private ContatoRepository contatoRepository;
		
	//listando os dados da base
	@GetMapping("/contatos")
	public ModelAndView index() {
		List<Contato> contatos = this.contatoRepository.findAll();
		ModelAndView mv = new ModelAndView("contatos/index");
		mv.addObject("contatos",contatos);
		return mv;
				 
	}
	
	@GetMapping("/contatos/new")
	public ModelAndView nnew(RequisicaoNovoContato requisicao) {
		ModelAndView mv = new ModelAndView("contatos/new");
		// criando lista de status como um objeto - statusContato
		mv.addObject("statusContato",StatusContato.values());
		return mv;
		
	}
	
	@PostMapping("/contatos")
	public ModelAndView create(@Valid RequisicaoNovoContato requisicao, BindingResult result ) {
		//System.out.println(requisicao);
		if (result.hasErrors()) {
			System.out.println("*******************Erro********************");
			ModelAndView mv = new ModelAndView("contatos/new");
			mv.addObject("statusContato",StatusContato.values());
            return mv;
		}
		else {
		
			Contato contato = requisicao.toContato() ;
			this.contatoRepository.save(contato);
			return new ModelAndView("redirect:/contatos");
		}
		
	}
	
	
}
	/*public String create(Contato contato) {
	System.out.println("******************************");
	System.out.println(contato);
	this.contatoRepository.save(contato);*/
	


