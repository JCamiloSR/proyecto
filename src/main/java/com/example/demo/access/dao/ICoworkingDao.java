package com.example.demo.access.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.entity.Coworking;

public interface ICoworkingDao extends CrudRepository<Coworking, Long>{

    // @Query("select c from Coworking c where c.usuario.id = ?1")
	// Coworking[] findByUserId(Long idUser);

    @Query("select c from Coworking c where c.id = ?1")
	Coworking[] findByUserId(Long idCoworking);
}
