package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.access.dao.ICoworkingDao;
import com.example.demo.access.dao.IReservaDao;
import com.example.demo.domain.entity.Coworking;
import com.example.demo.domain.entity.Reserva;

@Service
public class CoworkingService implements ICoworkingService{

    @Autowired
	private ICoworkingDao coworkingDao;
    @Autowired
	private IReservaDao reservaDao;

    @Override
    public Coworking[] getCoworkingByUser(Long id) {
        return coworkingDao.findByUserId(id);
    }

    // @Override
    // public Coworking getCoworkingById(Long id) {
    //     return coworkingDao.getCoworkingById(id);
    // }
    //listar todos los espacios de coworking
    @Override
    public Iterable<Coworking> getAllCoworking() {
        return coworkingDao.findAll();
    }
    //lista de coworking por id
    @Override
    public Coworking getById(Long id){
        Coworking coworking = coworkingDao.findById(id).orElse(null);
		if (coworking == null) {
			return new Coworking(0L, "", "","");
		}
		return coworking;
    }
    
    @Override
    public Coworking saveCoworkingById(Coworking coworking){
        return coworkingDao.save(coworking);
    }
    //crear coworking
    @Override
    public Coworking saveCoworking(Coworking coworking){
        return coworkingDao.save(coworking);
    }
    //eliminar coworking
    @Override
    public void deleteCoworkingById(Long id){
        coworkingDao.deleteById(id);
    }
    //actualizar coworking
    @Override
    public Coworking updateCoworking(Coworking coworking){
        return coworkingDao.save(coworking);
    }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

    //listar todos las reservas de coworking
    @Override
    public Iterable<Reserva> getAllReservas() {
        return reservaDao.findAll();
    }
    //listar reservas por id
    @Override
    public Reserva getByIdReserva(Long id){
        Reserva reserva = reservaDao.findById(id).orElse(null);
		if (reserva == null) {
			return new Reserva(0L, "", "","","","","","","");
		}
		return reserva;
    }
    //crear reserva
    @Override
    public Reserva saveReserva(Reserva reserva){
        return reservaDao.save(reserva);
    }
    //eliminar reserva
    @Override
    public void deleteReservaById(Long id){
        reservaDao.deleteById(id);
    }
    //actualizar reserva
    @Override
    public Reserva updateReserva(Reserva reserva){
        return reservaDao.save(reserva);
    }
}