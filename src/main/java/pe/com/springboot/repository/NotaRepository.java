package pe.com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.springboot.domain.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

	@Query("SELECT n FROM Nota n WHERE n.usuario = ?1")
	public List<Nota> findByUser(String usuario);

}
