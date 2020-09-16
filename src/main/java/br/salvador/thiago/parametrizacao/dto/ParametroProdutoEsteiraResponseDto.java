package br.salvador.thiago.parametrizacao.dto;

import br.salvador.thiago.parametrizacao.model.ParametroProdutoEsteira;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ParametroProdutoEsteiraResponseDto {

    private Integer idParametroRegraEsteira;

    private Integer codigoProdutoOperacional;

    private Integer codigoMobilidade;

    private String indicadorHabilitado;

    private String indicadorValidaRegraNegocio;

    private String indicadorLastoLCA;

    private String indicadorPlanoPagamentoPersonalizado;

    private Integer quantidadeMaximaParcela;

    private Integer quantidadePrazoValidade;

    private LocalDateTime dataInicioVigencia;

    private LocalDateTime dataFimVigencia;

    private Integer codigoUsuarioInclusao;

    private Integer codigoUsuarioAlteracao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    public ParametroProdutoEsteiraResponseDto(ParametroProdutoEsteira parametroProdutoEsteira) {
        this.idParametroRegraEsteira = parametroProdutoEsteira.getIdParametroRegraEsteira();
        this.codigoProdutoOperacional = parametroProdutoEsteira.getCodigoProdutoOperacional();
        this.codigoMobilidade = parametroProdutoEsteira.getCodigoMobilidade();
        this.indicadorHabilitado = parametroProdutoEsteira.getIndicadorHabilitado();
        this.indicadorValidaRegraNegocio = parametroProdutoEsteira.getIndicadorValidaRegraNegocio();
        this.indicadorLastoLCA = parametroProdutoEsteira.getIndicadorLastoLCA();
        this.indicadorPlanoPagamentoPersonalizado = parametroProdutoEsteira.getIndicadorPlanoPagamentoPersonalizado();
        this.quantidadeMaximaParcela = parametroProdutoEsteira.getQuantidadeMaximaParcela();
        this.quantidadePrazoValidade = parametroProdutoEsteira.getQuantidadePrazoValidade();
        this.dataInicioVigencia = parametroProdutoEsteira.getDataInicioVigencia();
        this.dataFimVigencia = parametroProdutoEsteira.getDataFimVigencia();
        this.codigoUsuarioInclusao = parametroProdutoEsteira.getCodigoUsuarioInclusao();
        this.codigoUsuarioAlteracao = parametroProdutoEsteira.getCodigoUsuarioAlteracao();
        this.dataCriacao = parametroProdutoEsteira.getDataCriacao();
        this.dataAtualizacao = parametroProdutoEsteira.getDataAtualizacao();
    }
}
