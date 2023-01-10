package com.plix.agendaweb2.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.plix.agendaweb2.dto.RequisicaoNovoContato;
import com.plix.agendaweb2.models.Contato;
import com.plix.agendaweb2.models.StatusContato;
import com.plix.agendaweb2.repositories.ContatoRepository;

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
	
	
	@GetMapping("/contato/new")
	public ModelAndView nnew() {
		ModelAndView mv = new ModelAndView("contatos/new");
		// criando lista de status como um objeto - statusContato
		mv.addObject("statusContato",StatusContato.values());
		return mv;
		
	}
	//salvando os dados na base
	@PostMapping("/contatos")
	public String create(RequisicaoNovoContato requisicao ) {
		Contato contato = requisicao.toContato() ;
		this.contatoRepository.save(contato);
		return "redirect:/contatos";
	}
	
	/*public String create(Contato contato) {
	System.out.println("******************************");
	System.out.println(contato);
	this.contatoRepository.save(contato);*/
	

	
	
	

}
