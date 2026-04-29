package pio.daw.usuarios.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import pio.daw.usuarios.model.Articulo;

@Repository
public interface ArticuloRepositorio extends JpaRepository<Articulo, Integer> {
}
