package br.salvador.thiago.parametrizacao.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class ParametroProdutoEsteiraPayloadDto {


    @NotNull
    private Integer codigoProdutoOperacional;

    @NotNull
    private Integer codigoMobilidade;

    @NotNull
    private char indicadorHabilitado;

    @NotNull
    private char indicadorValidaRegraNegocio;

    @NotNull
    private char indicadorLastoLCA;

    @NotNull
    private char indicadorPlanoPagamentoPersonalizado;

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
