package com.plix.agendaweb2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plix.agendaweb2.models.Contato;


@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

	
	
}
