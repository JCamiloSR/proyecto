package com.example.demo.domain.service;

import com.example.demo.domain.entity.Coworking;

public interface ICoworkingService {

    public Coworking[] getCoworkingByUser(Long id);
    public Iterable<Coworking>getAllCoworking();
    public Coworking getById(Long id);
    public Coworking saveCoworkingById(Coworking coworking);
    public Coworking saveCoworking(Coworking coworking);
    public void deleteCoworkingById(Long id);
    public Coworking updateCoworking(Coworking coworking);
    
}
