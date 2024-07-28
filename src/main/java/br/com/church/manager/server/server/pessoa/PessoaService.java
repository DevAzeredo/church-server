package br.com.church.manager.server.server.pessoa;


import br.com.church.manager.server.server.curso.Curso;
import br.com.church.manager.server.server.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Pessoa createPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


    public Optional<Pessoa> getPessoaById(Long id) {
        return pessoaRepository.findById(id);
    }
    public List<Pessoa> getAniversariantesDoMes(int mes) {
        return pessoaRepository.findAniversariantesDoMes(mes);
    }

    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa updatePessoa(Long id, Pessoa pessoaDetails) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa not found"));
        pessoa.setNome(pessoaDetails.getNome());
        return pessoaRepository.save(pessoa);
    }

    public void deletePessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    public List<Pessoa> getPessoasByCursoId(Long id) {
        return pessoaRepository.findPessoasByCursoId(id);
    }

    public Pessoa addCursoToPessoa(Long pessoaId, Long cursoId) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).orElseThrow(() -> new RuntimeException("Pessoa not found"));
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso not found"));
        pessoa.getCursos().add(curso);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa removeCursoFromPessoa(Long pessoaId, Long cursoId) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).orElseThrow(() -> new RuntimeException("Pessoa not found"));
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso not found"));
        pessoa.getCursos().remove(curso);
        return pessoaRepository.save(pessoa);
    }
}
