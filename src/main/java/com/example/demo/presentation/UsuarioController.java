package com.example.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.domain.entity.Coworking;
import com.example.demo.domain.entity.Usuario;
import com.example.demo.domain.service.ICoworkingService;
import com.example.demo.domain.service.IUsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private ICoworkingService coworkingService;

    Long idLogueado;

    // listar Front Página principal
    @GetMapping({ "/","/Home" })
    public String Home(Model model) {
        model.addAttribute("AllCoworking", coworkingService.getAllCoworking());
        return "Home"; //va hacia el template
    }

    // listar espacios de coworking
    @GetMapping({ "/espaciosCoworking" })
    public String espaciosCoworking(Model model) {
        model.addAttribute("AllCoworking", coworkingService.getAllCoworking());
        return "espaciosCoworking"; //va hacia el template
    }
    //reserva
    @GetMapping({ "/reserva" })
    public String Reserva(Model model) {
        model.addAttribute("AllCoworking", coworkingService.getAllCoworking());
        return "reserva"; //va hacia el template
    }

    // Front Inicio de Sesion
    @GetMapping("/InicioSesion")
    public String oauth(Model model) {
        model.addAttribute("usuarioLogueado", new Usuario());
        return "InicioSesion";
    }
    //procesar usuario y contraseña
    @PostMapping("/iniciarSesion")
    public String iniciarSesion(@ModelAttribute("usuarioLogueado") Usuario user,
            Model model) {
        Usuario usuario = usuarioService.findByUsuario(user.getUsuario(),
                user.getClave());
                String pg = "";
        if (usuario.getId() != 0) {
            idLogueado = usuario.getId();
            model.addAttribute("idUsuario", idLogueado);
            model.addAttribute("usuario", usuario.getUsuario());
            if(usuario.getId() == 1){
                pg = "redirect:/espaciosCoworking";      
            }
            else {
                pg = "redirect:/reserva";
            }   
        }
        else{
            pg = "credenciales_incorrectas";
        }
        return pg;
    }

    // Front Recuperar Contraseña
    @GetMapping("/RecuperarContraseña")
    public String RecuperarContraseña(Model model) {
        Coworking coworking = new Coworking();
        model.addAttribute("coworking", coworking);
        return "RecuperarContraseña";
    }

    // Front Registro Usuario
    @GetMapping("/RegistroUsuario")
    public String RegistroUsuario(Model model) {
        Coworking coworking = new Coworking();
        model.addAttribute("coworking", coworking);
        return "RegistroUsuario";
    }

    // Front Formulario de reserva
    @GetMapping("/FormularioReserva")
    public String FormularioReserva(Model model) {
        Coworking coworking = new Coworking();
        model.addAttribute("coworking", coworking);
        return "FormularioReserva";
    }

    // crear espacio de coworking
    @GetMapping("/crearCoworking")
    public String crearCoworking(Model model) {
        Coworking coworking = new Coworking();
        model.addAttribute("coworking", coworking);
        return "crearCoworking";
    }

    @PostMapping("/guardar")
    public String saveCoworking(@ModelAttribute("coworking") Coworking coworking) {
        coworkingService.saveCoworking(coworking);

        return "redirect:/espaciosCoworking";
    }

    // editar espacio de coworking
    @GetMapping("/editarCoworking/{id}")
    public String actualicarCoworking(@PathVariable Long id, Model model) {
        Coworking coworking = coworkingService.getById(id);
        if (coworking.getId() != 0) {
            model.addAttribute("coworking", coworking);
            return "editarCoworking";
        } else {
            return "editarCoworking";
        }
    }

    @PostMapping("/editar/{id}")
    public String updateCoworking(@PathVariable Long id,
            @ModelAttribute("coworking") Coworking coworking,
            Model model) {

        Coworking coworkingExistente = coworkingService.getById(id);

        coworkingExistente.setId(coworking.getId());
        coworkingExistente.setTitulo(coworking.getTitulo());
        coworkingExistente.setDescripcion(coworking.getDescripcion());

        coworkingService.saveCoworking(coworking);
        return "redirect:/espaciosCoworking";
    }

    //eliminar espacio de coworking
    @PostMapping("eliminar/{id}")
    public String deleteCoworking(@PathVariable Long id, Model model) {
        coworkingService.deleteCoworkingById(id);

        return "redirect:/espaciosCoworking";
    }

}