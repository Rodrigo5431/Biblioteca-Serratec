package br.com.project.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Publicacao {

	@NotBlank(message = "Preencha o Autor")
	@Column(nullable = false)
	private String autor;

	@Column(nullable = false)
	private LocalDate dataPublicacao;

	@NotBlank(message = "Preencha a editora")
	@Column(nullable = false)
	private String editora;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

}
