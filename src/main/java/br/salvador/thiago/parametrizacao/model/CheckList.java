package br.salvador.thiago.parametrizacao.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_checkList")
public class CheckList implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String produto;
	@NotNull
	private String nome_documento;
	@NotNull
	private String etapa_jornada_venda;
	@NotNull
	private Boolean obrigatoriedade;
	@NotNull
	private Instant data_urgencia;
	@NotNull
	private Instant data_criacao;
	@NotNull
	private String usuario;
	@NotNull
	private Boolean habilitado;

}
