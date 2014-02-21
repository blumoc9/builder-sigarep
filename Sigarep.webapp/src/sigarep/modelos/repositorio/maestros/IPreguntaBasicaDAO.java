package sigarep.modelos.repositorio.maestros;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sigarep.modelos.data.maestros.PreguntaBasica;

public interface IPreguntaBasicaDAO extends
		JpaRepository<PreguntaBasica, Integer> {

	/**
	 * Busca las todas las preguntas b�sicas que poseen estatus == true
	 * @return List<PreguntaBasica> Lista de preguntas basicas con estatus == true
	 */
	public List<PreguntaBasica> findByEstatusTrue();
	
	/**
	 * Busca el ultimo id insertado en la tabla PreguntaBasica
	 * @return Ultimo id insertado en la tabla PreguntaBasica
	 */
	@Query("SELECT COALESCE(MAX(pb.idPreguntaBasica),0) FROM PreguntaBasica AS pb")
	public int buscarUltimoID();
}