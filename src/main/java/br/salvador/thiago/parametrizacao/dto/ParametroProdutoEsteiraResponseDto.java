package br.salvador.thiago.parametrizacao.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class ParametroProdutoEsteiraResponseDto {

    private Integer idParametroRegraEsteira;

    private Integer codigoProdutoOperacional;

    private Integer codigoMobilidade;

    private char indicadorHabilitado;

    private char indicadorValidaRegraNegocio;

    private char indicadorLastoLCA;

    private char indicadorPlanoPagamentoPersonalizado;

    private Integer quantidadeMaximaParcela;

    private Integer quantidadePrazoValidade;

    private LocalDateTime dataInicioVigencia;

    private LocalDateTime dataFimVigencia;

    private Integer codigoUsuarioInclusao;

    private Integer codigoUsuarioAlteracao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
