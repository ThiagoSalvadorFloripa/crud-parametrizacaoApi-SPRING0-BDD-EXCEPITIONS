package br.salvador.thiago.parametrizacao.dto;

import java.io.Serializable;
import java.time.Instant;

import com.sun.istack.NotNull;

import br.salvador.thiago.parametrizacao.model.CheckList;
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
public class CheckListDTO implements Serializable {

	private static final long serialVersionUID = 1L;

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

	public CheckListDTO(CheckList model) {
		id = model.getId();
		produto = model.getProduto();
		nome_documento = model.getNome_documento();
		etapa_jornada_venda = model.getEtapa_jornada_venda();
		obrigatoriedade = model.getObrigatoriedade();
		data_urgencia = model.getData_urgencia();
		usuario = model.getUsuario();
		habilitado = model.getHabilitado();

	}

}
