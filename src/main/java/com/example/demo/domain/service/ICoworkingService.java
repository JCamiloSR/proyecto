package com.example.demo.domain.service;

import com.example.demo.domain.entity.Coworking;
import com.example.demo.domain.entity.Reserva;

public interface ICoworkingService {

    public Coworking[] getCoworkingByUser(Long id);
    public Iterable<Coworking>getAllCoworking();
    public Coworking getById(Long id);
    public Coworking saveCoworkingById(Coworking coworking);
    public Coworking saveCoworking(Coworking coworking);
    public void deleteCoworkingById(Long id);
    public Coworking updateCoworking(Coworking coworking);

    public Iterable<Reserva>getAllReservas();
    public Reserva getByIdReserva(Long id);
    public Reserva saveReserva(Reserva reserva);
    public void deleteReservaById(Long id);
    public Reserva updateReserva(Reserva coworking);
    
}
