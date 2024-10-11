package br.com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.domain.Livro;
import br.com.project.repository.LivroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping
	public List<Livro> listar() {
		return livroRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id) {
		Optional<Livro> livroOpt = livroRepository.findById(id);
		if (livroOpt.isPresent()) {
			return ResponseEntity.ok(livroOpt.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro inserir(@Valid @RequestBody Livro livro) {
		return livroRepository.save(livro);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizar(@PathVariable Long id, @Valid @RequestBody Livro livro) {

		if (livroRepository.existsById(id)) {
			livro.setId(id);
			livroRepository.save(livro);
			return ResponseEntity.ok(livro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (livroRepository.existsById(id)) {
			livroRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
