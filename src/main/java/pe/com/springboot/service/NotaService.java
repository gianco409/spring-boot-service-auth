package pe.com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.springboot.domain.model.Nota;
import pe.com.springboot.repository.NotaRepository;
import pe.com.springboot.util.UtilString;

@Service
public class NotaService {

	@Autowired
	private NotaRepository notaRepository;

	@Autowired
	private UtilString util;

	public List<Nota> list(String header) {
		String username = util.getUsernameFromToken(header);

		return notaRepository.findByUser(username);
	}

	public Nota save(String header, Nota input) {
		String username = util.getUsernameFromToken(header);

		input.setUsuario(username);
		return notaRepository.save(input);
	}

	public List<Nota> list() {
		return notaRepository.findAll();
	}

}
