package br.inpe.embrace.resources.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Israel Andrade
 * 
 * Data de criação 7 de jul de 2019
 */

@Entity
@Table(name="TBL_IMAGEM")
public final class Imagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_IMAGEM")
	private Long id;
	
	@NotEmpty
	@NotNull
	@Column(name="NOME_IMAGEM")
	private String nome;

	@NotEmpty
	@NotNull
	@Column(name="LOCALIZACAO_IMAGEM")
	private String localizacaoImagem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_PRODUTO")
	private Produto produto;

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
	
	public Imagem() {
		super();
	}
	
	private Imagem(final Long id, @NotEmpty @NotNull final String nome, @NotEmpty @NotNull final String localizacaoImagem, final Produto produto) {
		super();
		this.id = id;
		this.nome = nome;
		this.localizacaoImagem = localizacaoImagem;
		this.produto = produto;
	}

	public static final Imagem of(final Long id, @NotEmpty @NotNull final String nome, @NotEmpty @NotNull final String localizacaoImagem, final Produto produto) {
		return new Imagem(id, nome, localizacaoImagem, produto);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, localizacaoImagem, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imagem other = (Imagem) obj;
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
		builder.append("Imagem [id=");
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