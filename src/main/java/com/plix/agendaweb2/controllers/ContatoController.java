package com.plix.agendaweb2.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.engine.AttributeName;

import com.plix.agendaweb2.dto.RequisicaoNovoContato;

import com.plix.agendaweb2.models.Contato;
import com.plix.agendaweb2.models.StatusContato;
import com.plix.agendaweb2.repositories.ContatoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoRepository contatoRepository;
		
	//listando os dados da base
	@GetMapping("")
	public ModelAndView index() {
		List<Contato> contatos = this.contatoRepository.findAll();
		ModelAndView mv = new ModelAndView("contatos/index");
		mv.addObject("contatos",contatos);
		return mv;
				 
	}
	
	@GetMapping("/new")
	public ModelAndView nnew(RequisicaoNovoContato requisicao) {
		ModelAndView mv = new ModelAndView("contatos/new");
		// criando lista de status como um objeto - statusContato
		mv.addObject("statusContato",StatusContato.values());
		return mv;
		
	}
	
	@PostMapping("")
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
			return new ModelAndView("redirect:/contatos/"+ contato.getId());
		}
		
	}
	
	@GetMapping("/{id}")
	public ModelAndView show(@PathVariable Long id) {
		
		Optional<Contato>optional = this.contatoRepository.findById(id);
		
			if(optional.isPresent()) {	
				Contato contato = optional.get();
				
				ModelAndView mv = new ModelAndView("contatos/show");
				mv.addObject("contato",contato);
				
				return mv;
				
			}else {
				System.out.println("**************************** Não achou ID: " + id + "***************************");
				return new ModelAndView("redirect:/contatos");
			}
		}
	
	@GetMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id, RequisicaoNovoContato requisicao) {
		
		Optional<Contato>optional = this.contatoRepository.findById(id);
		
		if(optional.isPresent()) {	
			Contato contato = optional.get();
			requisicao.fromContato(contato);
			
			ModelAndView mv = new ModelAndView("contatos/edit");
			mv.addObject("contatoId", contato.getId());
			mv.addObject("statusContato",StatusContato.values());
			
			
			return mv;
			
			
		} else {	
			return new ModelAndView("contatos/edit");
		}
		
	}
}


	
	


