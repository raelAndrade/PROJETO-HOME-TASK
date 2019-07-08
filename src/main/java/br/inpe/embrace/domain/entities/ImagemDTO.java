package br.inpe.embrace.domain.entities;

import java.io.Serializable;

import br.inpe.embrace.resources.entities.Produto;

/**
 * 
 * @author Israel Andrade
 * 
 * Data de criação 7 de jul de 2019
 */

public final class ImagemDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String localizacaoImagem;
	private Produto produto;
	
	private ImagemDTO(Long id, String nome, String localizacaoImagem, Produto produto) {
		super();
		this.id = id;
		this.nome = nome;
		this.localizacaoImagem = localizacaoImagem;
		this.produto = produto;
	}
	
	public static final ImagemDTO of(Long id, String nome, String localizacaoImagem, Produto produto) {
		return new ImagemDTO(id, nome, localizacaoImagem, produto);
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	public String getLocalizacaoImagem() {
		return localizacaoImagem;
	}
	public Produto getProduto() {
		return produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localizacaoImagem == null) ? 0 : localizacaoImagem.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImagemDTO other = (ImagemDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localizacaoImagem == null) {
			if (other.localizacaoImagem != null)
				return false;
		} else if (!localizacaoImagem.equals(other.localizacaoImagem))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ImagemDTO [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", localizacaoImagem=");
		builder.append(localizacaoImagem);
		builder.append(", produto=");
		builder.append(produto);
		builder.append("]");
		return builder.toString();
	}
	
}
