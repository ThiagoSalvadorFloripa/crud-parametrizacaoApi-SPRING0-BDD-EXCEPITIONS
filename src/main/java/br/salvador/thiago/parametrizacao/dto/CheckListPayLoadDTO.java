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
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckListPayLoadDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotNull @NotBlank
	private String produto;
	@NotNull @NotBlank
	private String nome_documento;
	@NotNull @NotBlank
	private String etapa_jornada_venda;
	@NotNull @NotBlank
	private Boolean obrigatoriedade;
	@NotNull @NotBlank
	private Instant data_urgencia;
	@NotNull @NotBlank
	private Instant data_criacao;
	@NotNull @NotBlank
	private String usuario;
	@NotNull @NotBlank
	private Boolean habilitado;

	public CheckListPayLoadDTO(CheckList model) {
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
