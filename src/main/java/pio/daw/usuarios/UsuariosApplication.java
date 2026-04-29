package pio.daw.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pio.daw.usuarios.model.Articulo;
import pio.daw.usuarios.model.Usuario;
import pio.daw.usuarios.repository.ArticuloRepositorio;
import pio.daw.usuarios.repository.UsuarioRepositorio;

@SpringBootApplication
public class UsuariosApplication implements CommandLineRunner {
	@Autowired
	UsuarioRepositorio usuRepository;
	
	@Autowired
	ArticuloRepositorio articuloRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Insertar nuevos usuarios
		usuRepository.save(new Usuario("Ana Pérez", "ana.perez@ejemplo.com"));
		usuRepository.save(new Usuario("Carlos López", "carlos.lopez@dominio.net"));
		usuRepository.save(new Usuario("Sofía Gómez", "sofia_gomez123@mail.org"));
		usuRepository.save(new Usuario("Javier Vargas", "javierv@mi-correo.es"));
		usuRepository.save(new Usuario("Martina Ruiz", "martina.r@servidor.com"));
		usuRepository.save(new Usuario("Pablo Torres", "pablo.t@email.co"));
		usuRepository.save(new Usuario("Lucía Sánchez", "lucia.sanchez@provider.info"));
		usuRepository.save(new Usuario("Daniel Flores", "daniel_f@otro-mail.com"));
		usuRepository.save(new Usuario("Elena Díaz", "elena.d@correo-rapido.net"));
		usuRepository.save(new Usuario("Hugo Castro", "hugo.castro88@mi-conexion.com"));
		
		// Insertar nuevos artículos
		articuloRepository.save(new Articulo("Libro de Aventuras", "Una emocionante historia llena de misterio y acción."));
        articuloRepository.save(new Articulo("Taza de Cerámica", "Taza hecha a mano con diseño único y resistente al calor."));
        articuloRepository.save(new Articulo("Bolígrafo Retráctil", "Bolígrafo de tinta negra con mecanismo suave y agarre cómodo."));
        articuloRepository.save(new Articulo("Cuaderno de Espiral", "Cuaderno de 100 hojas de papel rayado de alta calidad."));
        articuloRepository.save(new Articulo("Lámpara de Escritorio LED", "Lámpara con luz LED ajustable y bajo consumo energético."));
        articuloRepository.save(new Articulo("Planta Suculenta Pequeña", "Pequeña planta suculenta fácil de cuidar, ideal para decoración."));
        articuloRepository.save(new Articulo("Juego de Mesa Familiar", "Juego de mesa divertido para disfrutar con amigos y familiares."));
        articuloRepository.save(new Articulo("Auriculares Inalámbricos", "Auriculares Bluetooth con sonido de alta fidelidad y cancelación de ruido."));
        articuloRepository.save(new Articulo("Mochila Urbana", "Mochila resistente y con múltiples compartimentos para el día a día."));
        articuloRepository.save(new Articulo("Vela Aromática", "Vela perfumada con aceites esenciales para crear un ambiente relajante."));		
	}

}
