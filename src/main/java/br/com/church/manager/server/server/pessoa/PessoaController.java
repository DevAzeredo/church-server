package br.com.church.manager.server.server.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.createPessoa(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        return pessoaService.getPessoaById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        return ResponseEntity.ok(pessoaService.getAllPessoas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoaDetails) {
        return ResponseEntity.ok(pessoaService.updatePessoa(id, pessoaDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{pessoaId}/addCurso/{cursoId}")
    public ResponseEntity<Pessoa> addCursoToPessoa(@PathVariable Long pessoaId, @PathVariable Long cursoId) {
        return ResponseEntity.ok(pessoaService.addCursoToPessoa(pessoaId, cursoId));
    }

    @PutMapping("/{pessoaId}/removeCurso/{cursoId}")
    public ResponseEntity<Pessoa> removeCursoFromPessoa(@PathVariable Long pessoaId, @PathVariable Long cursoId) {
        return ResponseEntity.ok(pessoaService.removeCursoFromPessoa(pessoaId, cursoId));
    }
}