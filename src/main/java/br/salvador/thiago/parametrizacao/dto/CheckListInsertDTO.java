package br.salvador.thiago.parametrizacao.dto;

import java.time.Instant;

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
public class CheckListInsertDTO {

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
