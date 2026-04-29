package pio.daw.usuarios.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pio.daw.usuarios.model.Articulo;
import pio.daw.usuarios.model.Usuario;
import pio.daw.usuarios.repository.ArticuloRepositorio;
import pio.daw.usuarios.repository.UsuarioRepositorio;

@Controller
public class ControladorPrincipal {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ArticuloRepositorio articuloRepositorio;

    // ─── Página principal ───────────────────────────────────────────────────────

    @GetMapping("/inicio")
    public String iniPg() {
        return "index";
    }

    // ─── Listado de usuarios ─────────────────────────────────────────────────────

    @GetMapping(path = "/listadousuarios")
    public String getListaUsuarios(Model modelo) {
        Iterable<Usuario> itUsuario = usuarioRepositorio.findAll();
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        itUsuario.forEach(listaUsuarios::add);
        modelo.addAttribute("listaUsuarios", listaUsuarios);
        return "listadousuarios";
    }

    // ─── Listado de artículos ────────────────────────────────────────────────────

    @GetMapping(path = "/listadoarticulos")
    public String getListaArticulos(Model modelo) {
        Iterable<Articulo> itArticulo = articuloRepositorio.findAll();
        List<Articulo> listaArticulos = new ArrayList<Articulo>();
        itArticulo.forEach(listaArticulos::add);
        modelo.addAttribute("listaArticulos", listaArticulos);
        return "listadoarticulos";
    }

    // ─── Alta de usuario ─────────────────────────────────────────────────────────

    /**
     * Muestra el formulario vacío para dar de alta un nuevo usuario.
     */
    @GetMapping(path = "/altausuario")
    public String mostrarFormAltaUsuario(Model modelo) {
        // Pasamos un objeto Usuario vacío al modelo para que Thymeleaf lo vincule
        modelo.addAttribute("usuario", new Usuario());
        return "altausuario";
    }

    /**
     * Recibe los datos del formulario, guarda el nuevo usuario y redirige
     * al listado de usuarios mostrando el registro recién creado.
     */
    @PostMapping(path = "/altausuario")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioRepositorio.save(usuario);
        return "redirect:/listadousuarios";
    }

    // ─── Alta de artículo ────────────────────────────────────────────────────────

    /**
     * Muestra el formulario vacío para dar de alta un nuevo artículo.
     */
    @GetMapping(path = "/altaarticulo")
    public String mostrarFormAltaArticulo(Model modelo) {
        modelo.addAttribute("articulo", new Articulo());
        return "altaarticulo";
    }

    /**
     * Recibe los datos del formulario, guarda el nuevo artículo y redirige
     * al listado de artículos.
     */
    @PostMapping(path = "/altaarticulo")
    public String guardarArticulo(@ModelAttribute("articulo") Articulo articulo) {
        articuloRepositorio.save(articulo);
        return "redirect:/listadoarticulos";
    }
}
