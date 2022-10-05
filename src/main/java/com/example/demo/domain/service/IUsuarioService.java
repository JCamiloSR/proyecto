package com.example.demo.domain.service;

//import com.example.demo.domain.entity.Rol;
import com.example.demo.domain.entity.Usuario;

public interface IUsuarioService {
    public Usuario findByUsuario(String user, String password);
	
	public Usuario findById(Long id);

}
