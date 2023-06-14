package pe.com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import pe.com.springboot.domain.model.Nota;
import pe.com.springboot.service.NotaService;

@Tag(name = "Nota API", description = "Api de gestion de Notas")
@RestController
@RequestMapping(path = "api/nota")
public class NotaController {

	@Autowired
	private NotaService notaService;

	@PostMapping
	public ResponseEntity<Nota> post(@RequestHeader(name = "Authorization") String header, @RequestBody Nota input) {

		Nota save = notaService.save(header, input);
		return new ResponseEntity<>(save, HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<Nota>> listByUSer(@RequestHeader(name = "Authorization") String header) {
		List<Nota> find = notaService.list(header);

		if (find == null || find.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(find);
	}
}
