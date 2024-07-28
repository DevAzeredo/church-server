package br.com.church.manager.server.server.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query("SELECT p FROM Pessoa p JOIN p.cursos c WHERE c.id = :cursoId")
    List<Pessoa> findPessoasByCursoId(@Param("cursoId") Long id);
    @Query("SELECT p FROM Pessoa p WHERE EXTRACT(MONTH FROM p.dataNascimento) = :mes")
    List<Pessoa> findAniversariantesDoMes(@Param("mes") int mes);
}