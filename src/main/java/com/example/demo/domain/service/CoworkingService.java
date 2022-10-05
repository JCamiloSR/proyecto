package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.access.dao.ICoworkingDao;
import com.example.demo.domain.entity.Coworking;

@Service
public class CoworkingService implements ICoworkingService{

    @Autowired
	private ICoworkingDao coworkingDao;

    @Override
    public Coworking[] getCoworkingByUser(Long id) {
        return coworkingDao.findByUserId(id);
    }

    // @Override
    // public Coworking getCoworkingById(Long id) {
    //     return coworkingDao.getCoworkingById(id);
    // }

    @Override
    public Iterable<Coworking> getAllCoworking() {
        return coworkingDao.findAll();
    }

    @Override
    public Coworking getById(Long id){
        Coworking coworking = coworkingDao.findById(id).orElse(null);
		if (coworking == null) {
			return new Coworking(0L, "", "","");
		}
		return coworking;
    }
    //crear
    @Override
    public Coworking saveCoworkingById(Coworking coworking){
        return coworkingDao.save(coworking);
    }

    @Override
    public Coworking saveCoworking(Coworking coworking){
        return coworkingDao.save(coworking);
    }
    //eliminar
    @Override
    public void deleteCoworkingById(Long id){
        coworkingDao.deleteById(id);
    }
    //actualizar
    @Override
    public Coworking updateCoworking(Coworking coworking){
        return coworkingDao.save(coworking);
    }

}