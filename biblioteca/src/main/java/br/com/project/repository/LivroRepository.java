package br.com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
