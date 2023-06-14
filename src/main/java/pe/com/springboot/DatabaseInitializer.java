package pe.com.springboot;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import pe.com.springboot.domain.model.Nota;
import pe.com.springboot.repository.NotaRepository;

@Component
public class DatabaseInitializer implements ApplicationListener<ApplicationReadyEvent> {

	private final List<String> titulos = List.of("Titulo A", "Titulo B", "Titulo C", "Titulo D");
	private final List<String> mensajes = List.of("mensaje 1", "mensaje 2", "mensaje 3", "mensaje 4");
	private final List<String> usuarios = List.of("usergian", "usergian", "usermarco", "usermarco");

	@Autowired
	private NotaRepository notaRepository;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		for (var i = 0; i < titulos.size(); ++i) {
			Nota request = new Nota();
			request.setTitulo(titulos.get(i));
			request.setMensaje(mensajes.get(i));
			request.setUsuario(usuarios.get(i));
			request.setCreatedAt(LocalDateTime.now());

			notaRepository.save(request);
		}
	}

}
