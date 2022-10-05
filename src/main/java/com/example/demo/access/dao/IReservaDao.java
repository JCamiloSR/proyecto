package com.example.demo.access.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.entity.Reserva;

public interface IReservaDao extends CrudRepository<Reserva, Long> {

    @Query("select c from Reserva c where c.id = ?1")
	Reserva[] findByUserId(Long idReserva);
    
}
