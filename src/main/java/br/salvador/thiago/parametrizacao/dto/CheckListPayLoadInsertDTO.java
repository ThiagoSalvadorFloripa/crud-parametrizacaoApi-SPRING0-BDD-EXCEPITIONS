package br.salvador.thiago.parametrizacao.dto;

import java.time.Instant;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckListPayLoadInsertDTO {

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

}
