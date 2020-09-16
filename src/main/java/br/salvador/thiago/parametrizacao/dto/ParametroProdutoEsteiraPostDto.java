package br.salvador.thiago.parametrizacao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ParametroProdutoEsteiraPostDto {

    @NotNull
    private Integer codigoProdutoOperacional;

    @NotNull
    private Integer codigoMobilidade;

    @NotNull
    @Length(min = 1, max = 1)
    private String indicadorHabilitado;

    @NotNull
    @Length(min = 1, max = 1)
    private String indicadorValidaRegraNegocio;

    @NotNull
    @Length(min = 1, max = 1)
    private String indicadorLastoLCA;

    @NotNull
    @Length(min = 1, max = 1)
    private String indicadorPlanoPagamentoPersonalizado;

    @NotNull
    private Integer quantidadeMaximaParcela;

    @NotNull
    private Integer quantidadePrazoValidade;

    @NotNull
    private LocalDateTime dataInicioVigencia;

    @NotNull
    private LocalDateTime dataFimVigencia;

    @NotNull
    private Integer codigoUsuarioInclusao;

    @NotNull
    private Integer codigoUsuarioAlteracao;
}
