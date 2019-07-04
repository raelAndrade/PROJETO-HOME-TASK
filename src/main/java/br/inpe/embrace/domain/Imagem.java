package br.inpe.embrace.domain;

import java.io.Serializable;

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
	
}