package br.inpe.embrace.domain;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="TBL_IMAGEM")
public class Imagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_IMAGEM")
	private Long id;
	
	@NotEmpty
	@Column(name="NOME_IMAGEM")
	private String nome;

	@Lob
	@Column(name="IMAGEM_BASE64")
	private byte[] imagemBase64;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PRODUTO_ID")
	private Produto produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getImagemBase64() {
		return imagemBase64;
	}

	public void setImagemBase64(byte[] imagemBase64) {
		this.imagemBase64 = imagemBase64;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Imagem other = (Imagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Imagem [id=" + id + ", nome=" + nome + ", imagemBase64=" + Arrays.toString(imagemBase64) + ", produto="
				+ produto + "]";
	}
	
}